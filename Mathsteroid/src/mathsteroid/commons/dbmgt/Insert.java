package mathsteroid.commons.dbmgt;
/*
 * DEDORO, John Nehry C.
 * Developer
 * 10/25/2018
 */
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Insert {
	PreparedStatement pstmt = null;
	public int insertData(Connection conn, String statement){
		try{
			pstmt = conn.prepareStatement(statement);
			return pstmt.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		return 0;
		
	}
}
