--Table pour les vols
CREATE DATABASE airfrance;

CREATE TABLE Vol (
    id_vol INT PRIMARY KEY AUTO_INCREMENT,
    numero_vol VARCHAR(20) NOT NULL
);

--Table pour les billets
CREATE TABLE Billet (
    id_billet INT PRIMARY KEY AUTO_INCREMENT,
    ref_billet VARCHAR(20) NOT NULL,
    id_vol INT,
    FOREIGN KEY (id_vol) REFERENCES Vol(id_vol)
);


--Insérer des données dans la table Vol
INSERT INTO Vol (numero_vol) VALUES
('AF1234'),
('AF2345'),
('AF3456'),
('AF4567'),
('AF5678'),
('AF6789'),
('AF7890'),
('AF8901'),
('AF9012'),
('AF0123'),
('AF1235'),
('AF2346'),
('AF3457'),
('AF4568'),
('AF5679');

-- Insérer des données dans la table Billet
INSERT INTO Billet (ref_billet, id_vol) VALUES
('BIL001', 1),
('BIL002', 1),
('BIL003', 2),
('BIL004', 2),
('BIL005', 3),
('BIL006', 3),
('BIL007', 4),
('BIL008', 4),
('BIL009', 5),
('BIL010', 5),
('BIL011', 6),
('BIL012', 6),
('BIL013', 7),
('BIL014', 8),
('BIL015', 9);
