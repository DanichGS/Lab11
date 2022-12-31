package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

import store.WoodDirectory;

public class TestRestroreObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WoodDirectory wd = null;
		File f = new File("wd.object");
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			wd = (WoodDirectory) ois.readObject();
			ois.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (wd != null) {
			for(Object w : wd.getArr())
				System.out.println(w.toString());
			
		}
		
	}

}
