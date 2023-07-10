package br.com.grupo7.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Professor {

	private Integer id;
	private String nome;
	private LocalDate dataNascimento;
	private LocalTime cargaHorario;
	private Double valorHora;
	private boolean estrangeiro;
	private Integer horasDisponiveis;
	private String biografia;
	private LocalDateTime dataHoraCadastro;

	/*
	 * private String[] disciplinas;
	 * 
	 * 
	 * public String[] getDisciplinas() { return disciplinas; } public void
	 * setDisciplinas(String[] disciplinas) { this.disciplinas = disciplinas; }
	 */

	public Professor() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public boolean isEstrangeiro() {
		return estrangeiro;
	}

	public void setEstrangeiro(boolean estrangeiro) {
		this.estrangeiro = estrangeiro;
	}

	public Integer getHorasDisponiveis() {
		return horasDisponiveis;
	}

	public void setHorasDisponiveis(Integer horasDisponiveis) {
		this.horasDisponiveis = horasDisponiveis;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalTime getCargaHorario() {
		return cargaHorario;
	}

	public void setCargaHorario(LocalTime cargaHorario) {
		this.cargaHorario = cargaHorario;
	}

	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}


	

}
