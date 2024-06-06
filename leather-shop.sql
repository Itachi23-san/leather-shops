-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Хост: localhost:8889
-- Время создания: Июн 06 2024 г., 17:25
-- Версия сервера: 5.7.24
-- Версия PHP: 8.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `leather-shop`
--

-- --------------------------------------------------------

--
-- Структура таблицы `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `category`
--

INSERT INTO `category` (`id`, `image`, `name`) VALUES
(1, 'https://psv4.userapi.com/c909618/u185911093/docs/d46/37266ad48c48/belts.png?extra=---0q7sfpYDn1NFXjjm66dZM05r2VGFJrJSxSjfvLnjyP5XQcEAxa9zxP80C_02vJWQdxRlKHZwAYFFlmdsYftxUXQzhW58fxGP3Y8QhG7X3cdN1qzH5LpXAMZJNQMGVinvq3KQKIT7kfjoeHGcu4RU5hA', 'Ремни'),
(3, 'https://psv4.userapi.com/c909618/u185911093/docs/d29/c083bd3d14a0/bag.png?extra=tvWAE9LFhR35mab6I7rL6RLc3zY5RO6HBFeBmkztaU6lAvsQNNXUsqtotvoPccfCVBmpTzw9o8QsQp_oHf6KZBSbZdhyckwgyXRerMggFatU508QLReWO81n5AWAWNC8RyBqpqR8ehoNr85GGVifMpPQww', 'Сумки'),
(4, 'https://psv4.userapi.com/c909618/u185911093/docs/d1/b33c9c04abeb/holder.png?extra=NqMmsbttv9m8joUA6I7XQ8eUB83EmMVg14P24DzsDPTX_aX3mm9bMSJuNtplW0HLcIdJAkXIRgck7F47_wFeMwiBf9RIZUunbiAvDMFCF9QnZv9g-Dodm2TiAjDRaqjE5ZA5h9hR8AUW09uwSjKDpZtouQ', 'Картхолдеры');

-- --------------------------------------------------------

--
-- Структура таблицы `customer_order`
--

CREATE TABLE `customer_order` (
  `id` bigint(20) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `customer_order`
--

INSERT INTO `customer_order` (`id`, `comment`, `name`, `phone`, `item_id`) VALUES
(1, 'Коментарий', 'ФИО', '+79998787777', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `item`
--

CREATE TABLE `item` (
  `id` bigint(20) NOT NULL,
  `characteristics` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `item`
--

INSERT INTO `item` (`id`, `characteristics`, `description`, `category`, `color`, `image`, `price`, `size`, `title`) VALUES
(1, '100% кожа', 'Описание', 'Ремни', 'clr-1', 'C:\\Users\\danii\\leather-shop\\src\\img\\eye.png', 6000, 'sz-1', 'Первый товар'),
(2, '- 100% кожа\r\n', 'Ремень для любителей классики', 'Ремни', 'clr-1', 'https://psv4.userapi.com/c909618/u185911093/docs/d46/09b8253505eb/belts.png?extra=Oi9742H2n2ZIisQA8cwgZV6GyL16QP95Q2xolGNcukdQygpAzIUuHDQiVRSuYrdqc50ObibJMzq3sYrGIh62s_G9N3Y8UOfh9q4a4RP_UJ4GGxMxnfy0RdhhxfeH97_UviCxllKTbLN7ohwgzPVCVl5Lfg', 2900, 'sz-1', 'Ремень cognac'),
(3, 'Характеристика', 'Описание', 'Картхолдеры', 'clr-4', 'https://psv4.userapi.com/c909618/u185911093/docs/d1/83fec0c2385b/holder.png?extra=4iulb4XvvlKx8udB1OzzBFXqPsCMMvmX2JrDmSEUHOIfBtrYMhNg5fkGwfZ17Ybfkhe6eOMiMKwxjG0J8LsCPnhoa9HH5nRDsmouHMgim9NyHXZoDROLQRQa-3jBwdqY3UrGbzVh-JlCU2zUg0-Lh_92WA', 1000, 'sz-2', 'Картхолдер cognac');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `customer_order`
--
ALTER TABLE `customer_order`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKcfmio8pwa3fui3ke1gkjvi1lu` (`item_id`);

--
-- Индексы таблицы `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `customer_order`
--
ALTER TABLE `customer_order`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `item`
--
ALTER TABLE `item`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `customer_order`
--
ALTER TABLE `customer_order`
  ADD CONSTRAINT `FKvwpyc5fmmr149bvvf0ywbet5` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
