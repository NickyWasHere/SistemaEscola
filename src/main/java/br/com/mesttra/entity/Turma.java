package br.com.mesttra.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Turma {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //Gera um ID diferente sempre que cria uma turma
	@Column (name = "cod_turma")
	private int codTurma;
	
	@ManyToOne
	@JoinColumn(name = "cod_funcionario_fk", referencedColumnName = "cod_funcionario")
	private Professor professor;
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "nro_sala_fk", referencedColumnName = "nro_sala")
	private Sala sala;
	
	@ManyToMany (mappedBy = "turmas", cascade = CascadeType.ALL)
	private List<Aluno> alunos;

	public int getCodTurma() {
		return codTurma;
	}

	public void setCodTurma(int codTurma) {
		this.codTurma = codTurma;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "Código: " + codTurma +
				"\nSala: " + sala.getNroSala();
	}

}
