package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;

// ランダム文字列サービスクラス
@Service
public class RandomStringService {
	private final static int GENERATE_NUM = 10; // 生成文字列の個数

	// ランダムな文字列のリストを生成する処理
	public List<String> generate(int charLength, boolean withNumber) {
		// 生成した文字列を保存するList
		List<String> list = new ArrayList<>();
		// 生成する個数分繰り返す
		for (int i = 0; i < GENERATE_NUM; i++) {
			RandomStringGenerator generator;
			if (withNumber) {
				// 数字を含むRandomStringGeneratorオブジェクトを生成
				// '0'から'z'の範囲で英数字のみを抽出
				generator = new RandomStringGenerator.Builder()
						.withinRange('0', 'z') // 文字コード 0～zの範囲指定
						.filteredBy(Character::isLetterOrDigit) // 英字または数字のみ通すフィルタ
						.get(); // RandomStringGeneratorオブジェクト取得
			} else {
				// 数字を含まないRandomStringGeneratorオブジェクトを生成
				// 'A'から'z'の範囲で英字のみを抽出
				generator = new RandomStringGenerator.Builder()
						.withinRange('A', 'z') // 文字コード A～zの範囲指定
						.filteredBy(Character::isLetter) // 英字のみ通すフィルタ
						.get(); // RandomStringGeneratorオブジェクト取得
			}
			// 生成した文字列をListに追加
			list.add(generator.generate(charLength));
		}
		return list;
	}
}
