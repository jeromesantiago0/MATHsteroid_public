package mathsteroid.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import mathsteroid.views.menu.Shop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;

public class MessageDialog extends JDialog implements ActionListener{
	private JLabel lblBg;
	private JButton btnCancel;
	private JButton btnOk;
	private boolean confirm = false;
	private boolean cancel = false;
	private boolean okay = false;
	private boolean exit = false;
	private MathsteroidGamePlay gamePlay;
	/**
	 * Create the dialog.
	 */
	public MessageDialog(MathsteroidGamePlay gamePlay, boolean exit) {
		init();
		this.gamePlay = gamePlay;
	}
	
	private void init() {
		getContentPane().setBackground(Color.BLACK);
		setUndecorated(true);
		setResizable(false);
		setSize(300, 150);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		btnOk = new JButton("");
		btnOk.setIcon(new ImageIcon(MessageDialog.class.getResource("/mathsteroid/resources/menu/btn_ok.png")));
		btnOk.setOpaque(false);
		btnOk.setMargin(new Insets(0, 0, 0, 0));
		btnOk.setForeground(new Color(255, 204, 51));
		btnOk.setFocusPainted(false);
		btnOk.setContentAreaFilled(false);
		btnOk.setBorderPainted(false);
		btnOk.setBackground(Color.WHITE);
		btnOk.setBounds(207, 110, 40, 20);
		btnOk.addActionListener(this);
		getContentPane().add(btnOk);
		
		btnCancel = new JButton("");
		btnCancel.setIcon(new ImageIcon(MessageDialog.class.getResource("/mathsteroid/resources/menu/btn_exit.png")));
		btnCancel.setOpaque(false);
		btnCancel.setMargin(new Insets(0, 0, 0, 0));
		btnCancel.setForeground(new Color(255, 204, 51));
		btnCancel.setFocusPainted(false);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(56, 110, 40, 20);
		btnCancel.addActionListener(this);
		getContentPane().add(btnCancel);
		
		lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(MessageDialog.class.getResource("/mathsteroid/resources/dialogs/DO_YOU.png")));
		lblBg.setBounds(0, 0, 300, 150);
		getContentPane().add(lblBg);
	}

	public void setBackgroundImage(String path){
		lblBg.setIcon(new ImageIcon(Shop.class.getResource(path)));
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnOk){
			if(!exit){
				setConfirmation(true);
				this.setVisible(false);
			}
			else{
				this.dispose();
				System.exit(0);
			}
		}
		else if(e.getSource() == btnCancel){
			this.dispose();
		}
	}
	
	public void setConfirmation(boolean confirmation){
		this.confirm = confirmation;
	}
	public boolean getConfirmation(){
		return this.confirm;
	}
	public void setCancelVisibility(boolean cancel){
		this.cancel = cancel;
		btnCancel.setVisible(this.okay);
	}
	public boolean getCancelVisibility(){
		return this.cancel;
	}
	public void setOkayVisibility(boolean okay){
		this.okay = okay;
		btnOk.setVisible(this.okay);
	}
	public boolean getOkayVisibility(){
		return this.okay;
	}
	public void setCancelLocation(Point p){
		btnCancel.setLocation(p);
	}
	public void setOkayLocation(Point p){
		btnOk.setLocation(p);
	}
}
