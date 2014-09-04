package P98;

import java.util.Date;
import java.util.Random;

public class P98_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[54];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		a = shuffle(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static int[] shuffle(int[] a) {
		for (int i = 0; i < a.length; i++) {
			Random r = new Random(new Date().getTime());
			int ran = r.nextInt(a.length - i) + i;
			swap(a, i, ran);
		}
		return a;
	}

	private static void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		if (i == j) {
			return;
		}
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
	}
}
