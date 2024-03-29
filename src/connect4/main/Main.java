package connect4.main;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import connect4.engine.ConnectFourEngine;
import connect4.engine.Player;
import connect4.ui.CUI;
import connect4.ui.GUI2;
import connect4.ui.UserInterface;

public class Main {
	
	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		Player p1 = new Player(1);
		Player p2 = new Player(2);
		ConnectFourEngine e = ConnectFourEngine.initInstance(p1, p2);
		logger.info("Game Started");
		int result = JOptionPane.showConfirmDialog(null, "Enable Graphics ?", "What do you want?", JOptionPane.OK_CANCEL_OPTION);
		
		UserInterface ui;
		if(result == JOptionPane.OK_OPTION)
			ui = new GUI2();
		else
			ui = new CUI();
		ui.setEngine(e);
		ui.show();
		ui.start();
	}
}