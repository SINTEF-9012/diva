package diva.helpers;

import java.util.HashSet;
import java.util.Set;

class State {
	String name;
	Set<Transition> targets = new HashSet<Transition>();

	public State(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		for(Transition t : targets) {
			b.append("transition -> " + t.target.name + "\n");
			b.append("event ce : contextEvents?" + t.event + "\n");
			String guard = (t.guard == null) ? "" : "guard " + t.guard + "\n";
			b.append(guard + "\n");
		}
		return b.toString();
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof State))
			return false;
		State oState = (State) other;
		return oState.name.equals(name);
	}
}