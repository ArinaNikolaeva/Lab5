package L5_8.data;

public abstract class Group { //супер класс группа
    protected String name; //название
    protected int year; //год
    protected int participants; //участники


    public Group(String name, int year, int participants) {
        this.name = name;
        this.year = year;
        this.participants = participants;
    }

    public Group() {
    }

    protected abstract String report(); //метод для вывода инфо

    protected abstract void setGanr(String str);

    public String getName(){
        return name;
    }
    public void setName(String n) {
        this.name = n;
    }

    public int getYear(){
        return year;
    }
    public void setYear(int a) {
        this.year = a;
    }

    public int getParticipants(){
        return participants;
    }
    public void setParticipants(int p) {
        this.participants = p;
    }
}

