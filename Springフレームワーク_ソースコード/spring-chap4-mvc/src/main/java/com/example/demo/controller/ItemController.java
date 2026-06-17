package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Item;

@Controller
public class ItemController {
	// 初期画面表示
	@GetMapping("/item")
	public String index() {
		return "item";
	}

	// 登録ボタンクリック時
	@PostMapping("/item")
	public String add(
			@RequestParam String name,
			@RequestParam Integer price,
			Model model) {

		// Itemクラスのオブジェクト（モデル）を生成
		Item item = new Item(name, price);
		// Thymeleafに渡すデータ（モデル）を追加
		model.addAttribute("item", item);
		// item.htmlを出力
		return "item";
	}
}
