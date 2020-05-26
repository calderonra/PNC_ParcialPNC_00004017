package com.raul.examen.examen.DAO;

import com.raul.examen.examen.Domain.Categoria;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CategoriaDAO {
    public List<Categoria> findAll() throws DataAccessException;
    public void save(Categoria categoria) throws DataAccessException;
}
