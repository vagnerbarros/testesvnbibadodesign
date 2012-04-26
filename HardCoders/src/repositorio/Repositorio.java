package repositorio;

import hibernate.Dao;
import interfaces.IEntidades;
import interfaces.IRepositorio;

import java.util.List;


public class Repositorio <T extends IEntidades> implements IRepositorio<T>{
	
	private Dao<T> dao;
	
	public Repositorio(){
		
		this.dao = new Dao<T>();
	}

	public void inserir(T novo) {
		
		this.dao.inserir(novo);
	}

	public void remover(T rem) {
		
		this.dao.deletar(rem);
	}

	public void atuliazar(T atual) {
		
		this.dao.atualizar(atual);
	}

	public List<T> listarTodos(T obj) {
		return this.dao.listarTodos(obj);
	}

	public List<T> buscar(T elem) {
		return this.dao.buscar(elem);
	}
	
	public List<T> buscaLike(T elem){
		return this.dao.buscaLike(elem);
	}
	
	public Long ultimoId(T elem){
		return this.dao.ultimoId(elem);
	}
}
