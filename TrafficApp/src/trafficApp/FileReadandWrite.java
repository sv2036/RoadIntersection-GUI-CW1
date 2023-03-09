package trafficApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


//class to handle read and write files.
public class FileReadandWrite {
	
	//Method To Read data from CSV file based on path.
	public String[][] readDataFromCSV(String path)
	{
		String line = "";
		int counter=0;
		String[][] fileinfo = new String[0][];
		try {  
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null)
            {
            	counter++;
                String[][] extracteddata = new String[counter][2];
                String content[] = line.split(",");
                extracteddata[counter - 1] = content;
                System.arraycopy(fileinfo, 0, extracteddata, 0, counter - 1);
                fileinfo = extracteddata;
            }
            br.close();
        } 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return fileinfo;
				
	}
	//Method To Write data from CSV file based on path.
	public void WriteDataFromCSV() 
	{
		String logFile = "log.txt";

        try {
            FileWriter writer = new FileWriter(logFile);
            writer.write("Total number of vehicles crossed per phase: 10 \n");
            writer.write("Average waiting time to cross : 12\n");
            writer.write("Total Emissions : 12\n");
            writer.close();
            
        } catch (IOException e) {
           
            e.printStackTrace();
        }
	}
	
}
