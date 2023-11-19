package project.isabackend.model;

public enum MedicalSupplyType {
    EQUIPMENT("Equipment"), LABORATORY("Laboratory"), INJECTION_INFUSION("Injections and Infusion"),
    HYGIENE_DISINFECTION("Hygiene and Disinfection"), DRESSING_MATERIAL("Dressing material"),
    EMERGENCY_FIRST_AID("Emergency and First Aid"), INSTRUMENTS("Instruments");

    public final String value;

    private MedicalSupplyType(String value) {
        this.value = value;
    }
}
