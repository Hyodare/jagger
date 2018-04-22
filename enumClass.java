public class enumClass
{
	public static int getNb(Val a)
	{
		if (a.getClass()== (new Bool(true)).getClass())
			return 0;
		
		if (a.getClass()== (new Num(1)).getClass())
			return 1;
		
		if (a.getClass()== (new CharC("")).getClass())
			return 2;
		if (a.getClass()== (new ErrorType("")).getClass())
			return 3;
		return -1;
	}
}
