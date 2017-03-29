package br.com.caelum.vraptor.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;



@Table
@Entity
public class Produto implements Serializable {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
private Long id;
	
	@NotNull(message="{produto.nome.vazio}") 
	@Length(min=3,message="{produto.nome.tamanho}")
	private String nome;
	@NotNull(message="{descricao.nome.vazio}")  
	@Length(min=10,message="{descricao.nome.tamanho}")
	private String descricao;
	@NotNull(message="{produto.preco.vazio}")
	@Min(message="{produto.preco.tamanho}", value = 0)
private double preco;
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
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public double getPreco() {
	return preco;
}
public void setPreco(double preco) {
	this.preco = preco;
}


}
