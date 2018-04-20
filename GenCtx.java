
public class GenCtx extends Ins
{
	
	public String name;
	//public Val val;
	public Exp exp;
	public GenCtx(String pname,Exp pval)
	{
		name=pname;
		exp=pval;
		/*Eval2 a=new Eval2();
		pval.accept(a);
		val=a.val;*/
	}
	
	@Override public AST accept(Visitor vis)
	{
		return vis.visitGenCtx(this);
	}
}
		
	
	