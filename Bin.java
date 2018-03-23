

public class Bin extends Exp
{	
	public Exp lhs,rhs;
	public String sym;
	
	public Bin(Exp pLhs,String pSym, Exp pRhs)
    {
        lhs= pLhs;
		sym=pSym;
        rhs=pRhs;
    }
	@Override public void accept(Visitor v)
	{
        v.visitBin(this);
    }

}