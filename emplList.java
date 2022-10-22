package employees;

public abstract class emplList {
    private String name;
    private String last_name;
    private String Id;

    public emplList(String name, String last_name, String Id) {
        this.name = name;
        this.last_name = last_name;
        this.Id = Id;
    }

    public abstract double getSalary();

    public String getName() {
        return name;
    }

    public String getFamily() {
        return last_name;
    }

    public String getId() {
        return Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String last_name) {
        this.last_name = last_name;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
}