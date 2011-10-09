/**
 * 
 */
package com.fusion.core.model;

/**
 * @author zhijun
 * 
 */
public abstract class Criteria {
	protected Object criteria;
	protected Object fact;

	/**
	 * @return the criteria
	 */
	public Object getCriteria() {
		return criteria;
	}

	/**
	 * @param criteria
	 *            the criteria to set
	 */
	public void setCriteria(Object criteria) {
		this.criteria = criteria;
	}

	/**
	 * @return the fact
	 */
	public Object getFact() {
		return fact;
	}

	/**
	 * @param fact
	 *            the fact to set
	 */
	public void setFact(Object fact) {
		this.fact = fact;
	}

	abstract public boolean isMet();

}
