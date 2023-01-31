import java.util.Scanner;

public class Question_1_Alt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int integerPartOfNumber = 0;
        int decimalPartOfNumber = 0;

        System.out.println("Input a number");

        String s = input.next();
        String[] tempStorage = new String[1];

        if (!s.contains(".")) s += ".0";

        int decimalCount = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '.') decimalCount++;
        }

        try {
            if (decimalCount > 1) throw new NumberFormatException();

            tempStorage = s.split("[.]");

            integerPartOfNumber = Integer.parseInt(tempStorage[0]);
            decimalPartOfNumber = Integer.parseInt(tempStorage[1]);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input");
            System.exit(0);
        }

        System.out.print(integerPartOfNumber + "." + decimalPartOfNumber + " = " + integerPartOfNumber);

        int numerator = decimalPartOfNumber;
        int denominator = (int) Math.pow(10, tempStorage[1].length());

        //Reduce fraction
        for (int i = denominator / 2; i >= 1; i--) {
            if ((denominator % i == 0) && (numerator % i == 0)) {
                denominator = denominator / i;
                numerator = numerator / i;
            }
        }

        if (numerator != 0) System.out.print(" + " + numerator + "/" + denominator);
        else System.out.print(".0");

    }
}

// Input number
// Separate into Integer and Decimal
// Convert decimal to fraction
// Print answer



// Realized that my previous attempt might not be what you were asking for
// So I did it a different way this time
// One of these is probably right