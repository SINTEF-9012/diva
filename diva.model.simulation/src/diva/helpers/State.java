package diva.helpers;

import java.util.HashSet;
import java.util.Set;

class State {
	final String name;
	final String description;
	final Set<Transition> targets = new HashSet<Transition>();

	public State(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	@Override
	public String toString() {
		final StringBuilder b = new StringBuilder();
		
		b.append("on entry do\n");
		b.append("print(\"" + description + "\")\n");
		b.append("end\n\n");
		
		for(Transition t : targets) {
			if (t.target == this) {
				b.append("internal event ce : contextEvents?" + t.event + "\n");
				final String guard = (t.guard == null) ? "" : "guard " + t.guard;
				b.append(guard + "\n");
				b.append("action do\n");
				b.append("print(\"" + t.event + " (" + guard.split(" == ")[1] + ") does NOT imply a reconfiguration\")\n");
				b.append("end\n\n");
			} else {
				b.append("transition -> " + t.target.name + "\n");
				b.append("event ce : contextEvents?" + t.event + "\n");
				final String guard = (t.guard == null) ? "" : "guard " + t.guard;
				b.append(guard + "\n");
				b.append("action do\n");
				b.append("print(\"" + t.event + " (" + guard.split(" == ")[1] + ") implies a reconfiguration\")\n");
				b.append("end\n\n");
			}
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