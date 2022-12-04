package br.com.mesttra.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Professor {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "cod_funcionario")
	private int codFuncionario;
	
	@Column (nullable = false)
	private String nome;
	
	@Column (nullable = false)
	private String telefone;
	
	@Column (nullable = false, name = "nivel_graduacao")
	private String nivelGraduacao;
	
	@Column (nullable = false)
	private double salario;
	
	@Column (nullable = false)
	private String disciplina;
	
	@OneToMany (mappedBy = "professor")
	private List<Turma> turmas;
	
	public int getCodFuncionario() {
		return codFuncionario;
	}
	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNivelGraduacao() {
		return nivelGraduacao;
	}
	public void setNivelGraduacao(String nivelGraduacao) {
		this.nivelGraduacao = nivelGraduacao;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
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
				"\nCódigo: " + codFuncionario +
				"\nDisciplina: " + disciplina +
				"\nGraduação: " + nivelGraduacao +
				"\nTelefone: " + telefone +
				"\nSalário: " + salario;
	}
	
}
