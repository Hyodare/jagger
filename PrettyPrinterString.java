

public class PrettyPrinterString extends VisitorVoid
{	
	public String  str;
	public PrettyPrinterString()
	{
		str="";
	}
	
	@Override public AST visitBin(Bin exp)
	{
		str=str+"(";
		exp.lhs.accept(this);
		str=str+exp.sym;
		exp.rhs.accept(this);
		str=str+")";
		return exp;
	}
	@Override public AST visitUna(Una exp)
	{
		str=str+exp.sym;
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
		str=str+String.valueOf(exp.a);
		
		return exp;	
	}	
	@Override public AST visitPrint(Print p)
	{
		str=str+"print(";
		p.a.accept(this);
		str=str+")";
		str=str+"---->";
		p.a.accept(new Eval()).accept(this);
		return p;
	}
	@Override public AST visitIte(Ite p)
	{
		str=str+"if(";
		p.cond.accept(this);
		str=str+") then(";
		p.pos1.accept(this);
		str=str+") else(";
		p.pos2.accept(this);
		str=str+")";
		return p;
	}
	@Override public AST visitCharC(CharC p)
	{
		str=str+" ";
		str=str+p.a;
		str=str+" ";
		return p;		
	}
	@Override public AST visitError(Error p)
	{
		str=str+"Error: ";
		str=str+p.a;
		str=str+" ";
		return p;		
	}
}