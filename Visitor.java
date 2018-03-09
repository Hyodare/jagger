

public abstract class Visitor
{	
	public abstract visitAdd(Add add){}
	public abstract visitMul(Mul mul){}
	public abstract visitSub(Sub sub){}
	public abstract visitDiv(Div div){}	
	public abstract visitNum(Num num){}	
}