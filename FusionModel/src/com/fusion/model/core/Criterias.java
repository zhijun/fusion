/**
 * 
 */
package com.fusion.model.core;

import java.util.List;

/**
 * @author zhijun
 * 
 */
public class Criterias {
	/**
	 * Parent Activity reference. 
	 */
	private Activity activity;
	
	private List<Criteria> criterias;

	public List<Criteria> getCriterias() {
		return criterias;
	}

	public void setCriterias(List<Criteria> criterias) {
		this.criterias = criterias;
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

	public boolean isMet() {
		for (Criteria criteria : criterias) {
			if (criteria.isMet() == false) {
				return false;
			}
		}
		return true;
	}


}
