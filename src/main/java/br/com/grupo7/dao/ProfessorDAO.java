package br.com.grupo7.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.grupo7.builder.ProfessorBuilder;
import br.com.grupo7.factory.ConnectionFactory;
import br.com.grupo7.model.Professor;

public class ProfessorDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void salvar(Professor professor) {

		String sqlProfessor = "INSERT INTO professor (nome, dataNascimento, cargaHorario, valorHora,"
				+ " estrangeiro, horasDisponiveis, biografia, dataHoraCadastro)" + " VALUES (?,?,?,?,?,?,?,?)";

		try {

			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(sqlProfessor);

			pstm.setString(1, professor.getNome());
			pstm.setDate(2, Date.valueOf(professor.getDataNascimento()));
			pstm.setTime(3, Time.valueOf(professor.getCargaHorario()));
			pstm.setDouble(4, professor.getValorHora());
			pstm.setBoolean(5, professor.isEstrangeiro());
			pstm.setInt(6, professor.getHorasDisponiveis());
			pstm.setString(7, professor.getBiografia());
			pstm.setTimestamp(8, Timestamp.valueOf(professor.getDataHoraCadastro()));
			// pstm.setArray(9, criarArrayDisciplinas(professor,
			// professor.getDisciplinas()));

			pstm.executeUpdate();
			conn.commit(); // Linha necessária porque decidi setar o AutoCommit(false) no ConnectionFactory

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void imprimirPorID(Integer id) throws SQLException {
		
		
		String sqlProfessor = "SELECT * FROM professor WHERE id = ?";
		
		conn = ConnectionFactory.getConnection();
		pstm = conn.prepareStatement(sqlProfessor);
		
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			
			Professor professor = new Professor();
			
			percorrerDados(rs, professor);
			
			StringBuilder sb = ProfessorBuilder
			.construirStringBuilderProfessor(professor.getId(), professor.getNome(),
					professor.getDataNascimento(), professor.getCargaHorario(),
					professor.getValorHora(), professor.isEstrangeiro(),
					professor.getHorasDisponiveis(), professor.getBiografia(),
					professor.getDataHoraCadastro());
			
			System.out.println(sb);
			
		} else {
			System.out.println("Não encontrado");
		}
		
		pstm.execute();
		conn.commit();
	}
	public void imprimirTodos() throws SQLException {

		List<Professor> professores = new ArrayList<Professor>();

		String sqlProfessor = "SELECT * FROM professor";
		
		conn = ConnectionFactory.getConnection();
		pstm = conn.prepareStatement(sqlProfessor);
		ResultSet rs = pstm.executeQuery();

		while(rs.next()) {
			
			Professor professor = new Professor();
			
			percorrerDados(rs, professor);
			
			professores.add(professor);
			
			StringBuilder sb = ProfessorBuilder
			.construirStringBuilderProfessor(professor.getId(), professor.getNome(),
					professor.getDataNascimento(), professor.getCargaHorario(),
					professor.getValorHora(), professor.isEstrangeiro(),
					professor.getHorasDisponiveis(), professor.getBiografia(),
					professor.getDataHoraCadastro());
			System.out.println(sb);
		}
	
		pstm.execute();
		conn.commit(); // Linha necessária porque decidi setar o AutoCommit(false) no ConnectionFactory


	}
	
	public void atualizar(Integer id, Professor professor) throws SQLException {
		

			
		String sqlProfessor = "UPDATE professor SET nome = ?, biografia = ?, cargaHorario = ?,  "
				+ "dataNascimento = ?, estrangeiro = ?, horasDisponiveis = ?, valorHora = ? WHERE id = ?";
		
		conn = ConnectionFactory.getConnection();
		pstm = conn.prepareStatement(sqlProfessor);
		
		pstm.setString(1, professor.getNome());
		pstm.setString(2, professor.getBiografia());
		pstm.setTime(3, Time.valueOf(professor.getCargaHorario()));
		pstm.setDate(4, Date.valueOf(professor.getDataNascimento()));
		pstm.setBoolean(5, professor.isEstrangeiro());
		pstm.setInt(6, professor.getHorasDisponiveis());
		pstm.setDouble(7, professor.getValorHora());
		pstm.setInt(8, id);
		
		pstm.executeUpdate();
		conn.commit();
	
		System.out.println("Atualizado com sucesso! \n\n");
		
	}
	
	public void deletarPorID(Integer id) throws SQLException {
		
		String sqlProfessor = "DELETE FROM professor WHERE id = ?";
				
		conn = ConnectionFactory.getConnection();
		pstm = conn.prepareStatement(sqlProfessor);
		
		pstm.setInt(1, id);
		
		pstm.executeUpdate();
		conn.commit();
	}

	
	public Professor percorrerDados(ResultSet rs, Professor professor) throws SQLException {
		
		professor.setId(rs.getInt("id"));
		professor.setBiografia(rs.getString("biografia"));
		professor.setCargaHorario(rs.getTime("cargaHorario").toLocalTime());
		professor.setDataHoraCadastro(rs.getTimestamp("dataHoraCadastro").toLocalDateTime());
		professor.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
		professor.setEstrangeiro(rs.getBoolean("estrangeiro"));
		professor.setHorasDisponiveis(rs.getInt("horasDisponiveis"));
		professor.setNome(rs.getString("nome"));
		professor.setValorHora(rs.getDouble("valorHora"));
		
		return professor;
	}
	/*
	 * private Array criarArrayDisciplinas(Professor professor, String[]
	 * disciplinas) throws SQLException{
	 * 
	 * disciplinas = professor.getDisciplinas(); Array disciplinasArray =
	 * conn.createArrayOf("text", disciplinas);
	 * 
	 * return disciplinasArray;
	 * 
	 * }
	 */

}
