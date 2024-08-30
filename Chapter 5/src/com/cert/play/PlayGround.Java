package com.cert.play;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PlayGround{
	
	public static void main(String[] args){

//		indexOutOfBoundString();

//		char test= 'a'; // crazy that this works
//		System.out.println(doubleNum(test));

//		String string = "animals";
//		System.out.println(string.startsWith('a'));


//		String text = " abc\t ";
//		System.out.println(text.length());

//		exceedingCapacityRequested();

//		String a = "abcabc";
//		System.out.println(a.length());
//
//		String [] bugs = { "cricket", "beetle", "ladybug" };
//		String [] alias = bugs;
//		System.out.println(bugs.length);
//		System.out.println(bugs.equals(alias));
//		System.out.println(bugs.toString());
//		autoBoxingExamples();


//		arrayListToArray();

		short a =3;
		short b =9;

		System.out.println(Math.min(a,b));
		int[] array = { 6, -4, 12, 0, -10 };
		System.out.println(Arrays.binarySearch(array,
				12));

	}

	private static void arrayListToArray() {
		List<String> names = new ArrayList<>();

		names.add("sthembizo");
		names.add("tshiamo");

		String[] objeectName=names.toArray(new String[0]);

		for( String name: objeectName){
			System.out.println(objeectName);
		}
	}

	private static void autoBoxingExamples() {
		List<Integer> list = new ArrayList<>();
		Integer w = null;//autoboxing happens here
		list.add(w);
//		double d= list.get(0);
//		System.out.println(d);
	}

	private static void exceedingCapacityRequested() {
		StringBuilder name= new StringBuilder(1);
//		name.append(0L);// INTRESTING DOESNT TAKE THE L
		name.append("sthembizo molefi");
//		name.insert(16,true);
//		name.delete(0,20);
		name.replace(0,2,"tshiamo");
		System.out.println(name);
	}

	private static void indexOutOfBoundString() {
		String name= "Sthembizo";

		System.out.println(name.charAt(11));
	}

	private static int doubleNum(int chr){
		return chr*2;
	}
}