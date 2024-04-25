import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class YearlyMonthlyGUI  implements ActionListener {

    // create a new frame
    static JFrame f;

    public YearlyMonthlyGUI(Scholarship[] scholarship, int[] recordAmount, Awarded[] awarded) {
        f = new JFrame("Yearly and Monthly Report Generator");

        JLabel labelString = new JLabel("Select Yearly or a specific Month");
        labelString.setBounds(10, 10, 150, 20);
        labelString.setVisible(true);
        f.add(labelString);

        //Define Array of choices to populate pulldown
        String[] choices = new String[recordAmount[2] + 1];

        choices = new String[] {"Yearly","January","February","March","April","May","June","July","August","September","October","November","December"};

        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setBounds(160, 10, 250, 20);
        cb.setVisible(true);
        f.add(cb);

        // Create Button1. If pressed, Awarded Applicants
        JButton btn1 = new JButton(new AbstractAction("Process Report") {
            @Override
            public void actionPerformed(ActionEvent e) {
                YearlyMonthlyReport applicantData = new YearlyMonthlyReport();
                try {
                    applicantData.printYearlyMonthly(scholarship, recordAmount, cb.getItemAt(cb.getSelectedIndex()), cb.getSelectedIndex(), awarded);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btn1.setBounds(10, 50, 200, 50);
        f.add(btn1);

        // Display GUI interface
        f.setSize(500,150);
        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
