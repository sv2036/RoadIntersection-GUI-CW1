package trafficApp;
import javax.swing.JButton;
import java.awt.*;                     // Using AWT container and component classes
import java.awt.event.ActionEvent;     // Using AWT event classes and listener interfaces
import java.awt.event.ActionListener;  // Using AWT event classes and listener interfaces
import java.util.Scanner;              // Import the Scanner class to read text files
import java.io.File;                   // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

// Defining an inner class to handle the "EXIT" button-click

class ActionEventbuttonclick implements ActionListener {
 
private JButton ExitButton;
 
ActionEventbuttonclick (){

}
// ActionEvent handler - Called back upon button-click

 @Override
    public void actionPerformed(ActionEvent e) {
    ExitButton Btn = new ExitButton();
        Btn.setDefaultCloseOperation(ExitButton.EXIT_ON_CLOSE);

        JButton ExitButton = new ExitButton("Summary Report.txt");
   }
   
  public class ReadFile {
  public static void main(String[] args) {      \\The entry main() method
    
   new ActionEventbuttonclick ();
   
 try {
      File Fl = new File("Summary Report.txt");
      Scanner myReader = new Scanner(Fl);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } 
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

 }

