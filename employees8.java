package employees;

public class employees8 extends emplList {//класс работников с почасовой оплатой
    double hour;

    public employees8(String name, String last_name, String Id, double hour) {
        super(name, last_name, Id);
        this.hour = hour;
    }

    @Override
    public double getSalary() {
        return 20.8 * 8 * hour;
    }

    public double getHourPrice() {
        return hour;
    }
}