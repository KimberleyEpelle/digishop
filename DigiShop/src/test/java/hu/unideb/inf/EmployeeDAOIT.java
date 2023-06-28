/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

import hu.unideb.inf.model.Employee;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author KIMBERLET EPELLE
 */
public class EmployeeDAOIT {
    
    public EmployeeDAOIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
final EntityManager entityManager = entityManagerFactory.createEntityManager();
 
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of saveEmployee method, of class EmployeeDAO.
     */
    @Test
    public void testSaveEmployee() {
        System.out.println("saveEmployee");
        
        Employee a = new Employee();
        EmployeeDAO instance = new EmployeeDAOImpl();
        
        instance.saveEmployee(a);
       
    }

    /**
     * Test of deleteEmployee method, of class EmployeeDAO.
     */
    @Test
    public void testDeleteEmployee() {
        System.out.println("deleteEmployee");
        Employee a = new Employee();
        EmployeeDAO instance = new EmployeeDAOImpl();
        instance.deleteEmployee(a);
       
    }

    /**
     * Test of updateEmployee method, of class EmployeeDAO.
     */
    @Test
    public void testUpdateEmployee() {
        System.out.println("updateEmployee");
    Employee a = new Employee();
        EmployeeDAO instance = new EmployeeDAOImpl();
        instance.updateEmployee(a);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployee method, of class EmployeeDAO.
     */
    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        EmployeeDAO instance = new EmployeeDAOImpl();
        List<Employee> expResult = instance.getEmployee();
        List<Employee> result = instance.getEmployee();
        assertEquals(expResult.get(0).getId(), result.get(0).getId());
       
    }

    public class EmployeeDAOImpl implements EmployeeDAO {

        

        public void saveEmployee(Employee a) {
            a.setName("fati");
        a.setAddress("junr");
        a.setCity("king");
        Date n=new Date();
        a.setDob(n.toString());
        a.setEmail("rew");
        a.setPosition(Employee.RankType.Admin);
        a.setSurname("lope");
        a.setEmploymentDate(n);
        a.setGender("female");
        a.setStatus("married");
        
        }
final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
final EntityManager entityManager = entityManagerFactory.createEntityManager();
 
        public void deleteEmployee(Employee a) {
        }

        public void updateEmployee(Employee a) {
        }

        public List<Employee> getEmployee() {
             TypedQuery<Employee> query
              = entityManager.createQuery("SELECT a FROM Employee a",Employee.class);
    
           List<Employee> as = query.getResultList();
            return as;
        }

        @Override
        public void close() throws Exception {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
