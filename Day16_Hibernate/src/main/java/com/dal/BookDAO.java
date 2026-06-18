package com.dal;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pojo.Book;
import com.util.HibUtil;

public class BookDAO {
	
	private SessionFactory sf;
	// CRUD
	// getAllBooks

	public void addBook(Book book) {

		Session session = HibUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.persist(book);

		tx.commit();
		session.close();
	}

	public List<Book> getAllBooks() {
		
		Session session = HibUtil.getSessionFactory().openSession();
		Query<Book> qry = session.createQuery("from Book");
		
		List<Book> myBk = qry.list();
		
		
		

		List<Book> list = session.createQuery("from Book", Book.class).list();

		session.close();

		return list;
		
		// 
	}

	public Book getBookById(int id) {

		Session session = HibUtil.getSessionFactory().openSession();

		Book book = session.get(Book.class, id);

		session.close();

		return book;
	}

	public void updateBook(Book book) {

		Session session = HibUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.merge(book);

		tx.commit();
		session.close();
	}

	public void deleteBook(int id) {

		Session session = HibUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Book book = session.get(Book.class, id);

		if (book != null) {
			session.remove(book);
		}

		tx.commit();
		session.close();
	}

			public List<Book> getBookByAuthor(String author) {
				Session session = sf.getCurrentSession();
				session.beginTransaction();
				
				// sql: select*from Book where author=?
				
				
				String hq1 = "from Book bk where bk.author=?1";
				Query qry = session.createQuery(hq1);
				javax.persistence.Query query = null;
				query.setParameter(1, author);
				
				List<Book> list=query.getResultList();
				return list;
			}
}


