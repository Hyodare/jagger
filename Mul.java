

public abstract class Mul extends Bin
{	
	public Mul(Exp pLhs, Exp pRhs)
    {
        lhs= pLhs;
        rhs=pRhs;
    }
	
	@Override public void accept(Visitor v)
    {
        v.visitMul(this);
    }
}