package com.raul.examen.examen.Service;


import com.raul.examen.examen.DAO.CategoriaDAO;
import com.raul.examen.examen.Domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    CategoriaDAO categoriaDAO;

    @Override
    public List<Categoria> findAll() throws DataAccessException {
        return categoriaDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Categoria categoria) throws DataAccessException {
        categoriaDAO.save(categoria);
    }
}
