package com.example.trade.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.trade.service.DefaultIndexTradeInfoService;
import com.example.trade.service.TradeInfo;

public class DefaultParticipantsServiceTest {

	private List<TradeInfo> tradeInfoList;

	@BeforeEach
	public void setup() {
		this.tradeInfoList = new ArrayList<>();
		tradeInfoList.add(new TradeInfo("Index001", "trade001", "desk001", 1000000, getDateAfter(52*7), getDateAfter(0), 18273.93));
		tradeInfoList.add(new TradeInfo("Index001", "trade002", "desk001", 5000000, getDateAfter(52*3), getDateAfter(-1), 11273.93));
		tradeInfoList.add(new TradeInfo("Index002", "trade003", "desk001", 75000000, getDateAfter(52*1), getDateAfter(0), 18273.93));
	}

	private static Date getDateAfter(int weeks) {
		return Date.from(LocalDate.now().plusYears(weeks).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	@AfterEach
	public void tearDown() {
		this.tradeInfoList = null;
	}

	@Test
	public void getAllParticipantsTest() {
		IndexTradeInfoService participantsService = new DefaultIndexTradeInfoService();
		assertEquals(tradeInfoList, participantsService.getAllTradeInfo());
	}

	@Test
	public void getAllParticipantsWithRaceTest() {
		DefaultIndexTradeInfoService participantsService = new DefaultIndexTradeInfoService();
		assertTrue(participantsService.getTradeInfo("Index003").isEmpty());
		assertEquals(Arrays.asList(this.tradeInfoList.get(2)), participantsService.getTradeInfo("Index002"));
	}
}
