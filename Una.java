public class Una extends Exp
{	
	public Exp a;
	public String sym;
	
	public Una(Exp pLhs,String pSym)
    {
        a= pLhs;
		sym=pSym;
		
    }
	@Override public AST accept(Visitor v)
	{
        return v.visitUna(this);
    }

}