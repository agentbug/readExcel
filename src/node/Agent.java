package node;

import java.util.ArrayList;
import java.util.List;

public class Agent {
	
	private AgentID id;
	private List<Equipment> thursday;
	private List<Equipment> wednesday;
	
	
	public Agent(AgentID id){
		this.id = id;
		thursday = new ArrayList<Equipment>();
		wednesday = new ArrayList<Equipment>();
	}
	
	public void addEquipmentToThursday(Equipment equipment){
		thursday.add(equipment);
	}
	
	public void addEquipmentToWednesday(Equipment equipment){
		wednesday.add(equipment);
	}

	
	
	public List<Equipment> getThursday() {
		return thursday;
	}

	public void setThursday(List<Equipment> thursday) {
		this.thursday = thursday;
	}

	public List<Equipment> getWednesday() {
		return wednesday;
	}

	public void setWednesday(List<Equipment> wednesday) {
		this.wednesday = wednesday;
	}

	public AgentID getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", thursday=" + thursday + ", wednesday=" + wednesday + "]";
	}
	
	
	
}
