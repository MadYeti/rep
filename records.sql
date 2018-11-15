-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Ноя 15 2018 г., 13:01
-- Версия сервера: 5.5.25
-- Версия PHP: 5.2.12

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `apps`
--

-- --------------------------------------------------------

--
-- Структура таблицы `records`
--

CREATE TABLE IF NOT EXISTS `records` (
  `Position` int(10) NOT NULL,
  `Nickname` varchar(20) NOT NULL,
  `Score` int(10) NOT NULL,
  PRIMARY KEY (`Position`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `records`
--

INSERT INTO `records` (`Position`, `Nickname`, `Score`) VALUES
(1, 'Mad Yeti', 56),
(2, '9789879978', 65),
(3, 'Nickname', 71),
(4, 'qwerty', 72),
(5, 'vbvbbvbv', 73),
(6, 'ZXCV', 74),
(7, 'eriutuerite', 85),
(8, 'm,xcvbxc', 88),
(9, 'bodya', 100),
(10, 'abracadabra', 105);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
