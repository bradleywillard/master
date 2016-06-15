package org.bwillard.ccsf.course.cs211s._10_streams;

import java.time.LocalDate;

/**
 * Evictions POJO
 * 
 * @author bradleywillard
 *
 */
public class Eviction implements Comparable<Eviction>{
	private String evictionId;
	private String address;
	private String city;
	private String state;
	private String zip;
	private LocalDate fileDate;
	private boolean nonPayment;
	private boolean breach;
	private boolean nuisance;
	private boolean illegalUse;
	private boolean failureToSignRenewal;
	private boolean accessDenial;
	private boolean unapprovedSubtenant;
	private boolean ownerMoveIn;
	private boolean demolition;
	private boolean capitalImprovement;
	private boolean substantialRehab;
	private boolean ellisActWithdrawl;
	private boolean condoConversion;
	private boolean roommateSameUnit;
	private boolean otherCause;
	private boolean latePayments;
	private boolean leadRemediation;
	private boolean development;
	private boolean goodSamaritanEnds;
	private boolean constraints;
	private LocalDate constraintsDate;
	private String supervisorDistrict;
	private String neighborhood;
	private double latitude;
	private double longitude;
	private String location;
	
	
	public String getEvictionId() {
		return evictionId;
	}
	public void setEvictionId(String evictionId) {
		this.evictionId = evictionId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public LocalDate getFileDate() {
		return fileDate;
	}
	public void setFileDate(LocalDate fileDate) {
		this.fileDate = fileDate;
	}
	public boolean isNonPayment() {
		return nonPayment;
	}
	public void setNonPayment(boolean nonPayment) {
		this.nonPayment = nonPayment;
	}
	public boolean isBreach() {
		return breach;
	}
	public void setBreach(boolean breach) {
		this.breach = breach;
	}
	public boolean isNuisance() {
		return nuisance;
	}
	public void setNuisance(boolean nuisance) {
		this.nuisance = nuisance;
	}
	public boolean isIllegalUse() {
		return illegalUse;
	}
	public void setIllegalUse(boolean illegalUse) {
		this.illegalUse = illegalUse;
	}
	public boolean isFailureToSignRenewal() {
		return failureToSignRenewal;
	}
	public void setFailureToSignRenewal(boolean failureToSignRenewal) {
		this.failureToSignRenewal = failureToSignRenewal;
	}
	public boolean isAccessDenial() {
		return accessDenial;
	}
	public void setAccessDenial(boolean accessDenial) {
		this.accessDenial = accessDenial;
	}
	public boolean isUnapprovedSubtenant() {
		return unapprovedSubtenant;
	}
	public void setUnapprovedSubtenant(boolean unapprovedSubtenant) {
		this.unapprovedSubtenant = unapprovedSubtenant;
	}
	public boolean isOwnerMoveIn() {
		return ownerMoveIn;
	}
	public void setOwnerMoveIn(boolean ownerMoveIn) {
		this.ownerMoveIn = ownerMoveIn;
	}
	public boolean isDemolition() {
		return demolition;
	}
	public void setDemolition(boolean demolition) {
		this.demolition = demolition;
	}
	public boolean isCapitalImprovement() {
		return capitalImprovement;
	}
	public void setCapitalImprovement(boolean capitalImprovement) {
		this.capitalImprovement = capitalImprovement;
	}
	public boolean isSubstantialRehab() {
		return substantialRehab;
	}
	public void setSubstantialRehab(boolean substantialRehab) {
		this.substantialRehab = substantialRehab;
	}
	public boolean isEllisActWithdrawl() {
		return ellisActWithdrawl;
	}
	public void setEllisActWithdrawl(boolean ellisActWithdrawl) {
		this.ellisActWithdrawl = ellisActWithdrawl;
	}
	public boolean isCondoConversion() {
		return condoConversion;
	}
	public void setCondoConversion(boolean condoConversion) {
		this.condoConversion = condoConversion;
	}
	public boolean isRoommateSameUnit() {
		return roommateSameUnit;
	}
	public void setRoommateSameUnit(boolean roommateSameUnit) {
		this.roommateSameUnit = roommateSameUnit;
	}
	public boolean isOtherCause() {
		return otherCause;
	}
	public void setOtherCause(boolean otherCause) {
		this.otherCause = otherCause;
	}
	public boolean isLatePayments() {
		return latePayments;
	}
	public void setLatePayments(boolean latePayments) {
		this.latePayments = latePayments;
	}
	public boolean isLeadRemediation() {
		return leadRemediation;
	}
	public void setLeadRemediation(boolean leadRemediation) {
		this.leadRemediation = leadRemediation;
	}
	public boolean isDevelopment() {
		return development;
	}
	public void setDevelopment(boolean development) {
		this.development = development;
	}
	public boolean isGoodSamaritanEnds() {
		return goodSamaritanEnds;
	}
	public void setGoodSamaritanEnds(boolean goodSamaritanEnds) {
		this.goodSamaritanEnds = goodSamaritanEnds;
	}
	public boolean isConstraints() {
		return constraints;
	}
	public void setConstraints(boolean constraints) {
		this.constraints = constraints;
	}
	public LocalDate getConstraintsDate() {
		return constraintsDate;
	}
	public void setConstraintsDate(LocalDate constraintsDate) {
		this.constraintsDate = constraintsDate;
	}
	public String getSupervisorDistrict() {
		return supervisorDistrict;
	}
	public void setSupervisorDistrict(String supervisorDistrict) {
		this.supervisorDistrict = supervisorDistrict;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Eviction [");
		sb.append("evictionId=").append(evictionId)
			.append(", address=").append(address)
			.append(", city=").append(city) 
			.append(", state=").append(state)
			.append(", zip=").append(zip)
			.append(", fileDate=").append(fileDate);
	    //Only care about the reasons if they're true, otherwise clutter...
		if(nonPayment) sb.append(", nonPayment=").append(nonPayment);
		if(breach) sb.append(", breach=").append(breach);
		if(nuisance) sb.append(", nuisance=").append(nuisance);
		if(illegalUse) sb.append(", illegalUse=").append(illegalUse);
		if(failureToSignRenewal) sb.append(", failureToSignRenewal=").append(failureToSignRenewal);
		if(accessDenial) sb.append(", accessDenial=").append(accessDenial);
		if(unapprovedSubtenant) sb.append(", unapprovedSubtenant=").append(unapprovedSubtenant);
		if(ownerMoveIn) sb.append(", ownerMoveIn=").append(ownerMoveIn);
		if(demolition) sb.append(", demolition=").append(demolition);
		if(capitalImprovement) sb.append(", capitalImprovement=").append(capitalImprovement);
		if(substantialRehab) sb.append(", substantialRehab=").append(substantialRehab);
		if(ellisActWithdrawl) sb.append(", ellisActWithdrawl=").append(ellisActWithdrawl);
		if(condoConversion) sb.append(", condoConversion=").append(condoConversion);
		if(roommateSameUnit) sb.append(", roommateSameUnit=").append(roommateSameUnit);
		if(otherCause) sb.append(", otherCause=").append(otherCause);
		if(latePayments) sb.append(", latePayments=").append(latePayments);
		if(leadRemediation) sb.append(", leadRemediation=").append(leadRemediation);
		if(development) sb.append(", development=").append(development);
		if(goodSamaritanEnds) sb.append(", goodSamaritanEnds=").append(goodSamaritanEnds);
		if(constraints) sb.append(", constraints=").append(constraints).append(", constraintsDate=").append(constraintsDate);
		sb.append(", supervisorDistrict=").append(supervisorDistrict)
			.append(", neighborhood=").append(neighborhood)
			.append(", latitude=").append(latitude)
			.append(", longitude=").append(longitude)
			.append(", location=").append(location) 
			.append("]");
	
		return sb.toString();	
	}
	
	@Override
	public int compareTo(Eviction o) {
		LocalDate thisFD = this.getFileDate();
		LocalDate thatFD = o.getFileDate();
		if(thisFD != null && thatFD != null) {
			return thisFD.compareTo(thatFD);
		}
		return getEvictionId().compareTo(o.getEvictionId());
	}
}
