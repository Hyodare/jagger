 import java.util.ArrayList;
 
 public class Eval2 extends VisitorVoid
{	
	public Val val;
	public Context ctx;
	
	public Eval2()
	{	ctx=new Context();
	}
	
	public Eval2(Context pctx)
	{	ctx=new Context(pctx);
	}

	public AST visitBin(Bin exp)
	{
		Eval2 val1= new Eval2(ctx);
		Eval2 val2= new Eval2(ctx);
		(exp).lhs.accept(val1);
		Val a=val1.val;
		(exp).rhs.accept(val2);
		Val b=val2.val;
		switch(exp.sym)
		{
			case "+":val=a.add(b); break;
			case "-":val=a.sub(b); break;
			case "*":val=a.mul(b); break;
			case "/":val=a.div(b); break;
			case "<":val=a.inf(b); break;
			case ">":val=a.sup(b); break;
			case "==":val=a.eqa(b); break;
			case "<=":val=a.ieq(b); break;
			case ">=":val=a.seq(b); break;
			case "<>":val=a.neq(b); break;
			default:return exp;
			
		}
		return exp;
	}
	public AST visitUna(Una exp)
	{	
		Eval2 val1= new Eval2(ctx);
		exp.a.accept(val1);
		Val a =val1.val;
		switch(exp.sym)
		{
			case "+":val= a; break;
			case "-":val=a.inv(); break;
			default: return exp;
			
		}
		return exp;
	}
	public AST visitNum(Num exp)
	{
		val= exp;
		return exp;
	}
	public AST visitCharC(CharC exp)
	{
		val= exp;
		return exp;
	}
	public AST visitBool(Bool exp)
	{
		val= exp;
		return exp;
	}
	public AST visitPrint(Print exp)
	{
		Eval2 a=new Eval2(ctx);
		exp.a.accept(a);
		System.out.println(a.val);
		//System.out.println(ctx.a.containsKey("a"));
		return exp;
	}
	public AST visitIte(Ite exp)
	{
		Eval2 val1= new Eval2(ctx);(exp).pos1.accept(val1);
		Eval2 val2= new Eval2(ctx);(exp).pos2.accept(val2);
		if(enumClass.getNb(val1.val) != enumClass.getNb(val2.val))
		{	val=new ErrorType("error then and else must have same type");
			return exp;
		}
		Eval2 cond= new Eval2(ctx);
		(exp).cond.accept(cond);
		int a;
		if(enumClass.getNb(cond.val)!=0){val=new ErrorType("error : there must be a boolean in conditions");return exp;}
		if (((Bool)(cond.val)).a==true){ val=val1.val;return exp;} else {val=val2.val;return exp;}
	}
	
	public AST visitLetIn(LetIn p)
	{
		ArrayList<String> b=new ArrayList<String>();
		ArrayList<String> d=new ArrayList<String>();
		Eval2 a=new Eval2(ctx);
		for(int i=0;i<p.b.size();i++)
		{	
			if (ctx.a.containsKey(p.b.get(i).name))
			{	b.add(p.b.get(i).name);}
			else{d.add(p.b.get(i).name);}
			p.b.get(i).accept(a);
			
		}
		
		for(int i=0;i<p.c.size();i++)
		{
			p.c.get(i).accept(a);
			
		}
		
		
		for(int i=0;i<b.size();i++)
		{
			a.ctx.a.put(b.get(i),ctx.get(b.get(i)));
			
		}
		for(int i=0;i<d.size();i++)
		{	
			a.ctx.a.remove(d.get(i));
			
		}
		ctx=a.ctx;
		return p;
	}
	
	public AST visitGenCtx(GenCtx exp)
	{
	
		Eval2 a=new Eval2(ctx);
		
		exp.exp.accept(a);
		ctx.put(exp.name,a.val);
		
		return exp;
	}
	
	public AST visitVar(Var exp)
	{
		
		val=ctx.get(exp.name);
		
		if(val==null)
			val=new ErrorType("error : the variable does not exist in this Context");
		return exp;
	}
	
	@Override public AST visitAffect(Affect exp)
	{
		if(ctx.a.containsKey(exp.name)==false)
		{
			System.out.println("error : undeclared variable");
			return exp;
		}
		Eval2 a=new Eval2(ctx);
		exp.exp.accept(a);
		ctx.put(exp.name,a.val);
		return exp;
	}
		
		
	@Override public AST visitWhile(While exp)
	{	

		exp.b.accept(this);
				while(((Bool)val).a==true)
		{
			for(int i=0;i<exp.c.size();i++)
			{	
				exp.c.get(i).accept(this);
			}
			exp.b.accept(this);
		}
		return exp;
		
	}
		
	@Override public AST visitFor(For exp)
	{
			
		ArrayList<String> b=new ArrayList<String>();
		ArrayList<String> d=new ArrayList<String>();
		Eval2 a=new Eval2(ctx);
		for(int i=0;i<exp.b.size();i++)
		{	
			if (ctx.a.containsKey(exp.b.get(i).name))
			{	b.add(exp.b.get(i).name);}
			else{d.add(exp.b.get(i).name);}
			exp.b.get(i).accept(a);
		}
		exp.a.accept(a);
		while(((Bool)a.val).a)
		{
			for(int i=0;i<exp.c.size();i++)
			{	
				exp.c.get(i).accept(a);
			}
			exp.d.accept(a);
			exp.a.accept(a);
		}
		
		for(int i=0;i<b.size();i++)
		{	
			a.ctx.a.put(b.get(i),ctx.get(b.get(i)));
			
		}
		for(int i=0;i<d.size();i++)
		{	
			a.ctx.a.remove(d.get(i));
			
		}
		ctx=a.ctx;
		return exp;
		
	}
		
		
	
}