package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.StatusPedido;

public class Pedido {
	private Date momento;
	private StatusPedido status;

	private Cliente cliente;
	private List<ItemPedido> items = new ArrayList<ItemPedido>();

	public Pedido() {
	}

	public Pedido(Date momento, StatusPedido status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItems() {
		return items;
	}
	
	public void adicionaItem(ItemPedido item) {
		this.items.add(item);
	}
	
	public void removeItem(ItemPedido item) {
		this.items.remove(item);
	}
	
	public Double total() {
		double soma = 0.0;
		for (ItemPedido item : items) {
			soma += item.subTotal();
		}
		return soma;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (ItemPedido item : items) {
			sb.append(item.getProduto().getNome());
			sb.append(", ");
			sb.append("$");
			sb.append(String.format("%.2f", item.getProduto().getPreco()));
			sb.append(", ");
			sb.append("Quantidade: ");
			sb.append(item.getQuantidade());
			sb.append(", ");
			sb.append("Subtotal: ");
			sb.append("$");
			sb.append(String.format("%.2f", item.subTotal()) + "\n");
		}
		sb.append("Total preco: ");
		sb.append(this.total());
		
		return sb.toString();
	}
	
	
}
