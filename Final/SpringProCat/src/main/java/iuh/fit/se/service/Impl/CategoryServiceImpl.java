package iuh.fit.se.service.Impl;

import iuh.fit.se.dao.CatergoryDao;
import iuh.fit.se.entities.Catergory;
import iuh.fit.se.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CatergoryDao catergoryDao;
    @Override
    public List<Catergory> getALLCategory() {
        return catergoryDao.getALlCatergory();
    }

    @Override
    public boolean addCategory(Catergory category) {
        return catergoryDao.addCatergory(category);
    }
}
