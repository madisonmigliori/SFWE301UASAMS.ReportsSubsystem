// just columns (no additional features)

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class ScholarshipReports {
    public void ScholarReport(Awarded[] awarded) {

        // CSV separator variables
        String line = "";
        String splitBy = ",";
        // report category choice variable
        int reportChoice = 0;

        Scanner scanner = new Scanner(System.in);
        try {

 
            char choice = 'y';
            do
            {
                // parsing a CSV file into BufferedReader class constructor
                BufferedReader br = new BufferedReader(new FileReader("Report Formatting - Scholarship Report.csv"));
                BufferedReader brAwarded = new BufferedReader(new FileReader("Awarded.csv"));
                String lineString;

                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                FileWriter fw = new FileWriter("Generated Scholarship Report" + timeStamp + ".csv");
                PrintWriter pw = new PrintWriter(fw);

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
                System.out.println("6: Donor Name\n");
                System.out.println("Enter category for further selection (0-8):\n");
                // user input report category choice
                reportChoice = scanner.nextInt();

                // return Boolean value
                while ((line = br.readLine()) != null) {
                      
                    // comma used as separator
                    String[] data = line.split(splitBy);
                    

                    // 0: Print All
                    if (reportChoice == 0) {
                        pw.println(data[0] + ", " + data[1] + ", " + data[2] + ", " + data[3] + ", " + data[4]
                                + ", " + data[5] + ", " + data[6] + ", " + data[7] + ", " + data[8] + ", " + data[9]
                                + ", " + data[10] + ", " + data[11]);
                    }
                    // 1: Scholarship Name
                    if (reportChoice == 1) {
                        pw.println(data[0]);
                    }
                    // 2: Total Amount
                    if (reportChoice == 2) {
                        pw.println(data[0] + "," + data[1]);
                    }
                    // 3: Close Date
                    if (reportChoice == 3) {
                        pw.println(data[0] + "," + data[2]);
                    }
                    // 4: Status
                    if (reportChoice == 4) {
                        pw.println(data[0] + "," + data[3]);
                    }
                    // 5: Awarded
                    if (reportChoice == 5) {
                        while ((lineString = brAwarded.readLine()) != null) {
                            pw.println(lineString);
                        }
                        brAwarded.mark(0);
                        break;
                    }
                    // 6: Donor Name
                    if (reportChoice == 6) {
                        pw.println(data[5]);
                    }

                }
                pw.close();
                System.out.println("\nReport available in \"Generated Scholarship Report.csv\"\n");

                br.close();
                    
                Desktop.getDesktop().open(new File("Generated Scholarship Report" + timeStamp + ".csv"));
                // user input report category choice
                System.out.println("Run another selection (y/n): ");
                choice = scanner.next().charAt(0);
                
            }while(choice == 'y');
            scanner.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
