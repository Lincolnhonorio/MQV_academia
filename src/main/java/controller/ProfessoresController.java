package controller;

import java.util.List;

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

import model.Professores;
import service.ProfessoresService;

@RestController
@RequestMapping("/api/professores")
public class ProfessoresController {

	@Autowired
	private ProfessoresService professoresService;
	
	@GetMapping
	public List<Professores> listarTodos() {
        return professoresService.listarTodosProfessores();
    }
	
	@PostMapping
	public ResponseEntity<Professores> salvar(@RequestBody Professores professor) {
        Professores novoProfessor = professoresService.salvarProfessor(professor);
        return new ResponseEntity<>(novoProfessor, HttpStatus.CREATED);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
        professoresService.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }	
}
