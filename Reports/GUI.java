import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;

public class GUI implements ActionListener {
    static JFrame f;

    public GUI() throws IOException {
        // Requirement: 1 ) Import Application Data - The report Engine subsystem shall be able to import 
        //                  the application name, ID, year, Academic Standing, GPA, Major,Minor, Expected
        //                  graduation date, field of interest, gender, transfer student, units, and 
        //                  demographics from the Back-end subsystem.

        // Requirement: 2 ) Eligible Applicants - The report Engine subsystem shall generate a report
        //                  a report of applicants that meet scholarship requirements for a given 
        //                  scholarship.

        // Create a an object to have access to its functions
        ReadInputCsvFiles applicantsData = new ReadInputCsvFiles();
        DonorReport donorData = new DonorReport();
        AwardDisbursementReport disburmentData = new AwardDisbursementReport();
        ScholarshipReports scholarshipReportsData = new ScholarshipReports();
        MatchingReport matchingData = new MatchingReport();

                
        // Additional arguments can be set to do different things.
        String [] args = {"All"};
        
        // Call parseCsvInfo to extract data from the following files
        // 1) Report Formating.csv                          -> Student[], totalAmount[0]
        // 2) Awarded.csv                                   -> Awarded[], totalAmount[1]
        // 3) Report Fromatting - Scholarship Reports.csv   -> Scholarship[], totalAmount[2]
        int[] recordAmount = applicantsData.parseCsvInfo(args);
        int numDonor = donorData.readFile();
        disburmentData.readIn("Awarded.csv");
        matchingData.ReadCSVFile();

        // create a new frame
        f = new JFrame("Report Generator");

        //Font
        Font uaFont = new Font("Arial",Font.BOLD, 12);

        //Icon
        ImageIcon ua = new ImageIcon("ua_block_rgb_blue.png");
        f.setIconImage(ua.getImage());

        //Header
        // JLabel headerLabel = new JLabel("University of Arizona Report Generator");
        // headerLabel.setBackground(new Color(171, 5, 32));
        // headerLabel.setForeground(new Color(171, 5, 32)); // Customize font color if needed
        // headerLabel.setBounds(90, 10, 300, 30); // Adjust the bounds according to your layout
        // f.add(headerLabel, BorderLayout.CENTER);

        // Create Button1. If pressed, Open Scholarships GUI
        JButton button1 = new JButton( new AbstractAction("Scholarships") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                new ScholarshipGUI(applicantsData.scholarship, recordAmount, applicantsData.student, applicantsData.awarded);
            }
        });

        button1.setBounds(90, 50, 200, 40);
        // // button1.setBackground(new Color(171, 5, 32));
        // // button1.setFont(uaFont);
        // button1.setForeground(Color.WHITE);

         // Create Button2. If pressed, Open Applicants Data GUI
        JButton button2 = new JButton(new AbstractAction("Applicants Report"){
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
        button1.setBounds(90, 100, 200, 40);;
        // button2.setBackground(new Color(171, 5, 32));
        // button2.setFont(uaFont);
        // button2.setForeground(Color.WHITE);
        
        // Create Button3. If pressed, Open Donor Data GUI
        JButton button3 = new JButton(new AbstractAction("Donors Report"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                try {
                    donorData.generateReport(donorData.donor, numDonor);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        button3.setBounds(90, 150, 200, 40);
        // button3.setBackground(new Color(171, 5, 32));
        // button3.setFont(uaFont);
        // button3.setForeground(Color.WHITE);

        JButton button4 = new JButton(new AbstractAction("Matching Report"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                ///new DonorGUI(applicantsData.scholarship, recordAmount);
                    try {
                        matchingData.GenerateReport(matchingData.getDataList());
                       // matchingData.CustomizedReport(matchingData.getDataList());
       
        // Process the input
   
                        
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                
            }
        });

        button4.setBounds(90, 200, 200, 40);
        // button4.setBackground(new Color(171, 5, 32));
        // button4.setFont(uaFont);
        // button4.setForeground(Color.WHITE);


        // Create Button. If pressed, Open Donor Data GUI
        JButton button5 = new JButton(new AbstractAction("Disbursement Report"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                try {
                    disburmentData.filterList();
                    disburmentData.writeOut();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        button5.setBounds(90, 250, 200, 40);
        // button5.setBackground(new Color(171, 5, 32));
        // button5.setFont(uaFont);
        // button5.setForeground(Color.WHITE);

        //Create Button

        // Create Button5. If pressed, Sue's code will be launch
        JButton button6 = new JButton(new AbstractAction("Additional Scholarship Filters"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                ScholarshipReportsData.ScholarReport(applicantsData.awarded);
            }
        });
        button6.setBounds(90, 300, 200, 40);
        // button6.setBackground(new Color(171, 5, 32));
        // button6.setFont(uaFont);
        // button6.setForeground(Color.WHITE);

        // Create Button6. If pressed, Sue's code will be launch
        JButton button7 = new JButton(new AbstractAction("Yearly or Monthly Report"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                new YearlyMonthlyGUI(applicantsData.scholarship, recordAmount, applicantsData.awarded);
            }
        });

        button7.setBounds(90, 350, 200, 40);
        // button7.setBackground(new Color(171, 5, 32));
        // button7.setFont(uaFont);
        // button7.setForeground(Color.WHITE);

        // Create Button7. Closes GUI
        JButton button8 = new JButton(new AbstractAction("Exit"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.exit(0);
            }
        });
        button8.setBounds(250, 400, 100, 50);
        // button8.setBackground(new Color(171, 5, 32));
        // button8.setFont(uaFont);
        // button8.setForeground(Color.WHITE);


        f.add(button1, BorderLayout.CENTER);
        f.add(button2, BorderLayout.CENTER);
        f.add(button3, BorderLayout.CENTER);
        f.add(button4, BorderLayout.CENTER);
        f.add(button5, BorderLayout.CENTER);
        f.add(button6, BorderLayout.CENTER);
        f.add(button7, BorderLayout.CENTER);
        f.add(button8, BorderLayout.CENTER);

        

        // set the size of frame
        f.setSize(500, 500); 
       // f.getContentPane().setBackground(new Color(244, 237, 229)) ; 
        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
