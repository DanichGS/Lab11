package store;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import event.IProductListener;
import event.ProductEvent;
import model.AbstractForm;
import model.IWeight;
import model.Timber;


public class ProductStore extends AbstractStore implements Serializable {
	
	private Map<Object,Integer> map = new TreeMap<>(new Comparator<Object>() {

		@Override
		public int compare(Object o1, Object o2) {
			return ((IWeight )o1).toString().compareTo(((IWeight)o2).toString());
		}
	});

	private IWeight timber;
	private List<Object> list = new ArrayList<>();
	List<IProductListener> productListeners = new CopyOnWriteArrayList<>();
	public void addProductListener(IProductListener listener) {
		productListeners.add(listener);
	}
	public void removeProductListener(IProductListener listener) {
		productListeners.remove(listener);
	}
	protected void fireProductEvent(ProductEvent obj) {
		productListeners.forEach((lsn)-> lsn.onProductEvent(obj));
	}
	
	public boolean add(IWeight newProduct) {
		list.add((Object) newProduct);
		fireProductEvent(new ProductEvent(this, newProduct));
		return true;
	}
	public float calcTotalWeight() {
		float sum = 0;
		for (Object timber : getArr()) {
			sum += ((IWeight)timber).weight();
		}
		return sum;
	}
	
	public String toSortedString() {
		StringBuilder sb = new StringBuilder("Content of product storage\n");
		Collections.sort(list,new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				int comp = ((IWeight )o1).name().compareTo(((IWeight)o2).name());
				if(comp != 0)
					return comp;
				return (int) (((IWeight )o1).weight()-((IWeight)o2).weight());
			}
		});
		for(int i=0; i<list.size();i++) {
			if(map.isEmpty()) {
				map.put((Object) list.get(i), 1);

			}else {
				if(map.containsKey(list.get(i))==true) {
					for(Map.Entry<Object, Integer> entry : map.entrySet()) {
						if(entry.getKey().equals(list.get(i))) {
							entry.setValue(entry.getValue()+1);
						}
					}
				}
				else {
					map.put((Object) list.get(i), 1);
				}
			}
		}
		for(Map.Entry<Object, Integer> entry:map.entrySet()) {
			Object obj = entry.getKey();
			Integer val = entry.getValue();
			sb.append(obj+" number = " + val).append("\n");
		}
		map.clear();
		return sb.toString();
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder("Вміст сховища продуктів:\n");
		
			sb.append(super.toString());
		
		return sb.toString();
	}
	@Override
	public Object[] getArr() {
		// TODO Auto-generated method stub
		return list.toArray();
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return list.iterator();
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return list.size();
	}
	public ListIterator<Object> listIterator() {
		// TODO Auto-generated method stub
		return list.listIterator();
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}
}
	
