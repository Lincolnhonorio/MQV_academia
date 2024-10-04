package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "professores")
public class Professores {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id; // Identificador único para cada professor

	    private String nome; // Nome do professor
	    private String modalidade; // Modalidade que o professor ensina
	    private String horario; // Horário em que o professor está disponível
		
	    public Professores() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getModalidade() {
			return modalidade;
		}

		public void setModalidade(String modalidade) {
			this.modalidade = modalidade;
		}

		public String getHorario() {
			return horario;
		}

		public void setHorario(String horario) {
			this.horario = horario;
		}
	    
}
