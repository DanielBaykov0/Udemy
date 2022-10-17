public class EvenDigitSum {

    public static int getEvenDigitSum (int number) {
        if (number < 0) {
            return -1;
        }
        int sum = 0;
        int remainder = 0;
        while (number != 0) {
            remainder = number % 10;
            if (remainder % 2 == 0) {
                sum = sum + remainder;
            }
            number = number / 10;
        }
        return sum;
    }
}
