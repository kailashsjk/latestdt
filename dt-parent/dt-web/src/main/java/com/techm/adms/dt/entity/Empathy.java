package com.techm.adms.dt.entity;

import java.util.ArrayList;
import java.util.List;

public class Empathy {
	
	private List<Observation> sayList;
	private List<Observation> doList;
	private List<Observation> feelList;
	private List<Observation> thinkList;
	
	public List<Observation> getSayList() {
		return sayList;
	}
	public void setSayList(List<Observation> sayList) {
		this.sayList = sayList;
	}
	public List<Observation> getDoList() {
		return doList;
	}
	public void setDoList(List<Observation> doList) {
		this.doList = doList;
	}
	public List<Observation> getFeelList() {
		return feelList;
	}
	public void setFeelList(List<Observation> feelList) {
		this.feelList = feelList;
	}
	public List<Observation> getThinkList() {
		return thinkList;
	}
	public void setThinkList(List<Observation> thinkList) {
		this.thinkList = thinkList;
	}
	
	public void addSayObservation(Observation obsrv) {
		if(this.sayList == null){
		this.sayList = new ArrayList<Observation>();
		}
		this.sayList.add(obsrv);
	}
	
	public void addDoObservation(Observation obsrv) {
		if(this.doList == null){
		this.doList = new ArrayList<Observation>();
		}
		this.doList.add(obsrv);
	}
	
	public void addFeelObservation(Observation obsrv) {
		if(this.feelList == null){
		this.feelList = new ArrayList<Observation>();
		}
		this.feelList.add(obsrv);
	}
	
	public void addThinkObservation(Observation obsrv) {
		if(this.thinkList == null){
		this.thinkList = new ArrayList<Observation>();
		}
		this.thinkList.add(obsrv);
	}
	
	@Override
	public String toString() {
		return "Empathy [sayList=" + sayList + ", doList=" + doList
				+ ", feelList=" + feelList + ", thinkList=" + thinkList + "]";
	}


}
