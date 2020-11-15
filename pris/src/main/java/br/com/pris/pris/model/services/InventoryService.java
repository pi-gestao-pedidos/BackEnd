package br.com.pris.pris.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pris.pris.model.entities.ItemPedido;
import br.com.pris.pris.model.entities.Material;
import br.com.pris.pris.model.entities.MaterialProduto;
import br.com.pris.pris.model.entities.Pedido;

@Service
public class InventoryService {

	@Autowired
	private PedidoService pedidos;
	
	@Autowired
	private MaterialService materiais;

	public void returnsMaterial(Integer idPedido) {
		Pedido pedido = this.pedidos.findPedidoById(idPedido);

		for (ItemPedido produto : pedido.getProdutos()) {
			Integer qtdProduto = produto.getQuantidade();
			for (MaterialProduto material : produto.getProduto().getMateriais()) {
				Material newMaterial = material.getMaterial();			
				Integer qtdMaterial = material.getQuantidade();
				newMaterial.setEstoque(newMaterial.getEstoque()+(qtdProduto*qtdMaterial));
				this.materiais.changeMaterial(newMaterial, newMaterial.getIdMaterial());
			}
		}
	}

	public void removeMaterial(Integer idPedido) {
		Pedido pedido = this.pedidos.findPedidoById(idPedido);

		for (ItemPedido produto : pedido.getProdutos()) {
			Integer qtdProduto = produto.getQuantidade();
			for (MaterialProduto material : produto.getProduto().getMateriais()) {
				Material newMaterial = material.getMaterial();			
				Integer qtdMaterial = material.getQuantidade();
				newMaterial.setEstoque(newMaterial.getEstoque()-(qtdProduto*qtdMaterial));
				this.materiais.changeMaterial(newMaterial, newMaterial.getIdMaterial());
			}
		}
	}
}
