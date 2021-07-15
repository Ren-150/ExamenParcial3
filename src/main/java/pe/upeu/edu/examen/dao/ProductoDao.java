package pe.upeu.edu.examen.dao;

import java.util.List;

import pe.upeu.edu.examen.model.Producto;

public interface ProductoDao {
	int create(Producto p);
	int update(Producto p);
	int delete(int id);
	Producto read(int id);
	List<Producto> readAll();
}
