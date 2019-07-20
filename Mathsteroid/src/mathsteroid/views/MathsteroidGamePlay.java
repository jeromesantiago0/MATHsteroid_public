 package mathsteroid.views;

import java.awt.Insets;
import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import mathsteroid.commons.Config;
import mathsteroid.commons.Sound;
import mathsteroid.commons.Questions;
import mathsteroid.commons.dbmgt.Insert;
import mathsteroid.commons.dbmgt.MathsteroidConnection;
import mathsteroid.commons.dbmgt.Read;
import mathsteroid.commons.dbmgt.User;
import mathsteroid.views.menu.About;
import mathsteroid.views.menu.Help;
import mathsteroid.views.menu.Menus;
import mathsteroid.views.menu.Ranking;
import mathsteroid.views.menu.Settings;
import mathsteroid.views.menu.Shop;


@SuppressWarnings("serial")
public class MathsteroidGamePlay extends JPanel implements ActionListener{

	//==================================================================//
	//								Objects								//
	//==================================================================//
	private MathsteroidMainForm mathsteroidMainForm;
	private Asteroid asteroid;
	private Earth earth;
	private ImageIcon icon;
	private Questions questions;
	private Menus menus;
	private Help help;
	private About about;
	private Shop shop;
	private MessageDialog messageDialog;
	private Sound sound;
	private Solver solver;
	private User user;
	private Settings settings;
	private Ranking ranking;
	public Config config;
	private Read read;
	private MathsteroidConnection mathsteroidConn;
	private Connection conn;
	//==================================================================//
	//								Fields								//
	//==================================================================//
	private int score = 0;
	private boolean bPlay = false;
	private boolean move = true;
	public int iCoins = 1500;
	public int earthLife;
	private int lvl1 = 0;
	private int lvl2 = 0;
	private int totalMathsteroids = 0;
	//private int iDelay = 0;											
	private int difficulty = 1;
	private int asteroidPosX;
	private int asteroidPosY;
	private int asteroidDirX;
	private int asteroidDirY;
	private int asteroidWidth = 160;
	private int asteroidHeight = 260;
	private int position = 1;
	private boolean gameOver = false;
	private String item = "";
	private int easyTotal = 0;
	private int averageTotal = 0;
	//==================================================================//
	//							Swing Objects							//
	//==================================================================//
	private JButton btnPlay;
	private Random random = new Random();
	private Timer timer;
	private JLabel lblCoins;
	private JLabel lblAnsweredMathsteroid;
	private JLabel lblLevel1_Icon;
	private JLabel lblLevel1_Score;
	private JLabel lblLevel2_Icon;
	private JLabel lblLevel2_Score;
	private JLabel lblDivider;
	private JLabel lblTotalMathsteroids;
	
	Point pRight = new Point(830, -250);
	Point pMid = new Point(300, -264);
	Point pLeft = new Point(-180, -254);
	private JLabel lblScore;
	private JLabel lblScorelabel;
	private JLabel lblBgStars;
	
	public MathsteroidGamePlay(User user) {
		this.user = user;
		
		//	construct
		sound = new Sound();
		config = new Config();
		Properties prop = new Properties();
		try{
			prop.load(new FileInputStream("src/databasePropDemo.properties"));
			config.setDelay(Integer.parseInt(prop.getProperty("Delay")));
			config.setRange(Integer.parseInt(prop.getProperty("Range")));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error in reading the config.txt!");
		}
		init();
	}
	private void init(){
		setLayout(null);
		setBackground(Color.BLACK);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setSize(775, 665);
		timer = new Timer(config.getDelay() * difficulty, this);
		timer.start();
		
		//	get questions
		questions = new Questions();

		//===========================================================//
		//==============================Header=======================//
		//	label for COINS and coins icon
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(MathsteroidGamePlay.class.getResource("/mathsteroid/resources/icons/coins.png")));
		label.setBounds(10, 11, 138, 38);
		add(label);
		
