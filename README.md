"# Gestion_infrastructure_scolaire" 
CREATE TABLE Salle (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    type VARCHAR(50),
    capacite INT
);
CREATE TABLE Équipement (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    type VARCHAR(50),
    etat VARCHAR(50)
);
