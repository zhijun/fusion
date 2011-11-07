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
public class AllConfirmFact {
	private Set<String> confirmations=new HashSet<String>();
	/**
	 * @return the confirmations
	 */
	public Set<String> getConfirmations() {
		return confirmations;
	}
	/**
	 * @param confirmations the confirmations to set
	 */
	public void setConfirmations(Set<String> confirmations) {
		this.confirmations = confirmations;
	}
	public void confirm(Party party){
		confirmations.add(party.getUser().getUid());
	}
	public void takeBack(Party party){
		confirmations.remove(party.getUser().getUid());
	}
	public boolean isAllConfirmed(List<Party> parties){
		for(Party party: parties){
			if(confirmations.contains(party.getUser().getUid())==false){
				return false;
			}
		}
		return true;
	}
	
	
}