		//	set scoring board
		lblCoins = new JLabel("0000");
		lblCoins.setText(""+iCoins);
		lblCoins.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCoins.setForeground(Color.WHITE);
		lblCoins.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCoins.setBounds(159, 17, 86, 27);
		add(lblCoins);		

		//	label for the answered mathsteroids
		lblAnsweredMathsteroid = new JLabel("<html><p align=center>Destroyed Mathsteroids:</p></html>");
		lblAnsweredMathsteroid.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAnsweredMathsteroid.setForeground(Color.ORANGE);
		lblAnsweredMathsteroid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnsweredMathsteroid.setBounds(231, 11, 97, 38);
		add(lblAnsweredMathsteroid);
		
		lblLevel1_Icon = new JLabel("");
		lblLevel1_Icon.setIcon(new ImageIcon(MathsteroidGamePlay.class.getResource("/mathsteroid/resources/icons/level1.png")));
		lblLevel1_Icon.setBounds(338, 19, 30, 30);
		add(lblLevel1_Icon);
		
		lblLevel1_Score = new JLabel("0");
		lblLevel1_Score.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLevel1_Score.setForeground(Color.WHITE);
		lblLevel1_Score.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLevel1_Score.setBounds(360, 22, 41, 27);
		add(lblLevel1_Score);
		
		lblLevel2_Icon = new JLabel("");
		lblLevel2_Icon.setIcon(new ImageIcon(MathsteroidGamePlay.class.getResource("/mathsteroid/resources/icons/level2.png")));
		lblLevel2_Icon.setBounds(429, 19, 30, 30);
		add(lblLevel2_Icon);
		
		lblLevel2_Score = new JLabel("0");
		lblLevel2_Score.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLevel2_Score.setForeground(Color.WHITE);
		lblLevel2_Score.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLevel2_Score.setBounds(456, 22, 41, 27);
		add(lblLevel2_Score);
		
		lblDivider = new JLabel("|");
		lblDivider.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDivider.setForeground(Color.ORANGE);
		lblDivider.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDivider.setBounds(507, 22, 15, 27);
		add(lblDivider);
		
		lblTotalMathsteroids = new JLabel("0");
		lblTotalMathsteroids.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTotalMathsteroids.setForeground(Color.WHITE);
		lblTotalMathsteroids.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalMathsteroids.setBounds(520, 21, 41, 27);
		add(lblTotalMathsteroids);
		
		//	add button play on the gameplay
		btnPlay = new JButton();
		btnPlay.setIcon(new ImageIcon(MathsteroidMainForm.class.getResource("/mathsteroid/resources/icons/play_btn.png")));
		btnPlay.setBounds(338, 303, 41, 50);
		btnPlay.setFocusPainted(false);
		btnPlay.setMargin(new Insets(0, 0, 0, 0));
		btnPlay.setContentAreaFilled(false);
		btnPlay.setBorderPainted(false);
		btnPlay.setOpaque(false);
		btnPlay.setText("PLAY");
		btnPlay.addActionListener(this);
		btnPlay.setVisible(false);
		add(btnPlay);
		
		//	add earth on the gameplay
		earth = new Earth("/mathsteroid/resources/earths/Earth_100.gif");
		earth.setBounds(289, 430, 210, 210);
		this.add(earth);

		//	set difficulty randomly
		difficulty = random.nextInt(2 - 1 + 1) + 1;
		timer.setDelay(config.getDelay() * (difficulty==1?2:1));
		//	get randomly selected question from the list
		item = questions.getQuestion();	//	1 - EASY
		//	easy - 1
		//	average - 2
		//	add asteroid on the gameplay
		addAsteroid(item.split("@")[0], item.split("@")[1], item.split("@")[2], difficulty, item.split("@")[3]); //	last param - 1 (EASY)
		
