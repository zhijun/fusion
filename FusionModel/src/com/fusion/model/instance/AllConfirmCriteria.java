/**
 * 
 */
package com.fusion.model.instance;

import com.fusion.model.core.Criteria;


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
		return fact.isAllConfirmed(activity.getParties().getParties());
	}

}
