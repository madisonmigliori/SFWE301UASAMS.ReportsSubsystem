import java.io.BufferedReader;  
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;  

public class ScholarshipReports {  
   public static void main(String[] args) { 

      // CSV separator variables
      String line = "";  
      String splitBy = ",";  

      // report category choice variable
      int reportChoice = 0; 

      // specified report category choice variable
      int ratio = 0; 

      try {   
         
         // parsing a CSV file into BufferedReader class constructor
         BufferedReader br = new BufferedReader(new FileReader("Report Formatting - Scholarship Report.csv")); 
         
         // title
         System.out.println("\nGenerate Scholarship Report\n");
         System.out.println("Select the data you want included (0-8):\n");

         // report category choice
         System.out.println("0: Print All");
         System.out.println("1: Scholarship Name");
         System.out.println("2: Total Amount");
         System.out.println("3: Close Date");
         System.out.println("4: Status");
         System.out.println("5: Awarded");
         System.out.println("6: Awardee Name");
         System.out.println("7: Remaining Amount");
         System.out.println("8: Donor Name\n");
         System.out.println("Enter category for further selection (0-8):\n");

         // user input report category choice
         Scanner scanner = new Scanner(System.in);
         reportChoice = scanner.nextInt();
         System.out.println("\nSelection: " + reportChoice + "\n");

         // user input report category specification choice

         // 0: Print All
         if (reportChoice == 0) { 

            System.out.println("Print All:\n");

         }
         // 1: Scholarship Name
         else if (reportChoice == 1) { 

            System.out.println("0: Print All Scholarship Name");
            System.out.println("1: A - Z");
            System.out.println("2: Z - A");

            System.out.println("\nEnter selection (0-2):\n");

            Scanner s0 = new Scanner(System.in);
            ratio = s0.nextInt();
            
            System.out.println("\nSelection: " + ratio + "\n");

            if (ratio != 0 && ratio != 1 && ratio != 2) {

               System.out.println("\nInvalid selection");

            }

            s0.close();

         }
         // 2: Total Amount
         else if (reportChoice == 2) { 

            System.out.println("0: Print All Amounts");
            System.out.println("1: Less Than");
            System.out.println("2: Greater Than");
            System.out.println("3: Equal");

            System.out.println("\nEnter selection (0-3):\n");

            Scanner s1 = new Scanner(System.in);
            ratio = s1.nextInt();

            System.out.println("\nEnter amount ($):\n");

            Scanner s0 = new Scanner(System.in);
            int value = s0.nextInt();

            String method = "Error";
            if (ratio == 0) {

               method = "Print All Amounts ";
            }
            else if (ratio == 1) {

               method = "Less Than: ";

            }
            else if (ratio == 2) {

               method = "Greater Than: ";

            }
            else if (ratio == 3) {

               method = "Equal: ";

            }

            System.out.println("\n" + method + value + "\n");

            if (ratio != 0 && ratio != 1 && ratio != 2 && ratio != 3) {

               System.out.println("\nInvalid selection");

            }

            s0.close();
            s1.close();

         }
         // 3: Close Date
         else if (reportChoice == 3) { 

            System.out.println("\nEnter date for Close After Date, Close Before Date or Close Exact Date (MM/DD/YYYY):\n");

            Scanner s0 = new Scanner(System.in);
            int value = s0.nextInt();

            // use modulo for user input and declare variables

            // int month = ;
            // int day = ;
            // int year = ;

            System.out.println("\nClose After Date, Close Before Date or Close Exact Date " + value + "?\n");

            System.out.println("0: Print All Close Date");
            System.out.println("1: Close After Date");
            System.out.println("2: Close Before Date");
            System.out.println("3: Close Exact Date");

            System.out.println("\nEnter selection (0-3):\n");

            Scanner s1 = new Scanner(System.in);
            ratio = s1.nextInt();

            if (ratio != 0 && ratio != 1 && ratio != 2 && ratio != 3) {

               System.out.println("\nInvalid selection");

            }

            s0.close();
            s1.close();
            
         } 
         // 4: Status
         else if (reportChoice == 4) { 

            System.out.println("0: Print All Status");
            System.out.println("1: Open");
            System.out.println("2: Closed");

            System.out.println("\nEnter selection (0-2):\n");

            Scanner s0 = new Scanner(System.in);
            ratio = s0.nextInt();
            
            System.out.println("\nSelection: " + ratio + "\n");

            if (ratio != 0 && ratio != 1 && ratio != 2) {

               System.out.println("\nInvalid selection");

            }

            s0.close();
            
         }
         // 5: Awarded
         else if (reportChoice == 5) { 

            System.out.println("0: Print All Awarded");
            System.out.println("1: Yes");
            System.out.println("2: No");

            System.out.println("\nEnter selection (0-2):\n");

            Scanner s0 = new Scanner(System.in);
            ratio = s0.nextInt();
            
            System.out.println("\nSelection: " + ratio + "\n");

            if (ratio != 0 && ratio != 1 && ratio != 2) {

               System.out.println("\nInvalid selection");

            }

            s0.close();
            
         }
         // 6: Awardee Name
         else if (reportChoice == 6) {

            // 1: empty or not check (print all those awarded) 
            // can be checked by 5: Awarded (Yes or No)

            // 2: search up awardee name (print all scholarhips awarded to awardee)

         }
         // 7: Remaining Amount
         else if (reportChoice == 7) { 
            
            System.out.println("\nEnter amount to check for Less Than, Greater Than or Equal remaining amount ($):\n");

            Scanner s0 = new Scanner(System.in);
            int value = s0.nextInt();

            System.out.println("\nLess Than, Greater Than or Equal To " + value + "?\n");

            System.out.println("0: Print All Remaining Amount");
            System.out.println("1: Less Than");
            System.out.println("2: Greater Than");
            System.out.println("3: Equal");

            System.out.println("\nEnter selection (0-3):\n");

            Scanner s1 = new Scanner(System.in);
            ratio = s1.nextInt();

            if (ratio != 0 && ratio != 1 && ratio != 2 && ratio != 3) {

               System.out.println("\nInvalid selection");

            }

            s0.close();
            s1.close();

         }
         // 8: Donor Name
         else if (reportChoice == 8) { 

            // 1: empty or not check (print all donors)

            // 2: search up awardee name (print all scholarhips funded by donor)
            
         }
         // Invalid Selection !(0-8)
         else {

            System.out.println("Invalid Selection");

         }
         
         // return Boolean value
         while ((line = br.readLine()) != null) {  

            // comma used as separator
            String[] data = line.split(splitBy);  

            // debug purposes print  

            /*System.out.println("Scholarship Name = " + data[0] + ", Total Amount = " + data[1] + ", Close Date = " + data[2]
            + ", Status = " + data[3] + ", Awarded = " + data[4] + ", Awardee Name = " + data[5] + ", Remaining Amount = " + data[6]
            + ", Donor Name = " + data[7]);*/

            // 0: Print All
            if (reportChoice == 0) {

               FileWriter writer = new FileWriter("Generated Scholarship Report.csv");

               System.out.println(data[0] + ", " + data[1] + ", " + data[2] + ", " + data[3] + ", " + data[4] 
               + ", " + data[5] + ", " + data[6] + ", " + data[7]); 

               // writer.append(data[0] + ", " + data[1] + ", " + data[2] + ", " + data[3] + ", " + data[4] 
               // + ", " + data[5] + ", " + data[6] + ", " + data[7]);

               // writer.append(String.valueOf(data[0]));
               // writer.append(splitBy);

               String sconame = "HaHa Scholarship";
               String namename = "Sue Kwon";
               int winwin = 8000;
               writer.append("-------------------------------\n");
               writer.append("|                             |\n");
               writer.append("|     Congrats on Winning     |\n");
               writer.append("|                             |\n");
               writer.append("|       " + sconame + "      |\n");
               writer.append("|                             |\n");
               writer.append("|           " + namename + "          |\n");
               writer.append("|                             |\n");
               writer.append("|       You won: $" + winwin + "        |\n");
               writer.append("|                             |\n");
               writer.append("-------------------------------\n");


               writer.close();

            }
            // 1: Scholarship Name
            else if (reportChoice == 1) {

               if (ratio == 1) {

                  // System.out.println("R1R1"); // fill out per criteria

                  // A-Z (sort data[0])
                  System.out.println(data[0]);

               }
               else if (ratio == 2) {

                  // System.out.println("R1R2"); // fill out per criteria

                  // Z-A (sort data[0])
                  System.out.println(data[0]);

               }
               else {

                  System.out.println("Please re-select: ");

               }

            }
            // 2: Total Amount
            else if (reportChoice == 2) {

               // compare values in array with variable called value (user input) 

               if (ratio == 1) {

                  // System.out.println("R2R1"); // fill out per criteria

                  // Less than user input value check data[1]
                  System.out.println(data[1]);


               }
               else if (ratio == 2) {

                  // System.out.println("R2R2"); // fill out per criteria

                  // Greater than user input value check data[1]
                  System.out.println(data[1]);

               }
               else if (ratio == 3) {

                  // System.out.println("R2R3"); // fill out per criteria

                  // Equal to user input value check data[1]
                  System.out.println(data[1]);

               }
               else {

                  System.out.println("Please re-select: ");

               }

            }
            // 3: Close Date
            else if (reportChoice == 3) {

               // compare values in array with variables called month, day, and year (user input derived variables) 

               if (ratio == 1) {

                  // System.out.println("R3R1"); // fill out per criteria

                  // After
                  System.out.println(data[2]);

               }
               else if (ratio == 2) {

                  // System.out.println("R3R2"); // fill out per criteria

                  // Before
                  System.out.println(data[2]);

               }
               else if (ratio == 3) {

                  // System.out.println("R3R3"); // fill out per criteria

                  // Exact
                  System.out.println(data[2]);

               }
               else {

                  System.out.println("Please re-select: ");

               }

            }
            // 4: Status
            else if (reportChoice == 4) {

               if (ratio == 1) {

                  // System.out.println("R4R1"); // fill out per criteria

                  // data[3] == "Open"
                  System.out.println(data[3]);

               }
               else if (ratio == 2) {

                  // System.out.println("R4R2"); // fill out per criteria

                  // data[3] == "Closed"
                  System.out.println(data[3]);

               }
               else {

                  System.out.println("Please re-select: ");

               }

            }
            // 5: Awarded
            else if (reportChoice == 5) {

               if (ratio == 1) {

                  // System.out.println("R5R1"); // fill out per criteria

                  // data[4] == "Yes"
                  System.out.println(data[3]);

               }
               else if (ratio == 2) {

                  // System.out.println("R5R2"); // fill out per criteria

                  // data[3] == "No"
                  System.out.println(data[3]);

               }
               else {

                  System.out.println("Please re-select: ");

               }

            }
            // 6: Awardee Name
            else if (reportChoice == 6) {

               if (ratio == 1) {

                  // System.out.println("R6R1"); // fill out per criteria

                  // if RC 5 R 1 == true => print
                  System.out.println(data[3]);

               }
               else if (ratio == 2) {

                  // System.out.println("R6R2"); // fill out per criteria

                  // data[4] == " " (variable derived from user input)
                  System.out.println(data[4]);


               }
               else {

                  System.out.println("Please re-select: ");
                  
               }

            }
            // 7: Remaining Amount
            else if (reportChoice == 7) {

               if (ratio == 1) {

                  // System.out.println("R7R1"); // fill out per criteria

                  // Less than user input value check data[5]
                  System.out.println(data[5]);

               }
               else if (ratio == 2) {

                  // System.out.println("R7R2"); // fill out per criteria

                  // Greater than user input value check data[5]
                  System.out.println(data[5]);

               }
               else if (ratio == 3) {

                  // System.out.println("R7R3"); // fill out per criteria

                  // Equal to user input value check data[5]
                  System.out.println(data[5]);

               }
               else {

                  System.out.println("Please re-select: ");

               }

            }
            // 8: Donor Name
            else if (reportChoice == 8) {

               if (ratio == 1) {

                  // System.out.println("R8R1"); // fill out per criteria

                  // print all
                  System.out.println(data[6]);

               }
               else if (ratio == 2) {

                  // System.out.println("R8R2"); // fill out per criteria

                  // data[6] == " " (variable derived from user input)
                  System.out.println(data[6]);

               }
               else {

                  System.out.println("Please re-select: ");

               }

            }
            // Invalid 
            else {

               System.out.println("Invalid Selection");
               System.out.println("Please re-select: ");

            }

            // write output csv file

            // FileWriter writer = new FileWriter("Generated Report.csv");
            // writer.append(String.valueOf(data[1]));
            // writer.append(splitBy);
            // writer.close();

         }  

         if (reportChoice == 0 || reportChoice == 1 || reportChoice == 2 || reportChoice == 3 || reportChoice == 4 || reportChoice == 5 
            || reportChoice == 6 || reportChoice == 7 || reportChoice == 8) {

            System.out.println("\nReport available in \"Generated Scholarship Report.csv\"\n");

         }

      br.close();
      scanner.close();

      }   

      catch (IOException e) {  
        
         e.printStackTrace(); 

      }  
   }  
}  
