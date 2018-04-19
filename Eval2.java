 public class Eval2 extends VisitorVoid
{	
	public Val val;
	public AST visitBin(Bin exp)
	{
		Eval2 val1= new Eval2();
		Eval2 val2= new Eval2();
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
	{	Eval2 val1= new Eval2();
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
	/*public abstract Exp visitAdd(Add add);
	public abstract Exp visitMul(Mul mul);
	public abstract Exp visitSub(Sub sub);
	public abstract Exp visitDiv(Div div);*/
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
		return exp;
	}
	public AST visitIte(Ite exp)
	{
		Eval2 val1= new Eval2();
		Eval2 cond= new Eval2();
		(exp).cond.accept(cond);
		int a;
		if(enumClass.getNb(cond.val)!=0){val=new ErrorType("il doit y avoir un Bool dans les conditions");return exp;}
		if (((Bool)(cond.val)).a!=true){ (exp).pos1.accept(val1);val=val1.val;return exp;} else {(exp).pos2.accept(val1);val=val1.val;return exp;}
	}
}