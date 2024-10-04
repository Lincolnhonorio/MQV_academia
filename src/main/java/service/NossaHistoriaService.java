package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.NossaHistoria;
import repository.NossaHistoriaRepository;

@Service
public class NossaHistoriaService {

	@Autowired
	private NossaHistoriaRepository nossaHistoriaRepository;
	
	public NossaHistoria salvarHistoria(NossaHistoria historia) {
		return nossaHistoriaRepository.save (historia);
	}
	
	public List<NossaHistoria> listarHistoria(){
		return nossaHistoriaRepository.findAll();
	}
}
