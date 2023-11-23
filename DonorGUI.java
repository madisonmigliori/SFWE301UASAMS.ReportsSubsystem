import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class DonorGUI  implements ActionListener {

    // create a new frame
    static JFrame f;

    public DonorGUI(Scholarship[] scholarship, int[] recordAmount) {
        f = new JFrame("Donor Report Generator");

        JLabel labelString = new JLabel("Select Donor");
        labelString.setBounds(10, 10, 150, 20);
        labelString.setVisible(true);
        f.add(labelString);

        //Define Array of choices to populate pulldown
        String[] choices = new String[recordAmount[2] + 1];
        int i;
        choices[0] = "All";
        for(i=1; i <= recordAmount[2]; i++)
        {
            choices[i] = scholarship[i-1].getDonorName();
        }

        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setBounds(160, 10, 250, 20);
        cb.setVisible(true);
        f.add(cb);

        // Create Button1. If pressed, Awarded Applicants
        JButton btn1 = new JButton(new AbstractAction("Donor Info") {
            @Override
            public void actionPerformed(ActionEvent e) {
               //ToDo
            }
        });
        btn1.setBounds(10, 50, 200, 50);
        f.add(btn1);

        // Display GUI interface
        f.setSize(500,300);
        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}