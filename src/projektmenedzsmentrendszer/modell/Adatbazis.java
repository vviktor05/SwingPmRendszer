package projektmenedzsmentrendszer.modell;

interface Adatbazis {
    String IP_LOCAL = "localhost:3306",
           IP_REMOTE = "binbfohspbyte7cyvf5q-mysql.services.clever-cloud.com:3306";

    String LOCAL_DB_NAME = "pmrendszer",
           REMOTE_DB_NAME = "binbfohspbyte7cyvf5q";
    
    String DRIVER = "com.mysql.cj.jdbc.Driver",
           URL = "jdbc:mysql://" + IP_REMOTE + "/" + REMOTE_DB_NAME,
           USER = "ukewcasjgzppqauf",
           PASSWORD = "1jMqBpU6nFxPFSyXp6JL";

    String SQL_AKTIV_PROJEKTEK = "SELECT * FROM projekt WHERE statusz = 3";
    String SQL_OSSZES_PROJEKT = "SELECT * FROM projekt";
    String SQL_PROJEKT_KERES = "SELECT * FROM projekt WHERE nev like ? order by nev";
    String SQL_FELADAT_KERES = "SELECT * FROM feladat WHERE feladat_targya like ? order by feladat_targya";
    String SQL_MEGRENDELOK = "SELECT * FROM megrendelo";
    String SQL_FEJLESZTESI_TERULETEK = "SELECT * FROM fejlesztesi_terulet";
    String SQL_HOL_TART_FAJTAK = "SELECT * FROM hol_tart";
    String SQL_PRIORITAS_FAJTAK = "SELECT * FROM prioritas";
    String SQL_STATUSZ_FAJTAK = "SELECT * FROM statusz";
    String SQL_BEOSZTAS_FAJTAK = "SELECT * FROM beosztas";
    String SQL_DOLGOZOK = "SELECT * FROM dolgozo";
    String SQL_SKILL_FAJTAK = "SELECT * FROM skill";
    String SQL_AKTIV_FELADAT = "SELECT * FROM feladat WHERE statusz = 3";
    String SQL_OSSZES_FELADAT = "SELECT * FROM feladat";
    String SQL_JELENTESEK = "SELECT * FROM jelentes";
    String SQL_CSAPATOK = "SELECT * FROM csapat";
    String SQL_PROJEKTVEZETOK 
            = "SELECT "
            + "d.azon, d.nev, d.jelszo, d.beosztas, d.fejlesztesi_terulet, d.skill, "
            + "d.skill, d.kezdes_datum, d.tel_szam, d.utolso_bejelentkezes_datum "
            + "FROM dolgozo d, beosztas b WHERE d.beosztas = b.azon AND b.nev = 'Projektvezető'";
    String SQL_PROJEKT_RESZLETES_KERESES 
            = "SELECT * FROM projekt "
            + "WHERE megrendelo = ? AND fejlesztesi_terulet = ? "
            + "AND megrendeles_datum >= ? AND megrendeles_datum <= ?"
            + " AND hol_tart = ? AND prioritas = ? AND projektvezeto = ? AND statusz = ?";
    String SQL_CSAPATVEZETOK 
            = "SELECT "
            + "d.azon, d.nev, d.jelszo, d.beosztas, d.fejlesztesi_terulet, d.skill, "
            + "d.skill, d.kezdes_datum, d.tel_szam, d.utolso_bejelentkezes_datum "
            + "FROM dolgozo d, beosztas b "
            + "WHERE d.beosztas = b.azon AND b.nev = 'Csapatvezető'";
    String SQL_KIVALASZTOTT_PROJEKTEN_DOLGOZO_CSAPATOK
            = "SELECT cs.azon, cs.nev, cs.csapatvezeto "
            + "FROM projekt_csapat pcs, csapat cs "
            + "WHERE pcs.csapat = cs.azon AND projekt = ?";
    String SQL_CSAPATOK_AKIK_NEM_DOLGOZNAK_A_KIVALASZTOTT_PROJEKTEN 
            = "SELECT * FROM csapat "
            + "WHERE azon not in "
            + "(SELECT csapat FROM projekt_csapat "
            + "WHERE projekt = ?)";
    String SQL_KIVALASZTOTT_CSAPATBAN_DOLGOZOK
            = "SELECT d.azon, d.nev, d.jelszo, d.beosztas, d.fejlesztesi_terulet, "
            + "d.skill, d.kezdes_datum, d.tel_szam, d.utolso_bejelentkezes_datum "
            + "FROM csapat_tagsag cst, dolgozo d "
            + "WHERE cst.dolgozo = d.azon AND d.beosztas = 3 AND cst.csapat = ? AND cst.csapat_tagsag_vege is null";
    String SQL_KIVALASZTOTT_CSAPATBAN_NEM_DOLGOZOK
            = "SELECT * FROM dolgozo "
            + "WHERE beosztas = 3 AND azon not in "
            + "(SELECT dolgozo FROM csapat_tagsag WHERE csapat = ? AND csapat_tagsag_vege IS NULL)";
    String SQL_ADD_PROJEKT
            = "INSERT INTO projekt "
            + "(nev, megrendelo, fejlesztesi_terulet, megrendeles_datum, hatarido_datum, "
            + "hol_tart, prioritas, projektvezeto, statusz, leiras) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String SQL_ADD_MEGRENDELO
            = "INSERT INTO megrendelo "
            + "(nev, tel_szam, email, weboldal, iranyitoszam, "
            + "helyseg, utca_hazszam) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    String SQL_ADD_FELADAT
            = "INSERT INTO feladat "
            + "(feladat_targya, hatarido_datum, felelos, projekt, "
            + "statusz, leiras) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
    String SQL_ADD_JELENTES
            = "INSERT INTO jelentes "
            + "(projekt, felvitte, szoveg) "
            + "VALUES (?, ?, ?)";
    String SQL_ADD_DOLGOZO
            = "INSERT INTO dolgozo "
            + "(nev, jelszo, beosztas, fejlesztesi_terulet, skill, kezdes_datum, tel_szam) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    String SQL_ADD_CSAPAT
            = "INSERT INTO csapat "
            + "(nev, csapatvezeto) "
            + "VALUES (?, ?)";
    String SQL_KIVALASZTOTT_CSAPATBAN_DOLDOLGOZOK
            = "SELECT azon, nev, jelszo, beosztas, fejlesztesi_terulet, skill, kezdes_datum, "
            + "tel_szam, utolso_bejelentkezes_datum "
            + "FROM csapat_tagsag cst, dolgozo d "
            + "WHERE d.azon = cst.dolgozo AND cst.csapat = ? AND cst.csapat_tagság_vége IS NULL";
    String SQL_MODOSIT_PROJEKT
            = "UPDATE projekt SET nev = ?, megrendelo = ?, fejlesztesi_terulet = ?, megrendeles_datum = ?, "
            + "hatarido_datum = ?, hol_tart = ?, prioritas = ?, projektvezeto = ?, statusz = ?, leiras = ? "
            + "WHERE azon = ?";
    String SQL_MODOSIT_MEGRENDELO
            = "UPDATE megrendelo SET nev = ?, tel_szam = ?, email = ?, weboldal = ?, "
            + "iranyitoszam = ?, helyseg = ?, utca_hazszam = ? "
            + "WHERE azon = ?";
    String SQL_MODOSIT_FELADAT
            = "UPDATE feladat SET feladat_targya = ?, hatarido_datum = ?, "
            + "felelos = ?, projekt = ?, statusz = ?, leiras = ? "
            + "WHERE azon = ?";
    String SQL_MODOSIT_JELENTES
            = "UPDATE jelentes SET projekt = ?, szoveg = ? "
            + "WHERE azon = ?";
    String SQL_MODOSIT_DOLGOZO
            ="UPDATE dolgozo SET nev = ?, beosztas = ?, fejlesztesi_terulet = ?, "
            + "skill = ?, kezdes_datum = ?, tel_szam = ? "
            + "WHERE azon = ?";
    String SQL_MODOSIT_CSAPAT
            = "UPDATE csapat SET nev = ?, csapatvezeto = ? "
            + "WHERE azon = ?";
    String SQL_TOROL_PROJEKT
            = "DELETE FROM projekt "
            + "WHERE azon = ?";
    String SQL_TOROL_PROJEKTRE_HIVATKOZO_FELADAT
            = "DELETE FROM feladat "
            + "WHERE projekt = ?";
    String SQL_TOROL_PROJEKTRE_HIVATKOZO_JELENTES
            = "DELETE FROM jelentes "
            + "WHERE projekt = ?";
    String SQL_TOROL_PROJEKT_CSAPAT
            = "DELETE FROM projekt_csapat "
            + "WHERE projekt = ?";
    String SQL_TOROL_PROJEKT_MEGRENDELO
            = "UPDATE projekt SET megrendelo = null "
            + "WHERE megrendelo = ?";
    String SQL_TOROL_MEGRENDELO
            = "DELETE FROM megrendelo "
            + "WHERE azon = ?";
    String SQL_TOROL_FELADAT
            = "DELETE FROM feladat "
            + "WHERE azon = ?";
    String SQL_TOROL_JELENTES
            = "DELETE FROM jelentes "
            + "WHERE azon = ?";
    String SQL_TOROL_DOLGOZO
            = "DELETE FROM dolgozo "
            + "WHERE azon = ?";
    String SQL_TOROL_CSAPAT
            = "DELETE FROM csapat "
            + "WHERE azon = ?";
    String SQL_PROJEKTEN_DOLGOZO_CSAPATOK_TORLESE
            = "DELETE FROM projekt_csapat "
            + "WHERE projekt = ?";
    String SQL_PROJEKTEN_DOLGOZO_CSAPATOK_MENT
            = "INSERT INTO projekt_csapat (projekt, csapat) "
            + "VALUES (?, ?)";
    String SQL_CSAPATTAGOK_TORLESE
            = "DELETE FROM csapat_tagsag "
            + "WHERE csapat = ?";
    String SQL_CSAPATTAGOK_MENT
            = "INSERT INTO csapat_tagsag (dolgozo, csapat) "
            + "VALUES (?, ?)";
    String SQL_BELEPES_ADATOK_VIZSGAL
            = "SELECT * FROM dolgozo "
            + "WHERE azon = ? AND jelszo = ? AND beosztas = ?";
    String SQL_JELSZO_MENT
            = "UPDATE dolgozo SET jelszo = ? "
            + "WHERE azon = ?";
    String SQL_DOLGOZO_BEJELENTKEZES_IDO_MENT
            = "UPDATE dolgozo SET utolso_bejelentkezes_datum = ? "
            + "WHERE azon = ?";
    String SQL_CSVEZETO_AKTIV_PROJEKTEK
            = "SELECT p.azon, p.nev, p.megrendelo, p.fejlesztesi_terulet, p.megrendeles_datum, p.hatarido_datum, p.hol_tart, "
            + "p.prioritas, p.projektvezeto, p.statusz, p.leiras "
            + "FROM projekt p, csapat cs, projekt_csapat pcs "
            + "WHERE p.azon = pcs.projekt AND cs.azon = pcs.csapat AND p.statusz = 3 AND cs.csapatvezeto = ?";
    String SQL_CSVEZETO_OSSZES_PROJEKTEK
            = "SELECT p.azon, p.nev, p.megrendelo, p.fejlesztesi_terulet, p.megrendeles_datum, p.hatarido_datum, p.hol_tart, "
            + "p.prioritas, p.projektvezeto, p.statusz, p.leiras "
            + "FROM projekt p, csapat cs, projekt_csapat pcs "
            + "WHERE p.azon = pcs.projekt AND cs.azon = pcs.csapat AND cs.csapatvezeto = ?";
    String SQL_CSVEZETO_PROJEKT_KERES
            = "SELECT p.azon, p.nev, p.megrendelo, p.fejlesztesi_terulet, p.megrendeles_datum, p.hatarido_datum, p.hol_tart, "
            + "p.prioritas, p.projektvezeto, p.statusz, p.leiras "
            + "FROM projekt p, csapat cs, projekt_csapat pcs "
            + "WHERE p.azon = pcs.projekt AND cs.azon = pcs.csapat AND cs.csapatvezeto = ? AND p.nev like ? order by p.nev";
    String SQL_CSVEZETO_AKTIV_FELADAT
            = "SELECT * FROM feladat "
            + "WHERE statusz = 3 AND felelos = ?";
    String SQL_CSVEZETO_OSSZES_FELADAT
            = "SELECT * FROM feladat "
            + "WHERE felelos = ?";
    String SQL_CSVEZETO_FELADAT_KERES
            = "SELECT * FROM feladat "
            + "WHERE felelos = ? AND feladat_targya like ? order by feladat_targya";
    String SQL_CSVEZETO_JELENTESEK
            = "SELECT j.azon, j.projekt, j.felvitel_datum, j.felvitte, j.szoveg "
            + "FROM jelentes j, projekt_csapat pcs, csapat cs "
            + "WHERE j.projekt = pcs.projekt AND pcs.csapat = cs.azon AND CS.csapatvezeto = ?";
    String SQL_SAJAT_JELENTESEK
            = "SELECT * FROM jelentes "
            + "WHERE felvitte = ?";
    String SQL_FEJLESZTO_AKTIV_PROJEKTEK
            = "SELECT p.azon, p.nev, p.megrendelo, p.fejlesztesi_terulet, p.megrendeles_datum, p.hatarido_datum, p.hol_tart, p.prioritas, p.projektvezeto, p.statusz, p.leiras \n" 
            + "FROM projekt p, projekt_csapat pcs, csapat_tagsag cst \n" 
            + "WHERE p.azon = pcs.projekt AND pcs.csapat = cst.csapat AND p.statusz = 3 AND cst.dolgozo = ?";
    String SQL_FEJLESZTO_OSSZES_PROJEKTEK
            = "SELECT p.azon, p.nev, p.megrendelo, p.fejlesztesi_terulet, p.megrendeles_datum, p.hatarido_datum, p.hol_tart, p.prioritas, p.projektvezeto, p.statusz, p.leiras \n" 
            + "FROM projekt p, projekt_csapat pcs, csapat_tagsag cst \n" 
            + "WHERE p.azon = pcs.projekt AND pcs.csapat = cst.csapat AND cst.dolgozo = ?";
    String SQL_FEJLESZTO_PROJEKT_KERES
            = "SELECT p.azon, p.nev, p.megrendelo, p.fejlesztesi_terulet, p.megrendeles_datum, p.hatarido_datum, p.hol_tart, p.prioritas, p.projektvezeto, p.statusz, p.leiras \n" 
            + "FROM projekt p, projekt_csapat pcs, csapat_tagsag cst \n" 
            + "WHERE p.azon = pcs.projekt AND pcs.csapat = cst.csapat AND cst.dolgozo = ? AND p.nev like ? order by p.nev";
    String SQL_CSVEZETO_PROJEKT_RESZLETES_KERES
            = "SELECT p.azon, p.nev, p.megrendelo, p.fejlesztesi_terulet, p.megrendeles_datum, p.hatarido_datum, p.hol_tart, "
            + "p.prioritas, p.projektvezeto, p.statusz, p.leiras "
            + "FROM projekt p, csapat cs, projekt_csapat pcs "
            + "WHERE p.azon = pcs.projekt AND cs.azon = pcs.csapat AND cs.csapatvezeto = ? AND megrendelo = ? AND fejlesztesi_terulet = ? "
            + "AND megrendeles_datum >= ? AND megrendeles_datum <= ? "
            + "AND hol_tart = ? AND prioritas = ? AND projektvezeto = ? AND statusz = ?";
    String SQL_FEJLESZTO_PROJEKT_RESZLETES_KERES
            = "SELECT p.azon, p.nev, p.megrendelo, p.fejlesztesi_terulet, p.megrendeles_datum, p.hatarido_datum, p.hol_tart, p.prioritas, p.projektvezeto, p.statusz, p.leiras \n" 
            + "FROM projekt p, projekt_csapat pcs, csapat_tagsag cst \n" 
            + "WHERE p.azon = pcs.projekt AND pcs.csapat = cst.csapat AND cst.dolgozo = ? AND megrendelo = ? AND fejlesztesi_terulet = ? "
            + "AND megrendeles_datum >= ? AND megrendeles_datum <= ? "
            + "AND hol_tart = ? AND prioritas = ? AND projektvezeto = ? AND statusz = ?";
    String SQL_FEJLESZTO_JELENTESEK
            = "SELECT j.azon, j.projekt, j.felvitel_datum, j.felvitte, j.szoveg "
            + "FROM jelentes j, projekt_csapat pcs, csapat_tagsag cst "
            + "WHERE j.projekt = pcs.projekt AND pcs.csapat = cst.csapat AND cst.dolgozo = ?";
}