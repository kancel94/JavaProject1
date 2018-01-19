import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login  {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    
    public Login(){
    	    createTable();
    	    deleteRecords();
    	    populateUsers();
    	    prepareGUI();
    	    showTextFields();
    }
    
    public void createTable(){
    	
		// vars. for SQL Query create
		  final String createTable = "CREATE TABLE IF NOT EXISTS " +
				 " tkangUsers6(AutoId INT AUTO_INCREMENT PRIMARY KEY, user_name VARCHAR(30), " +
				  "user_password VARCHAR(256))";
		  Connection connect = null;
		  Statement statement = null;
				  
		  try {
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://www.papademas.net/tickets?autoReconnect=true&useSSL=false"
		              + "&user=fp411&password=411");
	 	      
		      //create table
		    
		      statement = connect.createStatement();
		      
		      statement.executeUpdate(createTable);
		      System.out.println("Table created in given database...");

			//end create table
		    //close connection/statement object  
		     statement.close();
		     connect.close();
		    } catch (Exception e) {
		    	System.out.println(e.getMessage());  
		    }  

    }
    
	public void deleteRecords() //method for deleting records
	{
		String sql;
		Connection connect = null;
		Statement statement = null;
		try //try catch to catch exception
		{
		    Class.forName("com.mysql.jdbc.Driver");
		    // Setup the connection with the DB
		    connect = DriverManager
		        .getConnection("jdbc:mysql://www.papademas.net/tickets?autoReconnect=true&useSSL=false"
		            + "&user=fp411&password=411");
		    statement = connect.createStatement();
			sql = "DELETE FROM tkangUsers6"; //deleting from table
			statement.executeUpdate(sql); //execute update
			statement.close(); //close
		} catch (SQLException e) //catch exception
		{
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) //catch this exception
		{
		e.getMessage(); //get message if exception is caught
		}
	}
    
    public void populateUsers(){
    	
    	  // vars. for SQL Query inserts
		  String sql;
		  Connection connect = null;
		  Statement statement = null;
	      BufferedReader br;
	    	  List<List<String>> array = new ArrayList<>();  //arraylist to hold spreadsheet rows & columns	
	    	  
	    	  //read data from file
	    	  try {
				   br = new BufferedReader(new FileReader(new File("userpass.csv")));

			       String line;
						while ((line = br.readLine()) != null) {
							array.add(Arrays.asList(line.split(",")));
						}
					} catch (Exception e) {
						System.out.println("There was a problem loading the file");
		   }
	    	  
		   try {
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://www.papademas.net/tickets?autoReconnect=true&useSSL=false"
		              + "&user=fp411&password=411");
		      statement = connect.createStatement();
	
			  //create loop to grab each array index containing a list of values
			  //and PASS that data into your record objects' setters 
			    for (List<String> rowData: array){
				  //perform inserts into users table
			    	  //grab values one column at a time from array
				   sql="insert into tkangUsers6(user_name,user_password) " +
					     "values('"+rowData.get(0)+"','"+rowData.get(1)+"');";
	               statement.executeUpdate(sql);
			    }
		  	    System.out.println("Inserts completed in the given database...");

		    //close connection/statement object  
		     statement.close();
		     connect.close();
		    } catch (Exception e) {
		    	System.out.println(e.getMessage());  
		    }  
    }
    

    private void prepareGUI(){
        mainFrame = new JFrame("Login");
        mainFrame.setSize(450,200);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.setLocationRelativeTo(null); //center the GUI
        
        mainFrame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent wE){   //define a close operation
                System.exit(0);
        }
        });
        
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("",JLabel.CENTER);
        
        headerLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        statusLabel.setSize(350,100);
        
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
    
    private void showTextFields(){
        headerLabel.setText("Account Access");
        
        JLabel  namelabel= new JLabel("User ID: ", JLabel.RIGHT);
        JLabel  passwordLabel = new JLabel("Password: ", JLabel.CENTER);
        final JTextField userText = new JTextField(10);
        final JPasswordField passwordText = new JPasswordField(10);
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
        	
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
                
               /*verify user with a matching password/username from users table
                 *give popup message if either username or password is incorrect
               */
              Connection connect = null;
       		  Statement statement = null;
       		  
       		  try {
       		      // This will load the MySQL driver, each DB has its own driver
       		      Class.forName("com.mysql.jdbc.Driver");
       		      // Setup the connection with the DB
       		      connect = DriverManager
       		          .getConnection("jdbc:mysql://www.papademas.net/tickets?autoReconnect=true&useSSL=false"
       		              + "&user=fp411&password=411");
       	 	      
       		      //verify user from users table

       		      statement = connect.createStatement();
       		      
       		      String username = userText.getText();
       		      String password = passwordText.getText();
    			  boolean blnFound=false; //flag if user's credentials are valid
    			      
       		      String sql = "SELECT user_name, user_password FROM tkangUsers6 WHERE user_name='" + username + "' " +
       		    		           "AND BINARY user_password='" + password + "';";
       	    
       			  statement.executeQuery(sql);
       	          ResultSet rs = statement.getResultSet();
       	          blnFound = rs.first();  //grabs first record match!
                     
                  if(blnFound) {
              	  //close of Login window
              	  mainFrame.dispose();
              	  //open up ticketsGUI file upon successful login
                  new ticketsGUI(username, password);
              	  }
              	  else {
              		String message = "Invalid username\nand/or password";
              		JOptionPane.showMessageDialog(null, message);
              	  }
  
        		     //close connection/statement object  
       		     statement.close();
       		     connect.close();
       		    } catch (Exception e1) {
       		    	System.out.println(e1.getMessage());  
       		    }  
               }
        });
        
        controlPanel.add(namelabel);
        controlPanel.add(userText);
        controlPanel.add(passwordLabel);       
        controlPanel.add(passwordText);
        controlPanel.add(loginButton);
        mainFrame.setVisible(true);  
    }
    public static void main(String[] args){
        new Login();
    }

}