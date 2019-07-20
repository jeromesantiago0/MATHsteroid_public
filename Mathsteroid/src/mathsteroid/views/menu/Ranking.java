package mathsteroid.views.menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ranking extends JDialog implements ActionListener{
	ArrayList<String> ranking = new ArrayList<String>();
	private final JPanel contentPanel = new JPanel();
	private JLabel lblScore1;
	private JLabel lblName1;
	private JLabel lblName2;
	private JLabel lblName3;
	private JLabel lblName4;
	private JLabel lblName5;
	private JLabel lblName6;
	private JLabel lblName7;
	private JLabel lblName8;
	private JLabel lblName9;
	private JLabel lblName10;
	private JLabel lblScore10;
	private JLabel lblScore9;
	private JLabel lblScore8;
	private JLabel lblScore7;
	private JLabel lblScore6;
	private JLabel lblScore5;
	private JLabel lblScore4;
	private JLabel lblScore3;
	private JLabel lblScore2;
	private JButton btnOk;
	public Ranking(ArrayList<String> ranking) {
		init();
		this.ranking = ranking;
		setRanking();
	}
	
	private void init(){
		setBounds(100, 100, 304	, 603);
		this.setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnOk = new JButton("");
		btnOk.addActionListener(this);
		btnOk.setIcon(new ImageIcon(Ranking.class.getResource("/mathsteroid/resources/menu/btn_exit.png")));
		btnOk.setOpaque(false);
		btnOk.setMargin(new Insets(0, 0, 0, 0));
		btnOk.setForeground(new Color(255, 204, 51));
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnOk.setFocusPainted(false);
		btnOk.setContentAreaFilled(false);
		btnOk.setBorderPainted(false);
		btnOk.setBounds(260, 11, 34, 20);
		contentPanel.add(btnOk);
		
		lblName1 = new JLabel("B");
		lblName1.setForeground(Color.WHITE);
		lblName1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblName1.setBounds(45, 105, 137, 35);
		contentPanel.add(lblName1);
		
		lblName2 = new JLabel("Br");
		lblName2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName2.setForeground(Color.WHITE);
		lblName2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblName2.setBounds(45, 151, 137, 35);
		contentPanel.add(lblName2);
		
		lblName3 = new JLabel("Bry");
		lblName3.setHorizontalAlignment(SwingConstants.CENTER);
		lblName3.setForeground(Color.WHITE);
		lblName3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblName3.setBounds(45, 197, 137, 35);
		contentPanel.add(lblName3);
		
		lblName4 = new JLabel("Brya");
		lblName4.setHorizontalAlignment(SwingConstants.CENTER);
		lblName4.setForeground(Color.WHITE);
		lblName4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblName4.setBounds(45, 246, 137, 35);
		contentPanel.add(lblName4);
		
		lblName5 = new JLabel("Bryan");
		lblName5.setHorizontalAlignment(SwingConstants.CENTER);
		lblName5.setForeground(Color.WHITE);
		lblName5.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblName5.setBounds(45, 292, 137, 35);
		contentPanel.add(lblName5);
		
		lblName6 = new JLabel("Bryan ");
		lblName6.setHorizontalAlignment(SwingConstants.CENTER);
		lblName6.setForeground(Color.WHITE);
		lblName6.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblName6.setBounds(45, 341, 137, 35);
		contentPanel.add(lblName6);
		
		lblName7 = new JLabel("Bryan K");
		lblName7.setHorizontalAlignment(SwingConstants.CENTER);
		lblName7.setForeground(Color.WHITE);
		lblName7.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblName7.setBounds(45, 387, 137, 35);
		contentPanel.add(lblName7);
		
		lblName8 = new JLabel("Bryan Ke");
		lblName8.setHorizontalAlignment(SwingConstants.CENTER);
		lblName8.setForeground(Color.WHITE);
		lblName8.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblName8.setBounds(45, 433, 137, 35);
		contentPanel.add(lblName8);
		
		lblName9 = new JLabel("Bryan Ken");
		lblName9.setHorizontalAlignment(SwingConstants.CENTER);
		lblName9.setForeground(Color.WHITE);
		lblName9.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblName9.setBounds(45, 479, 137, 35);
		contentPanel.add(lblName9);
		
		lblName10 = new JLabel("Bryan Ken ");
		lblName10.setHorizontalAlignment(SwingConstants.CENTER);
		lblName10.setForeground(Color.WHITE);
		lblName10.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblName10.setBounds(45, 525, 137, 35);
		contentPanel.add(lblName10);
		
		lblScore1 = new JLabel("0");
		lblScore1.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore1.setForeground(Color.WHITE);
		lblScore1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblScore1.setBounds(208, 105, 59, 35);
		contentPanel.add(lblScore1);
		
		lblScore2 = new JLabel("0");
		lblScore2.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore2.setForeground(Color.WHITE);
		lblScore2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblScore2.setBounds(208, 151, 59, 35);
		contentPanel.add(lblScore2);
		
		lblScore3 = new JLabel("0");
		lblScore3.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore3.setForeground(Color.WHITE);
		lblScore3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblScore3.setBounds(208, 197, 59, 35);
		contentPanel.add(lblScore3);
		
		lblScore4 = new JLabel("0");
		lblScore4.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore4.setForeground(Color.WHITE);
		lblScore4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblScore4.setBounds(208, 246, 59, 35);
		contentPanel.add(lblScore4);
		
		lblScore5 = new JLabel("0");
		lblScore5.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore5.setForeground(Color.WHITE);
		lblScore5.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblScore5.setBounds(208, 292, 59, 35);
		contentPanel.add(lblScore5);
		
		lblScore6 = new JLabel("0");
		lblScore6.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore6.setForeground(Color.WHITE);
		lblScore6.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblScore6.setBounds(208, 341, 59, 35);
		contentPanel.add(lblScore6);
		
		lblScore7 = new JLabel("0");
		lblScore7.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore7.setForeground(Color.WHITE);
		lblScore7.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblScore7.setBounds(208, 387, 59, 35);
		contentPanel.add(lblScore7);
		
		lblScore8 = new JLabel("0");
		lblScore8.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore8.setForeground(Color.WHITE);
		lblScore8.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblScore8.setBounds(208, 433, 59, 35);
		contentPanel.add(lblScore8);
		
		lblScore9 = new JLabel("0");
		lblScore9.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore9.setForeground(Color.WHITE);
		lblScore9.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblScore9.setBounds(208, 479, 59, 35);
		contentPanel.add(lblScore9);
		
		lblScore10 = new JLabel("0");
		lblScore10.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore10.setForeground(Color.WHITE);
		lblScore10.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblScore10.setBounds(208, 525, 59, 35);
		contentPanel.add(lblScore10);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Ranking.class.getResource("/mathsteroid/resources/menu/BGranking.png")));
			lblNewLabel.setBounds(0, 0, 304, 603);
			contentPanel.add(lblNewLabel);
		}
	}

	String[] strTemp = new String[10];
	private void setRanking(){
		//System.out.println("Ranking: " + ranking.get(0));
		for(int i = 0; i<strTemp.length; i++){
			if(ranking.size() > i)			//size = 1
				strTemp[i] = ranking.get(i); 
			else
				strTemp[i] = "0~N/A";
		}
		//for(String str : strTemp)
		//	System.out.println(str);

		lblName1.setText(strTemp[0].split("~")[1]);
		lblScore1.setText(strTemp[0].split("~")[0]);

		lblName2.setText(strTemp[1].split("~")[1]);
		lblScore2.setText(strTemp[1].split("~")[0]);

		lblName3.setText(strTemp[2].split("~")[1]);
		lblScore3.setText(strTemp[2].split("~")[0]);

		lblName4.setText(strTemp[3].split("~")[1]);
		lblScore4.setText(strTemp[3].split("~")[0]);

		lblName5.setText(strTemp[4].split("~")[1]);
		lblScore5.setText(strTemp[4].split("~")[0]);

		lblName6.setText(strTemp[5].split("~")[1]);
		lblScore6.setText(strTemp[5].split("~")[0]);

		lblName7.setText(strTemp[6].split("~")[1]);
		lblScore7.setText(strTemp[6].split("~")[0]);

		lblName8.setText(strTemp[7].split("~")[1]);
		lblScore8.setText(strTemp[7].split("~")[0]);

		lblName9.setText(strTemp[8].split("~")[1]);
		lblScore9.setText(strTemp[8].split("~")[0]);

		lblName10.setText(strTemp[9].split("~")[1]);
		lblScore10.setText(strTemp[9].split("~")[0]);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOk){
			this.dispose();
		}
	}
}
