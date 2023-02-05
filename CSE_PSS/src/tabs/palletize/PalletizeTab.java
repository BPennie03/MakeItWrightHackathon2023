package tabs.palletize;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;


public class PalletizeTab extends JPanel {

    private JPanel topPanel = new JPanel();
    private JPanel demoPanel = new JPanel();

    private final String GTIN = "(01) 10810055939197";
    private final String EXPIRATION = "(17) 230501";
    private final String BATCH_LOT = "(10) TRT001";
    private final String SERIAL_NUM = "(21) 1QH001006";


    public PalletizeTab(){

        this.setLayout(new BorderLayout());
        demoPanel.setLayout(new GridLayout(4, 2));


        // Create and initialize this panel/tab's text field
        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(450, 60));
        field.setFont(new Font("Courier", Font.BOLD, 20));

        // Setting the label for the button because they don't support text wrapping for whatever reason :/
        JLabel label1 = new JLabel("Palletize");
        label1.setFont(new Font("Courier", Font.BOLD, 13));

        JLabel label2 = new JLabel("Order");
        label2.setFont(new Font("Courier", Font.BOLD, 13));

        // Button Stuff
        JButton button = new JButton();
        button.setLayout(new BorderLayout());
        button.add(BorderLayout.CENTER, label1);
        button.add(BorderLayout.SOUTH, label2);
        button.setPreferredSize(new Dimension(100, 60));
        // Creates te "submit" button
        button.addActionListener(e -> {
            field.setText("");
        });


        initLabelAndTextField("GTIN", GTIN);
        initLabelAndTextField("Expiration", EXPIRATION);
        initLabelAndTextField("Batch Lot", BATCH_LOT);
        initLabelAndTextField("Serial Number", SERIAL_NUM);


        // adding the text field and button to this panel
        this.add(field);
        this.add(button);
        topPanel.add(field);
        topPanel.add(button);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(demoPanel, BorderLayout.CENTER);

        JButton stepButton = new JButton("Step 2");
        stepButton.addActionListener(e ->{
            JFrame frame = new JFrame("Pallets");
            frame.setVisible(true);
            frame.setSize(500,500);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("pallets.jpeg")));
            JLabel label = new JLabel(icon);
            frame.add(label);
        });
        this.add(stepButton, BorderLayout.SOUTH);
    }


    public void initLabelAndTextField(String text, String textFieldText) {
        JLabel textFieldLabel = new JLabel(text + ": ");
        JTextField textField = new JTextField(textFieldText);
        textField.setEditable(false);
        demoPanel.add(textFieldLabel);
        demoPanel.add(textField);
    }
}
