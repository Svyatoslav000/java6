public class Main
{
    public static void main(String[] args) {
        System.out.println("Hello World");//1 Выведите на экран текст Hello World


        int x=1;//2 Создайте переменную, присвойте ей целочисленное значение. Выведите значение на экран

        System.out.println(x);

        int y=1;//3 Создайте переменную, увеличьте её на единицу несколькими способами и выведите значение на экран
        y++;
        System.out.println(y);
        int z=1;
        z=z+1;
        System.out.println(z);

        int a=5;//4 Даны две переменные. Поменяйте значения переменных друг с другом 
        int b=6;
        int c1=0;
        int d=3;
        int c=4;
        c1 = a;
        a = b;
        b = c1;
        c = c + d;
        d = c - d;
        c = c - d;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        double a1=3;//5 Дано два числа a и b. Найдите гипотенузу треугольника с заданными катетами
        double b1=4;
        double c1=0;
        c1=Math.sqrt(a1*a1 + b1*b1);
        System.out.println(c1);

        int e = 133;//6 Дано натуральное число. Выведите его последнюю цифру
        e%=10;
        System.out.println(e);

        int g=157;//7 Найдите число десятков в его десятичной записи 
        g%=100;
        g/=10;
        System.out.println(g);

        int h=78;//8 Дано двузначное число. Найдите число десятков в нем.

        h/=10;
        System.out.println(h);


        int ch1=56;//9 Реализуйте метод, который получает целое число на вход и возвращает разницу между данным числом и 21. Выведите значение на экран с различными целыми числами

        meth1(ch1);


        int ch2=20;//10 Реализуйте метод, в который передается две целочисленные переменные и возвращает их среднее арифметическое

        int ch3=24;
        meth2(ch2, ch3);


        int ch4=3;//11 Реализуйте метод, в который передается две целочисленные переменные и возвращает их среднее геометрическое
        int ch5=12;
        meth3(ch4, ch5);

        double x1=9;//12 Реализуйте метод, в который передается 4 числа с плавающей точкой. Первые два числа – координаты x, y первой точки. Вторые два числа – координаты x,y второй точки. Найти расстояние между двумя точками

        double y1=-1;
        double x2=2;
        double y2=-25;
        meth4(x1,y1,x2,y2);

        }
        static void meth1(int ch1){//поиск разницы между числом и 21
            int razn=ch1-21;
            System.out.println(razn);
        }
        static void meth2(int ch1, int ch2){//среднее арифметическое
            int srAriph=(ch1+ch2)/2;
            System.out.println(srAriph);
        }
        static void meth3(int ch1, int ch2){//среднее геометрическое
            double srGeom=Math.sqrt(ch1*ch2);
            System.out.println(srGeom);
        }
        static void meth4(double x1, double y1, double x2, double y2){//расстояние между двумя точками
            double rast=Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
            System.out.println(rast);
        }

    }
