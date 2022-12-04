package br.com.mesttra.dao;

import java.util.List;

import javax.persistence.*;

import br.com.mesttra.entity.Aluno;

public class AlunoDAO {

	private EntityManager manager;
	
	public AlunoDAO() {
		this.manager = Persistence.createEntityManagerFactory("escola").createEntityManager();
	}
	
	public void inserirAluno(Aluno aluno) {
		manager.getTransaction().begin();
		manager.persist(aluno);
		manager.getTransaction().commit();
	}
	
	public void removerAluno(int matricula) {
		Aluno aluno = manager.find(Aluno.class, matricula);
		
		if (aluno==null)
			return;
		
		manager.getTransaction().begin();
		manager.remove(aluno);
		manager.getTransaction().commit();
	}
	
	public Aluno verAluno(int matricula) {
		return manager.find(Aluno.class, matricula);
	}
	
	public List<Aluno> verTodos() {
		Query query = manager.createQuery("SELECT a FROM Aluno as a");
		return query.getResultList();
	}
}
