import java.util.ArrayList;

public class LetIn extends Ins
{
	public ArrayList<GenCtx> b;
	public ArrayList<AST> c;
	
	public LetIn(ArrayList<GenCtx> pb ,ArrayList<AST> pc)
	{
			b=pb;
			c=pc;		
	}
	
	@Override public AST accept(Visitor vis)
	{
		return vis.visitLetIn(this);
	}
}