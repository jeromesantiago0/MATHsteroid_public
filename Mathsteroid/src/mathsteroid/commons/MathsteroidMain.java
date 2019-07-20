package mathsteroid.commons;

import java.awt.EventQueue;

import javax.swing.UIManager;

import mathsteroid.views.MathsteroidMainForm;
import mathsteroid.views.StoryFrame;

public class MathsteroidMain {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//	set UI LookandFeel depending on the OS
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					StoryFrame storyframe = new StoryFrame();
					storyframe.setVisible(true);
					//storyframe.setModal(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
