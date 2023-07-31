package com.yuri.mypet.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.yuri.mypet.service.exceptions.FileException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class S3Service {

	private Logger LOG = LoggerFactory.getLogger(S3Service.class);

	@Autowired
	private AmazonS3 s3client;

	@Value("${s3.bucket}")
	private String bucketName;

	public URI uploadFile(MultipartFile multipartFile) {
		try {
			String fileName = multipartFile.getOriginalFilename(); // extrai nome do arquivo enviado
			InputStream is = multipartFile.getInputStream();

			String contenType = multipartFile.getContentType(); // ler qual arquivo esta sendo enviado
			return uploadFile(is, fileName, contenType);

		} catch (IOException e) {
			
			throw new FileException("Erro de IO: " + e.getMessage());
		}

	}

	public URI uploadFile(InputStream is, String fileName, String contentType) {
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);
			LOG.info("Iniciando upload");
			s3client.putObject(bucketName, fileName, is, meta);
			LOG.info("Upload finalizado");

			return s3client.getUrl(bucketName, fileName).toURI();
		} catch (URISyntaxException e) {

			throw new FileException("Erro ao converter URL para URI");
		}
	}

}