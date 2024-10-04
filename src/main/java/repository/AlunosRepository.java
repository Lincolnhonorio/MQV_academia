package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.Alunos;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Long> {
	
}
