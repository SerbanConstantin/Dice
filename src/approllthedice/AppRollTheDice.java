package approllthedice;

import java.util.Arrays;

/*
 * @author Serban Constantin
 */
public class AppRollTheDice {

    public static void main(String[] args) {

        //firstStep();
        //secondStep();
        thirdStep();
    }

    public static void thirdStep() {

        final int nrAttempts = 10000;

        int[][] throwsNr = new int[nrAttempts][2];

        for (int i = 0; i < throwsNr.length; i++) {
            throwsNr[i][0] = rollDice();
            throwsNr[i][1] = rollDice();

        }
        System.out.println("throws : " + Arrays.deepToString(throwsNr));

        double doubles = 0.0, gates = 0.0;
        for (int i = 0; i < throwsNr.length; i++) {
            if (isDouble(throwsNr[1][0], throwsNr[i][1])) {
                doubles++;
            }
            if (isGate(throwsNr[i][0], throwsNr[i][1])) {

                gates++;
            }

        }

        System.out.println("% doubles : " + (doubles * 100) / throwsNr.length + " &");
        System.out.println("% gates : " + (gates * 100) / throwsNr.length + " &");
    }

    public static void secondStep() {

        int zar1 = rollDice(), zar2 = rollDice();
        displayDice(zar1);
        displayDice(zar2);

        System.out.println(isDouble(zar1, zar2) ? " is Double" : " is not Double");
        System.out.println(isGate(zar1, zar2) ? " is Gate" : " is not Gate");
    }

    public static boolean isDouble(int zarA, int zarB) {

        if (zarA == zarB) {
            return true;
        }
        return false;

        // return zarA == zarB ? true : false;
    }

    public static boolean isGate(int zarA, int zarB) {
        /*if (zarA - zarB == 2 || zarA - zarB == -2) {
            return true;

        }
        return false;*/
        return Math.abs(zarA - zarB) == 2 ? true : false;

    }

    public static void firstStep() {

        int zar = rollDice();
        if (isZarValid(zar)) {
            displayDice(zar);
        } else {
            System.out.println("dice: " + zar + " is not valid");
        }

    }

    public static int rollDice() {

        //generates a dice between 1 and 6
        int nZar = generatesDice(1, 6);
        return nZar;

    }

    public static boolean isZarValid(int zar) {
        // return true if zar is valid; false otherwise
        return zar >= 1 && zar <= 6 ? true : false;

    }

    public static void displayDice(int zar) {

        switch (zar) {

            case 1:
                System.out.println("zar 1");
                break;
            case 2:
                System.out.println("zar 2");
                break;
            case 3:
                System.out.println("zar 3");
                break;
            case 4:
                System.out.println("zar 4");
                break;
            case 5:
                System.out.println("zar 5");
                break;
            case 6:
                System.out.println("zar 6");
                break;

            default:
                System.out.println("zar invalid" + zar);

        }

    }

    public static int generatesDice(int n, int m) {

        // genereaza un numar aleator de tip intreg intre n si m, unde n<m => n = numar aleator generat intre [0, m-n)
        if (n > m) {
            int aux = n;
            n = m;
            m = aux;

        }
        int d = n + (int) (Math.random() * (m - n + 1));

        return d;

    }

}
