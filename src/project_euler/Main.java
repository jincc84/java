package project_euler;

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
		String digit = "73167176531330624919225119674426574742355349194934" +
							"96983520312774506326239578318016984801869478851843" +
							"85861560789112949495459501737958331952853208805511" +
							"12540698747158523863050715693290963295227443043557" +
							"66896648950445244523161731856403098711121722383113" +
							"62229893423380308135336276614282806444486645238749" +
							"30358907296290491560440772390713810515859307960866" +
							"70172427121883998797908792274921901699720888093776" +
							"65727333001053367881220235421809751254540594752243" +
							"52584907711670556013604839586446706324415722155397" +
							"53697817977846174064955149290862569321978468622482" +
							"83972241375657056057490261407972968652414535100474" +
							"82166370484403199890008895243450658541227588666881" +
							"16427171479924442928230863465674813919123162824586" +
							"17866458359124566529476545682848912883142607690042" +
							"24219022671055626321111109370544217506941658960408" +
							"07198403850962455444362981230987879927244284909188" +
							"84580156166097919133875499200524063689912560717606" +
							"05886116467109405077541002256983155200055935729725" +
							"71636269561882670428252483600823257530420752963450";

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

	private static void problem11_1() {
		String source="0802229738150040007504050778521250779108" +
							"4949994017811857608717409843694804566200" +
							"8149317355791429937140675388300349133665" +
							"5270952304601142692468560132567137023691" +
							"2231167151676389419236542240402866331380" +
							"2447326099034502447533537836842035171250" +
							"3298812864236710263840675954706618386470" +
							"6726206802621220956394396308409166499421" +
							"2455580566739926971778789683148834896372" +
							"2136230975007644204535140061339734313395" +
							"7817532822753167159403800462161409535692" +
							"1639054296353147555888240017542436298557" +
							"8656004835718907054444374460215851541758" +
							"1980816805944769287392138652177704895540" +
							"0452088397359916079757321626267933279866" +
							"8836688757622072034633674655123263935369" +
							"0442167338253911249472180846293240627636" +
							"2069364172302388346299698267598574043616" +
							"2073352978319001743149714886811623570554" +
							"0170547183515469169233486143520189196748";
		int[][] matrix = new int[20][20];


		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				matrix[i][j] = Integer.parseInt(source.substring(i * 20 * 2 + (j * 2), i * 20 * 2 + (j * 2) + 2));
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
					row = (i - k < 0 ? i - k + 20 : i - k);
					column = (j - k < 0 ? j - k + 20 : j - k);
					reverse_diagonal_product *= matrix[row][column];
				}

				if(max_product < down_product ||
						max_product < right_product ||
						max_product < diagonal_product ||
						max_product < reverse_diagonal_product) {
					System.out.println("row:" + i + ", column:" + j);
				}

				max_product = max_product < down_product ? down_product : max_product;
				max_product = max_product < right_product ? right_product : max_product;
				max_product = max_product < diagonal_product ? diagonal_product : max_product;
				max_product = max_product < reverse_diagonal_product ? reverse_diagonal_product : max_product;

				System.out.println("max_product = " + max_product);
			}
		}

		output(11, max_product);
	}

	private static void problem11() {
		String source="0802229738150040007504050778521250779108" +
							"4949994017811857608717409843694804566200" +
							"8149317355791429937140675388300349133665" +
							"5270952304601142692468560132567137023691" +
							"2231167151676389419236542240402866331380" +
							"2447326099034502447533537836842035171250" +
							"3298812864236710263840675954706618386470" +
							"6726206802621220956394396308409166499421" +
							"2455580566739926971778789683148834896372" +
							"2136230975007644204535140061339734313395" +
							"7817532822753167159403800462161409535692" +
							"1639054296353147555888240017542436298557" +
							"8656004835718907054444374460215851541758" +
							"1980816805944769287392138652177704895540" +
							"0452088397359916079757321626267933279866" +
							"8836688757622072034633674655123263935369" +
							"0442167338253911249472180846293240627636" +
							"2069364172302388346299698267598574043616" +
							"2073352978319001743149714886811623570554" +
							"0170547183515469169233486143520189196748";
		int[][] matrix = new int[20][20];


		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				matrix[i][j] = Integer.parseInt(source.substring(i * 20 * 2 + (j * 2), i * 20 * 2 + (j * 2) + 2));
			}
		}

		long max_product = 0;

		output(11, max_product);
	}

	public static void main(String[] args) {
		problem11();
	}

	private static void output(int index, int result) {
		System.out.println("\nproblem" + index + " result : " + result);
	}

	private static void output(int index, long result) {
		System.out.println("\nproblem" + index + " result : " + result);
	}

	private static void output(int index, String result) {
		System.out.println("\nproblem" + index + " result : " + result);
	}
}
