package teste;

import java.util.List;

import util.Constantes;
import entidades.Cliente;
import entidades.Empresa;
import entidades.Funcionario;
import entidades.Pessoa;
import exception.EntidadeJaExisteException;
import fachada.Fachada;


public class TesteHibernate {

	private Fachada fachada;

	public TesteHibernate(){
		this.fachada = Fachada.getInstancia();
	}

	public void inserirCliente(){

		Cliente c = new Cliente();
		c.setNome("Jose");
		c.setEmail("jose@gmail.com");
		c.setId_empresa(new Long(1));
		c.setCpfOrCnpj("8884994944");
		c.setTipo(Constantes.PF);
		c.setAtivo(Constantes.ATIVO);
		try {
			this.fachada.cadastrarCliente(c);
		} catch (EntidadeJaExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inserirFuncionario(){

		Pessoa p = new Pessoa();
		p.setAtivo(Constantes.ATIVO);
		Fachada fachada = this.fachada.getInstancia();
		try {
			fachada.cadastrarPessoa(p);
		} catch (EntidadeJaExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long id_pessoa = fachada.ultimoIdPessoa(p);
		
		Funcionario f = new Funcionario();
		f.setId_pessoa(id_pessoa);
		f.setLogin("vagner");
		f.setCargo(Constantes.GERENTE);
		f.setSenha("12345");
		f.setNome("Vagner Barros Pereira");
		f.setCpf("050.000.990-60");
		f.setAtivo(Constantes.ATIVO);
		f.setId_empresa(new Long(1));
		try {
			this.fachada.cadastrarFuncionario(f);
		} catch (EntidadeJaExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inserirEmpresa(String nome){

		Empresa e = new Empresa();
		e.setNome(nome);
		e.setAtivo(Constantes.ATIVO);
		try {
			this.fachada.cadastrarEmpresa(e);
		} catch (EntidadeJaExisteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public List<Empresa> buscarEmpresa(Empresa e){
		return this.fachada.buscarEmpresa(e);
	}
	

	public void removerEmpresa(Long id){
		Empresa e = new Empresa();
		e.setId(id);
		List<Empresa> list = buscarEmpresa(e);
		this.fachada.removerEmpresa(list.get(0));
	}
	
	public void listarEmpresas(){
		
		List<Empresa> lista = this.fachada.listarEmpresas(new Empresa());
		for(Empresa e : lista){
			System.out.println("id = " + e.getId() + " nome = " + e.getNome());
		}
	}

	public static void main(String[] args) {

		
		TesteHibernate teste = new TesteHibernate();
		//	teste.inserirCliente();
		//  teste.inserirEmpresa("Tim");
		//	teste.inserirFuncionario();
		// 	teste.removerEmpresa();
		//	Cliente c = new Cliente();
		//	c.setNome("Jose");
		//	teste.buscarCliente(c);
		
	
	}
}
