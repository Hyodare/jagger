public class Eval extends Visitor
{	
	public AST visitBin(Bin exp)
	{
		
		switch(exp.sym)
		{
			case "+":return new Num(((Num)((exp).lhs.accept(this))).a+((Num)((exp).rhs.accept(this))).a);
			case "-":return new Num(((Num)((exp).lhs.accept(this))).a+((Num)((exp).rhs.accept(this))).a);
			case "*":return new Num(((Num)((exp).lhs.accept(this))).a+((Num)((exp).rhs.accept(this))).a);
			case "/":return new Num(((Num)((exp).lhs.accept(this))).a+((Num)((exp).rhs.accept(this))).a);
			case "<":if(((Num)((exp).lhs.accept(this))).a<((Num)((exp).rhs.accept(this))).a){return new Num(1);} else {return new Num(0);}
			case ">":if(((Num)((exp).lhs.accept(this))).a>((Num)((exp).rhs.accept(this))).a){return new Num(1);} else {return new Num(0);}
			case "==":if(((Num)((exp).lhs.accept(this))).a==((Num)((exp).rhs.accept(this))).a){return new Num(1);} else {return new Num(0);}
			case "<=":if(((Num)((exp).lhs.accept(this))).a<=((Num)((exp).rhs.accept(this))).a){return new Num(1);} else {return new Num(0);}
			case ">=":if(((Num)((exp).lhs.accept(this))).a>=((Num)((exp).rhs.accept(this))).a){return new Num(1);} else {return new Num(0);}
			case "<>":if(((Num)((exp).lhs.accept(this))).a!=((Num)((exp).rhs.accept(this))).a){return new Num(1);} else {return new Num(0);}
			default:return exp;
		}
		
	}
	public AST visitUna(Una exp)
	{
		switch(exp.sym)
		{
			case "+":return exp.a.accept(this);
			case "-":return new Num(((Num)exp.a.accept(this)).a);
			default: return exp;
		}
	}
	/*public abstract Exp visitAdd(Add add);
	public abstract Exp visitMul(Mul mul);
	public abstract Exp visitSub(Sub sub);
	public abstract Exp visitDiv(Div div);*/
	public AST visitNum(Num num)
	{
		return num;
	}
	
	public AST visitPrint(Print p)
	{
		return new Print(((Exp)p.a.accept(this)));
	}
}