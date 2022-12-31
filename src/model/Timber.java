package model;
import java.io.Serializable;
import java.util.Objects;
public class Timber extends AbstractForm implements Serializable {
	@Override
	public int hashCode() {
		return Objects.hash(height, length, width);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Timber other = (Timber) obj;
		return Float.floatToIntBits(height) == Float.floatToIntBits(other.height)
				&& Float.floatToIntBits(length) == Float.floatToIntBits(other.length)
				&& Float.floatToIntBits(width) == Float.floatToIntBits(other.width);
	}
	private float length;
	private float height;
	private float width;
	public Timber(Wood wood, float length, float height, float width) throws Exception {
		super();
		this.wood = wood;
		setLength(length);
		setHeight(height);
		setWidth(width);
	}
	public float getLength() {
		return length;
	}
	public float getHeight() {
		return height;
	}
	public float getWidth() {
		return width;
	}
	public void setLength(float length) throws Exception {
		if (length < 0.1 || length > 11) 
			throw new Exception(length + " is not correct length.\n" +
			"Must be from 1 to 10 m");
		this.length = length;
	}
	public void setHeight(float height) throws Exception {
		if (height < 0.1 || height > 3) 
			throw new Exception(height + " is not correct height.\n" +
			"Must be from 1 to 2 m");
		this.height = height;
	}
	public void setWidth(float width) throws Exception {
		if (width < 0.1 || width > 3) 
			throw new Exception(width + " is not correct weight.\n" +
			"Must be from 1 to 2 m");
		this.width = width;
	}
public float volume() {
	return length * height * width;
}

@Override
public String toString() {
	return "Timber [" + wood + ", weight=" + weight() + "]";
}
@Override
public String name() {
	// TODO Auto-generated method stub
	return "Timber";
}

}
