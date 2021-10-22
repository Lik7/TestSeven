package enums;

public enum AirportData {
    LED("LED", "пулково", "pulkovo", "Санкт-Петербург"),
    DME("DME", "домодедово", "domodedovo", "Москва");

    private String codeIATA;
    private String nameRU;
    private String nameEN;
    private String city;

    AirportData(String codeIATA, String nameRU, String nameEN, String city) {
        this.codeIATA = codeIATA;
        this.nameRU = nameRU;
        this.nameEN = nameEN;
        this.city = city;
    }

    public String getCodeIATA() {
        return codeIATA;
    }

    public String getNameRU() {
        return nameRU;
    }

    public String getNameEN() {
        return nameEN;
    }

    public String getCity() {
        return city;
    }
}
