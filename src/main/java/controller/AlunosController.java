package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Alunos;
import service.AlunosService;

@RestController
@RequestMapping("/api/alunos")
public class AlunosController {

	@Autowired
	private AlunosService alunosService;
	
	@GetMapping
	public List<Alunos> listarTodos() {
        return AlunosService.listarTodosAlunos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alunos> buscarPorId(@PathVariable Long id){
		Optional<Alunos> aluno = alunosService.buscarPorId(id);
		return aluno.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());	
	}
	
	@PostMapping
	public ResponseEntity<Alunos> salvar(@RequestBody Alunos aluno){
		Alunos novoAluno = alunosService.salvarAluno(aluno);
		return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunosService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }

	
	
}
