package pega.oop.practice;

import pega.oop.practice.Animals;

public class oopMain {
    public static void main(String[] args)throws Exception{
        Animals testAnimal=new Animals();

        testAnimal.setSpecies_name("African Zebra");
        testAnimal.setSex('F');
        testAnimal.setSize(21);
        testAnimal.setWeight(47);
        testAnimal.setAge(3);

        testAnimal.getAnimalDescription();

    }
}
