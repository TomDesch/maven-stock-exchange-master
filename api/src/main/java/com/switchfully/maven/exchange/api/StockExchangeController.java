package com.switchfully.maven.exchange.api;

import com.switchfully.maven.exchange.domain.Stock;
import com.switchfully.maven.exchange.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@RestController // Combines response body and controller
@RequestMapping("/stocks") // Search for myself what they do and mean :eyes:
public class StockExchangeController {

    private final StockService stockService;
    private final StockMapper stockMapper;

    public StockExchangeController(StockService stockService, StockMapper stockMapper) {
        this.stockService = stockService;
        this.stockMapper = stockMapper;
    }

    @GetMapping("/{stockId}") // Added this because I was told to
    public StockDto getStock(@PathVariable(name = "stockId") String stockId) {
        Stock foundStock = stockService.getStock(stockId);
        return stockMapper.mapToDto(foundStock);
    }
}
