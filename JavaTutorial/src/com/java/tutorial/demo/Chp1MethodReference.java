package com.java.tutorial.demo;

import java.util.Arrays;
import java.util.stream.Stream;

public class Chp1MethodReference {
	//Use the double-colon notation to separate an instance reference or class name from the
	//method.(((”(double colon) notation in method references”)))
	//Ex: 
	//1. Using a lambda expression: 
	//   Stream.of(3, 1, 4, 1, 5, 9).forEach(x -> System.out.println(x));
	//2. Using a method reference
	//   Stream.of(3, 1, 4, 1, 5, 9).forEach(System.out::println);
	//3. Assigning the method reference to a functional interface
	//   Consumer<Integer> printer = System.out::println;
	//	 Stream.of(3, 1, 4, 1, 5, 9).forEach(printer);
	
	//1.	object::instanceMethod
	//			Refer to an instance method using a reference to the supplied object, as in System.out::println
	//2.	Class::staticMethod
	//			Refer to static method, as in Math::max
	//3.	Class::instanceMethod
	//		Invoke the instance method on a reference to an object supplied by the context,as in String::length
	
	//1. equivalent to System.out::println
	//x -> System.out.println(x)
	
	//2. equivalent to Math::max
	//(x,y) -> Math.max(x,y)
	
	//3. equivalent to String::length
	//x -> x.length()
	
	//	There are four kinds of method references:
	//1.		Static methods
	//2.		Instance methods of particular objects
	//3.		Instance methods of an arbitrary object of a particular type (It is a reference to an instance method from some type.)
	//			"arbitrary object" (the object passed in the parameter)
	//4.		Constructor
	
	String name;

    //constructor
    public Chp1MethodReference(String name){
        this.name = name;
    }

    //instance method 1
    public int personInstanceMethod1(Chp1MethodReference person){
        return this.name.compareTo(person.name);
    }

    //instance method 2
    public int personInstanceMethod2(Chp1MethodReference person1, Chp1MethodReference person2){
        return person1.name.compareTo(person2.name);
    }
    
    public static int personInstanceMethod3(Chp1MethodReference person1, Chp1MethodReference person2) {
    	return person1.name.compareTo(person2.name);
    }
    
	public static void main(String[] args) {
		
		//Stream.generate(Math::random).limit(10).forEach(System.out::println);
		
		Chp1MethodReference[] personArray = {new Chp1MethodReference("A"), new Chp1MethodReference("B")};
		
//		Arrays.sort(personArray, Chp1MethodReference::personInstanceMethod1);
//		
//		//Arrays.sort(personArray, Chp1MethodReference::personInstanceMethod2);
//	    
//        // Scenario 3 : Getting compiled successfully. 
//		Chp1MethodReference personInstance = new Chp1MethodReference("C");
//        Arrays.sort(personArray, personInstance::personInstanceMethod2);
//
//        // Scenario 4 : Getting compiled successfully. As the same way as "Scenario 1"
//        String[] stringArray = { "Barbara", "James", "Mary", "John",
//                                "Patricia", "Robert", "Michael", "Linda" };
//        Arrays.sort(stringArray, String::compareToIgnoreCase);
        
		Chp1MethodReference c1 = new Chp1MethodReference("A");
		
		Arrays.asList(personArray).stream().forEach(a->System.out.print(a.name+","));

		System.out.println();
		
		Arrays.sort(personArray, c1::personInstanceMethod2);
		
		Arrays.asList(personArray).stream().forEach(a->System.out.println(a.name+","));
	
	}

}
