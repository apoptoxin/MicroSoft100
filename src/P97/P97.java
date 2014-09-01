package P97;

public class P97 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse("ac"));
	}
	public static String reverse(String s){
		char c[] = s.toCharArray();
		for(int i=0;i<s.length()-i-1;i++){
			swap(c,i,s.length()-1-i);
		}
		return String.valueOf(c);
	}
	private static void swap(char[] c, int i, int j) {
		// TODO Auto-generated method stub
		c[i] = (char) (c[i] ^ c[j]);
		c[j] = (char) (c[i] ^ c[j]);
		c[i] = (char) (c[i] ^ c[j]);
	}
}
