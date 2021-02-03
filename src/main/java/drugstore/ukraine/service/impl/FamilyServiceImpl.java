package drugstore.ukraine.service.impl;

import drugstore.ukraine.dao.FamilyRepository;
import drugstore.ukraine.entity.Family;
import drugstore.ukraine.entity.User;
import drugstore.ukraine.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FamilyServiceImpl implements FamilyService {


    @Autowired
    FamilyRepository familyRepo;

    @Override
    public void saveFamily(Family family) {
        familyRepo.save(family);
    }

    @Override
    public void deleteFamilyById(Long id) {
        familyRepo.deleteById(id);
    }


    @Override
    public Optional<Family> getFamilyById(Long id) {
        return familyRepo.findById(id);
    }

    @Override
    public Iterable<Family> getAllFamilies() {
        return familyRepo.findAll();
    }

}
