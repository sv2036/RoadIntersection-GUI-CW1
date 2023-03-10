package trafficApp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Intersection extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton AddVehicleButton = null;
	private JTable vehicleToAddTable;
	private JTable  vehicleTable;
	private JButton ExitButton ;
	private JButton CancelButton = null;
	private JPanel tablePanel;
	String[][] vehiclesListRowData=null;
	Object[][] userAddVehicleData = {{" ", " ", " ", " ", " ", " ", " ", " "}};
	Object[] addVehicleColumn = {"Vehicle", "Type", "Crossing time", "Directions", "Length", "Emission", "Status", "Segment"};
	DefaultTableModel addVehicleModel = new DefaultTableModel(userAddVehicleData, addVehicleColumn);
	DefaultTableModel vehicleModel = null;
	String[] rowData=null;

	public Intersection() throws IntersectionCustomException {

		setTitle("Traffic Intersection GUI");
		setSize(1300, 1300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 1));

		//Fetching phases Data
		ArrayList<Object> phaseList = PhaseListPanel.phaseListPanelData();
		String[][] phaseListRowData = (String[][]) phaseList.get(0);
		String[] phaseListColumnData = (String[]) phaseList.get(1);

		//Fetching vehicles Data
		ArrayList<Object> vehiclesList = VehicleListPanel.vehiclesListPanelData();
		vehiclesListRowData = mergeVehicleData(rowData);
		String[] vehiclesListColumnData = (String[]) vehiclesList.get(1);

		//fetching statistics Data
		ArrayList<Object> statisticsList = StatisticsListPanel.StatisticsListPanelData();
		String[][] StatisticsListRowData = (String[][]) statisticsList.get(0);
		String[] StatisticsListColumnData = (String[]) statisticsList.get(1);

		//creating table panel to add all tables in GUI
		tablePanel = new JPanel(new GridLayout(1, 3));
		JTable phaseTable = new JTable(phaseListRowData, phaseListColumnData);
		JTable StatisticsTable = new JTable(StatisticsListRowData, StatisticsListColumnData);

		JScrollPane phaseScrollPane = new JScrollPane(phaseTable);
		JScrollPane StatisticsScrollPane = new JScrollPane(StatisticsTable);
		phaseTable.setPreferredScrollableViewportSize(new Dimension(150, 100));

		StatisticsTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
		phaseTable.setGridColor(Color.BLACK);
		StatisticsTable.setGridColor(Color.BLACK); 

		//vehicle table
		vehicleModel = new DefaultTableModel(vehiclesListRowData, vehiclesListColumnData);
		vehicleTable = new JTable(vehicleModel);
		JScrollPane vehicleScrollPane = new JScrollPane(vehicleTable);
		vehicleTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
		vehicleTable.setGridColor(Color.BLACK);

		tablePanel.add(phaseScrollPane);
		tablePanel.add(vehicleScrollPane);
		tablePanel.add(StatisticsScrollPane);

		//adding to JFrame
		add(tablePanel);

		vehicleToAddTable = new JTable(addVehicleModel);
		vehicleToAddTable.setGridColor(Color.GRAY);

		//creation of buttons
		AddVehicleButton = new JButton("Add Vehicle");
		CancelButton = new JButton("Cancel");
		ExitButton = new JButton("Exit");
		JLabel CO2Label = new JLabel("CO2");

		//adding to panel
		JPanel buttonPanel = new JPanel((LayoutManager) new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(AddVehicleButton);
		buttonPanel.add(CancelButton);
		buttonPanel.add(ExitButton);

		//Adding action Listeners to buttons
		AddVehicleButton.addActionListener(this);
		CancelButton.addActionListener(this);
		ExitButton.addActionListener(this);

		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labelPanel.add(CO2Label);
		JTextField CO2TextField = new JTextField(10);
		CO2TextField.setText("10 205 kg"); 
		labelPanel.add(CO2TextField);

		//creation of second panel
		JPanel buttonsAndLabel = new JPanel(new GridLayout(1, 1));
		buttonsAndLabel.add(new JScrollPane(vehicleToAddTable));
		buttonsAndLabel.add(buttonPanel);
		buttonsAndLabel.add(labelPanel);

		add(buttonsAndLabel);

		setVisible(true);
	}

	public static void main(String[] args) {


		try {
			new Intersection();
		} 
		catch (IntersectionCustomException e) {

			System.err.println("Error: " + e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//if the click event is from add button, this is the method to perform - add each row data to the Vehicles
		if(e.getSource() == AddVehicleButton)
		{

			String[] rowData = new String[vehicleToAddTable.getColumnCount()];
			for (int i = 0; i < vehicleToAddTable.getColumnCount(); i++)
			{
				rowData[i] = (String) vehicleToAddTable.getValueAt(0, i);
				System.out.print(rowData[i]);
			}
			vehiclesListRowData= mergeVehicleData(rowData);
			vehicleModel.setRowCount(0); // clear old data
			for (Object[] x : vehiclesListRowData) {
				vehicleModel.addRow(x); // add new data
			}
			vehicleTable.revalidate(); // re-layout components
			vehicleTable.repaint();
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

			addVehicleModel.setNumRows(0);
			addVehicleModel.setNumRows(1);
		}

	}

	//Merging vehicleData and NewData 
	private String[][] mergeVehicleData(String[] rowData) {

		ArrayList<Object> vehiclesList = VehicleListPanel.vehiclesListPanelData();
		String[][] vehiclesListRowData = (String[][]) vehiclesList.get(0);

		int numRows = vehiclesListRowData.length + 1;
		int numCols = vehiclesListRowData[0].length;
		String[][] appendedArray = new String[numRows][numCols];

		for (int i = 0; i < vehiclesListRowData.length; i++) {
			for (int j = 0; j < vehiclesListRowData[i].length; j++) {
				appendedArray[i][j] = vehiclesListRowData[i][j];
			}
		}

		if(rowData!=null) {

			for (int i = 0; i < rowData.length; i++) {
				appendedArray[numRows - 1][i] = rowData[i];
			}

		}

		return appendedArray;



	}


}
