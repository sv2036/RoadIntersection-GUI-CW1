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
            BufferedReader breader = new BufferedReader(new FileReader(path));
            while ((line = breader.readLine()) != null)
            {
            	counter++;
                String[][] extracteddata = new String[counter][2];
                String content[] = line.split(",");
                extracteddata[counter - 1] = content;
                System.arraycopy(fileinfo, 0, extracteddata, 0, counter - 1);
                fileinfo = extracteddata;
            }
            breader.close();
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
            FileWriter fwriter = new FileWriter(logFile);
            fwriter.write("Total number of vehicles crossed per phase: 10 \n");
            fwriter.write("Average waiting time to cross : 5 sec \n");
            fwriter.write("Total Emissions : 10 205 kg\n");
            fwriter.close();
            
        } catch (IOException e) {
           
            e.printStackTrace();
        }
	}
	
}
