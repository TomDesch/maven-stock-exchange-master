package com.switchfully.maven.exchange.api;

import com.switchfully.maven.exchange.domain.Stock;
import com.switchfully.maven.exchange.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@ResponseBody
@RequestMapping("/stocks") // Search for myself what they do and mean :eyes:
public class StockExchangeController {

    private final StockService stockService;
    private final StockMapper stockMapper;

    public StockExchangeController(StockService stockService, StockMapper stockMapper) {
        this.stockService = stockService;
        this.stockMapper = stockMapper;
    }

    /**
     * For your information:
     * This method gets called from outside this application
     * (not really, but just imagine it will)
     */
    @GetMapping("/{stockId}") // Added this because I was told to
    public StockDto getStock(@PathVariable String stockId) {
        Stock foundStock = stockService.getStock(stockId);
        return stockMapper.mapToDto(foundStock);
    }

}
