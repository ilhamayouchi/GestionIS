/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.EGenre;
import beans.Etudiant;
import beans.Filiere;
import java.util.Date;
import services.EtudiantService;
import services.FiliereService;

/**
 *
 * @author a
 */
public class Test {
    public static void main(String[] args) {
        FiliereService fs = new FiliereService();
        EtudiantService es = new EtudiantService();
//fs.create(new Filiere("comp", "comptabilité"));
        //fs.create(new Filiere("GC", "Geneie civil"));
    
       // fs.delete(fs.findById(2));
        
//        Filiere f  = fs.findById(1);
//        f.setCode("xxxx");
//        f.setLibelle("xxxx");
//        fs.update(f);
        
//        for(Filiere f : fs.findAll())
//            System.out.println(f.getCode());
    
    
        //es.create(new Etudiant("Rami", "Amal", new Date(), EGenre.Femme, fs.findById(3)));
    
        //System.out.println(es.findById(1).getNom());
    
        es.delete(es.findById(1));
    
        for(Etudiant e : es.findAll())
            System.out.println(e.getNom());
    }
          
}
