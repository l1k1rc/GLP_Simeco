package ihm.parametersWindow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class SaveParam {
	private String path;
	/**
	 * Allows to save our "Params Window" with all of its parameters in a ".ser" file with a particular name.
	 * @param stock
	 */
	public SaveParam(HashMap<String,ArrayList<Integer>> stock) {
		try {
			JOptionPane jop = new JOptionPane();
			@SuppressWarnings("static-access")
			String chemin = jop.showInputDialog(null, "Veuillez donner le nom de votre fichier à sauvegarder :", "Sauvegarde", JOptionPane.QUESTION_MESSAGE);
			if(chemin != null) {
				FileOutputStream f=new FileOutputStream(chemin+".ser");
				ObjectOutputStream s=new ObjectOutputStream(f);
				path=new File(chemin+".ser").getAbsolutePath();
				s.writeObject(stock);
				//flow closing
				s.close();
				f.close();
				//buffer closing
				s.flush();
				f.flush();
				JOptionPane.showMessageDialog(null, "Fichier sauvegardé dans"+path,"ATTENTION", JOptionPane.WARNING_MESSAGE);
			}
			}catch(IOException e) {}
		}
}

