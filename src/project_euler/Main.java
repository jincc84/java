package project_euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Main {
	private static void problem1() {
		int sum = 0;
		for(int i=0; i<1000; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}

		output(1, sum);
	}

	private static void problem2() {
		int[] number = new int[3];
		number[0] = 1;
		number[1] = 2;
		number[2] = 3;

		int even_sum = 2;
		while(number[2] <= 4000000) {
			if(number[2] % 2 == 0) {
				System.out.print(number[2] + ",");
				even_sum += number[2];
			}

			number[2] = number[0] + number[1];
			number[0] = number[1];
			number[1] = number[2];
		}

		output(2, even_sum);
	}

	private static void problem3() {
		long num = 600851475143L;
		int divide_num = 1;
		int result = 0;

		while(num > divide_num) {
			divide_num++;
			if(num % divide_num == 0) {
				result = divide_num;
				num /= divide_num;
			}
		}

		output(3, result);
	}

	private static void problem4() {
		String number;
		int result = 0;
		for(int i=100; i<=999; i++) {
			for(int j=i; j<=999; j++) {
				number = Integer.toString(i * j);
				for(int k=0; k<number.length(); k++) {
					if(number.charAt(k) == number.charAt(number.length() - k - 1)) {
						if(k + 1 > number.length() - k - 2) {
							result = result < Integer.parseInt(number) ? Integer.parseInt(number) : result;
						} else {
							continue;
						}
					}

					break;
				}
			}
		}

		output(4, result);
	}

	private static void problem5() {
		int result = 0;
		boolean is_true = false;
		while(!is_true) {
			result++;
			is_true = true;
			for(int i=20; i>=1; i--) {
				if(result % i == 0) {
					continue;
				}
				is_true = false;
			}
		}

		output(5, result);
	}

	private static void problem6() {
		int result = 0;
		int sum_of_square = 0;
		int square_of_sum = 0;

		for(int i=1; i<=100; i++) {
			sum_of_square += Math.pow(i, 2);
			square_of_sum += i;
		}

		square_of_sum = (int) Math.pow(square_of_sum, 2);
		result = square_of_sum - sum_of_square;

		output(6, result);
	}

	private static void problem7() {
		int goal = 10001;
		int index = 0;
		int number = 2;
		boolean is_divide = false;

		while(true) {
			is_divide = false;
			for(int i=2; i<number; i++) {
				if(i > number/2) {
					break;
				}

				if(number % i == 0) {
					is_divide = true;
					break;
				}
			}

			if(!is_divide) {
				index++;
			}

			if(index == goal) {
				break;
			}
			number++;
		}

		output(7, number);
	}

	private static void problem8() {
		String digit = getFileString("D:/workspace_java/java/text_files/problem8.txt");

		int number = 1;
		int max_number = 0;
		for(int i=0; i<digit.length() - 5; i++) {
			number = 1;
			for(int j=0; j<5; j++) {
				number *= Integer.parseInt(digit.substring(i + j, i + j + 1));
			}

			if(max_number < number) {
				max_number = number;
			}

		}

		output(8, max_number);
	}

	private static void problem9() {
		int result = 0;
		for(int i=1; i<=1000 && result == 0; i++) {
			for(int j=i+1; j<=1000 && result == 0; j++) {
				for(int k=j+1; k<=1000 && result == 0; k++) {
					if(i + j + k == 1000 && Math.pow(i,2) + Math.pow(j,2) == Math.pow(k,2)) {
						result = i * j * k;
					}
				}
			}
		}

		output(9, result);
	}

	private static void problem10() {
		int number = 2;
		long sum = 0L;
		boolean is_divide = false;

		while(number <= 2000000) {
			is_divide = false;
			for(int i=2; i<number; i++) {
				if(i * 2 > number) {
					break;
				}

				if(number % i == 0) {
					is_divide = true;
					break;
				}
			}

			if(!is_divide) {
				sum += number;
			}

			number++;
		}

		output(10, sum);
	}

	private static void problem11() {
		String source= getFileString("D:/workspace_java/java/text_files/problem11.txt", " ");
		String[] sourceSplit = source.split(" ");
		int[][] matrix = new int[20][20];


		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				matrix[i][j] = Integer.parseInt(sourceSplit[i * 20 + j]);
			}
		}

		long max_product = 0;
		long down_product = 1;
		long right_product = 1;
		long diagonal_product = 1;
		long reverse_diagonal_product = 1;
		int row = 0;
		int column = 0;
		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				down_product = 1;
				right_product = 1;
				diagonal_product = 1;
				reverse_diagonal_product = 1;
				for(int k=0; k<4; k++) {
					// down
					row = i + k < 20 ? i + k : i + k - 20;
					column = j;
					down_product *= matrix[row][column];

					// right
					row = i;
					column = j + k < 20 ? j + k : j + k - 20;
					right_product *= matrix[row][column];

					// diagonal
					row = (i + k < 20 ? i + k : i + k - 20);
					column = (j + k < 20 ? j + k : j + k - 20);
					diagonal_product *= matrix[row][column];

					// reverse diagonal
					row = (i + k < 20 ? i + k : i + k - 20);
					column = (j - k < 0 ? j - k + 20 : j - k);
					reverse_diagonal_product *= matrix[row][column];
				}

				max_product = max_product < down_product ? down_product : max_product;
				max_product = max_product < right_product ? right_product : max_product;
				max_product = max_product < diagonal_product ? diagonal_product : max_product;
				max_product = max_product < reverse_diagonal_product ? reverse_diagonal_product : max_product;
			}
		}

		output(11, max_product);
	}

	private static void problem12() {
		int sequence = 0;
		int triangle_number = 0;
		int divisor = 0;

		while(divisor < 500) {
			divisor = 0;
			sequence++;
			triangle_number += sequence;

			for(int i=1; i<triangle_number; i++) {
				if(i * 2 > triangle_number) {
					break;
				}
				if(triangle_number % i == 0) {
					divisor++;
				}
			}
//			System.out.println("sequence:" + sequence + ", triangle_number:" + triangle_number + ", divisor:" + divisor);
		}

		output(12, triangle_number);

	}

	private static void problem13() {
		int TOTAL_DIGIT = 100;
		int DIGIT_LENGTH = 50;
		String digit = getFileString("D:/workspace_java/java/text_files/problem13.txt");

		ArrayList<String> rows = new ArrayList<String>();
		for(int i=0; i<TOTAL_DIGIT; i++) {
			rows.add(digit.substring(i * DIGIT_LENGTH, (i + 1) * DIGIT_LENGTH));
		}

		String sum = "";
		int cal = 0;
		int part_sum = 0;
		for(int i=DIGIT_LENGTH-1; i>=0; i--) {
			part_sum = 0;
			for(int j=0; j<TOTAL_DIGIT; j++) {
				part_sum += Integer.parseInt(rows.get(j).substring(i, i+1));
			}

			cal += part_sum;
			sum = (cal % 10) + sum;
//
//			System.out.println("part_sum = " + part_sum + ", cal = " + cal + ", sum = " + sum);
			cal = (cal - (cal % 10)) / 10;
		}

		sum = cal + sum;

		output(13, sum.substring(0, 10));
	}

	private static void problem14() {
		int max_terms_no = 0;
		int max_terms = 0;
		int terms = 0;
		long cal_no = 0;
		int no = 0;
		int MAX_NUMBER = 1000000;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=1; i<=MAX_NUMBER; i++) {
			if(map.containsKey(i)) {
//				System.out.println("[continue] no:" + i + ", terms:" + map.get(i) + ", max_terms:" + max_terms_no);
				continue;
			}

			cal_no = i;
			no = i;
			terms = 1;
			while(cal_no != 1) {
				if(cal_no % 2 == 0) {
					cal_no /= 2;
				} else {
					cal_no = 3 * cal_no + 1;
				}

				terms++;
			}

			map.put(no, terms);
//			System.out.println("no:" + no + ", terms:" + terms + ", max_terms:" + max_terms_no);
			while(no <= MAX_NUMBER) {
				no *= 2;
				terms++;
				if(!map.containsKey(no)) {
					if(no <= MAX_NUMBER) {
						map.put(no, terms);
					} else {
						no /= 2;
						terms--;
						break;
					}
				}
			}

			if(max_terms < terms) {
				max_terms = terms;
				max_terms_no = no;
			}
		}

		output(14, max_terms_no);
	}

	private static void problem15() {
		long[][] matrix = new long[21][21];
		for(int i=0; i<=20; i++) {
			for(int j=0; j<=20; j++) {
				if(i - 1 < 0 || j - 1 < 0) {
					matrix[i][j] = 1;
				} else {
					matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
				}

//				if(i == j) {
//					System.out.println("matrix[" + i + "][" + i + "] value : " + matrix[i][i]);
//				}
			}
		}

		output(15, matrix[20][20]);
	}

	// similar problem20
	private static void problem16() {
		String[] result = new String[1024];
		result[0] = "1";
		int max_digits = 0;
		int stat_no = 1024; // 2^10
		int index = 0;
		int unit_result = 0;
		int remain = 0;
		int output = 0;

		for(int time = 0; time < 100; time++) { // total 2^10*100 = 2^1000
			for(int j=0; j<max_digits + 1; j++) {
				result[j] = Integer.toString(Integer.parseInt(result[j]) * stat_no);
			}

			while(result[index] != null) {
				unit_result = Integer.parseInt(result[index]) + remain;
				remain = (unit_result - (unit_result % 10)) / 10;
				result[index] = Integer.toString(unit_result % 10);
				index++;

				if(result[index] == null && remain > 0) {
					result[index] = Integer.toString(remain);
					remain = 0;
				}
			}

			max_digits = index - 1;
			index = 0;
		}

		while(result[index] != null) {
			output += Integer.parseInt(result[index]);
			index++;
		}

		output(16, output);
	}

	private static void problem17() {
		HashMap<Integer, String> typical_word = new HashMap<Integer, String>();
		typical_word.put(1, "one");
		typical_word.put(2, "two");
		typical_word.put(3, "three");
		typical_word.put(4, "four");
		typical_word.put(5, "five");
		typical_word.put(6, "six");
		typical_word.put(7, "seven");
		typical_word.put(8, "eight");
		typical_word.put(9, "nine");
		typical_word.put(10, "ten");
		typical_word.put(11, "eleven");
		typical_word.put(12, "twelve");
		typical_word.put(13, "thirteen");
		typical_word.put(14, "fourteen");
		typical_word.put(15, "fifteen");
		typical_word.put(16, "sixteen");
		typical_word.put(17, "seventeen");
		typical_word.put(18, "eighteen");
		typical_word.put(19, "nineteen");
		typical_word.put(20, "twenty");
		typical_word.put(30, "thirty");
		typical_word.put(40, "forty");
		typical_word.put(50, "fifty");
		typical_word.put(60, "sixty");
		typical_word.put(70, "seventy");
		typical_word.put(80, "eighty");
		typical_word.put(90, "ninety");
		typical_word.put(100, "hundred");
		typical_word.put(1000, "thousand");
		
		int result = 0;
		int no = 0;
		String number_word = "";
		for(int i=1; i<=1000; i++) {
			no = i;
			number_word = "";
			
			if(no == 1000) {
				result += typical_word.get(1).length() +  typical_word.get(1000).length();
//				System.out.println("1000 = " + typical_word.get(1) + typical_word.get(1000));
				continue;
			}
			
			if(no >= 100) {
				result += typical_word.get((no - (no % 100)) / 100).length();
				number_word += typical_word.get((no - (no % 100)) / 100);
				result += typical_word.get(100).length();
				number_word += typical_word.get(100);
				if(no % 100 != 0) {
					result += 3; // and -> 3 more : British usage
					number_word += "and";
				}
				no = no % 100;
			}
			
			if(no >= 10) {
				if(typical_word.containsKey(no)) {
					result += typical_word.get(no).length();
					number_word += typical_word.get(no);
//					System.out.println(i + " = " + number_word);
					continue;
				}
				
				result += typical_word.get(no - (no % 10)).length();
				number_word += typical_word.get(no - (no % 10));
				no = no % 10;
			}
			
			if(no > 0) {
				result += typical_word.get(no).length();
				number_word += typical_word.get(no);
			}
			
//			System.out.println(i + " = " + number_word);
		}
		
		output(17, result);
	}

	private static void problem18() {
		int HEIGHT = 15;
		String source = getFileString("D:/workspace_java/java/text_files/problem18.txt", " ");
		String[] splitSource = source.split(" ");
		int[][] matrixSource = new int[HEIGHT][HEIGHT];
		int count = 1;
		int index = 0;
		int result = 0;
		int preSum = 0;
		int nowSum = 0;
		int now = 0;
		
		for(int i=0; i<HEIGHT; i++) {
			for(int j=0; j<count; j++) {
				now = Integer.parseInt(splitSource[index]);
				matrixSource[i][j] = now;
				if(i - 1 >= 0) {
					preSum = j - 1 >= 0 ? matrixSource[i-1][j-1] : 0;
					nowSum = j + 1 < count ? matrixSource[i-1][j] : 0;
					
//					System.out.println("preSum : " + preSum + ", nowSum : " + nowSum);
					
					now += preSum > nowSum ? preSum : nowSum;
					matrixSource[i][j] = matrixSource[i][j] > now ? matrixSource[i][j] : now;
				}

				index++;
//				System.out.print(matrixSource[i][j] + " ");
			}
			
//			System.out.println("");
			count++;
		}
		
		for(int i=0; i<HEIGHT; i++) {
			result = result < matrixSource[HEIGHT-1][i] ? matrixSource[HEIGHT-1][i] : result;
		}
		
		output(18, result);
	}
	
	private static void problem19() {
		int result = 0;
		int day = 1; // 1:Monday, 2:Tuesday... 6:Saturday, 0:Sunday
		int days = 0;
		for(int year=1900; year<=2000; year++) {
			for(int month=1; month<=12; month++) {
				switch(month) {
				case 2:
					days = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? 29 : 28;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					days = 30;
					break;
				default:
					days = 31;
				}
				
				if(year > 1900 && day % 7 == 0) {
					result++;
//					System.out.println("no." + result + ", year:" + year + ", month:" + month + ", day:" + day);
				}
				day += days;
			}
			day = day % 7;
		}
		
		output(19, result);
	}
	
	// similar problem16
	private static void problem20() {
		String[] result = new String[1024];
		result[0] = "1";
		int max_digits = 0;
		int index = 0;
		int unit_result = 0;
		int remain = 0;
		int output = 0;

		for(int no = 100; no > 1; no--) {
			for(int j=0; j<max_digits + 1; j++) {
				result[j] = Integer.toString(Integer.parseInt(result[j]) * no);
			}

			while(result[index] != null) {
				unit_result = Integer.parseInt(result[index]) + remain;
				remain = (unit_result - (unit_result % 10)) / 10;
				result[index] = Integer.toString(unit_result % 10);
				index++;

				if(result[index] == null && remain > 0) {
					result[index] = Integer.toString(remain);
					remain = 0;
				}
			}

			max_digits = index - 1;
			index = 0;
		}

		while(result[index] != null) {
			output += Integer.parseInt(result[index]);
			index++;
		}

		output(20, output);
	}
	
	private static void problem21() {
		int result = 0;
		int target_no = 0;
		ArrayList<Integer> amicable = new ArrayList<Integer>();
		
		for(int no=1; no<10000; no++) {
			if(amicable.contains(no)) {
				continue;
			}
			target_no = problem21_get_proper_sum(no);
			if(target_no > 10000 || target_no == no) {
				continue;
			}
			if(no == problem21_get_proper_sum(target_no)) {
				amicable.add(no);
				result += no;
//				System.out.println("target_no : " + no);
			}
		}
		
		output(21, result);
	}
	
	private static int problem21_get_proper_sum(int no) {
		int index = 0;
		int sum = 0;
		while(index*2 < no) {
			index++;
			
			if(no % index == 0) {
				sum += index;
			}
		}
		
		return sum;
	} 
	
	private static void problem22() {
		String source = getFileString("D:/workspace_java/java/text_files/problem22.txt");
		source = source.replaceAll("\"", "");
		String[] sourceSplit = source.split(",");
		String temp = null;
		for(int i=0; i<sourceSplit.length-1; i++) {
			for(int j=i+1; j<sourceSplit.length; j++) {
				if(sourceSplit[i].compareTo(sourceSplit[j]) > 0) {
					temp = sourceSplit[i];
					sourceSplit[i] = sourceSplit[j];
					sourceSplit[j] = temp;
				}
			}
		}
		
		long result = 0;
		for(int i=0;i<sourceSplit.length; i++) {
			String name = sourceSplit[i].toUpperCase();
			long row = 0;
			for(int j=0; j<name.length(); j++) {
				row += (name.charAt(j) - 64);
			}
			
//			System.out.println((i+1) + "th name : " + name + "'s score is " + ((i+1) * row));
			result += ((i+1) * row);
		}
		
		output(22, result);
	}
	
	private static void problem67() {
		int HEIGHT = 100;
		String source = getFileString("D:/workspace_java/java/text_files/problem67.txt", " ");
		String[] splitSource = source.split(" ");
		int[][] matrixSource = new int[HEIGHT][HEIGHT];
		int count = 1;
		int index = 0;
		int result = 0;
		int preSum = 0;
		int nowSum = 0;
		int now = 0;
		
		for(int i=0; i<HEIGHT; i++) {
			for(int j=0; j<count; j++) {
				now = Integer.parseInt(splitSource[index]);
				matrixSource[i][j] = now;
				if(i - 1 >= 0) {
					preSum = j - 1 >= 0 ? matrixSource[i-1][j-1] : 0;
					nowSum = j + 1 < count ? matrixSource[i-1][j] : 0;
					
//					System.out.println("preSum : " + preSum + ", nowSum : " + nowSum);
					
					now += preSum > nowSum ? preSum : nowSum;
					matrixSource[i][j] = matrixSource[i][j] > now ? matrixSource[i][j] : now;
				}

				index++;
//				System.out.print(matrixSource[i][j] + " ");
			}
			
//			System.out.println("");
			count++;
		}
		
		for(int i=0; i<HEIGHT; i++) {
			result = result < matrixSource[HEIGHT-1][i] ? matrixSource[HEIGHT-1][i] : result;
		}
		
		output(67, result);
	}
	
	public static void main(String[] args) {
		problem22();
	}

	private static void output(int index, int result) {
		System.out.println("problem" + index + " result : " + result);
	}

	private static void output(int index, long result) {
		System.out.println("problem" + index + " result : " + result);
	}

	private static void output(int index, String result) {
		System.out.println("problem" + index + " result : " + result);
	}

	private static String getFileString(String filePath) {
		return getFileString(filePath, "");
	}
	
	private static String getFileString(String filePath, String endLine) {
		StringBuffer sb = new StringBuffer();
		
		try {
			String read = null;
			File file = new File(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			
			while((read = br.readLine()) != null) {
				sb.append(read + endLine);
			}
			
			if(br != null) {
				br.close();
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return sb.toString();
	}
}
