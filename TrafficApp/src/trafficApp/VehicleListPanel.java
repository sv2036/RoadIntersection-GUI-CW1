package trafficApp;

import java.util.ArrayList;

public class VehicleListPanel {
	
	public static ArrayList<Object> vehiclesListPanelData()
	{
		FileReadandWrite rw = new FileReadandWrite();
		String[][] vehiclesListData=rw.readDataFromCSV("vehicles.csv");
		String[][] vehiclesListRowData = new String[vehiclesListData.length - 1][vehiclesListData[0].length];
		String[] vehiclesListColumnData = new String[vehiclesListData[0].length];
		int destinationRow = 0,destinationIndex = 0;
		
		//Getting Data from vehiclesListData
		for (String[] row : vehiclesListData) {
		    if (destinationRow > 0) {
		        int destinationColumn = 0;
		        for (String element : row) {
		        	vehiclesListRowData[destinationRow-1][destinationColumn] = element;
		        	destinationColumn++;
		        }
		    }
		    destinationRow++;
		}
		
		//Getting Headers from vehiclesListData
		for (String element : vehiclesListData[0]) {
			vehiclesListColumnData[destinationIndex] = element;
			destinationIndex++;
		}
		
		ArrayList<Object> arraysList = new ArrayList<Object>();
        arraysList.add(vehiclesListRowData);
        arraysList.add(vehiclesListColumnData);

        return arraysList;
		
	}

}
