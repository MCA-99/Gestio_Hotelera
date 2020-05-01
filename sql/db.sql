-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql
-- Tiempo de generación: 01-05-2020 a las 17:04:08
-- Versión del servidor: 10.4.12-MariaDB-1:10.4.12+maria~bionic
-- Versión de PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Contrata`
--

CREATE TABLE `Contrata` (
  `id_client` int(9) NOT NULL,
  `id_servei` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla Contrata';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Habitacions`
--

CREATE TABLE `Habitacions` (
  `id_habitacio` int(11) NOT NULL,
  `planta` int(5) NOT NULL,
  `preu` int(9) NOT NULL,
  `estat` varchar(30) CHARACTER SET utf8 NOT NULL,
  `tipus` varchar(500) CHARACTER SET utf8 NOT NULL,
  `descripcio` varchar(1000) CHARACTER SET utf8 NOT NULL,
  `caracteristiques` varchar(1000) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla Habitacions';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Reserva`
--

CREATE TABLE `Reserva` (
  `id_reserva` int(11) NOT NULL,
  `id_habitacio` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `treballador` varchar(30) NOT NULL,
  `tipus_reserva` varchar(50) NOT NULL,
  `cost` int(11) NOT NULL,
  `estat_reserva` varchar(50) NOT NULL,
  `data_entrada` date NOT NULL,
  `data_sortida` date NOT NULL,
  `hora_entrada` time NOT NULL,
  `hora_sortida` time NOT NULL,
  `id_treballador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla Reserva Habitacio';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Serveis`
--

CREATE TABLE `Serveis` (
  `id_servei` int(11) NOT NULL,
  `nom` int(11) NOT NULL,
  `preu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla Serveis';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuaris`
--

CREATE TABLE `Usuaris` (
  `id_usuari` int(11) NOT NULL,
  `nom_usuari` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `contrasenya` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `nom` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `cognom1` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `cognom2` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `DNI` varchar(9) CHARACTER SET utf8 DEFAULT NULL,
  `passaport` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `nacionalitat` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `telefon` int(9) DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `estatcivil` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `ocupacio` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `rol` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT 0,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla Usuaris';

--
-- Volcado de datos para la tabla `Usuaris`
--

INSERT INTO `Usuaris` (`id_usuari`, `nom_usuari`, `contrasenya`, `nom`, `cognom1`, `cognom2`, `DNI`, `passaport`, `nacionalitat`, `telefon`, `email`, `estatcivil`, `ocupacio`, `rol`, `activo`, `timestamp`) VALUES
(1, 'admin', 'admin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2020-04-30 13:20:53'),
(2, 'test', '098f6bcd4621d373cade4e832627b4f6', 'test', 'test', 'test', 'test', 'test', 'test', 665112212, 'test', NULL, NULL, 'rep', 0, '2020-05-01 17:02:29');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Habitacions`
--
ALTER TABLE `Habitacions`
  ADD PRIMARY KEY (`id_habitacio`);

--
-- Indices de la tabla `Reserva`
--
ALTER TABLE `Reserva`
  ADD PRIMARY KEY (`id_reserva`);

--
-- Indices de la tabla `Serveis`
--
ALTER TABLE `Serveis`
  ADD PRIMARY KEY (`id_servei`);

--
-- Indices de la tabla `Usuaris`
--
ALTER TABLE `Usuaris`
  ADD PRIMARY KEY (`id_usuari`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Usuaris`
--
ALTER TABLE `Usuaris`
  MODIFY `id_usuari` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
