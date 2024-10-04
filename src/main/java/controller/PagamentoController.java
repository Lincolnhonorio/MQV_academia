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

import model.Pagamento;
import service.PagamentoService;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

	@Autowired
	private PagamentoService pagamentoService;
	
	
	@GetMapping
	public List<Pagamento> listarTodosPagamentos(){
		return pagamentoService.listarTodosPagamentos();
	}
	
	@PostMapping
	public ResponseEntity<Pagamento> salvar(@RequestBody Pagamento pagamento){
		Pagamento novoPagamento = pagamentoService.salvarPagamento(pagamento);
        return new ResponseEntity<>(novoPagamento, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pagamentoService.deletarPagamento(id);
        return ResponseEntity.noContent().build();
    }
}
