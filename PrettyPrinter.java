

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
		/*System.out.print("---->");
		//System.out.print
		Eval2 a=new Eval2();
		p.a.accept(a);
		System.out.print(a.val);*/
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
	
	public AST visitLetIn(LetIn p)
	{	
		System.out.print("let ");
		for(int i=0;i<p.b.size();i++)
		{	
			p.b.get(i).accept(this);
		}
		System.out.print(" in ");
		for(int i=0;i<p.c.size();i++)
		{	
			p.c.get(i).accept(this);
			
		}
		System.out.print(" end ");
		return p;
	}
	
	public AST visitGenCtx(GenCtx exp)
	{
		System.out.print("var ");
		System.out.print(exp.name);
		System.out.print(":=");
		exp.exp.accept(this);
		System.out.print("  ");
		return exp;
	}
	
	public AST visitVar(Var exp)
	{
		System.out.print(exp.name);
		return exp;
	}
	@Override public AST visitAffect(Affect exp)
	{
		System.out.print(exp.name);
		System.out.print(":=");
		exp.exp.accept(this);
		System.out.print(";");
		return exp;
	}
	
	@Override public AST visitWhile(While exp)
	{
		System.out.print("while ");exp.b.accept(this);
		System.out.print(" do ");
		for(int i=0;i<exp.c.size();i++)
		{	
			exp.c.get(i).accept(this);
		}
		System.out.print("end");
		return exp;
	}
	@Override public AST visitFor(For exp)
	{
		System.out.print("for ");
		for(int i=0;i<exp.b.size();i++)
		{	
			exp.b.get(i).accept(this);
		}
		System.out.print(" ; ");exp.a.accept(this);
		System.out.print(" ; ");exp.d.accept(this);
		System.out.print(" ; do ");
		for(int i=0;i<exp.c.size();i++)
		{	
			exp.c.get(i).accept(this);
		}
		System.out.print("end");
		return exp;
		
	}
		
}