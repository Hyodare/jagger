
public class Affect extends Ins
{
	
	public String name;
	//public Val val;
	public Exp exp;
	public Affect(String pname,Exp pval)
	{
		name=pname;
		exp=pval;
		
	}
	
	@Override public AST accept(Visitor vis)
	{
		return vis.visitAffect(this);
	}
}
		