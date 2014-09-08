package codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Super2048 {
	public static final int RIGHT = 0;
	public static final int UP = 2;
	public static final int LEFT = 1;
	public static final int DOWN = 3;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader(new File(
				"/Users/liunan/Documents/codejam/B-large-practice.in.txt")));
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(
				"/Users/liunan/Documents/codejam/B-large-practice.out.txt")));
		int count = Integer.valueOf(in.readLine());
		for (int i = 0; i < count; i++) {
			String t[] = in.readLine().split(" ");
			String direction = t[1].toUpperCase();
			int n = Integer.valueOf(t[0]);
			int a[][] = new int[n][n];
			for (int p = 0; p < n; p++) {
				String m[] = in.readLine().split(" ");
				for (int q = 0; q < n; q++) {
					a[p][q] = Integer.valueOf(m[q]);
				}
			}
			getResult(a, n, direction);
			out.write("Case #" + (i + 1) + ":\n");
			for (int p = 0; p < n; p++) {
				for (int q = 0; q < n; q++) {
//					if (q == 0) {
//						out.write(a[p][q]);
//					} else {
//						out.write(" " + a[p][q]);
//					}
					out.write(a[p][q]+" ");
				}
				out.write("\n");
			}
		}
		in.close();
		out.close();
	}

	public static void getResult(int[][] a, int n, String direction) {
		if (direction.equals("UP")) {
			getUp(a, n);
		} else if (direction.equals("DOWN")) {
			getDown(a, n);
		} else if (direction.equals("LEFT")) {
			getLeft(a, n);
		} else if (direction.equals("RIGHT")) {
			getRight(a, n);
		}
	}

	private static void getLeft(int[][] a, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			int p = 0;
			int q = 1;
			for (; q < n;) {
				if (a[i][p] == 0) {
					a[i][p] = a[i][q];
					a[i][q++] = 0;
					continue;
				}
				if (a[i][q] == 0) {
					q++;
					continue;
				}
				if (a[i][p] == a[i][q] && a[i][q] != 0) {
					a[i][p++] *= 2;
					a[i][q++] = 0;
				} else if (a[i][p] != a[i][q] && a[i][q] != 0 && a[i][p] != 0) {
					p++;
					if (p == q) {
						q++;
					}
				}
			}
		}
	}

	private static void getRight(int[][] a, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			int p = n - 1;
			int q = n - 2;
			for (; q >= 0;) {
				if (a[i][p] == 0) {
					a[i][p] = a[i][q];
					a[i][q--] = 0;
					continue;
				}
				if (a[i][q] == 0) {
					q--;
					continue;
				}
				if (a[i][p] == a[i][q] && a[i][q] != 0) {
					a[i][p--] *= 2;
					a[i][q--] = 0;
				} else if (a[i][p] != a[i][q] && a[i][p] != 0 && a[i][q] != 0) {
					p--;
					if (p == q) {
						q--;
					}
				}
			}
		}
	}

	private static void getDown(int[][] a, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			int p = n - 1;
			int q = n - 2;
			for (; q >= 0;) {
				if (a[p][i] == 0) {
					a[p][i] = a[q][i];
					a[q--][i] = 0;
					continue;
				}
				if (a[q][i] == 0) {
					q--;
					continue;
				}
				if (a[p][i] == a[q][i] && a[q][i] != 0) {
					a[p--][i] *= 2;
					a[q--][i] = 0;
				} else if (a[p][i] != a[q][i] && a[p][i] != 0 && a[q][i] != 0) {
					p--;
					if (p == q) {
						q--;
					}
				}
			}
		}
	}

	private static void getUp(int[][] a, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			int p = 0;
			int q = 1;
			for (; q < n;) {
				if (a[p][i] == 0) {
					a[p][i] = a[q][i];
					a[q++][i] = 0;
					continue;
				}
				if (a[q][i] == 0) {
					q++;
					continue;
				}
				if (a[p][i] == a[q][i] && a[q][i] != 0) {
					a[p++][i] *= 2;
					a[q++][i] = 0;
				} else if (a[p][i] != a[q][i] && a[p][i] != 0 && a[q][i] != 0) {
					p++;
					if (p == q) {
						q++;
					}
				}
			}
		}
	}
}
