package L5_8.data;

import java.util.ArrayList;
import java.util.Scanner;

public class Mus {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList <Group> groups = new ArrayList();

    public static void add(Group p)
    {
        groups.add(p);
    }

    public static void print()
    {   for(Group p : groups) {
            p.report();
        }
    }

    public static String search(String str)
    {
        String name_s = str;
        boolean one = false;
        for(Group p : groups) {
            if (p.name.equals(name_s)){
                if (p instanceof Popular) {
                    one = true;
                    return ((Popular) p).report();
                } else {
                    one = true;
                    return ((NotPopular) p).report();
                }
            }
        }
        if(!one){
            return "Группа не найдена";
        }
        return "Ошибка";
    }
    public static void delete()
    {
        System.out.println("Введите название группы:");
        String name_s = scanner.next();
        boolean  one = false;

        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).name.equals(name_s)) {
                groups.remove(groups.get(i));
                one = true;
            }
        }
        if(!one){
            System.out.println("Группа не найдена");
        }
    }

    public int getCount() {
        return this.groups.size();
    }

    public Group getGroup(int index) {
        return groups.get(index);
    }

    public void remove(int ind) {
        this.groups.remove(ind);
    }

}
