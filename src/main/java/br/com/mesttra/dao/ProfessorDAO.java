package br.com.mesttra.dao;

import java.util.List;

import javax.persistence.*;

import br.com.mesttra.entity.Professor;

public class ProfessorDAO {

	private EntityManager manager;
	
	public ProfessorDAO() {
		manager = Persistence.createEntityManagerFactory("escola").createEntityManager();
	}
	
	public void inserirProfessor(Professor professor) {
		manager.getTransaction().begin();
		manager.persist(professor);
		manager.getTransaction().commit();
	}
	
	public void removerProfessor(int codFuncionario) {
		Professor professor = manager.find(Professor.class, codFuncionario);
		
		if (professor==null)
			return;
		
		manager.getTransaction().begin();
		manager.remove(professor);
		manager.getTransaction().commit();
	}
	
	public Professor verProfessor(int codFuncionario) {
		return manager.find(Professor.class, codFuncionario);
	}
	
	public List<Professor> verTodos() {
		Query query = manager.createQuery("SELECT p FROM Professor as p");
		return query.getResultList();
	}
}
