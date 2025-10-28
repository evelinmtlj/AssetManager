package com.pluralsight;

import java.time.LocalDate;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int odometer, int year) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.odometer = odometer;
        this.year = year;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
    @Override
    public double getValue(){

        int currentYear = LocalDate.now().getYear(); // gets current year
        int vehicleAge = currentYear - this.year;  // calculates how old the vehicles is
        double value = getOriginalCost();  // start with the original cost

        if(vehicleAge >= 0 && vehicleAge <= 3) {
            value -= value * .03 * vehicleAge; //3% per year
        } else if (vehicleAge >= 4 && vehicleAge <= 6) {
            value -= value * .06 * vehicleAge;
        }else if (vehicleAge >= 7 && vehicleAge <= 10){
            value -= value * .08 * vehicleAge;
        } else if (vehicleAge > 10) {
            value = 1000.0;
        }
        //minus reduce final value by 25%
        double finalValue = value - (value * .25);//
        if(odometer > 100000 && !(makeModel.contains("Honda") || makeModel.contains("Toyota"))){
            value *= .75;
        }
        return value;


    }
}
