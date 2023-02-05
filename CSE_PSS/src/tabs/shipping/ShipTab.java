package tabs.shipping;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * ShipTab contains everything within the shipTab tab under the swing application
 */
public class ShipTab extends JPanel {
    private final JButton submitBtn = new JButton();
    private JPanel btnPanel = new JPanel();
    private JPanel eventPanel = new JPanel();
    private ArrayList<ShippingEvent> eventList;

    public ShipTab(ArrayList <ShippingEvent> eventList){

        this.eventList = eventList;

        updateEvents();

        this.setLayout(new BorderLayout());
        this.add(eventPanel, BorderLayout.CENTER);
        this.add(btnPanel, BorderLayout.SOUTH);

        // Button stuff
        btnPanel.add(submitBtn);
        JButton stepButton = new JButton("Step 3");

        // Button listener to display stock images when clicked
        stepButton.addActionListener(e ->{
            JFrame frame = new JFrame("Reports");
            frame.setVisible(true);
            frame.setSize(500,300);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("shipping.jpeg")));
            JLabel label = new JLabel(icon);
            frame.add(label);
        });
        btnPanel.add(stepButton);

        submitBtn.setText("Submit");
        submitBtn.addActionListener(e -> btnPressed());
    }

    // The btnPressed and updateEvents methods work together to dynamically re-display the checkboxes after and during
    // simulating submitting events
    public void btnPressed() {
        ArrayList<ShippingEvent> tempEvents = new ArrayList<>();
        for (ShippingEvent event : eventList) {
            if (!event.isChecked()) {
                tempEvents.add(event);
            } else {
                eventPanel.remove(event);
            }
            eventPanel.revalidate();
            eventPanel.repaint();
        }

        this.eventList = tempEvents;
        updateEvents();
    }

    private void updateEvents() {
        for (ShippingEvent event : eventList) {
            eventPanel.add(event);
            eventPanel.repaint();
        }
    }

}
