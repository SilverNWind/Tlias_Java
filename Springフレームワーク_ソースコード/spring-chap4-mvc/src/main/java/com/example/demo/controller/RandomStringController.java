package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.RandomStringService;

@Controller
public class RandomStringController {

	private final RandomStringService service; // ランダム文字列生成サービス
	
	// コンストラクタインジェクション
	public RandomStringController(RandomStringService service) {
	    this.service = service;
	}

	// 初期表示
	@GetMapping("/random")
	public String index() {
		return "random";
	}

	// 作成するボタンをクリックしたとき
	@PostMapping("/random")
	public String generate(
			@RequestParam int charLength,
			@RequestParam(defaultValue = "false") boolean withNumber,
			Model model) {

		// ランダム文字列のListを生成
		List<String> list = service.generate(charLength, withNumber);

		model.addAttribute("randList", list);

		return "random";
	}
}
