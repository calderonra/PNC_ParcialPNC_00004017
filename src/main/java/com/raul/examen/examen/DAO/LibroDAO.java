package com.raul.examen.examen.DAO;

import com.raul.examen.examen.Domain.Libro;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface LibroDAO {

    public List<Libro> findAll() throws DataAccessException;

    public void save(Libro libro) throws DataAccessException;


}
