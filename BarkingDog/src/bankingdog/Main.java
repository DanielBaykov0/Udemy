package bankingdog;

public class Main {

    public static void main(String[] args) {

//        bankingdog.BarkingDog.shouldWakeUp(true, 1);
//        boolean wakeUP = true;
//        wakeUP = bankingdog.BarkingDog.shouldWakeUp(true, 1);
//        System.out.println(wakeUP);
//
//        wakeUP = bankingdog.BarkingDog.shouldWakeUp(false, 2);
//        System.out.println(wakeUP);
//
//        wakeUP = bankingdog.BarkingDog.shouldWakeUp(true, 8);
//        System.out.println(wakeUP);
//
//        wakeUP = bankingdog.BarkingDog.shouldWakeUp(true, -1);
//        System.out.println(wakeUP);

                boolean wakeUp = BarkingDog.shouldWakeUp(true, 1);
                System.out.println(wakeUp);

                boolean wakeUp2 = BarkingDog.shouldWakeUp(false, 2);
                System.out.println(wakeUp2);

                boolean wakeUp3 = BarkingDog.shouldWakeUp(true, 8);
                System.out.println(wakeUp3);

                boolean wakeUp4 = BarkingDog.shouldWakeUp(true, -1);
                System.out.println(wakeUp4);



            }
        }

