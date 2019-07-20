package mathsteroid.views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import java.awt.Font;

public class Asteroid extends JPanel implements MouseListener{
	public JLabel lblJ;
	public String question;
	public String choices;
	public String answer;
	public String solution;
	public JButton btnQuestion;
	public JButton btnA;
	public JButton btnB;
	public JButton btnC;

	/**
	 * Create the panel.
	 */
	public Asteroid(String path, String question, String choices, String answer, String solution,
			Point a, Point b, Point c, Point q) {
		setOpaque(false);
		setLayout(null);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setPreferredSize(new Dimension(161, 261));
		
		//	set Global values for the following variables
		this.question = question;
		this.choices = choices;
		this.answer = answer;
		this.solution = solution;
		
		btnC = new JButton(choices.split("~")[2]);
		btnC.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnC.setForeground(new Color(115, 77, 38));
		btnC.setBounds(c.x, c.y, 40, 30);  
		btnC.setFocusPainted(false);
		btnC.setMargin(new Insets(0, 0, 0, 0));
		btnC.setContentAreaFilled(false);
		btnC.setBorderPainted(false);
		btnC.setOpaque(false);
		btnC.addMouseListener(this);
		add(btnC);
		
		btnB = new JButton(choices.split("~")[1]);
		btnB.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnB.setForeground(new Color(115, 77, 38));
		btnB.setBounds(b.x, b.y, 40, 30);  
		btnB.setFocusPainted(false);
		btnB.setMargin(new Insets(0, 0, 0, 0));
		btnB.setContentAreaFilled(false);
		btnB.setBorderPainted(false);
		btnB.setOpaque(false);
		btnB.addMouseListener(this);
		add(btnB);
		
		btnA = new JButton(choices.split("~")[0]);
		btnA.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnA.setForeground(new Color(115, 77, 38));
		btnA.setBounds(a.x, a.y, 40, 30);  
		btnA.setFocusPainted(false);
		btnA.setMargin(new Insets(0, 0, 0, 0));
		btnA.setContentAreaFilled(false);
		btnA.setBorderPainted(false);
		btnA.setOpaque(false);
		btnA.addMouseListener(this);
		add(btnA);
		
		btnQuestion = new JButton(question);
		btnQuestion.setForeground(Color.WHITE);
		btnQuestion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQuestion.setBounds(q.x, q.y, 90, 60);
		btnQuestion.setFocusPainted(false);
		btnQuestion.setMargin(new Insets(0, 0, 0, 0));
		btnQuestion.setContentAreaFilled(false);
		btnQuestion.setBorderPainted(false);
		btnQuestion.setOpaque(false);
		add(btnQuestion);
		
		lblJ = new JLabel("");
		lblJ.setOpaque(false);
		lblJ.setBounds(0, 0, 161, 261);
		lblJ.setIcon(new ImageIcon(Asteroid.class.getResource(path)));
		add(lblJ);
	}
	
	public void setExplosion(String path){
		remove(btnA);
		remove(btnB);
		remove(btnC);
		remove(btnQuestion);
		lblJ.setIcon(new ImageIcon(Asteroid.class.getResource(path)));
		lblJ.revalidate();
	}
	
	public void changeIcon(String path){
		lblJ.setIcon(new ImageIcon(Asteroid.class.getResource(path)));
		lblJ.revalidate();
		
	}

	public void mouseEntered(MouseEvent mEn) {
		if(mEn.getSource() == btnA){
			btnA.setFont(new Font("Tahoma", Font.BOLD, 28));
			btnA.setForeground(new Color(244, 128, 66));
		}
		else if(mEn.getSource() == btnB){
			btnB.setFont(new Font("Tahoma", Font.BOLD, 28));
			btnB.setForeground(new Color(244, 128, 66));
		}
		else if(mEn.getSource() == btnC){
			btnC.setFont(new Font("Tahoma", Font.BOLD, 28));
			btnC.setForeground(new Color(244, 128, 66));
		}
	}

	public void mouseExited(MouseEvent mEx) {
		if(mEx.getSource() == btnA){
			btnA.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnA.setForeground(new Color(115, 77, 38));
		}
		else if(mEx.getSource() == btnB){
			btnB.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnB.setForeground(new Color(115, 77, 38));
		}
		else if(mEx.getSource() == btnC){
			btnC.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnC.setForeground(new Color(115, 77, 38));
		}
	}

	
	
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	public void mouseClicked(MouseEvent arg0) {}
}
