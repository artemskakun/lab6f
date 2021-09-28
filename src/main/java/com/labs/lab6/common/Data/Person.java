package com.labs.lab6.common.Data;

import java.io.Serializable;

public class Person implements Serializable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String passportID; //Длина строки не должна быть больше 30, Поле может быть null
    private Color eyeColor; //Поле не может быть null
    private Color hairColor; //Поле может быть null
    private Country nationality; //Поле может быть null

    public Person(String name, String passportID, Color eyeColor, Color hairColor, Country nationality) {
        this.name = name;
        this.passportID = passportID;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
    }

    public Person() {

    }

    /**
     * @return Name of Person
     */
    public String getName() {
        return name;
    }

    /**
     * @return Person passportID
     */
    public String getPassportID() {
        return passportID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    /**
     * @return Person Eye Color
     */
    public Color getEyeColor() {
        return eyeColor;
    }

    /**
     * @return Person Hair Color
     */
    public Color getHairColor() {
        return hairColor;
    }

    /**
     * @return Person nationality
     */
    public Country getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", passportID='" + passportID + '\'' +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                '}';
    }
}