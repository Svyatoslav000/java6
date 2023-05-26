package com.example.app;

public class Train {
    private String name;
    private String type;
    private String numOfCarriages;
    private String seatsInCarriage;

    public Train(String name, String type, String numOfCarriages, String seatsInCarriage) {
        this.name = name;
        this.type = type;
        this.numOfCarriages = numOfCarriages;
        this.seatsInCarriage = seatsInCarriage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumOfCarriages() {
        return numOfCarriages;
    }

    public void setNumOfCarriages(String numOfCarriages) {
        this.numOfCarriages = numOfCarriages;
    }

    public String getSeatsInCarriage() {
        return seatsInCarriage;
    }

    public void setSeatsInCarriage(String seatsInCarriage) {
        this.seatsInCarriage = seatsInCarriage;
    }
}
