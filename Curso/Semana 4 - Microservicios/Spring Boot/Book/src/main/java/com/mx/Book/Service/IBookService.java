package com.mx.Book.Service;

import java.util.List;

import com.mx.Book.Entity.Book;

public interface IBookService {
	public Book buscar(int id);
	public List<Book> listar();
}
