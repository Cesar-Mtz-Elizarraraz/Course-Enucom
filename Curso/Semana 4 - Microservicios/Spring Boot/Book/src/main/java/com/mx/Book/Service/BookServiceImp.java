package com.mx.Book.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mx.Book.Entity.Book;

@Service // @Service indica que una clase realiza tareas relacionadas con la lógica del negocio, ademas Spring las registra como beans
public class BookServiceImp implements IBookService{

	private List<Book> booksList = new ArrayList<Book>() {{
	    add(new Book(1, "El principito", "Antoine de Saint-Exupéry", 15.5));
	    add(new Book(2, "Cien años de soledad", "Gabriel García Márquez", 25));
	}};
	
	@Override
	public Book buscar(int id) {
		Book foundBook = null;
		for(Book b : booksList) {
			if(b.getId() == id) {
				foundBook = b;
				break;
			}
		}
		return foundBook;
	}

	@Override
	public List<Book> listar() {
		
		return booksList;
	}
	
}
