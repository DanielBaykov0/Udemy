public class DayOfTheWeekChallenge {

    public static void printDayOfTheWeek (int day) {
        day = 8;
//        switch (day) {
//           case 0: case 1: case 2: case 3: case 4: case 5: case 6:
//                System.out.println("Monday, Tuesday, Wednesday, Thursday, Friday, Saturday or Sunday");
//                break;
//            default:
//                System.out.println("Invalid day");
//                break;
//        }
        if(day < 0 || day > 6) {
            System.out.println("Invalid day");
        }else {
            System.out.println("Monday, Tuesday, Wednesday, Thursday, Friday, Saturday or Sunday");
        }


    }
}
