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
		Eval2 val1= new Eval2(ctx);
		Eval2 cond= new Eval2(ctx);
		(exp).cond.accept(cond);
		int a;
		if(enumClass.getNb(cond.val)!=0){val=new ErrorType("error : there must be a boolean in conditions");return exp;}
		if (((Bool)(cond.val)).a!=true){ (exp).pos1.accept(val1);val=val1.val;return exp;} else {(exp).pos2.accept(val1);val=val1.val;return exp;}
	}
	
	public AST visitLetIn(LetIn p)
	{
		Eval2 a=new Eval2(ctx);
		for(int i=0;i<p.b.size();i++)
		{	
			p.b.get(i).accept(a);
			//System.out.println("apres it: "+i+ "   "+ctx.a.containsKey(p.b.get(i).name));
		}
		//Eval2 a;
		for(int i=0;i<p.c.size();i++)
		{	//a=new Eval2(ctx);
			p.c.get(i).accept(a);
			//System.out.println(a.val);
		}
		return p;
	}
	
	public AST visitGenCtx(GenCtx exp)
	{//System.out.println("jajoute: "+exp.name);
	
		Eval2 a=new Eval2(ctx);
		//System.out.println("debut ctx : "+a.ctx.a.containsKey("i"));
		exp.exp.accept(a);
		ctx.put(exp.name,a.val);
		//System.out.println("fin ctx : "+a.ctx.a.containsKey("i"));
		return exp;
	}
	
	public AST visitVar(Var exp)
	{
		//System.out.println("name: "+exp.name);
		//System.out.println(ctx.a.containsKey("i"));
		val=ctx.get(exp.name);
		//System.out.println(val);
		if(val==null)
			System.out.println("error : the variable does not exist in this Context");
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}