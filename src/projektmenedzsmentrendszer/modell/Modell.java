package projektmenedzsmentrendszer.modell;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import projektmenedzsmentrendszer.modell.tablamodellek.*;
import projektmenedzsmentrendszer.modell.pojoosztalyok.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import static projektmenedzsmentrendszer.modell.tablamodellek.DatumFormazo.ROVID_DATUM_IDO_ADATBAZIS;
import projektmenedzsmentrendszer.vezerlo.Vezerlo;

public class Modell implements Adatbazis, DatumFormazo {
    private final Vezerlo vezerlo;
    private LekerdezoDAO lDAO;
    private Dolgozo belepettDolgozo = null;
    private ArrayList<Projekt> projektLista;
    private ArrayList<Megrendelo> megrendeloLista;
    private HashMap<Integer, String> fejlesztesiTeruletFajtak = new HashMap<>();
    private HashMap<Integer, String> holTartFajtak = new HashMap<>();
    private HashMap<Integer, String> prioritasFajtak = new HashMap<>();
    private HashMap<Integer, String> statuszFajtak = new HashMap<>();
    private HashMap<Integer, String> beosztasFajtak = new HashMap<>();
    private HashMap<Integer, String> skillFajtak = new HashMap<>();
    private ArrayList<Dolgozo> dolgozoLista;
    private ArrayList<Feladat> feladatLista;
    private ArrayList<Jelentes> jelentesLista;
    private ArrayList<Csapat> csapatLista;
    private ArrayList<Projekt> csVezetoOsszesProjektlista;
    private ArrayList<Projekt> fejlesztoOsszesProjektlista;

    public Modell(Vezerlo vezerlo) {
        this.vezerlo = vezerlo;
        try {
            lDAO = new LekerdezoDAO(this);
        } catch (ClassNotFoundException | SQLException ex) {
            vezerlo.hibaAblakFeldob("Hiba az adatbázishoz kapcsolódás során!\nNem sikerült kapcsolódni az adatbázishoz .", "Hiba");
            System.exit(0);
        }
        megrendeloTablaLeker();
        alapAdatbazisTablakLeker();
        dolgozoTablaLeker();
        getOsszesProjektTablaModell();
        getOsszesFeladatTablaModell();
    }

