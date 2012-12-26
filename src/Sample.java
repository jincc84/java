/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.io.*;
import java.util.*;

class Sample implements Runnable{
    static String ReadLn(int maxLength){  // utility function to read from stdin,
                                          // Provided by Programming-challenges, edit for style only
        byte line[] = new byte [maxLength];
        int length = 0;
        int input = -1;
        try{
            while (length < maxLength){//Read untill maxlength
                input = System.in.read();
                if ((input < 0) || (input == '\n')) break; //or untill end of line ninput
                line [length++] += input;
            }

            if ((input < 0) && (length == 0)) return null;  // eof
            return new String(line, 0, length);
        }catch (IOException e){
            return null;
        }
    }

    public static void main(String args[])  // entry point from OS
    {
        Sample myWork = new Sample();  // Construct the bootloader
        myWork.run();            // execute
    }

    public void run() {
        new mySample().run();
    }
}
class mySample implements Runnable{
	public void run() {
        int maxLength = 1024;
        String line;
        while ((line = Sample.ReadLn(maxLength)) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] splitLine = line.split("\\s+");
//            int number1 = Integer.valueOf(splitLine[0]);
//            int number2 = Integer.valueOf(splitLine[1]);
//            int maxCycleLength = solve(number1, number2);
//            System.out.println(number1 + " " + number2 + " " + maxCycleLength);
        }
    }
}