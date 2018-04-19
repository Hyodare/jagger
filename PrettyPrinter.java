

public class PrettyPrinter extends VisitorVoid
{	
	//public String 
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
		//System.out.print
		Eval2 a=new Eval2();
		p.a.accept(a);
		System.out.print(a.val);
		return p;
	}
	@Override public AST visitIte(Ite p)
	{
		System.out.print("if(");
		p.cond.accept(this);
		System.out.print(") then(");
		p.pos1.accept(this);
		System.out.print(") else(");
		p.pos2.accept(this);
		System.out.print(")");
		return p;
	}
	@Override public AST visitCharC(CharC p)
	{
		System.out.print("'");
		System.out.print(p.a);
		System.out.print("'");
		return p;		
	}
	@Override public AST visitError(ErrorType p)
	{
		System.out.print("Error: ");
		System.out.print(p.a);
		System.out.print(" ");
		return p;		
	}
}