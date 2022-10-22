import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main
{
    public static void main(String[] args) {

        System.out.println("Создаём карты___________________________________________________");      //создаём карты
        Card_raz cardP3= new Card_raz("6346", "Поразовая", "674", "0", "-");
        Card_F cardF1= new Card_F("3242", "Школьная", "678","-");
        Card_raz cardP2= new Card_raz("2343", "Поразовая", "34", "7", "-");
        Card_F cardF2= new Card_F("546", "Студенческая", "3453", "2022-10-10");
        Card_F cardF3= new Card_F("8797", "Социальная", "3455", "2022-11-20 ");
        Card_raz cardP1= new Card_raz("34325", "Поразовая", "670", "20", "-");


        System.out.println("________________________________________________________________");
        System.out.println();

        String[] nomeraFix={"12200234","12200987","12200657"};    //карты с фиксированной оплатой
        String[] nomeraraz={"12200582","12200789","12200341"};   ///карты с поразовой оплатой
        ArrayList<Card_F> listFix = new ArrayList<>();    //карты с фиксированной оплатой
        listFix.add(cardF1);
        listFix.add(cardF2);
        listFix.add(cardF3);
        ArrayList<Card_raz> listraz = new ArrayList<>();   //карты с поразовой оплатой
        listraz.add(cardP1);
        listraz.add(cardP2);
        listraz.add(cardP3);

        Bankomat _Bankomat_= new Bankomat();       //создаём банкомат
        Mobilnoe_prilozenie Mob_priloz = new Mobilnoe_prilozenie();    //создаём приложение
        Terminal _Terminal_= new Terminal();     // создаём терминал

        System.out.println("Введите номер карты");
        Scanner in = new Scanner(System.in);
        String nomer_carti = in.nextLine();    //вводим номер нашей карты

        int j=-1;
        int n=nomeraFix.length;
        int m=nomeraraz.length;
        for(int i=0 ; i < (n + m); i++){     //определяем карту по номеру
            if (i<n){
                if (nomer_carti.equalsIgnoreCase(nomeraFix[i])){
                    j=i;
                }
            }
            else{
                if (nomer_carti.equalsIgnoreCase(nomeraraz[i-n])){
                    j=i;
                }
            }
        }
        if (j>-1) {
            if (j < n) {
                Card_F carta0 = listFix.get(j);   //получаем карту
                System.out.println("Ваша карта:" + carta0.bankomat());
                System.out.println();
                carta0.oplata();        //оплата проезда
                _Terminal_.proverka_oplati(carta0.bankomat());   //проверка оплаты
                System.out.println();
                System.out.println("Пополнение через банкомат");
                _Bankomat_.popolnenieF(carta0.bankomat(), carta0);
                System.out.println();
                System.out.println("Пополнение через мобильное приложение");
                Mob_priloz.popolnenieF(carta0.bankomat(), carta0);
            } else {
                Card_raz carta0 = listraz.get(j - n);     //получаем карту
                System.out.println("Ваша карта:" + carta0.bankomat());
                System.out.println();
                carta0.oplata();         //оплата
                _Terminal_.proverka_oplati(carta0.bankomat());    //проверка оплаты
                System.out.println();
                System.out.println("Пополнение через банкомат");
                _Bankomat_.popolnenieP(carta0.bankomat(), carta0);
                System.out.println();
                System.out.println("Пополнение через мобильное приложение");
                Mob_priloz.popolnenieP(carta0.bankomat(), carta0);
            }
        }
        System.out.println();
        _Terminal_.statistika();
    }
}

class Card_F {      //карта с фиксированной оплатой
    public String[] carta;

    public Card_F(String nomer, String tip_carti, String schet, String date) {
        carta = new String[4];     //создаём карту
        carta[0] = nomer;
        carta[1] = tip_carti;
        carta[2] = schet;
        carta[3] = date;
        for (String i : carta) {        //выводим карту
            System.out.print(i +' ');
        }
        System.out.println();
    }

    public String bankomat(){      //банкомат и мобильное приложение - строка состаяния карты
        String s= carta[0]+' '+carta[1]+' '+carta[2]+' '+carta[3];
        return s;
    }

