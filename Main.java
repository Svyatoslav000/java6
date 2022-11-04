
public class Main

{

    public static void main(String[] args) {
        Reader Pety = new Reader("Иванов П.П.", 1330024, "ФАРМАЦИЯ","10-04-1990", 845458877);//определяем петю
        Pety.takeBook(2);//берем 2 книги
        String[] knigi = {"ФИЗИОЛОГИЯ", "Анатомия"};//наши книги
        Pety.takeBook(knigi);
        Book book = new Book("Так говорил Заратустра", "Фридрих Ницше");//создаем книги
        Book book2 = new Book("Искусство войны", "Сунь-Цзы");
        Book bookg = new Book("sdadadsadsa ", "das-ad");
        Book[] knigi2 = {book2, bookg, book};
        Pety.takeBook(knigi2);
        Pety.returnBook(2);
        Pety.returnBook(knigi);
        Pety.returnBook(knigi2);
    }

}

class Reader{


    private String name;
    private String facultet;
    private  int nomerBileta;
    private String dataRozdeniy;
    private  int foneNomber;

    public Reader(String name, int nomerBileta, String facultet, String dataRozdeniy, int foneNomber){
        this.name=name;
        this.nomerBileta=nomerBileta;
        this.facultet=facultet;
        this.dataRozdeniy=dataRozdeniy;
        this.foneNomber=foneNomber;
    }

    public String getName(){
        return name;
    }

    public void takeBook(int kolvo){//берем несколько книг по количеству
        System.out.println(name + " взял " + String.valueOf(kolvo) + " книги");
    }


    public void takeBook(String[] args){//берем книги по названию
        String ss = new String() ;
        for(String s : args){
            ss= ss + s + ", ";
        }
        System.out.println(name + " взял книги : " + ss.substring(0,ss.length()-2));
    }

    public void takeBook(Book[] args){//берем несколько книг из книг  с автором
        String ss = new String() ;
        String s = new String() ;
        for(Book kniga: args){
            s= kniga.getName();
            ss= ss + s+ ", ";
        }
        System.out.println(name + " взял книги : " + ss.substring(0,ss.length()-2));
    }

    public void returnBook(int kolvo){//возвращаем несколько книг по количеству
        System.out.println(name + " вернул " + String.valueOf(kolvo) + " книги");
    }


    public void returnBook(String[] args){//возвращаем книги по названию
        String ss = new String() ;
        for(String s : args){
            ss= ss + s + ", ";
        }
        System.out.println(name + " вернул книги : " + ss.substring(0,ss.length()-2));
    }

    public void returnBook(Book[] args){//возвращаем несколько книг из книг  с автором
        String ss = new String() ;
        String s = new String() ;
        for(Book kniga: args){
            s= kniga.getName();
            ss= ss + s+ ", ";
        }
        System.out.println(name + " вернул книги : " + ss.substring(0,ss.length()-2));
    }


}

class Book{
    public String name;
    public String avtor;

    public Book(String name, String avtor){
        this.name=name;
        this.avtor=avtor;
    }

    public String getName(){
        return name;
    }

}