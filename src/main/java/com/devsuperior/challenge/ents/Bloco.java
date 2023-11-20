package com.devsuperior.challenge.ents;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_bloco")
public class Bloco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant inicio;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant fim;
	
	@ManyToMany(mappedBy = "blocos")
	private Set<Atividade> atividade = new HashSet<>();
	
	public Bloco() {
	}

	public Bloco(Long id, Instant inicio, Instant fim) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getInicio() {
		return inicio;
	}

	public void setInicio(Instant inicio) {
		this.inicio = inicio;
	}

	public Instant getFim() {
		return fim;
	}

	public void setFim(Instant fim) {
		this.fim = fim;
	}
	
	public Set<Atividade> getAtividade() {
		return atividade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bloco other = (Bloco) obj;
		return Objects.equals(id, other.id);
	}
}
