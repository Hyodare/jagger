
public class ErrorType extends Val
{
	public String a;
	public ErrorType(String pA)
    {
		a=pA;
    }
	
	public AST accept(Visitor v)
    {
        return v.visitError(this);
    }
	
	@Override public String toString()
	{	return a;
	}
	
	@Override public Val add(Val val)
	{
		return this;
	}
	@Override public Val sub(Val val)
	{
		return this;
	}
	@Override public Val mul(Val val)
	{
		return this;
	}
	@Override public Val div(Val val)
	{
		return this;
	}
	@Override public Val sup(Val val)
	{
		return this;
	}
	@Override public Val inf(Val val)
	{
		return this;
	}
	@Override public Val eqa(Val val)
	{
		return this;
	}
	@Override public Val neq(Val val)
	{
		return this;
	}
	@Override public Val ieq(Val val)
	{
		return this;
	}
	@Override public Val seq(Val val)
	{
		return this;
	}
	@Override public Val inv()
	{
		return this;
	}
}