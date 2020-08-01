package com.twu.biblioteca.elementusage;

public class Element {
    String name;
    boolean isChecked;

    public Element(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
