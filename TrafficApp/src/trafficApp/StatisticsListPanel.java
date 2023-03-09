package trafficApp;

import java.util.ArrayList;

public class StatisticsListPanel {
	
	public static ArrayList<Object> StatisticsListPanelData()
	{
	
    String StatisticsListRowData[][] = {   {"S1", "600s", "2000m", "20s"},
					            		   {"S2", "60s", "300m", "10s"},
					                       {"S3", "300s", "1500m", "15s"},
					                       {"S4", "40s", "100m", "10s"},};
    String[] StatisticsListColumnData = {"Segment", "Waiting Time", "Waiting Length", "Cross Time"};
	
	
    ArrayList<Object> arraysList = new ArrayList<Object>();
    arraysList.add(StatisticsListRowData);
    arraysList.add(StatisticsListColumnData);

    return arraysList;
    
	}
	

}
