package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.Professores;

@Repository
public interface ProfessoresRepository extends JpaRepository<Professores, Long> {

}
