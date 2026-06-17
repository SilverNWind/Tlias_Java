package demo;

public class Main {
	public static void main(String[] args) {
		String[] ar = { "abc", "def", "ghi" };
		Converter c = new Converter();
		System.out.println(c.arrayToCsv(ar));
	}
}
