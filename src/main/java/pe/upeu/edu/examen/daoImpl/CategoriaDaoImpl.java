package pe.upeu.edu.examen.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.upeu.edu.examen.config.Conexion;
import pe.upeu.edu.examen.dao.CategoriaDao;
import pe.upeu.edu.examen.model.Categoria;

public class CategoriaDaoImpl implements CategoriaDao{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;

	public Categoria read(int id) {
		// TODO Auto-generated method stub
		Categoria c = new Categoria();
		String SQL = "select *from categoria where idcategoria=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				c.setIdcategoria(rs.getInt("idcategoria"));
				c.setNombre(rs.getString("nombre"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return c;
	}
	
	public List<Categoria> readAll() {
		// TODO Auto-generated method stub
		List<Categoria> lista = new ArrayList<>();
		String SQL = "select *from categoria";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery(SQL);
			while(rs.next()) {
				Categoria c = new Categoria();
				c.setIdcategoria(rs.getInt("idcategoria"));
				c.setNombre(rs.getString("nombre"));
				lista.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		
		return lista;
	}
}