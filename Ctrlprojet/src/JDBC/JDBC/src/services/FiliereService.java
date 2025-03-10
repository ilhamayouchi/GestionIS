/*
 * Service de gestion des filières dans la base de données.
 * Cette classe implémente les opérations CRUD pour l'entité Filiere.
 */

package services;

import beans.Filiere;
import connexion.Connexion;
import dao.IDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe FiliereService qui implémente l'interface IDao pour gérer les objets Filiere.
 */
public class FiliereService implements IDao<Filiere> {

    // Instance unique de connexion à la base de données (Singleton)
    private Connexion connexion;

    /**
     * Constructeur de la classe FiliereService.
     * Initialise la connexion à la base de données via le singleton Connexion.
     */
    public FiliereService() {
        connexion = Connexion.getInstance();
    }

    /**
     * Ajoute une nouvelle filière à la base de données.
     * @param o L'objet Filiere à ajouter.
     * @return true si l'insertion est réussie, sinon false.
     */
    @Override
    public boolean create(Filiere o) {
        String req = "INSERT INTO filiere VALUES (NULL, '" + o.getCode() + "','" + o.getLibelle() + "')";
        try {
            Statement st = connexion.getCn().createStatement();
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); // Affichage du message d'erreur SQL
        }
        return false;
    }

    /**
     * Supprime une filière de la base de données en fonction de son ID.
     * @param o L'objet Filiere à supprimer.
     * @return true si la suppression est réussie, sinon false.
     */
    @Override
    public boolean delete(Filiere o) {
        String req = "DELETE FROM filiere WHERE id = " + o.getId();
        try {
            Statement st = connexion.getCn().createStatement();
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); // Affichage du message d'erreur SQL
        }
        return false;
    }

    /**
     * Met à jour les informations d'une filière existante.
     * @param o L'objet Filiere avec les nouvelles valeurs.
     * @return true si la mise à jour est réussie, sinon false.
     */
    @Override
    public boolean update(Filiere o) {
        String req = "UPDATE filiere SET code ='" + o.getCode() + "', libelle='" + o.getLibelle() + "' WHERE id  = " + o.getId();
        try {
            Statement st = connexion.getCn().createStatement();
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); // Affichage du message d'erreur SQL
        }
        return false;
    }

    /**
     * Recherche une filière dans la base de données en fonction de son ID.
     * @param id L'identifiant de la filière recherchée.
     * @return L'objet Filiere correspondant ou null si non trouvé.
     */
    @Override
    public Filiere findById(int id) {
        String req = "SELECT * FROM filiere WHERE id = " + id;
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {
                return new Filiere(rs.getInt("id"), rs.getString("code"), rs.getString("libelle"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); // Affichage du message d'erreur SQL
        }
        return null;
    }

    /**
     * Récupère la liste de toutes les filières stockées dans la base de données.
     * @return Liste des objets Filiere.
     */
    @Override
    public List<Filiere> findAll() {
        List<Filiere> filieres = new ArrayList<>();
        String req = "SELECT * FROM filiere";
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                filieres.add(new Filiere(rs.getInt("id"), rs.getString("code"), rs.getString("libelle")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); // Affichage du message d'erreur SQL
        }
        return filieres;
    }
}
