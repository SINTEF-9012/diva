package diva.helpers;
class Transition {
		State target;
		String event, guard;
		
		public Transition(State target, String event, String guard) {
			this.target = target;
			this.event = event;
			this.guard = guard;
		}
		
		@Override
		public int hashCode() {
			return target.hashCode() - event.hashCode() + ((guard == null) ? 0 : guard.hashCode());
		}
		
		@Override
		public boolean equals(Object other) {		
			if (!(other instanceof Transition))
				return false;
			Transition oTarget = (Transition) other;
			System.out.println(event + " if " + guard + " ==? " + oTarget.event + " if " + oTarget.guard );
			return oTarget.event.equals(event) && oTarget.target.equals(target) && ((oTarget.guard == null) ? true : oTarget.guard.equals(guard));
		}
	}