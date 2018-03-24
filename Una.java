public class Una extends Exp
{	
	public Exp a;
	public String sym;
	
	public Una(Exp pLhs,String pSym)
    {
        a= pLhs;
		
    }
	@Override public void accept(Visitor v)
	{
        v.visitUna(this);
    }

}