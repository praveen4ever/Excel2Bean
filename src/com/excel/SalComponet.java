/**
 * 
 */
package com.excel;

import java.util.Date;

/**
 * @author PraVeenraj
 * 
 */
public class SalComponet {

	private String componentName;
	private Integer componentID;
	private Float componentAmount;
	private Double componentMaxAmount;
	private boolean isEnabled;
	private Date expiryDate;

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public Integer getComponentID() {
		return componentID;
	}

	public void setComponentID(Integer componentID) {
		this.componentID = componentID;
	}

	public Float getComponentAmount() {
		return componentAmount;
	}

	public void setComponentAmount(Float componentAmount) {
		this.componentAmount = componentAmount;
	}

	public Double getComponentMaxAmount() {
		return componentMaxAmount;
	}

	public void setComponentMaxAmount(Double componentMaxAmount) {
		this.componentMaxAmount = componentMaxAmount;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}




}
