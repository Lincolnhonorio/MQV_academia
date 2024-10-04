package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.NossaHistoria;

@Repository
public interface NossaHistoriaRepository extends JpaRepository<NossaHistoria, Long> {

}
