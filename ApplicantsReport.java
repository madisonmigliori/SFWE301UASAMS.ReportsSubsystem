import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ApplicantsReport {
    // variables
    Scanner scnr = new Scanner(System.in);
    private String[] applicantName;
    private int[] IDnum;
    private String[] applicantYear;
    private int[] academicStandings;
    private double[] GPA;
    private String[] major;
    private String[] minor;
    private String[] expectedGraduationDate;
    private String[] fieldOfInterest;
    private String[] gender;
    private String[] transferStudentStatus;
    private int[] numUnits;
    private String[] demographics;

    // read in all data into corresponding variables from .csv file
    public void importData(String fileName) {
        System.out.println("Complete importData() function");
    }

    // use data to output an applicant report by writing to a .txt file including all data fields
    public void generateRegularReport() {
        System.out.println("Complete generateRegularReport() function");
    }

    // user data to output an applicant report by writing to a .txt file including fields selected by the user
    public void generateCustomizedReport() {
        Boolean includeName;
        Boolean includeID;
        Boolean includeAcademicStanding;
        Boolean includeGPA;
        Boolean includeMajor;
        Boolean includeMinor;
        Boolean includeExpectedGraduationDate;
        Boolean includeFieldOfInterest;
        Boolean includeGender;
        Boolean includeTransferStudentStatus;
        Boolean includeNumUnits;
        Boolean includeDemographics;

        System.out.println("Complete generateCustomizedReport() function");
    }
}