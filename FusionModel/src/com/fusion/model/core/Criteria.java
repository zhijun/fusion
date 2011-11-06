/**
 * 
 */
package com.fusion.model.core;

/**
 * @author zhijun
 * 
 */
public abstract class Criteria {
	protected Activity activity;
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

	/**
	 * @return the activity
	 */
	public Activity getActivity() {
		return activity;
	}

	/**
	 * @param activity the activity to set
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	abstract public boolean isMet();

}
