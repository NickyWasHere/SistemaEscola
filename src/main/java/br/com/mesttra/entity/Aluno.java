package br.com.mesttra.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
public class Aluno {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int matricula;
	
	@Column (nullable = false, name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@Column (nullable = false)
	private String nome;
	
	@Column (nullable = false)
	private int serie;
	
	@ManyToMany
	@JoinTable (name = "alunos_turmas",
		joinColumns = @JoinColumn (name = "aluno_fk", referencedColumnName = "matricula"),
		inverseJoinColumns = @JoinColumn (name = "turma_fk", referencedColumnName = "cod_turma"))
	private List<Turma> turmas;

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	@Override
	public String toString() {
		return nome +
				"\nMatrícula: " + matricula +
				"\nData de nascimento: " + dataNascimento +
				"\nSérie: " + serie;
	}
}
