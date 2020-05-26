package com.raul.examen.examen.DAO;

import com.raul.examen.examen.Domain.Categoria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO{
    @PersistenceContext(unitName = "examen")
    private EntityManager entityManager;


    @Override
    public List<Categoria> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from public.cat_categoria");
        Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
        List <Categoria> resultset = query.getResultList();
        return resultset;    }

    @Override
    public void save(Categoria categoria) throws DataAccessException {
            try{
                if(categoria.getCodigoCategoria()==null)
                    entityManager.persist(categoria);
                else{
                    entityManager.merge(categoria);
                    entityManager.flush();
                }
            }catch(Throwable e){
                e.printStackTrace();
            }
    }
}
