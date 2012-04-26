package exception;

public class EntidadeInexistenteException extends Exception{

	public EntidadeInexistenteException(String msg){
		super(msg);
	}
	
	public String toString(){
		return this.getMessage();
	}
}
