package com.example.demo.model;

public class Item {
	// フィールド
	private String name; // 商品名
	private Integer price; // 価格

	// コンストラクタ
	public Item(String name, Integer price) {
		this.name = name;
		this.price = price;
	}

	// ゲッター
	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}
}
