/**
 * 
 */
package com.fusion.model.core;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

/**
 * @author zhijun An activity represents a durable effort started by
 *         participants including services.
 */
@Entity ("Activity")
public class Activity {
	@Id String id;
	private String title;
	private String memo;
	private Party creator;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo
	 *            the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	private Status status;
	private Parties parties;

	/**
	 * @return the parties
	 */
	public Parties getParties() {
		return parties;
	}

	/**
	 * @param parties
	 *            the parties to set
	 */
	public void setParties(Parties parties) {
		this.parties = parties;
	}

	/**
	 * @return the criterias
	 */
	public Criterias getCriterias() {
		return criterias;
	}

	/**
	 * @param criterias
	 *            the criterias to set
	 */
	public void setCriterias(Criterias criterias) {
		this.criterias = criterias;
	}

	/**
	 * @return the goals
	 */
	public Goals getGoals() {
		return goals;
	}

	/**
	 * @param goals
	 *            the goals to set
	 */
	public void setGoals(Goals goals) {
		this.goals = goals;
	}

	private Criterias criterias;
	private Goals goals;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the creator
	 */
	public Party getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(Party creator) {
		this.creator = creator;
	}

}
