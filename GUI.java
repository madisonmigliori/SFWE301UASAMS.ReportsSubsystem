import java.awt.event.*;
import javax.swing.*;

public class GUI implements ActionListener {
    static JFrame f;

    public GUI() {
        // create a new frame
        f = new JFrame("Report Generator");

        // Create Button1. If pressed, parse file and extract data into Student Class
        // Requirement: 1 ) Import Application Data - The report Engine subsystem shall be able to import 
        //                  the application name, ID, year, Academic Standing, GPA, Major,Minor, Expected
        //                  graduation date, field of interest, gender, transfer student, units, and 
        //                  demographics from the Back-end subsystem.

        // Create Button1. If pressed, parse file and Import applicant data
        JButton button1 = new JButton( new AbstractAction("Import Applicants Data") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                ReadStudentInfo StudentInfo = new ReadStudentInfo();
                
                // Additional arguments can be set to do different things.
                // For now I just set it to "all"
                String [] args = {"all"};
                StudentInfo.parseCsvInfo(args);
            }
        });
        button1.setBounds(90, 50, 200, 50);

        // Create Button2. If pressed, parse file and extract Eligble applicants
        // Requirement: 1 ) Eligible Applicants - The report Engine subsystem shall generate a report
        //                  a report of applicants that meet scholarship requirements for a given 
        //                  scholarship.

        // Create Button2. If pressed, parse file and extract 
        JButton button2 = new JButton(new AbstractAction("Report Eligible Applicants"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.out.println("Stub for Eligible Applicants");
            }
        });
        button2.setBounds(90, 120, 200, 50);
        
        // Create Button3. Closes GUI
        JButton button3 = new JButton(new AbstractAction("Exit"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.exit(0);
            }
        });
        button3.setBounds(250, 250, 100, 50);

        f.add(button1);
        f.add(button2);
        f.add(button3);

        // set the size of frame
        f.setSize(400, 400);

        // f.show();
        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
