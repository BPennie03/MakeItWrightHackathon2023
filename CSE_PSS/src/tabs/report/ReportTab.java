package tabs.report;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * ReportTab containing anything and everthing within the report tab in the app
 */
public class ReportTab extends JPanel {


    public ReportTab(){

        JPanel buttonPanel = new JPanel();

        // Button stuff
        JButton button = new JButton("Display Stats");
        buttonPanel.setLayout(new FlowLayout());
        button.setPreferredSize(new Dimension(400,100));
        button.setFont(new Font("Courier", Font.BOLD, 23));

        // Button listener to display stock images when clicked
        button.addActionListener(e ->{
            JFrame frame = new JFrame("Reports");
            frame.setVisible(true);
            frame.setSize(600,400);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("temperature.png")));
            JLabel label = new JLabel(icon);
            frame.add(label);
        });
        buttonPanel.add(button);
        this.add(buttonPanel);
    }

}
