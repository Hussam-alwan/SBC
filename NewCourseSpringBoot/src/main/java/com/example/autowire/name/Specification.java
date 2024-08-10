package com.example.autowire.name;

public class Specification {
    private String make;
    private String model;



    public void setMake(String make) {
        System.out.println("setter called make");
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Specification{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
