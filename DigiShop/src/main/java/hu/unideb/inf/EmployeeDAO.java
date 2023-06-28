/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

import hu.unideb.inf.model.Employee;
import java.util.List;

/**
 *
 * @author KIMBERLET EPELLE
 */
public interface EmployeeDAO extends AutoCloseable{
       public void saveEmployee(Employee a);
       public void deleteEmployee(Employee a);
         public void updateEmployee(Employee a);
    public List<Employee> getEmployee();
}
