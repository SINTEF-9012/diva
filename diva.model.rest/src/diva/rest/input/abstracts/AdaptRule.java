package diva.rest.input.abstracts;

import java.util.Collection;

import diva.rest.input.local.AdaptRuleLocal;

public abstract class AdaptRule {
	
	public static AdaptRule INSTANCE = new AdaptRuleLocal();

	public AdaptRule() {
		super();
	}

	public abstract int getPriority(String name, String property);

	public abstract String getRule(String name);

	public abstract Collection<String> allRuleNames();

}