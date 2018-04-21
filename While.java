import java.util.ArrayList;

public class While extends Ins
{	public Exp b;
	public ArrayList<AST> c;
	
	public While(Exp pb ,ArrayList<AST> pc)
	{
			b=pb;
			c=pc;		
	}
	
	@Override public AST accept(Visitor vis)
	{
		return vis.visitWhile(this);
	}
}