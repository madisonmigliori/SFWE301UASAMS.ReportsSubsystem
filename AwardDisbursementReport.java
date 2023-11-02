import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class AwardDisbursementReport {
    // variables
    Scanner scnr = new Scanner(System.in);
    private String[] currentDate;
    private String[] scholarshipName;
    private String[] applicantName;
    private double[] amountGranted;
    private String[] awardMessage;

    // read in all data into corresponding variables from .csv file
    public void importData(String fileName) {
        System.out.println("Complete importData() function");
    }

    // use data to output an award disbursement report by writing to a .txt file including all data fields
    public void generateRegularReport() {
        System.out.println("Complete generateRegularReport() function");
    }

    // user data to output an applicant report by writing to a .txt file including fields selected by the user
    public void generateCustomizedReport() {
        Boolean includeDate;
        Boolean includeScholarshipName;
        Boolean includeApplicantName;
        Boolean includeAmountGranted;
        Boolean includeAwardMessage;

        System.out.println("Complete generateCustomizedReport() function");
    }
}