package model;
import java.io.Serializable;
import java.util.Objects;
public class Waste implements IWeight, Serializable {
	@Override
	public int hashCode() {
		return Objects.hash(weight);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Waste other = (Waste) obj;
		return Float.floatToIntBits(weight) == Float.floatToIntBits(other.weight);
	}
	private float weight;
	@Override
	public float weight() {
		// TODO Auto-generated method stub
		return weight;
		
	}
	public Waste(float weight) throws Exception {
		super();
		setWeight(weight);
	}
	public void setWeight(float weight) throws Exception  {
		if (weight < 20 || weight > 100) 
		throw new Exception(weight + " is not correct weight.\n" +
		"Must be from 20 to 100 kg");	
		
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Waste [weight=" + weight + "]";
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Waste";
	}

}
