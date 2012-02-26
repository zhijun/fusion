/**
 * 
 */
package com.fusion.model.instance;

import com.fusion.model.core.Criteria;

/**
 * @author czj
 *
 */
public class PickupableCriteria extends Criteria {
	
	private PickupableFact fact=new PickupableFact();

	/* (non-Javadoc)
	 * @see com.fusion.model.core.Criteria#isMet()
	 */
	@Override
	public boolean isMet() {
		// TODO Auto-generated method stub
		return fact.getDriver().buffer(fact.getBuffer()).contains(fact.getPassenger());
	}

}
