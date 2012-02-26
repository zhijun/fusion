/**
 * 
 */
package com.fusion.model.instance;

import com.vividsolutions.jts.geom.Geometry;

/**
 * @author czj
 * 
 */
public class PickupableFact {
	private Geometry driver;
	/**
	 * Driver's Tolerated buffer
	 */
	private int buffer;
	private Geometry passenger;

	public Geometry getDriver() {
		return driver;
	}

	public void setDriver(Geometry driver) {
		this.driver = driver;
	}

	public int getBuffer() {
		return buffer;
	}

	public void setBuffer(int buffer) {
		this.buffer = buffer;
	}

	public Geometry getPassenger() {
		return passenger;
	}

	public void setPassenger(Geometry passenger) {
		this.passenger = passenger;
	}

}
