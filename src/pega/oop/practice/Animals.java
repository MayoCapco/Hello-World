package pega.oop.practice;

import java.io.Serializable;

public class Animals implements Serializable {
    private String species_name;
    private Character sex; // M or F
    private double size; // in Meters
    private double weight; // in KG
    private int age;

    public Animals(){
        this.species_name="UNSPECIFIED";
        this.size=0;
        this.age=0;
    }

    public Animals(String name, Character c, double sz, double wgt, int a){
        this.species_name=name;
        this.sex=c;
        this.size=sz;
        this.weight=wgt;
        this.age=a;
    }

    // setters
    public void setSpecies_name(String name){
        this.species_name=name;
    }

    public void setSex(Character c){
        this.sex=c;
    }

    public void setSize(double sz){
        this.size=sz;
    }

    public void setWeight(double wgt){
        this.weight=wgt;
    }

    public void setAge(int ag){
        this.age=ag;
    }

    // getters
    public String getSpecies_name(){
        return this.species_name;
    }

    public Character getSex(){
        return this.sex;
    }

    public double getSize(){
        return this.size;
    }

    public double getWeight(){
        return this.weight;
    }

    public int getAge(){
        return this.age;
    }

    public void getAnimalDescription(){
        System.out.println(this.species_name+"\nSex: "+this.sex+"\nAge: "+this.age+"\nSize: "+this.size+"\nWeight: "+this.weight);
    }
}
