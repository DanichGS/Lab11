package store;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.io.Serializable;
import model.Wood;

public class WoodDirectory extends AbstractStore implements Serializable {
	Set<Object> set = new LinkedHashSet<Object>();
	{
		//set.add(new Wood(0, "Larch", 1000));
	//set.add(new Wood(1, "Pine", 750));
		//set.add(new Wood(2, "Birch", 800));
		
	}
	
	private Map<Integer, Object> map = new HashMap<>();
	{
		map.put(1, new Wood(1, "Larch", 1000));
		map.put(2, new Wood(2, "Pine", 750));
		map.put(3, new Wood(3, "Birch", 800));
	}

	public Wood get(int id) {
		return (Wood) map.get(id);
	}

	public boolean add(Wood newWood) {
		if(map.get(newWood.getId()) != null)
		return false;
		map.put(newWood.getId(), newWood);
		return true;
	}
	

	public String toString() {
		StringBuilder sb = new StringBuilder("Вміст сховища продуктів:\n");

		sb.append(super.toString());

		return sb.toString();
	}
	public int maxId() {
		return set.size()-1;
	}

	@Override
	public Object[] getArr() {
		// TODO Auto-generated method stub
		return map.values().toArray();
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return map.values().iterator();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return set.size();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return map.size();
	}

}


