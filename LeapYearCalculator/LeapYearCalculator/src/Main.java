public class Main {

    public static void main(String[] args) {

        LeapYearCalculator.isLeapYear(-1600);
        boolean tryYear = true;
        tryYear = LeapYearCalculator.isLeapYear(-1600);
        System.out.println(tryYear);

        tryYear = LeapYearCalculator.isLeapYear(1600);
        System.out.println(tryYear);

        tryYear = LeapYearCalculator.isLeapYear(2017);
        System.out.println(tryYear);

        tryYear = LeapYearCalculator.isLeapYear(2000);
        System.out.println(tryYear);
    }
}
