import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.awt.*;
import java.util.Calendar;

public class Reports {
     // This prints out the data imported and then writes it to another .csv file
     static Scholarship[] scholaship = new Scholarship[100];

    public void printDonors(Scholarship[] scholaship, String donor, int[] x) throws IOException {
        try {
            // Define .CSV file were the Report will be written to.
            FileWriter fileName = new FileWriter ("DonorData.csv");

            //Create FileWriter object
            PrintWriter pw = new PrintWriter(fileName);
            int i = 0;
            pw.println("Donor, Amount Donated, Status, Expiration Date, Remaining amount ");
            while (i < x[1]) {
                pw.println(scholaship[i].getDonorName() + "," + scholaship[i].getAmount());
                pw.println();
                i++;
            }
            pw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Automaticaly opens .csv file on Excel
        Desktop.getDesktop().open(new File("DonorData.csv"));
    }

    public void printScholarshipStatus(Scholarship[] scholarship, int[] recordAmount, String Scholership, int selection) throws IOException {
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            String fileNameTemp = Scholership + timeStamp + ".csv";
            // Define .CSV file were the Report will be written to.
            FileWriter fileName = new FileWriter (fileNameTemp);

            //Create FileWriter object
            PrintWriter pw = new PrintWriter(fileName);
            int i = 0;
            if (Scholership.compareTo("All") == 0) 
            {
                while (i < recordAmount[2]) 
                {

                    pw.println("\"Scholarship Name\"" + "," + scholarship[i].getScholarshipName());
                    pw.println("   Total Amount              ," + scholarship[i].getAmount());
                    pw.println("   Close Date         ," + scholarship[i].getcloseDate());
                    pw.println("   Status          ," + scholarship[i].getStatus());
                    pw.println("   Awarded        ," + scholarship[i].getAwarded());
                    pw.println("   Remaining Amount                   ," + scholarship[i].getRemaining());
                    pw.println("   Donor Name1                    ," + scholarship[i].getDonorName());
                    pw.println("----------------------------,------------------------");
                    pw.println();
                    i++;                    
                }
            }
            else
            {
                    pw.println("\"Scholarship Name\"" + "," + scholarship[selection-1].getScholarshipName());
                    pw.println("   Total Amount              ," + scholarship[selection-1].getAmount());
                    pw.println("   Close Date         ," + scholarship[selection-1].getcloseDate());
                    pw.println("   Status          ," + scholarship[selection-1].getStatus());
                    pw.println("   Awarded        ," + scholarship[selection-1].getAwarded());
                    pw.println("   Remaining Amount                   ," + scholarship[selection-1].getRemaining());
                    pw.println("   Donor Name1                    ," + scholarship[selection-1].getDonorName());
                    pw.println("----------------------------,------------------------");
                    pw.println();
                    i++; 
            }

            pw.close();
            // Automaticaly opens .csv file on Excel
            Desktop.getDesktop().open(new File(fileNameTemp));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void printAwardedApplicants(Scholarship[] scholarship, int[] recordAmount, String Scholership, int selection, Awarded[] awarded) throws IOException {
        int awardFound =  0;
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            String fileNameTemp = Scholership + timeStamp + ".csv";
            // Define .CSV file were the Report will be written to.
            FileWriter fileName = new FileWriter (fileNameTemp);

            //Create FileWriter object
            PrintWriter pw = new PrintWriter(fileName);
            int i = 0;
            if ((Scholership.compareTo("All") == 0)) 
            {
                while (i < recordAmount[1]) 
                {
                    pw.println("_______________________" + "," + "______________________");
                    pw.println();
                    pw.println("Scholarship              ," + awarded[i].getScholarshipName());
                    pw.println("Applicants" + "," + awarded[i].getApplicantName());
                    pw.println("Amount" + "," + awarded[i].getAmount());
                    pw.println();
                    i++;
                    awardFound = 1;
                }   
            }
            else
            {
                while (i < recordAmount[1]) 
                {

                    if ( Scholership.compareTo(awarded[i].getScholarshipName()) == 0 )
                    {
                        pw.println("_______________________" + "," + "______________________");
                        pw.println();
                        pw.println("Scholarship              ," + awarded[i].getScholarshipName());
                        pw.println("Applicants" + "," + awarded[i].getApplicantName());
                        pw.println("Amount" + "," + awarded[i].getAmount());
                        pw.println();
                        awardFound = 1;
                    }
                    i++;  
                }
            }

            if (awardFound == 0)
            {
                pw.println("There are NO awardees" );
            }
            else
            {
                pw.println("_______________________" + "," + "______________________");
            }


            pw.close();
            // Automaticaly opens .csv file on Excel
            Desktop.getDesktop().open(new File(fileNameTemp));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void printEligibleApplicants(Student[] applicant, Scholarship[] scholarship, int[] recordAmount, String Scholarship, int selectedIndex, Awarded[] awarded) {
        int awardFound = 0;
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            String fileNameTemp = "EligibleStudents_" + scholarship + "_" + timeStamp + ".csv";
            // Define .CSV file were the Report will be written to.
            FileWriter fileName = new FileWriter(fileNameTemp);

            // Create FileWriter object
            PrintWriter pw = new PrintWriter(fileName);
            int i = 0;
            int x = 0;
            boolean printSch = true;
            
            if ((Scholarship.compareTo("All") == 0)) {
                while (i < recordAmount[2]) {
                    awardFound = 0;
                    x = 0;
                    pw.println("_______________________" + "," + "______________________");
                    pw.println("Scholarship              ," + scholarship[i].getScholarshipName());
                    if (scholarship[i].getStatus().compareTo("Open") == 0) 
                    {

                        while (x < recordAmount[0]) {

                            if ((applicant[x].getGpa() >= scholarship[i].getRequiredGpa()) &&
                                    ((applicant[x].getLGBT().compareTo("NA") == 0) ||
                                            (applicant[x].getGender()
                                                    .compareTo(scholarship[i].getRequiredGender()) == 0))
                                    &&
                                    ((scholarship[i].getRequiredEthnicity().compareTo("NA") == 0) ||
                                            (applicant[x].getEthnicity()
                                                    .compareTo(scholarship[i].getRequiredEthnicity()) == 0))
                                    &&
                                    ((scholarship[i].getRequiredLGBT().compareTo("NA") == 0) ||
                                            (applicant[x].getMilitary()
                                                    .compareTo(scholarship[i].getRequiredLGBT()) == 0))
                                    &&
                                    ((scholarship[i].getRequiredMilitary().compareTo("NA") == 0) ||
                                            (applicant[x].getMilitary()
                                                    .compareTo(scholarship[i].getRequiredMilitary()) == 0))
                                    &&
                                    ((scholarship[i].getRequiredUsCitizen().compareTo("NA") == 0) ||
                                            (applicant[x].getCitizenship()
                                                    .compareTo(scholarship[i].getRequiredUsCitizen()) == 0))) 
                            {
                                pw.println();
                                pw.println("Applicants" + "," + applicant[x].getName());

                                awardFound = 1;
                            }

                            x++;
                        }

                        if (awardFound == 0) {
                            pw.println();
                            pw.println("No Applicants are eligible");
                            pw.println("_______________________" + "," + "______________________");
                        }
                    }
                    else{
                                                    pw.println();
                            pw.println("*****Closed*****");
                            pw.println("_______________________" + "," + "______________________");
                    }
                    i++;
                }
            } 
            else 
            {
                if (scholarship[selectedIndex - 1].getStatus().compareTo("Open") == 0) {
                    x = 0;

                    while (x < recordAmount[0]) {
                        if ((applicant[x].getGpa() >= scholarship[selectedIndex - 1].getRequiredGpa()) &&
                                ((applicant[x].getLGBT().compareTo("NA") == 0) ||
                                        (applicant[x].getGender()
                                                .compareTo(scholarship[selectedIndex - 1]
                                                        .getRequiredGender()) == 0))
                                &&
                                ((scholarship[selectedIndex - 1].getRequiredEthnicity().compareTo("NA") == 0) ||
                                        (applicant[x].getEthnicity()
                                                .compareTo(scholarship[selectedIndex - 1]
                                                        .getRequiredEthnicity()) == 0))
                                &&
                                ((scholarship[selectedIndex - 1].getRequiredLGBT().compareTo("NA") == 0) ||
                                        (applicant[x].getMilitary()
                                                .compareTo(
                                                        scholarship[selectedIndex - 1].getRequiredLGBT()) == 0))
                                &&
                                ((scholarship[selectedIndex - 1].getRequiredMilitary().compareTo("NA") == 0) ||
                                        (applicant[x].getMilitary()
                                                .compareTo(scholarship[selectedIndex - 1]
                                                        .getRequiredMilitary()) == 0))
                                &&
                                ((scholarship[selectedIndex - 1].getRequiredUsCitizen().compareTo("NA") == 0) ||
                                        (applicant[x].getCitizenship()
                                                .compareTo(scholarship[selectedIndex - 1]
                                                        .getRequiredUsCitizen()) == 0))) {
                            if (printSch) {
                                pw.println("Scholarship              ,"
                                        + scholarship[selectedIndex - 1].getScholarshipName());
                                printSch = false;
                            }
                            pw.println();
                            pw.println("Applicants" + "," + applicant[x].getName());
                            pw.println();
                            awardFound = 1;

                        }
                        x++;
                    }
                    if (awardFound == 0) {
                        pw.println("Scholarship              ," + scholarship[selectedIndex - 1].getScholarshipName());
                        pw.println();
                        pw.println("There are NO awardees");
                    }

                } else {
                    pw.println("Scholarship              ," + scholarship[selectedIndex - 1].getScholarshipName());
                    pw.println();
                    pw.println("*****Closed*****");
                }
            }
            pw.println("_______________________" + "," + "______________________");
            pw.close();
            // Automaticaly opens .csv file on Excel
            Desktop.getDesktop().open(new File(fileNameTemp));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void printAwardedLetteReports(int[] recordAmount, Awarded[] awarded, Student[] applicant){
        int i = 0;
        int x = 0;
        String name;
        while (i < recordAmount[1]){
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            name = awarded[i].getApplicantName().replaceAll("\"","");
            String fileNameTemp = "Awarded_letter_" + name +"_" + timeStamp + ".txt";
            // Create FileWriter object
           
            try  {
                FileWriter fileName = new FileWriter(fileNameTemp);
                PrintWriter pw = new PrintWriter(fileName);
                x = 0;
                while (x < recordAmount[0]){
                    if (awarded[i].getApplicantName().compareTo(applicant[x].getName()) == 0){
                        name = applicant[x].getName();
                        break;
                    }
                    x++;
                }
                pw.println("Dear " + awarded[i].getApplicantName());
                pw.println("");
                pw.println("It is a great pleasure for me to inform you that you have been selected to receive the " + awarded[i].getScholarshipName());
                pw.println("Scholarship. Each year students who have distinguished themselves through  ");
                pw.println("outstanding academic achievement and personal excellence are chosen from the ");
                pw.println("entering class to receive this honor.");
                pw.println();
                pw.println("Please note, that students receiving scholarships from " + awarded[i].getScholarshipName() + " must be enrolled full ");
                pw.println("time and maintain a cumulative " + applicant[x].getGpa() + " Grade point average (GPA) to continue to ");
                pw.println("receive the scholarship.");
                pw.println("You will be receiving a total amount of: $" + awarded[i].getAmount());
                pw.println("Sincerely, ");
                pw.println();
                pw.println();
                pw.println("Sharon ONeal");
                pw.println("Dean");
                pw.close();
                // Automaticaly opens .txt file on Excel
                Desktop.getDesktop().open(new File(fileNameTemp));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        i++;
            
        }
    }
}

