package store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

import model.Cylinder;
import model.IWeight;
import model.Timber;
import model.Waste;

import java.io.Serializable;
public abstract class AbstractStore implements Serializable, Iterable<Object>, Collection<Object> {
	private List<Object> list = new ArrayList<Object>();


	public abstract int getCount();

	public abstract Object[] getArr();

	public boolean add(Object newObject) {
		list.add(newObject);
		return true;
		
	}

	public void remove(Predicate<Object> prd) {
		Iterator<Object> itr = this.iterator();
		while (itr.hasNext()) {
			Object obj = (Object) itr.next();
			if (prd.test(obj)) {
				itr.remove();
				
			} 
		}	
	}
	
	public void doForAll(Consumer<Object> cns) {
		Iterator<Object> itr = this.iterator();
		while (itr.hasNext()) {
			Object obj = (Object) itr.next();
			cns.accept(obj);
		}
	}
	public void doOnlyFor(Consumer<Object> cns, float maxWeight) {
		Iterator<Object> itr = this.iterator();
		while (itr.hasNext()) {
			IWeight obj = (IWeight) itr.next();
		
			if(obj.weight() > maxWeight) {
				cns.accept(obj);	
		 }
	}
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Object obj : this) 
			sb.append(obj).append("\n");
		return sb.toString();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Object> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}