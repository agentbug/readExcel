package node;

import java.util.Arrays;

public class Equipment {

	private String id;
	private Type type;
	private int[] charges;
	private Integer noWeek =  null;
	
	
	public Equipment(String id,Type type){
		this.id = id;
		this.type = type;
		charges = new int[18];
	}
	public Equipment(String id,Type type,int[] charges){
		this.id = id;
		this.type = type;
		this.charges = charges;
	}
	
	public Equipment(String id,Type type,int referance){
		this.id = id;
		this.type = type;
		charges = new int[18];
		this.noWeek = (referance % charges.length);
	}
	
	public int getCharge(){
		return charges[noWeek];
	}
	
	public void nextWeek(){
		noWeek = ((noWeek+1) % charges.length);
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int[] getCharges() {
		return charges;
	}

	public void setCharges(int[] charges) {
		this.charges = charges;
	}

	public int getReferance() {
		return noWeek;
	}

	public void setReferance(int referance) {
		this.noWeek = (referance % charges.length);
	}
	@Override
	public String toString() {
		return "Equipment [id=" + id + ", type=" + type + ", charges=" + Arrays.toString(charges) + ", referance="
				+ noWeek + "]";
	}
	
	
}
