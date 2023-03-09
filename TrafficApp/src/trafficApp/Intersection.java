package trafficApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Intersection extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton AddVehicleButton = null;
	private JTable vehicleToAddTable;
	private JButton ExitButton ;
	private JButton CancelButton = null;
	private JPanel tablePanel;

	public Intersection() throws IntersectionCustomException {
		
		 setTitle("Traffic Intersection GUI");
	     setSize(1300, 1300);
	     setDefaultCloseOperation(EXIT_ON_CLOSE);
	     setLayout(new GridLayout(2, 1));
 
		new FileReadandWrite().WriteDataFromCSV();
		
		//Fetching phases Data
		ArrayList<Object> phaseList = PhaseListPanel.phaseListPanelData();
		String[][] phaseListRowData = (String[][]) phaseList.get(0);
        String[] phaseListColumnData = (String[]) phaseList.get(1);
        
      //Fetching vehicles Data
        ArrayList<Object> vehiclesList = VehicleListPanel.vehiclesListPanelData();
		String[][] vehiclesListRowData = (String[][]) vehiclesList.get(0);
        String[] vehiclesListColumnData = (String[]) vehiclesList.get(1);

		
        //fetching statistics Data
        ArrayList<Object> statisticsList = StatisticsListPanel.StatisticsListPanelData();
		String[][] StatisticsListRowData = (String[][]) statisticsList.get(0);
        String[] StatisticsListColumnData = (String[]) statisticsList.get(1);
		
		

       
		 tablePanel = new JPanel(new GridLayout(1, 3));
		JTable phaseTable = new JTable(phaseListRowData, phaseListColumnData);
		JTable vehicleTable = new JTable(vehiclesListRowData, vehiclesListColumnData);
		JTable StatisticsTable = new JTable(StatisticsListRowData, StatisticsListColumnData);
	    JScrollPane phaseScrollPane = new JScrollPane(phaseTable);
	    JScrollPane vehicleScrollPane = new JScrollPane(vehicleTable);
	    JScrollPane StatisticsScrollPane = new JScrollPane(StatisticsTable);
	    phaseTable.setPreferredScrollableViewportSize(new Dimension(150, 100));
	    vehicleTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
	    StatisticsTable.setPreferredScrollableViewportSize(new Dimension(200, 100));

	    phaseTable.setGridColor(Color.BLACK);
	    vehicleTable.setGridColor(Color.BLACK);
	    StatisticsTable.setGridColor(Color.BLACK); 


	    tablePanel.add(phaseScrollPane);
	    tablePanel.add(vehicleScrollPane);
	    tablePanel.add(StatisticsScrollPane);
	    
	    add(tablePanel);
	    
	 
	    
	
        
	    Object[][] userAddVehicleData = {{" ", " ", " ", " ", " ", " ", " ", " "}};
	    Object[] addVehicleColumn = {"Vehicle", "Type", "Crossing time", "Directions", "Length", "Emission", "Status", "Segment"};
	   vehicleToAddTable = new JTable(userAddVehicleData, addVehicleColumn);
	   vehicleToAddTable.setGridColor(Color.GRAY);
	    //JTable vehiclesTable = new JTable();
	    //BUTTONS for GUIJButton 
	     AddVehicleButton = new JButton("Add Vehicle");
	    CancelButton = new JButton("Cancel");
	    ExitButton = new JButton("Exit");
	    JLabel CO2Label = new JLabel("CO2");
        JPanel buttonPanel = new JPanel((LayoutManager) new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(AddVehicleButton);
        buttonPanel.add(CancelButton);
        buttonPanel.add(ExitButton);
        AddVehicleButton.addActionListener(this);
        CancelButton.addActionListener(this);
        ExitButton.addActionListener(this);
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.add(CO2Label);
        JTextField CO2TextField = new JTextField(10);
        labelPanel.add(CO2TextField);
        JPanel secondRow = new JPanel(new GridLayout(1, 1));
        secondRow.add(new JScrollPane(vehicleToAddTable));
        secondRow.add(buttonPanel);
        secondRow.add(labelPanel);
	    
        add(secondRow);

	        setVisible(true);
	}
	
	public static void main(String[] args) {
		
		
		 try {
	            new Intersection();
	        } catch (IntersectionCustomException e) {
	            System.err.println("Error: " + e.getMessage());
	        }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//if the click event is from add button, this is the method to perform - add each row data to the Vehicles
        if(e.getSource() == AddVehicleButton)
        {
        	
        	Object[] rowData = new Object[vehicleToAddTable.getColumnCount()];
            for (int i = 0; i < vehicleToAddTable.getColumnCount(); i++)
            {
                rowData[i] = vehicleToAddTable.getValueAt(0, i);
                System.out.print(rowData[i]);
            }
            tablePanel.revalidate(); // re-layout components
            tablePanel.repaint();
        }

        //if the click event is from "exit" button, this is the method to perform - dispose window
        else if (e.getSource() == ExitButton)
        {

        	dispose();
        	new FileReadandWrite().WriteDataFromCSV();
        }

        //if the click event is from "cancel" button, this is the method to perform - delete(0) the row, then add new(1) one
        else if (e.getSource() == CancelButton)
        {
            
        }
		
	}

	
}
