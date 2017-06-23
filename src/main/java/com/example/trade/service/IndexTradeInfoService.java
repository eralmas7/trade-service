package com.example.trade.service;

import java.util.List;

public interface IndexTradeInfoService {

	public List<TradeInfo> getAllTradeInfo();

	public List<TradeInfo> getTradeInfo(String indexId);
}