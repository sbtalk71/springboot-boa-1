package org.demo.spring;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository implements DataRepository {

	@Override
	public String save(Book book) {
		System.out.println(book);
		return "Book saved";
	}

}
