package exception;

public class EntidadeJaExisteException extends Exception{

	public EntidadeJaExisteException(String msg){
		super(msg);
	}
	
	public String toString(){
		return this.getMessage();
	}
}
