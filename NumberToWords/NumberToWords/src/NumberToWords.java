public class NumberToWords {

    public static void numberToWords(int number) {
        int reversedNumber = reverse(number);
        int digitCount = getDigitCount(number);

        if (number < 0) {
            System.out.println("Invalid Value");
        }
        else if (number == 0) {
            System.out.println("Zero");
        }
        while (reversedNumber > 0) {
            int lastDigit = reversedNumber % 10;

            switch (lastDigit) {
                case 0:
                    System.out.println("Zero");
                    reversedNumber /= 10;
                    digitCount--;
                    break;
                case 1:
                    System.out.println("One");
                    reversedNumber /= 10;
                    digitCount--;
                    break;
                case 2:
                    System.out.println("Two");
                    reversedNumber /= 10;
                    digitCount--;
                    break;
                case 3:
                    System.out.println("Three");
                    reversedNumber /= 10;
                    digitCount--;
                    break;
                case 4:
                    System.out.println("Four");
                    reversedNumber /= 10;
                    digitCount--;
                    break;
                case 5:
                    System.out.println("Five");
                    reversedNumber /= 10;
                    digitCount--;
                    break;
                case 6:
                    System.out.println("Six");
                    reversedNumber /= 10;
                    digitCount--;
                    break;

                case 7:
                    System.out.println("Seven");
                    reversedNumber /= 10;
                    digitCount--;
                    break;
                case 8:
                    System.out.println("Eight");
                    reversedNumber /= 10;
                    digitCount--;
                    break;
                case 9:
                    System.out.println("Nine");
                    reversedNumber /= 10;
                    digitCount--;
                    break;
            }
        }
        if (number != 0) {
            for (int i = 1; i <= digitCount; i++) {
                System.out.println("Zero");
            }
        }
    }
    public static int reverse (int reversedNumber) {
        int reversed = 0;
        for (; reversedNumber != 0; reversedNumber /= 10 ) {
            // 123 / 10 = 12
            int lastDigit = reversedNumber % 10;
            // 123 % 10 = 3
            reversed = (reversed * 10) + lastDigit;
        }
        return reversed;
    }
    public static int getDigitCount (int number) {
        if (number < 0) {
            return -1;
        }
        else if (number == 0) {
            return 1;
        }
        int count = 0;
        for (; number != 0; number /= 10) {
            count++;
        }
        return count;
    }

}
