package projektmenedzsmentrendszer.vezerlo;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ComboBoxModel;
import projektmenedzsmentrendszer.modell.tablamodellek.*;
import projektmenedzsmentrendszer.modell.pojoosztalyok.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableModel;
import projektmenedzsmentrendszer.nezet.*;
import projektmenedzsmentrendszer.modell.*;

enum BelepesiSzint {
    PROJEKTVEZETO,
    CSAPATVEZETO,
    FEJLESZTO
}

public class Vezerlo {
    private final Modell modell;
    private BelepesAblak belepesAblak;
    private ProjektvezetoFoablak projektvezetoFoablak;
    private CsapatvezetoFoablak csapatvezetoFoablak;
    private FejlesztoFoablak fejlesztoFoablak;
    private FooldalTobbinfoAblak fooldalTobbinfoAblak;
    private BelepesiSzint belepesiSzint;

    public Vezerlo() {
        kinezetBeallit();
        this.belepesAblak = new BelepesAblak(this);
        this.modell = new Modell(this);
    }

    public void bejelentkezes(String ID, char[] jelszo, int kivalasztottBeosztasIndex) {
        if (modell != null) {
            if (belepesFelhJelszoVizsgal(ID, jelszo, kivalasztottBeosztasIndex)) {
                belepesAblak.dispose();
                switch (kivalasztottBeosztasIndex) {
                    case 1:
                        belepesiSzint = BelepesiSzint.PROJEKTVEZETO;
                        projektvezetoFoablak = new ProjektvezetoFoablak(this);
                        modell.bejelentkezesIdoMent();
                        break;
                    case 2:
                        belepesiSzint = BelepesiSzint.CSAPATVEZETO;
                        csapatvezetoFoablak = new CsapatvezetoFoablak(this);
                        modell.bejelentkezesIdoMent();
                        break;
                    case 3:
                        belepesiSzint = BelepesiSzint.FEJLESZTO;
                        fejlesztoFoablak = new FejlesztoFoablak(this);
                        modell.bejelentkezesIdoMent();
                        break;
                }
            }
        } else {
            belepesAblak.infoAblak("Adatbázishoz kapcsolódás folyamatban.", "Kapcsolódás");
        }
    }

