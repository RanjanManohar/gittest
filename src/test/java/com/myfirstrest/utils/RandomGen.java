package com.myfirstrest.utils;

import java.util.Random;

public class RandomGen {
	
	public static String GetRandomNo() {
	
	Random rand = new Random();
	
	 int rand_int1 = rand.nextInt(10000);
	 
	 return Integer.toString(rand_int1);
	
	}

}
