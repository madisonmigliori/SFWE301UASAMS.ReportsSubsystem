import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.*; 

public class ReadStudentInfo
{
    static Student[] student = new Student[100];

    // Parses the the .csv file and imports the data for later use  
    public void parseCsvInfo(String[] args)
    {
        
       String lineString = "";
       String splitBy = ",";
       String[] studentInfo;
       int i = 0;

       try
       {
            // Parsing CSV file
            FileReader fr=new FileReader("Report Formatting.csv"); 
            BufferedReader br = new BufferedReader(fr);  // pointer to first line in file
            br.readLine(); // Don't process header
            br.readLine(); // Don't process header
 
            while ((lineString = br.readLine()) != null) {
                    studentInfo = lineString.split(splitBy);
                    student[i] = new Student(studentInfo);
                    i++;
            }
            printOutput(student, i);

            fr.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // This prints out the data imported and then writes it to another .csv file
    public void printOutput(Student[] student, int x) throws IOException {
        try {

            // Define .CSV file were the Report will be written to.
            FileWriter fileName = new FileWriter ("ImportedApplicantData.csv");

            //Create FileWriter object
            PrintWriter pw = new PrintWriter(fileName);
            int i = 0;
            while (i < x) {
                pw.println("\"Applicant Name (Last,First)\"" + "," + student[i].getName());
                pw.println("   ID 8 digits              ," + student[i].getIdNum());
                pw.println("   Graduation Month         ," + student[i].getGradMonth());
                pw.println("   Graduation Year          ," + student[i].getGradYear());
                pw.println("   Academic Standing        ," + student[i].getAcadStand());
                pw.println("   GPA                      ," + student[i].getGpa());
                pw.println("   Major                    ," + student[i].getMajor());
                pw.println("   Minor                    ," + student[i].getMinor());
                pw.println("   Field of Interest        ," + student[i].getFieldIntr());
                pw.println("   Gender                   ," + student[i].getGender());
                pw.println("   Transfer Student Status  ," + student[i].getTranStu());
                pw.println("   Units Completed          ," + student[i].getUnitComp());
                pw.println("   Race                     ," + student[i].getRace());
                pw.println("   LGBT?                     ," + student[i].getLGBT());
                pw.println("   Ethnicity                ," + student[i].getEthnicity());
                pw.println("   Military                 ," + student[i].getMilitary());
                pw.println("   Disability               ," + student[i].getDisability());
                pw.println("   Citizenship              ," + student[i].getCitizenship());
                pw.println("----------------------------,------------------------");
                pw.println();
                i++;
            }
            pw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Automaticaly opens .csv file on Excel
        Desktop.getDesktop().open(new File("ImportedApplicantData.csv"));
    }

    public static void main(String[] args)
    {      
           new GUI();
    }

}