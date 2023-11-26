import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.FileReader;
import java.io.FileWriter;
//import java.util.Scanner;

public class DonorReport {
    Scholarship[] donor = new Scholarship[100];

    private int numDonors;
  
    public int readFile() {
       String lineString = "";
       String delimiter = ",";
       String[] donorInfo;
       int i = 0;

       try {
            // read csv file
            BufferedReader br = new BufferedReader(new FileReader("Report Formatting - Scholarship Report.csv"));

            br.readLine(); // don't process header
 
            while ((lineString = br.readLine()) != null) {
                donorInfo = lineString.split(delimiter);
                donor[i] = new Scholarship(donorInfo);
                i++;
            }
            numDonors = i;
            br.close();
        }

        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return numDonors;
    }

    public void generateReport(Scholarship[] donor, int numDonors) throws IOException {
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

            FileWriter fw = new FileWriter ("donor report" + timeStamp + ".csv");
            PrintWriter pw = new PrintWriter(fw);
            int i = 0;
//            Boolean printDonorName = true;
//            Boolean printScholarshipName = true;
//            Boolean printStatus = true;
//            Boolean printScholarshipAmount = true;

//            printDonorName = determinePrintCategory("donor name");
//            printScholarshipName = determinePrintCategory("scholarship name");
//            printStatus = determinePrintCategory("status");
//            printScholarshipAmount = determinePrintCategory("scholarship amount");

            // print headers
 //           if (printDonorName) {
                pw.print("Donor Name,");
 //           }
 //           if (printScholarshipName) {
                pw.print("Scholarship Name,");
 //           }
 //           if (printStatus) {
                pw.print("Status,");
 //           }
 //           if (printScholarshipAmount) {
                pw.print("Scholarship Amount");
 //           }
            pw.println();

            for (i = 0; i < numDonors; i++) {
                if (donor[i].getStatus().compareTo("Open") == 0) {
 //                   if (printDonorName) {
                        pw.print(donor[i].getDonorName() + ",");
 //                   }
 //                   if (printScholarshipName) {
                        pw.print(donor[i].getScholarshipName() + ",");
 //                   }
 //                   if (printStatus) {
                        pw.print(donor[i].getStatus() + ",");
 //                   }
 //                   if (printScholarshipAmount) {
                        pw.print(donor[i].getAmount());
 //                   }
                    pw.println();
                }
            }
            pw.close();
            Desktop.getDesktop().open(new File("donor report" + timeStamp + ".csv"));
        }
        
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

 /*   public Boolean determinePrintCategory(String categoryName) {
        Scanner scnr = new Scanner(System.in);
        char yesOrNo = ' ';

        System.out.println("Include " + categoryName + "? (y or n)");
        yesOrNo = scnr.next().charAt(0);
        
        if (yesOrNo == 'y') {
            return true;
        }
        else {
            return false;
        }
    }
    */
}