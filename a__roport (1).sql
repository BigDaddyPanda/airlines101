-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Dim 22 Avril 2018 à 14:43
-- Version du serveur :  10.1.21-MariaDB
-- Version de PHP :  7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `aéroport`
--

-- --------------------------------------------------------

--
-- Structure de la table `aeroport`
--

CREATE TABLE `aeroport` (
  `immatricul` int(11) NOT NULL,
  `nom` varchar(2000) DEFAULT NULL,
  `adresse` varchar(2000) DEFAULT NULL,
  `pays` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `avion`
--

CREATE TABLE `avion` (
  `idavion` int(11) NOT NULL,
  `nom` varchar(2000) NOT NULL,
  `marque` varchar(2000) NOT NULL,
  `companie` varchar(2000) NOT NULL,
  `maint` varchar(2000) NOT NULL,
  `type` varchar(2000) NOT NULL,
  `nombrepassager` int(11) NOT NULL,
  `nombrepersonnel` int(11) NOT NULL,
  `massemax` int(11) NOT NULL,
  `volumemax` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idclient` int(11) NOT NULL,
  `nom` varchar(2000) NOT NULL,
  `prenom` varchar(2000) NOT NULL,
  `datenaissance` date NOT NULL,
  `numeropasseport` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

CREATE TABLE `pays` (
  `id` int(11) NOT NULL,
  `libelle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE `personnel` (
  `idpersonnel` int(11) NOT NULL,
  `nom` varchar(2000) NOT NULL,
  `prenom` varchar(2000) NOT NULL,
  `age` int(11) NOT NULL,
  `maxsomme` int(11) DEFAULT NULL,
  `nbrheure` int(11) DEFAULT NULL,
  `type` varchar(2000) NOT NULL,
  `idvol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `idclient` int(11) NOT NULL,
  `idvol` int(11) NOT NULL,
  `statut` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `vol`
--

CREATE TABLE `vol` (
  `idvol` int(11) NOT NULL,
  `depart` varchar(2000) NOT NULL,
  `arrive` varchar(2000) NOT NULL,
  `heuredepart` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `heurearrive` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `type` varchar(2000) NOT NULL,
  `idavion` int(11) NOT NULL,
  `idaeroport` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `aeroport`
--
ALTER TABLE `aeroport`
  ADD PRIMARY KEY (`immatricul`),
  ADD KEY `pays` (`pays`);

--
-- Index pour la table `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`idavion`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idclient`);

--
-- Index pour la table `pays`
--
ALTER TABLE `pays`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD PRIMARY KEY (`idpersonnel`),
  ADD KEY `c2` (`idvol`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`idclient`,`idvol`);

--
-- Index pour la table `vol`
--
ALTER TABLE `vol`
  ADD PRIMARY KEY (`idvol`),
  ADD KEY `c3` (`idavion`),
  ADD KEY `c4` (`idaeroport`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `avion`
--
ALTER TABLE `avion`
  MODIFY `idavion` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `pays`
--
ALTER TABLE `pays`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `personnel`
--
ALTER TABLE `personnel`
  MODIFY `idpersonnel` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `aeroport`
--
ALTER TABLE `aeroport`
  ADD CONSTRAINT `aeroport_ibfk_1` FOREIGN KEY (`pays`) REFERENCES `pays` (`id`);

--
-- Contraintes pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD CONSTRAINT `c2` FOREIGN KEY (`idvol`) REFERENCES `vol` (`idvol`);

--
-- Contraintes pour la table `vol`
--
ALTER TABLE `vol`
  ADD CONSTRAINT `c3` FOREIGN KEY (`idavion`) REFERENCES `avion` (`idavion`),
  ADD CONSTRAINT `c4` FOREIGN KEY (`idaeroport`) REFERENCES `aeroport` (`immatricul`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
