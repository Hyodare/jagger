
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
			case 3:return val;
			//case 2:
			default: return new ErrorType("operation + impossible between type :"+ enumClass.getNb(this)+ " and type : "+enumClass.getNb(val));
		}
	}
	@Override public Val sub(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			case 3:return val;
			default: return new ErrorType("operation - impossible between type :"+ enumClass.getNb(this)+ " and type : "+enumClass.getNb(val));
		}
	}
	@Override public Val mul(Val val)
	{
		switch(enumClass.getNb(val))
		{
			case 0:return new Bool(((Bool)val).a &&  a);
			case 3:return val;		
			default: return new ErrorType("operation * impossible between type :"+ enumClass.getNb(this)+ " and type : "+enumClass.getNb(val));
		}
	}
	@Override public Val div(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			case 3:return val;
			default: return new ErrorType("operation / impossible between type :"+ enumClass.getNb(this)+ " and type : "+enumClass.getNb(val));
		}
	}
	@Override public Val sup(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			case 3:return val;
			default: return new ErrorType("operation > impossible between type :"+ enumClass.getNb(this)+ " and type : "+enumClass.getNb(val));
		}
	}
	@Override public Val inf(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			case 3:return val;
			default: return new ErrorType("operation < impossible between type :"+ enumClass.getNb(this)+ " and type : "+enumClass.getNb(val));
		}
	}
	@Override public Val eqa(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			case 3:return val;
			default: return new ErrorType("operation == impossible between type :"+ enumClass.getNb(this)+ " and type : "+enumClass.getNb(val));
		}
	}
	@Override public Val neq(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			case 3:return val;
			default: return new ErrorType("operation <> impossible between type :"+ enumClass.getNb(this)+ " and type : "+enumClass.getNb(val));
		}
	}
	@Override public Val ieq(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			case 3:return val;
			default: return new ErrorType("operation <= impossible between type :"+ enumClass.getNb(this)+ " and type : "+enumClass.getNb(val));
		}
	}
	@Override public Val seq(Val val)
	{
		switch(enumClass.getNb(val))
		{
			//case 2:
			case 3:return val;
			default: return new ErrorType("operation >= impossible between type :"+ enumClass.getNb(this)+ " and type : "+enumClass.getNb(val));
		}
	}
	@Override public Val inv()
	{
		return new Bool(!a);
	}
}