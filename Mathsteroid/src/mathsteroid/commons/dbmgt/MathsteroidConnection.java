package mathsteroid.commons.dbmgt;

/*
 * DEDORO, John Nehry C.
 * Developer
 * 10/25/2018
 */
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

public class MathsteroidConnection {
	Connection conn = null;
	Statement stmt;
	public Connection connect(){
		try {
			Class.forName("org.sqlite.JDBC");
		
			String dbpath = "jdbc:sqlite:mathsteroid.db";
			conn = DriverManager.getConnection(dbpath);
			System.out.print("Connected");
		} catch (Exception e){
			System.out.print("not connected" + e);
		}
	
		return conn;
		
	}
}
