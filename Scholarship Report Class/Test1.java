// just columns (no additional features)

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
         
         // return Boolean value
         while ((line = br.readLine()) != null) {  

            // comma used as separator
            String[] data = line.split(splitBy);  

            FileWriter writer = new FileWriter("Generated Scholarship Report.csv");
            
            // 0: Print All
            if (reportChoice == 0) {
               System.out.println(data[0] + ", " + data[1] + ", " + data[2] + ", " + data[3] + ", " + data[4] + ", " + data[5] + ", " + data[6] + ", " + data[7]); 
            }
            // 1: Scholarship Name
            if (reportChoice == 1) {
                System.out.println(data[0]);
            }
            // 2: Total Amount
            if (reportChoice == 2) {
                System.out.println(data[1]);
            }
            // 3: Close Date
            if (reportChoice == 3) {
                System.out.println(data[2]);
            }
            // 4: Status
            if (reportChoice == 4) {
                System.out.println(data[3]);
            }
            // 5: Awarded
            if (reportChoice == 5) {
                System.out.println(data[4]);
            }
            // 6: Awardee Name
            if (reportChoice == 6) {
                System.out.println(data[5]);
            }
            // 7: Remaining Amount
            if (reportChoice == 7) {
                System.out.println(data[6]);
            }
            // 8: Donor Name
            if (reportChoice == 8) {
                System.out.println(data[7]);
            }
          
            writer.close();
            
            // write output csv file

            // FileWriter writer = new FileWriter("Generated Report.csv");
            // writer.append(String.valueOf(data[1]));
            // writer.append(splitBy);
            // writer.close();

         }  

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
