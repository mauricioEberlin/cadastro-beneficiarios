package com.mauricio.avaliacao;

import com.mauricio.avaliacao.model.Beneficiario;
import com.mauricio.avaliacao.model.Documento;
import com.mauricio.avaliacao.service.BeneficiarioService;
import com.mauricio.avaliacao.service.DocumentoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableWebMvc
@OpenAPIDefinition(info = @Info(title = "cadastro-beneficiarios API", version = "1.0.0", description = "(Projeto de avaliação) Uma aplicação utilizando Java e Spring Boot que fornece uma API REST para manter o cadastro \n" +
		"de beneficiários de um plano de saúde, documentado com o Swagger."))
public class CadastroBeneficiariosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CadastroBeneficiariosApplication.class, args);
	}

	@Autowired
	private BeneficiarioService beneficiarioService;

	@Autowired
	private DocumentoService documentoService;

	@Override
	public void run(String... args) throws Exception {

		List<Documento> documentos = new ArrayList<>();

		Documento documento1 = Documento.builder()
				.tipoDocumento("RG")
				.descricao("Documento de identificação")
				.build();

		Documento documento2 = Documento.builder()
				.tipoDocumento("CPF")
				.descricao("Documento de identificação")
				.build();


		documentos.add(documento1);
		documentos.add(documento2);
		documentoService.save(documento1);
		documentoService.save(documento2);

		Beneficiario beneficiario = Beneficiario.builder()
				.documentos(documentos)
				.nome("Maurício Pereira")
				.telefone("11 96265 3735")
				.dataNascimento(LocalDate.of(2000, 02, 16))
				.build();

		beneficiarioService.save(beneficiario);

	}
}