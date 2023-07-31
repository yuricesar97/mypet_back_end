package com.yuri.mypet.service;

import com.yuri.mypet.domain.*;
import com.yuri.mypet.domain.enums.Perfil;
import com.yuri.mypet.domain.enums.TipoCliente;
import com.yuri.mypet.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service // componente so spring pode ser injetado em outros lugares com o @Autowarid
public class DBService {

	@Autowired
	private CategoriasRepository categoriaRepository;
	@Autowired
	private produtoRepository produtoRepository;

	@Autowired
	private PetClientRepository petClientRepository;

	@Autowired
	private EventProviderRepository varEventProviderRepository;

	@Autowired
	private PetProviderRepository petProviderRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoderEncoder;

	public void instantiateTestDataBase() throws ParseException {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônico");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Deceroção");
		Categoria cat7 = new Categoria(null, "Perfumaria");

		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mouse", 80.00);
		Produto produto4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto produto5 = new Produto(null, "Toalha", 50.00);
		Produto produto6 = new Produto(null, "Colcha", 200.00);
		Produto produto7 = new Produto(null, "TV true color", 1200.00);
		Produto produto8 = new Produto(null, "Roçadeira", 800.00);
		Produto produto9 = new Produto(null, "Abajour", 100.00);
		Produto produto10 = new Produto(null, "Pendente", 180.00);
		Produto produto11 = new Produto(null, "Shampoo", 90.00);

