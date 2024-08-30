package com.cert.play.Chapter;


public class PlayGround{
	
	public static void main(String[] args){

	 	// int a=(int)50L+(int)20l;	
		// System.out.println(a);
		// int b=(int)(50L++);
		// ++ cannot be applied to literls

		// boolean happy= 1; not allowed

		// int jacked= 10;
		// int jack= 10;
		// int t= jack++;//11

		// System.out.println(jack);//ans=11
		// System.out.println(jacked+(++jack));//jack here is 12
		// System.out.println(jacked + jack++ );//ans=22
		// System.out.println(jack);//ans=13


		// System.out.println(-10.5%-3);

//		NumericPromotion();

		// insatanceOfTest(2);

		// if(true)
		// 	System.out.println("khaelani");System.out.println("khaelani 2");System.out.println("khaelani");System.out.println("khaelani 2");
		

		String[] names= new String[3];

		for( String name: names){
			System.out.print(name +", ");
		}


	}

	public static void insatanceOfTest(Number num){

		// if(num instanceof String){
		// 	System.out.println(num);
		// }
//		if(num instanceof int){
//			System.out.println(num);
//		}
	}

	public static void NumericPromotion() {
		//Numeric promotions
		short w = 14;
		float x = 13;
		double y = 30;
		var z = w * x / y;

		System.out.println(z);

		int f= (int)44.7;

//		short j+=3;
	}
}