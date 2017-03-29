package br.com.caelum.vraptor.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class Carrinho implements Serializable  {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private List<Item> itens = new ArrayList<Item>();
private Double total = 0.0;
public List<Item> getItens() {
	return itens;
}
public void setItens(List<Item> itens) {
	this.itens = itens;
}
public Double getTotal() {
	return total;
}
public void setTotal(Double total) {
	this.total = total;
}
public void adiciona(Item item) {
	// TODO Auto-generated method stub
	itens.add(item);
	total += (item.getProduto().getPreco() * item.getQuantidade());
	System.out.println("Id " + item.getProduto().getId());
	System.out.println("Preço " + item.getProduto().getPreco());
	System.out.println("Total: " + this.total);
}

public Integer getTotalDeItens() {
	return itens.size();
}
public void remove(int indiceItem) {
	Item removido = itens.remove(indiceItem);
	total -= removido.getProduto().getPreco() * removido.getQuantidade();
	
}


}
