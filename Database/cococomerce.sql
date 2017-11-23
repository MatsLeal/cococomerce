-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 10-11-2017 a las 02:10:37
-- Versión del servidor: 5.7.19
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cocomarket`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--
create database if not exists cocomarket;

use cocomarket;

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `donaciones`
--

DROP TABLE IF EXISTS `donaciones`;
CREATE TABLE IF NOT EXISTS `donaciones` (
  `id_donador` int(11) NOT NULL,
  `id_beneficiado` int(11) NOT NULL,
  `hora_donacion` datetime NOT NULL,
  `id_producto` int(11) NOT NULL,
  `id_donacion` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_donacion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

DROP TABLE IF EXISTS `mensaje`;
CREATE TABLE IF NOT EXISTS `mensaje` (
  `id_mensaje` int(11) NOT NULL AUTO_INCREMENT,
  `id_donante` int(11) NOT NULL,
  `id_solicitante` int(11) NOT NULL,
  `mensaje` text NOT NULL,
  PRIMARY KEY (`id_mensaje`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `descripcion` text NOT NULL,
  `indiceimagen` longblob NOT NULL,
  `bloqueada` tinyint(1) NOT NULL,
  `fecha_update_producto` datetime NOT NULL,
  `usuario_ofertor` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_bloqueados`
--

DROP TABLE IF EXISTS `productos_bloqueados`;
CREATE TABLE IF NOT EXISTS `productos_bloqueados` (
  `id_producto` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `descripcion_bloqueo` text NOT NULL,
  `fecha_bloqueo` datetime NOT NULL,
  `id_bloqueo` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_bloqueo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_pedido`
--

DROP TABLE IF EXISTS `producto_pedido`;
CREATE TABLE IF NOT EXISTS `producto_pedido` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `id_donante` int(11) NOT NULL,
  `id_solicitante` int(11) NOT NULL,
  `ganador` tinyint(1) NOT NULL,
  `fecha_pedido` datetime NOT NULL,
  `id_producto` int(11) NOT NULL,
  PRIMARY KEY (`id_pedido`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------


-- Conversacioones y  mensajes


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



--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) NOT NULL,
  `clave` varchar(20) NOT NULL,
  `correo` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
