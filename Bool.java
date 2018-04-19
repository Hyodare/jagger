
public class Bool extends Val
{
	public boolean a;
	public Bool(boolean pA)
    {
        a=pA;
    }
	
	public AST accept(Visitor v)
    {
        return v.visitBool(this);
    }
	
	@Override public String toString()
	{	return String.valueOf(a);
	}
	
	@Override public Val add(Val val)
	{
		switch(enumClass.getNb(val))
		{
			case 0:return new Bool(((Bool)val).a ||  a);
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val sub(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val mul(Val val)
	{
		switch(enumClass.getNb(val))
		{
			case 0:return new Bool(((Bool)val).a &&  a);
					
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val div(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val sup(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val inf(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val eqa(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val neq(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val ieq(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val seq(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			default: return new ErrorType("erreur de typage");
		}
	}
	@Override public Val inv()
	{
		return new Bool(!a);
	}
}