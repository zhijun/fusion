/**
 * 
 */
package com.fusion.model.instance;

import com.fusion.model.core.Criteria;
import com.fusion.model.core.Party;


/**
 * @author zhijun
 *
 */
public class AllConfirmCriteria extends Criteria {

	/**
	 * 
	 */
	public AllConfirmCriteria() {
		// TODO Auto-generated constructor stub
		
	}

	/* (non-Javadoc)
	 * @see com.fusion.model.core.Criteria#isMet()
	 */
	@Override
	public boolean isMet() {
		// TODO Auto-generated method stub
		AllConfirmFact fact=(AllConfirmFact)getFact();
		for(Party party:activity.getParties().getParties()){
			if(fact.isConfirmed(party)==false){
				return false;
			}
		}
		return true;
	}

}
