

public class Add extends Bin
{	
	public Add(Exp pLhs, Exp pRhs)
    {
        lhs= pLhs;
        rhs=pRhs;
    }
	
	@Override public void accept(Visitor v)
    {
        v.visitAdd(this);
    }
}