    public boolean belepesFelhJelszoVizsgal(String pID, char[] pJelszo, int kivalasztottBeosztasIndex) {
        boolean helyesAdatok = false;
        int ID;
        String jelszo = String.valueOf(pJelszo);

        // ID mezőbe beírt adat ellenőrzése
        if (pID != null && pID.trim().length() > 0) {
            try {
                ID = Integer.parseInt(pID);
                // Jelszó mezőbe beírt adat ellenőrzése
                if (jelszo != null && jelszo.trim().length() > 0) {
                    // adatok helyességének ellenőrzése az adatbázisban lévő adatokkal
                    if (modell.belepesAdatokVizsgal(ID, jelszo, kivalasztottBeosztasIndex)) {
                        helyesAdatok = true;
                    } else {
                        belepesAblak.hibaAblak("Hibás dolgozó ID vagy jelszó!", "Hiba");
                    }
                } else {
                    belepesAblak.infoAblak("A jelszó mező nem lehet üres!", "Üres mező");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                belepesAblak.infoAblak("Az ID mezőben csak egész szám lehet!", "Nem megfelelő adat");
            }
        } else {
            belepesAblak.infoAblak("Az ID mező nem lehet üres!", "Üres mező");
        }

        return helyesAdatok;
    }

    public void kijelentkezes() {
        switch (belepesiSzint) {
            case PROJEKTVEZETO:
                modell.setBelepettDolgozo(null);
                projektvezetoFoablak.dispose();
                belepesAblak = new BelepesAblak(this);
                break;
            case CSAPATVEZETO:
                modell.setBelepettDolgozo(null);
                csapatvezetoFoablak.dispose();
                belepesAblak = new BelepesAblak(this);
                break;
            case FEJLESZTO:
                modell.setBelepettDolgozo(null);
                fejlesztoFoablak.dispose();
                belepesAblak = new BelepesAblak(this);
                break;
        }
    }

    public void jelszovaltoztatas(FoAblak foAblak, char[] jelenlegiJelszo, char[] ujJelszo, char[] megerosites) {
        String jJelszo = String.valueOf(jelenlegiJelszo);
        String uJelszo = String.valueOf(ujJelszo);
        String megerosit = String.valueOf(megerosites);

        if (jJelszo != null && jJelszo.trim().length() > 0) {
            if (uJelszo != null && uJelszo.trim().length() > 0) {
                if (megerosit != null && megerosit.trim().length() > 0) {
                    if (uJelszo.equals(megerosit)) {
                        if (!jJelszo.equals(uJelszo)) {
                            if (modell.jelenlegiJelszoVizsgal(jJelszo)) {
                                modell.jelszoValtoztatas(uJelszo);
                                foAblak.jelszovaltPanelAlaphelyzet();
                                foAblak.infoAblak("Az új jelszó elmentve!", "Jelszó elmentve");
                            } else {
                                foAblak.hibaAblak("Hibás a megadott jelenlegi jelszó!", "Hiba");
                            }
                        } else {
                            foAblak.infoAblak("Az új jelszó nem egyezhet a jelenlegivel!", "Info");
                        }
                    } else {
                        foAblak.infoAblak("Az új jelszó és a megerősített jelszónak egyeznie kell!", "Info");
                    }
                } else {
                    foAblak.infoAblak("Az új jelszó megerősítése mező nem lehet üres!", "Üres mező");
                }
            } else {
                foAblak.infoAblak("Az új jelszó mező nem lehet üres!", "Üres mező");
            }
        } else {
            foAblak.infoAblak("A jelenlegi jelszó mező nem lehet üres!", "Üres mező");
        }
    }

    public void keszitTobbinfoAblak(int kivalasztottSor) {
        Projekt kivalasztottProjekt;
        switch (belepesiSzint) {
            case PROJEKTVEZETO:
                kivalasztottProjekt = (Projekt) projektvezetoFoablak.getTblFooldalProjektek().getValueAt(kivalasztottSor, ProjektTablaModell.OBJECT_OSZLOP);

                projektvezetoFoablak.setEnabled(false);
                fooldalTobbinfoAblak = new FooldalTobbinfoAblak(this);
                fooldalTobbinfoAblak.comboBoxFrissit(fooldalTobbinfoAblak.getCbProjekt(), getProjektCBModell());
                fooldalTobbinfoAblak.getCbProjekt().setSelectedIndex(getKivalasztottProjektIndex(kivalasztottProjekt, fooldalTobbinfoAblak.getCbProjekt().getModel()));
                fooldalTobbinfoAblak.csapatokListaKiir(kivalasztottProjekt.getAzon());
                break;
            case CSAPATVEZETO:
                kivalasztottProjekt = (Projekt) csapatvezetoFoablak.getTblFooldalProjektek().getValueAt(kivalasztottSor, ProjektTablaModell.OBJECT_OSZLOP);

                csapatvezetoFoablak.setEnabled(false);
                fooldalTobbinfoAblak = new FooldalTobbinfoAblak(this);
                fooldalTobbinfoAblak.comboBoxFrissit(fooldalTobbinfoAblak.getCbProjekt(), getCsvezetoProjektCBModell());
                fooldalTobbinfoAblak.getCbProjekt().setSelectedIndex(getKivalasztottProjektIndex(kivalasztottProjekt, fooldalTobbinfoAblak.getCbProjekt().getModel()));
                fooldalTobbinfoAblak.csapatokListaKiir(kivalasztottProjekt.getAzon());
                break;
            case FEJLESZTO:
                kivalasztottProjekt = (Projekt) fejlesztoFoablak.getTblFooldalProjektek().getValueAt(kivalasztottSor, ProjektTablaModell.OBJECT_OSZLOP);

                fejlesztoFoablak.setEnabled(false);
                fooldalTobbinfoAblak = new FooldalTobbinfoAblak(this);
                fooldalTobbinfoAblak.comboBoxFrissit(fooldalTobbinfoAblak.getCbProjekt(), getFejlesztoProjektCBModell());
                fooldalTobbinfoAblak.getCbProjekt().setSelectedIndex(getKivalasztottProjektIndex(kivalasztottProjekt, fooldalTobbinfoAblak.getCbProjekt().getModel()));
                fooldalTobbinfoAblak.csapatokListaKiir(kivalasztottProjekt.getAzon());
                break;
        }
        fooldalTobbinfoAblak.alapHelyzet();
    }

    public void infoKilep() {
        switch (belepesiSzint) {
            case PROJEKTVEZETO:
                projektvezetoFoablak.setEnabled(true);
                fooldalTobbinfoAblak.dispose();
                break;
            case CSAPATVEZETO:
                csapatvezetoFoablak.setEnabled(true);
                fooldalTobbinfoAblak.dispose();
                break;
            case FEJLESZTO:
                fejlesztoFoablak.setEnabled(true);
                fooldalTobbinfoAblak.dispose();
                break;
        }
    }

    private void kinezetBeallit() {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.err.println(e.getMessage());
        }
    }

