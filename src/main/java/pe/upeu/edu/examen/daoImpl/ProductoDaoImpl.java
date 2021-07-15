package pe.upeu.edu.examen.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.upeu.edu.examen.config.Conexion;
import pe.upeu.edu.examen.dao.ProductoDao;
import pe.upeu.edu.examen.model.Producto;


public class ProductoDaoImpl implements ProductoDao{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	
	
	@Override
	public int create(Producto p) {
		int x = 0;
		String SQL = "insert into producto (idproducto, nombre, precio, stock) values(null, ?,?,?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, p.getNombre());
			ps.setDouble(2, p.getPrecio());
			ps.setInt(3, p.getStock());
			x = ps.executeUpdate();
			System.out.println(x);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public int update(Producto p) {
		// TODO Auto-generated method stub
		int x = 0;
		String SQL = "update producto set nombre = ?, precio = ?, stock = ? where idproducto = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, p.getNombre());
			ps.setDouble(2, p.getPrecio());
			ps.setInt(3, p.getStock());
			ps.setInt(4, p.getIdproducto());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public Producto read(int id) {
		// TODO Auto-generated method stub
		Producto p = new Producto();
		String SQL = "select *from producto where idproducto=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {				
				p.setIdproducto(rs.getInt("idproducto"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getDouble("precio"));
				p.setStock(rs.getInt("stock"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return p;
	}

	@Override
	public int delete(int id) {
		int x = 0;
		String SQL = "delete from producto where idproducto=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		List<Producto> lista = new ArrayList<>();
		String SQL = "select *from producto";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery(SQL);
			while(rs.next()) {
				Producto p = new Producto();
				p.setIdproducto(rs.getInt("idproducto"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getDouble("precio"));
				p.setStock(rs.getInt("stock"));
				lista.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		
		return lista;
	}
}