    public Card_F oplata(){         //оплата поездок на месяц
        String tip_carti = carta[1];
        String s = new String();
        Integer schet = Integer.valueOf(carta[2]);      //счёт карты
        LocalDate date = LocalDate.now();      //получаем дату
        carta[3] = s.valueOf(date.plusMonths(1));    //добавляем месяц
        if (tip_carti == "Студенческая") {
            schet -= 405;      //списание денег
            carta[2] = s.valueOf(schet);
            System.out.println("Оплата 405р.");
        }
        else {
            if (tip_carti == "Школьная") {
                schet -= 100;        //списание денег
                carta[2] = s.valueOf(schet);
                System.out.println("Оплата 100р.");
            }
            else {
                if (tip_carti == "Социальная") {
                    schet -= 415;        //списание денег
                    carta[2] = s.valueOf(schet);
                    System.out.println("Оплата 415р.");
                }
            }
        }
        for (String i : carta) {
            System.out.print(i+' ');
        }
        System.out.println();
        return this;
    }
}



class Card_raz {           //карта с поразовой оплатой
    public String[] carta;
    public Card_raz(String nomer, String tip_carti, String schet, String shtuchnie, String deystvie) {
        carta = new String[5];           //создаём карту
        carta[0] = nomer;
        carta[1] = tip_carti;
        carta[2] = schet;
        carta[3] = shtuchnie;
        carta[4] = deystvie;
        for (String i : carta) {
            System.out.print(i +' ');
        }
        System.out.println();
    }

    public String bankomat(){          //банкомат и мобильное приложение - строка состаяния карты
        String s= carta[0]+' '+carta[1]+' '+carta[2]+' '+carta[3]+carta[4] ;
        return s;
    }

    public Card_raz oplata() {
        String s = new String();
        Integer schet = Integer.valueOf(carta[2]);        //счёт карты
        Integer shtuchnie = Integer.valueOf(carta[3]);    //количество штучных поездок
        if (shtuchnie != 0) {
            shtuchnie--;          //списание штучных поездок
            carta[3] = s.valueOf(shtuchnie);
            carta[4] = " Штучные_" + s.valueOf(shtuchnie + 1);   //предыдущее состояние
            System.out.println("Оплата -1");
        }
        else {
            schet -= 40;      //списание денег
            carta[2] = s.valueOf(schet);
            carta[4] = " Баланс_" + s.valueOf(schet + 40);   //предыдущее состояние
            System.out.println("Оплата 40р.");
        }
        for (String i : carta) {
            System.out.print(i+' ');
        }
        System.out.println();
        return this;
    }
}

class Bankomat {    //банкомат
    public String[] card;

    public Bankomat() {
        card = new String[5];
    }

    public Card_F popolnenieF(String annotaziy, Card_F carta) {   //для карт с фиксированной оплатой
        card= annotaziy.split(" ");    //создание массива
        System.out.println("Введите сумму для пополнения");
        Scanner in = new Scanner(System.in);
        int summa = in.nextInt();    //сумма для пополнения
        Integer schet = Integer.valueOf(card[2]);   //счёт карты
        String s = new String();
        card[2] = s.valueOf(schet + summa);    //добавление суммы на счёт
        carta = new Card_F(card[0],card[1],card[2],card[3]);
        return carta;
    }

    public Card_raz popolnenieP(String annotaziy, Card_raz carta) {    //для карт с поразовой оплатой
        card= annotaziy.split(" ");
        System.out.println("Введите сумму для пополнения");
        Scanner in = new Scanner(System.in);
        int summa = in.nextInt();
        Integer schet = Integer.valueOf(card[2]);
        String s = new String();
        card[2] = s.valueOf(schet + summa);
        carta = new Card_raz(card[0],card[1],card[2],card[3], card[4]);
        return carta;
    }
}

