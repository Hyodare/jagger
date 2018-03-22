

public abstract class Visitor
{	
	public abstract Exp visitAdd(Add add);
	public abstract Exp visitMul(Mul mul);
	public abstract Exp visitSub(Sub sub);
	public abstract Exp visitDiv(Div div);
	public abstract Exp visitNum(Num num);
}