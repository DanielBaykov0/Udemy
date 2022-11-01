public class NumberPalindrome {

    public static boolean isPalindrome (int number) {
        if (number < 0) {
            number *= -1;
        }
        int reverse = 0;
        int n = number;
        while (n > 0) {
            int lastDigit = n % 10;
            reverse = (reverse * 10) + lastDigit;
            n = n / 10;
        }
        if (number == reverse) {
            return true;
        }
        else{
            return false;
        }
    }
}
