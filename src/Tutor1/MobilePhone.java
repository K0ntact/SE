package Tutor1;
import utils.DomainConstraint;

public class MobilePhone {

    @DomainConstraint(type = "String", optional = false, length = 30)
    private String manName;

    @DomainConstraint(type = "String", mutable = false, optional = false)
    private String model;

    @DomainConstraint(type = "Color", mutable = false, optional = false)
    private Color color;

    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1970, max = 2023)
    private int year;

    @DomainConstraint(type = "Boolean", optional = false)
    private boolean guaranteed;

    public MobilePhone(String manName, String model, Color color, int year, boolean guaranteed) {
        this.manName = manName;
        setModel(model);
        this.color = color;
        this.year = year;
        this.guaranteed = guaranteed;
    }

    public String getManName() {
        return manName;
    }
    public String getModel() {
        return model;
    }
    public Color getColor() {
        return color;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }
    private void setModel(String model) {
        /* Model must be in the format M-ABC-MNP, where ABC are letters in alphabet, MNP are numbers
        ^: start of string
        [A-Z]{3}: 3 letters in alphabet
        [0-9]{3}: 3 numbers
        $: end of string */
        if (model.matches("^M-[A-Z]{3}-[0-9]{3}$")) {
            this.model = model;
        } else {
            throw new IllegalArgumentException("Model must be in the format M-ABC-MNP, where ABC are letters in alphabet, MNP are numbers");
        }
    }
    public void setGuaranteed(boolean guaranteed) {
        this.guaranteed = guaranteed;
    }

    public int getYear() {
        return year;
    }
    public boolean isGuaranteed() {
        return guaranteed;
    }


}
