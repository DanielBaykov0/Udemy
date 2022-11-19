public class Try {

    public static int tryDigit (int a, int b) {

        if ((a < 10 || a > 99) || (b < 10 || b > 99)) {
            return -1;
        }
        while ((a > 0) && (b > 0)) {
            int aDigit = a % 10;
            // 12 % 10 = 2
            a /= 10;
            // 12 / 10 = 1
            int bDigit = b % 10;
            // 23 % 10 = 3
            b /= 10;
            // 23 / 10 = 2
            if ((aDigit == bDigit || aDigit == b) || (a == b || bDigit == a)) {
                // 2 == 3 || 2 == 2 || 1 == 2 || 3 == 1
                return b;
            } else {
                return -1;
            }
        }
            return -1;
}
    }

