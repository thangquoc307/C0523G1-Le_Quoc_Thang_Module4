package com.repository;
import com.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
@org.springframework.stereotype.Repository
public class Repository implements IRepository{

    @Override
    public List<Product> getAll() {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> productTypedQuery = session.createQuery("from Product", Product.class);
        return productTypedQuery.getResultList();
    }

    @Override
    public void create(Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            session.save(product);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void edit(int index, Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();

            Product productEdit = findById(index);
            System.out.println(productEdit);

            productEdit.setName(product.getName());
            productEdit.setDescription(product.getDescription());
            productEdit.setManufacture(product.getManufacture());
            productEdit.setPrice(product.getPrice());
            System.out.println(productEdit);

            session.merge(productEdit);
            transaction.commit();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void delete(int index) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            Product productDel = findById(index);
            session.delete(productDel);
            transaction.commit();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Product detail(int index) {
        return findById(index);
    }

    @Override
    public List<Product> search(String keyword) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> listSearch = session.createQuery("from Product where name like :key", Product.class);
        listSearch.setParameter("key", "%" + keyword + "%");
        return listSearch.getResultList();
    }

    @Override
    public Product findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> productTypedQuery = session.createQuery("from Product where id = :id", Product.class);
        productTypedQuery.setParameter("id", id);
        return productTypedQuery.getSingleResult();
    }
}
