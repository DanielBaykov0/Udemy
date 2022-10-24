public class LastDigitChecker {

    public static boolean hasSameLastDigit (int a, int b, int c) {

        if ((a < 10 || a > 1000) || (b < 10 || b > 1000) || (c < 10 || c > 1000)) {
            return false;
        }
        int aDigit = a % 10;
        int bDigit = b % 10;
        int cDigit = c % 10;
        while (a > 0 && b > 0 && c > 0) {
            a /= 10;
            b /= 10;
            c /= 10;
            if (aDigit == bDigit || aDigit == cDigit || bDigit == cDigit) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public static boolean isValid (int a) {
        if (a < 10 || a > 1000) {
            return false;
        }
        else {
            return true;
        }
    }
}
