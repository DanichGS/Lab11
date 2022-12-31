package test;

import java.io.File;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import model.Wood;
import store.WoodDirectory;

public class TestStoreObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WoodDirectory wd = new WoodDirectory();
		wd.add(new Wood(4, "Birch", 1f));
		File f = new File("wd.object");
		
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(wd);
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
