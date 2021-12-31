package enums;

import helpers.DateSelected;

//enum для указания даты в календаре
public enum Dates {
    DAYS(0, 1, 5, 7);

    private int today;
    private int tomorrow;
    private int addFiveDays;
    private int inWeek;

    Dates(int today, int tomorrow, int addFiveDays, int inWeek) {
        this.today = today;
        this.tomorrow = tomorrow;
        this.addFiveDays = addFiveDays;
        this.inWeek = inWeek;
    }

    DateSelected ds = new DateSelected();

    public int today() {
        return today;
    }


    public void startTomorrow() {
        ds.tapDayStartInCalendar(tomorrow);
    }

    public void startInFiveDays() {
        ds.tapDayStartInCalendar(addFiveDays);
    }


    public int addFiveDays() {
        return addFiveDays;
    }

    public int inWeek() {
        return inWeek;
    }
    public void finishInWeek() {
        ds.tapDayFinishInCalendar(inWeek);
    }

}
