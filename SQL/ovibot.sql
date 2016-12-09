-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2016. Dec 08. 15:04
-- Kiszolgáló verziója: 5.7.11
-- PHP verzió: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `ovibot`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `etkezesek`
--

CREATE TABLE `etkezesek` (
  `id` int(11) NOT NULL,
  `datum` date NOT NULL,
  `reggeli` varchar(250) NOT NULL,
  `ebed` varchar(250) NOT NULL,
  `uzsonna` varchar(250) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `etkezesek`
--

INSERT INTO `etkezesek` (`id`, `datum`, `reggeli`, `ebed`, `uzsonna`) VALUES
(1, '2016-12-17', 'Kakaós burkifli', 'Roston sült borzcomb\r\nResztelt Máj', 'Zsíros kenyér hagymával');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `gyerek`
--

CREATE TABLE `gyerek` (
  `id` int(11) NOT NULL,
  `nev` varchar(250) NOT NULL,
  `szuldatum` date NOT NULL,
  `lakhely` varchar(250) NOT NULL,
  `taj` int(11) NOT NULL,
  `apaid` int(11) NOT NULL,
  `anyaid` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `gyerek`
--

INSERT INTO `gyerek` (`id`, `nev`, `szuldatum`, `lakhely`, `taj`, `apaid`, `anyaid`) VALUES
(1, 'Lakatos Kalman', '2016-12-13', 'Kisdomosd', 1111111111, 0, 0);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `jelenleti`
--

CREATE TABLE `jelenleti` (
  `id` int(11) NOT NULL,
  `datum` date NOT NULL,
  `megjelent` tinyint(1) NOT NULL,
  `hangulat` tinyint(1) NOT NULL,
  `magatartas` tinyint(1) NOT NULL,
  `gyerekID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `jelenleti`
--

INSERT INTO `jelenleti` (`id`, `datum`, `megjelent`, `hangulat`, `magatartas`, `gyerekID`) VALUES
(1, '2016-12-06', 0, 1, 0, 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `ovono`
--

CREATE TABLE `ovono` (
  `id` int(11) NOT NULL,
  `nev` varchar(250) NOT NULL,
  `iroda` varchar(250) NOT NULL,
  `telefon` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `ovono`
--

INSERT INTO `ovono` (`id`, `nev`, `iroda`, `telefon`, `email`) VALUES
(1, 'Kiss Ilona', 'A331', '06205226989', 'ilonkakiss@gmail.com');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szulo_anya`
--

CREATE TABLE `szulo_anya` (
  `id` int(11) NOT NULL,
  `nev` varchar(250) NOT NULL,
  `lakhely` varchar(250) NOT NULL,
  `telszam` varchar(250) NOT NULL,
  `gyerek` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `szulo_anya`
--

INSERT INTO `szulo_anya` (`id`, `nev`, `lakhely`, `telszam`, `gyerek`) VALUES
(1, 'Lakatosné Zsibri Mária', 'KisDomosd', '0678566225', 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szulo_apa`
--

CREATE TABLE `szulo_apa` (
  `id` int(11) NOT NULL,
  `nev` varchar(250) NOT NULL,
  `lakhely` varchar(250) NOT NULL,
  `telszam` varchar(250) NOT NULL,
  `gyerek` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `szulo_apa`
--

INSERT INTO `szulo_apa` (`id`, `nev`, `lakhely`, `telszam`, `gyerek`) VALUES
(1, 'Lakatos Oszkár', 'Kisdomosd', '0650233695', 1);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `etkezesek`
--
ALTER TABLE `etkezesek`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `gyerek`
--
ALTER TABLE `gyerek`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `jelenleti`
--
ALTER TABLE `jelenleti`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `ovono`
--
ALTER TABLE `ovono`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `szulo_anya`
--
ALTER TABLE `szulo_anya`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `szulo_apa`
--
ALTER TABLE `szulo_apa`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `etkezesek`
--
ALTER TABLE `etkezesek`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT a táblához `gyerek`
--
ALTER TABLE `gyerek`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT a táblához `jelenleti`
--
ALTER TABLE `jelenleti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT a táblához `ovono`
--
ALTER TABLE `ovono`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT a táblához `szulo_anya`
--
ALTER TABLE `szulo_anya`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT a táblához `szulo_apa`
--
ALTER TABLE `szulo_apa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
