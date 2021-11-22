package com.switchfully.maven.exchange.cli;

import com.switchfully.maven.exchange.api.StockDto;
import com.switchfully.maven.exchange.api.StockExchangeController;
import com.switchfully.maven.exchange.api.StockMapper;
import com.switchfully.maven.exchange.service.StockService;

public class MyCLI {

    public static void main(String[] args) {
        if(args.length == 1) {
            StockExchangeController controller = new StockExchangeController(new StockService(), new StockMapper());
            StockDto stockDto = controller.getStock(args[0]);
            printStockDto(stockDto);
        } else {
            System.out.println("No stockId provided as argument. Shutting down...");
        }
    }

    private static void printStockDto(StockDto stockDto) {
        System.out.printf("Stock information for stockId: %s%n", stockDto.getId());
        System.out.printf("\tName: %s%n", stockDto.getName());
        System.out.printf("\tPrice: %s %s%n", stockDto.getPrice().intValue(), stockDto.getCurrency());
    }
}
