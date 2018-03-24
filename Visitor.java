

public abstract class Visitor
{	
	public abstract AST visitBin(Bin exp);
	public abstract AST visitUna(Una exp);
	/*public abstract Exp visitAdd(Add add);
	public abstract Exp visitMul(Mul mul);
	public abstract Exp visitSub(Sub sub);
	public abstract Exp visitDiv(Div div);*/
	public abstract AST visitNum(Num num);
	public abstract AST visitPrint(Print p);
}