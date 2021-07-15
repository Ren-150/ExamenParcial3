package pe.upeu.edu.examen.dao;

import java.util.List;

import pe.upeu.edu.examen.model.Categoria;

public interface CategoriaDao {
	Categoria read(int id);
	List<Categoria> readAll();
}
