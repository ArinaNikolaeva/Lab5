package L5_8.data;

public class NotPopular extends Group { //класс не популярная, потомок group
    protected String ganr; //жанр
    public NotPopular(String name, int year, int participants, String ganr) {
        super(name, year, participants);
        this.ganr = ganr;
    }

    public NotPopular() {
    }

    @Override //переопределение метода report класса group
    protected String report() {
        String info = "Не популярная группа " + this.name + ": основана в " + this.year + " г." + ", кол-во участников - " + this.participants + ", жанр - " + this.ganr;
        return info;
    }

    public String getGanr() {
        return ganr;
    }

    @Override
    public void setGanr(String str) {
        this.ganr = str;
    }
}
