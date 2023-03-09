package trafficApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatisticsListPanel {
	
	public static ArrayList<Object> StatisticsListPanelData()
	{
		
		ArrayList<Object> vehiclesList = VehicleListPanel.vehiclesListPanelData();
		String[][] vehiclesListRowData = (String[][]) vehiclesList.get(0);
		String[] StatisticsListColumwData = {"Segment", "Waiting Time", "Waiting Length", "Cross Time"};
	
	    // calculating sums and averages by segment
	    Map<String, Integer> waitingTimeSum = new HashMap<>();
	    Map<String, Integer> lengthSum = new HashMap<>();
	    Map<String, Integer> counter = new HashMap<>();
	    for (String[] row : vehiclesListRowData) {
	        String segment = row[7];
	        int crossingTime = Integer.parseInt(row[2]);
	        int length = Integer.parseInt(row[4]);
	        if (!waitingTimeSum.containsKey(segment)) {
	        	waitingTimeSum.put(segment, crossingTime);
	            lengthSum.put(segment, length);
	            counter.put(segment, 1);
	        } else {
	        	waitingTimeSum.put(segment, waitingTimeSum.get(segment) + crossingTime);
	            lengthSum.put(segment, lengthSum.get(segment) + length);
	            counter.put(segment, counter.get(segment) + 1);
	        }
	    }
    
	    	//Customizing StatisticsListRowData based on calculations
		    String[][] StatisticsListRowData = new String[waitingTimeSum.size()][4];
		    int i = 0;
		    for (String segment : waitingTimeSum.keySet()) {
		        int CrossingTime = waitingTimeSum.get(segment);
		        int MaxLength = lengthSum.get(segment);
		        int avgCrossingTime = CrossingTime / counter.get(segment);
		        StatisticsListRowData[i][0] = segment;
		        StatisticsListRowData[i][1] = Integer.toString(CrossingTime);
		        StatisticsListRowData[i][2] = Integer.toString(MaxLength);
		        StatisticsListRowData[i][3] = Integer.toString(avgCrossingTime);
		        i++;
		    }
    

		    ArrayList<Object> arraysList = new ArrayList<Object>();
		    arraysList.add(StatisticsListRowData);
		    arraysList.add(StatisticsListColumwData);
		
		    return arraysList;
    
	}
	
}
