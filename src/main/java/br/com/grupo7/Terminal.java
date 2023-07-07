package br.com.grupo7;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import br.com.grupo7.dao.ProfessorDAO;
import br.com.grupo7.model.Professor;

public class Terminal {
	
    public static void main(String[] args) {
    	incluirProfessor();
    }

    
    private static void incluirProfessor(){
    	
        ProfessorDAO professorDAO = new ProfessorDAO();
        Professor professor = popularTabelaProfessor();        
        
        professorDAO.salvar(professor);
        
        System.out.println("Professor incluído com sucesso!");
        
    }
    
    private static Professor popularTabelaProfessor() {
    	
    	Professor professor = new Professor();

        String[] disciplinas = {"Logica de programacao","Programacao Java"};
        
		professor.setNome("GLEYSON SAMPAIO");
		professor.setDataNascimento(LocalDate.of(1999, 9, 9));
		professor.setCargaHorario(LocalTime.of(8, 30, 5));
		professor.setValorHora(40.55);
		professor.setEstrangeiro(false);
		professor.setHorasDisponiveis(4);
		professor.setBiografia("Professor MJV");
		professor.setDisciplinas(disciplinas);
		professor.setDataHoraCadastro(LocalDateTime.now());
		
		return professor;
		
    }

}
