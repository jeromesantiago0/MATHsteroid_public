package mathsteroid.commons.dbmgt;
/*
 * DEDORO, John Nehry C.
 * Developer
 * 10/25/2018
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Read{
	
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	// para pag binasa mo alam mo ginagawa neto nag ccheck kung may kaparehang username di ba ?
	// Eng : Check if the username is already taken.
	//=============================================================
	//Objects
	User user = null;
	public boolean checkUser(Connection conn, String statement){
		try{
			pstmt = conn.prepareStatement(statement);
			ResultSet r1 = pstmt.executeQuery();
			
			return r1.next();
		} catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}	
	public User getUserData(Connection conn, String statement){
		user = new User();
		try {
			pstmt = conn.prepareStatement(statement);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int user_gameID = rs.getInt("gameid");
				String user_userID = rs.getString("userid");
				int user_score = rs.getInt("score");
				String user_asteroid = rs.getString("asteroids");
				int user_coins = rs.getInt("coins");
				
				System.out.println("gameID: " + user_gameID);
				System.out.println("userID: " + user_userID);
				System.out.println("score: " + user_score);
				System.out.println("asteroid: " + user_asteroid);
				System.out.println("coins: " + user_coins);
				
				user.setGameID(user_gameID+"");
				user.setUserID(user_userID);
				user.setScore(user_score);
				user.setAsteroids(user_asteroid);
				user.setCoins(user_coins);
				System.out.println("GET COINS: " + user.getUserID());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public ArrayList<String> ranking(Connection conn){
		ArrayList<String> ranking = new ArrayList<String>();
		try {
			pstmt = conn.prepareStatement("SELECT DISTINCT userid FROM game;");
			ResultSet rs = pstmt.executeQuery();
			ResultSet rs1 = null;
			
			while(rs.next()){
				System.out.println(rs.getString(1));
				String str = "SELECT MAX(score) AS score,userid FROM Game WHERE userid = '" + rs.getString("userid")+ "';";

				System.out.println(str);
				
				pstmt1 = conn.prepareStatement(str);
				rs1 = pstmt1.executeQuery();
				ranking.add(rs1.getString("score") + "~" + rs.getString("userid"));
				
				pstmt1.close();
				rs1.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try{
			for(int i =0; i<ranking.size(); i++){
				String strTemp = "";
				for(int j = 1; j<ranking.size(); j++){
					if(Integer.parseInt(ranking.get(j).split("~")[0]) > 
							Integer.parseInt(ranking.get(j-1).split("~")[0])){
						strTemp = ranking.get(j-1);

						ranking.remove(j-1);
						ranking.add(j, strTemp);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		for(String str : ranking)
			System.out.println(str);
		
		return ranking;
		
	}
}
