package com.cts.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.entity.Book;

@Repository("bookDao")
public class BookDAOImpl implements BookDAO {

	
	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public void saveBook(Book book) {
		Session currentSession = sessionfactory.getCurrentSession();
		currentSession.saveOrUpdate(book);
	}

	@Override
	public List<Book> listBooks() {
		System.out.println(sessionfactory);
		Session session = sessionfactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<Book> createQuery = criteriaBuilder.createQuery(Book.class);
		Root<Book>root=createQuery.from(Book.class);
		createQuery.select(root);
		Query<Book> query = session.createQuery(createQuery);
		return query.getResultList();
	}

	@Override
	public Book getBook(int id) {
		Session currentSession = sessionfactory.getCurrentSession();
		Book book = currentSession.get(Book.class, id);
		return book;
	}

	@Override
	public void deleteBook(int id) {
		Session currentSession = sessionfactory.getCurrentSession();
		Book load = currentSession.byId(Book.class).load(id);
		currentSession.delete(load);
		
	}

}
