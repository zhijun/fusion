/**
 * 
 */
package com.fusion.model.instance;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fusion.model.core.Party;

/**
 * @author zhijun
 *
 */
public class AnyConfirmFact {
	private Set<Party> confirmations=new HashSet<Party>();
	/**
	 * @return the confirmations
	 */
	public Set<Party> getConfirmations() {
		return confirmations;
	}
	/**
	 * @param confirmations the confirmations to set
	 */
	public void setConfirmations(Set<Party> confirmations) {
		this.confirmations = confirmations;
	}
	public void confirm(Party party){
		confirmations.add(party);
	}
	public void takeBack(Party party){
		confirmations.remove(party);
	}
	public boolean isAnyConfirmed(List<Party> parties){
		for(Party party: parties){
			if(confirmations.contains(party)){
				return true;
			}
		}
		return false;
	}
	
	
}
