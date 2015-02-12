package javaapplication13;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Qinghui
 */

import java.util.Scanner;
public class Temperature {
        public static final int MONTHS = 12;
        public static final int TEMP = 2;
        public static void main(String[] args) {
		int [][] test2DArray = inputTempForYear();
		int HighestTemp = findHighestTemp(test2DArray);
		int LowestTemp = findLowestTemp(test2DArray);
		double AverageHigh = calculateAverageHigh(test2DArray);
		double AverageLow = calculateAverageLow(test2DArray);
		System.out.println("Average High Temperature is: " + AverageHigh);
		System.out.println("Average Low Temperature is: " + AverageLow);
		System.out.println("The Highest Temperature of The Year is: " + HighestTemp);
		System.out.println("The Lowest Temperature of The Year is: " + LowestTemp);
	}
	
	//method inputTempForMonth, input: high and low (array) and month, no return value
	public static void inputTempForMonth(int mth, int tempHi, int tempLow, int[][] array)
	{
		array[mth][0] = tempHi; //this will be high temperature
		array[mth][1] = tempLow; //this will be low temperature
	}

	//method inputTempForYear, no input, return a multidimensional array
	public static int[][] inputTempForYear()
	{
		int[][] calendarTemps = new int[MONTHS][TEMP]; //initiate 2D array
        int i,mth = 0; //declare temporary variables
		
       Scanner keyboard = new Scanner(System.in);
       
       //start at 0, actual month will be off by 1
       for (i=0;i<calendarTemps.length;i++)
       {
       	System.out.println("Please input high temperature for month " +  (mth+1) + ":");
   		int tempHi = keyboard.nextInt();
       	System.out.println("Please input low temperature for month " +  (mth+1) + ":");
   		int tempLow = keyboard.nextInt();
       	
   		inputTempForMonth(i, tempHi, tempLow, calendarTemps);
   		
   		mth++;
       }   	
		return calendarTemps;
	}

	//method calculateAverageHigh, input array temp, return average high temp for the year
	public static double calculateAverageHigh(int[][] array)
	{
		double avgHigh = 0;	
		int tempHigh = 0;
		int sumHigh =0;
		
		for (int i = 0; i<array.length;i++ )
		{
			tempHigh = array[i][0];
			sumHigh = sumHigh + tempHigh;
			
		}
		avgHigh = sumHigh/12;
		return avgHigh;
	}

	//method calculateAverageLow, input array temp, return average low temp for the year
	public static double calculateAverageLow(int[][] array)
	{
		double avgLow = 0;	
		int tempLow = 0;
		int sumLow =0;
		
		for (int i = 0; i<array.length;i++ )
		{
			tempLow = array[i][1];
			sumLow = sumLow + tempLow;
		}
		avgLow = sumLow/12;		
		return avgLow;
	}

	//method findHighestTemp, return index value of highest temp, input array temp
	public static int findHighestTemp(int[][] array)
	{
		int maxValue = 0;
		
		for (int i = 0; i<array.length;i++ )
		{
	        if (array[i][0] > maxValue) 
	        {
	            maxValue = array[i][0];
	        }
		}
	
		return maxValue;
	}

	//method findLowestTemp, return index value of the lowest temp, input array temp
	public static int findLowestTemp(int[][] array)
	{
		int minValue = 0;

		for (int i = 0; i<array.length;i++ )
		{
	        if (array[i][1] < minValue) 
	        {
	            minValue = array[i][1];
	        }
		}
	
		return minValue;
	}
	

	

	

	

}