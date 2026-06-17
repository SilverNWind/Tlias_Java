package com.example.demo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {

	// 日付の文字列フォーマット
	private final static DateTimeFormatter FMT = 
		DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	// インスタンスフィールド
	private LocalDateTime createdAt; // 投稿日時
	private String title; // タイトル
	private String content; // 内容

	// コンストラクタ
	public Post(String title, String content) {
		this.title = title;
		this.content = content;
		this.createdAt = LocalDateTime.now(); // 現在日時
	}

	// ゲッター
	public String getCreatedAt() {
		return createdAt.format(FMT); // LocalDateTime→String変換
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content.replaceAll("\n", "<br>"); // 改行文字列→<br>置換
	}
}