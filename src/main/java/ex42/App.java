package ex42;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static class Employee{
        String firstName;
        String lastName;
        int salary;
    }

    public static class recordProcessor {

        static ArrayList<Employee> empArrL; //stores each employee in an arrayList

        //constructor that takes in file as an argument and add each employee to empArrL
        recordProcessor(File file) throws Exception{
            Scanner sc = new Scanner(file);
            this.empArrL = new ArrayList<>();
            String empData;

            while (sc.hasNextLine()) { //keep looping through until we reach end of text file
                empData = sc.nextLine();
                String[] arrOfStr = empData.split(","); //break string up to separate firstName, lastName and salary

                Employee temp = new Employee();
                temp.lastName = arrOfStr[0];
                temp.firstName = arrOfStr[1];
                temp.salary= Integer.parseInt(arrOfStr[2]); //convert salary string to int

                empArrL.add(temp); //add employee to empArrL data member
            }
        }

        public static String getRecordTable(){
            String table = "";
            //print table heading
            table += String.format("Last      First     Salary\n" +
                    "--------------------------\n");
            //print each employees attributes
            for(Employee emp: empArrL){
                table += String.format("%-9s %-9s %d\n", emp.lastName, emp.firstName, emp.salary);
            }
            return table;
        }
    }

    public static void main(String args[]) throws Exception {
        File file = new File("src/main/java/ex42/exercise42_input.txt");

        recordProcessor rp = new recordProcessor(file);
        System.out.println(rp.getRecordTable());
    }
}
