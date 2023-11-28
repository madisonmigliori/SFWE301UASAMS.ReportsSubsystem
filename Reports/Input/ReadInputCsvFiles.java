import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class ReadInputCsvFiles {
    Student[] student = new Student[100];
    Scholarship[] scholarship = new Scholarship[100];
    Awarded[] awarded = new Awarded[100];

    // Parses the the .csv file and imports the data for later use  
    public int[] parseCsvInfo(String[] args)
    {
        String lineString = "";
        String splitBy = ",";
        String[] scholarshipInfo;
        String[] studentInfo;
        String[] awardedInfo;
        int[] totalAmount = new int[3];
        int i = 0;

        try
       {
            // Parsing CSV file
            FileReader fr1=new FileReader("Report Formatting.csv"); 
            BufferedReader br1 = new BufferedReader(fr1);  // pointer to first line in file
            br1.readLine(); // Don't process header
            br1.readLine(); // Don't process header
 
            while ((lineString = br1.readLine()) != null) {
                    studentInfo = lineString.split(splitBy);
                    student[i] = new Student(studentInfo);
                    i++;
            }
            //printOutput(student, i);
            //Send back number of records 
            totalAmount[0] = i;


            fr1.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            i = 0;
            // Parsing CSV file
            FileReader fr2 = new FileReader("Awarded.csv");
            BufferedReader br2 = new BufferedReader(fr2); // pointer to first line in file
            br2.readLine(); // Don't process header

            while ((lineString = br2.readLine()) != null) {
                awardedInfo = lineString.split(splitBy);
                awarded[i] = new Awarded(awardedInfo);
                i++;
            }
            // printOutput(scholarship, i);
            // Send back number of records
            totalAmount[1] = i;

            fr2.close();
         }
         catch (IOException e)
         {
             e.printStackTrace();
         }

        try
        {
            i = 0;
            int x = 0;
            boolean reset = false;
            // Parsing CSV file
            FileReader fr3 = new FileReader("Report Formatting - Scholarship Report.csv");
            BufferedReader br3 = new BufferedReader(fr3); // pointer to first line in file
            br3.readLine(); // Don't process header

            while ((lineString = br3.readLine()) != null) {
                scholarshipInfo = lineString.split(splitBy);
                scholarship[i] = new Scholarship(scholarshipInfo);
                x = 0;
                while (x < totalAmount[1]) {
                    if (awarded[x].getScholarshipName().compareTo(scholarship[i].getScholarshipName()) == 0) {
                        scholarship[i].setRemaining(scholarship[i].getAmount() - awarded[x].getAmount());
                        reset = true;
                    }
                    x++;
                }
                if (!reset)
                {
                    scholarship[i].setRemaining(scholarship[i].getAmount());
                }
                reset = false;
                i++;
            }
            // printOutput(scholarship, i);
            // Send back number of records
            totalAmount[2] = i;
            fr3.close();
         }
         catch (IOException e)
         {
             e.printStackTrace();
         }
      
         return totalAmount;
    }
}
