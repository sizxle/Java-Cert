package com.cert.play;

import java.util.*;

public class PlayGround{
	
	public static void main(String[] args){


		// int[] names= new int[3];// gets 0, if its a string it gets null.. array values get initialized??

		// for( int name: names){
		// 	System.out.print(name +", ");
		// }


// //optional label
// 		CLEANING : for(char stables='a'; stables<'e';stables++){
// 			for(int leopard=1;leopard<4;leopard++){
// 				if(stables=='b' || leopard==2){
// 					continue CLEANING;
// 				}
// 				System.out.println("Cleaning: "+ stables+" "+leopard);
// 			}
// 		}

///
		// int checkDate = 0;
		// while(checkDate<10) {
		// 	checkDate++;
		// 	if(checkDate>100) {
		// 	break;
		// 	checkDate++; // DOES NOT COMPILE
		// 	}
		// }


		//forloop with datatype of object

		// List<Integer> list = new ArrayList<>();

		// list.add(10);
		// list.add(23);
		// for(Object k : list){
		// 	continue;
		// 	System.out.println(k);
		// }

		// crazy example
		// int temperature =(int) 4.5;
		// long humidity = -temperature + temperature * 3;
		// if (temperature>=4)
		// if (humidity < 6) System.out.println("Too Low");
		// else System.out.println("Just Right");
		// else System.out.println("Too High");

		Number time = Integer.valueOf(6);

		if(time instanceof Float ){
			System.out.println(time);
		}
	}
}