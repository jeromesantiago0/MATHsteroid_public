package mathsteroid.views;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Earth extends JPanel {
	public int life;
	private JProgressBar lifeStatus;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public Earth(String path) {
		setOpaque(false);
		setLayout(null);
		setBounds(10, 10, 210, 210);
		
		//	set life bar status
		lifeStatus = new JProgressBar();
		lifeStatus.setValue(100);
		lifeStatus.setToolTipText("Life");
		lifeStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lifeStatus.setForeground(Color.RED);
		lifeStatus.setBackground(Color.DARK_GRAY);
		lifeStatus.setBounds(46, 172, 106, 14);
		lifeStatus.setStringPainted(true);
		add(lifeStatus);
		
		//	
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Earth.class.getResource(path)));
		lblNewLabel.setBounds(0, 0, 202, 202);
		add(lblNewLabel);
	}
	public void setLife(int value){
		lifeStatus.setValue(lifeStatus.getValue()-value);
		changeEarth();
		lifeStatus.revalidate();
	}
	public void changeEarth(){
		if(lifeStatus.getValue() > 75 && lifeStatus.getValue() <= 100){
			lblNewLabel.setIcon(new ImageIcon(Earth.class.getResource("/mathsteroid/resources/earths/Earth_100.gif")));
		}
		else if(lifeStatus.getValue() > 50 && lifeStatus.getValue() <= 75){
			lblNewLabel.setIcon(new ImageIcon(Earth.class.getResource("/mathsteroid/resources/earths/Earth_75.gif")));
		}
		else if(lifeStatus.getValue() > 25 && lifeStatus.getValue() <= 50){
			lblNewLabel.setIcon(new ImageIcon(Earth.class.getResource("/mathsteroid/resources/earths/Earth_50.gif")));
		}
		else
			lblNewLabel.setIcon(new ImageIcon(Earth.class.getResource("/mathsteroid/resources/earths/Earth_25.gif")));
		revalidate();
	}
	public int getLife(){
		return lifeStatus.getValue();
	}
}
