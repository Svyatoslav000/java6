public class Vektor {
    double x;
    double y;
    double z;
    public  Vektor( double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public static void main(String[] args) {
        Vektor vektor=new Vektor(1.0,2.0,3.0);

        double z1=1;
        double y1=2;
        double x1=3;

    }

    public double dlina(Vektor vektor){//b.метод, вычисляющий длину вектора
        return Math.sqrt(vektor.x * x + vektor.y * y + vektor.z * z);
    }
    public double scalyarnoe(Vektor vektor){//c.	метод, вычисляющий скалярное произведение
        return(vektor.x*x+ vektor.y*y+ vektor.z*z);
    }
    public Vektor vektorvekproizv(Vektor vektor){//d.	метод, вычисляющий векторное произведение с другим вектором
        double x2=vektor.y * z-vektor.z*y;
        double y2=vektor.z*x-vektor.x*z;
        double z2=vektor.x*y-x*vektor.y;
        return new Vektor(x2,y2,z2);
    }
    public double cosinusugla(Vektor vektor){//e.	метод, вычисляющий угол между векторами (или косинус угла): косинус угла между векторами равен скалярному произведению векторов, деленному на произведение модулей (длин) векторов
        return scalyarnoe(vektor)/(vektor.dlina(vektor)*dlina(vektor));
    }

    public Vektor summa(Vektor vektor){//f.	методы для суммы и разности
        double x2=vektor.x + x;
        double y2=vektor.y+y;
        double z2=vektor.z + z;
        return new Vektor(x2,y2,z2);
    }
    public Vektor raznost(Vektor vektor){//f.	методы для суммы и разности
        double x2=vektor.x - x;
        double y2=vektor.y-y;
        double z2=vektor.z - z;
        return new Vektor(x2,y2,z2);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}


