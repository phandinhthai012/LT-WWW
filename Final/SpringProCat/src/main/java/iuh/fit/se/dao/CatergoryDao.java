package iuh.fit.se.dao;

import iuh.fit.se.entities.Catergory;

import java.util.List;

public interface CatergoryDao {
    public List<Catergory> getALlCatergory();
    public boolean addCatergory(Catergory catergory);
}
