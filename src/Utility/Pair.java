package Utility;

public class Pair<x, y> {
	public x first;
	public y second;

	public Pair() {
	}

	public Pair(x f, y s) {
		this.first = f;
		this.second = s;
	}

	public static <x, y> Pair<x, y> make_pair(x f, y s) {
		return new Pair<>(f, s);
	}

}
