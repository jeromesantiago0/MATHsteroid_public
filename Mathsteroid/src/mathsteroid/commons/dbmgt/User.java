package mathsteroid.commons.dbmgt;
/*
 * DEDORO, John Nehry C.
 * Developer
 * 10/25/2018
 */
public class User {
	private String _gameID;
	private String _userID;
	private int _score;
	private String _asteroids;
	private int _coins;
	
	//	getters
	public String getGameID(){
		return _gameID;
	}
	public String getUserID(){
		return _userID;
	}
	public int getscore(){
		return _score;
	}
	public String getAsteroids(){
		return _asteroids;
	}
	public int getCoins(){
		return _coins;
	}
	
	
	
	
	
	
	//	setters
	public void setGameID(String gameID){
		_gameID = gameID;
	}
	public void setUserID(String userID){
		_userID = userID;
	}
	public void setScore(int score){
		_score = score;
	}
	public void setAsteroids(String asteroids){
		_asteroids = asteroids;
	}
	public void setCoins(int coins){
		_coins = coins;
	}
}
