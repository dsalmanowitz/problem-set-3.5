/**
 * INSTRUCTIONS.
 * 
 * The following exercises are, perhaps, more mathematically inclined than previous
 * problem sets. While they might be challenging, they are certainly doable.
 * 
 * You can (and should!) solve each of them using only the operators, conditional control
 * structures, and iterative control structures we've covered. You are not permitted to use
 * recursive code in your solutions.
 * 
 * Please be mindful of the expected outputs, as your code will be tested against that
 * directly. If you're unsure, please ask for clarification.
 * 
 * This problem set is worth 25 points and is due no later than 11:59pm on October 28, 2018.
 */

public class ProblemSet3_5 {
	
	public static void main(String[] args) {
		ProblemSet3_5 ps = new ProblemSet3_5();
		
		// test your solutions here
		
		//ps.primes(1, 1000);
		//ps.leapYears(3);
		ps.palindromicNumbers(55);
		//ps.fibonacci(23);;
		//ps.multiples(2, 3, 40);
	}
	
	/**
	 * How many prime numbers are there between @start and @end, where @start and @end
	 * are positive integers in the range [1, @Integer.MAX_VALUE]?
	 * 
	 * Print your solution in the following formats: "There is X prime number."
	 *                                               "There are X prime numbers."
	 * 
	 * @param start
	 * @param end
	 */
	
	public boolean isPrime(int n) {
		int rem = 1;
		int num = n - 1;
		while (num > 1 && rem != 0) {
			rem = n % num;
			num--;
		}
		if (rem == 0 && n > 1 || n <= 1) {
			return false;
		} else {
			return true;
		}
	}
	
	public void primes(int start, int end) {
		int count = 0;
		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		if (count == 1) {
			System.out.println("There is " + count + " prime number.");
		} else {
			System.out.println("There are " + count + " prime numbers.");
		}
	}
	
	/**
	 * What are the next @count leap years?
	 * 
	 * Print your solution in the following formats: "The next leap year is X."
	 *                                               "The next 2 leap years are X and Y."
	 *                                               "THe next N leap years are A, ..., X, Y, and Z."
	 * 
	 * @param count
	 */
	
	public void leapYears(int count) {
		int year = 2016;
		int i = 0;
		if (count == 1) {
			System.out.println("The next leap year is 2020.");
		} else if (count == 2) {
			System.out.print("The next 2 leap years are 2020 and 2024.");
		} else {
			System.out.print("The next " + count + " leap years are ");
			while (i < count) {
				year += 4;
				if (year % 400 == 0) {
					i++;
					if (i != count) {
						System.out.println(year + ", ");
					} else {
						System.out.println("and " + year + ".");
					}
				} else if (year % 100 != 0 && year % 4 == 0) {
					i++;
					if (i != count) {
						System.out.print(year + ", ");
					} else {
						System.out.println("and " + year + ".");
					}
				}
			}
		}
	}
	
	/**
	 * Is @number a palindromic number?
	 * 
	 * Print your solution in the following formats: "X is a palindromic number."
	 *                                               "X is not a palindromic number."
	 *                                               
	 * @param number
	 */
	
	public void palindromicNumbers(int number) {
		double reverse = 0;
		int numDigits = 1;
		for (int i = 10; number / i > 0; i *= 10) {
			numDigits += 1;
		}
		for (int j = numDigits; j > 1; j--) {
			reverse = reverse * 10 + (number % Math.pow(10, (double)j - 1));
			System.out.println(reverse);
		}
		
		if (reverse == number) {
			System.out.println(number + " is a palindromic number.");
		} else {
			System.out.print(number + " is not a palindromic number.");
		}
	}
	
	/**
	 * What is the @nth Fibonacci number, where @n is a positive integer?
	 * 
	 * Print your solution in the following formats: "The 21st Fibonacci number is X."
	 *                                               "The 22nd Fibonacci number is X."
	 *                                               "The 23rd Fibonacci number is X."
	 *                                               "The 24th Fibonacci number is X."
	 *                                               
	 * @param n
	 */
	
	public void fibonacci(int n) {
		int number = n;
		int i = 0;
		int j = 1;
		int k = 0;
		while (n > 0) {
			k = i + j;
			i = j;
			j = k;
			n--;
		}
		 if (number > 10 && number < 20) {
			 System.out.println("The " + number + "th Fibonacci number is " + k + ".");
		} else if (number % 10 == 1) {
			System.out.println("The " + number + "st Fibonacci number is " + k + ".");
		} else if (number % 10 == 2) {
			System.out.println("The " + number + "nd Fibonacci number is " + k + ".");
		} else if (number % 10 == 3) {
			System.out.println("The " + number + "rd Fibonacci number is " + k + ".");
		} else {
			System.out.println("The " + number + "th Fibonacci number is " + k + ".");
		}
	}
	
	/**
	 * What is the sum of all multiples of @x and @y less than @limit, where @x, @y, and
	 * @limit are positive integers?
	 * 
	 * Print your solution in the following format: "The sum of all multiples of X and Y less than LIMIT is Z."
	 * 
	 * @param limit
	 */
	
	public void multiples(int x, int y, int limit) {
		int a = x;
		int b = y;
		int sum = 0;
		while (x < limit) {
			sum += x;
			x += a;
		}
		while (y < limit) {
			if (y % a != 0) {
				sum += y;
			}
			y += b;
		}
		System.out.println("The sum of all multiples of " + a + " and " + b + " less than " + limit + " is " + sum + ".");
	}
}
