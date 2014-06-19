/**
 * Copyright 2014 SINTEF <brice.morin@sintef.no>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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