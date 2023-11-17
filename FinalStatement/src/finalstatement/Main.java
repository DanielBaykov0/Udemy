package finalstatement;

public class Main {

    public static void main(String[] args) {
	    SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

//        one.instanceNumber = 4;
        System.out.println(Math.PI);
//        Math m = new Math();

        int pw = 674312;
        Password password = new ExtendedPassword(pw);
        password.storedPassword();

        password.letMeIn(1);
        password.letMeIn(523266);
        password.letMeIn(9773);
        password.letMeIn(0);
        password.letMeIn(-1);
        password.letMeIn(674312);

        System.out.println("abstractclasschallenge.bankaccount.banking.bankingdog.binarysearch.bubblesort.complexnumber.company.compositionpc.cylinder.dayoftheweek.deadlock.decimalcomparator.diagonalstar.digitsum.directories.echoclient.echoserver.employees.equaliteprinter.equalsum.evendigitsum.factorprinter.firstlastdigitsum.floor.flourpacker.greatestcommondivisor.inheritanceanimal.innerclasssong.inputcalculator.insertionsort.interpolationsearch.lambdachallenge.lambdas.largestprime.lastdigitchecker.leapyearcalculator.linearsearch.megabytesconverter.minutestoyears.numberinword.numberofdaysinmonth.numberpalindrome.numbertowords.paintjob.perfectnumber.person.playingcat.playlist.point.poolarea.sayhello.selectionsort.shareddigit.simplecalculator.speedconverter.sumodd.teennumberchecker.wallcalculator.Main method called");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("Owner is " + SIBTest.owner);


    }
}
