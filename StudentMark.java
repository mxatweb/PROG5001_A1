
/**
 * Program to manage student marks.
 *
 * @author Martin Atwebembire
 * @version 0.1(08.09.2022)
 */

import java.util.*;
import java.text.*;

public class StudentMark {
    private static String unit_name;
    // private static int student_mark;
    // private static boolean run = true;
    private static String menu_option;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private static String[] students = new String[25];
    private static double[] marks = new double[25];

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("MAIN MENU");
        System.out.println("1) Enter Unit Name");
        System.out.println("2) Enter Student Marks");
        System.out.println("3) Display Highest and Lowest Mark");
        System.out.println("4) Display Mean and Standard Deviation");
        System.out.println("5) Exit.");
        System.out.println();
        System.out.print("> Select a menu option to continue: ");
        getMenuOption();

    }

    public static void getMenuOption() {
        menu_option = in.nextLine().trim();

        if (menu_option.equals("1")) {
            getUnitName();
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();
        }
        if (menu_option.equals("2")) {
            getStudentMarks();
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();
        }
        if (menu_option.equals("3")) {
            displayHighestLowestMarks();
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();
        }
        if (menu_option.equals("4")) {
            displayMeanStD();
            System.out.print("> Select a menu option to continue: ");
            getMenuOption();
        }
        if (menu_option.equals("5")) {
            System.out.print("Program exited...goodbye!");
            System.exit(0);
        }
    }

    /*
     * F1: Allow users to input the unit name
     */
    public static void getUnitName() {
        System.out.print("> Please enter the unit name.");
        unit_name = in.nextLine();
        System.out.println("Unit Name: " + unit_name + " saved successfully!");
    }

    /*
     * F2: Allow users to input the students’ name and mark.
     */
    public static void getStudentMarks() {

        int i = 0;

        while (i < 25) {
            System.out.print("> Please enter student marks.e.g Peter Parker,75 (fullname,mark): ");
            String[] input = in.nextLine().split(",", 2);
            String student_name = input[0].trim();
            String student_mark = input[1].trim();

            boolean valid = validateStudentMarks(student_mark);

            /*
             * F3: Report invalid input by showing an error message on the screen before
             * allowing users to re-enter the mark.
             */
            if (valid) {
                // add to array
                students[i] = student_name;
                marks[i] = Double.parseDouble(student_mark);
                i++;
            } else {
                System.out.println("Invalid input! Only numbers between 0 and 100 are valid");
            }
        }
        printSummaryOfStudentMarks(); // print summary of user input i.e unit name, student name and mark

    }

    /*
     * F3: Validate user input.
     */
    public static boolean validateStudentMarks(String m) {

        try {
            double mark = Double.parseDouble(m);

            // A valid mark is any number between 0 and 100.
            if (mark < 0 || mark > 100) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*
     * F4: Print the unit name followed by the students’ marks after users have
     * finished entering the marks.
     */
    public static void printSummaryOfStudentMarks() {
        System.out.println("----------------------------");
        System.out.println("Unit Name: " + unit_name);
        System.out.println("----------------------------");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Student Name: " + students[i] + "," + " Marks: " + marks[i]);
        }
        System.out.println("----------------------------");
    }

    /*
     * F5: Find the highest mark and the lowest mark and print the result on the
     * screen (Algorithm 1)
     */
    public static void displayHighestLowestMarks() {

        /*
         * Find Highest Mark
         */
        double high_mark = marks[0];
        // int high_mark_index = 0;
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > high_mark) {
                high_mark = marks[i];
                // high_mark_index = i;
            }
        }
        /*
         * Find Lowest Mark
         */
        double low_mark = marks[0];
        // int low_mark_index = 0;
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < low_mark) {
                low_mark = marks[i];
                // low_mark_index = i;
            }
        }

        /*
         * Print Summary of Highest/Lowest Mark
         */
        System.out.println("----------------------------");
        System.out.println("Highest and Lowest Marks");
        System.out.println("----------------------------");
        System.out.println("Highest Mark: " + high_mark);
        System.out.println("Lowest Mark: " + low_mark);
        System.out.println("----------------------------");
    }

    /*
     * F6: Calculate the mean and standard deviation of the marks and print the
     * result on the screen (Algorithm 2)
     */
    public static void displayMeanStD() {

        double mean = 0;
        double sum = 0;
        double stdev = 0.0;

        /*
         * Calculate mean mark
         */
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        mean = sum / marks.length;

        /*
         * Calculate Standard Deviation
         * Square root of [(sum(Xi - mean)^2)/sample size]
         */
        sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += Math.pow(marks[i] - mean, 2); // sum of (every mark minus its mean)^2
        }
        stdev = Math.sqrt(sum / (marks.length - 1));

        /*
         * Print Mean and Standard Deviation
         */
        System.out.println("----------------------------");
        System.out.println("Mean and Standard Deviation");
        System.out.println("----------------------------");
        System.out.println("Mean Mark: " + mean);
        System.out.println("Standard Deviation: " + df.format(stdev));
        System.out.println("----------------------------");
    }
}
