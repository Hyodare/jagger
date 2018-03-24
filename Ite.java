 

public class Ite extends Exp
{	
	public Exp cond,pos1,pos2;
	
	public Ite(Exp pCond,Exp p1, Exp p2)
    {
        cond=pCond;
		pos1=p1;
		pos2=p2;
    }
	@Override public AST accept(Visitor v)
	{
        return v.visitIte(this);
    }

}