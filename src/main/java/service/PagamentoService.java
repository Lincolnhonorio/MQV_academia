package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Pagamento;
import repository.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public Pagamento salvarPagamento(Pagamento pagamento) {
		return pagamentoRepository.save(pagamento);
	}
	
	public List<Pagamento> listarTodosPagamentos(){
		return pagamentoRepository.findAll();
	}
	
	public void deletarPagamento(Long id) {
		pagamentoRepository.deleteById(id);
	}

}
