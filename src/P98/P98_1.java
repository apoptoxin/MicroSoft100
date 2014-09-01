package P98;

public class P98_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print("abc");
	}
	public static void print(String s){
		print(new StringBuffer(s),0);
	}
	private static void print(StringBuffer s,int pos) {
		// TODO Auto-generated method stub
		if(pos==s.length()-1){
			System.out.println(s.toString());
		}
		for(int i=pos;i<s.length();i++){
			swap(s,pos,i);
			print(s, pos+1);
			swap(s,pos,i);
		}
	}
	private static void swap(StringBuffer s, int pos, int i) {
		// TODO Auto-generated method stub
		char t = s.charAt(pos);
		s.setCharAt(pos, s.charAt(i));
		s.setCharAt(i, t);
	}
}