class Mobilnoe_prilozenie {     //мобильное приложение
    public String[] card;
    public Mobilnoe_prilozenie() {
        card = new String[5];
    }
    public Card_F popolnenieF(String annotaziy, Card_F carta) {       //для карт с фиксированной оплатой
        card= annotaziy.split(" ");        //создание массива
        System.out.println("Введите сумму для пополнения");
        Scanner in = new Scanner(System.in);
        int summa = in.nextInt();    //вводим сумму для пополнения
        Integer schet = Integer.valueOf(card[2]);   //счёт карты
        String s = new String();
        card[2] = s.valueOf(schet + summa);    //добавление суммы на счёт
        carta = new Card_F(card[0],card[1],card[2],card[3]);
        return carta;
    }
    public Card_raz popolnenieP(String annotaziy, Card_raz carta) {    //для карт с поразовой оплатой
        card= annotaziy.split(" ");
        System.out.println("Введите сумму для пополнения");
        Scanner in = new Scanner(System.in);
        int summa = in.nextInt();
        Integer schet = Integer.valueOf(card[2]);
        String s = new String();
        card[2] = s.valueOf(schet + summa);
        carta = new Card_raz(card[0],card[1],card[2],card[3], card[4]);
        return carta;
    }
}

class Terminal {     //терминал
    ArrayList<Integer> statist = new ArrayList<>();
    public Terminal(){
        statist = new ArrayList<>();    //лист для статистики
        statist.add(0);
        statist.add(0);
        statist.add(0);
    }

    public void proverka_oplati(String annotaziy) {     //провекрка оплаты проезда
        String[] card= annotaziy.split(" ");       //создание массива
        statist.add(0,statist.get(0)+1);    //добавляем проход в статистику
        if (card[1].equalsIgnoreCase("Поразовая")) {      //проверка поразовых карт
            String s = new String();
            String ss = new String();
            s = card[4].substring(card[4].indexOf("_")+1);
            Integer prov = Integer.valueOf(s);
            ss = card[4].substring(0,card[4].indexOf("_"));
            if (ss.equalsIgnoreCase("Штучные")) {
                Integer shtuki = Integer.valueOf(card[3]);
                if (prov > shtuki) {
                    System.out.println("Оплачено");
                    statist.add(1,statist.get(1)+1);   //добавляем в статистику
                }
                else {
                    System.out.println("НЕ Оплачено");
                }
            }
            else {
                if (ss.equalsIgnoreCase("Баланс")) {      //если расплачивались списанием денег со счёта
                    Integer balans = Integer.valueOf(card[2]);
                    if (prov > balans) {
                        System.out.println("Оплачено");
                        statist.add(2,statist.get(2)+40);   //добавляем в статистику
                    }
                    else {
                        System.out.println("НЕ Оплачено");
                    }
                }
            }
        }
        else {       //если карта с фиксированной оплатой
            String[] dataOplati = card[3].split("-");     //дата последней оплаты
            int[] dataOp = new int[3];
            for(int i=0; i<3; i++) {
                String s = new String();
                dataOp[i] = Integer.parseInt(s.valueOf(dataOplati[i]));   //создаём массив для даты последней оплаты
            }
            LocalDate date = LocalDate.now();         //получаем текущую дату
            String s = new String();
            String[] dataNow = (s.valueOf(date)).split("-");
            int[] dataN = new int[3];
            for(int i=0; i<3; i++){
                String ss = new String();
                dataN[i]= Integer.parseInt(ss.valueOf(dataOplati[i]));   //создаём массив для сегодняшней даты
            }

            if (dataOp[0]<dataN[0] && dataOp[1]==12 && dataN[1]==1 && dataN[2]<dataOp[2]){    //провекра если оплата на декабрь-январь
                System.out.println("Оплачено");
            }
            else{
                if (dataOp[0]==dataN[0] && dataN[1]==dataOp[1]){    //проверка если тот же месяц
                    System.out.println("Оплачено");
                }
                else{
                    if (dataOp[0]==dataN[0] && dataN[1]-dataOp[1]==1 && dataN[2]<dataOp[2]){     //проверка если уже другой месяц
                        System.out.println("Оплачено");
                    }
                    else{
                        System.out.println("НЕ Оплачено");

                    }
                }
            }
        }
    }

    public void statistika(){
        System.out.println("-----------Статистика-----------");    //вывод статистики терминала
        System.out.print("Количество поездок: ");
        System.out.print(statist.get(0));
        System.out.println();
        System.out.print("Количество Штучных поездок: ");
        System.out.print(statist.get(1));
        System.out.println();
        System.out.print("Сколько денег заработал: ");
        System.out.print(statist.get(2));
        System.out.println();
    }
}