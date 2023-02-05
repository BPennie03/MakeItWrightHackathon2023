package tabs.workorder;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * WorkOrderTab class for everything contained within the workOrder tab
 */
public class WorkOrderTab extends JPanel {

    private String scannerData;

    public WorkOrderTab() {

        // Text field for the scanner info to get inputted to
        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(450, 60));
        field.setFont(new Font("Courier", Font.BOLD, 20));

        // Setting the label for the button because they don't support text wrapping for whatever reason :/
        JLabel label1 = new JLabel("Confirm");
        label1.setFont(new Font("Courier", Font.BOLD, 13));

        JLabel label2 = new JLabel("Commission");
        label2.setFont(new Font("Courier", Font.BOLD, 13));

        // Button Stuff
        JButton button = new JButton();
        button.setLayout(new BorderLayout());
        button.add(BorderLayout.CENTER, label1);
        button.add(BorderLayout.SOUTH, label2);
        button.setPreferredSize(new Dimension(100, 60));
        button.addActionListener(e -> {
            scannerData = field.getText();
            writeScannerData();
            field.setText(""); // Resets / Clears text in text field
        });

        // Add the text field and button to the panel
        this.add(field);
        this.add(button);

        // Create button to display the stock images for reference in presentation
        JButton stepButton = new JButton("Step 1");
        stepButton.addActionListener(e -> {
            JFrame frame = new JFrame("Pallets");
            frame.setVisible(true);
            frame.setSize(500,500);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("commissions.jpeg")));
            JLabel label = new JLabel(icon);
            frame.add(label);
        });
        this.add(stepButton);
    }

    /**
     * Method to write the scanner data that is scanned into the text field via the scanner into a .txt file for the
     * next step in creating the EPCIS event
     */
    private void writeScannerData() {
        try {
            PrintWriter pw = new PrintWriter("ScannerData.txt");
            pw.write(scannerData);
            pw.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}
