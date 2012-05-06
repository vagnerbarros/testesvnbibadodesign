package fachada;

import interfaces.IRepositorio;

import java.util.List;

import repositorio.Repositorio;
import cadastro.Cadastro;
import entidades.Cliente;
import entidades.Empresa;
import entidades.Endereco;
import entidades.Falha;
import entidades.Funcionario;
import entidades.Pessoa;
import entidades.Reclamacao;
import entidades.Servico;
import entidades.Solicitacao;
import entidades.Telefone;
import exception.EntidadeJaExisteException;

public class Fachada {

	private static Fachada instancia;
	private Cadastro<Cliente> cadCliente;
	private Cadastro<Empresa> cadEmpresa;
	private Cadastro<Endereco> cadEndereco;
	private Cadastro<Falha> cadFalha;
	private Cadastro<Funcionario> cadFuncionario;
	private Cadastro<Reclamacao> cadReclamacao;
	private Cadastro<Servico> cadServico;
	private Cadastro<Telefone> cadTelefone;
	private Cadastro<Pessoa> cadPessoa;
	private Cadastro<Solicitacao> cadSolicitacacao;
	
	private Fachada(){
		iniciarCadastros();
	}
	
	private void iniciarCadastros(){
		
		IRepositorio<Cliente> rCliente = new Repositorio<Cliente>();
		this.cadCliente = new Cadastro<Cliente>(rCliente);
		
		IRepositorio<Empresa> rEmpresa = new Repositorio<Empresa>();
		this.cadEmpresa = new Cadastro<Empresa>(rEmpresa);
		
		IRepositorio<Endereco> rEndereco = new Repositorio<Endereco>();
		this.cadEndereco = new Cadastro<Endereco>(rEndereco);
		
		IRepositorio<Falha> rFalha = new Repositorio<Falha>();
		this.cadFalha = new Cadastro<Falha>(rFalha);
		
		IRepositorio<Funcionario> rFuncionario = new Repositorio<Funcionario>();
		this.cadFuncionario = new Cadastro<Funcionario>(rFuncionario);
		
		IRepositorio<Reclamacao> rReclamacao = new Repositorio<Reclamacao>();
		this.cadReclamacao = new Cadastro<Reclamacao>(rReclamacao);
		
		IRepositorio<Servico> rServico = new Repositorio<Servico>();
		this.cadServico = new Cadastro<Servico>(rServico);
		
		IRepositorio<Telefone> rTelefone = new Repositorio<Telefone>();
		this.cadTelefone = new Cadastro<Telefone>(rTelefone);
		
		IRepositorio<Pessoa> rPessoa = new Repositorio<Pessoa>();
		this.cadPessoa = new Cadastro<Pessoa>(rPessoa);
		
		IRepositorio<Solicitacao> rSolicitacao = new Repositorio<Solicitacao>();
		this.cadSolicitacacao = new Cadastro<Solicitacao>(rSolicitacao);
	}
	
	public static Fachada getInstancia(){
		if(instancia == null){
			instancia = new Fachada();
		}
		return instancia;
	}
	
	// métodos de cliente
	public void cadastrarCliente(Cliente c) throws EntidadeJaExisteException {
		this.cadCliente.cadastrar(c);
	}
	public void removerCliente(Cliente c) {
		this.cadCliente.remover(c);
	}
	public void atualizarCliente(Cliente c) {
		this.cadCliente.atualizar(c);
	}
	public List<Cliente> listarClientes(Cliente c){
		return this.cadCliente.listarTodos(c);
	}
	public List<Cliente> buscarCliente(Cliente c){
		return this.cadCliente.buscar(c);
	}
	public List<Cliente> buscaLikeCliente(Cliente c){
		return cadCliente.buscaLike(c);
	}
	
	//métodos de Funcionario
	public void cadastrarFuncionario(Funcionario f) throws EntidadeJaExisteException{
		this.cadFuncionario.cadastrar(f);
	}
	public void removerFuncionario(Funcionario f){
		this.cadFuncionario.remover(f);
	}
	public void atualizarFuncionario(Funcionario f){
		this.cadFuncionario.atualizar(f);
	}
	public List<Funcionario> listarFuncionario(Funcionario f){
		return this.cadFuncionario.listarTodos(f);
	}
	public List<Funcionario> buscarFuncionario(Funcionario f){
		return this.cadFuncionario.buscar(f);
	}
	public List<Funcionario> buscaLikeFuncionario(Funcionario f){
		return this.cadFuncionario.buscaLike(f);
	}

	
	//métodos de Empresa
	public void cadastrarEmpresa(Empresa e) throws EntidadeJaExisteException{
		this.cadEmpresa.cadastrar(e);
	}
	public void removerEmpresa(Empresa e){
		this.cadEmpresa.remover(e);
	}
	public void atualizarEmpresa(Empresa e){
		this.cadEmpresa.atualizar(e);
	}
	public List<Empresa> listarEmpresas(Empresa e){
		return this.cadEmpresa.listarTodos(e);
	}
	public List<Empresa> buscarEmpresa(Empresa e){
		return this.cadEmpresa.buscar(e);
	}
	public Long ultimoIdEmpresa(Empresa e){
		return this.cadEmpresa.ultimoId(e);
	}
	public List<Empresa> buscaLikeEmpresa(Empresa e){
		return this.cadEmpresa.buscaLike(e);
	}
	
