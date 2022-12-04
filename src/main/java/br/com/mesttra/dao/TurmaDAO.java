package br.com.mesttra.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import br.com.mesttra.entity.Aluno;
import br.com.mesttra.entity.Professor;
import br.com.mesttra.entity.Sala;
import br.com.mesttra.entity.Turma;

public class TurmaDAO {

	private EntityManager manager;
	
	public TurmaDAO() {
		manager = Persistence.createEntityManagerFactory("escola").createEntityManager();
	}
	
	public Turma criarTurma(Sala sala) {
		Turma turma = new Turma();
		turma.setSala(sala);
		sala.setTurma(turma);
		
		manager.getTransaction().begin();
		manager.persist(turma);
		manager.getTransaction().commit();
		
		return turma;
	}
	
	public void adicionarProfessor(Professor professor, int codTurma) {
		Turma turma = manager.find(Turma.class, codTurma);
		
		if (turma == null || turma.getProfessor()!=null)
			return;
		
		turma.setProfessor(professor);
		
		manager.getTransaction().begin();
		manager.merge(turma);
		manager.getTransaction().commit();
	}
	
	public void adicionarAluno(Aluno aluno, int codTurma) {
		Turma turma = manager.find(Turma.class, codTurma);
		
		if (turma == null || turma.getProfessor() == null)
			return;
		
		for (Aluno a : turma.getAlunos()) {
			if (a.getMatricula() == aluno.getMatricula())
				return;
		}
		
		List<Aluno> alunos = turma.getAlunos();
		if (alunos == null) {
			alunos = new ArrayList<Aluno>();
		}
		
		alunos.add(aluno);
		turma.setAlunos(alunos);
		
		List<Turma> turmas = aluno.getTurmas();
		if (turmas == null) {
			turmas = new ArrayList<Turma>();
		}
		
		turmas.add(turma);
		aluno.setTurmas(turmas);
		
		manager.getTransaction().begin();
		manager.merge(turma);
		manager.getTransaction().commit();
	}
	
	public void listaChamada(int codTurma) {
		Turma turma = manager.find(Turma.class, codTurma);
		
		if (turma == null)
			return;
		
		for (Aluno aluno : turma.getAlunos()) {
			System.out.println(aluno);
		}
	}
	
	public List<Turma> listarTurmas() {
		Query query = manager.createQuery("SELECT t FROM Turma as t");
		return query.getResultList();
	}
	
	public void excluirTurma(int codTurma) {
		Turma turma = manager.find(Turma.class, codTurma);
		
		if (turma == null)
			return;
		
		manager.getTransaction().begin();
		manager.remove(turma);
		manager.getTransaction().commit();
	}
}
