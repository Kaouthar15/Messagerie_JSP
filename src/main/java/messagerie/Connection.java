package messagerie;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Connection {
	private java.sql.Connection cnx;
	private Statement instruction;
	protected ResultSet result;
	
	public Connection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnx = DriverManager.getConnection("jdbc:mysql://localhost/messagerie","root","123456");
			instruction = cnx.createStatement();
		}
		catch(ClassNotFoundException ex) {
			System.err.println("Problème de pilote : \n"+ex);
		}
	}
	public void read(String request) {
		 try {
		result = instruction.executeQuery(request);
		 } catch (SQLException ex) {
		System.err.println("incorrect request " + request);
		 }
		}
	public void update(String request) {
		 try {
		instruction.executeUpdate(request);
		 } catch (SQLException ex) {
		System.err.println("incorrect request " + request);
		 }
		}
	
	public boolean next() { 
		try {
			return result.next();
		} catch (SQLException ex) {
			return false;
		}
	}
	public void stop() { 
		try { 
			cnx.close(); 
		} catch (SQLException ex) { 
			System.err.println("Error on the stopping of the database"); 
		} 
	}

	
}
