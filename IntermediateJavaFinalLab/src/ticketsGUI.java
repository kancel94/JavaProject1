import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField; //import necessary classes

/*proj implements one listener and can trigger action off menu item clicked
 * with one action performed event handler!
 */
@SuppressWarnings("serial")
public class ticketsGUI extends JFrame implements ActionListener {

	//needed class level member vars
	private JFrame mainFrame;
	
	//incl main menu objects
	private	JMenu file = new JMenu("File");
	private	JMenu tickets = new JMenu("Tickets");
	JScrollPane sp = null;
	//incl sub menu item objects
	
	JMenuItem ItemNew;
    JMenuItem ItemExit;
    JMenuItem ItemOpenTicket;
    JMenuItem ItemCloseTicket;
    JMenuItem ItemEditTicket;
    JMenuItem ItemViewTicket;
    JMenuItem ItemViewTickets;
    JMenuItem ItemDeleteTicket;
    //include more items below
	String user; //global variables
	String pass;
	String userID;
	String admin;
	public ticketsGUI(String user, String pass) {
	    this.user=user;
	    this.pass=pass;
	    if (user.equalsIgnoreCase("tkang")) //correct username
	    {
	    	if (pass.equals("hello1")) //correct pass for this username
	    	{
	    	userID= "ID101"; //assign strings to these global variables
	    	admin= "Yes";
	    	createTable(); //begin creating table, menu, and gui
	    	createTable2();
			createMenu();
		    prepareGUI();
	    	}
	    }
	    else if (user.equalsIgnoreCase("2ndcommand"))//correct pass for this username
	    {
	    	if (pass.equals("howareyou2")) //correct pass for this username
	    	{
	    	userID= "ID102";  //assign strings to these global variables
	    	admin= "Yes";
	    	createTable();//begin creating table, menu, and gui
	    	createTable2();
			createMenu();
		    prepareGUI();
	    	}
	    }
	    else if (user.equalsIgnoreCase("worker1")) //correct user for this username
	    {
	    	if (pass.equals("good3")) //correct pass for this username
	    	{
	    	userID= "ID103";  //assign strings to these global variables
	    	admin= "No";
	    	createTable(); //begin creating table, menu, and gui
	    	createTable2();
			createMenu();
		    prepareGUI();
	    	}
	    }
	    else if (user.equalsIgnoreCase("worker2")) //correct user for this username
	    {
	    	if (pass.equals("bad4")) //correct pass for this username
	    	{
	    	userID= "ID104"; //assign strings to these global variables
	    	admin= "No";
	    	createTable(); //begin creating table, menu, and gui
	    	createTable2();
			createMenu();
		    prepareGUI();
	    	}
	    }
	    else if (user.equalsIgnoreCase("worker3")) //correct user for this username
	    {
	    	if (pass.equals("soso5")) //correct pass for this username
	    	{
	    	userID= "ID105"; //assign strings to these global variables
	    	admin= "No";
	    	createTable(); //begin creating table, menu, and gui
	    	createTable2();
			createMenu();
		    prepareGUI();
	    	}
	    }
	    else if (user.equalsIgnoreCase("randomperson"))  //correct user for this username
	    {
	    	if (pass.equals("couldbebetter6")) //correct pass for this username
	    	{
	    	userID= "ID106"; //assign strings to these global variables
	    	admin= "No";
	    	createTable(); //begin creating table, menu, and gui
	    	createTable2();
			createMenu();
		    prepareGUI();
	    	}
	    }
	}
	
