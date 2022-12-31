package event;

import java.util.Date;
import java.util.EventObject;

import model.IWeight;

public class ProductEvent extends EventObject {
Date date = new Date();
private IWeight product;
private long time;
public ProductEvent(Object source, IWeight product) {
	super(source);
	this.product = product;
	this.time = System.currentTimeMillis();
}
public IWeight getProduct() {
	return product;
}
public long getTime() {
	return time;
}
@Override
public String toString() {
	return "Користувач додав через " + time % 1000 + " мілісекунд після останньої дії" + ": " + product;
}


}
