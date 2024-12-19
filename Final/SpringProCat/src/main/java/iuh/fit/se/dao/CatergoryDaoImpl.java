package iuh.fit.se.dao;

import iuh.fit.se.entities.Catergory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class CatergoryDaoImpl implements  CatergoryDao{
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Catergory> getALlCatergory() {
        String query = "SELECT c FROM Catergory c";
        return entityManager.createQuery(query,Catergory.class).getResultList();
    }

    @Override
    public boolean addCatergory(Catergory catergory) {
        try {
            entityManager.persist(catergory);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
