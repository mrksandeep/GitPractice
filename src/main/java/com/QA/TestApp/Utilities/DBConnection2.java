package com.QA.TestApp.Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class DBConnection2 extends BaseScript{
	private static String readData(String input) {
		try {
			return fUtil.fgetDataNew1(input);
		} catch (Exception e) {
			return "";
		}
	}


	String value="";
	Connection conDev;
	Statement stmt;

	private Properties loadFile() throws IOException{
		Properties obj = new Properties();					
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+File.separator+"DBConfig.properties");									
		obj.load(objfile);
		return obj;
	}

	public DBConnection2() throws Exception
	{
		if (conDev == null)
		{         
			try
			{
				
				String dbUrl = readData("connectionString1");				
				String dbUsername = readData("dbUsername1");	
				String dbPassword = readData("dbPassword1");	
				Class.forName("org.postgresql.Driver");
				
				conDev =  DriverManager.getConnection(dbUrl,dbUsername, dbPassword);
				if (conDev != null) {
					System.out.println("\n\n**** Connected to DB Successfully **** \n\n");
					logger.info("\n\n**** Connected to DB Successfully **** \n\n");
					fUtil.flogResult("Pass", "DB Connection", "Connected to DB Successfully", 0);
//					con.setAutoCommit(false);
				}
			}
			catch (ClassNotFoundException | SQLException | IOException e)
			{
				System.out.println("\n\n**** Database connection failed ****");
				System.err.println( e.getClass().getName()+": "+ e.getMessage() );
				logger.info("\n\n**** Database connection failed ****");
				fUtil.flogResult("Fail", "DB Connection", "Database connection failed - "+ e.getMessage(), 0);
				System.exit(0);
			}
		}
	}

	public void disconnectDB() throws Exception
	{
		try{
			if(stmt!=null)
				stmt.close();
		}catch(SQLException se2){
			se2.printStackTrace();
		}

		try{
			if(conDev!=null)
			{
				conDev.close();
				System.out.println("\n\n**** DB Connection Closed Successfully **** \n\n");
				logger.info("\n\n**** DB Connection Closed Successfully **** \n\n");
				fUtil.flogResult("Pass", "Close DB Connection", "DB Connection Closed Successfully", 0);
			}
		}catch(SQLException se){
			se.printStackTrace();
			fUtil.flogResult("Pass", "Close DB Connection", "Unable to close DB Connection - "+se.getMessage(), 0);
		}

	}
	
	/*
	 * This Function will execute a query and return a output value based in the column input provided
	 */
	public String executeQuery(String query, String coloumnName) throws SQLException, ClassNotFoundException, IOException,Exception{

		try {
			stmt = conDev.createStatement();	
			ResultSet rs= stmt.executeQuery(query);							

			while (rs.next()){
				value=rs.getString(coloumnName);	
			}
			System.out.println("Fetched Value from DB : "+value);

		}catch(Exception e) {
			System.out.println("\n\n**** Error in Execute Query ****");
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}finally {
			disconnectDB();
		}

		return value;
	}		
	
	/*
	 * This Function will update the table and return a value 0 or 1 based on the Create or Update query.
	 */

	public int createOrUpdateOrDelete(String query) throws SQLException,ClassNotFoundException, IOException,Exception
	{    
		int result = -1; // Value set to -1 as after the execution of query the value will change to either 0 or 1
		try {
			stmt = conDev.createStatement();	
			result = stmt.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("\n\n**** Error in Create/Update/Delete ****");
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}finally {
			disconnectDB();
		}
		return result;       
	}
}



