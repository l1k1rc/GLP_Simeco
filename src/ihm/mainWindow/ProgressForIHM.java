package ihm.mainWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
/**
 * Progress bar for the IHM.
 *
 */
public class ProgressForIHM extends JPanel{

	private static final long serialVersionUID = 1L;
	private static JProgressBar bar;
   /**
    * Allows to configure a specific progress bar for the IHM. 
    */
  public ProgressForIHM(){      
      
    bar  = new JProgressBar();
    bar.setMinimum(0);
    bar.setForeground(new Color(100, 200, 220));
    bar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    bar.setStringPainted(true);
    bar.setPreferredSize(new Dimension(150, 80));
    bar.setToolTipText("Votre progression");
    
    
    add(bar, BorderLayout.CENTER);
    this.setVisible(true);      
  }
  public static void incrementBar(int val) {
	  bar.setValue(val);
  }
  public static void setMaximumBar(int max) {
	  bar.setMaximum(max);
  }
  public static void setEndBar() {
	  bar.setValue(100);
  }
}