	private void createTable() //method to create table
	{	
		// vars. for SQL Query create
		final String createTable = "CREATE TABLE tkangTicket8(ticket_id INT AUTO_INCREMENT PRIMARY KEY, user_id VARCHAR(10), username VARCHAR(20), name VARCHAR(30), openDateAndTime TIMESTAMP, closeDateAndTime TIMESTAMP NULL, priority VARCHAR(200), ticket_description VARCHAR(300))";
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
		    System.out.println("Created table in given database...");

			//end create table
		    //close connection/statement object  
		    statement.close();
		    connect.close();
		    } catch (Exception e) {
		    	System.out.println(e.getMessage());  
		    }  

		
	}
	
	private void createTable2()
	{	
		// vars. for SQL Query create
		final String createTable2 =  "CREATE TABLE tkangAnalytics5(AutoId INT AUTO_INCREMENT PRIMARY KEY, ticket_id VARCHAR(30), ticketDuration VARCHAR(500), ticket_description VARCHAR(500))";
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
		      
		    statement.executeUpdate(createTable2);
		    System.out.println("Created table in given database...");

			//end create table
		    //close connection/statement object  
		    statement.close();
		    connect.close();
		    } catch (Exception e) {
		    	System.out.println(e.getMessage());  
		    }  

		
	}
	
	
	
private void createMenu()
{
	//set up mnemonics for main menu items (triggered by alt keys)
	file.setMnemonic('F');
	
	//initialize up sub menu items
	ItemNew = new JMenuItem("Log Out");
	ItemNew.setMnemonic('L');
	file.add(ItemNew);
	
	ItemExit = new JMenuItem("Exit");
	ItemExit.setMnemonic('x');
	file.add(ItemExit);
	
	ItemOpenTicket = new JMenuItem("Open Ticket");
	ItemOpenTicket.setMnemonic('O');
	tickets.add(ItemOpenTicket);
	
	ItemCloseTicket = new JMenuItem("Close Ticket");
	ItemCloseTicket.setMnemonic('C');
	tickets.add(ItemCloseTicket);
	
	ItemEditTicket = new JMenuItem("Edit Ticket");
	ItemEditTicket.setMnemonic('E');
	tickets.add(ItemEditTicket);
	
	ItemViewTicket = new JMenuItem("View Ticket");
	ItemViewTicket.setMnemonic('V');
	tickets.add(ItemViewTicket);
	
	ItemViewTickets = new JMenuItem("View Tickets and Analytics");
	ItemViewTickets.setMnemonic('V');
	tickets.add(ItemViewTickets);
	
	ItemDeleteTicket = new JMenuItem("Delete Ticket");
	ItemDeleteTicket.setMnemonic('D');
	tickets.add(ItemDeleteTicket);
	
	if (admin.equals("No")) //if logged in user is not an admin, edit and delete options are disabled
 	{
		ItemEditTicket.setEnabled(false);
		ItemDeleteTicket.setEnabled(false);
	}

	//incl more sub menu items below
	
	//add listeners for each desired menu item 
	ItemNew.addActionListener(this);
	ItemExit.addActionListener(this);
	ItemOpenTicket.addActionListener(this);
	ItemCloseTicket.addActionListener(this);
	ItemEditTicket.addActionListener(this);
	ItemViewTicket.addActionListener(this);
	ItemViewTickets.addActionListener(this);
	ItemDeleteTicket.addActionListener(this);
	
	//add more listeners for any additional sub menu items
}
 
private void prepareGUI() //method to create gui
{ 
	//initialize frame object
	mainFrame = new JFrame("Main");
    //create jmenu bar
	JMenuBar bar = new JMenuBar();
	bar.add(file);  //set menu orders
	bar.add(tickets);
	//add menu bar component to frame
    mainFrame.setJMenuBar(bar); 
   
    mainFrame.setSize(1000,400);
	mainFrame.setVisible(true);
	mainFrame.setLocationRelativeTo(null); //center GUI
	//JLabel label1 = new JLabel("Use the menu items to navigate through this GUI");
	//label1.setFont(new Font("Tahoma", Font.PLAIN, 40));
	//mainFrame.add(label1);
	JOptionPane.showMessageDialog(null,"Use the menu items to navigate through this GUI");
	
}

