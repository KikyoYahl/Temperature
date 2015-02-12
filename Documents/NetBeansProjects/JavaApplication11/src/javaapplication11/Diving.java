package javaapplication11;

import java.util.Scanner;
public class Diving {
	public static final int JUDGE_NUMBER=7;
	public static Scanner kbd = new Scanner (System.in);
	public static void main (String [] args){
		double DIF = 0;
		double[] divingscores = new double [JUDGE_NUMBER];
		DIF =  inputValidDegreeOfDifficulty ();
		divingscores =inputAllScores();
		System.out.println("Degree Of Difficulty \t\t" + DIF);
		for( int n = 0; n < JUDGE_NUMBER; n++){
			System.out.println("JUDGE NO." + (n+1) + "\t\t\t" + "Score: " + divingscores[n]);
		}
		System.out.println("Overall Score: \t\t\t" + calculateScore(divingscores, DIF));
	}
	
	public static double  inputValidDegreeOfDifficulty (){
		double dif = 0;
		do{
			System.out.println("Please enter the degree of difficulty between 1.2 to 3.8:");
			dif = kbd.nextDouble();
			if(dif < 1.2 || dif > 3.8)
				System.out.println("Invalid input");
		}while(dif < 1.2 || dif > 3.8);
		return dif;
	}
	public static double[] inputAllScores(){
		double[] amount = new double [JUDGE_NUMBER];
		
		int n = 0;
				while(n < JUDGE_NUMBER){
					amount[n] = inputValidScore();
					n++;
				}
		return amount;
	}
	public static double inputValidScore(){
		double amount=11;
		while (amount<0 | amount>10){
			System.out.println("Please enter a valid score between 0 and 10");
			amount=kbd.nextDouble();
			if(amount<0 | amount>10)
				System.out.println("Invalid input. Please try again.");
			else;
		}
		return amount;
}

	public static double calculateScore(double [] JudgeScore, double DIF){
		double score = 0;
		int MAX = 0 , MIN = 0;
		for (int k = 0; k < JUDGE_NUMBER; k++){
			if(JudgeScore[k] > JudgeScore[MAX])
				MAX = k;
		}
		for (int k = 0; k < JUDGE_NUMBER; k++){
			if(JudgeScore[k] < JudgeScore[MIN])
				MIN = k;
		}
		for (int k = 0; k < JUDGE_NUMBER; k++){
				score += JudgeScore[k];
		}
				score -= MIN+MAX;
				score *= DIF*0.6;
		return score;
	}
}
	