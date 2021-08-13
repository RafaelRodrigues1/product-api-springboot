package br.com.exerciciosspringboot.productwebservice.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(int id) {
		super("Resource not found. ID: " + id);
	}
}
