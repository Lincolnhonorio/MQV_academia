package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Professores;
import repository.ProfessoresRepository;

@Service
public class ProfessoresService {

	@Autowired
	private ProfessoresRepository professoresRepository;
	
	public Professores salvarProfessor (Professores professor) {
		return professoresRepository.save(professor);
	}
	
	public List<Professores> listarTodosProfessores(){
		return professoresRepository.findAll();
	}
	
	public void deletarProfessor(Long id) {
		professoresRepository.deleteById(id);
	}
}
