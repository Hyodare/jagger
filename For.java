import java.util.ArrayList;

public class For extends Ins
{	public Exp a;
	public ArrayList<AST> c;
	public ArrayList<GenCtx> b;
	public AST d;
	
	public For(ArrayList<GenCtx> pb ,Exp pa,AST pd,ArrayList<AST> pc)
	{
			b=pb;
			a=pa;
			d=pd;
			c=pc;		
	}
	
	@Override public AST accept(Visitor vis)
	{
		return vis.visitFor(this);
	}
}