package com.aryan.hibernate.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stockId;
	private String StockName;
	private Double price;
	private String exchange;
	
	@Version
	private Integer count; 
	
	@CreationTimestamp
	private LocalDateTime openingTime; 
	
	@UpdateTimestamp
	private LocalDateTime updatedTime;

	public Stock() {
		super();
	}

	public Stock(String stockName, Double price, String exchange) {
		super();
		StockName = stockName;
		this.price = price;
		this.exchange = exchange;
	}



	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return StockName;
	}

	public void setStockName(String stockName) {
		StockName = stockName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getExchange() {
		return exchange;
	} 

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public LocalDateTime getOpeningTime() {
		return openingTime; 
	}

	public void setOpeningTime(LocalDateTime openingTime) {
		this.openingTime = openingTime;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", StockName=" + StockName + ", price=" + price + ", exchange=" + exchange
				+ ", count=" + count + ", openingTime=" + openingTime + ", updatedTime=" + updatedTime + "]";
	}
	
	
}

//OUTPUT

/*
 * Hibernate: 
    create table Stock (
        stockId integer not null auto_increment,
        StockName varchar(255),
        count integer not null,
        exchange varchar(255),
        openingTime datetime(6) not null,
        price float(53),
        updatedTime datetime(6) not null,
        primary key (stockId)
    ) engine=InnoDB
Stock [stockId=null, StockName=AI, price=1500.0, exchange=NSE, count=null, openingTime=null, updatedTime=null]
Hibernate: 
    insert 
    into
        Stock
        (StockName, count, exchange, openingTime, price, updatedTime) 
    values
        (?, ?, ?, ?, ?, ?)
Stock [stockId=1, StockName=AI, price=1500.0, exchange=NSE, count=0, openingTime=2026-09-23T03:49:16.363377, updatedTime=2026-09-23T03:49:16.363423]
Hibernate: 
    update
        Stock 
    set
        StockName=?,
        count=?,
        exchange=?,
        price=?,
        updatedTime=? 
    where
        stockId=? 
        and count=?
Stock [stockId=1, StockName=AI, price=1800.0, exchange=BSE, count=1, openingTime=2026-09-23T03:49:16.363377, updatedTime=2026-09-23T03:49:16.394079]
*/
