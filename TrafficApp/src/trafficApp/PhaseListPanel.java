package trafficApp;

import java.util.ArrayList;

public class PhaseListPanel {
	
	public static ArrayList<Object> phaseListPanelData()
	{
		FileReadandWrite rw = new FileReadandWrite();
		String[][] phaseListData=rw.readDataFromCSV("/Users/sandeep/Documents/intersection.csv");
		String[][] phaseListRowData = new String[phaseListData.length - 1][phaseListData[0].length];
		String[] phaseListColumnData = new String[phaseListData[0].length];
		int destinationRow = 0,destinationIndex = 0;
		
		//Getting Data from phaseListData
		for (String[] row : phaseListData) {
		    if (destinationRow > 0) {
		        int destinationColumn = 0;
		        for (String element : row) {
		        	phaseListRowData[destinationRow-1][destinationColumn] = element;
		        	destinationColumn++;
		        }
		    }
		    destinationRow++;
		}
		
		//Getting Headers from phaseListData
		for (String element : phaseListData[0]) {
			phaseListColumnData[destinationIndex] = element;
			destinationIndex++;
		}
		
		ArrayList<Object> arraysList = new ArrayList<Object>();
        arraysList.add(phaseListRowData);
        arraysList.add(phaseListColumnData);

        return arraysList;
		
	}
	
	
}
