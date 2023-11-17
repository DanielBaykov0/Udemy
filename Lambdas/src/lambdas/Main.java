package lambdas;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        new Thread(() -> {
//            System.out.println("printing from the runnable");
//            System.out.println("Line 2");
//            System.out.printf("This is line %d\n", 3);
//        }).start();
//
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

//        for (employees.lambdas.Employee employee: employees) {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        }

//        System.out.println("********************************************");
//        for (int i = 0; i < employees.size(); i++) {
//            employees.lambdas.Employee employee = employees.get(i);
//            System.out.println(employee.getName());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }
//
////        Collections.sort(employees, new Comparator<employees.lambdas.Employee>() {
////            @Override
////            public int compare(employees.lambdas.Employee employee1, employees.lambdas.Employee employee2) {
////                return employee1.getName().compareTo(employee2.getName());
////            }
////        });
//
//        Collections.sort(employees, (employee1,  employee2) ->
//                employee1.getName().compareTo(employee2.getName()));
//
//        for (employees.lambdas.Employee employee : employees) {
//            System.out.println(employee.getName());
//        }
//
////        String sillyString = doStringStuff(new lambdas.UpperConcat() {
////            @Override
////            public String upperAndConcat(String s1, String s2) {
////                return s1.toUpperCase() + s2.toUpperCase();
////            }
////        },
////                employees.get(0).getName(), employees.get(1).getName());
////        System.out.println(sillyString);
//
//        lambdas.UpperConcat uc = (s1, s2) -> {
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
//
//        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);
//
//        lambdas.AnotherClass anotherClass = new lambdas.AnotherClass();
//        String s = anotherClass.doSomething();
//        System.out.println(s);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {

    public String doSomething() {
//        lambdas.UpperConcat uc = (s1, s2) -> {
//            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
        int i = 0;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
            System.out.println("i in the lambda expressios = " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };


//        lambdas.UpperConcat uc = new lambdas.UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("i (within anonymous class) = " + i);
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        };

        System.out.println("The lambdas.AnotherClass's name is " + getClass().getSimpleName());

//            i++;
//        System.out.println("i = " + i);
        return Main.doStringStuff(uc, "String1", "String2");


//        System.out.println("The lambdas.AnotherClass class's name is: " + getClass().getSimpleName());
//        return abstractclasschallenge.bankaccount.banking.bankingdog.binarysearch.bubblesort.complexnumber.company.compositionpc.cylinder.dayoftheweek.deadlock.decimalcomparator.diagonalstar.digitsum.directories.echoclient.echoserver.employees.equaliteprinter.equalsum.evendigitsum.factorprinter.firstlastdigitsum.floor.flourpacker.greatestcommondivisor.inheritanceanimal.innerclasssong.inputcalculator.insertionsort.interpolationsearch.lambdachallenge.lambdas.largestprime.lastdigitchecker.leapyearcalculator.linearsearch.megabytesconverter.minutestoyears.numberinword.numberofdaysinmonth.numberpalindrome.numbertowords.paintjob.perfectnumber.person.playingcat.playlist.point.poolarea.sayhello.selectionsort.shareddigit.simplecalculator.speedconverter.sumodd.teennumberchecker.wallcalculator.Main.doStringStuff(new lambdas.UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is: " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1", "String2");
    }

    public void printValue() {
        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The value is " + number);
        };

        new Thread(r).start();
    }
}