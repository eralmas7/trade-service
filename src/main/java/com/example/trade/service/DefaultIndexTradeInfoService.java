package com.example.trade.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultIndexTradeInfoService implements IndexTradeInfoService {

	private static List<TradeInfo> tradeInfoList = new ArrayList<TradeInfo>();
	
	static{
		tradeInfoList.add(new TradeInfo("Index001", "trade001", "desk001", 1000000, getDateAfter(52*7), getDateAfter(0), 18273.93));
		tradeInfoList.add(new TradeInfo("Index001", "trade002", "desk001", 5000000, getDateAfter(52*3), getDateAfter(-1), 11273.93));
		tradeInfoList.add(new TradeInfo("Index002", "trade003", "desk001", 75000000, getDateAfter(52*1), getDateAfter(0), 18273.93));
	}

	private static Date getDateAfter(int weeks) {
		return Date.from(LocalDate.now().plusYears(weeks).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	@Override
	public List<TradeInfo> getAllTradeInfo() {
		return tradeInfoList;
	}

	@Override
	public List<TradeInfo> getTradeInfo(String indexId) {
		return tradeInfoList.stream().filter(tradeInfo -> tradeInfo.getIndexId().equals(indexId)).collect(Collectors.toList());
	}
}