		//===========================================================//
		//==============================MENU=========================//
		menus = new Menus();
		menus.setBounds(225, 185, 326, 300);
		add(menus);
		menus.setVisible(true);
		menus.btnContinue.addActionListener(this);
		menus.btnQuit.addActionListener(this);
		menus.btnAbout.addActionListener(this);
		menus.btnHelp.addActionListener(this);
		menus.btnShop.addActionListener(this);
		menus.btnSettings.addActionListener(this);
		menus.btnRanking.addActionListener(this);
		
		lblScore = new JLabel("0");
		lblScore.setText(score+"");
		lblScore.setVerticalAlignment(SwingConstants.BOTTOM);
		lblScore.setForeground(Color.WHITE);
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblScore.setBounds(628, 22, 64, 27);
		add(lblScore);
		
		lblScorelabel = new JLabel("<html><p align=center>SCORE</p></html>");
		lblScorelabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblScorelabel.setForeground(Color.ORANGE);
		lblScorelabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblScorelabel.setBounds(561, 22, 57, 27);
		add(lblScorelabel);
		
		lblBgStars = new JLabel("");
		lblBgStars.setIcon(new ImageIcon(MathsteroidGamePlay.class.getResource("/mathsteroid/resources/bg/Stars.gif")));
		lblBgStars.setBounds(0, 0, 775, 665);
		add(lblBgStars);
	}
	public void actionPerformed(ActionEvent e) {
		if(bPlay){
			//	checks if the asteroid do NOT intersects the location of the earth
			if(asteroidPosY >= 190){
				// pause the game for a while
				bPlay = false;
				
				//	play explosion sound
				sound.playSFX("/mathsteroid/resources/sound/boom.wav");
				
				//	remove the component
				this.remove(asteroid);
				
				//	minus on earth life
				// change the earth images
				earth.setLife(10);
				
				//	checks life of earth
				if(earth.getLife() < 10){
					sound.playSFX("/mathsteroid/resources/sound/boom.wav");
					showTuts();
					gameOver = true;
					//JOptionPane.showMessageDialog(null, "Game Over!");
				}
				else{
					showTuts();
				}
				
				//	add another asteroid
				difficulty = random.nextInt(2 - 1 + 1) + 1;
				timer.setDelay(config.getDelay() * (difficulty==1?2:1));
				//	Randomly select questions from the list of questions
				item = questions.getQuestion();	//	1 - EASY
				addAsteroid(item.split("@")[0], item.split("@")[1], item.split("@")[2], difficulty, item.split("@")[3]);
			}// if: checks if the asteroid intersects the location of the earth

			//===========================================================//

			//	move asteroids based on its direction
			if(move){
				asteroidPosX += asteroidDirX * 2;
				asteroidPosY += asteroidDirY * 2;
				asteroidDirY = 1;
				asteroid.setLocation(asteroidPosX, asteroidPosY);
			}//	if: move asteroids based on its direction 

			//===========================================================//

			String chosen = "";
			if(e.getSource() == asteroid.btnA){
				chosen = asteroid.btnA.getText();
			}
			else if(e.getSource() == asteroid.btnB){
				chosen = asteroid.btnB.getText();
			}
			else if(e.getSource() == asteroid.btnC){
				chosen = asteroid.btnC.getText();
			}
			
			// check if the selected answer is the right answer
			if(chosen != ""){
				if(chosen.equals(asteroid.answer)){
					//new Mp3Player().playMp3("coin1.mp3");
					sound.playSFX("/mathsteroid/resources/sound/coin.wav");
					System.out.println("BOOM!");
					//iDelay = 50;
					//	remove the component
					this.remove(asteroid);
					
					//====================================================//
					
					//	play music on right answer
					//	try to change the animation if the answer is correct
					if(difficulty == 1){
						lvl1++;
						lblLevel1_Score.setText(""+lvl1);
						easyTotal++;
					}
					else{
						lvl2++;
						lblLevel2_Score.setText(""+lvl2);
						averageTotal++;
					}
					
					lblTotalMathsteroids.setText(""+totalMathsteroids);
					timer.setDelay(6000);
					if(icon != null){
						icon.getImage().flush();
					}
					
					//	sets new display for the explosion of mathsterois
					//	after answering the linear equation correctly
					icon = new ImageIcon(Asteroid.class.getResource("/mathsteroid/resources/asteroids/explosion.gif"));
					JLabel lblJ = new JLabel("");
					lblJ.setIcon(icon);
					lblJ.setOpaque(false);
					lblJ.setBounds(asteroidPosX, asteroidPosY, 161, 261);
					add(lblJ);
					System.out.println("hello");
					messageDialog = new MessageDialog(null, false);
					messageDialog.setModal(true);
					messageDialog.setCancelVisibility(false);
					messageDialog.setBackgroundImage("/mathsteroid/resources/dialogs/correct.png");
					messageDialog.setVisible(true);
					
					if(lblJ != null)
						remove(lblJ);
					// Update points when answer is correct
					iCoins += 10 * difficulty;
					score += 10 * difficulty;
					timer.setDelay(config.getDelay());
					lblCoins.setText("" + iCoins);
					lblScore.setText("" + score);
					//	add another asteroid
					//	random.nextInt(max - min + 1) + min
					difficulty = random.nextInt(2 - 1 + 1) + 1;
					timer.setDelay(config.getDelay() * (difficulty==1?2:1));
					item = questions.getQuestion();	//	1 - EASY
					addAsteroid(item.split("@")[0], item.split("@")[1], item.split("@")[2], difficulty, item.split("@")[3]);
				}//if
				else{
					timer.setDelay(timer.getDelay()-(timer.getDelay()/2));
					if(position == 1)
						asteroid.changeIcon("/mathsteroid/resources/asteroids/asteroid_l_hard.gif");
					else if(position == 2)
						asteroid.changeIcon("/mathsteroid/resources/asteroids/asteroid_m_hard.gif");
					else
						asteroid.changeIcon("/mathsteroid/resources/asteroids/asteroid_r_hard.gif");
					System.out.println("Wrong Answer Delay: " + timer.getDelay());
				}
			}
		}
		
		//	resets the game if game over
		if(solver != null)
			if(e.getSource() == solver.btnOk){
				if(gameOver){
					saveData();
					solver.dispose();
					bPlay = false;
					move = true;
					iCoins = 1500;
					score = 0;
					lvl1 = 0;
					lvl2 = 0;
					totalMathsteroids = 0;	
					easyTotal = 0;
					averageTotal = 0;
					difficulty = 1;
					asteroidWidth = 160;
					asteroidHeight = 260;
					position = 1;
					gameOver = false;
					lblLevel1_Score.setText(""+lvl1);
					lblLevel2_Score.setText(""+lvl2);
					lblTotalMathsteroids.setText(""+totalMathsteroids);
					lblCoins.setText(""+iCoins);
					lblScore.setText(score+"");
					earth.setLife(-100);
					menus.setVisible(true);
					menus.setVisible(true);
					menus.setOpaque(false);
					btnPlay.setVisible(false);
					btnPlay.setText("PLAY");
					setGame(false);
				}
				else{
					bPlay = true;
					solver.dispose();
				}
			}
		
		//========================================================
		//========================MENU============================

		//============================================
		if(e.getSource() == menus.btnContinue)
		{
			System.out.println("Hello");
			sound.playSFX("/mathsteroid/resources/sound/ok.wav");
			if(btnPlay.getText() == "PLAY"){
				btnPlay.setText("PAUSE");
				btnPlay.setVisible(true);
				btnPlay.setIcon(null);
				btnPlay.setIcon(new ImageIcon(MathsteroidMainForm.class.getResource("/mathsteroid/resources/icons/btn_pause.png")));
				btnPlay.setBounds(665, 11, 130, 50);
				menus.setVisible(false);
				setGame(true);
			}
		}
		if(e.getSource() == btnPlay){
			if(btnPlay.getText() == "PLAY"){
				btnPlay.setText("PAUSE");
				btnPlay.setVisible(true);
				btnPlay.setIcon(null);
				btnPlay.setIcon(new ImageIcon(MathsteroidMainForm.class.getResource("/mathsteroid/resources/icons/btn_pause.png")));
				btnPlay.setBounds(750, 11, 50, 50);
				menus.setVisible(false);
				setGame(true);
			}
			else{
				menus.setVisible(true);
				menus.setOpaque(false);
				btnPlay.setVisible(false);
				btnPlay.setText("PLAY");
				setGame(false);
				saveData();
			}
		}
		if(e.getSource() == menus.btnQuit){
			saveData();
			
			sound.playSFX("/mathsteroid/resources/sound/ok.wav");
			if(JOptionPane.showConfirmDialog(null, "Do you realy want to exit the game?") == JOptionPane.OK_OPTION){
				System.exit(0);
			}
			/*messageDialog = new MessageDialog(this, true);
			messageDialog.setModal(true);
			messageDialog.setBackgroundImage("/mathsteroid/resources/dialogs/dialog_wanna_quit.png");
			messageDialog.setVisible(true);*/
		}
		else if(e.getSource() == menus.btnHelp){
			sound.playSFX("/mathsteroid/resources/sound/ok.wav");
			help = new Help();
			help.setModal(true);
			help.setLocationRelativeTo(null);
			help.setVisible(true);
		}
		else if(e.getSource() == menus.btnShop){
			sound.playSFX("/mathsteroid/resources/sound/ok.wav");
			shop = new Shop();
			shop.setModal(true);
			earthLife = earth.getLife();
			System.out.println("earthLife: " + earthLife);
			shop.acceptEarth(earth);
			shop.acceptGamePlay(this);
			shop.setLocationRelativeTo(null);
			shop.setVisible(true);
		}
		else if(e.getSource() == menus.btnAbout){
			sound.playSFX("/mathsteroid/resources/sound/ok.wav");
			about = new About();
			about.setModal(true);
			about.setLocationRelativeTo(null);
			about.setVisible(true);
		}
		else if(e.getSource() == menus.btnSettings){
			sound.playSFX("/mathsteroid/resources/sound/ok.wav");
			settings = new Settings(this);
			settings.setModal(true);
			settings.setLocationRelativeTo(null);
			settings.setVisible(true);
		}
		else if(e.getSource() == menus.btnRanking){
			System.out.println("Helloasfbhdfh");
			sound.playSFX("/mathsteroid/resources/sound/ok.wav");
			try{
			ArrayList<String> rank = new ArrayList<String>();
			read = new Read();
			mathsteroidConn = new MathsteroidConnection();
			conn = mathsteroidConn.connect();
			rank = read.ranking(conn);
			for(String str : rank)
				System.out.println(str);
			ranking = new Ranking(rank);
			ranking.setModal(true);
			ranking.setLocationRelativeTo(null);
			ranking.setVisible(true);
			}catch(Exception ee){
				System.out.println("Error: " + ee.getMessage());
				ee.printStackTrace();
			}

		}
		
	}
	private void saveData() {
		MathsteroidConnection mathsteroidconn = new MathsteroidConnection();
		Insert insert = new Insert();
		conn = mathsteroidconn.connect();
		String userId = user.getUserID();
		String easy = lblLevel1_Score.getText() + "#" +easyTotal;
		String average = lblLevel2_Score.getText() + "#" +averageTotal;
		String insertUserData = "INSERT INTO game (userid,score,asteroids,coins) VALUES('" + userId + "',"
				 + score + ",'" + easy +"$" +average + "','" + iCoins + "')";
		System.out.println("\n" + insertUserData);
		System.out.println("Return Val: " + insert.insertData(conn,insertUserData));
		/*if(insert.insertData(conn,insertUserData) > 0){
			System.out.print("data inserted");
		}*/
	}
	private void showTuts() {
		/***
		 * Developer: Bryan Ken Altes
		 * 
		 */
		solver = new Solver(item.split("@")[0]);
		solver.setVisible(true);
		solver.setModal(true);
		solver.btnOk.addActionListener(this);
		bPlay = false;
	}
	

	//==================================================================//
	//						Utility Functions							//
	//==================================================================//
