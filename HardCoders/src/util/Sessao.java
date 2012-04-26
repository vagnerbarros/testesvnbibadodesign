package util;

import entidades.Empresa;
import entidades.Funcionario;

public abstract class Sessao {

	private static Empresa empresa;
	private static Funcionario funcionario;
	
	public static Empresa getEmpresa(){
		return empresa;
	}
	
	public static void setEmpresa(Empresa emp){
		empresa = emp;
	}
	
	public static Funcionario getFuncionario(){
		return funcionario;
	}
	
	public static void setFuncionario(Funcionario f){
		funcionario = f;
	}
	
	public static void deslogar(){
		funcionario = null;
		empresa = null;
	}
}
