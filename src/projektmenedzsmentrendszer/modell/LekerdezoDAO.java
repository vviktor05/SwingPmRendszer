package projektmenedzsmentrendszer.modell;

import projektmenedzsmentrendszer.modell.pojoosztalyok.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class LekerdezoDAO implements Adatbazis{
    private final Modell modell;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public LekerdezoDAO(Modell modell) throws ClassNotFoundException, SQLException {
        this.modell = modell;
        adatbazisKapcsolodas();
    }
    
    public Dolgozo belepesAdatokVizsgal(int ID, String titkositottJelszo, int beosztasAzon, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        Dolgozo dolgozo = null;

        ps = con.prepareStatement(sql);
        ps.setInt(1, ID);
        ps.setString(2, titkositottJelszo);
        ps.setInt(3, beosztasAzon);
        rs = ps.executeQuery();

        if (rs.next()) {
            dolgozo = sorAtalakitDolgozora(rs);
        }

        con.close();
        return dolgozo;
    }
    
    public ArrayList<Megrendelo> getMegrendeloLista(String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Megrendelo> megrendeloLista = new ArrayList<>();

        rs = con.createStatement().executeQuery(sql);
        Megrendelo aktMegrendelo;
        while (rs.next()) {
            aktMegrendelo = sorAtalakitMegrendelore(rs);
            megrendeloLista.add(aktMegrendelo);
        }

        con.close();
        return megrendeloLista;
    }

    public HashMap<Integer, String> getAlapAdatbazisTablaMap(String sql) throws ClassNotFoundException, SQLException {
        adatbazisKapcsolodas();
        HashMap<Integer, String> ftMap = new HashMap<>();

        ResultSet rs = con.createStatement().executeQuery(sql);
        while (rs.next()) {
            ftMap.put(rs.getInt("azon"), rs.getString("nev"));
        }

        con.close();
        return ftMap;
    }
    
    public ArrayList<Dolgozo> getDolgozoLista(String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Dolgozo> dolgozoLista = new ArrayList<>();

        ResultSet rs = con.createStatement().executeQuery(sql);
        Dolgozo aktDolgozo;
        while (rs.next()) {
            aktDolgozo = sorAtalakitDolgozora(rs);
            dolgozoLista.add(aktDolgozo);
        }

        con.close();
        return dolgozoLista;
    }

    public ArrayList<Projekt> getProjektLista(String sql) throws ClassNotFoundException, SQLException {
        adatbazisKapcsolodas();
        ArrayList<Projekt> projektLista = new ArrayList<>();

        ResultSet rs = con.createStatement().executeQuery(sql);
        Projekt aktProjekt;
        while (rs.next()) {
            aktProjekt = sorAtalakitProjektre(rs);
            projektLista.add(aktProjekt);
        }

        con.close();
        return projektLista;
    }

    public ArrayList<Projekt> getKeresettProjektek(String nev, String sql) throws ClassNotFoundException, SQLException {
        adatbazisKapcsolodas();
        ArrayList<Projekt> projektLista = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        nev = "%" + nev + "%";
        ps = con.prepareStatement(sql);
        ps.setString(1, nev);
        rs = ps.executeQuery();

        Projekt aktProjekt;
        while (rs.next()) {
            aktProjekt = sorAtalakitProjektre(rs);
            projektLista.add(aktProjekt);
        }

        con.close();
        return projektLista;
    }
    
    public ArrayList<Feladat> getKeresettFeladat(String targy, String sql) throws ClassNotFoundException, SQLException {
        adatbazisKapcsolodas();
        ArrayList<Feladat> feladatLista = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        targy = "%" + targy + "%";
        ps = con.prepareStatement(sql);
        ps.setString(1, targy);
        rs = ps.executeQuery();

        Feladat aktFeladat;
        while (rs.next()) {
            aktFeladat = sorAtalakitFeladatra(rs);
            feladatLista.add(aktFeladat);
        }

        con.close();
        return feladatLista;
    }
    
    public ArrayList<Feladat> getFeladatLista(String sql) throws ClassNotFoundException, SQLException {
        adatbazisKapcsolodas();
        ArrayList<Feladat> feladatLista = new ArrayList<>();

        ResultSet rs = con.createStatement().executeQuery(sql);
        Feladat aktFeladat;
        while (rs.next()) {
            aktFeladat = sorAtalakitFeladatra(rs);
            feladatLista.add(aktFeladat);
        }

        con.close();
        return feladatLista;
    }
    
    public ArrayList<Jelentes> getJelentesLista(String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Jelentes> jelentesLista = new ArrayList<>();

        ResultSet rs = con.createStatement().executeQuery(sql);
        Jelentes aktJelentes;
        while (rs.next()) {
            aktJelentes = sorAtalakitJelentesre(rs);
            jelentesLista.add(aktJelentes);
        }

        con.close();
        return jelentesLista;
    }
    
    public ArrayList<Csapat> getCsapatLista(String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Csapat> csapatLista = new ArrayList<>();

        ResultSet rs = con.createStatement().executeQuery(sql);
        Csapat aktCsapat;
        while (rs.next()) {
            aktCsapat = sorAtalakitCsapatra(rs);
            csapatLista.add(aktCsapat);
        }

        con.close();
        return csapatLista;
    }
    
    public ArrayList<Dolgozo> getProjektvezetoLista(String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Dolgozo> dolgozoLista = new ArrayList<>();

        ResultSet rs = con.createStatement().executeQuery(sql);
        Dolgozo aktDolgozo;
        while (rs.next()) {
            aktDolgozo = sorAtalakitDolgozora(rs);
            dolgozoLista.add(aktDolgozo);
        }

        con.close();
        return dolgozoLista;
    }
    
    public ArrayList<Projekt> getReszletesKeresesProjektek(Megrendelo megrendelo, int FTerulet, String dtol, 
            String dig, int holTart, int prioritas, Dolgozo dolgozo, int statusz, String sql) 
                throws ClassNotFoundException, SQLException{
        
        adatbazisKapcsolodas();
        ArrayList<Projekt> projektLista = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        ps = con.prepareStatement(sql);
        ps.setInt(1, megrendelo.getAzon());
        ps.setInt(2, FTerulet);
        ps.setString(3, dtol);
        ps.setString(4, dig);
        ps.setInt(5, holTart);
        ps.setInt(6, prioritas);
        ps.setInt(7, dolgozo.getAzon());
        ps.setInt(8, statusz);
        rs = ps.executeQuery();

        Projekt aktProjekt;
        while (rs.next()) {
            aktProjekt = sorAtalakitProjektre(rs);
            projektLista.add(aktProjekt);
        }

        con.close();
        return projektLista;
    }
    
    public ArrayList<Dolgozo> getCsapatvezetoLista(String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Dolgozo> dolgozoLista = new ArrayList<>();

        ResultSet rs = con.createStatement().executeQuery(sql);
        Dolgozo aktDolgozo;
        while (rs.next()) {
            aktDolgozo = sorAtalakitDolgozora(rs);
            dolgozoLista.add(aktDolgozo);
        }

        con.close();
        return dolgozoLista;
    }
    
    public ArrayList<Csapat> getCsapatLista(int kivalasztottProjektAzon, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Csapat> csapatLista = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        ps = con.prepareStatement(sql);
        ps.setInt(1, kivalasztottProjektAzon);
        rs = ps.executeQuery();

        Csapat aktCsapat;
        while (rs.next()) {
            aktCsapat = sorAtalakitCsapatra(rs);
            csapatLista.add(aktCsapat);
        }

        con.close();
        return csapatLista;
    }
    
    public ArrayList<Csapat> getProjektCsapatLista(int kivalasztottProjektAzon, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Csapat> csapatLista = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        ps = con.prepareStatement(sql);
        ps.setInt(1, kivalasztottProjektAzon);
        rs = ps.executeQuery();

        Csapat aktCsapat;
        while (rs.next()) {
            aktCsapat = sorAtalakitCsapatra(rs);
            csapatLista.add(aktCsapat);
        }

        con.close();
        return csapatLista;
    }
    
    public ArrayList<Dolgozo> getCsapatbanDolgozokLista(int kivalasztottCsapatAzon, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Dolgozo> dolgozoLista = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        ps = con.prepareStatement(sql);
        ps.setInt(1, kivalasztottCsapatAzon);
        rs = ps.executeQuery();

        Dolgozo aktDolgozo;
        while (rs.next()) {
            aktDolgozo = sorAtalakitDolgozora(rs);
            dolgozoLista.add(aktDolgozo);
        }

        con.close();
        return dolgozoLista;
    }
    
    public ArrayList<Dolgozo> getKivalasztottCsapatbanDolgozokLista(int kivalasztottDolgozoAzon, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Dolgozo> dolgozoLista = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        ps = con.prepareStatement(sql);
        ps.setInt(1, kivalasztottDolgozoAzon);
        rs = ps.executeQuery();

        Dolgozo aktDolgozo;
        while (rs.next()) {
            aktDolgozo = sorAtalakitDolgozora(rs);
            dolgozoLista.add(aktDolgozo);
        }

        con.close();
        return dolgozoLista;
    }
    
    public ArrayList<Dolgozo> getKivalasztottCsapatbanNemDolgozokLista(Csapat csapat, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Dolgozo> dolgozoLista = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        ps = con.prepareStatement(sql);
        ps.setInt(1, csapat.getAzon());
        rs = ps.executeQuery();

        Dolgozo aktDolgozo;
        while (rs.next()) {
            aktDolgozo = sorAtalakitDolgozora(rs);
            dolgozoLista.add(aktDolgozo);
        }

        con.close();
        return dolgozoLista;
    }
    
    public void addProjekt(String nev, Megrendelo megrend, int fTerulet, String megrendDatum, String hatarido, 
            int holTart, int prioritas, Dolgozo projektvezeto, int statusz, String leiras, String sql) throws ClassNotFoundException, SQLException{
        
        adatbazisKapcsolodas();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nev);
        ps.setInt(2, megrend.getAzon());
        ps.setInt(3, fTerulet);
        ps.setString(4, megrendDatum);
        ps.setString(5, hatarido);
        ps.setInt(6, holTart);
        ps.setInt(7, prioritas);
        ps.setInt(8, projektvezeto.getAzon());
        ps.setInt(9, statusz);
        ps.setString(10, leiras);
        ps.executeUpdate();

        con.close();
    }
    
    public void addMegrendelo(String nev, String telefonszam, String email, String weboldal, 
            String iranyitoszam, String helyseg, String utcaHazszam, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nev);
        ps.setString(2, telefonszam);
        ps.setString(3, email);
        ps.setString(4, weboldal);
        ps.setString(5, iranyitoszam);
        ps.setString(6, helyseg);
        ps.setString(7, utcaHazszam);
        ps.executeUpdate();

        con.close();
    }
    
    public void addFeladat(String feladatTargya, String hataridoDatum, Dolgozo felelos, Projekt projekt, int statusz, String leiras, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, feladatTargya);
        ps.setString(2, hataridoDatum);
        ps.setInt(3, felelos.getAzon());
        ps.setInt(4, projekt.getAzon());
        ps.setInt(5, statusz);
        ps.setString(6, leiras);
        ps.executeUpdate();

        con.close();
    }
    
    public void addJelentes(Projekt projekt, Dolgozo dolgozo, String leiras, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, projekt.getAzon());
        ps.setInt(2, dolgozo.getAzon());
        ps.setString(3, leiras);
        ps.executeUpdate();

        con.close();
    }
    
    public void addDolgozo(String nev, String jelszo, int beosztas, int fTerulet, int skill, String kezdesDatum, String telSzam, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nev);
        ps.setString(2, jelszo);
        ps.setInt(3, beosztas);
        ps.setInt(4, fTerulet);
        ps.setInt(5, skill);
        ps.setString(6, kezdesDatum);
        ps.setString(7, telSzam);
        ps.executeUpdate();

        con.close();
    }
    
    public void addCsapat(String nev, Dolgozo dolgozo, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nev);
        ps.setInt(2, dolgozo.getAzon());
        ps.executeUpdate();

        con.close();
    }
    
    public void modositProjekt(Projekt kivalasztottProjekt, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ps = con.prepareStatement(sql);
        ps.setString(1, kivalasztottProjekt.getNev());
        ps.setInt(2, kivalasztottProjekt.getMegrendelo().getAzon());
        ps.setInt(3, kivalasztottProjekt.getFejlesztesiTeruletID());
        ps.setString(4, kivalasztottProjekt.getMegrendelesDatum());
        ps.setString(5, kivalasztottProjekt.getHataridoDatum());
        ps.setInt(6, kivalasztottProjekt.getHolTartID());
        ps.setInt(7, kivalasztottProjekt.getPrioritasID());
        ps.setInt(8, kivalasztottProjekt.getProjektvezeto().getAzon());
        ps.setInt(9, kivalasztottProjekt.getStatuszID());
        ps.setString(10, kivalasztottProjekt.getLeiras());
        ps.setInt(11, kivalasztottProjekt.getAzon());
        ps.executeUpdate();

        con.close();
    }
    
    public void modositMegrendelo(Megrendelo megrendelo, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, megrendelo.getNev());
        ps.setString(2, megrendelo.getTelSzam());
        ps.setString(3, megrendelo.getEmail());
        ps.setString(4, megrendelo.getWeboldal());
        ps.setString(5, megrendelo.getIranyitoszam());
        ps.setString(6, megrendelo.getHelyseg());
        ps.setString(7, megrendelo.getUtcaHazszam());
        ps.setInt(8, megrendelo.getAzon());
        ps.executeUpdate();

        con.close();
    }
    
    public void modositFeladat(Feladat feladat, String sql) throws ClassNotFoundException, SQLException {
        adatbazisKapcsolodas();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, feladat.getFeladatTargya());
        ps.setString(2, feladat.getHataridoDatum());
        ps.setInt(3, feladat.getFelelos().getAzon());
        ps.setInt(4, feladat.getProjekt().getAzon());
        ps.setInt(5, feladat.getStatuszID());
        ps.setString(6, feladat.getLeiras());
        ps.setInt(7, feladat.getAzon());
        ps.executeUpdate();
        
        con.close();
    }
    
    public void modositJelentes(Jelentes jelentes, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, jelentes.getProjekt().getAzon());
        ps.setString(2, jelentes.getSzoveg());
        ps.setInt(3, jelentes.getAzon());
        ps.executeUpdate();
        
        con.close();
    }
    
    public void modositDolgozo(Dolgozo dolgozo, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, dolgozo.getNev());
        ps.setInt(2, dolgozo.getBeosztasID());
        ps.setInt(3, dolgozo.getfTeruletID());
        ps.setInt(4, dolgozo.getSkillID());
        ps.setString(5, dolgozo.getKezdesDatum());
        ps.setString(6, dolgozo.getTelSzam());
        ps.setInt(7, dolgozo.getAzon());
        ps.executeUpdate();
        
        con.close();
    }

    public void modositCsapat(Csapat csapat, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, csapat.getNev());
        ps.setInt(2, csapat.getCsapatvezeto().getAzon());
        ps.setInt(3, csapat.getAzon());
        ps.executeUpdate();
        
        con.close();
    }
    
    public void torolProjekt(Projekt projekt, String sql1, String sql2, String sql3, String sql4) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps1 = con.prepareStatement(sql1);
        ps1.setInt(1, projekt.getAzon());
        ps1.executeUpdate();
        
        PreparedStatement ps2 = con.prepareStatement(sql2);
        ps2.setInt(1, projekt.getAzon());
        ps2.executeUpdate();
        
        PreparedStatement ps3 = con.prepareStatement(sql3);
        ps3.setInt(1, projekt.getAzon());
        ps3.executeUpdate();
                
        PreparedStatement ps4 = con.prepareStatement(sql4);
        ps4.setInt(1, projekt.getAzon());
        ps4.executeUpdate();

        con.close();
    }
    
    public void torolMegrendelo(Megrendelo megrendelo, String sql1, String sql2) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps1 = con.prepareStatement(sql1);
        ps1.setInt(1, megrendelo.getAzon());
        ps1.executeUpdate();
        
        PreparedStatement ps2 = con.prepareStatement(sql2);
        ps2.setInt(1, megrendelo.getAzon());
        ps2.executeUpdate();

        con.close();
    }
    
    public void torolFeladat(Feladat feladat, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, feladat.getAzon());
        ps.executeUpdate();

        con.close();
    }
    
    public void torolJelentes(Jelentes jelentes, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, jelentes.getAzon());
        ps.executeUpdate();

        con.close();
    }
    
    public void torolDolgozo(Dolgozo dolgozo, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, dolgozo.getAzon());
        ps.executeUpdate();

        con.close();
    }
    
    public void torolCsapat(Csapat csapat, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, csapat.getAzon());
        ps.executeUpdate();

        con.close();
    }
    
    public void projektenDolgozoCsapatokMent(Projekt projekt, ArrayList<Csapat> csapatok, String sql1, String sql2) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps1 = con.prepareStatement(sql1);
        ps1.setInt(1, projekt.getAzon());
        ps1.executeUpdate();
        
        PreparedStatement ps2 = con.prepareStatement(sql2);
        for (int i = 0; i < csapatok.size(); i++) {
            ps2.setInt(1, projekt.getAzon());
            ps2.setInt(2, csapatok.get(i).getAzon());
            ps2.executeUpdate();
        }

        con.close();
    }
    
    public void csapattagokMent(Csapat csapat, ArrayList<Dolgozo> csapattagok, String sql1, String sql2) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps1 = con.prepareStatement(sql1);
        ps1.setInt(1, csapat.getAzon());
        ps1.executeUpdate();
        
        PreparedStatement ps2 = con.prepareStatement(sql2);
        for (int i = 0; i < csapattagok.size(); i++) {
            ps2.setInt(1, csapattagok.get(i).getAzon());
            ps2.setInt(2, csapat.getAzon());
            ps2.executeUpdate();
        }

        con.close();
    }
    
    public void ujJelszoMent(String uJelszo, Dolgozo dolgozo, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps1 = con.prepareStatement(sql);
        ps1.setString(1, uJelszo);
        ps1.setInt(2, dolgozo.getAzon());
        ps1.executeUpdate();

        con.close();
    }
    
    public void bejelentkezesIdoMent(Dolgozo dolgozo, String datumIdo, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        PreparedStatement ps1 = con.prepareStatement(sql);
        ps1.setString(1, datumIdo);
        ps1.setInt(2, dolgozo.getAzon());
        ps1.executeUpdate();

        con.close();
    }
    
    public ArrayList<Projekt> getCsvezetoProjektLista(Dolgozo belepettDolgozo, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Projekt> projektLista = new ArrayList<>();
        ps = con.prepareStatement(sql);
        ps.setInt(1, belepettDolgozo.getAzon());
        rs = ps.executeQuery();

        Projekt aktProjekt;
        while (rs.next()) {
            aktProjekt = sorAtalakitProjektre(rs);
            projektLista.add(aktProjekt);
        }

        con.close();
        return projektLista;
    }
    
    public ArrayList<Projekt> getCsvezetoKeresettProjektek(Dolgozo dolgozo, String nev, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Projekt> projektLista = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        nev = "%" + nev + "%";
        ps = con.prepareStatement(sql);
        ps.setInt(1, dolgozo.getAzon());
        ps.setString(2, nev);
        rs = ps.executeQuery();

        Projekt aktProjekt;
        while (rs.next()) {
            aktProjekt = sorAtalakitProjektre(rs);
            projektLista.add(aktProjekt);
        }

        con.close();
        return projektLista;
    }
    
    public ArrayList<Feladat> getCsvezetoFeldatLista(Dolgozo belepettDolgozo, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Feladat> feladatLista = new ArrayList<>();
        ps = con.prepareStatement(sql);
        ps.setInt(1, belepettDolgozo.getAzon());
        rs = ps.executeQuery();

        Feladat aktFeladat;
        while (rs.next()) {
            aktFeladat = sorAtalakitFeladatra(rs);
            feladatLista.add(aktFeladat);
        }

        con.close();
        return feladatLista;
    }
    
    public ArrayList<Feladat> getCsvezetoKeresettFeladat(Dolgozo dolgozo, String targy, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Feladat> feladatLista = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        targy = "%" + targy + "%";
        ps = con.prepareStatement(sql);
        ps.setInt(1, dolgozo.getAzon());
        ps.setString(2, targy);
        rs = ps.executeQuery();

        Feladat aktFeladat;
        while (rs.next()) {
            aktFeladat = sorAtalakitFeladatra(rs);
            feladatLista.add(aktFeladat);
        }

        con.close();
        return feladatLista;
    }
    
    public ArrayList<Jelentes> getCsvezetoJelentesek(Dolgozo belepettDolgozo, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Jelentes> jelentesLista = new ArrayList<>();
        ps = con.prepareStatement(sql);
        ps.setInt(1, belepettDolgozo.getAzon());
        rs = ps.executeQuery();

        Jelentes aktJelentes;
        while (rs.next()) {
            aktJelentes = sorAtalakitJelentesre(rs);
            jelentesLista.add(aktJelentes);
        }

        con.close();
        return jelentesLista;
    }
    
    public ArrayList<Projekt> getCsVezetoReszletesKeresesProjektek(Dolgozo belepettDolgozo, Megrendelo megrendelo, int FTerulet, 
            String dtol, String dig, int holTart, int prioritas, 
            Dolgozo dolgozo, int statusz, String sql) throws ClassNotFoundException, SQLException{
        adatbazisKapcsolodas();
        ArrayList<Projekt> projektLista = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        ps = con.prepareStatement(sql);
        ps.setInt(1, belepettDolgozo.getAzon());
        ps.setInt(2, megrendelo.getAzon());
        ps.setInt(3, FTerulet);
        ps.setString(4, dtol);
        ps.setString(5, dig);
        ps.setInt(6, holTart);
        ps.setInt(7, prioritas);
        ps.setInt(8, dolgozo.getAzon());
        ps.setInt(9, statusz);
        rs = ps.executeQuery();

        Projekt aktProjekt;
        while (rs.next()) {
            aktProjekt = sorAtalakitProjektre(rs);
            projektLista.add(aktProjekt);
        }

        con.close();
        return projektLista;
    }
    
    private Megrendelo sorAtalakitMegrendelore(ResultSet aktSor) throws ClassNotFoundException, SQLException{
        Megrendelo aktMegrendelo
                = new Megrendelo(aktSor.getInt("azon"), aktSor.getString("nev"),
                        aktSor.getString("tel_szam"),aktSor.getString("email"), aktSor.getString("weboldal"), 
                        aktSor.getString("iranyitoszam"), aktSor.getString("helyseg"), aktSor.getString("utca_hazszam"));

        return aktMegrendelo;
    }
    
    private Dolgozo sorAtalakitDolgozora(ResultSet aktSor) throws ClassNotFoundException, SQLException{
        HashMap<Integer, String> beosztas = new HashMap<>();
        HashMap<Integer, String> fTerulet = new HashMap<>();
        HashMap<Integer, String> skill = new HashMap<>();
        
        beosztas.put(aktSor.getInt("beosztas"), modell.getBeosztasNev(aktSor.getInt("beosztas")));
        fTerulet.put(aktSor.getInt("fejlesztesi_terulet"), modell.getFejlesztesiTeruletNev(aktSor.getInt("fejlesztesi_terulet")));
        skill.put(aktSor.getInt("skill"), modell.getSkillNev(aktSor.getInt("skill")));
        
        Dolgozo aktDolgozo
                = new Dolgozo(aktSor.getInt("azon"), aktSor.getString("nev"),
                        aktSor.getString("jelszo"), beosztas, fTerulet, skill, aktSor.getString("kezdes_datum"),
                        aktSor.getString("tel_szam"), aktSor.getString("utolso_bejelentkezes_datum"));

        return aktDolgozo;
    }

    private Projekt sorAtalakitProjektre(ResultSet aktSor) throws ClassNotFoundException, SQLException {
        HashMap<Integer, String> fTerulet = new HashMap<>();
        HashMap<Integer, String> holTart = new HashMap<>();
        HashMap<Integer, String> prioritas = new HashMap<>();
        HashMap<Integer, String> statusz = new HashMap<>();
        
        fTerulet.put(aktSor.getInt("fejlesztesi_terulet"), modell.getFejlesztesiTeruletNev(aktSor.getInt("fejlesztesi_terulet")));
        holTart.put(aktSor.getInt("hol_tart"), modell.getHolTartNev(aktSor.getInt("hol_tart")));
        prioritas.put(aktSor.getInt("prioritas"), modell.getPrioritasNev(aktSor.getInt("prioritas")));
        statusz.put(aktSor.getInt("statusz"), modell.getStatuszNev(aktSor.getInt("statusz")));
        
        Projekt aktProjekt
                = new Projekt(aktSor.getInt("azon"), aktSor.getString("nev"),
                        modell.getMegrendelo(aktSor.getInt("megrendelo")), fTerulet, aktSor.getString("megrendeles_datum"),
                        aktSor.getString("hatarido_datum"), holTart, prioritas,
                        modell.getDolgozo(aktSor.getInt("projektvezeto")), statusz, aktSor.getString("leiras"));

        return aktProjekt;
    }

    private Feladat sorAtalakitFeladatra(ResultSet aktSor) throws ClassNotFoundException, SQLException{
        HashMap<Integer, String> statusz = new HashMap<>();
        statusz.put(aktSor.getInt("statusz"), modell.getStatuszNev(aktSor.getInt("statusz")));
        
        Feladat aktFeladat
                = new Feladat(aktSor.getInt("azon"), aktSor.getString("feladat_targya"), 
                        aktSor.getString("hatarido_datum"), modell.getDolgozo(aktSor.getInt("felelos")), 
                        modell.getProjekt(aktSor.getInt("projekt")), statusz, aktSor.getString("leiras"));

        return aktFeladat;
    }
    
    private Jelentes sorAtalakitJelentesre(ResultSet aktSor) throws ClassNotFoundException, SQLException{
        Jelentes aktJelentes
                = new Jelentes(aktSor.getInt("azon"), modell.getProjekt(aktSor.getInt("projekt")),
                        aktSor.getString("felvitel_datum"), modell.getDolgozo(aktSor.getInt("felvitte")), aktSor.getString("szoveg"));

        return aktJelentes;
    }
    
    private Csapat sorAtalakitCsapatra(ResultSet aktSor) throws ClassNotFoundException, SQLException{
        Csapat aktCsapat
                = new Csapat(aktSor.getInt("azon"), aktSor.getString("nev"), modell.getDolgozo(aktSor.getInt("csapatvezeto")));

        return aktCsapat;
    }    
    
//    private ProjektCsapat sorAtalakitProjektCsapatra(ResultSet aktSor) throws ClassNotFoundException, SQLException{
//        ProjektCsapat aktProjektCsapat
//                = new ProjektCsapat(modell.getProjekt(aktSor.getInt("projekt")), modell.getCsapat(aktSor.getInt("csapat")));
//
//        return aktProjektCsapat;
//    }
    
    private void adatbazisKapcsolodas() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        con = DriverManager.getConnection(URL, USER, PASSWORD);
    }
}