package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemController {

    private final ItemRepository itemRepository; // itemsテーブル操作用
    
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // 商品一覧表示
    @GetMapping("/")
    public String index(Model model) {
        // itemsテーブルから全商品の一覧を取得
        List<Item> itemList = itemRepository.findAll();
        // Thymeleafにデータを渡す
        model.addAttribute("items", itemList);
        // items.htmlを出力
        return "items";
    }
}
