package excercise1.listingprimeandnumberchecking;

import java.util.Scanner;

public class ListingPrimeAndNumberChecking {

	public static int count=0,i=1;
	public static int primeOrNot(int num)
	{
		if(i<=num)
		{
		   if(num%i==0)
		   {
		        count++;                
		   }
		  i++;
		  primeOrNot(num);
		}
	     return count;
	}


    public static void listPrimeNumbers() {
		int isPrime;
		for(int j=1;j<=100;j++) {
			isPrime = primeOrNot(j);
			if(isPrime==2){
				System.out.print(j+" ");
			}
			count = 0;
			i = 1;
		}
	}
	
	public static int countDigits(int num) {
		int counter = 0;
		
		while(num!=0) {
			counter++;
			num/=10;
		}
		return counter;
	}
	
	public static boolean isArmstrong(int number) {
		int rev = 0;
		int num = number;
		int digitCount = countDigits(number);
		
		while(num!=0) {
			rev += Math.pow((num%10), digitCount);
			num/=10;
		}
		
		if(number==rev) {
			return true;
		}
		return false;
		
	}
	
	public static boolean isPalindrome(int number) {
		int num = number;
		
		int rev = 0;
		
		while(number!=0) {
			rev*=10;
			rev += (number%10);
			number/=10;
		}

		if(rev == num) {
			return true;
		}
		return false;
	}
	
	public static boolean isPerfect(int num) {
		int sum = 0,i=1;
		while(i<num) {
			if(num%i==0) {
				sum+=i;
			}
			i++;
		}
		
		if(sum==num) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int number;
		
		System.out.println("Printing the list of 100 prime numbers");
		listPrimeNumbers();
		
		System.out.println("\nEnter the number : ");
		number = s.nextInt();
		if(isArmstrong(number)) {
			System.out.println("The given number is an armstrong number");
		}
		if(isPerfect(number)) {
			System.out.println("The given number is a prefect number");
		}
		if(isPalindrome(number)) {
			System.out.println("The given number is a palindrome");
		}
		if(isArmstrong(number)==false && isPerfect(number)==false && isPalindrome(number)==false) {
			System.out.println("The neither armstrong number nor perfect number or palindrome");
		}
		
		s.close();
	}
}
