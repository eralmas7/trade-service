package com.example.trade.service;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.trade.service.TradeInfo;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class TradeServicesApplicationTests {

	@Autowired
	private TestRestTemplate rest;

	@Test
	public void testGetAllParticipantsEndpoint() {
		List<TradeInfo> tradeInfoList = Arrays.asList(rest.getForObject("/", TradeInfo[].class));
		assertEquals(new DefaultIndexTradeInfoService().getAllTradeInfo(), tradeInfoList);
	}

	@Test
	public void testGetAllParticipantsByRaceEndpoint() {
		List<TradeInfo> tradeInfoList = Arrays.asList(rest.getForObject("/trade/index001", TradeInfo[].class));
		assertEquals(new DefaultIndexTradeInfoService().getTradeInfo("index001"), tradeInfoList);
		tradeInfoList = Arrays.asList(rest.getForObject("/trade/index002", TradeInfo[].class));
		assertEquals(new DefaultIndexTradeInfoService().getTradeInfo("index002"), tradeInfoList);
	}

}
