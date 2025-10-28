package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class House extends Asset {
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

//constructor
    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }
//getters/setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public double getValue() {
        double squareFtPrice = switch (condition) {
            case 1 -> 180; //excellent
            case 2 -> 130; //good
            case 3 -> 90; //fair
            case 4 -> 80; //poor
            default -> 0;
        };

        return (squareFtPrice * this.squareFoot) + (.25 * this.lotSize);

    }




}

