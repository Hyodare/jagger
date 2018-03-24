

public class PrettyPrinter extends VisitorVoid
{	
	@Override public AST visitBin(Bin exp)
	{
		System.out.print("(");
		exp.lhs.accept(this);
		System.out.print(exp.sym);
		exp.rhs.accept(this);
		System.out.print(")");
		return exp;
	}
	@Override public AST visitUna(Una exp)
	{
		System.out.print(exp.sym);
		exp.a.accept(this);
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
	@Override public AST visitNum(Num exp)
	{
		System.out.print(exp.a);
		
		return exp;	
	}	
	@Override public AST visitPrint(Print p)
	{
		System.out.print("print(");
		p.a.accept(this);
		System.out.print(")");
		System.out.print("---->");
		p.a.accept(new Eval()).accept(this);
		return p;
	}
}