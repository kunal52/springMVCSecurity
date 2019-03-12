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

import com.cts.entity.Product;

@Repository("productDao")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addProduct(Product product) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(product);
		
	}

	@Override
	public List<Product> getProductList() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<Product> createQuery = criteriaBuilder.createQuery(Product.class);
		Root<Product>root=createQuery.from(Product.class);
		createQuery.select(root);
		Query<Product> query = session.createQuery(createQuery);
		return query.getResultList();
	}

	@Override
	public Product getProduct(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Product product = currentSession.get(Product.class, id);
		return product;
	}

	@Override
	public void deleteProduct(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Product load = currentSession.byId(Product.class).load(id);
		currentSession.delete(load);

	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub

	}

}
