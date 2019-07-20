package mathsteroid.views.menu;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class About extends JDialog implements ActionListener {
	private JButton btnOkay;

	/**
	 * Create the panel.
	 */
	public About() {
		setUndecorated(true);
		setSize(450, 600);
		getContentPane().setLayout(null);
		
		btnOkay = new JButton("");
		btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnOkay.setIcon(new ImageIcon(About.class.getResource("/mathsteroid/resources/menu/btn_exit_hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOkay.setIcon(new ImageIcon(About.class.getResource("/mathsteroid/resources/menu/btn_exit.png")));
			}
		});
		btnOkay.setIcon(new ImageIcon(About.class.getResource("/mathsteroid/resources/menu/btn_exit.png")));
		btnOkay.addActionListener(this);
		btnOkay.setForeground(new Color(255, 204, 51));
		btnOkay.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnOkay.setFocusPainted(false);
		btnOkay.setMargin(new Insets(0, 0, 0, 0));
		btnOkay.setContentAreaFilled(false);
		btnOkay.setBorderPainted(false);
		btnOkay.setOpaque(false);
		btnOkay.setBounds(400, 15, 40, 20);
		getContentPane().add(btnOkay);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(About.class.getResource("/mathsteroid/resources/menu/bg_about.png")));
		label.setBounds(0, 0, 450, 600);
		getContentPane().add(label);

	}

	public void actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
