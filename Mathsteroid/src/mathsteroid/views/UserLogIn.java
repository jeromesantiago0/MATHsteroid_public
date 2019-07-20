/*
 * DEDORO, John Nehry C.
 * DB Developer
 * 10/25/2018
 */
package mathsteroid.views;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import mathsteroid.commons.Sound;
import mathsteroid.commons.dbmgt.Insert;
import mathsteroid.commons.dbmgt.MathsteroidConnection;
import mathsteroid.commons.dbmgt.Read;
import mathsteroid.commons.dbmgt.User;
import java.awt.Font;

public class UserLogIn extends JDialog implements ActionListener,MouseListener {

	private JPanel contentPane;
	private JButton btnExit,btnLogIn;
	private JTextField userid;
	private JPasswordField passwordField;
	
	MathsteroidConnection mathsteroid_conn = null;
	Connection conn = null;
	Insert insert = null;
	Read read = null;
	MathsteroidMainForm main = null;
	Sound sound = null;
	/**
	 * Create the frame.
	 */
	
	//=============================================================
	//Objects
	User user;
	private StoryFrame storyFrame = null;
	public UserLogIn(StoryFrame storyFrame) {
		this.storyFrame = storyFrame;
		init();
	}
	private void init(){
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(510, 200, 350, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userid = new JTextField();
		userid.setForeground(Color.BLACK);
		userid.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		userid.setBounds(54, 95, 245, 20);
		userid.setOpaque(false);
		userid.setBorder(null);
		contentPane.add(userid);
		userid.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		passwordField.setBounds(54, 140, 245, 20);
		passwordField.setOpaque(false);
		passwordField.setBorder(null);
		contentPane.add(passwordField);
		
		btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(UserLogIn.class.getResource("/mathsteroid/resources/menu/btn_exit.png")));
		btnExit.setBounds(301, 0, 40, 32);
		btnExit.setBorderPainted(false);
		btnExit.setOpaque(false);
		btnExit.setContentAreaFilled(false);
		btnExit.addMouseListener(this);
		contentPane.add(btnExit);
		btnExit.addActionListener(this);
		
		btnLogIn = new JButton("");		
		btnLogIn.setOpaque(false);
		btnLogIn.setBorderPainted(false);
		btnLogIn.setBorder(null);
		btnLogIn.setBackground(Color.BLACK);
		btnLogIn.setIcon(new ImageIcon(UserLogIn.class.getResource("/mathsteroid/resources/user/btn_log.png")));
		btnLogIn.setBounds(41, 183, 274, 25);
		btnLogIn.setContentAreaFilled(false);
		btnLogIn.addActionListener(this);
		btnLogIn.addMouseListener(this);
		contentPane.add(btnLogIn);
		
		JLabel regformbg = new JLabel("");
		regformbg.setIcon(new ImageIcon(UserLogIn.class.getResource("/mathsteroid/resources/user/LogForm.png")));
		regformbg.setBounds(0, 0, 351, 261);
		contentPane.add(regformbg);
		repaint();
	
		mathsteroid_conn = new MathsteroidConnection();
		read = new Read();
		sound = new Sound();
	}
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == btnExit){
			this.dispose();
		}
		else if(e.getSource() == btnLogIn) {
			sound.playSFX("/mathsteroid/resources/sound/ok.wav");
			String eUserid = userid.getText();
			@SuppressWarnings("deprecation")
			String ePassword = passwordField.getText();
			
			String chckDataLogIn = "SELECT * FROM user WHERE userid = '" + eUserid +"' AND "
					 + " password = '" + ePassword + "'";
			System.out.println(chckDataLogIn);
			
			conn = mathsteroid_conn.connect();
			boolean ret = read.checkUser(conn, chckDataLogIn);
			if(ret) {

				String userDataStmt = "SELECT * FROM game WHERE userid = '"+eUserid +"'";

				this.dispose();
				this.storyFrame.dispose();
				//	create user info object
				user = new User();
				user = read.getUserData(conn, userDataStmt);
				System.out.println("COINS: " + user.getUserID());
				main = new MathsteroidMainForm(user);
				main.setVisible(true);
				repaint();
				revalidate();
			} else {
				JOptionPane.showMessageDialog(contentPane,"INCORRECT USERID OR PASSWORD");
			}
			try {
				conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	public void mouseEntered(MouseEvent me) {
		if(me.getSource() == btnLogIn){
			btnLogIn.setIcon(new ImageIcon(UserLogIn.class.getResource("/mathsteroid/resources/user/btn_LogForm_hover.png")));
		}
		if(me.getSource() == btnExit){
			btnExit.setIcon(new ImageIcon(UserLogIn.class.getResource("/mathsteroid/resources/menu/btn_exit_hover.png")));
		}
		
	}
	public void mouseExited(MouseEvent mEx) {
		if(mEx.getSource() == btnLogIn){
			btnLogIn.setIcon(new ImageIcon(UserLogIn.class.getResource("/mathsteroid/resources/user/btn_log.png")));		
		}
		if(mEx.getSource() == btnExit){
			btnExit.setIcon(new ImageIcon(UserLogIn.class.getResource("/mathsteroid/resources/menu/btn_exit.png")));
		}
				
	}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	public void mouseClicked(MouseEvent arg0) {}
}
