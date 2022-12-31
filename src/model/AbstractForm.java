package model;
import java.io.Serializable;
public abstract class AbstractForm implements IWeight, Serializable {
	public abstract float volume();

	protected Wood wood;

	public AbstractForm() {
		super();
	}

	public Wood getWood() {
		return wood;
	}

	@Override
	public float weight() {
		return wood.getDensity() * volume();
	}

}