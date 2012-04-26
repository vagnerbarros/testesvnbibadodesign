package hibernate;

import interfaces.IEntidades;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtility;


public class Dao<T extends IEntidades> {

	public boolean inserir(T objeto) {

		Session sessao = HibernateUtility.getSession();
		Transaction transacao = sessao.beginTransaction();

		try {
			sessao.save(objeto);
			transacao.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			sessao.flush();
			sessao.close();
		}
	}

	public boolean atualizar(T objeto) {

		Session sessao = HibernateUtility.getSession();
		Transaction transacao = sessao.beginTransaction();

		try {
			sessao.update(objeto);
			transacao.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			sessao.flush();
			sessao.close();
		}
	}

	public boolean deletar(T objeto) {

		Session sessao = HibernateUtility.getSession();
		Transaction transacao = sessao.beginTransaction();

		try {
			sessao.delete(objeto);
			transacao.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			sessao.flush();
			sessao.close();
		}
	}

	public List<T> listarTodos(T obj) {
		
		Session sessao = HibernateUtility.getSession();
		Transaction tx = sessao.beginTransaction();
		
		try {
			Criteria c = sessao.createCriteria(obj.getClass());
			List<T> list = (List<T>) c.list();
			tx.commit();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			sessao.flush();
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> buscar(T objeto){
		
		Session sessao = HibernateUtility.getSession();
		
		try{
			Criteria crit = sessao.createCriteria(objeto.getClass());
			Map<String, Object> map = objeto.getHashMap();
			Set<String> chaves = map.keySet();
			Object valor = null;
			for(String chave : chaves){
				valor = map.get(chave);
				crit.add(Restrictions.eq(chave, valor));
			}
			List<T> retorno = (List<T>) crit.list();
			return retorno;
		}
		catch(HibernateException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public List<T> buscaLike(T objeto){
		
		Session sessao = HibernateUtility.getSession();
		
		try{
			Criteria crit = sessao.createCriteria(objeto.getClass());
			Map<String, Object> map = objeto.getHashMap();
			Set<String> chaves = map.keySet();
			Object valor = null;
			for(String chave : chaves){
				valor = map.get(chave);
				if(valor instanceof Long || valor instanceof Double){
					crit.add(Restrictions.eq(chave, valor));
				}
				else{
					crit.add(Restrictions.ilike(chave, "%"+valor+"%"));
				}
			}
			List<T> retorno = (List<T>) crit.list();
			return retorno;
		}
		catch(HibernateException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public Long ultimoId(T objeto){
		
		Session sessao = HibernateUtility.getSession();
		
		try{
			Criteria crit = sessao.createCriteria(objeto.getClass());
			crit.setProjection(Projections.max("id"));
			return (Long) crit.uniqueResult();
		}
		catch(HibernateException e){
			e.printStackTrace();
			return null;
		}
	}
}