    public ProjektTablaModell getFooldalAttekintoTablaAktivP() {
        ProjektTablaModell ptm = new ProjektTablaModell();
        switch (belepesiSzint) {
            case PROJEKTVEZETO:
                ptm = modell.getAktivProjektTablaModell();
                break;
            case CSAPATVEZETO:
                ptm = modell.getCsapatvezetoAktivProjektTablaModell();
                break;
            case FEJLESZTO:
                ptm = modell.getFejlesztoAktivProjektTablaModell();
                break;
        }
        return ptm;
    }

    public ProjektTablaModell getFooldalAttekintoTablaOsszesP() {
        ProjektTablaModell ptm = new ProjektTablaModell();
        switch (belepesiSzint) {
            case PROJEKTVEZETO:
                ptm = modell.getOsszesProjektTablaModell();
                break;
            case CSAPATVEZETO:
                ptm = modell.getCsapatvezetoOsszesProjektTablaModell();
                break;
            case FEJLESZTO:
                ptm = modell.getFejlesztoOsszesProjektTablaModell();
                break;
        }
        return ptm;
    }

    public ProjektTablaModell getKeresProjektTabla(String nev) {
        ProjektTablaModell ptm = new ProjektTablaModell();
        switch (belepesiSzint) {
            case PROJEKTVEZETO:
                if (nev != null && nev.trim().length() > 0) {
                    ptm = modell.getKeresettProjektekTablaModell(nev);
                } else {
                    projektvezetoFoablak.infoAblak("A projekt neve mező nem lehet üres!", "Nem megfelelő paraméter");
                    if (projektvezetoFoablak.getTbFooldalAktivP().isSelected()) {
                        ptm = getFooldalAttekintoTablaAktivP();
                    } else {
                        ptm = getFooldalAttekintoTablaOsszesP();
                    }
                }
                break;
            case CSAPATVEZETO:
                if (nev != null && nev.trim().length() > 0) {
                    ptm = modell.getCsvezetoKeresettProjektekTablaModell(nev);
                } else {
                    csapatvezetoFoablak.infoAblak("A projekt neve mező nem lehet üres!", "Nem megfelelő paraméter");
                    if (csapatvezetoFoablak.getTbFooldalAktivP().isSelected()) {
                        ptm = getFooldalAttekintoTablaAktivP();
                    } else {
                        ptm = getFooldalAttekintoTablaOsszesP();
                    }
                }
                break;
            case FEJLESZTO:
                if (nev != null && nev.trim().length() > 0) {
                    ptm = modell.getFejlesztoKeresettProjektekTablaModell(nev);
                } else {
                    fejlesztoFoablak.infoAblak("A projekt neve mező nem lehet üres!", "Nem megfelelő paraméter");
                    if (fejlesztoFoablak.getTbFooldalAktivP().isSelected()) {
                        ptm = getFooldalAttekintoTablaAktivP();
                    } else {
                        ptm = getFooldalAttekintoTablaOsszesP();
                    }
                }
                break;
        }
        return ptm;
    }

    public FeladatTablaModell getFeladatokTablaAktivF() {
        FeladatTablaModell ftm = new FeladatTablaModell();
        switch (belepesiSzint) {
            case PROJEKTVEZETO:
                ftm = modell.getAktivFeladatTablaModell();
                break;
            case CSAPATVEZETO:
                ftm = modell.getCsapatvezetoAktivFeldatTablaModell();
                break;
        }
        return ftm;
    }

    public MegrendeloTablaModell getProjektMegrendelokTabla() {
        return modell.getMegrendelokTablaModell();
    }

    public FeladatTablaModell getFeladatokTablaOsszesF() {
        FeladatTablaModell ptm = new FeladatTablaModell();
        switch (belepesiSzint) {
            case PROJEKTVEZETO:
                ptm = modell.getOsszesFeladatTablaModell();
                break;
            case CSAPATVEZETO:
                ptm = modell.getCsapatvezetoOsszesFeladatTablaModell();
                break;
        }
        return ptm;
    }

