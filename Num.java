

public class Num extends Exp
{	
	public double a;
	public Num(double pA)
    {
        a=pA;
    }
	
	@Override public void accept(Visitor v)
    {
        v.visitNum(this);
    }
}