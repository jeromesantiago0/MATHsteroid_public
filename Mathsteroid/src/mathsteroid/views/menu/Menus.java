package mathsteroid.views.menu;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import mathsteroid.views.MathsteroidGamePlay;

public class Menus extends JPanel{
	public JButton btnContinue;
	public JButton btnShop;
	public JButton btnHelp;
	public JButton btnAbout;
	public JButton btnQuit;
	public JLabel lblNewLabel;
	private MathsteroidGamePlay gamePlay;
	public JButton btnRanking;
	public JButton btnSettings;
	public Menus() {
		setOpaque(false);
		btnContinue = new JButton("");
		btnContinue.setBounds(34, 84, 257, 27);
		btnContinue.setIcon(new ImageIcon(Menus.class.getResource("/mathsteroid/resources/menu/btn_continue.png")));
		
		btnShop = new JButton("");
		btnShop.setBounds(34, 116, 257, 27);
		btnShop.setIcon(new ImageIcon(Menus.class.getResource("/mathsteroid/resources/menu/btn_shop.png")));
		
		btnHelp = new JButton("");
		btnHelp.setBounds(34, 148, 257, 27);
		btnHelp.setIcon(new ImageIcon(Menus.class.getResource("/mathsteroid/resources/menu/btn_help.png")));
		
		btnAbout = new JButton("");
		btnAbout.setBounds(34, 180, 257, 27);
		btnAbout.setIcon(new ImageIcon(Menus.class.getResource("/mathsteroid/resources/menu/btn_about.png")));
		
		btnQuit = new JButton("");
		btnQuit.setBounds(34, 212, 257, 27);
		btnQuit.setIcon(new ImageIcon(Menus.class.getResource("/mathsteroid/resources/menu/btn_quit.png")));
		
		btnSettings = new JButton("");
		btnSettings.setIcon(new ImageIcon(Menus.class.getResource("/mathsteroid/resources/menu/btn_settings.png")));
		btnSettings.setBounds(245, 11, 45, 45);
		
		btnRanking = new JButton("");
		btnRanking.setIcon(new ImageIcon(Menus.class.getResource("/mathsteroid/resources/menu/btn_ranking.png")));
		btnRanking.setBounds(34, 11, 45, 45);
	
		
		btnContinue.setContentAreaFilled(false);
		btnContinue.setFocusPainted(false);
		btnContinue.setBorderPainted(false);
		btnContinue.setOpaque(false);
		btnShop.setContentAreaFilled(false);
		btnShop.setFocusPainted(false);
		btnShop.setBorderPainted(false);
		btnShop.setOpaque(false);
		btnHelp.setContentAreaFilled(false);
		btnHelp.setFocusPainted(false);
		btnHelp.setBorderPainted(false);
		btnHelp.setOpaque(false);
		btnAbout.setContentAreaFilled(false);
		btnAbout.setFocusPainted(false);
		btnAbout.setBorderPainted(false);
		btnAbout.setOpaque(false);
		btnQuit.setContentAreaFilled(false);
		btnQuit.setFocusPainted(false);
		btnQuit.setBorderPainted(false);
		btnQuit.setOpaque(false);
		btnRanking.setContentAreaFilled(false);
		btnRanking.setFocusPainted(false);
		btnRanking.setBorderPainted(false);
		btnRanking.setOpaque(false);
		btnSettings.setContentAreaFilled(false);
		btnSettings.setFocusPainted(false);
		btnSettings.setBorderPainted(false);
		btnSettings.setOpaque(false);
		setLayout(null);
		add(btnContinue);
		add(btnShop);
		add(btnHelp);
		add(btnAbout);
		add(btnQuit);
		add(btnRanking);
		add(btnSettings);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Menus.class.getResource("/mathsteroid/resources/menu/MENU.png")));
		lblNewLabel_1.setBounds(113, 11, 104, 43);
		add(lblNewLabel_1);
		
	
		
	
		
	}
}
