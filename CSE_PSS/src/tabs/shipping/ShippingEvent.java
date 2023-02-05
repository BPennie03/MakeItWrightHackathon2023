package tabs.shipping;

import javax.swing.*;
import java.awt.*;

public class ShippingEvent extends JPanel {

    private final JLabel label = new JLabel();
    private final JCheckBox checkBox = new JCheckBox();

    private final int totalUnits;

    public ShippingEvent(int totalUnits, String SSCC, String description){
        this.totalUnits = totalUnits;
        final int rows = 1;
        final int cols = 2;

        // Layout managing
        this.setLayout(new GridLayout(rows, cols));

        // Working with labels and checkboxes
        this.label.setText("SSCC #: " + SSCC);
        this.checkBox.setPreferredSize(new Dimension(this.getWidth() / 4, this.getHeight() - 5));

        // Adding things to this panel
        this.add(this.checkBox);
        this.add(this.label);
    }

    public boolean isChecked(){
        return this.checkBox.isSelected();
    }

    @Override
    public String toString() {
        return this.label.getText();
    }

}
