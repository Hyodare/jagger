 

public class Print extends Ins
{	
	public Exp a;

	
	public Print(Exp pA)
    {
        a=pA;
    }
	@Override public AST accept(Visitor v)
	{
        return v.visitPrint(this);
    }

}