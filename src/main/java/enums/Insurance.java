package enums;

public enum Insurance {

    INSURE_YOUR_TRIP("Страховка «Авиа»"),
    TRAVEL_CANCELLATION_INSURANCE("Страховка от невыезда"),
    MEDICAL_INSURANCE("Медицинская страховка"),
    TRAVEL_INSURANCE("Страховка Трэвел"),
    TRAVEL_SPORT("Страховка Трэвел-Спорт"),
    ANTICOVID_INSURANCE("Страховка \"Антиковид\"");

    private String insuranceName;

    Insurance(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getInsuranceName() {
        return insuranceName;
    }
}
