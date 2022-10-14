public class Main {

    public static void main(String[] args) {

        boolean tryone = DecimalComparator.areEqualByThreeDecimalPlaces(1.236, 1.2365);
        tryone = DecimalComparator.areEqualByThreeDecimalPlaces(3.175, 3.176);
        System.out.println(tryone);
    }
}
