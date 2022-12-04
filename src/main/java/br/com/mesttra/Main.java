package br.com.mesttra;

import java.util.List;

import br.com.mesttra.dao.AlunoDAO;
import br.com.mesttra.dao.ProfessorDAO;
import br.com.mesttra.dao.TurmaDAO;
import br.com.mesttra.entity.Professor;
import br.com.mesttra.entity.Sala;
import br.com.mesttra.entity.Turma;

public class Main {

	public static void main(String[] args) {
		AlunoDAO alunoDAO = new AlunoDAO();
		ProfessorDAO professorDAO = new ProfessorDAO();
		TurmaDAO turmaDAO = new TurmaDAO();

		Professor professor = new Professor();
		professor.setDisciplina("Lógica de Programação");
		professor.setNivelGraduacao("DOUTORADO");
		professor.setNome("Joao");
		professor.setSalario(2000);
		professor.setTelefone("12996291100");
		
		professorDAO.inserirProfessor(professor);
		System.out.println(professorDAO.verProfessor(1));
		
		List<Professor> professores = professorDAO.verTodos();
		for (Professor p: professores) {
			System.out.println(p);
		}
		
		Sala sala = new Sala();
		sala.setAltura(5);
		sala.setComprimento(12);
		sala.setLargura(8);
		
		Turma turma = turmaDAO.criarTurma(sala);
		turmaDAO.adicionarProfessor(professor, turma.getCodTurma());
	}

}
