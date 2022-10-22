import employees.employes;
import employees.emplList;
import employees.employees8;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static List<emplList> list = new ArrayList<>();//объявляем лист

    public static void main(String[] args) {//тело
        createEmplyeers();
        outputConsole(list);
        sortM(list);

    }

    public static void createEmplyeers() {  // создаем сотрудников
        list.add(new employes("Игорь", "Мизин", "4000", 76723));
        list.add(new employes("Артем", "Чугумбаев", "3000", 67573));
        list.add(new employees8("Валерий", "Дьяконов", "58", 978));
        list.add(new employees8("Сергей", "Шепелев", "88",989));
        list.add(new employees8("Никита", "Лопатин", "342",989));
        list.add(new employees8("Андрей", "БронтВЕЙН", "9877",7564));
        list.add(new employees8("Антон", "Степанов", "9878",300));
        list.add(new employees8("Никита", "Точилин", "1231",1234));
        list.add(new employees8("Кира", "Пантыкина", "1231",12348));

    }


    public static void outputConsole(List<emplList> empl) { //метод вывода
        String emplo = null;
        for (int i = 0; i < empl.size(); i++) {
            if (empl.get(i) instanceof employes) {
                emplo = "фиксированный";
            } else if (empl.get(i) instanceof employees8) {
                emplo = "почасовый";
            }
            System.out.println(i + 1 + " " + empl.get(i).getName() + " " + empl.get(i).getFamily() + " " + empl.get(i).getId() + " "+ emplo + " " + empl.get(i).getSalary());
        }
    }

    public static void sortM(List<emplList> empl) {//сортировка для листов
        System.out.println();
        empl.sort(new Comparator<emplList>() {
            @Override
            public int compare(emplList o1, emplList o2) {
                if (o1.getSalary() == o2.getSalary()) return 0;
                else if (o1.getSalary() < o2.getSalary()) return 1;
                else return -1;
            }
        });
        outputConsole(empl);
        for (int i = 0; i < 5; i++) {//вывод 5 имен
            System.out.println(empl.get(i).getName());
        }
        for (int i = empl.size()-3; i < empl.size(); i++) {//вывод 3 идентификаторов
            System.out.println(empl.get(i).getId());
        }
    }
}