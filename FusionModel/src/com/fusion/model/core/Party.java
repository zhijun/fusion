/**
 * 
 */
package com.fusion.model.core;

import com.google.code.morphia.annotations.Reference;

/**
 * @author zhijun Person or service which can be part of an Activity.
 */
public class Party {
	@Reference
	private User user;
	
	private String status;
	
	public Party(){
		
	}
	public Party(User user){
		this.user=user;
	}
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return user.getUid().hashCode();
	}


}
