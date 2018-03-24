

public class Num extends Exp
{	
	public double a;
	public Num(double pA)
    {
        a=pA;
    }
	
	@Override public AST accept(Visitor v)
    {
        return v.visitNum(this);
    }
}