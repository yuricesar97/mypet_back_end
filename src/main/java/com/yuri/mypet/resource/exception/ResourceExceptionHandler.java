package com.yuri.mypet.resource.exception;

import javax.servlet.http.HttpServletRequest;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.yuri.mypet.service.exceptions.AuthorizationException;
import com.yuri.mypet.service.exceptions.DataInternalException;
import com.yuri.mypet.service.exceptions.FileException;
import com.yuri.mypet.service.exceptions.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // para intercptar erros
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class) /**
														 * indica que é um tratador de excessão de
														 * ObjectNotFoundException.class
														 */
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

		StandarError err = new StandarError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

	}

	@ExceptionHandler(DataInternalException.class) /**
													 * indica que é um tratador de excessão de
													 * ObjectNotFoundException.class
													 */
	public ResponseEntity<StandarError> DataInternalException(DataInternalException e, HttpServletRequest request) {

		StandarError err = new StandarError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class) /**
																 * indica que é um tratador de excessão de
																 * ObjectNotFoundException.class
																 */
	public ResponseEntity<StandarError> objectNotFound(MethodArgumentNotValidException e, HttpServletRequest request) {

		ValidationError err = new ValidationError(HttpStatus.NOT_FOUND.value(), "Erro de validação",
				System.currentTimeMillis());

		for (FieldError x : e.getBindingResult()
				.getFieldErrors()) { /**
										 * percorrer lista de erros, getBindin e getFiled acessa todos os erros de
										 * campos que ocorreu
										 */
			err.addError(x.getField(), x.getDefaultMessage());// x pega o nome do, getDefault pega a mensagem
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

	}

	@ExceptionHandler(AuthorizationException.class) /**
													 * indica que é um tratador de excessão de
													 * ObjectNotFoundException.class
													 */
	public ResponseEntity<StandarError> authorization(AuthorizationException e, HttpServletRequest request) {

		StandarError err = new StandarError(HttpStatus.FORBIDDEN.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);

	}

	@ExceptionHandler(FileException.class)

	public ResponseEntity<StandarError> file(FileException e, HttpServletRequest request) {

		StandarError err = new StandarError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

	}

	@ExceptionHandler(AmazonServiceException.class)

	public ResponseEntity<StandarError> amazonService(AmazonServiceException e, HttpServletRequest request) {

		HttpStatus code = HttpStatus.valueOf(e.getErrorCode()); //pega codigo que veio da excessao
		StandarError err = new StandarError(code.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(code).body(err);

	}
	@ExceptionHandler(AmazonClientException.class)

	public ResponseEntity<StandarError> amazonClient(AmazonClientException e, HttpServletRequest request) {

		StandarError err = new StandarError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

	}
	@ExceptionHandler(AmazonS3Exception.class)

	public ResponseEntity<StandarError> amazonS3(AmazonS3Exception e, HttpServletRequest request) {

		StandarError err = new StandarError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

	}

}
