

public abstract class Num extends Exp
{	
	public int a;
	public Num(int pA)
    {
        a=pA;
    }
	
	@Override public void accept(Visitor v)
    {
        v.visitNum(this);
    }
}