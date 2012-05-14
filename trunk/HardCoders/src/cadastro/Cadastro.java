package cadastro;

import interfaces.IEntidades;
import interfaces.IRepositorio;
import java.util.List;

import exception.EntidadeJaExisteException;

public class Cadastro <T extends IEntidades<T>> {

	private IRepositorio<T> repositorio;

	public Cadastro(IRepositorio<T> rep){
		this.repositorio = rep;
	}

	public void cadastrar(T novo) throws EntidadeJaExisteException{
		
		List<T> results = this.repositorio.buscar(novo.getCamposChave());
		boolean podeInserir = true;
		for(T elem : results){
			if(novo.equals(elem)){
				podeInserir = false;
			}
		}
		if(podeInserir){
			this.repositorio.inserir(novo);
		}
		else{
			throw new EntidadeJaExisteException(novo + " já existe");
		}
	}

	public void remover(T rem){
		this.repositorio.remover(rem);
	}

	public void atualizar(T atual) throws EntidadeJaExisteException{
		List<T> results = this.repositorio.buscar(atual.getCamposChave());
		boolean podeAtualizar = true;
		for(T elem : results){
			if(atual.equals(elem) && !atual.getId().equals(elem.getId())){
				podeAtualizar = false;
			}
		}
		if(podeAtualizar){
			this.repositorio.atuliazar(atual);
		}
		else{
			throw new EntidadeJaExisteException(atual + "já existe");
		}
	}

	public List<T> listarTodos(T obj){
		return this.repositorio.listarTodos(obj);
	}

	public List<T> buscar(T elem){
		return this.repositorio.buscar(elem);
	}
	
	public List<T> buscaLike(T elem){
		return this.repositorio.buscaLike(elem);
	}
	
	public Long ultimoId(T elem){
		return this.repositorio.ultimoId(elem);
	}
}