    public Projekt getKivalasztottProjekt(int kivalasztottSor) {
        return modell.getKivalasztottProjekt(kivalasztottSor);
    }

    public Feladat getKivalasztottFeladat(int kivalasztottSor) {
        return modell.getKivalasztottFeladat(kivalasztottSor);
    }

    public Jelentes getKivalasztottJelentes(int kivalasztottSor) {
        return modell.getKivalasztottJelentes(kivalasztottSor);
    }

    public void infoAblakFeldob(String uzenet, String fejlec) {
        belepesAblak.infoAblak(uzenet, fejlec);
    }

    public void hibaAblakFeldob(String uzenet, String fejlec) {
        belepesAblak.hibaAblak(uzenet, fejlec);
    }

    public FeladatTablaModell getKeresFeladatTabla(String targy) {
        FeladatTablaModell keresettFeladatok = new FeladatTablaModell();
        switch (belepesiSzint) {
            case PROJEKTVEZETO:
                if (targy != null && targy.trim().length() > 0) {
                    keresettFeladatok = modell.getKeresettFeladatTablaModell(targy);
                } else {
                    projektvezetoFoablak.infoAblak("A feladat neve mező nem lehet üres!", "Nem megfelelő paraméter");
                    if (projektvezetoFoablak.getTbFeladatokAktivP().isSelected()) {
                        keresettFeladatok = getFeladatokTablaAktivF();
                    } else {
                        keresettFeladatok = getFeladatokTablaOsszesF();
                    }
                }
                break;
            case CSAPATVEZETO:
                if (targy != null && targy.trim().length() > 0) {
                    keresettFeladatok = modell.getCsvezetoKeresettFeladatTablaModell(targy);
                } else {
                    csapatvezetoFoablak.infoAblak("A projekt neve mező nem lehet üres!", "Nem megfelelő paraméter");
                    if (csapatvezetoFoablak.getTbFooldalAktivP().isSelected()) {
                        keresettFeladatok = getFeladatokTablaAktivF();
                    } else {
                        keresettFeladatok = getFeladatokTablaOsszesF();
                    }
                }
                break;
        }
        return keresettFeladatok;
    }

    public JelentesTablaModell getJelentesekTabla() {
        JelentesTablaModell jtm = new JelentesTablaModell();
        switch (belepesiSzint) {
            case PROJEKTVEZETO:
                jtm = modell.getJelentesekTablaModell();
                break;
            case CSAPATVEZETO:
                jtm = modell.getCsapatvezetoJelentesekTablaModell();
                break;
            case FEJLESZTO:
                jtm = modell.getFejlesztoJelentesekTablaModell();
                break;
        }
        return jtm;
    }

    public DolgozoTablaModell getDolgozokTabla() {
        return modell.getDolgozokTablaModell();
    }

    public CsapatTablaModell getCsapatokTabla() {
        return modell.getCsapatokTablaModell();
    }

    public DefaultComboBoxModel getMegrendelokCBModell() {
        return modell.getMegrendelokCBModell();
    }

    public DefaultComboBoxModel getFTeruletCBModell() {
        return modell.getFTeruletCBModell();
    }

    public DefaultComboBoxModel getHolTartCBModell() {
        return modell.getHolTartCBModell();
    }

    public DefaultComboBoxModel getPrioritasCBModell() {
        return modell.getPrioritasCBModell();
    }

    public DefaultComboBoxModel getProjektvezetoCBModell() {
        return modell.getProjektvezetoCBModell();
    }

    public DefaultComboBoxModel getStatuszCBModell() {
        return modell.getStatuszCBModell();
    }

