package node;

import java.util.ArrayList;
import java.util.List;

public class Week {
	
	private WeekID id;
	private List<Agent> agents;
	
	public Week(WeekID id){
		this.id = id;
		agents = new ArrayList<Agent>();
	}
	
	public void addAgent(Agent agent){
		agents.add(agent);
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

	public WeekID getId() {
		return id;
	}
	
	
	
}
