
public class Var extends Exp
{
	public String name;
	
	public Var(String pname)
	{	name=pname;
	}
	
	@Override public AST accept(Visitor vis)
	{
		return vis.visitVar(this);
	}
}