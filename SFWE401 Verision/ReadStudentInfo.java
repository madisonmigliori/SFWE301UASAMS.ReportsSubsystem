import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.FileWriter;
import java.awt.*; 

public class ReadStudentInfo
{
    String timeStamp;
    // This prints out the data imported and then writes it to another .csv file
    public void printOutput(Student[] student, int[] x) throws IOException {
        try {

            // Define .CSV file were the Report will be written to.
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            FileWriter fileName = new FileWriter ("ImportedApplicantData" + timeStamp + ".csv");

            //Create FileWriter object
            PrintWriter pw = new PrintWriter(fileName);
            int i = 0;
            String[] dataString;
            /*
            while (i < x[0]) {
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
            */
            i = 1;
            pw.print(",");
            while (i <= x[0]) {
               pw.print("Student: " + i + " ,");
               i++;
            }
            i = 0;
            pw.println();
            pw.print("Name,");
            while (i < x[0]) {
                
               pw.print(student[i].getName()+ ",");
            i++;
           }
            i = 0;
            pw.println();
            pw.print("IdNume,");
            while (i < x[0]) {
                
               pw.print(student[i].getIdNum()+ ",");
            i++;
           }
            i = 0;
            pw.println();
            pw.print("Graduation Month,");
            while (i < x[0]) {
                
               pw.print(student[i].getGradMonth()+ ",");
            i++;
           }
            i = 0;
            pw.println();
                        pw.print("Graduation Year,");
            while (i < x[0]) {
                
               pw.print(student[i].getGradYear()+ ",");
            i++;
           }
            i = 0;
            pw.println();
            pw.print("Academic Standing,");
            while (i < x[0]) {
                
               pw.print(student[i].getAcadStand()+ ",");
            i++;
           }
            i = 0;
            pw.println();
            pw.print("Major,");
            while (i < x[0]) {
                
               pw.print(student[i].getMajor()+ ",");
            i++;
           }
            i = 0;
            pw.println();
            pw.print("Minor,");
            while (i < x[0]) {
                
               pw.print(student[i].getMinor()+ ",");
            i++;
           }
            i = 0;
            pw.println();
            pw.print("Field Of Interest,");
            while (i < x[0]) {
                
               pw.print(student[i].getFieldIntr()+ ",");
            i++;
           }
            i = 0;
            pw.println();
            pw.print("Units Complete,");
            while (i < x[0]) {
                
               pw.print(student[i].getUnitComp()+ ",");
            i++;
           }
            i = 0;
            pw.println();
            pw.print("Race,");
            while (i < x[0]) {
                
               pw.print(student[i].getRace()+ ",");
            i++;
           }
            i = 0;
            pw.println();
            pw.print("LGBT,");
            while (i < x[0]) {
                
               pw.print(student[i].getLGBT()+ ",");
            i++;
           }
            i = 0;
            pw.println();
            pw.print("Ethnicity,");
            while (i < x[0]) {
                
               pw.print(student[i].getEthnicity()+ ",");
            i++;
           }
            i = 0;
            pw.println();
            pw.print("Military,");
            while (i < x[0]) {
                
               pw.print(student[i].getMilitary()+ ",");
            i++;
           }
            i = 0;
            pw.println();
            pw.print("Disability,");
            while (i < x[0]) {
                
               pw.print(student[i].getDisability()+ ",");
            i++;
           }
            i = 0;
            pw.println();
            pw.print("Citizenship,");
            while (i < x[0]) {
                
               pw.print(student[i].getCitizenship()+ ",");
            i++;
           }

            pw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Automaticaly opens .csv file on Excel
        Desktop.getDesktop().open(new File("ImportedApplicantData" + timeStamp + ".csv"));
    }
}
