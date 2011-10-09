/**
 * 
 */
package com.fusion.core.model;

import java.util.List;

/**
 * @author zhijun
 * 
 */
public class Criterias {
	private List<Criteria> criterias;

	public List<Criteria> getCriterias() {
		return criterias;
	}

	public void setCriterias(List<Criteria> criterias) {
		this.criterias = criterias;
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
