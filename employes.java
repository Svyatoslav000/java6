package employees;

public class employes extends emplList {//класс работников с обычной оплатой
    double Mounths;

    public employes(String name, String last_name, String Id, double Mounths) {
        super(name, last_name, Id);
        this.Mounths = Mounths;
    }

    @Override
    public double getSalary() {
        return Mounths;
    }

    public double getPriceMounts() {
        return Mounths;
    }
}