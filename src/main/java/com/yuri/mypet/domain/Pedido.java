package com.yuri.mypet.domain;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instante;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido") /**
																 * necessario ,se vai não dar erro de entidade trasiente
																 * de quando vai salvar o pedido e pagamento
																 */
	private Pagamento pagamento;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private PetClient cliente;

	@ManyToOne
	@JoinColumn(name = "endereço_de_entrega_id")
	private EnderecoFisico enderecoDeEntrega;

	@OneToMany(mappedBy = "id.pedido") // reverencia do mapeamento de uma classe aux
	private Set<ItemPedido> itens = new HashSet<>();// garante que não tera repetições

	public Pedido() {

	}

	public Pedido(Integer id, Date instante, PetClient cliente, EnderecoFisico endereco) {
		super();
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoDeEntrega = endereco;

	}

	public double getValorTotal() {
		double soma = 0.0;
		for (ItemPedido ip : itens) { // para cada itens pedido da lista itens faça isso
			soma = soma + ip.getSubTotal();
		}
		return soma;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public PetClient getCliente() {
		return cliente;
	}

	public void setCliente(PetClient cliente) {
		this.cliente = cliente;
	}

	public EnderecoFisico getEndereco() {
		return enderecoDeEntrega;
	}

	public void setEndereco(EnderecoFisico endereco) {
		this.enderecoDeEntrega = endereco;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")); // formatar para dinherio do brasil
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido número");
		builder.append(getId());
		builder.append(", Instante: ");
		builder.append(sdf.format(getInstante()));
		builder.append(", Cliente: ");
		builder.append(getCliente().getUsername());
		builder.append(", Situação do pagamento: ");
		builder.append(getPagamento().getEstado().getDescricao());
		builder.append("\nDetalhes:\n");
		for (ItemPedido ip : getItens()) {
			builder.append(ip.toString());
		}
		builder.append("Valor total: ");
		builder.append(nf.format(getValorTotal()));
		return builder.toString();
	}

}
