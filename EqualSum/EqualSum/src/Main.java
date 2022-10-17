public class Main {

    public static void main(String[] args) {

        boolean tryOne = EqualSumChecker.hasEqualSum(1, 1,1);
        tryOne = EqualSumChecker.hasEqualSum(1, 1, 1);
        System.out.println(tryOne);

        tryOne = EqualSumChecker.hasEqualSum(1, 1, 2);
        System.out.println(tryOne);
    }
}
