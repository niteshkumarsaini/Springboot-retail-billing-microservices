package com.microservice.RetailService.Util;

public enum ItemType {

    ELECTRONICS(0.15),
    GROCERIES(0.00),
    FURNITURE(0.10),
    OTHER(0.12);

    private final double taxRate;

    ItemType(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public static ItemType from(String type) {
        try {
            return ItemType.valueOf(type.toUpperCase());
        } catch (Exception e) {
            return OTHER;
        }
    }
}