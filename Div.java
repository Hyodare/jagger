

public class Div extends Bin
{	
	public Div(Exp pLhs, Exp pRhs)
    {
        lhs= pLhs;
        rhs=pRhs;
    }
	
	@Override public void accept(Visitor v)
    {
        v.visitDiv(this);
    }
}