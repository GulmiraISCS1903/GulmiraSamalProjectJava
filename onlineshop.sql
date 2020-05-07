-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Май 08 2020 г., 01:55
-- Версия сервера: 10.4.11-MariaDB
-- Версия PHP: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `onlineshop`
--

-- --------------------------------------------------------

--
-- Структура таблицы `products`
--

CREATE TABLE `products` (
  `idproducts` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `quality` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  `weight` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `products`
--

INSERT INTO `products` (`idproducts`, `name`, `quality`, `date`, `price`, `weight`) VALUES
(1, 'alma', 'good', '07.05.2020', 550, 15),
(2, 'grusha', 'exc', '2020', 500, 12),
(3, 'rasp', 'ss', '2121', 362, 0),
(4, 'aaaaaa', 'aaa', 'aaa', 15, 36),
(5, 'qiwi', 'good', '08.05.2020', 900, 16),
(6, 'banana', 'exc', '08.05.2020', 950, 21);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `idusers` int(11) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `location` varchar(30) NOT NULL,
  `gender` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`idusers`, `firstname`, `lastname`, `username`, `password`, `location`, `gender`) VALUES
(1, 'gu', 'lm', 'aa', 'aa', 'ir', 'Female'),
(2, 'q', 'q', 'q', 'q', 'q', 'Female'),
(3, 'w', 'w', 'w', 'w', 'w', 'Female'),
(4, 'gulmira', 'samal', 'admin', '12345', 'kz', 'Female'),
(5, 'hh', 'hhhh', 'admin', '12345', 'hh', 'Male'),
(6, 'dkhb', 'lsj', 'admin', '12345', 'djvabkl', 'Male'),
(7, 'jkdbs', 'msdmjkb', 'admin', '12345', 'asnkl', 'Male'),
(8, '', '', '', '', '', 'Female'),
(9, 'a', 'a', 'a', 'a', 'a', 'Female'),
(10, 'gh', 'gh', 'gh', 'gh', 'gh', 'Female'),
(11, 'sbhd', 'sjdfk', 'admin', '12345', 'sdfn', 'Male'),
(12, 'sdvbj', 'sdjvb', 'admin', '12345', 'dsjvk', 'Male'),
(13, 'awbhd', ' sfn sfj', 'admin', '12345', 'jsab', 'Male'),
(14, 'sd', 'sca', 'admin', '12345', 'cn', 'Female'),
(15, 'djs', 'jdskb', 'jdsbjkdb', 'dshv', 'jdf', 'Male'),
(16, 'bv', 'nb', 'njbjh', 'jhj', 'bj', 'Female'),
(17, 'qwerty', 'qwerty', 'qwerty', 'qwerty', 'qwerty', 'Female'),
(18, 'qwerty', 'qwerty', 'admin', '12345', 'qwerty', 'Female');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`idproducts`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`idusers`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `products`
--
ALTER TABLE `products`
  MODIFY `idproducts` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `idusers` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