    public ProjektTablaModell getReszletesKeresesProjektekTabla(
            Object megrendelo, int FTerulet, Date datumtol, Date datumig,
            int holTart, int prioritas, Object projektvezeto, int statusz) {
        String dtol = "";
        String dig = "";
        if (datumtol != null && datumig != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dtol = sdf.format(datumtol);
            dig = sdf.format(datumig);
        }

        if (dtol.length() <= 0) {
            dtol = "1900-01-01";
        }

        if (dig.length() <= 0) {
            dig = "2100-01-01";
        }

        ProjektTablaModell ptm = new ProjektTablaModell();
        switch (belepesiSzint) {
            case PROJEKTVEZETO:
                ptm = modell.getReszletesKeresesProjektekTablaModell((Megrendelo) megrendelo, FTerulet, dtol, dig, holTart, prioritas, (Dolgozo) projektvezeto, statusz);
                break;
            case CSAPATVEZETO:
                ptm = modell.getCsVezetoReszletesKeresesProjektekTablaModell((Megrendelo) megrendelo, FTerulet, dtol, dig, holTart, prioritas, (Dolgozo) projektvezeto, statusz);
                break;
            case FEJLESZTO:
                ptm = modell.getFejlesztoReszletesKeresesProjektekTablaModell((Megrendelo) megrendelo, FTerulet, dtol, dig, holTart, prioritas, (Dolgozo) projektvezeto, statusz);
                break;
        }
        return ptm;
    }

    public DefaultComboBoxModel getCsapatvezetoCBModell() {
        return modell.getCsapatvezetoCBModell();
    }

    public DefaultComboBoxModel getProjektCBModell() {
        return modell.getProjekCBModell();
    }

    public DefaultComboBoxModel getCsvezetoProjektCBModell() {
        return modell.getCsvezetoProjektCBModell();
    }

    public DefaultComboBoxModel getBeosztasCBModell() {
        return modell.getBeosztasCBModell();
    }

    public DefaultComboBoxModel getSkillCBModell() {
        return modell.getSkillCBModell();
    }

    public DefaultComboBoxModel getCsapatCBModell() {
        return modell.getCsapatCBModell();
    }

    public DefaultListModel getKivalasztottProjektenDolgozoCsapatokLModell(int kivalasztottProjektAzon) {
        return modell.getProjektenDolgozoCsapatokLModell(kivalasztottProjektAzon);
    }

    public DefaultListModel getCsapatokLModell(Projekt kivalasztottProjekt) {
        return modell.getCsapatokLModell(kivalasztottProjekt);
    }

    public DefaultListModel getKivalasztottCsapatTagjaiLModell(Object kivalasztottCsapat) {
        return modell.getCsapatTagjaiLModell((Csapat) kivalasztottCsapat);
    }

    public DefaultListModel getDolgozokLModell(Object csapat) {
        return modell.getDolgozokLModell((Csapat) csapat);
    }

    public void projektHozzaadd(String nev, Object megrendelo, int fTerulet, Date megrendDatum, Date hatarido,
            int holTart, int prioritas, int statusz, String leiras) {

        if (nev != null && nev.trim().length() > 0 && nev.length() <= 50 && megrendDatum != null && hatarido != null) {
            modell.projektHozzaadd(nev, (Megrendelo) megrendelo, fTerulet, megrendDatum, hatarido, holTart, prioritas, statusz, leiras);
            projektvezetoFoablak.projektPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("A projekt hozzáadva!", "Info");
        } else {
            projektvezetoFoablak.infoAblak("Csak a leírás mező lehet üres!", "Info");
        }
    }

    public void megrendeloHozzaadd(String nev, String telefonszam, String email, String weboldal, String iranyitoszam, String helyseg, String utcaHazszam) {
        if (nev != null && nev.trim().length() > 0 && telefonszam != null && telefonszam.trim().length() > 0 && email != null && email.trim().length() > 0
                && iranyitoszam != null && iranyitoszam.trim().length() > 0 && helyseg != null && helyseg.trim().length() > 0
                && utcaHazszam != null && utcaHazszam.trim().length() > 0) {
            modell.megrendeloHozzaadd(nev, telefonszam, email, weboldal, iranyitoszam, helyseg, utcaHazszam);
            projektvezetoFoablak.megrendPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Megrendelő hozzáadva!", "Info");
        } else {
            projektvezetoFoablak.infoAblak("Csak a weboldal mező lehet üres!", "Info");
        }
    }

    public void feladatHozzaadd(String feladatTargya, Date hataridoDatum, Object felelos, Object projekt, int statusz, String leiras) {
        if (feladatTargya != null && feladatTargya.trim().length() > 0 && hataridoDatum != null) {
            modell.feladatHozzaadd(feladatTargya, hataridoDatum, (Dolgozo) felelos, (Projekt) projekt, statusz, leiras);
            projektvezetoFoablak.feladatPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Feladat hozzáadva!", "Info");
        } else {
            projektvezetoFoablak.infoAblak("Csak a leírás mező lehet üres!", "Info");
        }
    }

