package Utility;

public class Pair<x, y> {
	public x first;
	public y second;

	public Pair(x first, y second) {
		this.first = first;
		this.second = second;
	}

	public static <x, y> Pair<x, y> make_pair(x first, y second) {
		return new Pair<>(first, second);
	}

}
