package test;


import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Predicate;

import javax.swing.JOptionPane;

import model.Cylinder;
import model.IWeight;
import model.Timber;
import model.Waste;
import store.AbstractStore;
import store.ProductStore;
import store.WoodDirectory;

public class TestApp {
	private WoodDirectory wd = new WoodDirectory();
	private ProductStore ps = new ProductStore();
	private AbstractStore as = new AbstractStore();

	public static void main(String[] args) {
		TestApp app = new TestApp();
		app.startApp();
	}
	private void startApp() {
		try {
			as.add(new Waste(30f));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Введення продуктів", JOptionPane.ERROR_MESSAGE);

		}

		try {
			as.add(new Timber(wd.get(0), 0.1f, 0.3f, 0.4f));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(),
					"Введення продуктів", JOptionPane.ERROR_MESSAGE);
		}
		try {
			as.add(new Cylinder(wd.get(1), 11f, 0.5f));
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e3.getMessage(),
					"Введення продуктів", JOptionPane.ERROR_MESSAGE);
		}
		try {
			as.add(new Waste(50f));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Введення продуктів", JOptionPane.ERROR_MESSAGE);

		}
		try {
			as.add(new Waste(40f));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Введення продуктів", JOptionPane.ERROR_MESSAGE);

		}

		float maxWeight = 50f;
		Predicate<Object> prd = new Predicate<Object>() {

			@Override
			public boolean test(Object t) {
				return t instanceof Waste && ((IWeight) t).weight() > maxWeight;
			}
		};
		as.doOnlyFor( System.out::println, maxWeight);
		as.remove(prd);
		wd.doForAll( System.out::println);
		
		System.out.println("Перелік виробів до вилучення");
		System.out.println(as.toString());
		Iterator<Object> itr = as.iterator();
		//ListIterator<Object> litr = as.listiterator();
		while (itr.hasNext()) {
			IWeight obj = (IWeight) itr.next();
			if (obj.weight() > 100) itr.remove();
		}
		System.out.println("Перелік виробів після вилучення");
		System.out.println(as.toString());

		System.out.println("Вивід першого виробу із списку виробів");
		//System.out.println(litr.previous());



	}
}

