package interfaces;

import java.util.List;

public interface IRepositorio <T>{

	public void inserir(T novo);
	public void remover(T rem);
	public void atuliazar(T atual);
	public List<T> listarTodos(T elem);
	public List<T> buscar(T elem);
	public List<T> buscaLike(T elem);
	public Long ultimoId(T elem);
}
