/**
 * 
 */
package com.fusion.model.core;

import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.annotations.Reference;

/**
 * @author zhijun
 * 
 */
public class Criterias {
	/**
	 * Parent Activity reference. 
	 */
	@Reference
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
	
	public void addCriteria(Criteria criteria){
		if(criterias==null){
			criterias=new ArrayList<Criteria>(5);
		}
		criterias.add(criteria);
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
