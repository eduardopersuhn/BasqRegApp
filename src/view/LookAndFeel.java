package view;

import javax.swing.UIManager;

public class LookAndFeel {
	
	public static void set() {
		try {
			  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
		  e.printStackTrace();
		}
	}
	
}
