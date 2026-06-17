package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // コントローラを表すアノテーション
public class HelloController {

    @GetMapping({ "/", "/test" }) // URLパターンを追加してみる
    public String index() {
        // hello.htmlを出力する
        return "hello";
    }

    // 「http://localhost:8080/hello?msg=AAA」のURLパターンを処理する
    @GetMapping("/hello")
    public String hello(@RequestParam String msg, Model model) {
        // 画面に情報を渡す
        model.addAttribute("memo", msg);
        // hello.htmlの出力
        return "hello";
    }

    // POSTリクエスト
    @PostMapping("/hello")
    public String helloByPost(@RequestParam String msg, Model model) {
        // 画面に情報を渡す
        model.addAttribute("memo", msg);
        // helloPost.htmlの出力
        return "helloPost";
    }
}
