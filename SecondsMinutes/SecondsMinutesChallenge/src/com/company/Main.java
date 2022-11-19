package com.company;

public class Main {

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {

        System.out.println(getDurationString(330, 40));
        System.out.println(getDurationString(80));

    }

    public static String getDurationString(int minutes, int seconds) {
        if ((minutes < 0) || (seconds < 0) || (seconds > 59)) {
            return INVALID_VALUE_MESSAGE;
        }
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;

//        String hoursString = hours + "h";
//        if(hours < 10) {
//            hoursString = "0" + hoursString;
//        }
//        String minutesString = minutes + "m";
//        if(minutes < 10) {
//            minutesString = "0" + minutesString;
//        }
//        String secondsString = seconds + "s";
//        if(seconds < 10) {
//            secondsString = "0" + secondsString;
//        }
        return hours + " h " + remainingMinutes + " m " + seconds + " s";
    }
    public static String getDurationString (int seconds) {
        if(seconds < 0) {
            return INVALID_VALUE_MESSAGE;
        }
        int minutes = seconds / 60;
        int remainingMinutes = seconds % 60;
        return getDurationString(minutes,remainingMinutes);
    }
}
