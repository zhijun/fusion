/**
 * 
 */
package com.fusion.model.core;

/**
 * @author zhijun
 * 
 */
public abstract class Criteria {
	protected Object expected;
	protected Object fact;

	/**
	 * @return the criteria
	 */
	public Object getExpected() {
		return expected;
	}

	/**
	 * @param criteria
	 *            the criteria to set
	 */
	public void setExpected(Object expected) {
		this.expected = expected;
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
