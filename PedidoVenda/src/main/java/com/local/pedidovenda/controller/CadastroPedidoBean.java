package com.local.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.local.pedidovenda.model.Cliente;
import com.local.pedidovenda.model.EnderecoEntrega;
import com.local.pedidovenda.model.FormaPagamento;
import com.local.pedidovenda.model.ItemPedido;
import com.local.pedidovenda.model.Pedido;
import com.local.pedidovenda.model.Produto;
import com.local.pedidovenda.model.Usuario;
import com.local.pedidovenda.repository.ClienteRepository;
import com.local.pedidovenda.repository.ProdutoRepository;
import com.local.pedidovenda.repository.UsuarioRepository;
import com.local.pedidovenda.service.CadastroPedidoService;
import com.local.pedidovenda.util.jsf.FacesUtil;
import com.local.pedidovenda.validation.SKU;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Inject
	private ClienteRepository clienteRepository;
	
	@Inject
	private ProdutoRepository produtoRepository;
	
	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	@Produces
	@PedidoEdicao
	private Pedido pedido;
	
	private List<Usuario> vendedores;
	
	private Produto produtoLinhaEditavel;
	
	private String sku;
	
	
	public CadastroPedidoBean() {
		this.limpar();

	}	
	
	private void limpar(){
		this.pedido = new Pedido();
		this.pedido.setEnderecoEntrega(new EnderecoEntrega());
	}	
	
	public void pedidoAlterado(@Observes PedidoAlteradoEvent event) {
		this.pedido = event.getPedido();
	}
		
	public void inicializar(){
		if (FacesUtil.isNotPostback()) {
			this.vendedores = this.usuarioRepository.vendedores();
			
			this.pedido.adicionarItemVazio();
			
			this.recalcularPedido();
		}
	}	
	
	public  void salvar(){
		this.pedido.removerItemVazio();
		
		try{
			this.pedido = this.cadastroPedidoService.salvar(this.pedido);
		
			FacesUtil.addInfoMessage("Pedido salvo com sucesso!");
		} finally{
			this.pedido.adicionarItemVazio();
		}
	}
	
	public void recalcularPedido(){
		if(this.pedido != null){
			this.pedido.recalcularValorTotal();
			
		}
	}	
	
	public void carregarProdutoPorSku(){
		if(StringUtils.isNotEmpty(this.sku)){
			this.produtoLinhaEditavel = this.produtoRepository.porSku(this.sku);
			this.carregarProdutoLinhaEditavel();
		}
	}	
	
	public void carregarProdutoLinhaEditavel() {
		ItemPedido item = this.pedido.getItens().get(0);
		
		if (this.produtoLinhaEditavel != null) {
			if(this.existeItemComProduto(this.produtoLinhaEditavel)){
				FacesUtil.addAlertMessage("Já existe um item no pedido com o produto informado. ");
			} else {
				item.setProduto(this.produtoLinhaEditavel);
				item.setValorUnitario(this.produtoLinhaEditavel.getValorUnitario());
				
				this.pedido.adicionarItemVazio();
				this.produtoLinhaEditavel = null;
				this.sku = null;
				
				this.pedido.recalcularValorTotal();
			}

		}
	}	
	
	private boolean existeItemComProduto(Produto produto) {
		Boolean existeItem = false;
		
		for (ItemPedido item : this.getPedido().getItens()) {
			if(produto.equals(item.getProduto())){
				existeItem =  true;
				break;
			}
		}
		
		return existeItem;
	}
	
	public void atualizarQuantidade(ItemPedido item, int linha){
		if(item.getQuantidade() <  1){
			if(linha == 0){
				item.setQuantidade(1);
			} else {
				this.getPedido().getItens().remove(linha);
			}
		}
		this.pedido.recalcularValorTotal();
	}
	

	public List<Produto> completarProduto(String nome) {
		return this.produtoRepository.porNome(nome);
	}
	
	public FormaPagamento[] getFormasPagamento() {
		return FormaPagamento.values();
	}
	
	public List<Cliente> completarCliente(String nome) {
		return this.clienteRepository.porNome(nome);
	}
	

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Usuario> getVendedores() {
		return vendedores;
	}	
	
	
	public Produto getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}

	public void setProdutoLinhaEditavel(Produto produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}	
	
	@SKU
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Boolean isEditando() {
		return this.pedido.getId() != null;
	}	
}