package logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import javafx.stage.FileChooser;

public class Save {

	// saves the current game's state to a file
	public static void saveProgress(Player player, List<Integer> randEventOrder, Integer currentTypingSceneIndex) {
		
		FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Save File");
    	File file = fileChooser.showSaveDialog(null);
		
	    if (file != null) {
	        try {
	        	BufferedWriter bw = new BufferedWriter(new FileWriter(file +".txt"));
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
	
	public static void saveProgressTestMethod(Player player, List<Integer> randEventOrder, Integer currentTypingSceneIndex, String fileName) {
		 try {
	        	BufferedWriter bw = new BufferedWriter(new FileWriter(fileName +".txt"));
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
