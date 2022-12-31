package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import model.Wood;

public class TestCollections {

	public static void main(String[] args) {

		Random rnd = new Random();
		Collection<Integer> c1 = new Vector<>();
		for (int i = 0; i < 15; i++) {
			c1.add(rnd.nextInt(10));
		}
		System.out.println("Collection Vector");
		for (Integer x : c1) 
			System.out.printf(" %d", x);
			
		Collection<Integer> c2 = new TreeSet<>();
		c2.addAll(c1);
		System.out.println("\nCollection TreeSet");
		c2.forEach((x)-> System.out.printf(" %d", x));
		
		
		//////////////////////////////////////////////////////////////
		Collection<Integer> c3 = new ArrayList<>();
		Collection<Integer> c4 = new LinkedHashSet<>();
		Collection<Integer> c5 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			c3.add(rnd.nextInt(10));
			c4.add(rnd.nextInt(10));
		}
		c5.addAll(c3); c5.removeAll(c4);
		System.out.println("\n" + c3 + " removeAll " + c4 + " = " + c5);
		
		c5.clear(); c5.addAll(c4); c5.removeAll(c3);
		System.out.println("\n" + c4 + " removeAll " + c3 + " = " + c5);
		
		c5.clear(); c5.addAll(c3); c5.retainAll(c4);
		System.out.println("\n" + c3 + " retainAll " + c4 + " = " + c5);
		
		c5.clear(); c5.addAll(c4); c5.retainAll(c3);
		System.out.println("\n" + c4 + " retainAll " + c3 + " = " + c5);
		
		
		////////////////////////////////////////////////
		Collection<Integer> c6 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			c6.add(rnd.nextInt(10));
		}
		Collection<Integer> c7 = new LinkedHashSet<>();
		c7.addAll(c6);
		boolean b1 = c6.containsAll(c7);
		System.out.println("\n" + c6 + " containsAll " + c7 + " = " + b1);
		
		Collection<Integer> c8 = new TreeSet<>();
		c8.addAll(c6);
		boolean b2 = c6.containsAll(c8);
		System.out.println("\n" + c6 + " containsAll " + c8 + " = " + b2);
		
		
		/////////////////////////////////////////////////////////////////
		List<Integer> c9 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			c9.add(rnd.nextInt(10));
		}
		c9.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {

				return a - b;
			}
		});
		
		
		/////////////////////////////////
		Collection<Integer> coll = new ArrayDeque<>();
		Collections.addAll(coll, 1, 3, 5, 3, 4, 2, 14);
		Collections.addAll(coll, new Integer[]{3,7,12});
		System.out.println(coll);
		System.out.println(Collections.frequency(coll, 3));
		System.out.println(Collections.max(coll));
		System.out.println(Collections.min(coll));
		///////////////////////////////////
		List<Integer> list = new ArrayList<>(coll);
		Collections.swap(list, 2, 6);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		System.out.println(Collections.binarySearch(list, 3));
		Collections.sort(list,(a,b)->b-a);
		System.out.println(list);
		System.out.println(Collections.binarySearch(list,3,(a,b)->b-a));
		Collections.reverse(list);
		System.out.println(list);
		Collections.rotate(list, 2);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		Collections.replaceAll(list, 3, 8);
		System.out.println(list);
		Collections.fill(list, 0);
		System.out.println(list);
		
		
		/////////////////////////////////////////
		Set<Wood> set = new HashSet<>();
		set.add(new Wood(1,"Lypa",1f));
		set.add(new Wood(1,"Lypa",1f));
		set.add(new Wood(1,"Lypa",1f));
		
		set.forEach(System.out::println);
	}
	

}
