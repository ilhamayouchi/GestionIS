/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;
import java.util.List;
/**
 *
 * @author hp
 * @param <T>
 */
public interface Idoa <T> {
    boolean create (T o);
    boolean delete (T o);
    boolean update (T o);
    T findById (int  id);
    List<T> findAll ();
    
    
    
}
