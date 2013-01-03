package project_euler;

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

			System.out.println("sequence:" + sequence + ", triangle_number:" + triangle_number + ", divisor:" + divisor);
		}

		output(12, triangle_number);

	}

	private static void problem13() {
		int TOTAL_DIGIT = 100;
		int DIGIT_LENGTH = 50;
		String digit = "37107287533902102798797998220837590246510135740250" +
							"46376937677490009712648124896970078050417018260538" +
							"74324986199524741059474233309513058123726617309629" +
							"91942213363574161572522430563301811072406154908250" +
							"23067588207539346171171980310421047513778063246676" +
							"89261670696623633820136378418383684178734361726757" +
							"28112879812849979408065481931592621691275889832738" +
							"44274228917432520321923589422876796487670272189318" +
							"47451445736001306439091167216856844588711603153276" +
							"70386486105843025439939619828917593665686757934951" +
							"62176457141856560629502157223196586755079324193331" +
							"64906352462741904929101432445813822663347944758178" +
							"92575867718337217661963751590579239728245598838407" +
							"58203565325359399008402633568948830189458628227828" +
							"80181199384826282014278194139940567587151170094390" +
							"35398664372827112653829987240784473053190104293586" +
							"86515506006295864861532075273371959191420517255829" +
							"71693888707715466499115593487603532921714970056938" +
							"54370070576826684624621495650076471787294438377604" +
							"53282654108756828443191190634694037855217779295145" +
							"36123272525000296071075082563815656710885258350721" +
							"45876576172410976447339110607218265236877223636045" +
							"17423706905851860660448207621209813287860733969412" +
							"81142660418086830619328460811191061556940512689692" +
							"51934325451728388641918047049293215058642563049483" +
							"62467221648435076201727918039944693004732956340691" +
							"15732444386908125794514089057706229429197107928209" +
							"55037687525678773091862540744969844508330393682126" +
							"18336384825330154686196124348767681297534375946515" +
							"80386287592878490201521685554828717201219257766954" +
							"78182833757993103614740356856449095527097864797581" +
							"16726320100436897842553539920931837441497806860984" +
							"48403098129077791799088218795327364475675590848030" +
							"87086987551392711854517078544161852424320693150332" +
							"59959406895756536782107074926966537676326235447210" +
							"69793950679652694742597709739166693763042633987085" +
							"41052684708299085211399427365734116182760315001271" +
							"65378607361501080857009149939512557028198746004375" +
							"35829035317434717326932123578154982629742552737307" +
							"94953759765105305946966067683156574377167401875275" +
							"88902802571733229619176668713819931811048770190271" +
							"25267680276078003013678680992525463401061632866526" +
							"36270218540497705585629946580636237993140746255962" +
							"24074486908231174977792365466257246923322810917141" +
							"91430288197103288597806669760892938638285025333403" +
							"34413065578016127815921815005561868836468420090470" +
							"23053081172816430487623791969842487255036638784583" +
							"11487696932154902810424020138335124462181441773470" +
							"63783299490636259666498587618221225225512486764533" +
							"67720186971698544312419572409913959008952310058822" +
							"95548255300263520781532296796249481641953868218774" +
							"76085327132285723110424803456124867697064507995236" +
							"37774242535411291684276865538926205024910326572967" +
							"23701913275725675285653248258265463092207058596522" +
							"29798860272258331913126375147341994889534765745501" +
							"18495701454879288984856827726077713721403798879715" +
							"38298203783031473527721580348144513491373226651381" +
							"34829543829199918180278916522431027392251122869539" +
							"40957953066405232632538044100059654939159879593635" +
							"29746152185502371307642255121183693803580388584903" +
							"41698116222072977186158236678424689157993532961922" +
							"62467957194401269043877107275048102390895523597457" +
							"23189706772547915061505504953922979530901129967519" +
							"86188088225875314529584099251203829009407770775672" +
							"11306739708304724483816533873502340845647058077308" +
							"82959174767140363198008187129011875491310547126581" +
							"97623331044818386269515456334926366572897563400500" +
							"42846280183517070527831839425882145521227251250327" +
							"55121603546981200581762165212827652751691296897789" +
							"32238195734329339946437501907836945765883352399886" +
							"75506164965184775180738168837861091527357929701337" +
							"62177842752192623401942399639168044983993173312731" +
							"32924185707147349566916674687634660915035914677504" +
							"99518671430235219628894890102423325116913619626622" +
							"73267460800591547471830798392868535206946944540724" +
							"76841822524674417161514036427982273348055556214818" +
							"97142617910342598647204516893989422179826088076852" +
							"87783646182799346313767754307809363333018982642090" +
							"10848802521674670883215120185883543223812876952786" +
							"71329612474782464538636993009049310363619763878039" +
							"62184073572399794223406235393808339651327408011116" +
							"66627891981488087797941876876144230030984490851411" +
							"60661826293682836764744779239180335110989069790714" +
							"85786944089552990653640447425576083659976645795096" +
							"66024396409905389607120198219976047599490197230297" +
							"64913982680032973156037120041377903785566085089252" +
							"16730939319872750275468906903707539413042652315011" +
							"94809377245048795150954100921645863754710598436791" +
							"78639167021187492431995700641917969777599028300699" +
							"15368713711936614952811305876380278410754449733078" +
							"40789923115535562561142322423255033685442488917353" +
							"44889911501440648020369068063960672322193204149535" +
							"41503128880339536053299340368006977710650566631954" +
							"81234880673210146739058568557934581403627822703280" +
							"82616570773948327592232845941706525094512325230608" +
							"22918802058777319719839450180888072429661980811197" +
							"77158542502016545090413245809786882778948721859617" +
							"72107838435069186155435662884062257473692284509516" +
							"20849603980134001723930671666823555245252804609722" +
							"53503534226472524250874054075591789781264330331690";

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

	private static void problem16() {

	}

	public static void main(String[] args) {
		problem15();
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
