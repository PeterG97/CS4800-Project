package graphicalPassword;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;

public class FileChooser {	
	public static void main(JFrame mainFrame, JPanel mainPanel, JLabel pictureLabel) //The three GUI elements that need to resized depending on picture
	{
		//Open Java file chooser
		final JFileChooser jFileChooser = new JFileChooser();
		int returnVal = jFileChooser.showOpenDialog(jFileChooser);
		
		//Checks if file is valid and set image to image label
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			String filePath = jFileChooser.getSelectedFile().getAbsolutePath(); //String from user file path input
			
			BufferedImage img = null; //Sets imgage based on filePath catches exceptions
			try {
				img = ImageIO.read(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			pictureLabel.setIcon(new ImageIcon(img));
			
			/* Properties that need to adjusted depending on the image size, will also need to implement a cap on size and make images scale down
			mainFrame.setBounds(100, 100, 1298, 780);
			mainPanel.setBounds(0, 20, 1280, 720);
			pictureLabel.setBounds(0, 20, 1280, 720);
			*/
		}
	}

}