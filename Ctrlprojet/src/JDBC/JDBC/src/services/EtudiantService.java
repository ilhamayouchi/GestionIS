/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.EGenre;
import beans.Etudiant;
import connexion.Connexion;
import dao.IDao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a
 */
public class EtudiantService implements IDao<Etudiant>{

    private Connexion connexion;
    private FiliereService fs;
    

    public EtudiantService() {
        connexion = Connexion.getInstance();
        fs = new FiliereService();
    }
    
    @Override
    public boolean create(Etudiant o) {
        String req = "insert into Etudiant (id, nom, prenom, dateNaissance, genre, filiere) values (null, ?, ?, ?, ?, ?)"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setDate(3, new Date(o.getDateNaissance().getTime()));
            ps.setString(4, o.getGenre().toString());
            ps.setInt(5, o.getFiliere().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Etudiant o) {
        String req = "delete from Etudiant where id = ?"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Etudiant o) {
        String req = "update etudiant set nom = ?, prenom = ?, dateNaissance = ?, genre = ?, filiere = ? where id  = ?"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setDate(3, new Date(o.getDateNaissance().getTime()));
            ps.setString(4, o.getGenre().toString());
            ps.setInt(5, o.getFiliere().getId());
            ps.setInt(6, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Etudiant findById(int id) {
        String req = "select * from Etudiant where id  = ?"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getDate("dateNaissance"), EGenre.valueOf(rs.getString("genre")), fs.findById(rs.getInt("filiere")));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant>  etudiants = new ArrayList<>();
        String req = "select * from Etudiant"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                etudiants.add(new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getDate("dateNaissance"), EGenre.valueOf(rs.getString("genre")), fs.findById(rs.getInt("filiere"))));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return etudiants;
    }
    
}
