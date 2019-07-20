package mathsteroid.views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import mathsteroid.commons.Sound;
import mathsteroid.commons.dbmgt.User;

@SuppressWarnings("serial")
public class MathsteroidMainForm extends JFrame{

	private JPanel contentPane;
	private MathsteroidGamePlay gamePlay;
	Sound sound;
	private User user;
	/**
	 * Create the frame.
	 */
	public MathsteroidMainForm(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 710);
		setLocationRelativeTo(null);
		setTitle("MATHsteroid");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.user = user;
		init();
	}
	
	private void init(){
		gamePlay = new MathsteroidGamePlay(user);
		gamePlay.setPreferredSize(new Dimension(700, 600));
		gamePlay.setBounds(10, 10, 775, 665);
		getContentPane().add(gamePlay);
	}
	public void resetGame(MathsteroidGamePlay mainForm){
		getContentPane().remove(mainForm);
		repaint();
		gamePlay = new MathsteroidGamePlay(user);
		gamePlay.setPreferredSize(new Dimension(700, 600));
		gamePlay.setBounds(10, 10, 775, 665);
		getContentPane().add(gamePlay);
		revalidate();
	}
}
