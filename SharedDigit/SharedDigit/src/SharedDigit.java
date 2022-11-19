public class SharedDigit {

    public static boolean hasSharedDigit(int a, int b) {

        if ((a < 10 || a > 99) || (b < 10 || b > 99)) {
            return false;
        }
        while ((a > 0) && (b > 0)) {
            int aDigit = a % 10;
            // 12 % 10 = 2
            a /= 10;
            // 12 / 10 = 1,2
            int bDigit = b % 10;
            // 23 % 10 = 3
            b /= 10;
            // 23 / 10 = 2,3
            if ((aDigit == bDigit || aDigit == b) || (a == b || bDigit == a)) {
                // 2 == 3 || 2 == 2,3 || 1,2 == 2,3 || 3 == 1,2
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
