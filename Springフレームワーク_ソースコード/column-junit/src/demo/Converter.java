package demo;

public class Converter {
	// 配列をカンマ区切りの文字列に変換
	public String arrayToCsv(String[] ary) {
		String csv = "";
		for (String s : ary) {
			csv += s;
			csv += ",";
		}
		return csv;

		// 修正
		//return String.join(",", ary);
	}
}
