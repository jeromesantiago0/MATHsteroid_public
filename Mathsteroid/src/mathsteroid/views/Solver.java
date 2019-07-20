/***
		 * Developer: 			Bryan Ken Altes
		 * Date Modified:		10/25/2018
		 * Description:			Make a Solver for Tutorial when the answer is Wrong 
		 */
package mathsteroid.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Solver extends JDialog {
	//String Equation = "4x+5=40";
	private final JPanel contentPanel = new JPanel();
	private JLabel steps1;
	private JLabel steps2;
	private JLabel steps3;
	private JLabel question;
	private JLabel answer;
	public JButton btnOk;
	public Solver(String Equation) {
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(300,338);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setUndecorated(true);
		contentPanel.setLayout(null);
		
		question = new JLabel("");
		question.setForeground(Color.WHITE);
		question.setFont(new Font("Segoe UI", Font.BOLD, 17));
		question.setHorizontalAlignment(SwingConstants.CENTER);
		question.setBounds(15, 37, 257, 23);
		contentPanel.add(question);
		
		btnOk = new JButton("");
		btnOk.setIcon(new ImageIcon(Solver.class.getResource("/mathsteroid/resources/menu/btn_exit.png")));
		btnOk.setContentAreaFilled(false);
		btnOk.setBorderPainted(false);
		btnOk.setOpaque(false);
		btnOk.setFocusable(false);
		btnOk.setForeground(Color.WHITE);
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnOk.setBounds(253, 11, 47, 25);
		contentPanel.add(btnOk);
		
		steps2 = new JLabel("");
		steps2.setForeground(Color.WHITE);
		steps2.setHorizontalAlignment(SwingConstants.CENTER);
		steps2.setFont(new Font("Segoe UI", Font.BOLD, 17));
		steps2.setBounds(92, 145, 180, 23);
		contentPanel.add(steps2);
		
		steps1 = new JLabel("");
		steps1.setForeground(Color.WHITE);
		steps1.setHorizontalAlignment(SwingConstants.CENTER);
		steps1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		steps1.setBounds(92, 93, 180, 23);
		contentPanel.add(steps1);
		
		steps3 = new JLabel("");
		steps3.setForeground(Color.WHITE);
		steps3.setHorizontalAlignment(SwingConstants.CENTER);
		steps3.setFont(new Font("Segoe UI", Font.BOLD, 17));
		steps3.setBounds(92, 203, 180, 23);
		contentPanel.add(steps3);
		
		JLabel Step1 = new JLabel("");
		Step1.setHorizontalAlignment(SwingConstants.CENTER);
		Step1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Step1.setBounds(15, 59, 257, 23);
		contentPanel.add(Step1);
		
		JLabel Step2 = new JLabel("");
		Step2.setHorizontalAlignment(SwingConstants.CENTER);
		Step2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Step2.setBounds(15, 131, 257, 23);
		contentPanel.add(Step2);
		
		JLabel Step3 = new JLabel("");
		Step3.setHorizontalAlignment(SwingConstants.CENTER);
		Step3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Step3.setBounds(15, 191, 257, 23);
		contentPanel.add(Step3);
		
		answer = new JLabel("");
		answer.setForeground(Color.WHITE);
		answer.setHorizontalAlignment(SwingConstants.CENTER);
		answer.setFont(new Font("Segoe UI", Font.BOLD, 20));
		answer.setBounds(106, 254, 166, 23);
		contentPanel.add(answer);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Solver.class.getResource("/mathsteroid/resources/bg/solutionbg.png")));
		lblNewLabel.setBounds(0, 0, 300, 338);
		contentPanel.add(lblNewLabel);
		solve(Equation);
	}
	public void solve(String equation){
		// Variable
		question.setText(equation);
		System.out.println(equation);
		int first = Integer.parseInt(equation.substring(0,equation.indexOf("x")));
		System.out.println(first);
		int second = Integer.parseInt(equation.substring(equation.indexOf("x")+2,equation.indexOf("=")));
		System.out.println(second);
		int third = Integer.parseInt(equation.split("=")[1]);
		System.out.println(third);
		int op;
		String op1 = equation.substring(equation.indexOf("x")+1,equation.indexOf("x")+2);
		System.out.println(op1);
		
		
		//>>>    Converter 

		if("+".equals(op1)){
			op = 0;
		}
		else{
			op = 1;
		}
		
		//>>> Checker
		//If the operator is +
		if(op == 0){
			int Step1 = third-second;
			String step1 = first+"x="+third+"-"+second;
		//	System.out.println("Step1:"+step1);
			steps1.setText(step1);
			double Step2 = ((double)(int)Step1/(double)(int)first);
			String step2 = first+"x="+Step1;
		//	System.out.println(step2);
			steps2.setText(step2);
			String convert = ""+Step2;
			if(convert.contains(".0")){
				int STep2 = Step1/first;
				String step3 = first+"x/"+first+"="+Step1+"/"+first;
				steps3.setText(step3);
				System.out.println(step3);
				String Step3 = "x="+STep2;
				answer.setText(Step3);
				System.out.println(Step3);
			}else{
				String STep2 = Step1+"/"+first;
				steps3.setText(STep2);
				String Step3 = "x="+third+"/"+STep2+" or "+Step2;
				answer.setText(Step3);
			//	System.out.println(Step3);
			}
			
		}else{
			

			int Step1 = third+second;
			String step1 = first+"x="+third+"-"+second;
			steps1.setText(step1);
		//	System.out.println(step1);
			double Step2 = ((double)(int)Step1/(double)(int)first);
			String step2 = first+"x="+Step1;
			steps2.setText(step2);
		//	System.out.println(step2);
			String convert = ""+Step2;
			if(convert.contains(".0")){
				int STep2 = Step1/first;
				String step3 = first+"x/"+first+"="+Step1+"/"+first;
				steps3.setText(step3);
		//		System.out.println(step3);
				String Step3 = "x="+STep2;
				answer.setText(Step3);
				System.out.println(Step3);
			}else{
				String STep2 = Step1+"/"+first;
				steps3.setText(STep2);
				String Step3 = "x="+third+"/"+STep2+" or "+Step2;
				answer.setText(Step3);
				System.out.println(Step3);
			}
		}
	}
}
