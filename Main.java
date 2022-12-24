import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class Zadanie {//Класс задание для планировщика
    public int nomer;
    public LocalDate  first_data;
    public LocalDate last_data;
    public String naimenovanie;
    public String opisanie;
    public Boolean vipolnenie;

    public Zadanie(String naimenovanie, String opisanie) throws ParseException {//конструктор класса задание
        this.nomer = (int)(Math.random()*100);
        this.first_data = LocalDate.now();
        this.naimenovanie = naimenovanie;
        this.opisanie = opisanie;
        this.vipolnenie=false;
    }

    public void Vipolneno() throws ParseException {//отмечаем задание выполненным
        vipolnenie=true ;
        this.last_data=LocalDate.now();
    }

    public String Izmenenie_Naim(String naim){//изменяет наименование задания
        this.naimenovanie=naim;
        return naimenovanie;
    }

    public String Izmenenie_Opis(String op){//изменяем описание задания
        this.opisanie=op;
        return naimenovanie;
    }
}

public class Main{

    public static void main(String[] args) throws IOException, ParseException {
        Zadanie z1 = new Zadanie("Продукты","Сходить за продуктами по списку");//создаём задания
        Zadanie z2 = new Zadanie("ДЗ","Сделать дз по java");
        ArrayList<Zadanie> Vse = new ArrayList<>();//все задания
        ArrayList<Zadanie> Nevipolneni = new ArrayList<>();//все невыполненные заданий
        ArrayList<Zadanie> Vipolneni = new ArrayList<>();//все выполненные задания
        Vse.add(z1);
        Nevipolneni.add(z1);
        Vse.add(z2);
        Nevipolneni.add(z2);
        Integer h=1;
        while (h==1){//цикл планировщика
            System.out.println("Что вы хотите сделать?");
            System.out.println("1. Создать задание");
            System.out.println("2. Удалить задание");
            System.out.println("3. Отредактировать задание");
            System.out.println("4. Просмотреть список ВСЕХ заданий (на дату ВЫПОЛНЕНИЯ- 41,на дату СОЗДАНИЯ- 42)");
            System.out.println("5. Просмотреть список ВЫПОЛНЕННЫХ заданий (на дату ВЫПОЛНЕНИЯ- 51,на дату СОЗДАНИЯ- 52)");
            System.out.println("6. Просмотреть список НЕВЫПОЛНЕННЫХ заданий (на дату ВЫПОЛНЕНИЯ- 61,на дату СОЗДАНИЯ- 62)");
            System.out.println("7. Просмотреть детальную информацию о задании");
            System.out.println("8. Отметить задание как выполненное");
            System.out.println();
            Scanner in = new Scanner(System.in);
            System.out.println("Введите номер операции:");
            Integer n = in.nextInt();
            switch(n){//выполнение выбранной операции
                case 1:
                    String s2 = in.nextLine();
                    System.out.println("Введите Наименование и Описание (разделитель *):");//создаём задания
                    String s = in.nextLine();
                    String ss = s.substring(s.indexOf("*")+1) ;
                    s=s.substring(0, s.indexOf("*")) ;
                    Vse.add(new Zadanie(s, ss));
                    Nevipolneni.add(Vse.get(Vse.size()-1));
                    break;
                case 2:
                    System.out.println("Введите номер задания к удалению:");
                    Integer k = in.nextInt();
                    for(Zadanie i: Vse){//ищем задание в списке
                        if (i.nomer==k){
                            Vse.remove(i);
                            if (i.vipolnenie){
                                Vipolneni.remove(i);//удаляем задания
                            }
                            else Nevipolneni.remove(i);
                            break;
                        }
                    }
                    break;
                case  3:
                    System.out.println("Введите номер задания:");
                    k = in.nextInt();
                    System.out.println("Что редактируем? 1.Наименование 2.Описание 3.И то и то");
                    Integer l = in.nextInt();
                    for(Zadanie i: Vse){
                        if (i.nomer==k){
                            switch(l){
                                case 1:
                                    s2 = in.nextLine();
                                    System.out.println("Введите наименование:");//изменяем наименование
                                    String s1 = in.nextLine();
                                    i.Izmenenie_Naim(s1);
                                    break;
                                case 2:
                                    s2 = in.nextLine();
                                    System.out.println("Введите описание:");//изменяем описание
                                    String ss1 = in.nextLine();
                                    i.Izmenenie_Opis(ss1);
                                    break;
                                case 3:
                                    s2 = in.nextLine();//изменяем, и наименование, и описание задания
                                    System.out.println("Введите Наименование и Описание (разделитель *):");
                                    s1 = in.nextLine();
                                    ss1 = s1.substring(s1.indexOf("*")+1) ;
                                    s1=s1.substring(0, s1.indexOf("*")) ;
                                    i.Izmenenie_Naim(s1);
                                    i.Izmenenie_Opis(ss1);
                                    break;
                            }
                        }
                    }
                    break;
                case 4:
                    for(Zadanie i: Vse){//выводит все задания
                        System.out.println(i.nomer+ " " + i.naimenovanie);
                    }
                    break;
                case 41:
                    int a = in.nextInt();//выводим все задания в соответствии с датой выполнения
                    int b = in.nextInt();//вводим дату с клавиатуры
                    int c = in.nextInt();
                    LocalDate d = LocalDate.of(a, b, c);
                    Vse_na_datu(Vse, d);
                    break;
                case 42:
                    a = in.nextInt();//выводит все задания в соответствии с датой создания
                    b = in.nextInt();//вводим дату с клавиатуры
                    c = in.nextInt();
                    d = LocalDate.of(a, b, c);
                    Vse_na_datuSozd(Vse, d);
                    break;
                case 5:
                    for(Zadanie i: Vipolneni){//выводит все выполненные задания
                        System.out.println(i.nomer+ " " + i.naimenovanie);
                    }
                    break;
                case 51:
                    a = in.nextInt();//выводим все выполненные задания в соответствии с датой выполнения
                    b = in.nextInt();//вводим дату с клавиатуры
                    c = in.nextInt();
                    d = LocalDate.of(a, b, c);
                    VseVipoln_na_datu(Vipolneni, d);
                case 52:
                    a = in.nextInt();//выводим все выполненные задания в соответствии с датой создания
                    b = in.nextInt();//вводим дату с клавиатуры
                    c = in.nextInt();
                    d = LocalDate.of(a, b, c);
                    VseVipoln_na_datuSozd(Vipolneni, d);
                    break;
                case 6:
                    for(Zadanie i: Nevipolneni){//выводит все невыполненные задания
                        System.out.println(i.nomer+ " " + i.naimenovanie);
                    }
                    break;
                case 61:
                    a = in.nextInt();//выводим все невыполненные задания в соответствии с датой выполнения
                    b = in.nextInt();//вводим дату с клавиатуры
                    c = in.nextInt();
                    d = LocalDate.of(a, b, c);
                    VseNeVipoln_na_datu(Nevipolneni, d);
                    break;
                case 62:
                    a = in.nextInt();//выводим все невыполненные задания в соответствии с датой создания
                    b = in.nextInt();//вводим дату с клавиатуры
                    c = in.nextInt();
                    d = LocalDate.of(a, b, c);
                    VseNeVipoln_na_datuSozd(Nevipolneni, d);
                    break;
                case 7:
                    System.out.println("Введите номер задания:");//информация о задании в соответствии с егт номером
                    k = in.nextInt();
                    information(Vse, k);
                    break;
                case 8:
                    System.out.println("Введите номер задания:");//отмечаем выполненное задание
                    k = in.nextInt();
                    for(Zadanie i: Vse){
                        if (i.nomer==k){
                            i.Vipolneno();
                            Vipolneni.add(i);//добавляем задание в список выполненных
                            Nevipolneni.remove(i);//удоляем из списка невыполненных
                            break;
                        }
                    }
                    break;
            }
            System.out.println("Продолжить работу с планировщиком? 1.Да 2.Нет");
            h = in.nextInt();
        }

    }

