package com.raul.examen.examen.Service;

import com.raul.examen.examen.Domain.Libro;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface LibroService {

    public List<Libro> findAll() throws DataAccessException;

    public void save(Libro libro) throws DataAccessException;
}
