import java.util.Scanner;
public class Task {
    public static void main(String[] args) {
        //sets the number both methods are converting
        int num = (int)Math.round(Math.random()*99);
        String binary = "";
        int i = 0;
        int ans = 0;
        System.out.println("Decimal (" + num + ") to Binary Conversion:");
        binary = methodTwo(num, binary);
        //removes the brackets and commas from the arraylist when printing, and sets the result to a single int.
        int binNumber = Integer.valueOf(binary);
        System.out.println(binNumber);
        System.out.println("Binary (" + binNumber + ") to Decimal Conversion:");
        int decNumber = methodOne(binNumber, i, ans);
        System.out.println(decNumber);
    }
    public static int methodOne(int num, int i, int ans) {
        //accepts binary (1 or 0) number as string and converts it to base-10(decimal, 0-9) number as an int
        //binary to decimal
        if (num == 0){
            //returns decimal once num = 0
            return ans;
        }
        else {
            //adds result to ans in the right order.
            //gets remainder of num before multiplying it by the power of 2, with an exponent of i(starts at 0, increases by 1 each time)
            //ex. (11000 % 10 = 0 (1100 still exists, just not currently in use), 0 * 2,i = 0, adds to ans.) continues until num = 0.
            ans = ((num%10)*(int)Math.pow(2, i))+ans;
            //divides binary number by 10, returns ans until num = 0.
            return methodOne(num/10, i+1, ans);
            //problem I had was that i++ wouldn't work. i+1 works.
        }
    }
    public static String methodTwo(int num, String bin){
        //accepts decimals (any numbers from 0-9) numbers as an int and converts it to binary as
        //a string
        //decimal to binary
        if (num == 0){
            //returns string once the number reaches 0
            return bin;
        }
        else {
            //adds binary number to existing string in the right order
            bin = String.valueOf(num%2) + bin;
            //divides number before running through the method again, adding binary numbers to string until the number = 0
            return methodTwo(num/2, bin);
        }
    }
    //sources - https://www.geeksforgeeks.org/decimal-binary-number-using-recursion/
    //https://www.geeksforgeeks.org/binary-to-decimal-conversion-in-java/
    //https://stackoverflow.com/questions/32774059/output-arraylist-to-string-without-brackets-appearing
    //https://sentry.io/answers/how-do-i-convert-a-string-to-an-int-in-java/
    //testng: Cross reference with online sources that list the conversions,
    //printing throughout conversion process to follow what's happening, and to make sure it's converting properly

}