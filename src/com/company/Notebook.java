package com.company;

public class Notebook {

    private int price;
    private int sizeOperateMember;
    private String manufacturer;

    public Notebook(int price, int sizeOperateMember, String manufacturer) {
        this.price = price;
        this.sizeOperateMember = sizeOperateMember;
        this.manufacturer = manufacturer;

    }

    public int getPrice() {
        return price;
    }

    public int getSizeOperateMember() {
        return sizeOperateMember;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return  this.getPrice() + " $" + ", " + this.getSizeOperateMember() + " Mb, " + this.getManufacturer();
    }
}