	//métodos de endereço
	public void cadastrarEndereco(Endereco e) throws EntidadeJaExisteException{
		this.cadEndereco.cadastrar(e);
	}
	public void removerEndereco(Endereco e){
		this.cadEndereco.remover(e);
	}
	public void atualizarEndereco(Endereco e){
		this.cadEndereco.atualizar(e);
	}
	public List<Endereco> listarEnderecos(Endereco e){
		return this.cadEndereco.listarTodos(e);
	}
	public List<Endereco> buscarEndereco(Endereco e){
		return this.cadEndereco.buscar(e);
	}
	public Long ultimoIdEndereco(Endereco e){
		return this.cadEndereco.ultimoId(e);
	}
	public List<Endereco> buscaLikeEndereco(Endereco e){
		return this.cadEndereco.buscaLike(e);
	}
	
	//métodos de Falha
	public void cadastrarFalha(Falha f) throws EntidadeJaExisteException{
		this.cadFalha.cadastrar(f);
	}
	public void removerFalha(Falha f){
		this.cadFalha.remover(f);
	}
	public void atualizarFalha(Falha f){
		this.cadFalha.atualizar(f);
	}
	public List<Falha> listarFalhas(Falha f){
		return this.cadFalha.listarTodos(f);
	}
	public List<Falha> buscarFalha(Falha f){
		return this.cadFalha.buscar(f);
	}
	public Long ultimoIdFalha(Falha f){
		return this.cadFalha.ultimoId(f);
	}
	
	//métodos de Reclamação
	public void cadastrarReclamacao(Reclamacao r) throws EntidadeJaExisteException{
		this.cadReclamacao.cadastrar(r);
	}
	public void removerReclamacao(Reclamacao r){
		this.cadReclamacao.remover(r);
	}
	public void atualizarReclamacao(Reclamacao r){
		this.cadReclamacao.atualizar(r);
	}
	public List<Reclamacao> listarReclamacoes(Reclamacao r){
		return this.cadReclamacao.listarTodos(r);
	}
	public List<Reclamacao> buscarReclamacao(Reclamacao r){
		return this.cadReclamacao.buscar(r);
	}
	public Long ultimoIdReclamacao(Reclamacao r){
		return this.cadReclamacao.ultimoId(r);
	}
	public List<Reclamacao> buscaLikeReclamacao(Reclamacao r){
		return this.cadReclamacao.buscaLike(r);
	}

	//métodos de Serviço
	public void cadastrarServico(Servico s) throws EntidadeJaExisteException{
		this.cadServico.cadastrar(s);
	}
	public void removerServico(Servico s){
		this.cadServico.remover(s);
	}
	public void atualizarServico(Servico s){
		this.cadServico.atualizar(s);
	}
	public List<Servico> listarServicos(Servico s){
		return this.cadServico.listarTodos(s);
	}
	public List<Servico> buscarServico(Servico s){
		return this.cadServico.buscar(s);
	}
	public Long ultimoIdServico(Servico s){
		return this.cadServico.ultimoId(s);
	}
	public List<Servico> buscaLikeServico(Servico s){
		return this.cadServico.buscaLike(s);
	}
	
	//métodos de Telefone
	public void cadastrarTelefone(Telefone t) throws EntidadeJaExisteException{
		this.cadTelefone.cadastrar(t);
	}
	public void removerTelefone(Telefone t){
		this.cadTelefone.remover(t);
	}
	public void atualizarTelefone(Telefone t){
		this.cadTelefone.atualizar(t);
	}
	public List<Telefone> listarTelefones(Telefone t){
		return this.cadTelefone.listarTodos(t);
	}
	public List<Telefone> buscarTelefone(Telefone t){
		return this.cadTelefone.buscar(t);
	}
	public Long ultimoIdTelefone(Telefone t){
		return this.cadTelefone.ultimoId(t);
	}
	public List<Telefone> buscaLikeTelefone(Telefone t){
		return this.cadTelefone.buscaLike(t);
	}
	
	//métodos de pessoa
	public void cadastrarPessoa(Pessoa p) throws EntidadeJaExisteException{
		this.cadPessoa.cadastrar(p);
	}
	public void removerPessoa(Pessoa p){
		this.cadPessoa.remover(p);
	}
	public void atualizarPessoa(Pessoa p){
		this.cadPessoa.atualizar(p);
	}
	public List<Pessoa> listarPessoa(Pessoa p){
		return this.cadPessoa.listarTodos(p);
	}
	public List<Pessoa> buscarPessoa(Pessoa p){
		return this.cadPessoa.buscar(p);
	}
	public Long ultimoIdPessoa(Pessoa p){
		return this.cadPessoa.ultimoId(p);
	}
	
	//métodos de solicitacao
	public void cadastrarSolicitacao(Solicitacao s) throws EntidadeJaExisteException{
		this.cadSolicitacacao.cadastrar(s);
	}
	public void removerSolicitacao(Solicitacao s){
		this.cadSolicitacacao.remover(s);
	}
	public void atualizarSolicitacao(Solicitacao s){
		this.cadSolicitacacao.atualizar(s);
	}
	public List<Solicitacao> listarSolicitacao(Solicitacao s){
		return this.cadSolicitacacao.listarTodos(s);
	}
	public List<Solicitacao> buscarSolicitacao(Solicitacao s){
		return this.cadSolicitacacao.buscar(s);
	}
	public List<Solicitacao> buscaIntervaloData(Solicitacao s){
		return this.cadSolicitacacao.buscaLike(s);
	}
}
