/**
 * 
 */
package com.fusion.model.instance;

import com.fusion.model.core.Criteria;


/**
 * @author zhijun
 *
 */
public class AnyConfirmCriteria extends Criteria {

	/**
	 * 
	 */
	public AnyConfirmCriteria() {
		// TODO Auto-generated constructor stub
		
	}

	/* (non-Javadoc)
	 * @see com.fusion.model.core.Criteria#isMet()
	 */
	@Override
	public boolean isMet() {
		// TODO Auto-generated method stub
		AnyConfirmFact fact=(AnyConfirmFact)getFact();
		return fact.isAnyConfirmed(activity.getParties().getParties());
	}

}
