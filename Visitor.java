

public abstract class Visitor
{	
	public abstract AST visitBin(Bin exp);
	public abstract AST visitUna(Una exp);
	public abstract AST visitNum(Num num);
	public abstract AST visitPrint(Print p);
	public abstract AST visitIte(Ite p);
	public abstract AST visitCharC(CharC exp);
	public abstract AST visitError(ErrorType exp);
	public abstract AST visitBool(Bool exp);
	public abstract AST visitVar(Var exp);
	public abstract AST visitGenCtx(GenCtx exp);
	public abstract AST visitLetIn(LetIn exp);
	
}