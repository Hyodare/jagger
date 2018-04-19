

public class Num extends Val
{	
	public double a;
	public Num(double pA)
    {
        a=pA;
    }
	
	public AST accept(Visitor v)
    {
        return v.visitNum(this);
    }
	@Override public String toString()
	{	return String.valueOf(a);
	}
	
	@Override public Val add(Val val)
	{
		switch(enumClass.getNb(val))
		{
			case 1:return new Num(((Num)val).a+a);
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val sub(Val val)
	{
		switch(enumClass.getNb(val))
		{
			case 1:return new Num(a-((Num)val).a);
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val mul(Val val)
	{
		switch(enumClass.getNb(val))
		{
			case 1:return new Num(((Num)val).a*a);
			case 2:
			{
					String str="";
					String tmp=((CharC)val).a;
					for(int i=0;i<a;i++)
					{
						str=str+tmp;
					}
					return new CharC(str);
			}
			
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val div(Val val)
	{
		switch(enumClass.getNb(val))
		{
			 case 1:return new Num(a/((Num)val).a);
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val sup(Val val)
	{
		switch(enumClass.getNb(val))
		{
			case 1:return new Bool(((Num)val).a>a);
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val inf(Val val)
	{
		switch(enumClass.getNb(val))
		{
			case 1:return new Bool(((Num)val).a<a);
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val eqa(Val val)
	{
		switch(enumClass.getNb(val))
		{
			case 1:return new Bool(((Num)val).a==a);
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val neq(Val val)
	{
		switch(enumClass.getNb(val))
		{
			case 1:return new Bool(((Num)val).a!=a);
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val ieq(Val val)
	{
		switch(enumClass.getNb(val))
		{
			case 1:return new Bool(((Num)val).a<=a);
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val seq(Val val)
	{
		switch(enumClass.getNb(val))
		{
			case 1:return new Bool(((Num)val).a>=a);
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val inv()
	{
		return new Num(-a);
	}
}