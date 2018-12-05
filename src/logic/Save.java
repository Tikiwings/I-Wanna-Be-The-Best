package logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javafx.stage.FileChooser;

public class Save {
	private Save()
	{
		
	}

	// saves the current game's state to a file
	public static void saveProgress(Player player, List<Integer> randEventOrder, Integer currentTypingSceneIndex, String fileName) {
		
		File file = null;
		FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Save File");
    	
		if (fileName == null) {
	    	file = fileChooser.showSaveDialog(null);
		}
		
    	BufferedWriter bw = null;
    	
    	if (file != null) {
			try {
				bw = new BufferedWriter(new FileWriter(file +".txt"));
			} catch (IOException e1) {
		
				e1.printStackTrace();
			}
    	}
		else
			try {
				bw = new BufferedWriter(new FileWriter(fileName +".txt"));
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
	    if (file != null || fileName != null) {
	        try {
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
	        } 
	        catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        finally
	        {
	        	try {
	        		if(bw != null)
	        			bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	    }
	}
}
