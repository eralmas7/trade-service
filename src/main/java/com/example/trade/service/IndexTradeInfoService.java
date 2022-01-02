package com.example.trade.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public interface IndexTradeInfoService {

	public List<TradeInfo> getAllTradeInfo();

	public List<TradeInfo> getTradeInfo(String indexId);
}

class TradeInfo {
	private String indexId;
	private String tradeId;
	private String deskId;
	private double notional;
	private Date expiry;
	private Date tradeDate;
	private double level;
	
	public TradeInfo(){}

	public TradeInfo(String indexId, String tradeId, String deskId, double notional, Date expiry, Date tradeDate,
			double level) {
		this.indexId = indexId;
		this.tradeId = tradeId;
		this.deskId = deskId;
		this.notional = notional;
		this.expiry = expiry;
		this.tradeDate = tradeDate;
		this.level = level;
	}

	public String getIndexId() {
		return indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getDeskId() {
		return deskId;
	}

	public void setDeskId(String deskId) {
		this.deskId = deskId;
	}

	public double getNotional() {
		return notional;
	}

	public void setNotional(double notional) {
		this.notional = notional;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public double getLevel() {
		return level;
	}

	public void setLevel(double level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
		        .append(indexId)
		        .append(tradeId)
		        .toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TradeInfo){
	        final TradeInfo other = (TradeInfo) obj;
	        return new EqualsBuilder()
	            .append(indexId, other.indexId)
	            .append(tradeId, other.tradeId)
	            .isEquals();
	    } else{
	        return false;
	    }
	}
}
