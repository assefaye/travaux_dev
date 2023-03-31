package sn.groupeisi.gestionsecurite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.groupeisi.gestionsecurite.entities.AppCvEntity;

import java.util.Optional;


public interface AppCvRepository extends JpaRepository<AppCvEntity, Integer> {
    Optional<AppCvEntity> findByEmail(String email);
}
