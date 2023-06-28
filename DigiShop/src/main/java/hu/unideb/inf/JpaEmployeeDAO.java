/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

import hu.unideb.inf.model.Employee;
import hu.unideb.inf.model.Login_User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author KIMBERLET EPELLE
 */
public class JpaEmployeeDAO implements EmployeeDAO{
final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
final EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public void saveEmployee(Employee a) {
   entityManager.getTransaction().begin();
    entityManager.persist(a);
    entityManager.getTransaction().commit(); }

    @Override
    public void deleteEmployee(Employee a) {
    entityManager.getTransaction().begin();
    entityManager.remove(a);
    entityManager.getTransaction().commit();  }

    @Override
    public void updateEmployee(Employee a) {
    saveEmployee(a);
    }
    
      public void saveUser(Login_User a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Employee> getEmployee() {
      TypedQuery<Employee> query
              = entityManager.createQuery("SELECT a FROM Employee a",Employee.class);
    List<Employee> as = query.getResultList();
    return as;
    }

    @Override
    public void close() throws Exception {
   entityManager.close();
   entityManagerFactory.close();
    }
    
}

