-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-11-2017 a las 18:00:09
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `coquito`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conversacion`
--

CREATE TABLE `conversacion` (
  `id_conversacion` int(11) NOT NULL,
  `id_destinatario` int(11) NOT NULL,
  `id_remitente` int(11) NOT NULL,
  `id_mensaje` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `conversacion`
--

INSERT INTO `conversacion` (`id_conversacion`, `id_destinatario`, `id_remitente`, `id_mensaje`) VALUES
(1, 1, 2, 1),
(2, 4, 1, 5),
(3, 5, 1, 9),
(6, 2, 9, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE `mensaje` (
  `id_msg` int(11) NOT NULL,
  `id_conversacion` int(11) NOT NULL,
  `mensaje` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `mensaje`
--

INSERT INTO `mensaje` (`id_msg`, `id_conversacion`, `mensaje`) VALUES
(1, 1, 'hola'),
(2, 1, 'hola :0'),
(3, 2, 'hola ;)'),
(4, 2, 'que tal?'),
(5, 1, 'asdj'),
(6, 0, 'popo'),
(7, 0, 'coco'),
(8, 0, 'qweqwe'),
(9, 3, ''),
(10, 3, 'hola muerte'),
(11, 2, 'como estas'),
(12, 2, 'yo bien, y tu?'),
(13, 2, 'yo bien, y tu?'),
(14, 2, ''),
(15, 2, 'excelente'),
(16, 2, 'genial'),
(17, 3, 'que?'),
(18, 3, 'nada :c'),
(19, 3, 'askdsjah te odio >:c'),
(20, 3, 'perdon :c'),
(21, 2, 'y que haces?'),
(22, 2, 'DDASDASD'),
(23, 3, 'KHKJ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_persona` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_persona`, `nombre`) VALUES
(1, 'Andrea'),
(2, 'popo'),
(3, 'popo2'),
(4, 'laksjd'),
(5, 'muerte');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `conversacion`
--
ALTER TABLE `conversacion`
  ADD PRIMARY KEY (`id_conversacion`);

--
-- Indices de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD PRIMARY KEY (`id_msg`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_persona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `conversacion`
--
ALTER TABLE `conversacion`
  MODIFY `id_conversacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  MODIFY `id_msg` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
