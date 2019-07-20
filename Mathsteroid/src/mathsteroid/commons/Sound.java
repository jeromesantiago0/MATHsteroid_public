package mathsteroid.commons;
import javax.swing.*;

import sun.audio.*;

import java.io.*;
public class Sound{
	AudioPlayer MGP = AudioPlayer.player;
	AudioStream BGM = null;;
	AudioData MD = null;;
	ContinuousAudioDataStream loop = null;
	
	/***
	 * Developer: 		Nehry Dedoro
	 * Date Modified:	
	 * Description:		
	 * @param path
	 */
	
	//	plays music repeatedly
	public void playBGM(String path){
		try{
			InputStream input = this.getClass().getResourceAsStream(path);
			BGM = new AudioStream(input);
			MD = BGM.getData();
			loop = new ContinuousAudioDataStream(MD);
		}catch(IOException error){
			JOptionPane.showMessageDialog(null, "Unable to play sound: " + path + "\n" + error.getMessage());
		}
		MGP.start(loop);
	}
	//	plays music once
	public void playSFX(String path){
		try{
			BGM = new AudioStream(this.getClass().getResourceAsStream(path));
			MGP.start(BGM);
		}catch(IOException error){
			JOptionPane.showMessageDialog(null, "Unable to play sound: " + path + "\n" + error.getMessage());
		}
	}
}