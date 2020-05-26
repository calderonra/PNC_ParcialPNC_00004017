package com.raul.examen.examen.Service;

import com.raul.examen.examen.Domain.Categoria;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CategoriaService {

    public List<Categoria> findAll() throws DataAccessException;
    public void save(Categoria categoria) throws DataAccessException;
}
