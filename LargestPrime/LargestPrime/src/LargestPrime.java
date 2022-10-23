public class LargestPrime {

    public static int getLargestPrime (int number) {

        if (number <= 1) {
            return -1;
        }
        int largestPrime = 0;
        int k = 0;
        for (int i = 2; i <= number/2; i++) {
            if (number % i == 0) {
                k = getLargestPrime(i);
                if (k <= i) {
                    largestPrime = k;
                }
                else {
                    largestPrime = i;
                }
                }
        }
        if (largestPrime == 0) {
            largestPrime = number;
        }
        return largestPrime;
    }
}
