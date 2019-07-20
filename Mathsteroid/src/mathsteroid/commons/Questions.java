package mathsteroid.commons;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class Questions {
	private String iFinals;
	private String Range;
	String question = null;

	public String getQuestion(){
		Properties prop = new Properties();
		try{
			prop.load(new FileInputStream("src/databasePropDemo.properties"));
			Range = prop.getProperty("Range");
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Range:"+Range);
		Random rand = new Random();
		int first = rand.nextInt(Integer.parseInt(Range))+1;
		int second = rand.nextInt(Integer.parseInt(Range))+1;
		int third = rand.nextInt(Integer.parseInt(Range))+1;
		int operator = rand.nextInt(2)+1;
		int formula = 0;
		String setter = "";
		if(operator == 1){
			setter = "-";
			 formula = (first*second) - third;
		}
		if(operator == 2){
			setter = "+";
			formula = (first*second) + third;
		}
		//iFinals = (first==1?"":first)+"x"+setter+third+"="+formula;
		iFinals = first+"x"+setter+third+"="+formula;
		System.out.println("Quadtratic: "+iFinals);
		int iRand1 = rand.nextInt(second);
		int iRand2 = rand.nextInt(second);

		//Generate Choices
		int choices1 = (second+iRand1+1);
		int choices2 = (second+iRand2+1);
		int iRandomChoices = rand.nextInt(3)+1;
		if(choices1 == choices2){
			choices1 -= 1;
		}
		else if(choices1 == second){
			choices1 -= 1;
		}
		else if(second == choices2){
			choices2 += 1;
		}
/*		System.out.println(choices1);
		System.out.println(choices2);*/
		/*question = iFinals+ "@" + second+"~"+choices1+"~"+choices2+ "@" + second + "@" + "e1.png";*/
		
		
		//Radomize the position of the correct answer
		if(iRandomChoices == 1){
			question = iFinals+ "@" + second+"~"+choices1+"~"+choices2+ "@" + second + "@" + "e1.png";
		}
		if(iRandomChoices == 2){
			question = iFinals+ "@" + choices1+"~"+second+"~"+choices2+ "@" + second + "@" + "e1.png";
		}
		if(iRandomChoices == 3){
			question = iFinals+ "@" + choices2+"~"+choices1+"~"+second+ "@" + second + "@" + "e1.png";
		}
		return question;
	}
}
