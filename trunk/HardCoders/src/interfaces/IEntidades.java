package interfaces;

import java.util.Map;

public interface IEntidades<T> {

	public String nomeTabela();
	public Map<String, Object> getHashMap();
	public T getCamposChave();
	public Long getId();
}
