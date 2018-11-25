package application;

import java.io.BufferedWriter;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
//import java.util.Base64;
import java.util.List;

import javax.swing.JFileChooser;

public class Save {

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
	
//	private static String toString(Serializable o) throws IOException {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(baos);
//        oos.writeObject(o);
//        oos.close();
//        return Base64.getEncoder().encodeToString(baos.toByteArray()); 
//    }
//	
//	private static Object fromString(String s) throws IOException, ClassNotFoundException {
//		byte [] data = Base64.getDecoder().decode(s);
//		ObjectInputStream ois = new ObjectInputStream( 
//		new ByteArrayInputStream(data));
//		Object o = ois.readObject();
//		ois.close();
//		return o;
//	}
//	
	
}
