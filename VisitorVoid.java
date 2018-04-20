

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
	@Override public AST visitVar(Var p)
	{	
	return p;
	}
	@Override public AST visitGenCtx(GenCtx p)
	{	
	return p;
	}
	@Override public AST visitLetIn(LetIn p)
	{
		for(int i=0;i<p.b.size();i++)
		{	
			p.b.get(i).accept(this);
		}
		for(int i=0;i<p.c.size();i++)
		{	
			p.c.get(i).accept(this);
		}
		return p;
	}
	@Override public AST visitAffect(Affect exp)
	{
		exp.exp.accept(this);		
		return exp;
	}
	
	
	
}