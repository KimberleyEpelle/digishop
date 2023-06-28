/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

import hu.unideb.inf.model.AddProducts;
import hu.unideb.inf.model.Category;
import hu.unideb.inf.model.Sales;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author KIMBERLET EPELLE
 */
public class JPAproductDAO implements ProductDAO{
final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
final EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public void saveProduct(AddProducts a) {
    entityManager.getTransaction().begin();
    entityManager.persist(a);
    entityManager.getTransaction().commit(); 
    }

    @Override
    public void deleteProduct(AddProducts a) {
    entityManager.getTransaction().begin();
    entityManager.remove(a);
    entityManager.getTransaction().commit(); 
    }

    @Override
    public void updateProduct(AddProducts a) {
    saveProduct(a);
    }
    
    public void saveCategory(Category a) {
    entityManager.getTransaction().begin();
    entityManager.persist(a);
    entityManager.getTransaction().commit(); 
    }

    public void saveSales(Sales a) {
    entityManager.getTransaction().begin();
    entityManager.persist(a);
    entityManager.getTransaction().commit(); 
    }

    
    @Override
    public List<AddProducts> getProducts() {
    TypedQuery<AddProducts> query
         = entityManager.createQuery("SELECT a FROM AddProducts a",AddProducts.class);
    List<AddProducts> prod = query.getResultList();
    return prod;
    }

    @Override
    public List<Category> getCategory() {
    TypedQuery<Category> query
              = entityManager.createQuery("SELECT a FROM Category a",Category.class);
    List<Category> as = query.getResultList();
    return as;
    }

   

    @Override
    public List<Sales> getSales() {
   TypedQuery<Sales> query
              = entityManager.createQuery("SELECT a FROM Sales a",Sales.class);
    List<Sales> as = query.getResultList();
    return as;
    }
     @Override
    public void close() throws Exception {
    entityManager.close();
    entityManagerFactory.close();
    }
}
