
package model;
import java.io.Serializable;
import java.util.Objects;
public class Wood implements Serializable {
	private int id;
	private String name;
	private float density;
	
	public Wood(int id, String name, float density) {
		super();
		this.id = id;
		this.name = name;
		this.density = density;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getDensity() {
		return density;
	}
	public void setDensity(float density) {
		this.density = density;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(density, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wood other = (Wood) obj;
		return Float.floatToIntBits(density) == Float.floatToIntBits(other.density) && id == other.id
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Wood [id=" + id + ", name=" + name + ", density=" + density;
	}

}

