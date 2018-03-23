

public class PrettyPrinter extends VisitorVoid
{	
	@Override public Exp visitBin(Bin exp)
	{
		System.out.print("(");
		exp.lhs.accept(this);
		System.out.print(exp.sym);
		exp.rhs.accept(this);
		System.out.print(")");
		return exp;
	}
	/*@Override public Exp visitAdd(Add exp)
	{
		System.out.print("(");
		exp.lhs.accept(this);
		System.out.print("+");
		exp.rhs.accept(this);
		System.out.print(")");
		return exp;
	}
	@Override public Exp visitMul(Mul exp)
	{
		exp.lhs.accept(this);
		System.out.print("*");
		exp.rhs.accept(this);
		return exp;
	}
	@Override public Exp visitSub(Sub exp)
	{
		System.out.print("(");
		exp.lhs.accept(this);
		System.out.print("-");
		exp.rhs.accept(this);
		System.out.print(")");
		return exp;
	}
	@Override public Exp visitDiv(Div exp)
	{
		exp.lhs.accept(this);
		System.out.print("/");
		exp.rhs.accept(this);
		return exp;
	}	*/
	@Override public Exp visitNum(Num exp)
	{
		System.out.print(exp.a);
		
		return exp;	
	}	
	@Override public Exp visitPrint(Print p)
	{
		System.out.print("print(");
		p.exp.accept(this);
		System.out.print(")");
		return p;
	}
}