import java.util.HashMap;
public class Context
{
	public HashMap<String,Val> a;
	
	public Context()
	{
		a=new HashMap<String,Val>();
	}
	public Context(Context pa)
	{
		a=new HashMap<String,Val>(pa.a);
	}
	
	public Val put(String name, Val val)
	{
			return a.put(name,val);
	}
	
	public Val get(String name)
	{
		return a.get(name);
	}
	
}