    public static void Vse_na_datu(ArrayList<Zadanie> Vse, LocalDate data1){//выводим все задания в соответствии с датой выполнения
        System.out.println(data1);
        for(Zadanie i: Vse){
            if ((i.last_data).equals(data1)){//сравнениваем даты
                System.out.println(i.nomer+ " " + i.naimenovanie);
            }
        }
    }

    public static void VseNeVipoln_na_datu(ArrayList<Zadanie> Nevipolneni, LocalDate data1){//выводим все невыполненные задания в соответствии с датой выполнения
        System.out.println(data1);
        for(Zadanie i: Nevipolneni){
            if (i.last_data.equals(data1)){
                System.out.println(i.nomer+ " " + i.naimenovanie);
            }
        }
    }

    public static void VseVipoln_na_datu(ArrayList<Zadanie> Vipolneni, LocalDate data1){//выводим все выполненные задания в соответствии с датой выполнения
        System.out.println(data1);
        for(Zadanie i: Vipolneni){
            if (i.last_data.equals(data1)){
                System.out.println(i.nomer+ " " + i.naimenovanie);
            }
        }
    }

    public static void Vse_na_datuSozd(ArrayList<Zadanie> Vse, LocalDate data1){//выводим все задания в соответствии с датой создания
        System.out.println(data1);
        for(Zadanie i: Vse){
            if (i.first_data.equals(data1)){
                System.out.println(i.nomer+ " " + i.naimenovanie);
            }
        }
    }

    public static void VseNeVipoln_na_datuSozd(ArrayList<Zadanie> Nevipolneni, LocalDate data1){//выводим все невыполненные задания в соответствии с датой создания
        System.out.println(data1);
        for(Zadanie i: Nevipolneni){
            if (i.first_data.equals(data1)){
                System.out.println(i.nomer+ " " + i.naimenovanie);
            }
        }
    }

    public static void VseVipoln_na_datuSozd(ArrayList<Zadanie> Vipolneni, LocalDate data1){//выводим все выполненные задания в соответствии с датой создания
        System.out.println(data1);
        for(Zadanie i: Vipolneni){
            if (i.first_data.equals(data1)){
                System.out.println(i.nomer+ " " + i.naimenovanie);
            }
        }
    }

    public static void information(ArrayList<Zadanie> Vse, int nomer){//выводим подробную информацию о задании
        System.out.println(nomer);
        for(Zadanie i: Vse){
            if (i.nomer==nomer){
                System.out.println(i.first_data);
                System.out.println(i.naimenovanie);
                System.out.println(i.opisanie);
                System.out.println(i.last_data);
            }
        }
    }
}