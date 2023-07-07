package br.com.grupo7.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import br.com.grupo7.factory.ConnectionFactory;
import br.com.grupo7.model.Professor;

public class ProfessorDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void salvar(Professor professor) {

		String sqlProfessor = "INSERT INTO professor (nome, dataNascimento, cargaHorario, valorHora,"
				+ " estrangeiro, horasDisponiveis, biografia, dataHoraCadastro, disciplinas)"
				+ " VALUES (?,?,?,?,?,?,?,?,?)";

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
			pstm.setArray(9, criarArrayDisciplinas(professor, professor.getDisciplinas()));

			pstm.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Array criarArrayDisciplinas(Professor professor, String[] disciplinas) throws SQLException{
		
		disciplinas = professor.getDisciplinas();
		Array disciplinasArray = conn.createArrayOf("text", disciplinas);
		
		return disciplinasArray;
		
	}
	
}
