package mathsteroid.views.menu;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import mathsteroid.views.Earth;
import mathsteroid.views.MathsteroidGamePlay;
import mathsteroid.views.MessageDialog;

import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends JDialog implements ActionListener {
	private JButton btnOkay;
	private JButton btnHigante;
	private JButton btnBalot;
	private JButton btnBilao;
	private MessageDialog messageDialog;

	/**
	 * Create the panel.
	 */
	public Shop() {
		setUndecorated(true);
		setSize(601, 345);
		getContentPane().setLayout(null);
		
		btnOkay = new JButton("");
		btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOkay.setIcon(new ImageIcon(Shop.class.getResource("/mathsteroid/resources/menu/btn_exit_hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOkay.setIcon(new ImageIcon(Shop.class.getResource("/mathsteroid/resources/menu/btn_exit.png")));
			}
		});
		btnOkay.setIcon(new ImageIcon(Shop.class.getResource("/mathsteroid/resources/menu/btn_exit.png")));
		btnOkay.setBackground(Color.WHITE);
		btnOkay.addActionListener(this);
		btnOkay.setForeground(new Color(255, 204, 51));
		btnOkay.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnOkay.setFocusPainted(false);
		btnOkay.setMargin(new Insets(0, 0, 0, 0));
		btnOkay.setContentAreaFilled(false);
		btnOkay.setBorderPainted(false);
		btnOkay.setBounds(553, 7, 40, 20);
		getContentPane().add(btnOkay);
		
		btnHigante = new JButton("");
		btnHigante.setIcon(new ImageIcon(Shop.class.getResource("/mathsteroid/resources/menu/btn_buy.png")));
		btnHigante.setOpaque(false);
		btnHigante.setMargin(new Insets(0, 0, 0, 0));
		btnHigante.setForeground(new Color(255, 204, 51));
		btnHigante.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnHigante.setFocusPainted(false);
		btnHigante.setContentAreaFilled(false);
		btnHigante.setBorderPainted(false);
		btnHigante.setBounds(45, 276, 124, 37);
		btnHigante.addActionListener(this);
		getContentPane().add(btnHigante);
		
		btnBalot = new JButton("");
		btnBalot.setIcon(new ImageIcon(Shop.class.getResource("/mathsteroid/resources/menu/btn_buy.png")));
		btnBalot.setOpaque(false);
		btnBalot.setMargin(new Insets(0, 0, 0, 0));
		btnBalot.setForeground(new Color(255, 204, 51));
		btnBalot.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBalot.setFocusPainted(false);
		btnBalot.setContentAreaFilled(false);
		btnBalot.setBorderPainted(false);
		btnBalot.setBounds(234, 276, 124, 37);
		btnBalot.addActionListener(this);
		getContentPane().add(btnBalot);
		
		btnBilao = new JButton("");
		btnBilao.setIcon(new ImageIcon(Shop.class.getResource("/mathsteroid/resources/menu/btn_buy.png")));
		btnBilao.setOpaque(false);
		btnBilao.setMargin(new Insets(0, 0, 0, 0));
		btnBilao.setForeground(new Color(255, 204, 51));
		btnBilao.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBilao.setFocusPainted(false);
		btnBilao.setContentAreaFilled(false);
		btnBilao.setBorderPainted(false);
		btnBilao.setBounds(434, 276, 124, 37);
		btnBilao.addActionListener(this);
		getContentPane().add(btnBilao);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Shop.class.getResource("/mathsteroid/resources/menu/bg_shop.png")));
		label.setBounds(0, 0, 601, 345);
		getContentPane().add(label);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOkay)
			this.dispose();
		else if(e.getSource() == btnHigante){
			this.setModal(false);
			if(gamePlay != null){
				if(gamePlay.iCoins >= HIGANTE){
					messageDialog = new MessageDialog(null, false);
					messageDialog.setModal(true);
					messageDialog.setBackgroundImage("/mathsteroid/resources/dialogs/DO_YOU.png");
					messageDialog.setVisible(true);
					if(!messageDialog.isVisible()){
						if(messageDialog.getConfirmation()){
							messageDialog.dispose();
							messageDialog = new MessageDialog(null, false);
							messageDialog.setModal(true);
							messageDialog.setCancelVisibility(false);
							messageDialog.setBackgroundImage("/mathsteroid/resources/dialogs/PUR_GIANT.png");
							messageDialog.setVisible(true);
							earth.setLife(-15);
							gamePlay.setCoins(gamePlay.iCoins - HIGANTE);
						}
					}
					
				}
				else{
					messageDialog = new MessageDialog(null, false);
					messageDialog.setModal(true);
					messageDialog.setBackgroundImage("/mathsteroid/resources/dialogs/insuf_giant.png");
					messageDialog.setCancelVisibility(false);
					messageDialog.setVisible(true);
				}
			}
		}
		else if(e.getSource() == btnBalot){
			if(gamePlay != null){
				if(gamePlay.iCoins >= BALOT){
					messageDialog = new MessageDialog(null, false);
					messageDialog.setModal(true);
					messageDialog.setBackgroundImage("/mathsteroid/resources/dialogs/DO_YOU.png");
					messageDialog.setVisible(true);
					if(!messageDialog.isVisible()){
						if(messageDialog.getConfirmation()){
							messageDialog.dispose();
							messageDialog = new MessageDialog(null, false);
							messageDialog.setModal(true);
							messageDialog.setCancelVisibility(false);
							messageDialog.setBackgroundImage("/mathsteroid/resources/dialogs/PUR_BALOT.png");
							messageDialog.setVisible(true);
							System.out.println(earth.getLife());
							earth.setLife(-10);
							gamePlay.setCoins(gamePlay.iCoins - BALOT);
						}
					}
					
				}
				else{
					messageDialog = new MessageDialog(null, false);
					messageDialog.setModal(true);
					messageDialog.setBackgroundImage("/mathsteroid/resources/dialogs/insuf_balot.png");
					messageDialog.setCancelVisibility(false);
					messageDialog.setVisible(true);
				}
			}
		}
		else if(e.getSource() == btnBilao){
			if(gamePlay != null){
				/*if(gamePlay.Coins >= BILAO){
					earth.setLife(earth.getLife() + 10);
					gamePlay.Coins -= BILAO;
					JOptionPane.showMessageDialog(null, "Congratulations you successfully purchased the item!");
				}*/

				if(gamePlay.iCoins >= BALOT){
					messageDialog = new MessageDialog(null, false);
					messageDialog.setModal(true);
					messageDialog.setBackgroundImage("/mathsteroid/resources/dialogs/DO_YOU.png");
					messageDialog.setVisible(true);
					if(!messageDialog.isVisible()){
						if(messageDialog.getConfirmation()){
							messageDialog.dispose();
							messageDialog = new MessageDialog(null, false);
							messageDialog.setModal(true);
							messageDialog.setCancelVisibility(false);
							messageDialog.setBackgroundImage("/mathsteroid/resources/dialogs/PUR_BILAO.png");
							messageDialog.setVisible(true);
							System.out.println(earth.getLife());
							earth.setLife(-5);
							gamePlay.setCoins(gamePlay.iCoins - BILAO);
						}
					}
					
				}
				else{
					messageDialog = new MessageDialog(null, false);
					messageDialog.setModal(true);
					messageDialog.setBackgroundImage("/mathsteroid/resources/dialogs/insuf_bilao.png");
					messageDialog.setCancelVisibility(false);
					messageDialog.setVisible(true);
				}
			}
				
			}
		}
	
	private int coins;
	private static final int HIGANTE = 1300;
	private static final int BALOT = 900;
	private static final int BILAO = 500;
	
	private Earth earth;
	public Earth acceptEarth(Earth earth){
		this.earth = earth;
		
		return this.earth;
	}
	
	MathsteroidGamePlay gamePlay;
	public MathsteroidGamePlay acceptGamePlay(MathsteroidGamePlay gamePlay){
		this.gamePlay = gamePlay;
		
		return this.gamePlay;
	}
}
