package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

@Controller
public class AccountController {

	private final HttpSession session;
	private final Account account;
	
	public AccountController(HttpSession session, Account account) {
	    this.session = session;
	    this.account = account;
	}

	// 初期表示
	@GetMapping("/")
	public String index() {
		session.invalidate();
		return "login";
	}

	// ログイン処理
	@PostMapping("/login")
	public String login(
			@RequestParam String name,
			Model model) {

		// パラメータが空文字の場合はエラーメッセージを出力
		if (name == null || name.length() == 0) {
			model.addAttribute("message", "名前を入力してください");
			return "login";
		}
		// セッションスコープのAccountオブジェクトに名前をセット
		account.setName(name);

		return "input";
	}
}
