package mathsteroid.commons;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Config {
	private int _delay;
	private int _range;
	
	
	
	//getters
	
	public int getDelay(){
		return _delay;
	}
	
	public int getRange(){
		return _range;
	}
	
	
	//setters
	
	public void setDelay(int delay){
		_delay = delay;
	}
	public void setRange(int range){
		_range = range;
	}
	
	
	
	//Utility
	
	
	public void readconfig(){
		try{
			Properties prop = new Properties();
			prop.load(new FileInputStream("src/databasePropDemo.properties"));
			_delay = Integer.parseInt(prop.getProperty("Delay"));
			_range = Integer.parseInt(prop.getProperty("Range"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
