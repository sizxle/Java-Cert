package com.cert.play;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static com.cert.play.Class1.print;
//import static com.cert.play.Class2.print;

class Class1 {
	public static void print() {
		System.out.println("Class1 print()");
	}

	public static void print(int x) {
		System.out.println("Class1 print(int x): " + x);
	}
}

// Class2.java
//class Class2 {
//	public static void print(String s) {
//		System.out.println("Class2 print(String s): " + s);
//	}
//}

public class PlayGround{

	public static final int NUM_OF_PEOPLE=20;

	public static void main(String[] args) {
		print();        // Calls print() from Class1
		print(10);      // Calls print(int x) from Class1
//		print("Hello"); // Calls print(String s) from Class2

		Long j= 3L;

	}
}