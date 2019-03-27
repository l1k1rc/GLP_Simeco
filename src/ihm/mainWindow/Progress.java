package ihm.mainWindow;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
/**
 * Progress bar between parametersWindow and mainWindow.
 * @author MATTHIEU
 *
 */
public class Progress extends JFrame{

	private static final long serialVersionUID = 1L;
	private Thread t;
	private JProgressBar bar;
   /**
    * Allows to configure a progress bar.
    */
  public Progress(){      
    this.setSize(400, 100);
    this.setTitle("Loading...");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
	this.setIconImage(new ImageIcon("euro.png").getImage());		

      
    t = new Thread(new Traitement());
    bar  = new JProgressBar();
    bar.setMaximum(250);
    bar.setMinimum(0);
    bar.setStringPainted(true);
    
    this.getContentPane().add(bar, BorderLayout.CENTER);

    t.start();      
    this.setVisible(true);      
  }
  /**
   * Allows to configure the timer in the progress bar.
   * @author MATTHIEU
   * @see 
   */
  class Traitement implements Runnable{   
    public void run(){
         
      for(int val = 0; val <= 250; val++){
        bar.setValue(val);
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
        e.printStackTrace();
        }
      }
      setVisible(false);

      new FenetrePrincipale();      
    }   
  }

}