package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.techm.adms.dt.entity.NeedsOrInsight;

public interface IDTNeedsOrInsightsDAO extends IBaseDAO<NeedsOrInsight, Serializable>{
	public List<NeedsOrInsight>getNeedList(int projectID);
	public List<NeedsOrInsight> getInsightList(int projectID);	
	public void deActivate(int noiId);
	public List<NeedsOrInsight> getInsightListByDeleteFlag(int projectID);
	public List<NeedsOrInsight> getNeedListByDeleteFlag(int projectID);
	public void activate(int noiId);
}
