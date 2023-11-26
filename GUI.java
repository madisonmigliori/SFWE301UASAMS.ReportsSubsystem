import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class GUI implements ActionListener {
    static JFrame f;

    public GUI() {
        // Requirement: 1 ) Import Application Data - The report Engine subsystem shall be able to import 
        //                  the application name, ID, year, Academic Standing, GPA, Major,Minor, Expected
        //                  graduation date, field of interest, gender, transfer student, units, and 
        //                  demographics from the Back-end subsystem.

        // Requirement: 2 ) Eligible Applicants - The report Engine subsystem shall generate a report
        //                  a report of applicants that meet scholarship requirements for a given 
        //                  scholarship.

        // Create a an object of ReadInputCsvFiles to have access to its functions
        ReadInputCsvFiles applicantsData = new ReadInputCsvFiles();
        DonorReport donorData = new DonorReport();
        AwardDisbursementReport disburmentData = new AwardDisbursementReport();

                
        // Additional arguments can be set to do different things.
        String [] args = {"All"};
        
        // Call parseCsvInfo to extract data from the following files
        // 1) Report Formating.csv                          -> Student[], totalAmount[0]
        // 2) Awarded.csv                                   -> Awarded[], totalAmount[1]
        // 3) Report Fromatting - Scholarship Reports.csv   -> Scholarship[], totalAmount[2]
        int[] recordAmount = applicantsData.parseCsvInfo(args);
        int numDonor = donorData.readFile();
        disburmentData.readIn("Awarded.csv");

        // create a new frame
        f = new JFrame("Report Generator");

        // Create Button1. If pressed, Open Scholarships GUI
        JButton button1 = new JButton( new AbstractAction("Scholarships") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                new ScholarshipGUI(applicantsData.scholarship, recordAmount, applicantsData.student, applicantsData.awarded);
            }
        });
        button1.setBounds(90, 50, 200, 40);

         // Create Button2. If pressed, Open Applicants Data GUI
        JButton button2 = new JButton(new AbstractAction("Applicanats Report"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                ReadStudentInfo applicantData = new ReadStudentInfo();
                try {
                    applicantData.printOutput(applicantsData.student, recordAmount);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        button2.setBounds(90, 100, 200, 40);
        
        // Create Button3. If pressed, Open Donor Data GUI
        JButton button3 = new JButton(new AbstractAction("Donors Report"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                ///new DonorGUI(applicantsData.scholarship, recordAmount);
                try {
                    donorData.generateReport(donorData.donor, numDonor);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        button3.setBounds(90, 150, 200, 40);

        // Create Button4. If pressed, Open Donor Data GUI
        JButton button4 = new JButton(new AbstractAction("Disbursement Report"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                ///new DonorGUI(applicantsData.scholarship, recordAmount);
                try {
                    disburmentData.filterList();
                    disburmentData.writeOut();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        button4.setBounds(90, 200, 200, 40);

        // Create Button5. If pressed, Sue's code will be launch
        JButton button5 = new JButton(new AbstractAction("Sue's Code Report"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                ///new DonorGUI(applicantsData.scholarship, recordAmount);
/*                try {
                 // "SUE's CODE"
                  
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                */
            }
        });
        button5.setBounds(90, 250, 200, 40);
    
        // Create Button6. Closes GUI
        JButton button6 = new JButton(new AbstractAction("Exit"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.exit(0);
            }
        });
        button6.setBounds(250, 300, 100, 50);


        f.add(button1);
        f.add(button2);
        f.add(button3);
        f.add(button4);
        f.add(button5);
        f.add(button6);  

        // set the size of frame
        f.setSize(400, 400);   
        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
