import java.util.Scanner;

public class Question_1 {
    public static void main(String[] args) throws InterruptedException {
        int originalNumerator = 0;
        int originalDenominator = 0;


        int numerator = 0;
        int denominator = 0;

        Scanner input = new Scanner(System.in);

        //Input numbers
        try {
            System.out.println("Enter Numerator:");
            originalNumerator = input.nextInt();

            System.out.println("Enter Denominator:");
            originalDenominator = input.nextInt();
            denominator = originalDenominator;

            //Prevent division by 0
            if (originalDenominator == 0) {
                System.out.println("You Cannot Divide by 0");
                System.exit(0);
            }
            else {
                System.out.println("Calculating...");
            }
        }
        catch (Exception e) {
            System.out.println("Invalid Input");
            System.exit(0);
        }

        //Separate into mixed fraction

        int mixedFractionWholeNumber = originalNumerator / originalDenominator;
        numerator = originalNumerator - mixedFractionWholeNumber * originalDenominator;

        //Reduce fraction
        for (int i = denominator / 2; i >= 1; i--) {
            if ((denominator % i == 0) && (numerator % i == 0)) {
                denominator = denominator / i;
                numerator = numerator / i;
            }
        }

        //Print out answer dramatically
        Thread.sleep(1500);

        System.out.print(originalNumerator + "/" + originalDenominator + " = ");
        if (numerator == 0) System.out.print(mixedFractionWholeNumber);
        else if (mixedFractionWholeNumber == 0) System.out.print(numerator + "/" + denominator);
        else System.out.print(mixedFractionWholeNumber + " + " + numerator + "/" + denominator);
    }
}

// Take a real number as input
// Convert into mixed fraction
// Reduce the fraction as much as possible