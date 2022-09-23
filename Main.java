public class Main
{
    public static void main(String[] args) {
        System.out.println("Hello World");//первое задание

        int x=1;//второе задание
        System.out.println(x);

        int y=1;//3 задание
        y++;
        System.out.println(y);
        int z=1;
        z=z+1;
        System.out.println(z);

        int a=5;//4 задача
        int b=6;
        int c=0;
        c = a;
        a = b;
        b = c;
        System.out.println(a);
        System.out.println(b);

        double a1=3;//5 задача
        double b1=4;
        double c1=0;
        c1=Math.sqrt(a1*a1 + b1*b1);
        System.out.println(c1);

        int e = 133;//6 задача
        e%=10;
        System.out.println(e);

        int g=157;//7 задача
        g%=100;
        g/=10;
        System.out.println(g);

        int h=78;//8 задача
        h/=10;
        System.out.println(h);


        int ch1=56;//9 zadanie
        meth1(ch1);


        int ch2=20;//10 zadanie
        int ch3=24;
        meth2(ch2, ch3);


        int ch4=3;//11 zadanie
        int ch5=12;
        meth3(ch4, ch5);

        double x1=9;//12 zadanie
        double y1=-1;
        double x2=2;
        double y2=-25;
        meth4(x1,y1,x2,y2);

        }
        static void meth1(int ch1){
            int razn=ch1-21;
            System.out.println(razn);
        }
        static void meth2(int ch1, int ch2){
            int srAriph=(ch1+ch2)/2;
            System.out.println(srAriph);
        }
        static void meth3(int ch1, int ch2){
            double srGeom=Math.sqrt(ch1*ch2);
            System.out.println(srGeom);
        }
        static void meth4(double x1, double y1, double x2, double y2){
            double rast=Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
            System.out.println(rast);
        }

    }
