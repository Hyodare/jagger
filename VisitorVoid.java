

public abstract class VisitorVoid extends Visitor 
{	@Override public AST visitBin(Bin exp)
	{
		exp.lhs.accept(this);
		exp.rhs.accept(this);
		return exp;
	}
	@Override public AST visitUna(Una exp)
	{
		exp.a.accept(this);
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
	@Override public AST visitNum(Num exp)
	{
		return exp;	
	}	
	@Override public AST visitPrint(Print p)
	{
		p.a.accept(this);
		return p;
	}
	@Override public AST visitIte(Ite p)
	{
		p.cond.accept(this);
		p.pos1.accept(this);
		p.pos2.accept(this);
		return p;
	}
	
	@Override public AST visitError(ErrorType p)
	{
		return p;
	}
	
	@Override public AST visitCharC(CharC p)
	{
		return p;
	}
	@Override public AST visitBool(Bool p)
	{
		return p;
	}
}