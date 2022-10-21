import java.util.Scanner;

public class InputCalculator {

    public static void inputThenPrintSumAndAverage () {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int count = 0;
        long average = 0;

        while (true) {

            boolean isIt = scanner.hasNextInt();
            if (isIt) {
                int number = scanner.nextInt();
                count++;
                sum += number;
                average = Math.round((double)sum / (int)count);
                }
            else {
                System.out.println("SUM = " + sum + " AVG = " + average );
                break;
            }
            scanner.nextLine();
        }
        scanner.close();
    }
}
