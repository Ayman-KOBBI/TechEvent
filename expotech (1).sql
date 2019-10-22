-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 22 oct. 2019 à 22:02
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `expotech`
--

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `id_comm` int(11) NOT NULL,
  `id_article` int(11) NOT NULL,
  `date_comm` date NOT NULL,
  `heure_comm` time NOT NULL,
  `Text` text NOT NULL,
  PRIMARY KEY (`id_comm`),
  KEY `id_article` (`id_article`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `events`
--

DROP TABLE IF EXISTS `events`;
CREATE TABLE IF NOT EXISTS `events` (
  `id_ev` int(11) NOT NULL AUTO_INCREMENT,
  `id_org` int(11) NOT NULL,
  `lieu` varchar(50) NOT NULL,
  `nb_place` int(11) NOT NULL,
  `dt_event` date NOT NULL,
  `h_event` varchar(50) NOT NULL,
  `prix` int(11) NOT NULL,
  `image` varchar(50) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id_ev`),
  KEY `id_org` (`id_org`)
) ENGINE=MyISAM AUTO_INCREMENT=80 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `events`
--

INSERT INTO `events` (`id_ev`, `id_org`, `lieu`, `nb_place`, `dt_event`, `h_event`, `prix`, `image`, `description`) VALUES
(1, 0, 'toz', 5, '2019-02-01', '09:00:00', 2, '', 'ahmed'),
(79, 11, 'mjez', 8, '2019-01-28', '08:00', 70, 'm', 'esprit');

-- --------------------------------------------------------

--
-- Structure de la table `forum`
--

DROP TABLE IF EXISTS `forum`;
CREATE TABLE IF NOT EXISTS `forum` (
  `id_article` int(11) NOT NULL,
  `id_ev` int(11) NOT NULL,
  `id_org` int(11) NOT NULL,
  `date_cr` date NOT NULL,
  `heure_cr` time NOT NULL,
  `lieu` varchar(50) NOT NULL,
  `image` varchar(50) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id_article`),
  KEY `id_ev` (`id_ev`,`id_org`,`lieu`,`image`,`description`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `organisateur`
--

DROP TABLE IF EXISTS `organisateur`;
CREATE TABLE IF NOT EXISTS `organisateur` (
  `id_org` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tel` varchar(50) NOT NULL,
  PRIMARY KEY (`id_org`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `participant`
--

DROP TABLE IF EXISTS `participant`;
CREATE TABLE IF NOT EXISTS `participant` (
  `id_par` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tel` varchar(50) NOT NULL,
  `solde` float NOT NULL,
  PRIMARY KEY (`id_par`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `participant`
--

INSERT INTO `participant` (`id_par`, `nom`, `prenom`, `email`, `tel`, `solde`) VALUES
(10, 'aaaa', 'bbbb', 'cccc', 'dddd', 20),
(11, 'ayman', 'kobbi', '6546', 'eaemail', 36);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id_ticket` int(11) NOT NULL AUTO_INCREMENT,
  `id_ev` int(11) NOT NULL,
  `id_par` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `image` varchar(50) NOT NULL,
  PRIMARY KEY (`id_ticket`),
  KEY `id_ev` (`id_ev`),
  KEY `id_par` (`id_par`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id_ticket`, `id_ev`, `id_par`, `nom`, `prenom`, `image`) VALUES
(1, 1, 11, 'ayman', 'kobbi', 'image.jpg');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
