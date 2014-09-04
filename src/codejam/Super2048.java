package codejam;

public class Super2048 {
	public static final int RIGHT = 0;
	public static final int UP = 2;
	public static final int LEFT = 1;
	public static final int DOWN = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { { 2, 2, 2, 2 }, { 2, 0, 0, 2 }, { 0, 4, 2, 2 },
				{ 4, 2, 4, 2 } };
		getResult(a, 4, UP);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public static void getResult(int[][] a, int n, int direction) {
		switch (direction) {
		case UP:
			getUp(a, n);
			break;
		case DOWN:
			getDown(a, n);
			break;
		case RIGHT:
			getRight(a, n);
			break;
		case LEFT:
			getLeft(a, n);
			break;
		default:
			break;
		}
	}

	private static void getLeft(int[][] a, int n) {
		// TODO Auto-generated method stub

	}

	private static void getRight(int[][] a, int n) {
		// TODO Auto-generated method stub

	}

	private static void getDown(int[][] a, int n) {
		// TODO Auto-generated method stub

	}

	private static void getUp(int[][] a, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {// 对每一列分别做
			int p = 0;
			int q = 0;
			for (q = 1; q < n;) {
				if (a[q][i] == 0) {
					q++;
				} else if (a[q][i] == a[p][i]) {
					a[p++][i] *= 2;
					a[q++][i] = 0;
				} else if (a[p][i] == 0) {
					while (q < n && a[q][i] == 0) {
						q++;
					}
					if (q != n) {
						a[p][i] = a[q++][i];
					}
				} else if (a[q][i] != a[p][i]) {
					for (; p < q && a[p][i] != 0; p++)
						;
					if (p < q) {
						a[p++][i] = a[q][i];
						a[q++][i] = 0;
					} else {
						q++;
					}
				}
			}
			for (; p < n; p++) {
				a[p][i] = 0;
			}
		}
	}
}
