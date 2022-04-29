package enums;

//enum для указания даты в календаре
public enum Days {
    TODAY(0),
    TOMORROW(1),
    IN_FIVE_DAYS(5),
    IN_WEEK(7);

    private int addDaysToToday;

    Days(int addDaysToToday) {
        this.addDaysToToday = addDaysToToday;
    }

    public int getDay() {
        return addDaysToToday;
    }
}
