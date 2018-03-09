

public abstract class VisitorVoid extends Visitor 
{	
	public visitexp(Add exp)
	{
		exp.lhs.accept(this);
		exp.rhs.accept(this);
	}
	public visitMul(Mul exp)
	{
		exp.lhs.accept(this);
		exp.rhs.accept(this);
	}
	public visitSub(Sub exp)
	{
		exp.lhs.accept(this);
		exp.rhs.accept(this);
	}
	public visitDiv(Div exp)
	{
		exp.lhs.accept(this);
		exp.rhs.accept(this);
	}	
	public visitNum(Num exp)
	{
		
	}	
}