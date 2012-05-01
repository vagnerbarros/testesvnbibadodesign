package util;

public class Constantes {

	// cargos poss�veis para funcionarios.
	public static String GERENTE = "Gerente";
	public static String FUNCIONARIO = "Funcion�rio";
	
	// tipos de endere�os poss�veis
	public static String RESIDENCIAL = "Residencial";
	public static String COMERCIAL = "Comercial";
	
	//tipos de telefones poss�veis
//	public static String RESIDENCIAL = "Residencial";
	public static String CELULAR = "Celular";
	public static String CONTATO = "Contato";
//	public static String COMERCIAL = "Comercial";
	
	// tipos constantes de clientes
	public static String PF = "pessoa fisica";
	public static String PJ = "pessoa juridica";
	
	//parametros de busca funcionario
	public static String NOME = "Nome";
	public static String CPF = "CPF";
	
	// parametros de busca Servico
//	public static String NOME = "NOME";
	public static String VALOR = "Valor";
	
	// parametros de busca reclamacao
	public static String CODIGO = "C�digo";
	public static String TIPO = "Tipo";
	
	// parametros de busca cliente
	public static String NOMERAZAO = "Nome/Raz�o Social";
	public static String ENDERECO = "Endere�o";
	public static String TELEFONE = "Telefone";
	public static String CPFCNPJ = "CPF/CNPJ";
	
	// lista de estados poss�veis 
	public static String [] listaEstados = { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI",
		"PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"};
	
	// lista de tipos de telefone funcionario
	public static String [] getRotuloTelefone(){
		String [] retorno = {RESIDENCIAL , CELULAR};
		return retorno;
	}
	
	//lista de tipos de telefone pessoa jur�dica
	public static String [] getRotuloTelefoneCliente(){
		String [] retorno = {RESIDENCIAL, COMERCIAL, CELULAR, CONTATO};
		return retorno;
	}
	
	// lista de tipos de endere�os
	public static String [] getRotuloEndereco(){
		String [] retorno = {RESIDENCIAL, COMERCIAL};
		return retorno;
	}
	
	// lista de tipos de funcionarios
	public static String [] getCargos(){
		String [] retorno = {FUNCIONARIO, GERENTE};
		return retorno;
	}
	
	//tipos busca funcionario
	public static String [] getBuscaFuncionario(){
		String [] retorno = {NOME, CPF};
		return retorno;
	}
	
	//tipos busca servico
	public static String [] getBuscaServico(){
		String [] retorno = {NOME, VALOR};
		return retorno;
	}
	
	//tipos busca reclamacao
	public static String [] getBuscaReclamacao(){
		String [] retorno = {CODIGO, TIPO};
		return retorno;
	}
	
	//tipos busca cliente
	public static String [] getBuscaCliente(){
		String [] retorno = {NOMERAZAO, ENDERECO, TELEFONE, CPFCNPJ};
		return retorno;
	}
	
	// tipo ativo
	public static String ATIVO = "S";
	public static String INATIVO = "N";
}
