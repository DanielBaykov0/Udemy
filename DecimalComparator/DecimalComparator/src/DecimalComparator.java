public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(double first,double second) {
        int firstOne = (int) (first * 1000);
        int secondOne = (int) (second * 1000);
            if(firstOne == secondOne) {
            return true;
        }else return false;
    }
}
