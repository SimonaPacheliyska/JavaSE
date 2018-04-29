
public class StringAnalizer {
	public static void main(String[] args)
	{
		String test= new String("abccddddeffff");
		System.out.println(getPlateauLength(test));
	}
	
	public static int getPlateauLength(String s) {
		int maxL=0;
		int current = 1;
		for(int i=0;i<s.length()-1;i++)
		{
			for(int j=i+1;j<s.length() && areEqual(s.charAt(i), s.charAt(j));j++)
			{
				current++;
			}
			if(current>maxL)
			{
				maxL=current;
			}
			current=1;
		}
		return maxL;
	}
	
	private static boolean areEqual(char fst, char snd)
	{
		return fst==snd;
	}

}
