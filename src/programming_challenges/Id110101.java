package programming_challenges;
class Id110101 implements Runnable{
	public void run() {
        int maxLength = 1024;
        String line;
        while ((line = Main.ReadLn(maxLength)) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] splitLine = line.split("\\s+");
            int number1 = Integer.valueOf(splitLine[0]);
            int number2 = Integer.valueOf(splitLine[1]);
            int maxCycleLength = solve(number1, number2);
            System.out.println(number1 + " " + number2 + " " + maxCycleLength);
        }
    }

    public static int solve(int number1, int number2) {
        int start;
        int end;
        if (number1 < number2) {
            start = number1;
            end = number2;
        } else {
            start = number2;
            end = number1;
        }
        int maxCycleLength = -1;
        for (int i = start; i <= end; i++) {
            int result = solve(i);
            if (result > maxCycleLength) {
                maxCycleLength = result;
            }
        }
        return maxCycleLength;
    }

    public static int solve(int number) {
        int cycleLength = 1;
        while (number != 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number = number * 3 + 1;
            }
            cycleLength++;
        }
        return cycleLength;
    }
    /*public void run(){
        	// Your program here

        }*/

    // You can insert more classes here if you want.
}