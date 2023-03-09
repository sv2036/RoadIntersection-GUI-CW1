package trafficApp;


import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Intersection {
	public static void main(String[] args) {
		
		ArrayList<Object> phaseList = PhaseListPanel.phaseListPanelData();
		String[][] phaseListRowData = (String[][]) phaseList.get(0);
        String[] phaseListColumnData = (String[]) phaseList.get(1);
        
        ArrayList<Object> vehiclesList = VehicleListPanel.vehiclesListPanelData();
		String[][] vehiclesListRowData = (String[][]) vehiclesList.get(0);
        String[] vehiclesListColumnData = (String[]) vehiclesList.get(1);
				
        ArrayList<Object> statisticsList = StatisticsListPanel.StatisticsListPanelData();
		String[][] StatisticsListRowData = (String[][]) statisticsList.get(0);
        String[] StatisticsListColumnData = (String[]) statisticsList.get(1);
		
		
		JPanel tablePanel = new JPanel();
		
		JTable phaseTable = new JTable(phaseListRowData, phaseListColumnData);
		JTable vehicleTable = new JTable(vehiclesListRowData, vehiclesListColumnData);
		JTable StatisticsTable = new JTable(StatisticsListRowData, StatisticsListColumnData);
	    JScrollPane phaseScrollPane = new JScrollPane(phaseTable);
	    JScrollPane vehicleScrollPane = new JScrollPane(vehicleTable);
	    JScrollPane StatisticsScrollPane = new JScrollPane(StatisticsTable);
	     
	    tablePanel.setLayout(new GridLayout(2,1));
	        
	    tablePanel.add(phaseScrollPane);
	    tablePanel.add(vehicleScrollPane);
	    tablePanel.add(StatisticsScrollPane);
	    
	      

	    
	        JFrame frame = new JFrame();
	        frame.add(tablePanel);
	        frame.setLayout(new GridLayout(2, 1));
	        frame.setSize(800, 800);
	        frame.setVisible(true);
	}

}