    private void megrendeloTablaLeker() {
        try {
            megrendeloLista = lDAO.getMegrendeloLista(SQL_MEGRENDELOK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void alapAdatbazisTablakLeker() {
        try {
            fejlesztesiTeruletFajtak = lDAO.getAlapAdatbazisTablaMap(SQL_FEJLESZTESI_TERULETEK);
            holTartFajtak = lDAO.getAlapAdatbazisTablaMap(SQL_HOL_TART_FAJTAK);
            prioritasFajtak = lDAO.getAlapAdatbazisTablaMap(SQL_PRIORITAS_FAJTAK);
            statuszFajtak = lDAO.getAlapAdatbazisTablaMap(SQL_STATUSZ_FAJTAK);
            beosztasFajtak = lDAO.getAlapAdatbazisTablaMap(SQL_BEOSZTAS_FAJTAK);
            skillFajtak = lDAO.getAlapAdatbazisTablaMap(SQL_SKILL_FAJTAK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void dolgozoTablaLeker() {
        try {
            dolgozoLista = lDAO.getDolgozoLista(SQL_DOLGOZOK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ProjektTablaModell getAktivProjektTablaModell() {
        ArrayList<Projekt> lista = new ArrayList<>();
        try {
            lista = lDAO.getProjektLista(SQL_AKTIV_PROJEKTEK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new ProjektTablaModell(lista);
    }

    public ProjektTablaModell getOsszesProjektTablaModell() {
        try {
            projektLista = lDAO.getProjektLista(SQL_OSSZES_PROJEKT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new ProjektTablaModell(projektLista);
    }

    public ProjektTablaModell getKeresettProjektekTablaModell(String nev) {
        ArrayList<Projekt> lista = new ArrayList<>();
        try {
            lista = lDAO.getKeresettProjektek(nev, SQL_PROJEKT_KERES);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new ProjektTablaModell(lista);
    }

    public FeladatTablaModell getKeresettFeladatTablaModell(String targy) {
        ArrayList<Feladat> lista = new ArrayList<>();
        try {
            lista = lDAO.getKeresettFeladat(targy, SQL_FELADAT_KERES);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new FeladatTablaModell(lista);
    }

    public MegrendeloTablaModell getMegrendelokTablaModell() {
        megrendeloTablaLeker();

        return new MegrendeloTablaModell(megrendeloLista);
    }

    public FeladatTablaModell getAktivFeladatTablaModell() {
        ArrayList<Feladat> lista = new ArrayList<>();
        try {
            lista = lDAO.getFeladatLista(SQL_AKTIV_FELADAT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new FeladatTablaModell(lista);
    }

    public FeladatTablaModell getOsszesFeladatTablaModell() {
        try {
            feladatLista = lDAO.getFeladatLista(SQL_OSSZES_FELADAT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new FeladatTablaModell(feladatLista);
    }

    public JelentesTablaModell getJelentesekTablaModell() {
        try {
            jelentesLista = lDAO.getJelentesLista(SQL_JELENTESEK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new JelentesTablaModell(jelentesLista);
    }

    public DolgozoTablaModell getDolgozokTablaModell() {
        dolgozoTablaLeker();

        return new DolgozoTablaModell(dolgozoLista);
    }

    public CsapatTablaModell getCsapatokTablaModell() {
        try {
            csapatLista = lDAO.getCsapatLista(SQL_CSAPATOK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new CsapatTablaModell(csapatLista);
    }

    public Projekt getKivalasztottProjekt(int kivalasztottSor) {
        return projektLista.get(kivalasztottSor);
    }

    public Feladat getKivalasztottFeladat(int kivalasztottSor) {
        return feladatLista.get(kivalasztottSor);
    }

    public Jelentes getKivalasztottJelentes(int kivalasztottSor) {
        return jelentesLista.get(kivalasztottSor);
    }

    public String getFejlesztesiTeruletNev(int fTID) {
        return fejlesztesiTeruletFajtak.get(fTID);
    }

    public String getHolTartNev(int hTID) {
        return holTartFajtak.get(hTID);
    }

    public String getPrioritasNev(int pID) {
        return prioritasFajtak.get(pID);
    }

    public String getStatuszNev(int sID) {
        return statuszFajtak.get(sID);
    }

    public String getBeosztasNev(int sID) {
        return beosztasFajtak.get(sID);
    }

    public String getSkillNev(int sID) {
        return skillFajtak.get(sID);
    }

    public Megrendelo getMegrendelo(int mID) {
        int i = 0;
        while (i < megrendeloLista.size() && megrendeloLista.get(i).getAzon() != mID) {
            i++;
        }
        if (i < megrendeloLista.size()) {
            return megrendeloLista.get(i);
        } else {
            return null;
        }
    }

    public Dolgozo getDolgozo(int dID) {
        int i = 0;
        while (i < dolgozoLista.size() && dolgozoLista.get(i).getAzon() != dID) {
            i++;
        }
        return dolgozoLista.get(i);
    }

    public Projekt getProjekt(int pID) {
        int i = 0;
        while (i < projektLista.size() && projektLista.get(i).getAzon() != pID) {
            i++;
        }
        return projektLista.get(i);
    }

    public DefaultComboBoxModel getMegrendelokCBModell() {
        megrendeloTablaLeker();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (Megrendelo aktMegrendelo : megrendeloLista) {
            dcbm.addElement(aktMegrendelo);
        }
        return dcbm;
    }

    public DefaultComboBoxModel getFTeruletCBModell() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (Map.Entry<Integer, String> aktFT : fejlesztesiTeruletFajtak.entrySet()) {
            dcbm.addElement(aktFT.getValue());
        }
        return dcbm;
    }

    public DefaultComboBoxModel getHolTartCBModell() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (Map.Entry<Integer, String> aktHT : holTartFajtak.entrySet()) {
            dcbm.addElement(aktHT.getValue());
        }
        return dcbm;
    }

    public DefaultComboBoxModel getPrioritasCBModell() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (Map.Entry<Integer, String> aktPr : prioritasFajtak.entrySet()) {
            dcbm.addElement(aktPr.getValue());
        }
        return dcbm;
    }

    public DefaultComboBoxModel getProjektvezetoCBModell() {
        ArrayList<Dolgozo> projektvezetoLista = new ArrayList<>();
        try {
            projektvezetoLista = lDAO.getProjektvezetoLista(SQL_PROJEKTVEZETOK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (Dolgozo aktDolgozo : projektvezetoLista) {
            dcbm.addElement(aktDolgozo);
        }

        return dcbm;
    }

    public DefaultComboBoxModel getStatuszCBModell() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (Map.Entry<Integer, String> aktS : statuszFajtak.entrySet()) {
            dcbm.addElement(aktS.getValue());
        }
        return dcbm;
    }

    public ProjektTablaModell getReszletesKeresesProjektekTablaModell(Megrendelo megrendelo, int FTerulet,
            String dtol, String dig, int holTart, int prioritas, Dolgozo dolgozo, int statusz) {

        ArrayList<Projekt> lista = new ArrayList<>();
        try {
            lista = lDAO.getReszletesKeresesProjektek(megrendelo, FTerulet, dtol, dig, holTart, prioritas, dolgozo, statusz, SQL_PROJEKT_RESZLETES_KERESES);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ProjektTablaModell(lista);
    }

    public DefaultComboBoxModel getCsapatvezetoCBModell() {
        ArrayList<Dolgozo> csapatvezetoLista = new ArrayList<>();
        try {
            csapatvezetoLista = lDAO.getCsapatvezetoLista(SQL_CSAPATVEZETOK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (Dolgozo aktDolgozo : csapatvezetoLista) {
            dcbm.addElement(aktDolgozo);
        }

        return dcbm;
    }

    public DefaultComboBoxModel getProjekCBModell() {
        getOsszesProjektTablaModell();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (Projekt aktProjekt : projektLista) {
            dcbm.addElement(aktProjekt);
        }

        return dcbm;
    }

    public DefaultComboBoxModel getBeosztasCBModell() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (Map.Entry<Integer, String> aktB : beosztasFajtak.entrySet()) {
            dcbm.addElement(aktB.getValue());
        }
        return dcbm;
    }

    public DefaultComboBoxModel getSkillCBModell() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (Map.Entry<Integer, String> aktS : skillFajtak.entrySet()) {
            dcbm.addElement(aktS.getValue());
        }
        return dcbm;
    }

    public DefaultComboBoxModel getCsapatCBModell() {
        getCsapatokTablaModell();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (Csapat aktCsapat : csapatLista) {
            dcbm.addElement(aktCsapat);
        }

        return dcbm;
    }

    public DefaultListModel getProjektenDolgozoCsapatokLModell(int kivalasztottProjektAzon) {
        ArrayList<Csapat> csapatokLista = new ArrayList<>();
        try {
            csapatokLista = lDAO.getCsapatLista(kivalasztottProjektAzon, SQL_KIVALASZTOTT_PROJEKTEN_DOLGOZO_CSAPATOK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        DefaultListModel dlm = new DefaultListModel();
        for (Csapat aktCsapat : csapatokLista) {
            dlm.addElement(aktCsapat);
        }

        return dlm;
    }

    public DefaultListModel getCsapatbanDolgozokLModell(int kivalasztottCsapatAzon) {
        ArrayList<Dolgozo> dolgozokLista = new ArrayList<>();
        try {
            dolgozokLista = lDAO.getCsapatbanDolgozokLista(kivalasztottCsapatAzon, SQL_KIVALASZTOTT_CSAPATBAN_DOLDOLGOZOK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        DefaultListModel dlm = new DefaultListModel();
        for (Dolgozo aktDolgozo : dolgozokLista) {
            dlm.addElement(aktDolgozo);
        }

        return dlm;
    }

    public DefaultListModel getCsapatokLModell(Projekt kivalasztottProjekt) {
        ArrayList<Csapat> csapatLista = new ArrayList<>();
        try {
            csapatLista = lDAO.getProjektCsapatLista(kivalasztottProjekt.getAzon(), SQL_CSAPATOK_AKIK_NEM_DOLGOZNAK_A_KIVALASZTOTT_PROJEKTEN);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        DefaultListModel dlm = new DefaultListModel();
        for (Csapat aktCsapat : csapatLista) {
            dlm.addElement(aktCsapat);
        }

        return dlm;
    }

    public Csapat getCsapat(int csID) {
        int i = 0;
        while (i < csapatLista.size() && csapatLista.get(i).getAzon() != csID) {
            i++;
        }
        return csapatLista.get(i);
    }

    public DefaultListModel getCsapatTagjaiLModell(Csapat kivalasztottCsapat) {
        ArrayList<Dolgozo> dolgozoLista = new ArrayList<>();
        try {
            dolgozoLista = lDAO.getKivalasztottCsapatbanDolgozokLista(kivalasztottCsapat.getAzon(), SQL_KIVALASZTOTT_CSAPATBAN_DOLGOZOK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        DefaultListModel dlm = new DefaultListModel();
        for (Dolgozo aktDolgozo : dolgozoLista) {
            dlm.addElement(aktDolgozo);
        }

        return dlm;
    }

    public DefaultListModel getDolgozokLModell(Csapat csapat) {
        ArrayList<Dolgozo> dolgozoLista = new ArrayList<>();
        try {
            dolgozoLista = lDAO.getKivalasztottCsapatbanNemDolgozokLista(csapat, SQL_KIVALASZTOTT_CSAPATBAN_NEM_DOLGOZOK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        DefaultListModel dlm = new DefaultListModel();
        for (Dolgozo aktDolgozo : dolgozoLista) {
            dlm.addElement(aktDolgozo);
        }

        return dlm;
    }

    public void projektHozzaadd(String nev, Megrendelo megrend, int fTerulet, Date megrendDatum,
            Date hatarido, int holTart, int prioritas, int statusz, String leiras) {
        try {
            lDAO.addProjekt(nev, megrend, fTerulet, ROVID_DATUM_ADATBAZIS.format(megrendDatum), ROVID_DATUM_ADATBAZIS.format(hatarido),
                    holTart, prioritas, belepettDolgozo, statusz, leiras, SQL_ADD_PROJEKT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void megrendeloHozzaadd(String nev, String telefonszam, String email, String weboldal,
            String iranyitoszam, String helyseg, String utcaHazszam) {
        try {
            lDAO.addMegrendelo(nev, telefonszam, email, weboldal, iranyitoszam,
                    helyseg, utcaHazszam, SQL_ADD_MEGRENDELO);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void feladatHozzaadd(String feladatTargya, Date hataridoDatum, Dolgozo felelos, Projekt projekt, int statusz, String leiras) {
        try {
            lDAO.addFeladat(feladatTargya, ROVID_DATUM_ADATBAZIS.format(hataridoDatum), felelos, projekt, statusz,
                    leiras, SQL_ADD_FELADAT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void jelentesHozzaadd(Projekt projekt, String leiras) {
        try {
            lDAO.addJelentes(projekt, belepettDolgozo, leiras, SQL_ADD_JELENTES);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void dolgozoHozzaadd(String nev, int beosztas, int fTerulet, int skill, Date kezdDatum, String telSzam) {
        String kezdesDatum = ROVID_DATUM_ADATBAZIS.format(kezdDatum);
        String jelszo = jelszoTitkosit(kezdesDatum, String.valueOf(beosztas));
        try {
            lDAO.addDolgozo(nev, jelszo, beosztas, fTerulet, skill, kezdesDatum, telSzam, SQL_ADD_DOLGOZO);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void csapatHozzaadd(String nev, Dolgozo dolgozo) {
        try {
            lDAO.addCsapat(nev, dolgozo, SQL_ADD_CSAPAT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void projektModositas(Projekt projekt, String nev, Object megrendelo, int fTerulet, Date megrendDatum,
            Date hatarido, int holTart, int prioritas, int statusz, String leiras) {

        projekt.setNev(nev);
        projekt.setMegrendelo((Megrendelo) megrendelo);
        projekt.setFejlesztesiTerulet(fTerulet, getFejlesztesiTeruletNev(fTerulet));
        projekt.setMegrendelesDatum(ROVID_DATUM_ADATBAZIS.format(megrendDatum));
        projekt.setHataridoDatum(ROVID_DATUM_ADATBAZIS.format(hatarido));
        projekt.setHolTart(holTart, getHolTartNev(holTart));
        projekt.setPrioritas(prioritas, getPrioritasNev(prioritas));
        projekt.setProjektvezeto(belepettDolgozo);
        projekt.setStatusz(statusz, getStatuszNev(statusz));
        projekt.setLeiras(leiras);
        try {
            lDAO.modositProjekt(projekt, SQL_MODOSIT_PROJEKT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void megrendeloModosit(Megrendelo megrendelo, String nev, String telefonszam, String email, String weboldal,
            String iranyitoszam, String helyseg, String utcaHazszam) {

        megrendelo.setNev(nev);
        megrendelo.setTelSzam(telefonszam);
        megrendelo.setEmail(email);
        megrendelo.setWeboldal(weboldal);
        megrendelo.setIranyitoszam(iranyitoszam);
        megrendelo.setHelyseg(helyseg);
        megrendelo.setUtcaHazszam(utcaHazszam);
        try {
            lDAO.modositMegrendelo(megrendelo, SQL_MODOSIT_MEGRENDELO);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void feladatModosit(Feladat feladat, String feladatTargya, Date hataridoDatum, Object felelos, Object projekt, int statusz, String leiras) {
        feladat.setFeladatTargya(feladatTargya);
        feladat.setHataridoDatum(ROVID_DATUM_ADATBAZIS.format(hataridoDatum));
        feladat.setFelelos((Dolgozo) felelos);
        feladat.setProjekt((Projekt) projekt);
        feladat.setStatusz(statusz, getStatuszNev(statusz));
        feladat.setLeiras(leiras);
        try {
            lDAO.modositFeladat(feladat, SQL_MODOSIT_FELADAT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void jelentesModosit(Jelentes jelentes, Object projekt, String leiras) {
        jelentes.setProjekt((Projekt) projekt);
        jelentes.setSzoveg(leiras);
        try {
            lDAO.modositJelentes(jelentes, SQL_MODOSIT_JELENTES);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void dolgozoModosit(Dolgozo dolgozo, String nev, int beosztas, int fTerulet, int skill, Date kezdesDatum, String telSzam) {
        dolgozo.setNev(nev);
        dolgozo.setBeosztas(beosztas, getBeosztasNev(beosztas));
        dolgozo.setfTerulet(fTerulet, getFejlesztesiTeruletNev(fTerulet));
        dolgozo.setSkill(skill, getSkillNev(skill));
        dolgozo.setKezdesDatum(ROVID_DATUM_ADATBAZIS.format(kezdesDatum));
        dolgozo.setTelSzam(telSzam);
        try {
            lDAO.modositDolgozo(dolgozo, SQL_MODOSIT_DOLGOZO);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void csapatModosit(Csapat csapat, String nev, Object csapatvezeto) {
        csapat.setNev(nev);
        csapat.setCsapatvezeto((Dolgozo) csapatvezeto);
        try {
            lDAO.modositCsapat(csapat, SQL_MODOSIT_CSAPAT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void projektTorlese(Projekt projekt) {
        try {
            lDAO.torolProjekt(projekt, SQL_TOROL_PROJEKTRE_HIVATKOZO_FELADAT, SQL_TOROL_PROJEKTRE_HIVATKOZO_JELENTES, SQL_TOROL_PROJEKT_CSAPAT, SQL_TOROL_PROJEKT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void megrendeloTorlese(Megrendelo megrendelo) {
        try {
            lDAO.torolMegrendelo(megrendelo, SQL_TOROL_PROJEKT_MEGRENDELO, SQL_TOROL_MEGRENDELO);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void feladatTorlese(Feladat feladat) {
        try {
            lDAO.torolFeladat(feladat, SQL_TOROL_FELADAT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void jelentesTorlese(Jelentes jelentes) {
        try {
            lDAO.torolJelentes(jelentes, SQL_TOROL_JELENTES);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void dolgozoTorlese(Dolgozo dolgozo) {
        try {
            lDAO.torolDolgozo(dolgozo, SQL_TOROL_DOLGOZO);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void csapatTorlese(Csapat csapat) {
        try {
            lDAO.torolCsapat(csapat, SQL_TOROL_CSAPAT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void projektenDolgozoCsapatokMent(Object projekt, ListModel<String> listaModell) {
        Projekt aktProjekt = (Projekt) projekt;
        ArrayList<Csapat> projektenDolgozoCsapatok = new ArrayList<>();
        DefaultListModel dlmListaModell = (DefaultListModel) listaModell;

        for (int i = 0; i < dlmListaModell.size(); i++) {
            projektenDolgozoCsapatok.add((Csapat) dlmListaModell.getElementAt(i));
        }

        try {
            lDAO.projektenDolgozoCsapatokMent(aktProjekt, projektenDolgozoCsapatok, SQL_PROJEKTEN_DOLGOZO_CSAPATOK_TORLESE, SQL_PROJEKTEN_DOLGOZO_CSAPATOK_MENT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void csapattagokMent(Object csapat, ListModel<String> listaModell) {
        Csapat aktCsapat = (Csapat) csapat;
        ArrayList<Dolgozo> csapattagok = new ArrayList<>();
        DefaultListModel dlmListaModell = (DefaultListModel) listaModell;

        for (int i = 0; i < dlmListaModell.size(); i++) {
            csapattagok.add((Dolgozo) dlmListaModell.getElementAt(i));
        }

        try {
            lDAO.csapattagokMent(aktCsapat, csapattagok, SQL_CSAPATTAGOK_TORLESE, SQL_CSAPATTAGOK_MENT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean belepesAdatokVizsgal(int ID, String jelszo, int beosztasAzon) {
        boolean helyesAdat = false;
        String titkositottJelszo = jelszoTitkosit(jelszo, String.valueOf(beosztasAzon)); // jelszó hashelés + sózás
        try {
            belepettDolgozo = lDAO.belepesAdatokVizsgal(ID, titkositottJelszo, beosztasAzon, SQL_BELEPES_ADATOK_VIZSGAL);
            if (belepettDolgozo != null) {
                helyesAdat = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return helyesAdat;
    }

    public Dolgozo getBelepettDolgozo() {
        return belepettDolgozo;
    }

    public void setBelepettDolgozo(Dolgozo belepettDolgozo) {
        this.belepettDolgozo = belepettDolgozo;
    }

    public String jelszoTitkosit(String jelszo, String so) {
        StringBuilder sbTitkositottJelszo = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            jelszo = jelszo + so;
            byte[] bajtTomb = null;
            for (int i = 0; i < 100; i++) {
                bajtTomb = md.digest(jelszo.getBytes());
            }

            for (int i = 0; i < bajtTomb.length; i++) {
                sbTitkositottJelszo.append(Integer.toString((bajtTomb[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sbTitkositottJelszo.toString();
    }

    public boolean jelenlegiJelszoVizsgal(String jJelszo) {
        String titkositottJjelszo = jelszoTitkosit(jJelszo, String.valueOf(belepettDolgozo.getBeosztasID()));
        return titkositottJjelszo.equals(belepettDolgozo.getJelszo());
    }

    public void jelszoValtoztatas(String uJelszo) {
        String titkositottJelszo = jelszoTitkosit(uJelszo, String.valueOf(belepettDolgozo.getBeosztasID()));
        belepettDolgozo.setJelszo(titkositottJelszo);
        try {
            lDAO.ujJelszoMent(titkositottJelszo, belepettDolgozo, SQL_JELSZO_MENT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void bejelentkezesIdoMent() {
        try {
            lDAO.bejelentkezesIdoMent(belepettDolgozo, ROVID_DATUM_IDO_ADATBAZIS.format(new Date()), SQL_DOLGOZO_BEJELENTKEZES_IDO_MENT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ProjektTablaModell getCsapatvezetoAktivProjektTablaModell() {
        ArrayList<Projekt> lista = new ArrayList<>();
        try {
            lista = lDAO.getCsvezetoProjektLista(belepettDolgozo, SQL_CSVEZETO_AKTIV_PROJEKTEK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new ProjektTablaModell(lista);
    }

    public ProjektTablaModell getCsapatvezetoOsszesProjektTablaModell() {
        try {
            csVezetoOsszesProjektlista = lDAO.getCsvezetoProjektLista(belepettDolgozo, SQL_CSVEZETO_OSSZES_PROJEKTEK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new ProjektTablaModell(csVezetoOsszesProjektlista);
    }

    public ProjektTablaModell getCsvezetoKeresettProjektekTablaModell(String nev) {
        ArrayList<Projekt> lista = new ArrayList<>();
        try {
            lista = lDAO.getCsvezetoKeresettProjektek(belepettDolgozo, nev, SQL_CSVEZETO_PROJEKT_KERES);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new ProjektTablaModell(lista);
    }

    public DefaultComboBoxModel getCsvezetoProjektCBModell() {
        getCsapatvezetoOsszesProjektTablaModell();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (Projekt aktProjekt : csVezetoOsszesProjektlista) {
            dcbm.addElement(aktProjekt);
        }

        return dcbm;
    }

    public FeladatTablaModell getCsapatvezetoAktivFeldatTablaModell() {
        ArrayList<Feladat> lista = new ArrayList<>();
        try {
            lista = lDAO.getCsvezetoFeldatLista(belepettDolgozo, SQL_CSVEZETO_AKTIV_FELADAT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new FeladatTablaModell(lista);
    }

    public FeladatTablaModell getCsapatvezetoOsszesFeladatTablaModell() {
        ArrayList<Feladat> lista = new ArrayList<>();
        try {
            lista = lDAO.getCsvezetoFeldatLista(belepettDolgozo, SQL_CSVEZETO_OSSZES_FELADAT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new FeladatTablaModell(lista);
    }

    public FeladatTablaModell getCsvezetoKeresettFeladatTablaModell(String targy) {
        ArrayList<Feladat> lista = new ArrayList<>();
        try {
            lista = lDAO.getCsvezetoKeresettFeladat(belepettDolgozo, targy, SQL_CSVEZETO_FELADAT_KERES);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new FeladatTablaModell(lista);
    }

    public JelentesTablaModell getCsapatvezetoJelentesekTablaModell() {
        try {
            jelentesLista = lDAO.getCsvezetoJelentesek(belepettDolgozo, SQL_CSVEZETO_JELENTESEK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new JelentesTablaModell(jelentesLista);
    }

    public JelentesTablaModell getCsapatvezetoJelentesekKTablaModell() {
        try {
            jelentesLista = lDAO.getCsvezetoJelentesek(belepettDolgozo, SQL_SAJAT_JELENTESEK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new JelentesTablaModell(jelentesLista);
    }

    public ProjektTablaModell getFejlesztoAktivProjektTablaModell() {
        ArrayList<Projekt> lista = new ArrayList<>();
        try {
            lista = lDAO.getCsvezetoProjektLista(belepettDolgozo, SQL_FEJLESZTO_AKTIV_PROJEKTEK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new ProjektTablaModell(lista);
    }

    public ProjektTablaModell getFejlesztoOsszesProjektTablaModell() {
        try {
            fejlesztoOsszesProjektlista = lDAO.getCsvezetoProjektLista(belepettDolgozo, SQL_FEJLESZTO_OSSZES_PROJEKTEK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new ProjektTablaModell(fejlesztoOsszesProjektlista);
    }

    public DefaultComboBoxModel getFejlesztoProjektCBModell() {
        getFejlesztoOsszesProjektTablaModell();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (Projekt aktProjekt : fejlesztoOsszesProjektlista) {
            dcbm.addElement(aktProjekt);
        }

        return dcbm;
    }

    public ProjektTablaModell getFejlesztoKeresettProjektekTablaModell(String nev) {
        ArrayList<Projekt> lista = new ArrayList<>();
        try {
            lista = lDAO.getCsvezetoKeresettProjektek(belepettDolgozo, nev, SQL_FEJLESZTO_PROJEKT_KERES);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new ProjektTablaModell(lista);
    }

    public ProjektTablaModell getFejlesztoReszletesKeresesProjektekTablaModell(Megrendelo megrendelo, int FTerulet, String dtol, String dig, int holTart, int prioritas, Dolgozo dolgozo, int statusz) {
        ArrayList<Projekt> lista = new ArrayList<>();
        try {
            lista = lDAO.getCsVezetoReszletesKeresesProjektek(belepettDolgozo, megrendelo, FTerulet, dtol, dig, holTart, prioritas, dolgozo, statusz, SQL_FEJLESZTO_PROJEKT_RESZLETES_KERES);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ProjektTablaModell(lista);
    }

    public ProjektTablaModell getCsVezetoReszletesKeresesProjektekTablaModell(Megrendelo megrendelo, int FTerulet, String dtol,
            String dig, int holTart, int prioritas, Dolgozo dolgozo, int statusz) {
        ArrayList<Projekt> lista = new ArrayList<>();
        try {
            lista = lDAO.getCsVezetoReszletesKeresesProjektek(belepettDolgozo, megrendelo, FTerulet, dtol, dig, holTart, prioritas, dolgozo, statusz, SQL_CSVEZETO_PROJEKT_RESZLETES_KERES);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ProjektTablaModell(lista);
    }

    public JelentesTablaModell getFejlesztoJelentesekTablaModell() {
        try {
            jelentesLista = lDAO.getCsvezetoJelentesek(belepettDolgozo, SQL_FEJLESZTO_JELENTESEK);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new JelentesTablaModell(jelentesLista);
    }

    public void pdfGeneral(String fajlNev, String fejlecSzoveg, String[] oszlopNevek, ArrayList lista) {
        try {
            Document pdfFajl = new Document(PageSize.A4.rotate(), 50, 50, 30, 20);
            Date aktualisDatumIdo = new Date();
            String teljesFajlNev = fajlNev + "_" + ROVID_DATUM_IDO_FAJLNEV.format(aktualisDatumIdo) + ".pdf";
            String fajlMappaNeve = "files";
            Path mappa = Paths.get(fajlMappaNeve);
            if(!Files.exists(mappa)){
                Files.createDirectory(mappa);
            }
            PdfWriter.getInstance(pdfFajl, new FileOutputStream(fajlMappaNeve + "/" + teljesFajlNev));
            pdfFajl.open();
            //oldal fejléce
            BaseFont betutipus = BaseFont.createFont(
                    BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
            Paragraph fejlec
                    = new Paragraph(fejlecSzoveg, new Font(betutipus, 20, Font.BOLD));
            fejlec.setAlignment(Paragraph.ALIGN_CENTER);
            pdfFajl.add(fejlec);
            //táblázat
            PdfPTable tablazat = new PdfPTable(oszlopNevek.length);
            tablazat.setWidthPercentage(100);
            tablazat.setSpacingBefore(40);
            //táblázat fejléce
            for (String oszlopNev : oszlopNevek) {
                tablazat.addCell(cella(oszlopNev, 10, true, Paragraph.ALIGN_CENTER));
            }
            //táblázat adatai
            ArrayList<ArrayList<String>> adatok = getListaadatok(lista);
            for (ArrayList<String> sor : adatok) {
                for (String adat : sor) {
                    tablazat.addCell(cella(adat, 10, false, Paragraph.ALIGN_LEFT));
                }
            }
            pdfFajl.add(tablazat);
            pdfFajl.add(new Paragraph("Fájl generálva: " + HOSSZU_DATUM_IDO.format(aktualisDatumIdo), new Font(betutipus, 8)));
            pdfFajl.close();
            vezerlo.infoAblakFeldob("A PDF fájl elkészült!", "Info");
        } catch (DocumentException | IOException e) {
            vezerlo.hibaAblakFeldob("Hiba a PDF fájl generálása során!", "Hiba");
            e.printStackTrace();
        }
    }

    private PdfPCell cella(String szoveg, int betumeret, boolean felkover,
            int igazitas) throws DocumentException, IOException {
        PdfPCell cella = new PdfPCell();
        BaseFont betutipus = BaseFont.createFont(
                BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
        Paragraph bekezdes = new Paragraph(szoveg,
                new Font(betutipus, betumeret, felkover ? Font.BOLD : Font.NORMAL));
        bekezdes.setAlignment(igazitas);
        cella.addElement(bekezdes);
        cella.setPaddingBottom(3);
        cella.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        cella.setVerticalAlignment(Paragraph.ALIGN_CENTER);
        return cella;
    }

    private ArrayList<ArrayList<String>> getListaadatok(ArrayList lista) {
        ArrayList<ArrayList<String>> adatok = new ArrayList<>();

        Object elsoElem = lista.get(0);
        if (elsoElem instanceof Projekt) {
            ArrayList<Projekt> aktProjektLista = (ArrayList<Projekt>) lista;
            for (Projekt projekt : aktProjektLista) {
                adatok.add(projekt.getAdatokStringLista());
            }
        } else if (elsoElem instanceof Megrendelo) {
            ArrayList<Megrendelo> aktMegrendeloLista = (ArrayList<Megrendelo>) lista;
            for (Megrendelo megrendelo : aktMegrendeloLista) {
                adatok.add(megrendelo.getAdatokStringLista());
            }
        } else if (elsoElem instanceof Feladat) {
            ArrayList<Feladat> aktFeladatLista = (ArrayList<Feladat>) lista;
            for (Feladat feladat : aktFeladatLista) {
                adatok.add(feladat.getAdatokStringLista());
            }
        }
        return adatok;
    }

    public void jelentesPDFGeneral(Jelentes jelentes) {
        try {
            Document pdfFajl = new Document(PageSize.A4, 50, 50, 30, 20);
            Date aktualisDatumIdo = new Date();
            String teljesFajlNev = "jelentes_" + ROVID_DATUM_IDO_FAJLNEV.format(aktualisDatumIdo) + ".pdf";
            String fajlMappaNeve = "files";
            Path mappa = Paths.get(fajlMappaNeve);
            if(!Files.exists(mappa)){
                Files.createDirectory(mappa);
            }
            PdfWriter.getInstance(pdfFajl, new FileOutputStream(fajlMappaNeve + "/" + teljesFajlNev));
            pdfFajl.open();
            //oldal fejléce
            BaseFont betutipus = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
            Paragraph fejlec = new Paragraph("Jelentés", new Font(betutipus, 20, Font.BOLD));
            fejlec.setAlignment(Paragraph.ALIGN_CENTER);
            fejlec.setSpacingAfter(40);
            pdfFajl.add(fejlec);
            // Adatok
            Paragraph jelentesAdatok = new Paragraph();
            jelentesAdatok.setFont(new Font(betutipus, 14, Font.BOLD));
            jelentesAdatok.add("Jelentést készítette : " + jelentes.getFelvitte().getNev() + "\n\n");
            jelentesAdatok.add("Projekt neve : " + jelentes.getProjekt() + "\n\n");
            Date felvitelDatum = new Date();
            try {
                felvitelDatum = ROVID_DATUM_IDO_ADATBAZIS.parse(jelentes.getFelvitelDatuma());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            jelentesAdatok.add("Felvitel dátuma : " + HOSSZU_DATUM_IDO.format(felvitelDatum) + "\n\n");
            jelentesAdatok.setSpacingAfter(20);
            pdfFajl.add(jelentesAdatok);
            // vonal szeparátor
            pdfFajl.add(new Chunk(new LineSeparator()));
            // szöveg
            Paragraph jelentesLeiras = new Paragraph();
            jelentesLeiras.setFont(new Font(betutipus, 14));
            jelentesLeiras.setSpacingBefore(20);
            jelentesLeiras.add(jelentes.getSzoveg());
            jelentesLeiras.setSpacingAfter(20);
            pdfFajl.add(jelentesLeiras);
            pdfFajl.add(new Paragraph("Fájl generálva: " + HOSSZU_DATUM_IDO.format(aktualisDatumIdo), new Font(betutipus, 8)));
            pdfFajl.close();
            vezerlo.infoAblakFeldob("A PDF fájl elkészült!", "Info");
        } catch (DocumentException | IOException e) {
            vezerlo.hibaAblakFeldob("Hiba a PDF fájl generálása során!", "Hiba");
            e.printStackTrace();
        }
    }
}