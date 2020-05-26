package com.raul.examen.examen.DAO;

import com.raul.examen.examen.Domain.Libro;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class LibroDAOImpl implements LibroDAO{

    @PersistenceContext(unitName = "examen")
    private EntityManager entityManager;

    @Override
    public List<Libro> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from public.cat_libro");
        Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
        List <Libro> resultset = query.getResultList();
        return resultset;
    }

    @Override
    public void save(Libro libro) throws DataAccessException {
    try{
        if(libro.getCodigoLibro()==null)
            entityManager.persist(libro);
        else{
            entityManager.merge(libro);
            entityManager.flush();
        }
    }catch (Throwable e){
        e.printStackTrace();
    }
    }
}
