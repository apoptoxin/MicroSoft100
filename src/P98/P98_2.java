package P98;

import java.io.ObjectInputStream.GetField;

public class P98_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMaxPalindrome("abcba"));
	}

	public static String getMaxPalindrome(String s) {
		char c[] = encode(s);
		int id = 0;
		int mx = 0;
		int p[] = new int[c.length];
		for (int i = 1; i < c.length; i++) {
			p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
			for (; i + p[i] < c.length && i - p[i] >= 0
					&& c[i + p[i]] == c[i - p[i]]; p[i]++)
				;
			if (p[i] + i > mx) {
				mx = p[i] + i;
				id = i;
			}
		}
		id = 0;
		mx = 0;
		for (int i = 0; i < p.length; i++) {
			if (p[i] > mx) {
				id = i;
				mx = p[i];
			}
		}
		return decode(c, id, mx);
	}

	private static String decode(char[] c, int id, int mx) {
		// TODO Auto-generated method stub
		StringBuffer s = new StringBuffer();
		for(int i=id+1-mx;i<id+mx;i++){
			if(c[i]!='#'){
				s.append(c[i]);
			}
		}
		return s.toString();
	}

	private static char[] encode(String s) {
		// TODO Auto-generated method stub
		char c[] = new char[s.length() * 2 + 1];
		c[0] = '#';
		for (int i = 1; i < c.length; i += 2) {
			c[i] = s.charAt(i / 2);
			c[i + 1] = '#';
		}
		return c;
	}
}
