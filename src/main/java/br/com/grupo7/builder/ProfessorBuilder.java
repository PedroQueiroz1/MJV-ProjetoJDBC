package br.com.grupo7.builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ProfessorBuilder {

	public static StringBuilder construirStringBuilderProfessor(Integer id, String nome, LocalDate dataNascimento,
			LocalTime cargaHorario, Double valorHora, boolean estrangeiro, Integer horasDisponiveis, String biografia,
			LocalDateTime dataHoraCadastro) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Id: ").append(id).append("\n");
		sb.append("Nome: ").append(nome).append("\n");
		sb.append("Data de Nascimento: ").append(dataNascimento).append("\n");
		sb.append("Carga Horária: ").append(cargaHorario).append("\n");
		sb.append("Valor por Hora: ").append(valorHora).append("\n");
		sb.append("Estrangeiro? ").append(estrangeiro).append("\n");
		sb.append("Horas Disponíveis: ").append(horasDisponiveis).append("\n");
		sb.append("Biografia:  ").append(biografia).append("\n");
		sb.append("Data e Horário do Cadastro: ").append(dataHoraCadastro).append("\n");
		sb.append("**********************************").append("\n\n");
		
		return sb;
	}
}