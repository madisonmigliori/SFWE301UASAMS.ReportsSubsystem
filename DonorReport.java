import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.awt.*;

public class DonorReport {
    private Donor[] donor = new Donor[100];
    private int numDonors;
  
    public void readFile() {
       String lineString = "";
       String delimiter = ",";
       String[] donorInfo;
       int i = 0;

       try {
            // read csv file
            FileReader fr = new FileReader("Report Formatting - Donor Financials Report.csv"); 
            BufferedReader br = new BufferedReader(fr);
            br.readLine(); // Don't process header
 
            while ((lineString = br.readLine()) != null) {
                donorInfo = lineString.split(delimiter);
                donor[i] = new Donor(donorInfo);
                i++;
            }
            numDonors = i + 1;
            fr.close();
        }

        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void generateReport() throws IOException {
        try {
            FileWriter fw = new FileWriter ("donor report.csv");
            PrintWriter pw = new PrintWriter(fw);
            int i = 0;
            Boolean printDonorName = true;
            Boolean printScholarshipName = true;
            Boolean printCloseDate = true;
            Boolean printAwardeeName = true;
            Boolean printRemainingFunds = true;
            Date currentDate = new Date();

            printDonorName = determinePrintCategory("donor name");
            printScholarshipName = determinePrintCategory("scholarship name");
            printCloseDate = determinePrintCategory("close date");
            printAwardeeName = determinePrintCategory("awardee name");
            printRemainingFunds = determinePrintCategory("remaining funds");

            for (i = 0; i < numDonors; i++) {
                if (currentDate.before(donor[i].getCloseDate())) {
                    if (printDonorName) {
                        pw.println(donor[i].getDonorName());
                    }
                    if (printScholarshipName) {
                        pw.println(donor[i].getScholarshipName());
                    }
                    if (printCloseDate) {
                        pw.println(donor[i].getCloseDate());
                    }
                    if (printAwardeeName) {
                        pw.println(donor[i].getAwardeeName());
                    }
                    if (printRemainingFunds) {
                        pw.println(donor[i].getRemainingFunds());
                    }
                }
            }
            pw.close();
        }
        
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Boolean determinePrintCategory(String categoryName) {
        Scanner scnr = new Scanner(System.in);
        char yesOrNo = ' ';

        try {
          System.out.println("Include " + categoryName + "? (y or n)");
          yesOrNo = scnr.next().charAt(0);
          
          if (yesOrNo == 'y') {
              return true;
          }
          else {
              return false;
          }
        }
        finally {
          scnr.close();
        }
    }
}