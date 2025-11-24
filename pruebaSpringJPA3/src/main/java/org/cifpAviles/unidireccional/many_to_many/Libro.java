package org.cifpAviles.unidireccional.many_to_many;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity(name="uni_libro_many_to_many")
@Table(name="uni_libro_many_to_many")
public class Libro {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String editorial;
	
	@ManytoMany
	@JoinTable(name="AutorLibroUnidireccional",
	joinColumns = @JoinColumn(name="idLibro"),
	inverseJoinColumns = @JoinColumn(name="idAutor"))
	
	private List<Autor> listAutores;
}
