

public abstract class Bin extends Exp
{	
	public Exp lhs,rhs;
	@Override public abstract void accept(Visitor vis);

}