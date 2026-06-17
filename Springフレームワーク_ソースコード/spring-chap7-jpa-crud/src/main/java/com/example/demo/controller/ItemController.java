package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemController {

    private final ItemRepository itemRepository; // itemsテーブル操作用
    private final CategoryRepository categoryRepository;
    
    public ItemController(
            ItemRepository itemRepository,
            CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

	// 商品一覧表示
	@GetMapping("/items")
	public String index(
			@RequestParam(defaultValue = "") Integer categoryId,
			Model model) {

		// categoryテーブルから全カテゴリー一覧を取得
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);

		// 商品一覧情報の取得
		List<Item> itemList = null;
		if (categoryId == null) {
			itemList = itemRepository.findAll();
		} else {
			// itemsテーブルをカテゴリーIDを指定して一覧を取得
			itemList = itemRepository.findByCategoryId(categoryId);
		}
		model.addAttribute("items", itemList);

		return "items";
	}

	// 新規登録画面の表示
	@GetMapping("/items/add")
	public String create() {
		return "addItem";
	}

	// 新規登録処理
	@PostMapping("/items/add")
	public String store(
			@RequestParam(defaultValue = "") Integer categoryId,
			@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") Integer price) {

		// Itemオブジェクトの生成
		Item item = new Item(categoryId, name, price);
		// itemsテーブルへの反映（INSERT）
		itemRepository.save(item);
		// 「/items」にGETでリクエストし直す（リダイレクト）
		return "redirect:/items";
	}

	// 更新画面表示
	@GetMapping("/items/{id}/edit")
	public String edit(@PathVariable Integer id, Model model) {

		// itemsテーブルをID（主キー）で検索
		Item item = itemRepository.findById(id).get();
		model.addAttribute("item", item);
		return "editItem";
	}

	// 更新処理
	@PostMapping("/items/{id}/edit")
	public String update(
			@PathVariable Integer id,
			@RequestParam(defaultValue = "") Integer categoryId,
			@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") Integer price) {

		// Itemオブジェクトの生成
		Item item = itemRepository.findById(id).get();
        item.setCategoryId(categoryId);
        item.setName(name);
        item.setPrice(price);
		
		// itemsテーブルへの反映（UPDATE）
		itemRepository.save(item);
		// 「/items」にGETでリクエストし直す（リダイレクト）
		return "redirect:/items";
	}

	// 削除処理
	@PostMapping("/items/{id}/delete")
	public String delete(@PathVariable Integer id) {

		// itemsテーブルから削除（DELETE）
		itemRepository.deleteById(id);
		// 「/items」にGETでリクエストし直す（リダイレクト）
		return "redirect:/items";
	}
}
