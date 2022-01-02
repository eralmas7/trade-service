package com.example.trade.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexTradeController {

	private IndexTradeInfoService indexTradeInfoService;

	public IndexTradeController(IndexTradeInfoService indexTradeInfoService) {
		this.indexTradeInfoService = indexTradeInfoService;
	}
	@GetMapping("/")
	public List<TradeInfo> getAllTradeInfo() {
		return indexTradeInfoService.getAllTradeInfo();
	}

	@GetMapping("/trade/{indexId}")
	public List<TradeInfo> getTradeInfo(@PathVariable String indexId) {
		return indexTradeInfoService.getTradeInfo(indexId);
	}

}
