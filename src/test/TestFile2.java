package test;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestFile2 {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFileChooser dialog = new JFileChooser();
		dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		dialog.setDialogTitle("Софієнко Дмитро КІ-211");
		dialog.setApproveButtonText("Відкрити");
		dialog.setMultiSelectionEnabled(true);
		dialog.showOpenDialog(null);
		File[] ff = dialog.getSelectedFiles();
		if (ff != null) {
			for(File f : ff)
				System.out.println(f.getAbsolutePath());
		}
	}


}