    public void jelentesHozzaadd(Object projekt, String leiras) {
        if (leiras != null && leiras.trim().length() > 0) {
            modell.jelentesHozzaadd((Projekt) projekt, leiras);
            projektvezetoFoablak.jelentesPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Jelentés hozzáadva!", "Info");
        } else {
            projektvezetoFoablak.infoAblak("A leírás mező nem lehet üres!", "Info");
        }
    }

    public void dolgozoHozzaadd(String nev, int beosztas, int fTerulet, int skill, Date kezdesDatum, String telSzam) {
        if (nev != null && nev.trim().length() > 0 && kezdesDatum != null && telSzam != null && telSzam.trim().length() > 0) {
            modell.dolgozoHozzaadd(nev, beosztas, fTerulet, skill, kezdesDatum, telSzam);
            projektvezetoFoablak.dolgozoPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Dolgozo hozzáadva!", "Info");
        } else {
            projektvezetoFoablak.infoAblak("Nem lehet üres mező!", "Info");
        }
    }

    public void csapatHozzaadd(String nev, Object csapatvezeto) {
        if (nev != null && nev.trim().length() > 0) {
            modell.csapatHozzaadd(nev, (Dolgozo) csapatvezeto);
            projektvezetoFoablak.csapatKPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Csapat hozzáadva!", "Info");
        } else {
            projektvezetoFoablak.infoAblak("A név mező nem lehet üres!", "Info");
        }
    }

    public int getKivalasztottMegrendeloIndex(Megrendelo megrendelo) {
        ComboBoxModel<String> megrendeloCBModell = projektvezetoFoablak.getCbProjektekMegrend().getModel();

        int i = 0;
        Object aktMegrendelo = megrendeloCBModell.getElementAt(i);
        while (i < megrendeloCBModell.getSize() && megrendelo != null && ((Megrendelo) aktMegrendelo).getAzon() != megrendelo.getAzon()) {
            i++;
            aktMegrendelo = megrendeloCBModell.getElementAt(i);
        }

        return i;
    }

    public int getKivalasztottDolgozoIndex(Dolgozo felelos, ComboBoxModel modell) {
        int i = 0;
        Object aktFelelos = modell.getElementAt(i);
        while (i < modell.getSize() && ((Dolgozo) aktFelelos).getAzon() != felelos.getAzon()) {
            i++;
            aktFelelos = modell.getElementAt(i);
        }

        return i;
    }

    public int getKivalasztottProjektIndex(Projekt projekt, ComboBoxModel modell) {
        int i = 0;
        Object aktProjekt = modell.getElementAt(i);
        while (i < modell.getSize() && ((Projekt) aktProjekt).getAzon() != projekt.getAzon()) {
            i++;
            aktProjekt = modell.getElementAt(i);
        }

        return i;
    }

    public void projektModositasMentese(Projekt kivalasztottProjekt, String nev, Object megrendelo, int fTerulet, Date megrendDatum, Date hatarido,
            int holTart, int prioritas, int statusz, String leiras) {

        if (nev != null && nev.trim().length() > 0 && megrendDatum != null && hatarido != null) {
            modell.projektModositas(kivalasztottProjekt, nev, megrendelo, fTerulet, megrendDatum, hatarido, holTart, prioritas, statusz, leiras);
            projektvezetoFoablak.projektPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Módosítások elmentve!", "Info");
        } else {
            projektvezetoFoablak.infoAblak("Csak a leírás mező lehet üres!", "Info");
        }
    }

    public void megrendeloModositasMentes(Megrendelo kivalasztottMegrendelo, String nev, String telefonszam, String email, String weboldal,
            String iranyitoszam, String helyseg, String utcaHazszam) {
        if (nev != null && nev.trim().length() > 0 && telefonszam != null && telefonszam.trim().length() > 0
                && email != null && email.trim().length() > 0 && weboldal != null && weboldal.trim().length() > 0
                && iranyitoszam != null && iranyitoszam.trim().length() > 0 && helyseg != null && helyseg.trim().length() > 0
                && utcaHazszam != null && utcaHazszam.trim().length() > 0) {

            modell.megrendeloModosit(kivalasztottMegrendelo, nev, telefonszam, email, weboldal, iranyitoszam, helyseg, utcaHazszam);
            projektvezetoFoablak.megrendPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Módosítások elmentve!", "Info");
        } else {
            projektvezetoFoablak.infoAblak("Csak a weboldal mező lehet üres!", "Info");
        }
    }

