

public abstract class VisitorVoid extends Visitor 
{	@Override public Exp visitBin(Bin exp)
	{
		exp.lhs.accept(this);
		exp.rhs.accept(this);
		return exp;
	}
	/*@Override public Exp visitAdd(Add exp)
	{
		exp.lhs.accept(this);
		exp.rhs.accept(this);
		return exp;
	}
	@Override public Exp visitMul(Mul exp)
	{
		exp.lhs.accept(this);
		exp.rhs.accept(this);
		return exp;
	}
	@Override public Exp visitSub(Sub exp)
	{
		exp.lhs.accept(this);
		exp.rhs.accept(this);
		return exp;
	}
	@Override public Exp visitDiv(Div exp)
	{
		exp.lhs.accept(this);
		exp.rhs.accept(this);
		return exp;
	}	*/
	@Override public Exp visitNum(Num exp)
	{
		return exp;	
	}	
}