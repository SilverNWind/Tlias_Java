package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

    // 登録画面の表示
    @GetMapping("/")
    public String index() {
        return "itemForm";
    }

    // 登録情報確認画面の表示
    @PostMapping("/item")
    public String confirm( // リクエストパラメータの取得（初期値あり）
            @RequestParam(defaultValue = "未設定") String name, 
            @RequestParam(defaultValue = "100") int price,
            Model model) {

        model.addAttribute("name", name);
        model.addAttribute("price", price);

        return "itemConfirm";
    }

    // 隠しパラメータ送信用画面の表示
    @GetMapping("/item/hidden")
    public String itemFormHidden() {
        return "itemFormHidden";
    }

    // URLパスパラメータの取得
    @GetMapping("/item/{id}")
    public String show(@PathVariable int id, // パスパラメータで取得した商品ID
            Model model) {

        // 取得した商品IDに応じて表示する情報を変更する
        switch (id) {
        case 101:
            model.addAttribute("name", "ボールペン");
            model.addAttribute("price", 100);
            break;
        case 102:
            model.addAttribute("name", "消しゴム");
            model.addAttribute("price", 50);
            break;
        default:
            model.addAttribute("name", "未設定");
            model.addAttribute("price", 0);
            break;
        }

        return "itemConfirm";
    }

    // 商品詳細登録画面の表示
    @GetMapping("/item/detail")
    public String detail() {
        return "itemDetailForm";
    }

    // 商品詳細確認画面の表示
    @PostMapping("/item/detail")
    public String confirmDetail(
            @RequestParam(defaultValue = "未設定") String name,
            @RequestParam(defaultValue = "") Integer price, 
            @RequestParam(defaultValue = "") Integer categoryId,
            @RequestParam(defaultValue = "") String[] genreList, 
            @RequestParam(defaultValue = "") LocalDate releaseDate,
            Model model) {

        model.addAttribute("name", name);
        model.addAttribute("price", price);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("genreList", genreList);
        model.addAttribute("releaseDate", releaseDate);

        return "itemDetailConfirm";
    }

}
