

public abstract class PrettyPrinter extends VisitorVoid
{	
	@Override public Exp visitAdd(Add exp)
	{
		exp.lhs.accept(this);
		system.out.println("+");
		exp.rhs.accept(this);
		return exp;
	}
	@Override public Exp visitMul(Mul exp)
	{
		exp.lhs.accept(this);
		system.out.println("*");
		exp.rhs.accept(this);
		return exp;
	}
	@Override public Exp visitSub(Sub exp)
	{
		exp.lhs.accept(this);
		system.out.println("-");
		exp.rhs.accept(this);
		return exp;
	}
	@Override public Exp visitDiv(Div exp)
	{
		exp.lhs.accept(this);
		system.out.println("/");
		exp.rhs.accept(this);
		return exp;
	}	
	@Override public Exp visitNum(Num exp)
	{
		system.out.println(exp.a);
		return exp;	
	}	
}