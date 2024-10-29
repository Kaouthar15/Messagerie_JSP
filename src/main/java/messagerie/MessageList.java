package messagerie;

import java.sql.SQLException;

public class MessageList extends Connection {

	public MessageList(int idPerson) throws SQLException {
		super();
		read("select * from message where personId=\""+idPerson+"\"");
		
	}
	public String subject() {
		try {
			return result.getString("Subject");
		}catch(SQLException ex) {
			System.err.println("SQL Error"+ex);
		}
		return null;
	}
	public String text() {
		try {
			return result.getString("Text");
		}catch(SQLException ex) {
			System.err.println("SQL Error"+ex);
		}
		return null;	
	}
	
	
}
