package util;

public class Validacao{

	public static boolean cpfValido(String cpf){

		String subCpf = cpf.substring(0, 11).replace(".", "");

		if(subCpf.equals("111111111") || subCpf.equals("222222222") || subCpf.equals("333333333") || subCpf.equals("444444444")
				|| subCpf.equals("555555555") || subCpf.equals("666666666") || subCpf.equals("777777777") || subCpf.equals("888888888")
				|| subCpf.equals("999999999") || subCpf.equals("000000000")){
			return false;
		}
		else{
			
			int resto = auxiliarCpf(subCpf, 10) % 11;
			int primeiroDigito = 0;
			if(resto >= 2){
				primeiroDigito = 11 - resto;
			}

			subCpf = subCpf + primeiroDigito;

			resto = auxiliarCpf(subCpf, 11) % 11;
			int segundoDigito = 0;
			if(resto >= 2){
				segundoDigito = 11 - resto;
			}

			String resultado = primeiroDigito + "" + segundoDigito;
			return resultado.equals(cpf.substring(12, 14));
		}
	}

	private static int auxiliarCpf(String subCpf, int valorInicial){

		int soma = 0;
		int digito;
		for(int i = valorInicial, j = 0; i >= 2; i--, j++){
			digito = Integer.parseInt(subCpf.charAt(j) + "");
			soma += (digito * i); 
		}
		return soma;
	}
	
	public static boolean cnpjValido(String cnpj){
		
		String subCnpj = cnpj.substring(0, 15).replace(".", "");
		subCnpj = subCnpj.replace("/", "");
		
		int resto = auxiliarCnpj(subCnpj, 5) % 11;
		
		int primeiroDigito = 0;
		if(resto >= 2){
			primeiroDigito = 11 - resto;
		}
		
		subCnpj = subCnpj + primeiroDigito;
		
		resto = auxiliarCnpj(subCnpj, 6) % 11;
		
		int segundoDigito = 0;
		if(resto >= 2){
			segundoDigito = 11 - resto;
		}

		String resultado = primeiroDigito + "" + segundoDigito;
		return resultado.equals(cnpj.substring(16, 18));
	}
	
	private static int auxiliarCnpj(String subCnpj, int valorInicial){
		
		int soma = 0;
		int digito;
		boolean primeiroCiclo = true;
		for(int i = valorInicial, j = 0; i >= 2; i--, j++){
			digito = Integer.parseInt(subCnpj.charAt(j) + "");
			soma += (digito * i); 
			if(i == 2 && primeiroCiclo){
				i = 10;
				primeiroCiclo = false;
			}
		}
		return soma;
	}
}
