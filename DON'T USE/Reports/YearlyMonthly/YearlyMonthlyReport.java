import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class YearlyMonthlyReport {
    
    public void printYearlyMonthly(Scholarship[] scholarship, int[] recordAmount, String Selection,  int dropdownIndex, Awarded[] awarded) throws IOException {

        try {
            String fileNameTemp;
            String parsedMonth;
            String scholarshipMonth;
            int fundsAwarded = 0;
            
            if ((Selection.compareTo("Yearly") == 0))
            {
                fileNameTemp = "Yearly";
            }
            else
            {
                fileNameTemp = "Monthly" + Selection;
            }
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            fileNameTemp = fileNameTemp + timeStamp + ".csv";
            // Define .CSV file were the Report will be written to.
            FileWriter fileName = new FileWriter (fileNameTemp);

            //Create FileWriter object
            PrintWriter pw = new PrintWriter(fileName);
            int i = 0;
            int x = 0;
            boolean accountOpen = true;

            if ((Selection.compareTo("Yearly") == 0))
            {
                while (i < recordAmount[2]) 
                {
                    x = 0;
                    pw.println("_______________________" + "," + "______________________"+ "," + "______________________");
                    pw.println("Donor Name," + scholarship[i].getDonorName() + "," + scholarship[i].getAmount());
                    pw.println("\"Scholarship Name\"" + "," + scholarship[i].getScholarshipName());
                    if (scholarship[i].getStatus().compareTo("Open") == 0) {
                        pw.println("Current Status,OPEN");
                        accountOpen = true;
                    } else {
                        pw.println("Current Status,CLOSED");
                        accountOpen = false;
                    }

                    while (x < recordAmount[1]) 
                    {
                        if ((scholarship[i].getScholarshipName().compareTo(awarded[x].getScholarshipName())) == 0)
                        {
                            pw.println("  Applicant" + "," + awarded[x].getApplicantName());
                            pw.println("  Amount Awarded" + ",," + awarded[x].getAmount());
                            pw.println("  Date Awarded,," + awarded[x].getDateAwarded());
                            pw.println();
                        }
                        x++;
                    }  
                    pw.println();

                    if (accountOpen)
                    {
                        pw.println("Remaining Funds,," + scholarship[i].getRemaining());
                    }
                    else{
                        pw.println("Available Funds,," + 0);
                    }
                    i++;                    
                }
            }
            else
            {
                while (i < recordAmount[2]) 
                {
                    scholarshipMonth = scholarship[i].getcloseDate().substring(0, 2);
                    fundsAwarded = 0;
                    x = 0;
                    pw.println("_______________________" + "," + "______________________" + ","
                            + "______________________");
                    pw.println("Donor Name," + scholarship[i].getDonorName() + "," + scholarship[i].getAmount());
                    pw.println("\"Scholarship Name\"" + "," + scholarship[i].getScholarshipName());
                    if (Integer.parseInt(scholarshipMonth) > dropdownIndex) {
                        pw.println("Current Status,OPEN");
                        accountOpen = true;
                    } else {
                        pw.println("Current Status,CLOSED");
                        accountOpen = false;
                    }

                    while (x < recordAmount[1]) {
                        if ((scholarship[i].getScholarshipName().compareTo(awarded[x].getScholarshipName())) == 0) {
                            if (Integer.parseInt(scholarshipMonth) < dropdownIndex) {
                                pw.println("  Applicant" + "," + awarded[x].getApplicantName());
                                pw.println("  Amount Awarded" + ",," + awarded[x].getAmount());
                                pw.println("  Date Awarded,," + awarded[x].getDateAwarded());
                                pw.println();
                                fundsAwarded = fundsAwarded + awarded[x].getAmount();
                            }
                        }
                        x++;
                    }

                    if (accountOpen) {
                        if (Integer.parseInt(scholarshipMonth) > dropdownIndex) {
                            fundsAwarded = scholarship[i].getAmount();
                        }
                    }
                    else
                    {
                        fundsAwarded = 0;
                    }
                    
                    pw.println("Available Funds,," + fundsAwarded);
                    pw.println();
                    i++;
                                      
                }
            }

            pw.close();
            // Automaticaly opens .csv file on Excel
            Desktop.getDesktop().open(new File(fileNameTemp));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
