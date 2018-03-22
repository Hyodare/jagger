

public abstract class Sub extends Bin
{	
	public Sub(Exp pLhs, Exp pRhs)
    {
        lhs= pLhs;
        rhs=pRhs;
    }
	
	@Override public void accept(Visitor v)
    {
        v.visitSub(this);
    }
}