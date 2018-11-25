package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import javax.swing.JFileChooser;

public class Save {

	// saves the current game's state to a file
	public static void saveProgress(Player player, List<Integer> randEventOrder, Integer currentTypingSceneIndex) {
	    JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new File(chooser.getCurrentDirectory().toString()));
	    int retrival = chooser.showSaveDialog(null);
	    if (retrival == JFileChooser.APPROVE_OPTION) {
	        try {
	        	BufferedWriter bw = new BufferedWriter(new FileWriter(chooser.getSelectedFile()+".txt"));
	            bw.write(player.getCurClass());
	            bw.newLine();
	            bw.write(player.getInt().toString());
	            bw.newLine();
	            bw.write(player.getChar().toString());
	            bw.newLine();
	            bw.write(player.getHP().toString());
	            bw.newLine();
	            bw.write(player.getMP().toString());
	            bw.newLine();
	            bw.write(player.getScore().toString());
	            bw.newLine();
	            bw.write(currentTypingSceneIndex.toString());
	            for (int i = 0; i < randEventOrder.size(); i++) {
	            	bw.newLine();
	            	bw.write(randEventOrder.get(i).toString());
	            }
	            bw.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}
}
