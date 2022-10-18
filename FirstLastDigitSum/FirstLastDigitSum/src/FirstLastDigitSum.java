public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit (int number) {
        if (number < 0) {
            return -1;
        }
        int firstDigit = 0;
        int lastDigit = 0;
        int n = number;
        lastDigit = n % 10;
        while (n >= 10) {
            n = n / 10;
        }
        firstDigit += n % 10;
        return firstDigit + lastDigit;
    }
}
