 

public class Print extends Ins
{	
	public Exp a;

	
	public Print(Exp pA)
    {
        a=pA;
    }
	@Override public void accept(Visitor v)
	{
        v.visitPrint(this);
    }

}