@Override
public void actionPerformed(ActionEvent e) {

	//add desired coding to trigger each sub menu action 
	
	if(e.getSource() == ItemNew) { //if user clicks this option
		System.out.println("You have been logged out, please log in again."); //output on console
		mainFrame.dispose(); //main gui is disposed and
		new Login(); //user can log in as same or different user
	}

	if(e.getSource() == ItemExit){ //if user clicks this option
		 System.out.println("You have exited the program."); //output on console
         System.exit(0); //program exits
     }
	
	 else if(e.getSource() == ItemOpenTicket){ //if user clicks this option

		 try {
			 String[] options = {"OK"}; //create a jpanel with label and ok button
			 JPanel panel2 = new JPanel();
			 JLabel label4 = new JLabel("Enter your full name: ");
			 JTextField txt2 = new JTextField(15); 
			 panel2.add(label4); 
			 panel2.add(txt2);
			 JOptionPane.showOptionDialog(null, panel2, "Name", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]); // create a dialog box to allow user input
			 if (txt2.getText().equals("")) //if user inputs nothing
			 {
					System.out.println("INVALID INPUT"); //output on console
					JOptionPane.getRootFrame().dispose(); //joption pane is disposed 
					JOptionPane.showMessageDialog(null,"Ticket ID: Not created");
			 }	
			 else //if user inputs something
			 {
				 String str3= txt2.getText(); //input is converted to string
				 String[] choices = { "Choose Priority Level", "High", "Medium", "Low" }; //dialog box with drop down menu and 4 choices
				 String input = (String) JOptionPane.showInputDialog(null, "Choose priority: ", "Priority Level", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
				 if (input.equals(choices[0])) //if user chooses the first choice (Choose Priority Level)
				 {
					 System.out.println("INVALID INPUT"); //output on console
					 JOptionPane.getRootFrame().dispose(); //disposed
					 JOptionPane.showMessageDialog(null,"Ticket ID: Not created");
				 }
				 else //if user selects the other 3 choices
				 {
					 JPanel panel3 = new JPanel(); //new panel with jtext area to write ticket description
					 JLabel label5 = new JLabel("Enter a ticket description: ");
					 JTextArea txt3 = new JTextArea(8,15);
					 txt3.setLineWrap(true);
					 panel3.add(label5);
					 panel3.add(txt3);
					 JOptionPane.showOptionDialog(null, panel3, "Description", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
					 if (txt3.getText().equals("")) //if user inputs nothing and presses ok
					 {
						 System.out.println("INVALID INPUT"); //output on console
						 JOptionPane.getRootFrame().dispose(); //disposed
						 JOptionPane.showMessageDialog(null,"Ticket ID: Not created");
					 }
					 else //if user inputs something
					 {
						 String str4= txt3.getText(); //text is converted and saved to string
						 Calendar cal = Calendar.getInstance();
						 java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis()); //timestamp to get time and date for opening ticket

						 Class.forName("com.mysql.jdbc.Driver").newInstance();
						
						 Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?autoReconnect=true&useSSL=false"
			                                                               + "&user=fp411&password=411");

						 String insertTableSQL = "Insert into tkangTicket8"
								 +"(user_id, username, name, openDateAndTime, priority, ticket_description) values"
								 + "(?,?,?,?,?,?)"; //making use of prepared statements
						 PreparedStatement preparedStatement = dbConn.prepareStatement(insertTableSQL);
						 preparedStatement.setString(1,userID);
						 preparedStatement.setString(2,user);
						 preparedStatement.setString(3,str3);
						 preparedStatement.setTimestamp(4,timestamp);
						 preparedStatement.setString(5,input);
						 preparedStatement.setString(6,str4);
						 int result = preparedStatement.executeUpdate();
						 if (result != 0) {
							 System.out.println("Ticket Created Successfully!!!");
						 }
						 else {
							 System.out.println("Ticket cannot be Created!!!");
						 }
						 JOptionPane.showMessageDialog(null,"Ticket ID: Created"); //display dialog box once everything is inputted properly
						 System.out.println("Ticket has been created."); //output on console
						 preparedStatement.close(); //close prepared statement 
						 dbConn.close();   //close connections!!!
						 }
					 }
				 } //catching all of these exceptions
			 } catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.getMessage();
		     } catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			 } catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			 } catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			 } catch (NullPointerException e1) {
				 System.out.println("You pressed cancel");
				 JOptionPane.getRootFrame().dispose();
				 JOptionPane.showMessageDialog(null,"Ticket ID: Not created");
			 }
     }
	
	else if(e.getSource() == ItemCloseTicket){ //if user chooses to close ticket
		 //retrieve ticket information
		 try { //try catch
			 
			 Calendar cal = Calendar.getInstance();
			 java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis()); //timestamp to get date and time
			    
			 String[] options = {"OK"}; //creating a japenl with text field and ok button
			 JPanel panel6 = new JPanel();
			 JLabel label8 = new JLabel("Which ticket would you like to close? (Please input the ticket_id): ");
			 JTextField txt5 = new JTextField(15);
			 panel6.add(label8);
			 panel6.add(txt5);
			 JOptionPane.showOptionDialog(null, panel6, "Close", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);

			 Class.forName("com.mysql.jdbc.Driver").newInstance();
					
			 Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?autoReconnect=true&useSSL=false"
		                                                               + "&user=fp411&password=411");
		            
		     Statement statement = dbConn.createStatement();
		     String text= txt5.getText();
		     int textInt= Integer.parseInt(text);
		     String sql= "SELECT ticket_id, openDateAndTime, closeDateAndTime FROM tkangTicket8 WHERE ticket_id = '"+textInt+"'";
		     ResultSet rs = statement.executeQuery(sql); //select those 3 columns from tkangTicket8 table where ticket id is the one you chose
		     if (rs.next()) //since we're only looking for one row, use if result set
		     {
		    	 int ticketId = rs.getInt("ticket_id");
		    	 Timestamp time1 = rs.getTimestamp("closeDateAndTime");
		    	 if (textInt == ticketId && time1 == null) //if user inputs a valid value and the closing date and time is null
				 {
		    		 Statement statement2 = dbConn.createStatement();
		    		 String sql2 = "UPDATE tkangTicket8 SET closeDateAndTime= '"+timestamp+"' WHERE ticket_id = '"+textInt+"'"; //update close date and time with new time
		    		 statement2.executeUpdate(sql2);
		    		 JOptionPane.showMessageDialog(null,"Ticket ID#" + textInt + " has been closed");
		    		 System.out.println("Ticket#" + textInt + "has been closed.");
				 }
	    		 else if (textInt == ticketId && time1 != null) //if time is not null
	    		 {
	    			 System.out.println("This ticket has already been closed.");
	    			 JOptionPane.showMessageDialog(null,"This ticket has already been closed.");
	    		 }
	    		 else 
		    	 {
		    		 System.out.println("NOT A VALID VALUE");
					 JOptionPane.getRootFrame().dispose();
					 JOptionPane.showMessageDialog(null,"Ticket ID: Nothing has been closed");
		    	 }
		     } rs.close();
		     statement.close();
		       dbConn.close();   //close connections
		 }	  catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.getMessage();
		       } catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			} catch (NumberFormatException e1) { //if user inputs a value that isnt an integer
				System.out.println("NOT A VALID VALUE");
				JOptionPane.getRootFrame().dispose();
				JOptionPane.showMessageDialog(null,"Ticket ID: Nothing has been closed");
			}
		 }
	
	else if(e.getSource() == ItemViewTicket){ //if user clicks this
		try
		{
			String[] options = {"OK"}; //creating jpanel with ok button and textfield
			JPanel panel8 = new JPanel();
			JLabel label9 = new JLabel("Which specific ticket would you like to view? (Please input the ticket_id): ");
			JTextField txt7 = new JTextField(15);
			panel8.add(label9);
			panel8.add(txt7);
			JOptionPane.showOptionDialog(null, panel8, "View", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);

			Class.forName("com.mysql.jdbc.Driver").newInstance();
					
			Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?autoReconnect=true&useSSL=false"
		                                                               + "&user=fp411&password=411");
		            
		    Statement statement = dbConn.createStatement();
		    String text = txt7.getText();
		    int textInt = Integer.parseInt(text);
		    String sql= "SELECT ticket_id FROM tkangTicket8 WHERE ticket_id='"+textInt+"'"; //selecting ticketID
		    ResultSet rs = statement.executeQuery(sql);
		    if (rs.next()) //since user is only looking for specific ticketID
		    {
		    	int ticketId = rs.getInt("ticket_id");
		        if (textInt == ticketId) //if user inputs valid value
		    	{
		    		Statement statement2 = dbConn.createStatement(); //will select all the columns from table with chosen ticket ID
		    		 String sql2 = "SELECT ticket_id, user_id, username, name, openDateAndTime, closeDateAndTime, priority, ticket_description FROM tkangTicket8 WHERE ticket_id = '"+textInt+"'";
		    		 ResultSet results = statement2.executeQuery(sql2);
		    		 if (results.next()) 
		    		 {
		    		 String descrip = results.getString("ticket_id"); //using result type to change to usable data type
		    		 String descrip1 = results.getString("user_id");
		    		 String descrip2 = results.getString("username");
		    		 String descrip3 = results.getString("name");
		    		 Timestamp descrip4 = results.getTimestamp("openDateAndTime");
		    		 Timestamp descrip5 = results.getTimestamp("closeDateAndTime");
		    		 String descrip6 = results.getString("priority");
		    		 String descrip7 = results.getString("ticket_description");
		    		 
		    		 System.out.println("Ticket#" + descrip + " is being displayed."); //output on console
		    		 
		    		 if(descrip5 != null) //if close date and time is not null
		    		 {//display the following
		    		 JOptionPane.showMessageDialog(null,"Viewing Ticket#" + descrip + 
		    				 "\n\nUser ID: " + descrip1 +
		    				 "\nUsername: " + descrip2 +
		    				 "\nName: " + descrip3 +
		    				 "\nOpen Date and Time: " + descrip4 +
		    				 "\nClose Date and Time: " + descrip5 +
		    				 "\nPriority: " + descrip6 +
		    				 "\nDescription: " + descrip7);
		    		 }
		    		 else if (descrip5 == null) //if close date and time is null
		    		 { //display the following
		    			 JOptionPane.showMessageDialog(null,"Viewing Ticket#" + descrip +
			    				 "\n\nUser ID: " + descrip1 +
			    				 "\nUsername: " + descrip2 +
			    				 "\nName: " + descrip3 +
			    				 "\nOpen Date and Time: " + descrip4 +
			    				 "\nClose Date and Time: Not Closed Yet" +
			    				 "\nPriority: " + descrip6 +
			    				 "\nDescription: " + descrip7);
		    		 }
		    	}
		    	}
		    	else 
		    	 {
		    		 System.out.println("NOT A VALID VALUE");
					 JOptionPane.getRootFrame().dispose();
					 JOptionPane.showMessageDialog(null,"Ticket ID: Nothing can be viewed");
		    	 }
		    }	
		    rs.close();
		    statement.close();
	        dbConn.close();   //close connections!!
		    
		}catch (InstantiationException e1) {
		 // TODO Auto-generated catch block
		 e1.getMessage();
		} catch (IllegalAccessException e1) {
		 // TODO Auto-generated catch block
		 e1.getMessage();
		} catch (ClassNotFoundException e1) {
		 // TODO Auto-generated catch block
		 e1.getMessage();
		} catch (SQLException e1) {
		 // TODO Auto-generated catch block
		 e1.getMessage();
		} catch (NumberFormatException e1) { //if user inputs an invalid value like letters
			System.out.println("NOT A VALID VALUE");
			JOptionPane.getRootFrame().dispose();
			JOptionPane.showMessageDialog(null,"Ticket ID: Nothing can be viewed");
		}
	}
		
	 else if(e.getSource() == ItemViewTickets){ //if user clicks on this to see jtable
			 //retrieve ticket information
			 try {					
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?autoReconnect=true&useSSL=false"
	                                                               + "&user=fp411&password=411");
	            
	            Statement statement = dbConn.createStatement();
	            
	            Statement statement3 = dbConn.createStatement();
	            String sql3 = "DELETE FROM tkangAnalytics5"; //deleting from table so table isnt cluttered with duplicates every time you run the program
				statement3.executeUpdate(sql3); //execute update
	            //select all columns and also sort based on priority
	            ResultSet results = statement.executeQuery("SELECT * FROM tkangTicket8 ORDER BY CASE WHEN priority= 'Low' THEN 2 ELSE 1 END, priority");
	            
	            // Use JTable built in functionality to build a table model and display the table model
	            // off a resultset
	            JTable jt = new JTable(ticketsJTable.buildTableModel(results));
	            jt.setBounds(30,40,1200,1300);
	            sp=new JScrollPane(jt);
	            sp.setPreferredSize(new Dimension(600, 150));

				JPanel panel8 = new JPanel();
	            panel8.add(sp); //display tabel within dialog box
				JOptionPane.showMessageDialog(null, sp, "Viewing Tickets (Press OK to display Analytics in Console)", JOptionPane.PLAIN_MESSAGE);
	            

			    Class.forName("com.mysql.jdbc.Driver").newInstance();
				
	      
	            Statement statement2 = dbConn.createStatement(); 
	            String sql = "INSERT INTO tkangAnalytics5(ticket_id, ticketDuration, ticket_description) values( ?, ?, ?)";
				PreparedStatement pstmt2 = dbConn.prepareStatement(sql); //prepared statement
	            ResultSet results2 = statement2.executeQuery("SELECT ticket_id, openDateAndTime, closeDateAndTime, ticket_description FROM tkangTicket8");
	            int openCounter= 0; //initialize counters
	            int closeCounter= 0;
	            while (results2.next()) //since we'll need multiple rows
	            {
		            String ticketId = results2.getString("ticket_id"); //convert to string
	            	String descrip = results2.getString("ticket_description");
	            	
	            	Timestamp dateStart = results2.getTimestamp("openDateAndTime"); //declare timestamp variable based on data from database
	            	Timestamp dateClose = results2.getTimestamp("closeDateAndTime"); //use to compare  
	            	
	            	if (dateClose == null) //if it hasnt been closed yet
		    		{
	            	openCounter = openCounter+ 1; //increase counter by one
	            	
	            	Calendar cal = Calendar.getInstance();
    				Timestamp dateNow = new Timestamp(cal.getTimeInMillis()); //current time

    				long diff = dateNow.getTime()-dateStart.getTime(); //formula for finding difference between now and open date
    				long diffSeconds = diff / 1000 % 60;
    				long diffMinutes = diff / (60 * 1000) % 60;
    				long diffHours = diff / (60 * 60 * 1000) % 24;
    				long diffDays = diff / (24 * 60 * 60 * 1000);
    				
    				String output= diffDays + " days, " +  diffHours + " hours, " + diffMinutes + " minutes, " + diffSeconds + " seconds.";
    				System.out.print("Duration of Opened Ticket#" + ticketId + ": " + diffDays + " days, "); //output in console
    				System.out.print(diffHours + " hours, ");
    				System.out.print(diffMinutes + " minutes, ");
    				System.out.print(diffSeconds + " seconds. \n");
    				pstmt2.setString(1, ticketId); //put in 3rd table (analytics)
    				pstmt2.setString(2, output);
    				pstmt2.setString(3, descrip);
    				pstmt2.executeUpdate();
		    		}
	            	else if (dateClose != null) //if it has been closed
	            	{
	            		closeCounter= closeCounter+1; //increase counter by 1
	            	}
	            } 
	            //new result set for high priority open tickets
	            ResultSet results3 = statement2.executeQuery("SELECT ticket_id, openDateAndTime, closeDateAndTime, priority FROM tkangTicket8");
	            System.out.println("High Priority Open Tickets...");
	            while (results3.next()) //since we need more than 1 row
	            {
	            	String priority = results3.getString("priority");
	            	String ticketId = results3.getString("ticket_id");

	            	Timestamp dateClose = results3.getTimestamp("closeDateAndTime"); //use to compare  
	            	
	            	if (dateClose == null && priority.equals("High"))	//if priority is high and it is not closed
		    		{
	            		System.out.println("Ticket#" + ticketId); //display in console
	            	}
	            } 
	           
	            System.out.println("Ratio of Closed Tickets to Open Tickets--> " + closeCounter + ":" + openCounter + "\n"); //using counter to display ratio
	            statement.close();
	            statement2.close();
	            statement3.close();
	            pstmt2.close();
		        dbConn.close();   //close connections
		        
		        
		        
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			}
		 
	     } 	
	
	 else if (e.getSource() == ItemDeleteTicket) //if user wishes to delete a ticket
	 {
		 try{
			 String[] options = {"OK"}; //jpanel with text field and ok button
			 JPanel panel4 = new JPanel();
			 JLabel label6 = new JLabel("Which row would you like to delete? (Please input the ticket_id): ");
			 JTextField txt4 = new JTextField(15);
			 panel4.add(label6);
			 panel4.add(txt4);
			 JOptionPane.showOptionDialog(null, panel4, "Delete", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);

			 Class.forName("com.mysql.jdbc.Driver").newInstance();
					
			 Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?autoReconnect=true&useSSL=false"
		                                                               + "&user=fp411&password=411");
		            
		     Statement statement = dbConn.createStatement();
		     String text= txt4.getText();
		     int textInt = Integer.parseInt(text);
		     String sql= "SELECT ticket_id FROM tkangTicket8 WHERE ticket_id = '"+textInt+"'";
		     ResultSet rs = statement.executeQuery(sql);
		     if (rs.next()) //if since looking for specific ticket id
		     {
		    	 int ticketId = rs.getInt("ticket_id");
		    	 if (textInt == ticketId) //if user inputted valid value
		    	 {
		    		 Statement statement2 = dbConn.createStatement();
		    		 String sql2 = "DELETE FROM tkangTicket8 WHERE ticket_id = '"+textInt+"'"; //string for deleting
		    		 int confirm = JOptionPane.showConfirmDialog (null, "Are you sure you wish to delete ticket #" + textInt,"Warning",JOptionPane.YES_NO_OPTION); //confirmation box
		    		 if(confirm == JOptionPane.YES_OPTION) //if user clicks yes option
		    		 {
		    			 statement2.executeUpdate(sql2); //deletes ticket
		    			 System.out.println("Ticket has been deleted");
		    			 JOptionPane.showMessageDialog(null,"Ticket ID#" +textInt +" has been deleted");
				 	 }
				 	 else //if user doesn't
				 	 {
				 		 JOptionPane.getRootFrame().dispose(); //disposed
						 JOptionPane.showMessageDialog(null,"Ticket ID: Nothing has been deleted");
				 	 }
		    	 }
		    	 else //if invalid value is inputted
		    	 {
		    		 System.out.println("NOT A VALID VALUE");
					 JOptionPane.getRootFrame().dispose();
					 JOptionPane.showMessageDialog(null,"Ticket ID: Nothing has been deleted");
		    	 }
		    } rs.close();
		     statement.close();
		       dbConn.close();   //close connections
		 } catch (InstantiationException e1) {
			 // TODO Auto-generated catch block
			 e1.getMessage();
		 } catch (IllegalAccessException e1) {
			 // TODO Auto-generated catch block
			 e1.getMessage();
		 } catch (ClassNotFoundException e1) {
			 // TODO Auto-generated catch block
			 e1.getMessage();
		} catch (SQLException e1) {
			 // TODO Auto-generated catch block
			 e1.getMessage();
		} catch (NumberFormatException e1) {
			System.out.println("NOT A VALID VALUE");
			JOptionPane.getRootFrame().dispose();
			JOptionPane.showMessageDialog(null,"Ticket ID: Nothing has been deleted");
		}
	 }
	
	else if (e.getSource() == ItemEditTicket) //if user wants to edit ticket
	 {
		 try
		 {
			 String[] options = {"OK"}; //jpanel with textfield and ok button
			 JPanel panel9 = new JPanel();
			 JLabel label8 = new JLabel("Which ticket would you like to edit? (Please input the ticket_id): ");
			 JTextField txt7 = new JTextField(15);
			 panel9.add(label8);
			 panel9.add(txt7);
			 JOptionPane.showOptionDialog(null, panel9, "Edit", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);

			 Class.forName("com.mysql.jdbc.Driver").newInstance();
					
			 Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/tickets?autoReconnect=true&useSSL=false"
		                                                               + "&user=fp411&password=411");
		            
		     Statement statement = dbConn.createStatement();
		     String text= txt7.getText();
		     int textInt = Integer.parseInt(text);
		     String sql= "SELECT ticket_id, name, priority, ticket_description FROM tkangTicket8 WHERE ticket_id = '"+textInt+"'"; //select these fields based on ticket id
		     ResultSet rs = statement.executeQuery(sql);
		     if (rs.next()) //if since we're looking for specific row
		     {
		    	 int ticketId = rs.getInt("ticket_id"); 
		    	 String name= rs.getString("name"); 
		    	 String descrip = rs.getString("ticket_description");
		    	 String priority = rs.getString("priority");
		    	 if (textInt == ticketId) //if user inputs valid value
		    	 {
		    		 JOptionPane.showMessageDialog(null,"Enter values you wish to change (Leave blank if you do not want to update that field)");
		    		 JPanel panel2 = new JPanel();
					 JLabel label4 = new JLabel("Update Full Name: ");
					 JTextField txt2 = new JTextField(15);
					 panel2.add(label4);
					 panel2.add(txt2);
					 JOptionPane.showOptionDialog(null, panel2, "Update Name", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
					 if (txt2.getText() == null || txt2.getText().trim().isEmpty()) //if user leaves it blank
					 {
							System.out.println("You have chosen to not update the name field.");
					 }	
					 else //if user enters something
					 {
						 name= txt2.getText(); //declares into variable
					 }
						 String[] choices = { "Choose New Priority Level (Leave it on this choice to continue or press cancel if you wish to stop updating)", "High", "Medium", "Low" };
						 String input = (String) JOptionPane.showInputDialog(null, "Choose priority: ", "Priority Level", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
						 if (input.equals(choices[0])) //if user leaves it the way it is
						 {
							 System.out.println("You have chosen to not update the priority field.");
						 }
						 else
						 {
							 priority = input;
						 }
							 JPanel panel3 = new JPanel();
							 JLabel label5 = new JLabel("Update ticket description: ");
							 JTextArea txt3 = new JTextArea(8,15);
							 txt3.setLineWrap(true);
							 panel3.add(label5);
							 panel3.add(txt3); //dialog textarea for description
							 JOptionPane.showOptionDialog(null, panel3, "Update Description", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
							 if (txt3.getText() == null || txt3.getText().trim().isEmpty()) //if empty
							 {
								 System.out.println("You have chosen to not update the ticket description.");
							 }
							 else
							 {
								 descrip= txt3.getText(); //update
							 }
								 Statement statement2 = dbConn.createStatement(); //using update 
								 String sql2 = "UPDATE tkangTicket8 SET name = '"+name+"', priority= '"+priority+"', ticket_description = '"+descrip+"' WHERE ticket_id = '"+textInt+"'";
								 statement2.executeUpdate(sql2);
								 JOptionPane.showMessageDialog(null,"Ticket ID#" + textInt + " has been updated");
								 System.out.println("Ticket#" + textInt + "has been updated.");		    		 
							 }
						 }
						 
					
		    	 else //if user inputs an invalid value
		    	 {
		    		 System.out.println("NOT A VALID VALUE");
					 JOptionPane.getRootFrame().dispose();
					 JOptionPane.showMessageDialog(null,"Ticket ID: Nothing has been edited");
		    	 }
		      rs.close();
	 } catch (InstantiationException e1) {
		 // TODO Auto-generated catch block
		 e1.getMessage();
	 } catch (IllegalAccessException e1) {
		 // TODO Auto-generated catch block
		 e1.getMessage();
	 } catch (ClassNotFoundException e1) {
		 // TODO Auto-generated catch block
		 e1.getMessage();
	} catch (SQLException e1) {
		 // TODO Auto-generated catch block
		 e1.getMessage();
	} catch (NumberFormatException e1) {
		System.out.println("NOT A VALID VALUE");
		JOptionPane.getRootFrame().dispose();
		JOptionPane.showMessageDialog(null,"Ticket ID: Nothing has been deleted");
	} catch (NullPointerException e1) {
		 System.out.println("You pressed cancel."); //if user presses cancel
		 JOptionPane.getRootFrame().dispose();
		 JOptionPane.showMessageDialog(null,"Ticket ID: Not created");
	 }
}
	
}
}



