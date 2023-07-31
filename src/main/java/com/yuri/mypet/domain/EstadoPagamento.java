package com.yuri.mypet.domain;

public enum EstadoPagamento {

	PENDENTE(1, "PENDENTE"), QUITADO(2, "QUITADO"), CANCELADO(3, "CANCELADO");

	private Integer cod;
	private String descricao;

	private EstadoPagamento(Integer cod, String descricao) {

		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EstadoPagamento toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}

		}
		throw new IllegalArgumentException("Id inválido: " + cod);

	}
}
