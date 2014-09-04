package codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SevensegmentDisplay {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader(new File(
				"/Users/liunan/Documents/codejam/A-small-practice.in.txt")));
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(
				"/Users/liunan/Documents/codejam/A-small-practice.out.txt")));
		int n = Integer.valueOf(in.readLine());
		for (int i = 0; i < n; i++) {
			List<Integer> list = new ArrayList<Integer>();
			String t[] = in.readLine().split(" ");
			for (int j = 1; j < t.length; j++) {
				list.add(Integer.valueOf(t[j]));
			}
			Integer array[] = new Integer[list.size()];
			list.toArray(array);
			out.write("Case #" + (i + 1) + ": " + calNextPresent(array));
			out.write("\n");
		}
		in.close();
		out.close();
		// System.out.println(calNextPresent());
	}

	public static String calNextPresent(Integer test[]) {
		int hash[] = { 126, 48, 109, 121, 51, 91, 95, 112, 127, 123 };
		boolean flag = true;
		String re = "";
		for (int i = 0; i < hash.length; i++) {
			int pos = i;
			int j = 0;
			int t = Integer.parseInt(test[j].toString(), 2);
			int error = 0;
			for (; j < test.length; ++j, t = j == test.length ? 0 : Integer
					.parseInt(test[j].toString(), 2), pos = (hash.length + pos - 1)
					% hash.length) {
				if ((t & (~hash[pos])) > 0 || (error & t) > 0) {
					break;
				}
				error = error | (t ^ hash[pos]);
			}
			if (j == test.length) {
				int k = 0;
				for (; k < test.length; k++) {
					if ((error & Integer.parseInt(test[k].toString(), 2)) != 0) {
						break;
					}
				}
				if (k == test.length) {
					if (flag) {
						re = Integer.toBinaryString(hash[pos] & (~error));
						while (re.length() != 7) {
							re = "0" + re;
						}
						flag = false;
					} else {
						re = "ERROR!";
					}
				}
			}
			// 如果满足条件，用亦或可以求取失效的灯，然后用需要显示的&（~失效）得到显示的数字，直接返回结果
		}
		// 返回false
		return re;
	}

	public static String calNextPresent() {
		int hash[] = { 126, 48, 109, 121, 51, 91, 95, 112, 127, 123 };
		Integer test[] = { 100000, 111, 11 };
		boolean flag = true;
		String re = "";
		for (int i = 0; i < hash.length; i++) {
			int pos = i;
			int j = 0;
			int t = Integer.parseInt(test[j].toString(), 2);
			int error = 0;
			for (; j < test.length; ++j, t = j == test.length ? 0 : Integer
					.parseInt(test[j].toString(), 2), pos = (hash.length + pos - 1)
					% hash.length) {
				if ((t & (~hash[pos])) > 0 || (error & t) > 0) {
					break;
				}
				error = error | (t ^ hash[pos]);
			}
			if (j == test.length) {
				int k = 0;
				for (; k < test.length; k++) {
					if ((error & Integer.parseInt(test[k].toString(), 2)) != 0) {
						break;
					}
				}
				if (k == test.length) {
					if (flag) {
						re = Integer.toBinaryString(hash[pos] & (~error));
						while (re.length() != 7) {
							re = "0" + re;
						}
						flag = false;
					} else {
						re = "ERROR!";
					}
				}
			}
			// 如果满足条件，用亦或可以求取失效的灯，然后用需要显示的&（~失效）得到显示的数字，直接返回结果
		}
		// 返回false
		return re;
	}

}
