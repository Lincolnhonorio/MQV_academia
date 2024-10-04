package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Alunos;
import repository.AlunosRepository;

@Service
public class AlunosService {
	@Autowired
	private static AlunosRepository alunosRepository;
	
	public Alunos salvarAluno(Alunos aluno) {
	return alunosRepository.save(aluno);
	}
	
	public static List<Alunos> listarTodosAlunos(){
	return alunosRepository.findAll();	
	}
	
	public Optional<Alunos> buscarPorId(Long id){
	return alunosRepository.findById(id);	
	}
	
	public void deletarAluno(Long id) {
		alunosRepository.deleteById(id);
	}
}
