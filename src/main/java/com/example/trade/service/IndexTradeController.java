package com.example.trade.service;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexTradeController {

	private IndexTradeInfoService indexTradeInfoService;

	public IndexTradeController(IndexTradeInfoService indexTradeInfoService) {
		this.indexTradeInfoService = indexTradeInfoService;
	}
	@RequestMapping("/")
	public List<TradeInfo> getAllTradeInfo() {
		return indexTradeInfoService.getAllTradeInfo();
	}

	@RequestMapping("/trade/{indexId}")
	public List<TradeInfo> getTradeInfo(@PathVariable String indexId) {
		return indexTradeInfoService.getTradeInfo(indexId);
	}

}
