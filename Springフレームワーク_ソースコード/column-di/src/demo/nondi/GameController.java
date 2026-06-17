package demo.nondi;

// ゲームコーンとローラクラス
public class GameController {

	// 乗り物のオブジェクト
	private Vehicle vehicle;

	// コンストラクタ
	public GameController() {
		// // 車オブジェクトの生成（Carに依存）
		this.vehicle = new Car();
	}

	// Aボタン
	public void buttonA() {
		vehicle.start();
	}
}
