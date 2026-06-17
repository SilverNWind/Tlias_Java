package demo.di;

public class GameController {
	// 乗り物のオブジェクト
	private Vehicle vehicle;

	// コンストラクタ
	// Vehicleオブジェクトを引数で取得できるようにする
	public GameController(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	// Aボタン
	public void buttonA() {
		vehicle.start();
	}
}
