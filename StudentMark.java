
/**
 * Program to manage student marks.
 *
 * @author Martin Atwebembire
 * @version 0.1(08.09.2022)
 */

import java.util.*;
public class StudentMark
{
    private static String unit_name;
    private static int student_mark;
    
    public static void main (String[] args){
        System.out.println("Welcome to the Student Marks Manager Program.");
        System.out.println("1: Enter Unit Name.");
        System.out.println("2: Enter Student Marks.");
        System.out.println("3: Display Highest and Lowest Mark.");
        System.out.println("4: Display Mean and Standard Deviation.");
        System.out.println("5: Exit.");
        getInput();
        
    }
    
    /**
     *  F1: Allow users to input the unit name
     *  F2: Allow users to input the students’ marks.
     */
    public static void getInput(){
          Scanner in = new Scanner(System.in);
          String input = in.nextLine();
          switch(input){
              case "1":
                  System.out.println("Please enter the unit name. e.g PROG5001");
                  unit_name = in.nextLine();
                  break;
              case "2":
                  
                  break;
              case "3":
                  break;
              case "4":
                  break;
              case "5":
                  System.out.println("Goodbye");
                  System.exit(0);
                  break;
                }
          
        
    }
}