//	generate asteroid based on level of difficulty
	private void addAsteroid(String question, String choices, String answer, int level, String solution){
		//	sets score per asteroid destroyed
		lblTotalMathsteroids.setText(""+totalMathsteroids);
		
		//	Update the count of total asteroids
		totalMathsteroids++;
		
		//	print debug the level and updates
		System.out.println("Level: " + level);
		System.out.println("Difficulty: " + difficulty);
		System.out.println("Add Maths. Delay: " + timer.getDelay());
		
		//	randomly generates positions of the next asteroid
		//	random.nextInt(max - min + 1) + min
		position = random.nextInt(3 - 1 + 1) + 1;
		switch(position){
			case 3: asteroid = new Asteroid((level==1? //	ternary operator
					"/mathsteroid/resources/asteroids/asteroid_r_easy.gif": // Yellow
						"/mathsteroid/resources/asteroids/asteroid_r_average.gif"), // Orange
						question, choices, answer, solution,
						//	location of questions and choices depending on the position of mathsteroid
						new Point(50, 137), new Point(74, 99), new Point(93, 65), new Point(8, 183));
					asteroid.setBounds(pRight.x, pRight.y, asteroidWidth, asteroidHeight);
					asteroidPosX = pRight.x;
					asteroidPosY = pRight.y;
					asteroidDirX = -1;
					//System.out.println("position: " + position);
					break;
			case 2: asteroid = new Asteroid((level==1?
					"/mathsteroid/resources/asteroids/asteroid_m_easy.gif": // Yellow
						"/mathsteroid/resources/asteroids/asteroid_m_average.gif"),  // Orange
					question, choices, answer, solution,
					new Point(63, 145), new Point(63, 105), new Point(63, 70), new Point(40, 190));
					asteroid.setBounds(pMid.x, pMid.y, asteroidWidth, asteroidHeight);  
					asteroidPosX = pMid.x;
					asteroidPosY = pMid.y;
					asteroidDirX = 0;
					asteroidDirY = 1;
					break;
			case 1: asteroid = new Asteroid((level==1?
					"/mathsteroid/resources/asteroids/asteroid_l_easy.gif": // Yellow
						"/mathsteroid/resources/asteroids/asteroid_l_average.gif"),  // Orange
					question, choices, answer, solution,
					new Point(64, 137), new Point(48, 99), new Point(32, 65), new Point(75, 183));
					asteroid.setBounds(pLeft.x, pLeft.y, asteroidWidth, asteroidHeight); 
					asteroidPosX = pLeft.x;
					asteroidPosY = pLeft.y;  
					asteroidDirX = 1;
					asteroidDirY = 1;
					break;
		}//	switch
		
		//	adds action listeners to the asteroids' choices
		asteroid.btnA.addActionListener(this);
		asteroid.btnB.addActionListener(this);
		asteroid.btnC.addActionListener(this);
		this.add(asteroid);
	}//	addAsteroid
	
	//	signals the ameplay to start/stop
	public void setGame(boolean bPlay){
		this.bPlay = bPlay;
		if(bPlay)
			timer.start();
		else
			timer.stop();
	}//	setGame
	//	set the value for the label coins
	public void setCoins(int coins){
		this.iCoins = coins;
		lblCoins.setText(""+this.iCoins);
	}//	setCoins
}
