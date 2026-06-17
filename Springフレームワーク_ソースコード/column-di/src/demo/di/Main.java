package demo.di;

public class Main {
	public static void main(String[] args) {
		// 乗り物の生成（車オブジェクト）
		Vehicle vehicle = new Car();
		// コントローラクラスを利用する場合に
		// Vehicleオブジェクトを外部から注入する
		GameController ctrl = new GameController(vehicle);
		ctrl.buttonA();
	}
}