    public void feladatModositasMentes(Feladat kivalasztottFeladat, String feladatTargya, Date hataridoDatum, Object felelos,
            Object projekt, int statusz, String leiras) {

        if (feladatTargya != null && feladatTargya.trim().length() > 0 && hataridoDatum != null) {
            modell.feladatModosit(kivalasztottFeladat, feladatTargya, hataridoDatum, felelos, projekt, statusz, leiras);
            projektvezetoFoablak.feladatPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Módosítások elmentve!", "Info");
        } else {
            projektvezetoFoablak.infoAblak("Csak a leírás mező lehet üres!", "Info");
        }
    }

    public void jelentesModositasMentes(Jelentes kivalasztottJelentes, Object projekt, String leiras) {
        if (leiras != null && leiras.trim().length() > 0) {
            modell.jelentesModosit(kivalasztottJelentes, projekt, leiras);
            projektvezetoFoablak.jelentesPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Módosítások elmentve!", "Info");
        } else {
            projektvezetoFoablak.infoAblak("A leírás mező nem lehet üres!", "Info");
        }
    }

    public void dolgozoModositasMentes(Dolgozo kivalasztottDolgozo, String nev, int beosztas, int fTerulet, int skill, Date kezdesDatum, String telSzam) {
        if (nev != null && nev.trim().length() > 0 && kezdesDatum != null && telSzam != null && telSzam.trim().length() > 0) {
            modell.dolgozoModosit(kivalasztottDolgozo, nev, beosztas, fTerulet, skill, kezdesDatum, telSzam);
            projektvezetoFoablak.dolgozoPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Módosítások elmentve!", "Info");
        } else {
            projektvezetoFoablak.infoAblak("Nem lehet üres mező!", "Info");
        }
    }

    public void csapatModositasMentes(Csapat kivalasztottCsapat, String nev, Object csapatvezeto) {
        if (nev != null && nev.trim().length() > 0) {
            modell.csapatModosit(kivalasztottCsapat, nev, csapatvezeto);
            projektvezetoFoablak.csapatKPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Módosítások elmentve!", "Info");
        } else {
            projektvezetoFoablak.infoAblak("A név mező nem lehet üres!", "Info");
        }
    }

    public void projektTorlese(Projekt kivalasztottProjekt) {
        if (projektvezetoFoablak.kerdesAblak("Biztos törlöd a projektet?\n"
                + "Ha igen a projekttel együtt törlödnek a projekthez tartozó feladatok, jelentések.", "Törlés") == JOptionPane.YES_OPTION) {
            modell.projektTorlese(kivalasztottProjekt);
            projektvezetoFoablak.projektPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Projekt törölve!", "Törlés");
        }
    }

    public void megrendeloTorlese(Megrendelo kivalasztottMegrendelo) {
        if (projektvezetoFoablak.kerdesAblak("Biztos törlöd a megrendelőt?", "Törlés") == JOptionPane.YES_OPTION) {
            modell.megrendeloTorlese(kivalasztottMegrendelo);
            projektvezetoFoablak.megrendPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Megrendelő törölve!", "Törlés");
        }
    }

    public void feladatTorlese(Feladat kivalasztottFeladat) {
        if (projektvezetoFoablak.kerdesAblak("Biztos törlöd a feladatot?", "Törlés") == JOptionPane.YES_OPTION) {
            modell.feladatTorlese(kivalasztottFeladat);
            projektvezetoFoablak.feladatPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Feladat törölve!", "Törlés");
        }
    }

    public void jelentesTorlese(Jelentes kivalasztottJelentes) {
        if (projektvezetoFoablak.kerdesAblak("Biztos törlöd a jelentést?", "Törlés") == JOptionPane.YES_OPTION) {
            modell.jelentesTorlese(kivalasztottJelentes);
            projektvezetoFoablak.jelentesPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Jelentés törölve!", "Törlés");
        }
    }

    public void dolgozoTorlese(Dolgozo kivalasztottDolgozo) {
        if (projektvezetoFoablak.kerdesAblak("Biztos törlöd a dolgozót?", "Törlés") == JOptionPane.YES_OPTION) {
            modell.dolgozoTorlese(kivalasztottDolgozo);
            projektvezetoFoablak.dolgozoPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Dolgozó törölve!", "Törlés");
        }
    }

