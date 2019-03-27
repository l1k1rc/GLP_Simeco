package ihm.saveAndRestore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
 
 
public class SelectionFichier {
	private static HashMap<String, ArrayList<Integer>> result=new HashMap<String,ArrayList<Integer>>();
    public SelectionFichier() {
    	try{
            // creation of the dialog box
            JFileChooser dialogue = new JFileChooser();
             FileFilter test=new FileNameExtensionFilter(".ser", ".jpg");
             dialogue.setDialogTitle("Choisissez votre .ser :");
             dialogue.setFileFilter(test);
            // display it
            	dialogue.showOpenDialog(null);
             
            // recovery the selected file
            restoreStockParam(dialogue.getSelectedFile());		
				
    	}catch(Exception e) {
    		System.out.println("Pas de fichier sélectionné");// Mettre ça dans un JLabel
    	}
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    /*
     * Allows to restore the previous parameters from the previous simulation.
     */
	public void restoreStockParam(File file) {
		try {
		FileInputStream f= new FileInputStream(file); 
		@SuppressWarnings("resource")
		ObjectInputStream s=new ObjectInputStream(f);
		result=(HashMap)s.readObject();

		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static HashMap<String, ArrayList<Integer>> getResult() {
		return result;
	}
    
}