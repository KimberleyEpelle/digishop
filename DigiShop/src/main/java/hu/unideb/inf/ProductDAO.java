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

/**
 *
 * @author KIMBERLET EPELLE
 */
public interface ProductDAO extends AutoCloseable{
     public void saveProduct(AddProducts a);
     public void deleteProduct(AddProducts a);
      public void updateProduct(AddProducts a);
       public List<AddProducts> getProducts();
       public List<Category> getCategory();
        public List<Sales> getSales();
}
   