    public void csapatTorlese(Csapat kivalasztottCsapat) {
        if (projektvezetoFoablak.kerdesAblak("Biztos törlöd a csapatot?", "Törlés") == JOptionPane.YES_OPTION) {
            modell.csapatTorlese(kivalasztottCsapat);
            projektvezetoFoablak.csapatKPanelAlaphelyzet();
            projektvezetoFoablak.infoAblak("Csapat törölve!", "Törlés");
        }
    }

    public void jelentesTeljesNezet(Object jelentes) {
        new JelentesTeljesNezetAblak((Jelentes) jelentes);
    }

    public void projektenDolgozoCsapatokMent(Object projekt, ListModel<String> listaModell) {
        modell.projektenDolgozoCsapatokMent(projekt, listaModell);
        projektvezetoFoablak.infoAblak("Sikeres mentés!", "Mentés");
    }

    public void csapattagokMent(Object csapat, ListModel<String> listaModell) {
        modell.csapattagokMent(csapat, listaModell);
        projektvezetoFoablak.infoAblak("Sikeres mentés!", "Mentés");
    }

    public String getBelepettDolgozoNev() {
        return modell.getBelepettDolgozo().getNev();
    }

    public JelentesTablaModell getCsvezJelentesekKTabla() {
        return modell.getCsapatvezetoJelentesekKTablaModell();
    }

    public void csVezetoJelentesHozzaadd(Object projekt, String leiras) {
        if (leiras != null && leiras.trim().length() > 0) {
            modell.jelentesHozzaadd((Projekt) projekt, leiras);
            csapatvezetoFoablak.jelentesPanelAlaphelyzet();
            csapatvezetoFoablak.infoAblak("Jelentés hozzáadva!", "Info");
        } else {
            csapatvezetoFoablak.infoAblak("A leírás mező nem lehet üres!", "Info");
        }
    }

    public void csVezetoJelentesModositasMentes(Jelentes kivalasztottJelentes, Object projekt, String leiras) {
        if (leiras != null && leiras.trim().length() > 0) {
            modell.jelentesModosit(kivalasztottJelentes, projekt, leiras);
            csapatvezetoFoablak.jelentesPanelAlaphelyzet();
            csapatvezetoFoablak.infoAblak("Módosítások elmentve!", "Info");
        } else {
            csapatvezetoFoablak.infoAblak("A leírás mező nem lehet üres!", "Info");
        }
    }

    public void csVezetoJelentesTorlese(Jelentes kivalasztottJelentes) {
        if (csapatvezetoFoablak.kerdesAblak("Biztos törlöd a jelentést?", "Törlés") == JOptionPane.YES_OPTION) {
            modell.jelentesTorlese(kivalasztottJelentes);
            csapatvezetoFoablak.jelentesPanelAlaphelyzet();
            csapatvezetoFoablak.infoAblak("Jelentés törölve!", "Törlés");
        }
    }

    private DefaultComboBoxModel getFejlesztoProjektCBModell() {
        return modell.getFejlesztoProjektCBModell();
    }

    public void mentesPDF(TableModel tablaModell) {
        if (tablaModell instanceof ProjektTablaModell) {
            ProjektTablaModell ptm = (ProjektTablaModell) tablaModell;
            modell.pdfGeneral("projektek", "Projektek", ptm.getOszlopNevek(), ptm.getProjektLista());
        } else if (tablaModell instanceof MegrendeloTablaModell) {
            MegrendeloTablaModell mtm = (MegrendeloTablaModell) tablaModell;
            modell.pdfGeneral("megrendelok", "Megrendelők", mtm.getOszlopNevek(), mtm.getMegrendeloLista());
        } else if (tablaModell instanceof FeladatTablaModell) {
            FeladatTablaModell ftm = (FeladatTablaModell) tablaModell;
            modell.pdfGeneral("feladatok", "Feladatok", ftm.getOszlopNevek(), ftm.getFeladatLista());
        }
    }

    public void jelentesMentesPDF(Object jelentes) {
        Jelentes kivalasztottJelentes = (Jelentes) jelentes;
        modell.jelentesPDFGeneral(kivalasztottJelentes);
    }
}