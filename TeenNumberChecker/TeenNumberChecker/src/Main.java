public class Main {

    public static void main(String[] args) {

        boolean tryOne = TeenNumberChecker.hasTeen(56, 76, 13);
        tryOne = TeenNumberChecker.hasTeen(9, 99, 19);
        System.out.println(tryOne);

        tryOne = TeenNumberChecker.hasTeen(23, 15, 42);
        System.out.println(tryOne);

        tryOne = TeenNumberChecker.hasTeen(22, 23, 34);
        System.out.println(tryOne);

        boolean tryTwo = TeenNumberChecker.isTeen(9);
        tryTwo = TeenNumberChecker.isTeen(9);
        System.out.println(tryTwo);

        tryTwo = TeenNumberChecker.isTeen(13);
        System.out.println(tryTwo);
    }
}
