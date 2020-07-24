-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2020. Már 07. 20:32
-- Kiszolgáló verziója: 10.4.11-MariaDB
-- PHP verzió: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `pmrendszer`
--
CREATE DATABASE IF NOT EXISTS `pmrendszer` DEFAULT CHARACTER SET utf8 COLLATE utf8_hungarian_ci;
USE `pmrendszer`;
-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `beosztas`
--

CREATE TABLE `beosztas` (
  `azon` int(11) NOT NULL,
  `nev` varchar(50) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `beosztas`
--

INSERT INTO `beosztas` (`azon`, `nev`) VALUES
(1, 'Projektvezető'),
(2, 'Csapatvezető'),
(3, 'Fejlesztő');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `csapat`
--

CREATE TABLE `csapat` (
  `azon` int(11) NOT NULL,
  `nev` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `csapatvezeto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `csapat`
--

INSERT INTO `csapat` (`azon`, `nev`, `csapatvezeto`) VALUES
(7, 'A team', 9),
(8, 'B team', 11),
(9, 'C team', 24);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `csapat_tagsag`
--

CREATE TABLE `csapat_tagsag` (
  `dolgozo` int(11) NOT NULL,
  `csapat_tagsag_kezdete` datetime NOT NULL DEFAULT current_timestamp(),
  `csapat_tagsag_vege` datetime DEFAULT NULL,
  `csapat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `csapat_tagsag`
--

INSERT INTO `csapat_tagsag` (`dolgozo`, `csapat_tagsag_kezdete`, `csapat_tagsag_vege`, `csapat`) VALUES
(20, '2020-03-07 16:04:33', NULL, 8),
(21, '2020-03-07 16:04:34', NULL, 8),
(23, '2020-03-07 16:03:27', NULL, 9),
(25, '2020-03-07 16:04:24', NULL, 7),
(26, '2020-03-07 16:04:34', NULL, 8),
(27, '2020-03-07 16:03:27', NULL, 9),
(28, '2020-03-07 16:04:24', NULL, 7);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `dolgozo`
--

CREATE TABLE `dolgozo` (
  `azon` int(11) NOT NULL,
  `nev` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `jelszo` varchar(200) COLLATE utf8_hungarian_ci NOT NULL,
  `beosztas` int(11) NOT NULL,
  `fejlesztesi_terulet` int(11) NOT NULL,
  `skill` int(11) NOT NULL,
  `kezdes_datum` date NOT NULL,
  `tel_szam` varchar(20) COLLATE utf8_hungarian_ci NOT NULL,
  `utolso_bejelentkezes_datum` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `dolgozo`
--

INSERT INTO `dolgozo` (`azon`, `nev`, `jelszo`, `beosztas`, `fejlesztesi_terulet`, `skill`, `kezdes_datum`, `tel_szam`, `utolso_bejelentkezes_datum`) VALUES
(8, 'Horváth Krisztina', 'ed20a3f3b8b4c67c848b6f53d9da31270cf3a20998944b2b7e0278dccbb9c18f', 1, 1, 4, '2020-02-01', '06701122345', '2020-03-07 19:28:22'),
(9, 'Faragó András', '598dbeb7ca96ccc4523ea8c997fc9cbd6be29baf571495ded2788fa71e8455e0', 2, 1, 3, '2020-02-01', '06701122345', '2020-03-05 00:32:46'),
(10, 'Lukáts Zoltán', '19f18324dfa42ec28807f6c031c9cb24c3883959e13deaa973b1fac04bc2cafb', 3, 1, 2, '2020-02-02', '06701122345', '2020-03-04 19:50:05'),
(11, 'Lakatos Géza', '598dbeb7ca96ccc4523ea8c997fc9cbd6be29baf571495ded2788fa71e8455e0', 2, 4, 4, '2020-02-01', '06302425505', '2020-02-28 23:23:39'),
(17, 'Csikós Csaba', '2c7a4c5f98d05a38a2baf9383930a19afe1d1f3ebd85bce370b15b45e5a37f57', 1, 1, 5, '2018-05-07', '06203254679', NULL),
(18, 'Kovács Annamária', '3247df76b73273030876b0a8533182731c5003502b99dd7efad3e93cbc900c83', 1, 4, 4, '2018-11-14', '06306237942', NULL),
(19, 'Bana Ferenc', '5cd6937c10c8be0c9274372fa9d5d70c429d78ad7e3c5ae6b6e788c64d333cfe', 2, 3, 3, '2018-03-23', '06207942653', NULL),
(20, 'Gál Endre', '72b6331a2b3fea9c0c5faa54b2254911cd1fc27170ac900f452e5e72d8176131', 3, 4, 2, '2019-02-18', '06207237689', NULL),
(21, 'Tóth Ádám', '852db2468a4b76030bef3ba429bf73e134b7112c5622fc3ee8fa6e0bcd15ed39', 3, 1, 1, '2019-11-29', '06706271345', NULL),
(22, 'Kerekes Eszter', '39c648259495b8e83c2856da31bc86153012b6e118944c78c2150167e8385666', 1, 2, 5, '2019-01-17', '06308942571', NULL),
(23, 'Kiss Elemér', '12feab7f6b26dba78fe2e6319aa5e6083455ea201d8070613929aa4490696af5', 3, 4, 3, '2019-05-23', '06705941739', NULL),
(24, 'Kováts Károly', '42baab9bd8afe059e4e5e9a2c9ba3ecaa9372ab3b20b5475e6ea3c76980662d4', 2, 2, 5, '2018-03-05', '06302465987', NULL),
(25, 'Szilágyi Péter', '8957c0e6cec0698f80692c2779bc57ac39916e9bbc310799d247b0e81f832c98', 3, 1, 2, '2019-09-20', '06304569841', NULL),
(26, 'Balogh Sándor', 'd704eb2b7affdbb9682fd34c6e3dbebb262e5ad0762dfe476d192b2d071b2461', 3, 4, 3, '2018-12-12', '06707893521', NULL),
(27, 'Vincze László', '33d5f92211e451e6e5cd66170a6baa1bc644d595604cea65e5b55daaca6c3f7e', 3, 1, 3, '2019-01-24', '06308945689', NULL),
(28, 'Balla Mihály', '982520eb0a3909b12aa8b1ccf1a8335d8772dfdcfa2482b4823ca30907a09c7c', 3, 2, 4, '2020-01-03', '06707768964', NULL);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `fejlesztesi_terulet`
--

CREATE TABLE `fejlesztesi_terulet` (
  `azon` int(11) NOT NULL,
  `nev` varchar(50) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `fejlesztesi_terulet`
--

INSERT INTO `fejlesztesi_terulet` (`azon`, `nev`) VALUES
(1, 'Asztali alkalmazás'),
(2, 'Adatbázisok fejlesztése'),
(3, 'Alkalmazás iOS és Android'),
(4, 'Web fejlesztés'),
(5, 'Mesterséges intelligencia'),
(6, 'Adatbányászat');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `feladat`
--

CREATE TABLE `feladat` (
  `azon` int(11) NOT NULL,
  `feladat_targya` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `hatarido_datum` date NOT NULL,
  `felelos` int(11) NOT NULL,
  `projekt` int(11) DEFAULT NULL,
  `statusz` int(11) NOT NULL,
  `leiras` varchar(500) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `feladat`
--

INSERT INTO `feladat` (`azon`, `feladat_targya`, `hatarido_datum`, `felelos`, `projekt`, `statusz`, `leiras`) VALUES
(1, 'Nyílvántartó rendszer specifikáció', '2020-07-21', 9, 1, 2, ''),
(2, 'Webáruház rendszer specifikáció meghatározása', '2020-04-15', 11, 2, 3, ''),
(45, 'Építőipari szoftver', '2020-01-08', 9, 1, 4, 'Az Easy Office egy olyan 3D program, amelyet az építőipari projektmenedzsment könnyű kezelésére hoztunk létre a megrendelő számára. Az eltérő építési szakaszok szükségletének kielégítése érdekében az Easy Office egy egységes módon lett létrehozva, amely könnyedén testre szabható, bővíthető és egyszerűen használható kezelői felületet nyújt.'),
(47, 'Business Card Designer program létrehozása', '2020-04-10', 19, 14, 3, '');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `hol_tart`
--

CREATE TABLE `hol_tart` (
  `azon` int(11) NOT NULL,
  `nev` varchar(50) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `hol_tart`
--

INSERT INTO `hol_tart` (`azon`, `nev`) VALUES
(1, 'Vevői Specifikáció'),
(2, 'Szoftveres Specifikáció'),
(3, 'Rendszertervezés'),
(4, 'Implementáció'),
(5, 'Tesztelés'),
(6, 'Kész'),
(7, 'Továbbfejlesztés');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `jelentes`
--

CREATE TABLE `jelentes` (
  `azon` int(11) NOT NULL,
  `projekt` int(11) NOT NULL,
  `felvitel_datum` datetime NOT NULL DEFAULT current_timestamp(),
  `felvitte` int(11) NOT NULL,
  `szoveg` varchar(300) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `jelentes`
--

INSERT INTO `jelentes` (`azon`, `projekt`, `felvitel_datum`, `felvitte`, `szoveg`) VALUES
(2, 2, '2020-02-02 13:46:05', 11, 'Elkezdtük a web alkalmazással szemben támasztott pontos vevői elvárások definiálását.'),
(3, 1, '2020-02-12 20:41:04', 8, 'asxsx'),
(5, 6, '2020-02-17 00:33:33', 8, 'fdsss'),
(7, 19, '2020-02-18 10:07:50', 8, 'qweqe'),
(8, 1, '2020-02-28 22:56:23', 8, 'asdasdasd'),
(9, 1, '2020-02-28 23:03:52', 8, 'asd'),
(10, 1, '2020-02-28 23:10:52', 8, 'dsa'),
(11, 1, '2020-02-28 23:21:28', 9, 'asdasd'),
(12, 1, '2020-02-28 23:23:54', 11, 'dfrgh');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `megrendelo`
--

CREATE TABLE `megrendelo` (
  `azon` int(11) NOT NULL,
  `nev` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `tel_szam` varchar(20) COLLATE utf8_hungarian_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `weboldal` varchar(50) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `iranyitoszam` varchar(10) COLLATE utf8_hungarian_ci NOT NULL,
  `helyseg` varchar(40) COLLATE utf8_hungarian_ci NOT NULL,
  `utca_hazszam` varchar(100) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `megrendelo`
--

INSERT INTO `megrendelo` (`azon`, `nev`, `tel_szam`, `email`, `weboldal`, `iranyitoszam`, `helyseg`, `utca_hazszam`) VALUES
(1, 'Takacs Kft.', '06302425344', 'takacs@gmail.com', 'www.takacs.hu', '2322', 'Foktő', 'Petőfi Sándor utca 230.'),
(2, 'Balla Bt.', '06302425505', 'balla@gmail.com', NULL, '3424', 'Kecskemét', 'Bethlen Gábor út 32'),
(7, 'Straus kft.', '06705324169', 'straus@hotmail.com', 'www.straus.markt.com', '2092', 'Budakeszi', 'Arany János utca 73.'),
(8, 'Argo Kft.', '06309953241', 'argo@mailbox.hu', 'argokft.hu', '4024', 'Debrecen', 'Városház utca 14.'),
(9, 'Cargo Network Kft.', '06203214672', 'cargo.n@yahoo.com', 'cargonetwork.com', '2370', 'Dabas', 'Liget sor 6.'),
(10, 'Duna Control Kft.', '06708941269', 'info@dunacontrol.hu', 'www.duna-control.hu', '2400', 'Dunaújváros', 'Táncsics Mihály utca 14. Fsz. 2.'),
(11, 'Data Hungária Kft.', '06205478941', 'datainfo@hungaria.hu', 'www.datahun.hu', '5000', 'Szolnok', 'Dózsa György út 67.'),
(12, 'IRP International Kft.', '06303264589', 'info@irp.com', 'www.irp.com', '1027', 'Budapest II. kerület', 'Bem József utca 12.');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `prioritas`
--

CREATE TABLE `prioritas` (
  `azon` int(11) NOT NULL,
  `nev` varchar(50) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `prioritas`
--

INSERT INTO `prioritas` (`azon`, `nev`) VALUES
(1, 'Alacsony'),
(2, 'Normál'),
(3, 'Magas'),
(4, 'SÜRGŐS!');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `projekt`
--

CREATE TABLE `projekt` (
  `azon` int(11) NOT NULL,
  `nev` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `megrendelo` int(11) DEFAULT NULL,
  `fejlesztesi_terulet` int(11) NOT NULL,
  `megrendeles_datum` date NOT NULL,
  `hatarido_datum` date NOT NULL,
  `hol_tart` int(11) NOT NULL,
  `prioritas` int(11) NOT NULL,
  `projektvezeto` int(11) NOT NULL,
  `statusz` int(11) NOT NULL,
  `leiras` varchar(500) COLLATE utf8_hungarian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `projekt`
--

INSERT INTO `projekt` (`azon`, `nev`, `megrendelo`, `fejlesztesi_terulet`, `megrendeles_datum`, `hatarido_datum`, `hol_tart`, `prioritas`, `projektvezeto`, `statusz`, `leiras`) VALUES
(1, 'Nyílvántartó rendszer', 1, 2, '2020-02-01', '2020-07-21', 3, 4, 8, 2, 'A BMR ügyviteli rendszer a magyar kisvállalkozások igényeire kialakított megoldás, amely ötvözi a nagyvállalati rendszerek kényelmi funkciót az egyszerűsített, logikus folyamatokkal és gyors, költséghatékony bevezetéssel. Fontosabb funkciói: tételek egyszerű, gyors felvitele; korlátlan számú vállalkozás könyvelése; eredménykimutatás; bérszámfejtés; 30 napos áfa figyelése; tárgyieszköz nyilvántartás.'),
(2, 'Webáruház', 2, 4, '2020-02-01', '2020-04-15', 4, 2, 17, 3, 'Megrendelőnk egy bútorokkal foglalkozó webáruház honlapjának létrehozásával bízott meg bennünket. A honlap megjelenése testreszabható; ügyfelülnk egyéni igényeire épülve készítjük el a web korszerű és felhasználóbarát platformját.'),
(6, 'Építőipari szoftver', 7, 1, '2019-10-01', '2020-01-08', 6, 1, 18, 4, 'Az Easy Office egy olyan 3D program, amelyet az építőipari projektmenedzsment könnyű kezelésére hoztunk létre a megrendelő számára. Az eltérő építési szakaszok szükségletének kielégítése érdekében az Easy Office egy egységes módon lett létrehozva, amely könnyedén testre szabható, bővíthető és egyszerűen használható kezelői felületet nyújt.'),
(14, 'Business Card Designer ', 8, 1, '2020-03-10', '2020-04-10', 1, 1, 22, 3, 'A megrendelőnk által kért Business Card Designer egyolyan névjegykártya készítő program, amely könnyű tervezést biztosít. A program lépésről lépésre végigvezet a névjegykártya készítés összes fázisán.'),
(18, 'Projekt menedzsment szoftver', 9, 2, '2020-02-04', '2020-04-27', 2, 3, 17, 3, 'A Trend Menedzsment egy web alapú menedzsment platform, amely összevont megoldást nyújt a projektek dokumentációjának és kommunikációjának kezelésére. Segíta vállalatoknak a projektek elszámoltathatóságának és hatékonyságának növelésében.'),
(19, 'Könyvviteli szoftver', 10, 2, '2020-02-20', '2020-08-11', 5, 3, 18, 1, 'Az ügyfél kérésére egy olyan összetett szoftveren dolgozunk, amely könnyen kezelhető és átlátható. Ebbena komplex programban  megtalálható a kettős könyvviteli program, a bérszámfejtő program, az eszköz nyilvántartás,és a projekt irányítás programja.'),
(20, 'Weboldal', 12, 4, '2019-06-19', '2019-09-13', 6, 2, 8, 4, 'A megrendelő kérésére egy olyan modern a lehetőségekhez igazodó honlapot hoztunk létre, amely könnyedén és a megfelelő módon válaszol az adatokat kérő eszköznek, és annak adottságai szerinti legmegfelelőbb formában jelenik meg rajta.');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `projekt_csapat`
--

CREATE TABLE `projekt_csapat` (
  `projekt` int(11) NOT NULL,
  `csapat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `projekt_csapat`
--

INSERT INTO `projekt_csapat` (`projekt`, `csapat`) VALUES
(1, 7),
(1, 8),
(2, 7),
(6, 7),
(6, 8),
(6, 9),
(14, 8),
(18, 8),
(18, 9),
(19, 7),
(19, 8),
(19, 9),
(20, 9);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `skill`
--

CREATE TABLE `skill` (
  `azon` int(11) NOT NULL,
  `nev` varchar(50) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `skill`
--

INSERT INTO `skill` (`azon`, `nev`) VALUES
(1, 'Gyakornok'),
(2, 'Junior'),
(3, 'Medior'),
(4, 'Senior'),
(5, 'Arhitect');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `statusz`
--

CREATE TABLE `statusz` (
  `azon` int(11) NOT NULL,
  `nev` varchar(50) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `statusz`
--

INSERT INTO `statusz` (`azon`, `nev`) VALUES
(1, 'Leállítva'),
(2, 'Szüneteltetve'),
(3, 'Folyamatban'),
(4, 'Kész');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `beosztas`
--
ALTER TABLE `beosztas`
  ADD PRIMARY KEY (`azon`);

--
-- A tábla indexei `csapat`
--
ALTER TABLE `csapat`
  ADD PRIMARY KEY (`azon`),
  ADD KEY `csapatvezeto` (`csapatvezeto`);

--
-- A tábla indexei `csapat_tagsag`
--
ALTER TABLE `csapat_tagsag`
  ADD PRIMARY KEY (`dolgozo`,`csapat_tagsag_kezdete`),
  ADD KEY `csapat` (`csapat`);

--
-- A tábla indexei `dolgozo`
--
ALTER TABLE `dolgozo`
  ADD PRIMARY KEY (`azon`),
  ADD KEY `beosztas` (`beosztas`),
  ADD KEY `f_terulet` (`fejlesztesi_terulet`),
  ADD KEY `skill` (`skill`);

--
-- A tábla indexei `fejlesztesi_terulet`
--
ALTER TABLE `fejlesztesi_terulet`
  ADD PRIMARY KEY (`azon`);

--
-- A tábla indexei `feladat`
--
ALTER TABLE `feladat`
  ADD PRIMARY KEY (`azon`),
  ADD KEY `felelos` (`felelos`),
  ADD KEY `projekt` (`projekt`),
  ADD KEY `statusz` (`statusz`);

--
-- A tábla indexei `hol_tart`
--
ALTER TABLE `hol_tart`
  ADD PRIMARY KEY (`azon`);

--
-- A tábla indexei `jelentes`
--
ALTER TABLE `jelentes`
  ADD PRIMARY KEY (`azon`),
  ADD KEY `projekt` (`projekt`),
  ADD KEY `felvitte` (`felvitte`);

--
-- A tábla indexei `megrendelo`
--
ALTER TABLE `megrendelo`
  ADD PRIMARY KEY (`azon`);

--
-- A tábla indexei `prioritas`
--
ALTER TABLE `prioritas`
  ADD PRIMARY KEY (`azon`);

--
-- A tábla indexei `projekt`
--
ALTER TABLE `projekt`
  ADD PRIMARY KEY (`azon`),
  ADD KEY `megrendelo` (`megrendelo`),
  ADD KEY `fejlesztesi_terulet` (`fejlesztesi_terulet`),
  ADD KEY `hol_tart` (`hol_tart`),
  ADD KEY `prioritas` (`prioritas`),
  ADD KEY `projektvezeto` (`projektvezeto`),
  ADD KEY `statusz` (`statusz`);

--
-- A tábla indexei `projekt_csapat`
--
ALTER TABLE `projekt_csapat`
  ADD PRIMARY KEY (`projekt`,`csapat`),
  ADD KEY `csapat` (`csapat`);

--
-- A tábla indexei `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`azon`);

--
-- A tábla indexei `statusz`
--
ALTER TABLE `statusz`
  ADD PRIMARY KEY (`azon`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `beosztas`
--
ALTER TABLE `beosztas`
  MODIFY `azon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT a táblához `csapat`
--
ALTER TABLE `csapat`
  MODIFY `azon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT a táblához `dolgozo`
--
ALTER TABLE `dolgozo`
  MODIFY `azon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT a táblához `fejlesztesi_terulet`
--
ALTER TABLE `fejlesztesi_terulet`
  MODIFY `azon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT a táblához `feladat`
--
ALTER TABLE `feladat`
  MODIFY `azon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT a táblához `hol_tart`
--
ALTER TABLE `hol_tart`
  MODIFY `azon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT a táblához `jelentes`
--
ALTER TABLE `jelentes`
  MODIFY `azon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT a táblához `megrendelo`
--
ALTER TABLE `megrendelo`
  MODIFY `azon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT a táblához `prioritas`
--
ALTER TABLE `prioritas`
  MODIFY `azon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT a táblához `projekt`
--
ALTER TABLE `projekt`
  MODIFY `azon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT a táblához `skill`
--
ALTER TABLE `skill`
  MODIFY `azon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT a táblához `statusz`
--
ALTER TABLE `statusz`
  MODIFY `azon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `csapat`
--
ALTER TABLE `csapat`
  ADD CONSTRAINT `csapat_ibfk_1` FOREIGN KEY (`csapatvezeto`) REFERENCES `dolgozo` (`azon`);

--
-- Megkötések a táblához `csapat_tagsag`
--
ALTER TABLE `csapat_tagsag`
  ADD CONSTRAINT `csapat_tagsag_ibfk_2` FOREIGN KEY (`csapat`) REFERENCES `csapat` (`azon`),
  ADD CONSTRAINT `csapat_tagsag_ibfk_3` FOREIGN KEY (`dolgozo`) REFERENCES `dolgozo` (`azon`);

--
-- Megkötések a táblához `dolgozo`
--
ALTER TABLE `dolgozo`
  ADD CONSTRAINT `dolgozo_ibfk_1` FOREIGN KEY (`beosztas`) REFERENCES `beosztas` (`azon`),
  ADD CONSTRAINT `dolgozo_ibfk_2` FOREIGN KEY (`skill`) REFERENCES `skill` (`azon`),
  ADD CONSTRAINT `dolgozo_ibfk_3` FOREIGN KEY (`fejlesztesi_terulet`) REFERENCES `fejlesztesi_terulet` (`azon`);

--
-- Megkötések a táblához `feladat`
--
ALTER TABLE `feladat`
  ADD CONSTRAINT `feladat_ibfk_1` FOREIGN KEY (`statusz`) REFERENCES `statusz` (`azon`),
  ADD CONSTRAINT `feladat_ibfk_2` FOREIGN KEY (`projekt`) REFERENCES `projekt` (`azon`),
  ADD CONSTRAINT `feladat_ibfk_3` FOREIGN KEY (`felelos`) REFERENCES `dolgozo` (`azon`);

--
-- Megkötések a táblához `jelentes`
--
ALTER TABLE `jelentes`
  ADD CONSTRAINT `jelentes_ibfk_1` FOREIGN KEY (`projekt`) REFERENCES `projekt` (`azon`),
  ADD CONSTRAINT `jelentes_ibfk_2` FOREIGN KEY (`felvitte`) REFERENCES `dolgozo` (`azon`);

--
-- Megkötések a táblához `projekt`
--
ALTER TABLE `projekt`
  ADD CONSTRAINT `projekt_ibfk_1` FOREIGN KEY (`statusz`) REFERENCES `statusz` (`azon`),
  ADD CONSTRAINT `projekt_ibfk_2` FOREIGN KEY (`megrendelo`) REFERENCES `megrendelo` (`azon`),
  ADD CONSTRAINT `projekt_ibfk_3` FOREIGN KEY (`hol_tart`) REFERENCES `hol_tart` (`azon`),
  ADD CONSTRAINT `projekt_ibfk_4` FOREIGN KEY (`prioritas`) REFERENCES `prioritas` (`azon`),
  ADD CONSTRAINT `projekt_ibfk_5` FOREIGN KEY (`fejlesztesi_terulet`) REFERENCES `fejlesztesi_terulet` (`azon`),
  ADD CONSTRAINT `projekt_ibfk_6` FOREIGN KEY (`projektvezeto`) REFERENCES `dolgozo` (`azon`);

--
-- Megkötések a táblához `projekt_csapat`
--
ALTER TABLE `projekt_csapat`
  ADD CONSTRAINT `projekt_csapat_ibfk_1` FOREIGN KEY (`projekt`) REFERENCES `projekt` (`azon`),
  ADD CONSTRAINT `projekt_csapat_ibfk_2` FOREIGN KEY (`csapat`) REFERENCES `csapat` (`azon`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