		cat1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		cat2.getProdutos().addAll(Arrays.asList(produto2, produto4));
		cat3.getProdutos().addAll(Arrays.asList(produto5, produto6));
		cat4.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3, produto7));
		cat5.getProdutos().addAll(Arrays.asList(produto8));
		cat6.getProdutos().addAll(Arrays.asList(produto9, produto10));
		cat7.getProdutos().addAll(Arrays.asList(produto11));

		produto1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		produto2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		produto3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		produto4.getCategorias().addAll(Arrays.asList(cat2));
		produto5.getCategorias().addAll(Arrays.asList(cat3));
		produto6.getCategorias().addAll(Arrays.asList(cat3));
		produto7.getCategorias().addAll(Arrays.asList(cat4));
		produto8.getCategorias().addAll(Arrays.asList(cat5));
		produto9.getCategorias().addAll(Arrays.asList(cat6));
		produto10.getCategorias().addAll(Arrays.asList(cat6));
		produto11.getCategorias().addAll(Arrays.asList(cat7));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5, produto6, produto7,
				produto8, produto9, produto10, produto11));

		cat1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		cat2.getProdutos().addAll(Arrays.asList(produto2, produto4));
		cat3.getProdutos().addAll(Arrays.asList(produto5, produto6));
		cat4.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3, produto7));
		cat5.getProdutos().addAll(Arrays.asList(produto8));
		cat6.getProdutos().addAll(Arrays.asList(produto9, produto10));
		cat7.getProdutos().addAll(Arrays.asList(produto11));

		produto1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		produto2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		produto3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		produto4.getCategorias().addAll(Arrays.asList(cat2));
		produto5.getCategorias().addAll(Arrays.asList(cat3));
		produto6.getCategorias().addAll(Arrays.asList(cat3));
		produto7.getCategorias().addAll(Arrays.asList(cat4));
		produto8.getCategorias().addAll(Arrays.asList(cat5));
		produto9.getCategorias().addAll(Arrays.asList(cat6));
		produto10.getCategorias().addAll(Arrays.asList(cat6));
		produto11.getCategorias().addAll(Arrays.asList(cat7));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5, produto6, produto7,
				produto8, produto9, produto10, produto11));

		PetClient cli1 = new PetClient(null, "maria_silva", "Yuri Cesar","yuricesar97@gmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, Perfil.CLIENTE, bCryptPasswordEncoderEncoder.encode("123"), null, null,
				"21/04/1997", "Rua Flores", "300", "Apto 303", "Pompeia", "38220834", "Santos", "São Paulo", true, "1932658487", "19985749826");
		cli1.addPerfil(Perfil.ADMIN);

		PetClient cli2 = new PetClient(null, "antonio_nunes", "Antonio Nunes", "antonio@gmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, Perfil.CLIENTE, bCryptPasswordEncoderEncoder.encode("123"), null, null,
				"21/04/1997", "Rua Flores", "300", "Apto 303", "Chácaras São Paulo", "38220834", "Franca", "São Paulo", true, "1932658487", "19985749826");
		cli2.addPerfil(Perfil.ADMIN);

		PetClient cli3 = new PetClient(null, "juliana_aparecida", "Juliana Aparecida", "juliana@gmail.com",
				"36378912377", TipoCliente.PESSOAFISICA, Perfil.CLIENTE, bCryptPasswordEncoderEncoder.encode("123"),
				null, null, "21/04/1997", "Rua Flores", "300", "Apto 303", "Colônia", "38220834", "Jundiaí", "São Paulo", true, "1932658487", "19985749826");

		PetClient cli4 = new PetClient(null, "fabiola_marcondes", "Fabiola Marcondes", "fabiola@gmail.com",
				"36378912377", TipoCliente.PESSOAFISICA, Perfil.CLIENTE, bCryptPasswordEncoderEncoder.encode("123"),
				null, null, "21/04/1997", "Rua Flores", "300", "Apto 303", "Centro", "38220834", "Campinas", "São Paulo", true, "1932658487", "19985749826");

		PetClient cli5 = new PetClient(null, "marina_david", "Marina David", "marina@gmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, Perfil.CLIENTE, bCryptPasswordEncoderEncoder.encode("123"), null, null,
				"21/04/1997", "Rua Flores", "300", "Apto 303", "Bela vista", "38220834", "Bauru", "São Paulo", true, "1932658487", "19985749826");

		PetClient cli6 = new PetClient(null, "ana_costa", "Ana Costa", "ana@gmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, Perfil.CLIENTE, bCryptPasswordEncoderEncoder.encode("321"), null, null, null,
				"Avenida Matos", "105", "Sala 800", "Alegre", "38777012", "Holambra", "São Paulo", true, "1932658487", "19985749826");
		cli6.addPerfil(Perfil.ADMIN);

		petClientRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));

		PetProvider ju1 = new PetProvider(null, "Administrador Geral", "admin@mypet.com", "55167067000107", TipoCliente.PESSOAJURIDICA,
				Perfil.ADMIN , bCryptPasswordEncoderEncoder.encode("321"), "https://mypeet.s3-sa-east-1.amazonaws.com/2.jpg",
				"Aprovado", "banho e tosa", "vaicinaçao", "consulta", "exames", "cirugia", "hidratante", null, null, null, null, null, null, null, null, null,
				null, null, false, "Rua Flores", "300", "Apto 303", "Pompeia", "131582496", "Dom Pedro",
				"Maranhão (MA)", true, "12932584769", "19999857482");
				ju1.addPerfil(Perfil.ADMIN);
						
		PetProvider ju2 = new PetProvider(null, "pet", "personal@gmail.com", "123456",
				TipoCliente.PESSOAJURIDICA, Perfil.SERVICO, bCryptPasswordEncoderEncoder.encode("321"), "https://mypeet.s3.sa-east-1.amazonaws.com/sp17.jpg",
				"Aprovado", "tosa", "vacinaçao", "consulta", "exames", "geral", "hidrata", null, "tosa", "acupunuta", null, null, null, null, null, null,
				null, null, false, "Rua dolores", "300", "Apto 303", "Chácaras São Paulo", "38220834", "Mangaratiba",
				"Pernambuco (PE)",true, "12932584769", "19999857482");

		PetProvider ju3 = new PetProvider(null, "CaninPet", "canin@gmail.com", "123456", TipoCliente.PESSOAJURIDICA,
				Perfil.SERVICO, bCryptPasswordEncoderEncoder.encode("321"), "https://mypeet.s3.sa-east-1.amazonaws.com/sp18.jpg",
				"Aprovado", "tosa", null, "consulta", "exames", "cirurgia", null, null, "tosa", null, null, "hotel", null, null, null, null,
				null, null, false, "Rua gilda", "300", "Apto 303", "Rua Flores", "38220834", "Sapucaia",
				"Rio de Janeiro (RJ)",true, "1932874951", "19998748521");

		PetProvider ju4 = new PetProvider(null, "pet", "pet@gmail.com", "123456", TipoCliente.PESSOAJURIDICA,
				Perfil.SERVICO, bCryptPasswordEncoderEncoder.encode("321"), "https://mypeet.s3.sa-east-1.amazonaws.com/sp21.jpg",
				"Aprovado", "tosa", "vacinaçao", "consulta", "exames", "cirurgia", null, null, "tosa", null, null, "hotel", null, null, null, null,
				null, null, false, "Rua dolores", "300", "Apto 303", "Chácaras São Paulo", "38220834", "Mangaratiba",
				"Rio de Janeiro (RJ)",true, "1932874951", "19998748521");


		petProviderRepository.saveAll(Arrays.asList(ju1, ju2, ju3, ju4));

				petProviderRepository.saveAll(Arrays.asList(ju1, ju2, ju3, ju4));

		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatDateTime = today.format(formatter);
		System.out.println("Formatado : " + formatDateTime);

		EventProvider evento1 = new EventProvider(null,
				"title", "description",
				"2019-09-10", "2019-09-15");

				EventProvider evento2 = new EventProvider(null,
				"title", "description",
				"2019-09-16", "2019-09-22");

		varEventProviderRepository.saveAll(Arrays.asList(evento1,evento2));

//		AgendaProvider varAgendaProvider = new AgendaProvider(null, true, true, true,
//				true, false, false, false,
//				"tempoInicio", "tempoFim", "siglaDia", "tempoInicioCorrecaoo",
//				"tempoFimCorrecao", "today", "time", false);
//		varAgendaProviderRepository.saveAll(Arrays.asList(varAgendaProvider));

	}


	}

