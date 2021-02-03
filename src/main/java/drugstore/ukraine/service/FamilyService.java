package drugstore.ukraine.service;

import drugstore.ukraine.entity.Family;

import java.util.Optional;

public interface FamilyService {

    void saveFamily(Family family);

    void deleteFamilyById(Long id );

    Optional<Family> getFamilyById(Long id);

    Iterable<Family> getAllFamilies();

}
