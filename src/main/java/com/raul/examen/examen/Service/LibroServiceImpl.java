package com.raul.examen.examen.Service;

import com.raul.examen.examen.DAO.LibroDAO;
import com.raul.examen.examen.Domain.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    LibroDAO libroDAO;

    @Override
    public List<Libro> findAll() throws DataAccessException {
        return libroDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Libro libro) throws DataAccessException {
        libroDAO.save(libro);
    }
}
