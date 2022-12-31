package model;
import java.io.Serializable;
import java.util.Objects;
public class Cylinder extends AbstractForm implements Serializable {
	@Override
	public int hashCode() {
		return Objects.hash(diameter, length);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cylinder other = (Cylinder) obj;
		return Float.floatToIntBits(diameter) == Float.floatToIntBits(other.diameter)
				&& Float.floatToIntBits(length) == Float.floatToIntBits(other.length);
	}

	private float length;
	private float diameter;

	

	public Cylinder(Wood wood, float length, float diameter) throws Exception {
		super();
		this.wood = wood;
		setLength(length);
		setDiameter(diameter);
	}

	public float getLength() {
		return length;
	}

	public float getDiameter() {
		return diameter;
	}
	
	public void setLength(float length) throws Exception {
		if (length < 0.1 || length > 11) 
			throw new Exception(length + " is not correct length.\n" +
			"Must be from 1 to 10 m");
		this.length = length;
	}

	public void setDiameter(float diameter) throws Exception {
		if (diameter < 0.1 || diameter > 5) 
			throw new Exception(diameter + " is not correct diameter.\n" +
			"Must be from 1 to 4 m");
		this.diameter = diameter;
	}

	@Override
	public float volume() {
		return (float) (Math.PI * Math.pow(diameter/2, 2))* length;
	}
	@Override
	public String toString() {
		return "Cylinder [" + wood + ", weight=" + weight() + "]";
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Cylinder";
	}
	
	
}
