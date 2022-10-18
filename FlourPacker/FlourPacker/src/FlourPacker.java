public class FlourPacker {

    public static boolean canPack (int bigCount, int smallCount, int goal) {

        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }
        int big = bigCount * 5;
        int sum = (big + smallCount);

        if (sum < goal) {
            return false;
        }
        else if (goal % 5 <= smallCount) {
            return true;
        }
        else {
            return false;
        }
    }
}
