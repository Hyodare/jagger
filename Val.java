
public abstract class Val extends Exp
{
	
	//public Object a;
	public abstract AST accept(Visitor vis);
	
	public abstract Val add(Val val);
	public abstract Val sub(Val val);
	public abstract Val mul(Val val);
	public abstract Val div(Val val);
	public abstract Val sup(Val val);
	public abstract Val inf(Val val);
	public abstract Val eqa(Val val);
	public abstract Val neq(Val val);
	public abstract Val ieq(Val val);
	public abstract Val seq(Val val);
	public abstract Val inv();
	
	
	
}