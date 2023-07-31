package com.yuri.mypet.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Cliente Físico"), PESSOAJURIDICA(2, "Cliente jurídico");

	private Integer cod;
	private String descricao;

	private TipoCliente(Integer cod, String descricao) {

		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}

		}
		throw new IllegalArgumentException("Id inválido: " + cod);

	}

}
