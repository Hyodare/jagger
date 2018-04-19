
public class CharC extends Val
{
	public String a;
	public CharC(String pA)
    {
		//a=pA;
		if(pA.length()>0 && pA.substring(0,1).equals("'"))
		{
		a=pA.substring(1,pA.length()-1);
		
		}
		else
		{
			a=pA;
		}
		
    }
	
	public AST accept(Visitor v)
    {
        return v.visitCharC(this);
    }
	
	@Override public String toString()
	{	return ""+a+"";
	}
	
	
	@Override public Val add(Val val)
	{
		switch(enumClass.getNb(val))
		{
			case 1:return new CharC(a+String.valueOf(((Num)val).a));
			case 2:return new CharC(a+((CharC)val).a);
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val sub(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case (new Num()).getClass():return new Num(((Num)val).a-a);
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val mul(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case (new Num()).getClass():return new Num(((Num)val).a+a);
			//case 2:
			
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val div(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case (new Num()).getClass():return new Num(val.a/a);
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val sup(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case (new Num()).getClass():return new Bool(val.a>a);
			case 2:return new Bool(a.compareTo(((CharC)val).a)>0);
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val inf(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case (new Num()).getClass():return new Bool(val.a<a);
			case 2:return new Bool(a.compareTo(((CharC)val).a)<0);
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val eqa(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case (new Num()).getClass():return new Bool(val.a==a);
			case 2:return new Bool(a.equals(((CharC)val).a)==true);
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val neq(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case (new Num()).getClass():return new Bool(val.a!=a);
			case 2:return new Bool(!(a.equals(((CharC)val).a)));
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val ieq(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case (new Num()).getClass():return new Bool(val.a<=a);
			case 2:return new Bool(a.compareTo(((CharC)val).a)<=0);
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val seq(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case (new Num()).getClass():return new Bool(val.a<=a);
			case 2:return new Bool(a.compareTo(((CharC)val).a)>=0);
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val inv()
	{
		return new ErrorType("cannot invert a String");
	}
}