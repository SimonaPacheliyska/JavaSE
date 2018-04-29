
public class PatternMatcher {
	public static boolean match(String s, String p) {
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i)==p.charAt(0) || p.charAt(0)=='*') {
				i++;
				for(int j =1;j<p.length();j++,i++) {
					if(p.charAt(j)=='?') {
						continue;
					}
					if(p.charAt(j)=='*') {
						continue;
					}
					if(s.charAt(i)!=p.charAt(j)) {
						return false;
					}
					
				}
				return true;
			}
		}
		return false;
}
public static void main(String[] args) {
	String a = new String("abba");
	String b = "aba";
	System.out.println(match(a, b));
}
}

