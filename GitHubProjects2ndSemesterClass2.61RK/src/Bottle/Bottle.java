package Bottle;

public class Bottle<D> {
	private D content;
	
	public void fill(D content) {
		this.content = content;
	}

	public D empty() {
		D content = this.content;
		this.content = null;
		return content;
	}
	
	
}
