

public abstract class Bin extends Exp
{	
	public Exp lhs,rhs;
	public abstract accept(Visitor vis){}

}