package com.yuri.mypet.service;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import com.yuri.mypet.domain.EstadoPagamento;
import com.yuri.mypet.domain.ItemPedido;
import com.yuri.mypet.domain.PagamentoComBoleto;
import com.yuri.mypet.domain.Pedido;
import com.yuri.mypet.repositories.ItemPedidoRepository;
import com.yuri.mypet.repositories.PagamentoRepository;
import com.yuri.mypet.repositories.PedidoRepository;
import com.yuri.mypet.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repo;

	@Autowired
	private BoletoService boletoService;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private PetClientService petClientService;

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private EmailService emailService;

	public Pedido find(Integer id) {

		Optional<Pedido> op = repo.findById(id);

		return op.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + Pedido.class.getName()));
	}

	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(petClientService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) { // se o meu pagamento for do tipo pagamento com boleto
																// gera uma data para ele
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());

		}

		repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.find(ip.getProduto().getId())); // item de pedido esta associado com o produto
																			// que buscou do banco de dados
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}

		itemPedidoRepository.saveAll(obj.getItens());
		emailService.sendOrderConfirmationEmail(obj);
		return obj;
	}
}
