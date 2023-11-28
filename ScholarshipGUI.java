import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class ScholarshipGUI implements ActionListener {
    // create a new frame
    static JFrame f;

    public ScholarshipGUI(Scholarship[] scholarship, int[] recordAmount, Student[] applicant, Awarded[] awarded) {
        f = new JFrame("Scholarship Report Generator");

        // Create dropdown menu
        JLabel labelString = new JLabel("Select Scholarship");
        labelString.setBounds(10, 10, 150, 20);
        labelString.setVisible(true);
        f.add(labelString);

        //Define Array of choices to populate pulldown
        String[] choices = new String[recordAmount[2] + 1];
        int i;
        choices[0] = "All";
        for(i=1; i <= recordAmount[2]; i++)
        {
            choices[i] = scholarship[i-1].getScholarshipName();
        }

        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setBounds(160, 10, 250, 20);
        cb.setVisible(true);
        f.add(cb);

        // Create Button1. If pressed, Open Scholarships GUI
        JButton btn1 = new JButton(new AbstractAction("Scholarship Status") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reports scholarshipStatus = new Reports();

                try {
                    if (cb.getItemAt(cb.getSelectedIndex()).compareTo("all") == 0)
                    {
                        scholarshipStatus.printScholarshipStatus(scholarship, recordAmount, "all", cb.getSelectedIndex());
                    }
                    else
                    {
                        scholarshipStatus.printScholarshipStatus(scholarship, recordAmount, cb.getItemAt(cb.getSelectedIndex()), cb.getSelectedIndex());
                    }
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btn1.setBounds(10, 50, 200, 50);
        f.add(btn1);

        // Create Button2. If pressed, Awarded Applicants
        JButton btn2 = new JButton(new AbstractAction("Awarded Applicants") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reports awardedApplicants = new Reports();
                try {
                    awardedApplicants.printAwardedApplicants(scholarship, recordAmount,
                            cb.getItemAt(cb.getSelectedIndex()), cb.getSelectedIndex(), awarded);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        });
        btn2.setBounds(10, 110, 200, 50);
        f.add(btn2);

        // Create Button3. If pressed, congratulation letter will display
        JButton btn3 = new JButton(new AbstractAction("Print Awarded Letters") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reports awardedLetteReports = new Reports();

                awardedLetteReports.printAwardedLetteReports(recordAmount, awarded, applicant);
            }
        });
        btn3.setBounds(10, 170, 200, 50);
        f.add(btn3);

        //Create Button4. If pressed, Awarded Applicants
        JButton btn4 = new JButton(new AbstractAction("Eligible Applicants") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reports awardedApplicants = new Reports();

                awardedApplicants.printEligibleApplicants(applicant, scholarship, recordAmount,
                            cb.getItemAt(cb.getSelectedIndex()), cb.getSelectedIndex(), awarded);
            }
        });
        btn4.setBounds(10, 230, 200, 50);
        f.add(btn4);       

        f.setSize(500,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
