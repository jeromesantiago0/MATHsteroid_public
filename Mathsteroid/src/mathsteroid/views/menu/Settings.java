package mathsteroid.views.menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import mathsteroid.commons.Config;
import mathsteroid.views.MathsteroidGamePlay;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

public class Settings extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	public String setDelays;
	private JButton btnContinue;
	private JButton btnExit;
	private JLabel lblNewLabel_1;
	private int RANGE;
	private int DELAY;
	private JSlider level;
	private String __Range;
	private String __Delay;
	private JSlider delay;
	private MathsteroidGamePlay gamePlay;
	
	
	public Settings(MathsteroidGamePlay gamePlay) {
		init();
		this.gamePlay = gamePlay;
	}

	private void init() {
		readConfig();
		setBounds(100, 100, 250, 271);
		getContentPane().setLayout(null);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnContinue = new JButton("");
		btnContinue.setIcon(new ImageIcon(Settings.class.getResource("/mathsteroid/resources/menu/btn_ok.png")));
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContinue.setForeground(Color.YELLOW);
		btnContinue.setBorderPainted(false);
		btnContinue.setContentAreaFilled(false);
		btnContinue.setOpaque(false);
		btnContinue.addActionListener(this);
		btnContinue.setBounds(169, 219, 46, 29);
		contentPanel.add(btnContinue);	
		
		level = new JSlider();
		level.setMajorTickSpacing(5);
		level.setMaximum(20);
		level.setValue(Integer.parseInt(__Range));
		level.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				RANGE = level.getValue();
				String Range = ""+RANGE;
				Properties prop = new Properties();
				try{
					prop.setProperty("Delay", __Delay);
					prop.setProperty("Range", Range);
					prop.store(new FileOutputStream("src/databasePropDemo.properties"), null);
					
				}catch(Exception e){

				}
			}
		});
		
		delay = new JSlider();
		delay.setValue(Integer.parseInt(__Delay));
		delay.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				DELAY = delay.getValue();
				String Delay = ""+DELAY;
				Properties prop = new Properties();
				try{
					prop.setProperty("Delay", Delay);
					prop.setProperty("Range", __Range);
					prop.store(new FileOutputStream("src/databasePropDemo.properties"), null);
					
				}catch(Exception e){

				}
			}
		});
		
		btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(Settings.class.getResource("/mathsteroid/resources/menu/btn_exit.png")));
		btnExit.setOpaque(false);
		btnExit.setForeground(Color.YELLOW);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setBounds(48, 219, 46, 29);
		btnExit.addActionListener(this);
		contentPanel.add(btnExit);
		delay.setSnapToTicks(true);
		delay.setPaintTicks(true);
		delay.setPaintLabels(true);
		delay.setOrientation(SwingConstants.VERTICAL);
		delay.setOpaque(false);
		delay.setMinimum(10);
		delay.setMajorTickSpacing(20);
		delay.setForeground(Color.YELLOW);
		delay.setFocusable(false);
		delay.setBounds(37, 58, 64, 112);
		contentPanel.add(delay);
		level.setOrientation(SwingConstants.VERTICAL);
		level.setForeground(Color.YELLOW);
		level.setSnapToTicks(true);
		level.setPaintTicks(true);
		level.setPaintLabels(true);
		level.setMinimum(5);
		level.setBounds(153, 58, 64, 112);
		level.setOpaque(false);
		level.setFocusable(false);
		contentPanel.add(level);
		btnContinue.setBorderPainted(false);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Settings.class.getResource("/mathsteroid/resources/menu/bgsettings.png")));
		lblNewLabel_1.setBounds(0, 0, 250, 271);
		contentPanel.add(lblNewLabel_1);
	}

	private void readConfig() {
		try{
			Properties prop = new Properties();
			prop.load(new FileInputStream("src/databasePropDemo.properties"));
			__Delay = prop.getProperty("Delay");
			__Range = prop.getProperty("Range");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnContinue){
			readConfig();
			gamePlay.config.setDelay(Integer.parseInt(__Delay));
			gamePlay.config.setRange(Integer.parseInt(__Range));
			this.dispose();
		}
		if(e.getSource() == btnExit){
			this.dispose();
		}
	}
}
