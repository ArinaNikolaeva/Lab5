package L5_8.data;

public class Popular extends Group { //класс группа, потомок group
    protected String ganr; //жанр

    public Popular(String name, int year, int participants, String ganr) {
        super(name, year, participants);
        this.ganr = ganr;
    }

    public Popular() {
    }
    @Override //переопределение метода report класса group
    protected String report() { //переопределение метода report класса group
        String info = "Популярная группа " + this.name + ": основана в " + this.year + " г." + ", кол-во участников - " + this.participants + ", жанр - " + this.ganr;
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

