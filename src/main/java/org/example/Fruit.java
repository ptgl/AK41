package org.example;

public class Fruit {
    public String name;
    public String color;

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public Fruit(String name, String color){
        this.name = name;
        this.color = color;
    }

    public void info(){
        System.out.println(this.name+" is "+this.color);
    }
}
