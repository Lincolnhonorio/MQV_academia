package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.NossaHistoria;
import service.NossaHistoriaService;

@RestController
@RequestMapping
public class NossaHistoriaController {
	
	@Autowired
	private NossaHistoriaService nossaHistoriaService;
	
	@GetMapping
	public List<NossaHistoria> listarHistoria(){
		return nossaHistoriaService.listarHistoria();
	}
	
	@PostMapping
	public ResponseEntity<NossaHistoria> salvar(@RequestBody NossaHistoria historia) {
		NossaHistoria novaHistoria = nossaHistoriaService.salvarHistoria(historia);
		return new ResponseEntity<>(novaHistoria, HttpStatus.CREATED);
	}
}
