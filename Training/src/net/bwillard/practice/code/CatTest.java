package net.bwillard.practice.code;

import java.util.ArrayList;
import java.util.List;

public class CatTest {
public class Animal {}

public class Cat extends Animal {}

public class MyCat extends Cat {}

public class Dog extends Animal {}

public void addMethod(List<? super Cat> catList) {
	List<? super Cat> catList2 = new ArrayList<>();
    catList.add(new MyCat());
    System.out.println("Cat Added");
}

public static void main(String[] args) {
    List<Animal> animalList= new ArrayList<Animal>();
    List<Cat> catList= new ArrayList<Cat>();
    List<MyCat> myCatList= new ArrayList<MyCat>();
    List<Dog> dogList= new ArrayList<Dog>();

    CatTest catTest= new CatTest();
    // Here you are trying to add a MyCat instance(in the addMethod we create a MyCat instance). MyCat is a Cat, Cat is an Animal, therefore MyCat is an Animal.
    // So you can add a new MyCat() to a list of List<Animal> because it's a list of Animals and MyCat IS an Animal.
    catTest.addMethod(animalList);
    // Here you are trying to add a MyCat instance(in the addMethod we create a MyCat instance). MyCat is a Cat. 
    // So you can add a new MyCat() to a list of List<Cat> because it is a list of Cats, and MyCat IS a Cat
    catTest.addMethod(catList);
    // ***Here are trying to add a MyCat instance(in the addMethod we create a MyCat instance). MyCat is a Cat.
    // Everything should work but !!! THE PROBLEM HERE is that you restricted(bounded) the type of the lists to be passed to the method to be of
    // a type that is either "Cat" or supertype of "Cat". While "MyCat" IS a "Cat". It IS NOT a supertype of "Cat". Therefore you cannot use the method
    catTest.addMethod(myCatList); // DOESN'T COMPILE
    // Here you are adding a MyCat instance(in the addMethod we create a MyCat instance). MyCat is a Cat. 
    // You CANNOT call the method here, because "Dog" is not a "Cat" or a supertype of "Cat"
    catTest.addMethod(dogList); // DOESN'T COMPILE

}