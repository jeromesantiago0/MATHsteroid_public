/*
 * DEDORO, John Nehry C.
 * DB Developer
 * 10/25/2018
 */
package mathsteroid.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import mathsteroid.commons.Sound;
import mathsteroid.commons.dbmgt.Insert;
import mathsteroid.commons.dbmgt.MathsteroidConnection;
import mathsteroid.commons.dbmgt.Read;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;

public class UserReg extends JDialog implements ActionListener,MouseListener {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	StoryFrame storyFrame = null;
	public UserReg(StoryFrame storyFrame) {
		this.storyFrame = storyFrame;
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(510, 200, 350, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		password = new JPasswordField();
		password.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		password.setOpaque(false);
		password.setBorder(null);
		password.setBounds(51, 145, 247, 20);
		contentPane.add(password);
		
		repassword = new JPasswordField();
		repassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		repassword.setBounds(51, 195, 247, 20);
		repassword.setOpaque(false);
		repassword.setBorder(null);
		contentPane.add(repassword);
		
		
		name = new JTextField();
		name.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		name.setBounds(51, 95, 110, 20);
		name.setOpaque(false);
		name.setBorder(null);
		contentPane.add(name);
		name.setColumns(10);
		
		userid = new JTextField();
		userid.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		userid.setColumns(10);
		userid.setBounds(188, 95, 110, 20);
		userid.setOpaque(false);
		userid.setBorder(null);
		contentPane.add(userid);
		
		btnExit = new JButton("");
		btnExit.addMouseListener(this);
		btnExit.setIcon(new ImageIcon(UserReg.class.getResource("/mathsteroid/resources/menu/btn_exit.png")));
		btnExit.setBounds(296, 8, 44, 25);
		btnExit.setBorderPainted(false);
		btnExit.setOpaque(false);
		btnExit.setContentAreaFilled(false);
		btnExit.addActionListener(this);
		contentPane.add(btnExit);
		
		btnReg = new JButton("");
		btnReg.setOpaque(false);
		btnReg.setBorderPainted(false);
		btnReg.setIcon(new ImageIcon(UserReg.class.getResource("/mathsteroid/resources/user/btn_reg.png")));
		btnReg.setBounds(41, 237, 274, 25);
		btnReg.setContentAreaFilled(false);
		btnReg.addActionListener(this);
		btnReg.addMouseListener(this);
		contentPane.add(btnReg);
		
		JLabel regformbg = new JLabel("");
		regformbg.setIcon(new ImageIcon(UserReg.class.getResource("/mathsteroid/resources/user/bg_regform.png")));
		regformbg.setBounds(0, 0, 350, 316);
		contentPane.add(regformbg);
		repaint();
		
	}
	
	private JButton btnExit, btnReg;
	private JTextField name,userid;
	private JPasswordField password,repassword;
	MathsteroidConnection mathsteroid_conn = null;
	Connection conn = null;
	Insert insert;
	Read read;
	Sound sound = new Sound();
	public void actionPerformed(ActionEvent ae) {
		JButton button = (JButton) ae.getSource();
		if(button == btnExit){
			this.dispose();
		}
		if(button == btnReg) {
			sound.playSFX("/mathsteroid/resources/sound/ok.wav");
			mathsteroid_conn = new MathsteroidConnection();
			read = new Read();
			insert = new Insert();
			String eName = name.getText();
			String eUserid = userid.getText();
			String ePassword = password.getText();
			String	eRepassword = repassword.getText();
			
			mathsteroid_conn = new MathsteroidConnection();
			conn = mathsteroid_conn.connect();
			
			read = new Read();
			insert = new Insert();
			
			String chckPstmtUserid = "SELECT userid FROM user WHERE userid = '" + eUserid +"'";
			String insertUserData = "INSERT INTO user VALUES('"
					+ eUserid +"','"+ eName + "','"+ ePassword +"')";
			String insertUserGameData = "INSERT INTO game (userid,score,asteroids,coins) VALUES('"+eUserid+"',0,'',0)";
			System.out.println(chckPstmtUserid);
			System.out.println(insertUserData);
			System.out.println(insertUserGameData);
			// CHECK IF THE USERID IS ALREADY TAKEN
			// ISANG KUNDISYON KUNG SAAN TINITIGNAN ANG DATABASE KUNG MAYROONG KAPAREHONG USERID NA NILAGAY NI USER
/*1*/	if(!read.checkUser(conn,chckPstmtUserid)){
			// CHECK if PASSWORD IS THE SAME
			// ISANG KUNDISYONG KUNG SAAN TINITIGNAN KUNG PAREHO YUNG INENTER NA PASSWORD
	/*2*/	if(ePassword.equals(eRepassword)) {
					// KAPAG NA MEET LAHAT NG KUNDISYON TSKA TAYO MAG PAPASOK NG DATA
					//ISANG KUNDISYON DIN ITO KUNG SAAN TINITIGNAN KUNG NAIPASOK BA ANG DATA O HINDI
		/*3*/		if(ePassword.length() > 4) {
				/*4*/	if(eName.length() > 4 && eUserid.length() > 4) {
						/*5*/	if(insert.insertData(conn,insertUserData) > 0){
									if(insert.insertData(conn, insertUserGameData) > 0){
										JOptionPane.showMessageDialog(contentPane,"Please login to play the game.");
										UserLogIn logFrame = new UserLogIn(this.storyFrame);
										logFrame.setModal(true);
										logFrame.setVisible(true);
										repaint();
										this.dispose();
										} else JOptionPane.showMessageDialog(contentPane,"DATABASE NOT INSTALLED OR CANNOT INSERT DATA");}
								
						/*5*/	else { 
										JOptionPane.showMessageDialog(contentPane,"DATABASE NOT INSTALLED");
								}
				/*4*/	}  else {
								JOptionPane.showMessageDialog(contentPane,"USERNAME AND NAME TOO SHORT");
							}
		/*3*/			} else {
							JOptionPane.showMessageDialog(contentPane,"PASSWORD TOO SHOT");
						}
	/*2*/	} else {
						JOptionPane.showMessageDialog(contentPane,"PASSWORD YOU'VE ENTER IS NOT THE SAME");
					}
/*1*/	}else {
				JOptionPane.showMessageDialog(contentPane,"USERNAME ALREADY TAKEN");
				}
			
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		
	}
	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent me) {
		if(me.getSource() == btnReg){
			btnReg.setIcon(new ImageIcon(UserReg.class.getResource("/mathsteroid/resources/user/btn_regform_hover.png")));
		}
		if(me.getSource() == btnExit){
			btnExit.setIcon(new ImageIcon(UserReg.class.getResource("/mathsteroid/resources/menu/btn_exit_hover.png")));
		}
		
	}
	public void mouseExited(MouseEvent mEx) {
		if(mEx.getSource() == btnReg){
			btnReg.setIcon(new ImageIcon(UserReg.class.getResource("/mathsteroid/resources/user/btn_reg.png")));;
		}
		if(mEx.getSource() == btnExit){
			btnExit.setIcon(new ImageIcon(UserReg.class.getResource("/mathsteroid/resources/menu/btn_exit.png")));
		}
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
