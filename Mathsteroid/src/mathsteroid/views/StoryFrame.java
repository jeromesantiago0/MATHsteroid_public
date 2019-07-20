/*
 * DEDORO, John Nehry C.
 * Developer
 * 10/25/2018
 */
package mathsteroid.views;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import mathsteroid.commons.Sound;
import mathsteroid.commons.dbmgt.MathsteroidConnection;

public class StoryFrame extends JDialog implements ActionListener,MouseListener{

	private final JPanel contentPanel = new JPanel();
	private Sound sound;
	public StoryFrame() {
		this.setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(988, 494);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 989, 494);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		
		sound = new Sound();
		sound.playBGM("/mathsteroid/resources/sound/bg1.wav");
		contentPanel.setLayout(null);
		
		btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(StoryFrame.class.getResource("/mathsteroid/resources/menu/btn_exit.png")));
		btnExit.setBounds(943, 11, 36, 30);
		btnExit.setOpaque(false);
		btnExit.setBorder(null);
		btnExit.setContentAreaFilled(false);
		btnExit.addActionListener(this);
		btnExit.addMouseListener(this);
		contentPanel.add(btnExit);
		
		btnRegister = new JButton("");
		btnRegister.setIcon(new ImageIcon(StoryFrame.class.getResource("/mathsteroid/resources/user/BTN_REG3.png")));
		btnRegister.setBounds(346, 400, 130, 30);
		btnRegister.setOpaque(false);
		btnRegister.setBorderPainted(false);
		btnRegister.setContentAreaFilled(false);
		btnRegister.addActionListener(this);
		btnRegister.addMouseListener(this);
		contentPanel.add(btnRegister);
		
		btnLogIn = new JButton("");
		btnLogIn.setIcon(new ImageIcon(StoryFrame.class.getResource("/mathsteroid/resources/user/BTN_log3.png")));
		btnLogIn.setBounds(524, 400, 130, 30);
		btnLogIn.setOpaque(false);
		btnLogIn.setBorderPainted(false);
		btnLogIn.setContentAreaFilled(false);
		btnLogIn.addActionListener(this);
		btnLogIn.addMouseListener(this);
		contentPanel.add(btnLogIn);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(StoryFrame.class.getResource("/mathsteroid/resources/bg/angNUNO.gif")));
		lblNewLabel.setBounds(0, 0, 989, 494);
		contentPanel.add(lblNewLabel);
		repaint();
	}
	 private JButton btnRegister,btnExit,btnLogIn;
	 UserReg regFrame = null;
	 UserLogIn logFrame = null;
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegister){
			sound.playSFX("/mathsteroid/resources/sound/ok.wav");
			regFrame = new UserReg(this);
			regFrame.setModal(true);
			regFrame.setVisible(true);
		}
		else if(e.getSource() == btnLogIn){
			sound.playSFX("/mathsteroid/resources/sound/ok.wav");
			logFrame = new UserLogIn(this);
			logFrame.setModal(true);
			logFrame.setVisible(true);
		}	
		
		else if(e.getSource() == btnExit){
			System.exit(0);
		}
		
	}
	public void mouseEntered(MouseEvent me) {
		if(me.getSource() == btnRegister){
			btnRegister.setIcon(new ImageIcon(StoryFrame.class.getResource("/mathsteroid/resources/user/BTN_REG_HOVER.png")));
			
		}
		if(me.getSource() == btnLogIn){
			btnLogIn.setIcon(new ImageIcon(StoryFrame.class.getResource("/mathsteroid/resources/user/BTN_LOG_HOVER.png")));
			
		}
		if(me.getSource() == btnExit){
			btnExit.setIcon(new ImageIcon(StoryFrame.class.getResource("/mathsteroid/resources/menu/btn_exit_hover.png")));
		}
		
	}
	public void mouseExited(MouseEvent mEx) {
		if(mEx.getSource() == btnRegister){
			btnRegister.setIcon(new ImageIcon(StoryFrame.class.getResource("/mathsteroid/resources/user/BTN_REG3.png")));
			
		}
		if(mEx.getSource() == btnLogIn){
			btnLogIn.setIcon(new ImageIcon(StoryFrame.class.getResource("/mathsteroid/resources/user/BTN_log3.png")));
		}
		if(mEx.getSource() == btnExit){
			btnExit.setIcon(new ImageIcon(StoryFrame.class.getResource("/mathsteroid/resources/menu/btn_exit.png")));
		}
		
		
	}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	public void mouseClicked(MouseEvent arg0) {}
}
