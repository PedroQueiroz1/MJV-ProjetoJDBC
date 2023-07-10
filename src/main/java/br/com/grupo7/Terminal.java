package br.com.grupo7;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import br.com.grupo7.dao.ProfessorDAO;
import br.com.grupo7.model.Professor;

public class Terminal {

	public static void main(String[] args) throws SQLException {
		
		incluirProfessor();
		imprimirProfessor();
		atualizarProfessor(3, atualizarTabelaProfessor());
		excluirProfessor(1);
	}

	private static void incluirProfessor() {
		ProfessorDAO professorDAO = new ProfessorDAO();
		Professor professor = popularTabelaProfessor();

		professorDAO.salvar(professor);

		System.out.println("Professor incluído com sucesso! \n\n");

	}

	private static void imprimirProfessor() throws SQLException {
		ProfessorDAO professorDAO = new ProfessorDAO();
		professorDAO.imprimirTodos();
	}

	private static void atualizarProfessor(Integer id, Professor professor) throws SQLException {
		ProfessorDAO professorDAO = new ProfessorDAO();
		professorDAO.atualizar(id, professor);
	}

	private static void excluirProfessor(Integer id) throws SQLException {
		ProfessorDAO professorDAO = new ProfessorDAO();

		professorDAO.deletarPorID(id);

		System.out.println("Professor [" + id + "] deletado com sucesso! \n\n");
	}
	

	private static Professor popularTabelaProfessor() {

		Professor professor = new Professor();

		// String[] disciplinas = {"Lógica de programacao","Programação Java"};

		professor.setNome("GLEYSON SAMPAIO");
		professor.setDataNascimento(LocalDate.of(1999, 9, 9));
		professor.setCargaHorario(LocalTime.of(8, 30, 5));
		professor.setValorHora(40.55);
		professor.setEstrangeiro(false);
		professor.setHorasDisponiveis(4);
		professor.setBiografia("Professor MJV");
		// professor.setDisciplinas(disciplinas);
		professor.setDataHoraCadastro(LocalDateTime.now());

		return professor;

	}
	
	public static Professor atualizarTabelaProfessor() {
		
		Professor professor = new Professor();

		// String[] disciplinas = {"Lógica de programacao","Programação Java"};

		professor.setNome("Pedro");
		professor.setDataNascimento(LocalDate.of(1998, 11, 04));
		professor.setCargaHorario(LocalTime.of(2, 10, 10));
		professor.setValorHora(10.55);
		professor.setEstrangeiro(false);
		professor.setHorasDisponiveis(8);
		professor.setBiografia("Estudante apaixonado em programação Java");
		// professor.setDisciplinas(disciplinas);

		return professor;
	}

}
