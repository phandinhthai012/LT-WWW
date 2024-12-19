package iuh.fit.se.service;

import iuh.fit.se.entities.Catergory;

import java.util.List;

public interface CategoryService {
    public List<Catergory> getALLCategory();
    public boolean addCategory(Catergory category);
}
