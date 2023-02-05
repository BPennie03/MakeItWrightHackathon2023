import tabs.palletize.PalletizeTab;
import tabs.report.ReportTab;
import tabs.shipping.ShipTab;
import tabs.shipping.ShippingEvent;
import tabs.workorder.WorkOrderTab;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Main frame of the application that acts as the foundation for the other nested panels and whatnot
 */
public class PharmaSol extends JFrame {

    public PharmaSol(String applicationName){

        // Initializes this main frame
        this.setName(applicationName);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(600,700));
        this.setLayout(new BorderLayout());

        // Creates a panel to display the following message above everything else
        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("Please select a panel: "));
        this.add(northPanel,BorderLayout.NORTH);

        // Creates the list of shipping events which gets populated in the initExampleShipments method
        ArrayList<ShippingEvent> shippingEventsExamples = initExampleShipments();

        // Creating a new JTabbedPane and adding the following as tabs
        JTabbedPane tp = new JTabbedPane();
        tp.add("Worker Order", new WorkOrderTab());
        tp.add("Palletize", new PalletizeTab());
        tp.add("Ship!", new ShipTab(shippingEventsExamples));
        tp.add("Report", new ReportTab());
        this.add(tp, BorderLayout.CENTER);
        this.setVisible(true);
    }

    /**
     * initExampleShipments creates an initializes new Shipping Events for the purpose of example and demonstration
     * @return a list of example shipping events
     */
    private ArrayList<ShippingEvent> initExampleShipments(){

        ArrayList<ShippingEvent> shippingEventsExamples = new ArrayList<>();

        shippingEventsExamples.add(new ShippingEvent(12,"085002031790000012", "Example Drug 01"));
        shippingEventsExamples.add(new ShippingEvent(45,"056005534524735325", "Example Drug 02"));
        shippingEventsExamples.add(new ShippingEvent(97,"087456386940543243", "Example Drug 03"));
        shippingEventsExamples.add(new ShippingEvent(37,"756789769456742424", "Example Drug 04"));
        shippingEventsExamples.add(new ShippingEvent(86,"656748461929245442", "Example Drug 05"));
        shippingEventsExamples.add(new ShippingEvent(10,"019385764738644424", "Example Drug 06"));
        shippingEventsExamples.add(new ShippingEvent(10,"564830173810244425", "Example Drug 07"));
        shippingEventsExamples.add(new ShippingEvent(15,"654827494748590476", "Example Drug 08"));
        shippingEventsExamples.add(new ShippingEvent(78,"564830173810295677", "Example Drug 09"));
        shippingEventsExamples.add(new ShippingEvent(10,"564830173810250378", "Example Drug 10"));
        shippingEventsExamples.add(new ShippingEvent(65,"567495659567422499", "Example Drug 11"));
        shippingEventsExamples.add(new ShippingEvent(10,"564830173810290840", "Example Drug 12"));
        shippingEventsExamples.add(new ShippingEvent(92,"988749576383300911", "Example Drug 13"));
        shippingEventsExamples.add(new ShippingEvent(72,"275839572840303412", "Example Drug 14"));
        shippingEventsExamples.add(new ShippingEvent(25,"564830173810213783", "Example Drug 15"));

        return shippingEventsExamples;
    }
}
