package com.dotin.model.enums;

public enum CategoryElementType {
    ROLE(1), CONFIRMATION(2);

    private int numVal;

    CategoryElementType(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
