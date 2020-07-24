package projektmenedzsmentrendszer.nezet;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.sql.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.TableModel;
import projektmenedzsmentrendszer.modell.pojoosztalyok.*;
import projektmenedzsmentrendszer.modell.tablamodellek.*;
import projektmenedzsmentrendszer.vezerlo.*;

public class ProjektvezetoFoablak extends javax.swing.JFrame implements FoAblak {
    private final Vezerlo vezerlo;
    private JPanel elozoOldal;
    private JPanel jelenlegiOldal;
    private JPanel elozoAlmenu;
    private JPanel jelenlegiAlmenu;
    private JToggleButton kivalasztottMenuGomb;
    private JButton kivalasztottGomb;
    private Projekt kivalasztottProjekt;
    private Megrendelo kivalasztottMegrendelo;
    private Feladat kivalasztottFeladat;
    private Jelentes kivalasztottJelentes;
    private Dolgozo kivalasztottDolgozo;
    private Csapat kivalasztottCsapat;

    public ProjektvezetoFoablak(Vezerlo vezerlo) {
        this.vezerlo = vezerlo;
        initComponents();
        jelenlegiOldal = pnFooldal;
        jelenlegiAlmenu = pnFooldalAlmenu;
        tablaFrissit(tblFooldalProjektek, vezerlo.getFooldalAttekintoTablaAktivP());
        setVisible(true);
        datumvalasztokBeallit();
        lbBelepveNev.setText(vezerlo.getBelepettDolgozoNev());
    }

    private void tablaFrissit(JTable table, TableModel modell) {
        table.setModel(modell);
        if (modell.getRowCount() <= 0) {
            infoAblak("Nincs ilyen adat!", "Nincs adat");
            tfFooldalPNev.setText(null);
        }
    }

    private void comboBoxFrissit(JComboBox cb, DefaultComboBoxModel modell) {
//        if (modell.getSize() <= 0) {
//            modell.addElement("Nincs adat");
//        }
        cb.setModel(modell);
    }

    private void listaFrissit(JList lista, DefaultListModel modell) {
//        if (modell.getSize() <= 0) {
//            modell.addElement("Nincs adat");
//        }
        lista.setModel(modell);
    }

    @Override
    public void infoAblak(String uzenet, String fejlec) {
        JOptionPane.showMessageDialog(this, uzenet, fejlec, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public int kerdesAblak(String uzenet, String fejlec) {
        return JOptionPane.showConfirmDialog(this, uzenet, fejlec, JOptionPane.YES_NO_OPTION);
    }

    @Override
    public void hibaAblak(String uzenet, String fejlec) {
        JOptionPane.showMessageDialog(this, uzenet, fejlec, JOptionPane.ERROR_MESSAGE);
    }

    private void datumvalasztokBeallit() {
        datumvalasztoBeallit(dcKeresesDatumtol);
        datumvalasztoBeallit(dcKeresesDatumig);
        datumvalasztoBeallit(dcProjektekMegrendDatum);
        datumvalasztoBeallit(dcProjektekHataridoDatum);
        datumvalasztoBeallit(dcFeladatokHataridoDatum);
        datumvalasztoBeallit(dcDolgozoKezdesDatum);
    }

    private void datumvalasztoBeallit(JDateChooser datumvalaszto) {
        JTextFieldDateEditor tfde = (JTextFieldDateEditor) datumvalaszto.getDateEditor();
        tfde.setEditable(false);
        tfde.setBackground(Color.white);
    }

    private void panelValt(JPanel panel, JPanel alMenuPanel) {
        jelenlegiOldal.setVisible(false);
        elozoOldal = jelenlegiOldal;
        jelenlegiOldal = panel;
        jelenlegiOldal.setVisible(true);

        jelenlegiAlmenu.setVisible(false);
        elozoAlmenu = jelenlegiAlmenu;
        jelenlegiAlmenu = alMenuPanel;
        jelenlegiAlmenu.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgFomenu = new javax.swing.ButtonGroup();
        bgFomenuAlmenu = new javax.swing.ButtonGroup();
        bgProjektek = new javax.swing.ButtonGroup();
        bgFeladatok = new javax.swing.ButtonGroup();
        bgJelentesek = new javax.swing.ButtonGroup();
        bgDolgozok = new javax.swing.ButtonGroup();
        pnFomenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbBelepveNev = new javax.swing.JLabel();
        tbtFooldal = new javax.swing.JToggleButton();
        tbtProjektek = new javax.swing.JToggleButton();
        tbtFeladatok = new javax.swing.JToggleButton();
        tbtJelentesek = new javax.swing.JToggleButton();
        tbtDolgozok = new javax.swing.JToggleButton();
        btJelszovalt = new javax.swing.JButton();
        btKijelentkezes = new javax.swing.JButton();
        lpTartalom = new javax.swing.JLayeredPane();
        pnFooldal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFooldalProjektek = new javax.swing.JTable();
        btFooldalKeres = new javax.swing.JButton();
        tfFooldalPNev = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbFooldalPNev = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taFooldalPLeiras = new javax.swing.JTextArea();
        btFooldalFrissit = new javax.swing.JButton();
        btFooldalInfo = new javax.swing.JButton();
        tbFooldalAktivP = new javax.swing.JToggleButton();
        btFooldalMentPDF = new javax.swing.JButton();
        pnFooldalKereses = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblFooldalKereses = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbKeresesFTerulet = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbKeresesMegrend = new javax.swing.JComboBox<>();
        cbKeresesHolTart = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbKeresesPrioritas = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbKeresesPVezeto = new javax.swing.JComboBox<>();
        cbKeresesStatusz = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        btKeresesKeres = new javax.swing.JButton();
        btKeresesMentPDF = new javax.swing.JButton();
        dcKeresesDatumtol = new com.toedter.calendar.JDateChooser();
        dcKeresesDatumig = new com.toedter.calendar.JDateChooser();
        btKeresesDatumtolTorol = new javax.swing.JButton();
        btKeresesDatumigTorol = new javax.swing.JButton();
        pnProjektekKezel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblProjektek = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taProjektekLeiras = new javax.swing.JTextArea();
        btProjektekHozzaad = new javax.swing.JButton();
        cbProjektekStatusz = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        btProjektekModosit = new javax.swing.JButton();
        btProjektekTorol = new javax.swing.JButton();
        btProjektekAlap = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cbProjektekPrioritas = new javax.swing.JComboBox<>();
        cbProjektekHolTart = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cbProjektekFTerulet = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        cbProjektekMegrend = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        tfProjektekNev = new javax.swing.JTextField();
        dcProjektekMegrendDatum = new com.toedter.calendar.JDateChooser();
        dcProjektekHataridoDatum = new com.toedter.calendar.JDateChooser();
        btProjektekHataridoDatumTorol = new javax.swing.JButton();
        btProjektekMegrendDatumTorol = new javax.swing.JButton();
        pnProjektekMegrendelo = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblProjektMegrend = new javax.swing.JTable();
        btMegrendHozzaad = new javax.swing.JButton();
        btMegrendModosit = new javax.swing.JButton();
        btMegrendTorol = new javax.swing.JButton();
        btMegrendAlap = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        tfMegrendNev = new javax.swing.JTextField();
        tfMegrendTelszam = new javax.swing.JTextField();
        tfMegrendEmail = new javax.swing.JTextField();
        tfMegrendWeb = new javax.swing.JTextField();
        tfMegrendIranyitoszam = new javax.swing.JTextField();
        tfMegrendUtcaHazszam = new javax.swing.JTextField();
        tfMegrendHely = new javax.swing.JTextField();
        btMegrendMentPDF = new javax.swing.JButton();
        pnProjektCsapatok = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btProjektCsapatAddCsapat = new javax.swing.JButton();
        btProjektCsapatAddOsszes = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        liProjektenDolgozoCsapatok = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        liProjektCsapatCsapatok = new javax.swing.JList<>();
        cbProjektCsapatokProjektNev = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        btProjektCsapatMent = new javax.swing.JButton();
        btProjektCsapatKiveszOsszes = new javax.swing.JButton();
        btProjektCsapatKiveszCsapat = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        pnFeladatok = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblFeladatok = new javax.swing.JTable();
        btFeladatokKeres = new javax.swing.JButton();
        tfFeladatokNev = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbFeladatokNev = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        taFeladatokLeiras = new javax.swing.JTextArea();
        btFeladatokFrissit = new javax.swing.JButton();
        tbFeladatokAktivP = new javax.swing.JToggleButton();
        btFeladatokMentPDF = new javax.swing.JButton();
        pnFeladatokKezel = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblFeladatokK = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        tfFeladatokKTargy = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        cbFeladatokKStatusz = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        cbFeladatokKFelelos = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        taFeladatokKLeiras = new javax.swing.JTextArea();
        btFeladatokKHozzaad = new javax.swing.JButton();
        btFeladatokKModosit = new javax.swing.JButton();
        btFeladatokKTorol = new javax.swing.JButton();
        btFeladatokKAlap = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        cbFeladatokKPNev = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        btFeladatokHataridoDatumTorol = new javax.swing.JButton();
        dcFeladatokHataridoDatum = new com.toedter.calendar.JDateChooser();
        pnJelentesek = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        btJelentesekTeljesMeret = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        taJelentesekLeiras = new javax.swing.JTextArea();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblJelentesek = new javax.swing.JTable();
        btJelentesekMentPDF = new javax.swing.JButton();
        pnJelentesekKezel = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblJelentesekK = new javax.swing.JTable();
        cbJelentesekKPNev = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        taJelentesekKLeiras = new javax.swing.JTextArea();
        btJelentesekKHozzaad = new javax.swing.JButton();
        btJelentesekKTorol = new javax.swing.JButton();
        btJelentesekKAlap = new javax.swing.JButton();
        jLabel84 = new javax.swing.JLabel();
        btJelentesekKModosit = new javax.swing.JButton();
        pnDolgozokKezel = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tblDolgozok = new javax.swing.JTable();
        jLabel63 = new javax.swing.JLabel();
        tfDolgozokNev = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        btDolgozokHozzaad = new javax.swing.JButton();
        cbDolgozokFTerulet = new javax.swing.JComboBox<>();
        jLabel70 = new javax.swing.JLabel();
        btDolgozokModosit = new javax.swing.JButton();
        btDolgozokTorol = new javax.swing.JButton();
        btDolgozokAlap = new javax.swing.JButton();
        tfDolgozokTelSzam = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        cbDolgozokBeosztas = new javax.swing.JComboBox<>();
        cbDolgozoSkill = new javax.swing.JComboBox<>();
        dcDolgozoKezdesDatum = new com.toedter.calendar.JDateChooser();
        btDolgozoKezdesDatumTorol = new javax.swing.JButton();
        pnDolgozokCsapatok = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        btCsapatOsszeallitAddDolgozo = new javax.swing.JButton();
        btCsapatOsszeallitOsszesAdd = new javax.swing.JButton();
        jScrollPane22 = new javax.swing.JScrollPane();
        liCsapatOsszeallitCstagok = new javax.swing.JList<>();
        jScrollPane23 = new javax.swing.JScrollPane();
        liCsapatOsszeallitDolgozok = new javax.swing.JList<>();
        cbCsapatOsszeallitNev = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        btCsapatOsszeallitMent = new javax.swing.JButton();
        btCsapatOsszeallitOsszesKivesz = new javax.swing.JButton();
        btCsapatOsszeallitKiveszDolgozo = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        pnDolgozokCsapatokKezel = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tblCsapatokK = new javax.swing.JTable();
        tfCsapatokKNev = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        cbCsapatokKCsVez = new javax.swing.JComboBox<>();
        jLabel75 = new javax.swing.JLabel();
        btCsapatokKHozzaad = new javax.swing.JButton();
        btCsapatokKModosit = new javax.swing.JButton();
        btCsapatokKTorol = new javax.swing.JButton();
        btCsapatokKAlap = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        pnJelszovaltoztatas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbJelszoHibaUzenet = new javax.swing.JLabel();
        pfJelszoValtUj = new javax.swing.JPasswordField();
        pfJelszoValtMegerosit = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btJelszoValtMent = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        pfJelszoValtJelenlegi = new javax.swing.JPasswordField();
        lpAlmenu = new javax.swing.JLayeredPane();
        pnFooldalAlmenu = new javax.swing.JPanel();
        tbAttekinto = new javax.swing.JToggleButton();
        tbKereses = new javax.swing.JToggleButton();
        pnProjektekAlmenu = new javax.swing.JPanel();
        tbProjektKezel = new javax.swing.JToggleButton();
        tbProjektCsapatok = new javax.swing.JToggleButton();
        tbProjektMegrendelo = new javax.swing.JToggleButton();
        pnFeladatokAlmenu = new javax.swing.JPanel();
        tbFeladatok = new javax.swing.JToggleButton();
        tbFeladatokKezel = new javax.swing.JToggleButton();
        pnJelentesekAlmenu = new javax.swing.JPanel();
        tbJelentesek = new javax.swing.JToggleButton();
        tbJelentesekKezel = new javax.swing.JToggleButton();
        pnDolgozokAlmenu = new javax.swing.JPanel();
        tbDolgozokKezel = new javax.swing.JToggleButton();
        tbDolgozokCsapatok = new javax.swing.JToggleButton();
        tbDolgozokCsapatokKezell = new javax.swing.JToggleButton();
        pnVisszaAlmenu = new javax.swing.JPanel();
        btVissza = new javax.swing.JButton();

        setTitle("Projektmenedzsment szoftver - Projektvezető");
        setDefaultCloseOperation(3);
        setPreferredSize(new java.awt.Dimension(1200, 720));
        setSize(new java.awt.Dimension(1200, 720));

        pnFomenu.setBackground(new java.awt.Color(204, 204, 204));
        pnFomenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnFomenu.setPreferredSize(new java.awt.Dimension(298, 0));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Belépve:");

        lbBelepveNev.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        bgFomenu.add(tbtFooldal);
        tbtFooldal.setSelected(true);
        tbtFooldal.setBackground(new java.awt.Color(235, 235, 235));
        tbtFooldal.setBorder(null);
        tbtFooldal.setFocusPainted(false);
        tbtFooldal.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbtFooldal.setText("Főoldal");
        tbtFooldal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtFomenuActionPerformed(evt);
            }
        });

        bgFomenu.add(tbtProjektek);
        tbtProjektek.setBackground(new java.awt.Color(235, 235, 235));
        tbtProjektek.setBorder(null);
        tbtProjektek.setFocusPainted(false);
        tbtProjektek.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbtProjektek.setText("Projektek");
        tbtProjektek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtFomenuActionPerformed(evt);
            }
        });

        bgFomenu.add(tbtFeladatok);
        tbtFeladatok.setBackground(new java.awt.Color(235, 235, 235));
        tbtFeladatok.setBorder(null);
        tbtFeladatok.setFocusPainted(false);
        tbtFeladatok.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbtFeladatok.setText("Feladatok");
        tbtFeladatok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtFomenuActionPerformed(evt);
            }
        });

        bgFomenu.add(tbtJelentesek);
        tbtJelentesek.setBackground(new java.awt.Color(235, 235, 235));
        tbtJelentesek.setBorder(null);
        tbtJelentesek.setFocusPainted(false);
        tbtJelentesek.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbtJelentesek.setText("Jelentések");
        tbtJelentesek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtFomenuActionPerformed(evt);
            }
        });

        bgFomenu.add(tbtDolgozok);
        tbtDolgozok.setBackground(new java.awt.Color(235, 235, 235));
        tbtDolgozok.setBorder(null);
        tbtDolgozok.setFocusPainted(false);
        tbtDolgozok.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbtDolgozok.setText("Dolgozók");
        tbtDolgozok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtFomenuActionPerformed(evt);
            }
        });

        btJelszovalt.setBackground(new java.awt.Color(235, 235, 235));
        btJelszovalt.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btJelszovalt.setText("Jelszóváltoztatás");
        btJelszovalt.setFocusPainted(false);
        btJelszovalt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFomenuAlsoGombokActionPerformed(evt);
            }
        });

        btKijelentkezes.setBackground(new java.awt.Color(235, 235, 235));
        btKijelentkezes.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btKijelentkezes.setText("Kijelentkezés");
        btKijelentkezes.setFocusPainted(false);
        btKijelentkezes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFomenuAlsoGombokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFomenuLayout = new javax.swing.GroupLayout(pnFomenu);
        pnFomenu.setLayout(pnFomenuLayout);
        pnFomenuLayout.setHorizontalGroup(
            pnFomenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbtFooldal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tbtProjektek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tbtFeladatok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tbtJelentesek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFomenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFomenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lbBelepveNev, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(btJelszovalt, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
            .addComponent(btKijelentkezes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tbtDolgozok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnFomenuLayout.setVerticalGroup(
            pnFomenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFomenuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbBelepveNev)
                .addGap(82, 82, 82)
                .addComponent(tbtFooldal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tbtProjektek, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tbtFeladatok, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tbtJelentesek, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tbtDolgozok, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btJelszovalt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btKijelentkezes)
                .addContainerGap())
        );

        pnFooldal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnFooldal.setOpaque(false);

        jScrollPane1.setBorder(null);

        tblFooldalProjektek.setAutoCreateRowSorter(true);
        tblFooldalProjektek.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblFooldalProjektek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblFooldalProjektek.setRowHeight(30);
        tblFooldalProjektek.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblFooldalProjektekFocusLost(evt);
            }
        });
        tblFooldalProjektek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFooldalProjektekMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFooldalProjektek);

        btFooldalKeres.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btFooldalKeres.setText("Keresés");
        btFooldalKeres.setFocusPainted(false);
        btFooldalKeres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFooldalGombokActionPerformed(evt);
            }
        });

        tfFooldalPNev.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tfFooldalPNev.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfFooldalPNevFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Projekt neve:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Egyéb információ a projektről", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N

        lbFooldalPNev.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lbFooldalPNev.setHorizontalAlignment(11);

        taFooldalPLeiras.setEditable(false);
        taFooldalPLeiras.setBackground(new java.awt.Color(240, 240, 240));
        taFooldalPLeiras.setColumns(20);
        taFooldalPLeiras.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        taFooldalPLeiras.setLineWrap(true);
        taFooldalPLeiras.setRows(5);
        taFooldalPLeiras.setWrapStyleWord(true);
        taFooldalPLeiras.setBorder(null);
        jScrollPane3.setViewportView(taFooldalPLeiras);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFooldalPNev, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbFooldalPNev, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btFooldalFrissit.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btFooldalFrissit.setText("Frissítés");
        btFooldalFrissit.setFocusPainted(false);
        btFooldalFrissit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFooldalGombokActionPerformed(evt);
            }
        });

        btFooldalInfo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btFooldalInfo.setText("Több információ");
        btFooldalInfo.setFocusPainted(false);
        btFooldalInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFooldalGombokActionPerformed(evt);
            }
        });

        tbFooldalAktivP.setBackground(new java.awt.Color(235, 235, 235));
        tbFooldalAktivP.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tbFooldalAktivP.setSelected(true);
        tbFooldalAktivP.setText("Aktív / Összes projekt");
        tbFooldalAktivP.setFocusPainted(false);

        btFooldalMentPDF.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btFooldalMentPDF.setText("Mentés PDF-be");
        btFooldalMentPDF.setFocusPainted(false);
        btFooldalMentPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFooldalGombokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFooldalLayout = new javax.swing.GroupLayout(pnFooldal);
        pnFooldal.setLayout(pnFooldalLayout);
        pnFooldalLayout.setHorizontalGroup(
            pnFooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFooldalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
                    .addGroup(pnFooldalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFooldalPNev, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btFooldalKeres))
                    .addGroup(pnFooldalLayout.createSequentialGroup()
                        .addComponent(btFooldalInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 528, Short.MAX_VALUE)
                        .addComponent(btFooldalMentPDF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbFooldalAktivP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btFooldalFrissit)))
                .addContainerGap())
        );
        pnFooldalLayout.setVerticalGroup(
            pnFooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFooldalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfFooldalPNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFooldalKeres)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnFooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnFooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btFooldalFrissit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btFooldalInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btFooldalMentPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbFooldalAktivP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnFooldalLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btFooldalKeres, tfFooldalPNev});

        pnFooldalKereses.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnFooldalKereses.setOpaque(false);

        jScrollPane8.setBorder(null);

        tblFooldalKereses.setAutoCreateRowSorter(true);
        tblFooldalKereses.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblFooldalKereses.setFocusable(false);
        tblFooldalKereses.setRowHeight(25);
        tblFooldalKereses.setRowSelectionAllowed(false);
        jScrollPane8.setViewportView(tblFooldalKereses);

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel8.setText("Részletes keresés");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setText("Megrendelés intervallum:");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setText("Fejlesztési terület:");

        cbKeresesFTerulet.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel11.setText("Megrendelő:");

        cbKeresesMegrend.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        cbKeresesHolTart.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel12.setText("Hol tart a projekt:");

        cbKeresesPrioritas.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel13.setText("Prioritás:");

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel14.setText("Projektvezető:");

        cbKeresesPVezeto.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        cbKeresesStatusz.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel15.setText("Státusz:");

        btKeresesKeres.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btKeresesKeres.setText("Keresés");
        btKeresesKeres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKeresesGombokActionPerformed(evt);
            }
        });

        btKeresesMentPDF.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btKeresesMentPDF.setText("Mentés PDF-be");
        btKeresesMentPDF.setFocusPainted(false);
        btKeresesMentPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKeresesGombokActionPerformed(evt);
            }
        });

        dcKeresesDatumtol.setFocusable(false);

        dcKeresesDatumig.setFocusable(false);

        btKeresesDatumtolTorol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projektmenedzsmentrendszer/images/torolIkon.png"))); // NOI18N
        btKeresesDatumtolTorol.setPreferredSize(new java.awt.Dimension(53, 23));
        btKeresesDatumtolTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKeresesDatumTorolGombokActionPerformed(evt);
            }
        });

        btKeresesDatumigTorol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projektmenedzsmentrendszer/images/torolIkon.png"))); // NOI18N
        btKeresesDatumigTorol.setPreferredSize(new java.awt.Dimension(53, 23));
        btKeresesDatumigTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKeresesDatumTorolGombokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFooldalKeresesLayout = new javax.swing.GroupLayout(pnFooldalKereses);
        pnFooldalKereses.setLayout(pnFooldalKeresesLayout);
        pnFooldalKeresesLayout.setHorizontalGroup(
            pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFooldalKeresesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
            .addGroup(pnFooldalKeresesLayout.createSequentialGroup()
                .addGroup(pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFooldalKeresesLayout.createSequentialGroup()
                        .addGap(0, 349, Short.MAX_VALUE)
                        .addGroup(pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pnFooldalKeresesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btKeresesMentPDF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(cbKeresesStatusz, 0, 272, Short.MAX_VALUE)
                    .addComponent(cbKeresesPVezeto, 0, 272, Short.MAX_VALUE)
                    .addComponent(cbKeresesPrioritas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbKeresesHolTart, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbKeresesFTerulet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbKeresesMegrend, 0, 270, Short.MAX_VALUE)
                    .addComponent(btKeresesKeres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcKeresesDatumtol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcKeresesDatumig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btKeresesDatumtolTorol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btKeresesDatumigTorol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 311, Short.MAX_VALUE))
        );

        pnFooldalKeresesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbKeresesFTerulet, cbKeresesHolTart, cbKeresesMegrend, cbKeresesPVezeto, cbKeresesPrioritas, cbKeresesStatusz});

        pnFooldalKeresesLayout.setVerticalGroup(
            pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFooldalKeresesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbKeresesMegrend, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbKeresesFTerulet, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btKeresesDatumtolTorol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dcKeresesDatumtol, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcKeresesDatumig, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btKeresesDatumigTorol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbKeresesHolTart, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbKeresesPrioritas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbKeresesPVezeto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbKeresesStatusz, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btKeresesMentPDF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btKeresesKeres, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnFooldalKeresesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btKeresesDatumigTorol, btKeresesDatumtolTorol, cbKeresesFTerulet, cbKeresesHolTart, cbKeresesMegrend, cbKeresesPVezeto, cbKeresesPrioritas, cbKeresesStatusz, dcKeresesDatumig, dcKeresesDatumtol});

        pnProjektekKezel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnProjektekKezel.setOpaque(false);

        jScrollPane9.setBorder(null);

        tblProjektek.setAutoCreateRowSorter(true);
        tblProjektek.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblProjektek.setFocusable(false);
        tblProjektek.setRowHeight(25);
        tblProjektek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProjektekMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblProjektek);

        jLabel40.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel40.setText("Rövid leírás:");

        taProjektekLeiras.setColumns(20);
        taProjektekLeiras.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        taProjektekLeiras.setLineWrap(true);
        taProjektekLeiras.setRows(5);
        taProjektekLeiras.setWrapStyleWord(true);
        jScrollPane4.setViewportView(taProjektekLeiras);

        btProjektekHozzaad.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btProjektekHozzaad.setText("Hozzáad");
        btProjektekHozzaad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProjektekKezelGombokActionPerformed(evt);
            }
        });

        cbProjektekStatusz.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel41.setText("Státusz:");

        btProjektekModosit.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btProjektekModosit.setText("Módosít");
        btProjektekModosit.setEnabled(false);
        btProjektekModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProjektekKezelGombokActionPerformed(evt);
            }
        });

        btProjektekTorol.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btProjektekTorol.setText("Töröl");
        btProjektekTorol.setEnabled(false);
        btProjektekTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProjektekKezelGombokActionPerformed(evt);
            }
        });

        btProjektekAlap.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btProjektekAlap.setText("Alaphelyzet");
        btProjektekAlap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProjektekKezelGombokActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel17.setText("Prioritás:");

        cbProjektekPrioritas.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        cbProjektekHolTart.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel18.setText("Hol tart a projekt:");

        jLabel25.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel25.setText("Megrendelés dátuma:");

        cbProjektekFTerulet.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel31.setText("Megrendelő:");

        cbProjektekMegrend.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel33.setText("Fejlesztési terület:");

        jLabel34.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel34.setText("Projektek kezelése");

        jLabel35.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel35.setText("Határidő dátuma:");

        jLabel36.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel36.setText("Projekt neve:");

        tfProjektekNev.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        dcProjektekMegrendDatum.setFocusable(false);

        dcProjektekHataridoDatum.setFocusable(false);

        btProjektekHataridoDatumTorol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projektmenedzsmentrendszer/images/torolIkon.png"))); // NOI18N
        btProjektekHataridoDatumTorol.setPreferredSize(new java.awt.Dimension(53, 23));
        btProjektekHataridoDatumTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProjektekMegrendDatumTorolGombokActionPerformed(evt);
            }
        });

        btProjektekMegrendDatumTorol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projektmenedzsmentrendszer/images/torolIkon.png"))); // NOI18N
        btProjektekMegrendDatumTorol.setPreferredSize(new java.awt.Dimension(53, 23));
        btProjektekMegrendDatumTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProjektekMegrendDatumTorolGombokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnProjektekKezelLayout = new javax.swing.GroupLayout(pnProjektekKezel);
        pnProjektekKezel.setLayout(pnProjektekKezelLayout);
        pnProjektekKezelLayout.setHorizontalGroup(
            pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProjektekKezelLayout.createSequentialGroup()
                .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnProjektekKezelLayout.createSequentialGroup()
                        .addContainerGap(143, Short.MAX_VALUE)
                        .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addGroup(pnProjektekKezelLayout.createSequentialGroup()
                                .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnProjektekKezelLayout.createSequentialGroup()
                                        .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cbProjektekMegrend, 0, 275, Short.MAX_VALUE)
                                            .addComponent(cbProjektekFTerulet, 0, 275, Short.MAX_VALUE)
                                            .addComponent(cbProjektekHolTart, 0, 275, Short.MAX_VALUE)
                                            .addComponent(cbProjektekPrioritas, 0, 275, Short.MAX_VALUE)
                                            .addComponent(cbProjektekStatusz, 0, 268, Short.MAX_VALUE)
                                            .addComponent(tfProjektekNev, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(57, 57, 57)
                                        .addComponent(jLabel40))
                                    .addGroup(pnProjektekKezelLayout.createSequentialGroup()
                                        .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dcProjektekHataridoDatum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dcProjektekMegrendDatum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btProjektekMegrendDatumTorol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btProjektekHataridoDatumTorol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))))
                    .addGroup(pnProjektekKezelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btProjektekHozzaad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btProjektekModosit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btProjektekTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btProjektekAlap, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(136, Short.MAX_VALUE))
            .addGroup(pnProjektekKezelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9)
                .addContainerGap())
        );

        pnProjektekKezelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btProjektekHozzaad, btProjektekModosit, btProjektekTorol});

        pnProjektekKezelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbProjektekFTerulet, cbProjektekHolTart, cbProjektekMegrend, cbProjektekPrioritas, cbProjektekStatusz, dcProjektekHataridoDatum, dcProjektekMegrendDatum});

        pnProjektekKezelLayout.setVerticalGroup(
            pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProjektekKezelLayout.createSequentialGroup()
                .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnProjektekKezelLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(btProjektekMegrendDatumTorol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btProjektekHataridoDatumTorol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnProjektekKezelLayout.createSequentialGroup()
                        .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnProjektekKezelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnProjektekKezelLayout.createSequentialGroup()
                                        .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel36)
                                            .addComponent(tfProjektekNev, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel31)
                                            .addComponent(cbProjektekMegrend, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel33)
                                            .addComponent(cbProjektekFTerulet, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(pnProjektekKezelLayout.createSequentialGroup()
                                        .addComponent(jLabel40)
                                        .addGap(93, 93, 93)))
                                .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(dcProjektekMegrendDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(dcProjektekHataridoDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(cbProjektekHolTart, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(cbProjektekPrioritas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbProjektekStatusz, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel41)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnProjektekKezelLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnProjektekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btProjektekHozzaad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btProjektekModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btProjektekTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btProjektekAlap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnProjektekKezelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btProjektekHataridoDatumTorol, btProjektekMegrendDatumTorol, cbProjektekFTerulet, dcProjektekHataridoDatum, dcProjektekMegrendDatum});

        pnProjektekMegrendelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnProjektekMegrendelo.setOpaque(false);

        jScrollPane16.setBorder(null);

        tblProjektMegrend.setAutoCreateRowSorter(true);
        tblProjektMegrend.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblProjektMegrend.setFocusable(false);
        tblProjektMegrend.setRowHeight(25);
        tblProjektMegrend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProjektMegrendMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(tblProjektMegrend);

        btMegrendHozzaad.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btMegrendHozzaad.setText("Hozzáad");
        btMegrendHozzaad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMegrendGombokActionPerformed(evt);
            }
        });

        btMegrendModosit.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btMegrendModosit.setText("Módosít");
        btMegrendModosit.setEnabled(false);
        btMegrendModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMegrendGombokActionPerformed(evt);
            }
        });

        btMegrendTorol.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btMegrendTorol.setText("Töröl");
        btMegrendTorol.setEnabled(false);
        btMegrendTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMegrendGombokActionPerformed(evt);
            }
        });

        btMegrendAlap.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btMegrendAlap.setText("Alaphelyzet");
        btMegrendAlap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMegrendGombokActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel29.setText("Utca, házszám:");

        jLabel30.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel30.setText("Helység:");

        jLabel37.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel37.setText("Weboldal:");

        jLabel38.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel38.setText("Telefonszám:");

        jLabel39.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel39.setText("Email:");

        jLabel62.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel62.setText("Megrendelők kezelése");

        jLabel81.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel81.setText("Irányítószám:");

        jLabel82.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel82.setText("Megrendelő neve:");

        tfMegrendNev.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        tfMegrendTelszam.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        tfMegrendEmail.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        tfMegrendWeb.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        tfMegrendIranyitoszam.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        tfMegrendUtcaHazszam.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        tfMegrendHely.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        btMegrendMentPDF.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btMegrendMentPDF.setText("Mentés PDF-be");
        btMegrendMentPDF.setFocusPainted(false);
        btMegrendMentPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMegrendGombokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnProjektekMegrendeloLayout = new javax.swing.GroupLayout(pnProjektekMegrendelo);
        pnProjektekMegrendelo.setLayout(pnProjektekMegrendeloLayout);
        pnProjektekMegrendeloLayout.setHorizontalGroup(
            pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProjektekMegrendeloLayout.createSequentialGroup()
                .addGroup(pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnProjektekMegrendeloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 1332, Short.MAX_VALUE))
                    .addGroup(pnProjektekMegrendeloLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnProjektekMegrendeloLayout.createSequentialGroup()
                                .addGroup(pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel62)
                                    .addComponent(tfMegrendNev, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfMegrendTelszam, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfMegrendEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnProjektekMegrendeloLayout.createSequentialGroup()
                                .addGroup(pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfMegrendWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfMegrendIranyitoszam, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfMegrendHely, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfMegrendUtcaHazszam, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnProjektekMegrendeloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btMegrendHozzaad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMegrendModosit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMegrendTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMegrendAlap, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMegrendMentPDF)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnProjektekMegrendeloLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btMegrendAlap, btMegrendHozzaad, btMegrendModosit, btMegrendTorol});

        pnProjektekMegrendeloLayout.setVerticalGroup(
            pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProjektekMegrendeloLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel62)
                .addGap(18, 18, 18)
                .addGroup(pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfMegrendNev, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82))
                .addGap(18, 18, 18)
                .addGroup(pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfMegrendTelszam, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(18, 18, 18)
                .addGroup(pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfMegrendEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addGap(18, 18, 18)
                .addGroup(pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfMegrendWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addGroup(pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfMegrendIranyitoszam, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81))
                .addGap(20, 20, 20)
                .addGroup(pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfMegrendHely, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfMegrendUtcaHazszam, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btMegrendMentPDF, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnProjektekMegrendeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btMegrendHozzaad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btMegrendModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btMegrendTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btMegrendAlap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnProjektekMegrendeloLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btMegrendAlap, btMegrendMentPDF});

        pnProjektCsapatok.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnProjektCsapatok.setOpaque(false);

        jLabel27.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel27.setText("Projekt neve:");

        btProjektCsapatAddCsapat.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btProjektCsapatAddCsapat.setText("<");
        btProjektCsapatAddCsapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProjektCsapatGombokActionPerformed(evt);
            }
        });

        btProjektCsapatAddOsszes.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btProjektCsapatAddOsszes.setText("<<");
        btProjektCsapatAddOsszes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProjektCsapatGombokActionPerformed(evt);
            }
        });

        liProjektenDolgozoCsapatok.setBackground(new java.awt.Color(240, 240, 240));
        liProjektenDolgozoCsapatok.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        liProjektenDolgozoCsapatok.setSelectionMode(0);
        jScrollPane6.setViewportView(liProjektenDolgozoCsapatok);

        liProjektCsapatCsapatok.setBackground(new java.awt.Color(240, 240, 240));
        liProjektCsapatCsapatok.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        liProjektCsapatCsapatok.setSelectionMode(0);
        jScrollPane7.setViewportView(liProjektCsapatCsapatok);

        cbProjektCsapatokProjektNev.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbProjektCsapatokProjektNev.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Projekt 1", "Projekt 2", "Projekt 3", "Projekt 4", "Projekt 5" }));
        cbProjektCsapatokProjektNev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProjektCsapatokProjektNevActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel28.setText("Projekten dolgozó csapatok:");

        jLabel49.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel49.setText("Csapatok:");

        btProjektCsapatMent.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btProjektCsapatMent.setText("Mentés");
        btProjektCsapatMent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProjektCsapatMentActionPerformed(evt);
            }
        });

        btProjektCsapatKiveszOsszes.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btProjektCsapatKiveszOsszes.setText(">>");
        btProjektCsapatKiveszOsszes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProjektCsapatGombokActionPerformed(evt);
            }
        });

        btProjektCsapatKiveszCsapat.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btProjektCsapatKiveszCsapat.setText(">");
        btProjektCsapatKiveszCsapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProjektCsapatGombokActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel61.setHorizontalAlignment(0);
        jLabel61.setText("Projekten dolgozó csapatok összeállítása");

        javax.swing.GroupLayout pnProjektCsapatokLayout = new javax.swing.GroupLayout(pnProjektCsapatok);
        pnProjektCsapatok.setLayout(pnProjektCsapatokLayout);
        pnProjektCsapatokLayout.setHorizontalGroup(
            pnProjektCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProjektCsapatokLayout.createSequentialGroup()
                .addGroup(pnProjektCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnProjektCsapatokLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnProjektCsapatokLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnProjektCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btProjektCsapatMent, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnProjektCsapatokLayout.createSequentialGroup()
                        .addGroup(pnProjektCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbProjektCsapatokProjektNev, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnProjektCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnProjektCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnProjektCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btProjektCsapatAddCsapat)
                                    .addComponent(btProjektCsapatAddOsszes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btProjektCsapatKiveszOsszes, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btProjektCsapatKiveszCsapat, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnProjektCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                            .addComponent(jLabel49))))
                .addGap(81, 81, 81))
        );

        pnProjektCsapatokLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btProjektCsapatAddCsapat, btProjektCsapatAddOsszes});

        pnProjektCsapatokLayout.setVerticalGroup(
            pnProjektCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProjektCsapatokLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel61)
                .addGroup(pnProjektCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnProjektCsapatokLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel49))
                    .addGroup(pnProjektCsapatokLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27))
                    .addGroup(pnProjektCsapatokLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(cbProjektCsapatokProjektNev, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnProjektCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnProjektCsapatokLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnProjektCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addGroup(pnProjektCsapatokLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnProjektCsapatokLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                        .addComponent(btProjektCsapatAddCsapat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btProjektCsapatKiveszCsapat, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btProjektCsapatAddOsszes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btProjektCsapatKiveszOsszes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(btProjektCsapatMent, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pnProjektCsapatokLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btProjektCsapatAddCsapat, btProjektCsapatAddOsszes});

        pnFeladatok.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnFeladatok.setOpaque(false);

        jScrollPane11.setBorder(null);

        tblFeladatok.setAutoCreateRowSorter(true);
        tblFeladatok.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblFeladatok.setRowHeight(30);
        tblFeladatok.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblFeladatokFocusLost(evt);
            }
        });
        tblFeladatok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFeladatokMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblFeladatok);

        btFeladatokKeres.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btFeladatokKeres.setText("Keresés");
        btFeladatokKeres.setFocusPainted(false);
        btFeladatokKeres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFeladatokGombokActionPerformed(evt);
            }
        });

        tfFeladatokNev.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Feladat tárgya:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Egyéb információ a feladatról", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N

        lbFeladatokNev.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lbFeladatokNev.setHorizontalAlignment(11);
        lbFeladatokNev.setToolTipText("");

        taFeladatokLeiras.setEditable(false);
        taFeladatokLeiras.setBackground(new java.awt.Color(240, 240, 240));
        taFeladatokLeiras.setColumns(20);
        taFeladatokLeiras.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        taFeladatokLeiras.setLineWrap(true);
        taFeladatokLeiras.setRows(5);
        taFeladatokLeiras.setWrapStyleWord(true);
        taFeladatokLeiras.setBorder(null);
        jScrollPane12.setViewportView(taFeladatokLeiras);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFeladatokNev, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(lbFeladatokNev, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btFeladatokFrissit.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btFeladatokFrissit.setText("Frissítés");
        btFeladatokFrissit.setFocusPainted(false);
        btFeladatokFrissit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFeladatokGombokActionPerformed(evt);
            }
        });

        tbFeladatokAktivP.setBackground(new java.awt.Color(235, 235, 235));
        tbFeladatokAktivP.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tbFeladatokAktivP.setSelected(true);
        tbFeladatokAktivP.setText("Aktív / Összes feladat");
        tbFeladatokAktivP.setFocusPainted(false);

        btFeladatokMentPDF.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btFeladatokMentPDF.setText("Mentés PDF-be");
        btFeladatokMentPDF.setFocusPainted(false);
        btFeladatokMentPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFeladatokGombokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFeladatokLayout = new javax.swing.GroupLayout(pnFeladatok);
        pnFeladatok.setLayout(pnFeladatokLayout);
        pnFeladatokLayout.setHorizontalGroup(
            pnFeladatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFeladatokLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFeladatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1332, Short.MAX_VALUE)
                    .addGroup(pnFeladatokLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnFeladatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnFeladatokLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfFeladatokNev, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btFeladatokKeres))
                            .addGroup(pnFeladatokLayout.createSequentialGroup()
                                .addComponent(btFeladatokMentPDF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tbFeladatokAktivP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btFeladatokFrissit)))))
                .addContainerGap())
        );
        pnFeladatokLayout.setVerticalGroup(
            pnFeladatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFeladatokLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFeladatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfFeladatokNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFeladatokKeres)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnFeladatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFeladatokFrissit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbFeladatokAktivP)
                    .addComponent(btFeladatokMentPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnFeladatokLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btFeladatokFrissit, tbFeladatokAktivP});

        pnFeladatokKezel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnFeladatokKezel.setOpaque(false);

        jScrollPane10.setBorder(null);

        tblFeladatokK.setAutoCreateRowSorter(true);
        tblFeladatokK.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblFeladatokK.setFocusable(false);
        tblFeladatokK.setRowHeight(25);
        tblFeladatokK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFeladatokKMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblFeladatokK);

        jLabel32.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel32.setText("Feladat tárgya:");

        tfFeladatokKTargy.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel42.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel42.setText("Határidő dátuma:");

        cbFeladatokKStatusz.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel45.setText("Státusz:");

        cbFeladatokKFelelos.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel46.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel46.setText("Felelős neve:");

        jLabel47.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel47.setText("Rövid leírás:");

        taFeladatokKLeiras.setColumns(20);
        taFeladatokKLeiras.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        taFeladatokKLeiras.setLineWrap(true);
        taFeladatokKLeiras.setRows(5);
        taFeladatokKLeiras.setWrapStyleWord(true);
        jScrollPane5.setViewportView(taFeladatokKLeiras);

        btFeladatokKHozzaad.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btFeladatokKHozzaad.setText("Hozzáad");
        btFeladatokKHozzaad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFeladatokKGombokActionPerformed(evt);
            }
        });

        btFeladatokKModosit.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btFeladatokKModosit.setText("Módosít");
        btFeladatokKModosit.setEnabled(false);
        btFeladatokKModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFeladatokKGombokActionPerformed(evt);
            }
        });

        btFeladatokKTorol.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btFeladatokKTorol.setText("Töröl");
        btFeladatokKTorol.setEnabled(false);
        btFeladatokKTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFeladatokKGombokActionPerformed(evt);
            }
        });

        btFeladatokKAlap.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btFeladatokKAlap.setText("Alaphelyzet");
        btFeladatokKAlap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFeladatokKGombokActionPerformed(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel79.setHorizontalAlignment(0);
        jLabel79.setText("Feladatok kezelése");

        cbFeladatokKPNev.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel56.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel56.setText("Projekt neve:");

        btFeladatokHataridoDatumTorol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projektmenedzsmentrendszer/images/torolIkon.png"))); // NOI18N
        btFeladatokHataridoDatumTorol.setPreferredSize(new java.awt.Dimension(53, 23));
        btFeladatokHataridoDatumTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFeladatokHataridoDatumTorolActionPerformed(evt);
            }
        });

        dcFeladatokHataridoDatum.setFocusable(false);
        dcFeladatokHataridoDatum.setPreferredSize(new java.awt.Dimension(91, 23));

        javax.swing.GroupLayout pnFeladatokKezelLayout = new javax.swing.GroupLayout(pnFeladatokKezel);
        pnFeladatokKezel.setLayout(pnFeladatokKezelLayout);
        pnFeladatokKezelLayout.setHorizontalGroup(
            pnFeladatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFeladatokKezelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btFeladatokKHozzaad, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btFeladatokKModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btFeladatokKTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btFeladatokKAlap, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 864, Short.MAX_VALUE))
            .addGroup(pnFeladatokKezelLayout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addGroup(pnFeladatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(4, 4, 4)
                .addGroup(pnFeladatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbFeladatokKPNev, 0, 321, Short.MAX_VALUE)
                    .addComponent(cbFeladatokKStatusz, 0, 321, Short.MAX_VALUE)
                    .addComponent(cbFeladatokKFelelos, 0, 321, Short.MAX_VALUE)
                    .addComponent(tfFeladatokKTargy, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(jLabel79)
                    .addComponent(dcFeladatokHataridoDatum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnFeladatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFeladatokKezelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel47))
                    .addGroup(pnFeladatokKezelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btFeladatokHataridoDatumTorol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(pnFeladatokKezelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10)
                .addContainerGap())
        );
        pnFeladatokKezelLayout.setVerticalGroup(
            pnFeladatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFeladatokKezelLayout.createSequentialGroup()
                .addGroup(pnFeladatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFeladatokKezelLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnFeladatokKezelLayout.createSequentialGroup()
                        .addGroup(pnFeladatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnFeladatokKezelLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btFeladatokHataridoDatumTorol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnFeladatokKezelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel79)
                                .addGap(18, 18, 18)
                                .addGroup(pnFeladatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(tfFeladatokKTargy, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32))
                                .addGap(18, 18, 18)
                                .addGroup(pnFeladatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel42)
                                    .addComponent(dcFeladatokHataridoDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(pnFeladatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cbFeladatokKFelelos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46))
                        .addGap(18, 18, 18)
                        .addGroup(pnFeladatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cbFeladatokKPNev, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56))
                        .addGap(18, 18, 18)
                        .addGroup(pnFeladatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cbFeladatokKStatusz, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45))))
                .addGap(26, 26, 26)
                .addGroup(pnFeladatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btFeladatokKHozzaad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFeladatokKModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFeladatokKTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFeladatokKAlap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnFeladatokKezelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btFeladatokHataridoDatumTorol, dcFeladatokHataridoDatum, tfFeladatokKTargy});

        pnJelentesek.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnJelentesek.setOpaque(false);

        jLabel58.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel58.setHorizontalAlignment(0);
        jLabel58.setText("Jelentések");

        jLabel59.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel59.setText("Előnézet:");

        btJelentesekTeljesMeret.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btJelentesekTeljesMeret.setText("Teljes méret");
        btJelentesekTeljesMeret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJelentesekGombokActionPerformed(evt);
            }
        });

        taJelentesekLeiras.setEditable(false);
        taJelentesekLeiras.setBackground(new java.awt.Color(240, 240, 240));
        taJelentesekLeiras.setColumns(20);
        taJelentesekLeiras.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        taJelentesekLeiras.setLineWrap(true);
        taJelentesekLeiras.setRows(5);
        taJelentesekLeiras.setWrapStyleWord(true);
        taJelentesekLeiras.setBorder(null);
        jScrollPane18.setViewportView(taJelentesekLeiras);

        jScrollPane13.setBorder(null);

        tblJelentesek.setAutoCreateRowSorter(true);
        tblJelentesek.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblJelentesek.setFocusable(false);
        tblJelentesek.setRowHeight(30);
        tblJelentesek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJelentesekMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tblJelentesek);

        btJelentesekMentPDF.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btJelentesekMentPDF.setText("Mentés PDF-be");
        btJelentesekMentPDF.setFocusPainted(false);
        btJelentesekMentPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJelentesekGombokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnJelentesekLayout = new javax.swing.GroupLayout(pnJelentesek);
        pnJelentesek.setLayout(pnJelentesekLayout);
        pnJelentesekLayout.setHorizontalGroup(
            pnJelentesekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnJelentesekLayout.createSequentialGroup()
                .addGroup(pnJelentesekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnJelentesekLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel58)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnJelentesekLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(pnJelentesekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addGroup(pnJelentesekLayout.createSequentialGroup()
                        .addGroup(pnJelentesekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addGroup(pnJelentesekLayout.createSequentialGroup()
                                .addComponent(btJelentesekTeljesMeret, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btJelentesekMentPDF)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnJelentesekLayout.setVerticalGroup(
            pnJelentesekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnJelentesekLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel58)
                .addGap(12, 12, 12)
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnJelentesekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnJelentesekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btJelentesekTeljesMeret, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btJelentesekMentPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnJelentesekLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btJelentesekMentPDF, btJelentesekTeljesMeret});

        pnJelentesekKezel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnJelentesekKezel.setOpaque(false);

        jScrollPane14.setBorder(null);

        tblJelentesekK.setAutoCreateRowSorter(true);
        tblJelentesekK.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblJelentesekK.setFocusable(false);
        tblJelentesekK.setRowHeight(25);
        tblJelentesekK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJelentesekKMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tblJelentesekK);

        cbJelentesekKPNev.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel51.setText("Projekt neve:");

        jLabel54.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel54.setText("Rövid leírás:");

        taJelentesekKLeiras.setColumns(20);
        taJelentesekKLeiras.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        taJelentesekKLeiras.setLineWrap(true);
        taJelentesekKLeiras.setRows(5);
        taJelentesekKLeiras.setWrapStyleWord(true);
        jScrollPane15.setViewportView(taJelentesekKLeiras);

        btJelentesekKHozzaad.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btJelentesekKHozzaad.setText("Hozzáad");
        btJelentesekKHozzaad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJelentesekKGombokActionPerformed(evt);
            }
        });

        btJelentesekKTorol.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btJelentesekKTorol.setText("Töröl");
        btJelentesekKTorol.setEnabled(false);
        btJelentesekKTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJelentesekKGombokActionPerformed(evt);
            }
        });

        btJelentesekKAlap.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btJelentesekKAlap.setText("Alaphelyzet");
        btJelentesekKAlap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJelentesekKGombokActionPerformed(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel84.setHorizontalAlignment(0);
        jLabel84.setText("Jelentések kezelése");

        btJelentesekKModosit.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btJelentesekKModosit.setText("Módosít");
        btJelentesekKModosit.setEnabled(false);
        btJelentesekKModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJelentesekKGombokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnJelentesekKezelLayout = new javax.swing.GroupLayout(pnJelentesekKezel);
        pnJelentesekKezel.setLayout(pnJelentesekKezelLayout);
        pnJelentesekKezelLayout.setHorizontalGroup(
            pnJelentesekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnJelentesekKezelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnJelentesekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnJelentesekKezelLayout.createSequentialGroup()
                        .addGroup(pnJelentesekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnJelentesekKezelLayout.createSequentialGroup()
                                .addGap(0, 87, Short.MAX_VALUE)
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnJelentesekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel84)
                                    .addComponent(cbJelentesekKPNev, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel54))
                            .addGroup(pnJelentesekKezelLayout.createSequentialGroup()
                                .addComponent(btJelentesekKHozzaad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btJelentesekKModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btJelentesekKTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btJelentesekKAlap, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                        .addContainerGap(154, Short.MAX_VALUE))
                    .addGroup(pnJelentesekKezelLayout.createSequentialGroup()
                        .addComponent(jScrollPane14)
                        .addContainerGap())))
        );
        pnJelentesekKezelLayout.setVerticalGroup(
            pnJelentesekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnJelentesekKezelLayout.createSequentialGroup()
                .addGroup(pnJelentesekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnJelentesekKezelLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(pnJelentesekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnJelentesekKezelLayout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnJelentesekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btJelentesekKHozzaad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btJelentesekKAlap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btJelentesekKModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btJelentesekKTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pnJelentesekKezelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel84)
                        .addGap(18, 18, 18)
                        .addGroup(pnJelentesekKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel51)
                            .addComponent(cbJelentesekKPNev, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnDolgozokKezel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnDolgozokKezel.setOpaque(false);

        jScrollPane19.setBorder(null);

        tblDolgozok.setAutoCreateRowSorter(true);
        tblDolgozok.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblDolgozok.setFocusable(false);
        tblDolgozok.setRowHeight(25);
        tblDolgozok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDolgozokMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(tblDolgozok);

        jLabel63.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel63.setText("Dolgozó neve:");

        tfDolgozokNev.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel65.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel65.setText("Skill:");

        jLabel68.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel68.setText("Telefonszám:");

        btDolgozokHozzaad.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btDolgozokHozzaad.setText("Hozzáad");
        btDolgozokHozzaad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDolgozokGombokActionPerformed(evt);
            }
        });

        cbDolgozokFTerulet.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel70.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel70.setText("Fejlesztési terület:");

        btDolgozokModosit.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btDolgozokModosit.setText("Módosít");
        btDolgozokModosit.setEnabled(false);
        btDolgozokModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDolgozokGombokActionPerformed(evt);
            }
        });

        btDolgozokTorol.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btDolgozokTorol.setText("Töröl");
        btDolgozokTorol.setEnabled(false);
        btDolgozokTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDolgozokGombokActionPerformed(evt);
            }
        });

        btDolgozokAlap.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btDolgozokAlap.setText("Alaphelyzet");
        btDolgozokAlap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDolgozokGombokActionPerformed(evt);
            }
        });

        tfDolgozokTelSzam.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel83.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel83.setHorizontalAlignment(0);
        jLabel83.setText("Dolgozók kezelése");

        jLabel69.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel69.setText("Kezdés dátuma:");

        jLabel71.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel71.setText("Beosztás:");

        cbDolgozokBeosztas.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        cbDolgozoSkill.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        dcDolgozoKezdesDatum.setFocusable(false);
        dcDolgozoKezdesDatum.setPreferredSize(new java.awt.Dimension(91, 23));

        btDolgozoKezdesDatumTorol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projektmenedzsmentrendszer/images/torolIkon.png"))); // NOI18N
        btDolgozoKezdesDatumTorol.setPreferredSize(new java.awt.Dimension(53, 23));
        btDolgozoKezdesDatumTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDolgozoKezdesDatumTorolbtKeresesDatumTorolGombokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDolgozokKezelLayout = new javax.swing.GroupLayout(pnDolgozokKezel);
        pnDolgozokKezel.setLayout(pnDolgozokKezelLayout);
        pnDolgozokKezelLayout.setHorizontalGroup(
            pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDolgozokKezelLayout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addGroup(pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbDolgozoSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDolgozokFTerulet, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDolgozokBeosztas, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDolgozokNev, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83))
                .addGap(97, 97, 97)
                .addGroup(pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDolgozokTelSzam, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnDolgozokKezelLayout.createSequentialGroup()
                        .addComponent(dcDolgozoKezdesDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDolgozoKezdesDatumTorol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(pnDolgozokKezelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDolgozokKezelLayout.createSequentialGroup()
                        .addComponent(jScrollPane19)
                        .addGap(10, 10, 10))
                    .addGroup(pnDolgozokKezelLayout.createSequentialGroup()
                        .addComponent(btDolgozokHozzaad, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btDolgozokModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btDolgozokTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btDolgozokAlap, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnDolgozokKezelLayout.setVerticalGroup(
            pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDolgozokKezelLayout.createSequentialGroup()
                .addGroup(pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDolgozokKezelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel63))
                    .addGroup(pnDolgozokKezelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel83)
                        .addGap(18, 18, 18)
                        .addComponent(tfDolgozokNev, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDolgozokKezelLayout.createSequentialGroup()
                        .addGroup(pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbDolgozokBeosztas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel71))
                        .addGap(18, 18, 18)
                        .addGroup(pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDolgozokKezelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel70))
                            .addComponent(cbDolgozokFTerulet, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnDolgozokKezelLayout.createSequentialGroup()
                        .addGroup(pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel69)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btDolgozoKezdesDatumTorol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dcDolgozoKezdesDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDolgozokKezelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel68))
                            .addComponent(tfDolgozokTelSzam, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDolgozokKezelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel65))
                    .addComponent(cbDolgozoSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnDolgozokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btDolgozokHozzaad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDolgozokModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDolgozokTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDolgozokAlap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnDolgozokKezelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btDolgozoKezdesDatumTorol, dcDolgozoKezdesDatum, tfDolgozokTelSzam});

        pnDolgozokCsapatok.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnDolgozokCsapatok.setOpaque(false);

        jLabel48.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel48.setText("Csapat neve:");

        btCsapatOsszeallitAddDolgozo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btCsapatOsszeallitAddDolgozo.setText("<");
        btCsapatOsszeallitAddDolgozo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCsapatOsszeallitGombokActionPerformed(evt);
            }
        });

        btCsapatOsszeallitOsszesAdd.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btCsapatOsszeallitOsszesAdd.setText("<<");
        btCsapatOsszeallitOsszesAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCsapatOsszeallitGombokActionPerformed(evt);
            }
        });

        liCsapatOsszeallitCstagok.setBackground(new java.awt.Color(240, 240, 240));
        liCsapatOsszeallitCstagok.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        liCsapatOsszeallitCstagok.setSelectionMode(0);
        jScrollPane22.setViewportView(liCsapatOsszeallitCstagok);

        liCsapatOsszeallitDolgozok.setBackground(new java.awt.Color(240, 240, 240));
        liCsapatOsszeallitDolgozok.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        liCsapatOsszeallitDolgozok.setSelectionMode(0);
        jScrollPane23.setViewportView(liCsapatOsszeallitDolgozok);

        cbCsapatOsszeallitNev.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbCsapatOsszeallitNev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCsapatOsszeallitNevActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel53.setText("Csapattagok:");

        jLabel55.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel55.setText("Fejlesztők:");

        btCsapatOsszeallitMent.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btCsapatOsszeallitMent.setText("Mentés");
        btCsapatOsszeallitMent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCsapatOsszeallitMentActionPerformed(evt);
            }
        });

        btCsapatOsszeallitOsszesKivesz.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btCsapatOsszeallitOsszesKivesz.setText(">>");
        btCsapatOsszeallitOsszesKivesz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCsapatOsszeallitGombokActionPerformed(evt);
            }
        });

        btCsapatOsszeallitKiveszDolgozo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btCsapatOsszeallitKiveszDolgozo.setText(">");
        btCsapatOsszeallitKiveszDolgozo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCsapatOsszeallitGombokActionPerformed(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel72.setHorizontalAlignment(0);
        jLabel72.setText("Csapatok összeállítása");

        javax.swing.GroupLayout pnDolgozokCsapatokLayout = new javax.swing.GroupLayout(pnDolgozokCsapatok);
        pnDolgozokCsapatok.setLayout(pnDolgozokCsapatokLayout);
        pnDolgozokCsapatokLayout.setHorizontalGroup(
            pnDolgozokCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDolgozokCsapatokLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(pnDolgozokCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btCsapatOsszeallitMent, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDolgozokCsapatokLayout.createSequentialGroup()
                        .addGroup(pnDolgozokCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDolgozokCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDolgozokCsapatokLayout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addGap(0, 731, Short.MAX_VALUE))
                            .addGroup(pnDolgozokCsapatokLayout.createSequentialGroup()
                                .addGroup(pnDolgozokCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCsapatOsszeallitNev, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane22))
                                .addGap(18, 18, 18)
                                .addGroup(pnDolgozokCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnDolgozokCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btCsapatOsszeallitOsszesAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                        .addComponent(btCsapatOsszeallitOsszesKivesz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btCsapatOsszeallitAddDolgozo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(btCsapatOsszeallitKiveszDolgozo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnDolgozokCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel55)
                                    .addComponent(jScrollPane23))))))
                .addGap(71, 71, 71))
        );

        pnDolgozokCsapatokLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCsapatOsszeallitAddDolgozo, btCsapatOsszeallitKiveszDolgozo, btCsapatOsszeallitOsszesAdd, btCsapatOsszeallitOsszesKivesz});

        pnDolgozokCsapatokLayout.setVerticalGroup(
            pnDolgozokCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDolgozokCsapatokLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel72)
                .addGap(18, 18, 18)
                .addGroup(pnDolgozokCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDolgozokCsapatokLayout.createSequentialGroup()
                        .addGroup(pnDolgozokCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDolgozokCsapatokLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(cbCsapatOsszeallitNev, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel48))
                        .addGroup(pnDolgozokCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDolgozokCsapatokLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnDolgozokCsapatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53)
                                    .addComponent(jScrollPane22)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDolgozokCsapatokLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                                .addComponent(btCsapatOsszeallitAddDolgozo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCsapatOsszeallitKiveszDolgozo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btCsapatOsszeallitOsszesAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCsapatOsszeallitOsszesKivesz, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDolgozokCsapatokLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane23)))
                .addGap(18, 18, 18)
                .addComponent(btCsapatOsszeallitMent, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnDolgozokCsapatokLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btCsapatOsszeallitAddDolgozo, btCsapatOsszeallitKiveszDolgozo, btCsapatOsszeallitOsszesAdd, btCsapatOsszeallitOsszesKivesz});

        pnDolgozokCsapatokKezel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnDolgozokCsapatokKezel.setOpaque(false);

        jScrollPane21.setBorder(null);

        tblCsapatokK.setAutoCreateRowSorter(true);
        tblCsapatokK.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblCsapatokK.setFocusable(false);
        tblCsapatokK.setRowHeight(25);
        tblCsapatokK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCsapatokKMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(tblCsapatokK);

        tfCsapatokKNev.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel73.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel73.setText("Csapat neve:");

        cbCsapatokKCsVez.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel75.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel75.setText("Csapatvezető:");

        btCsapatokKHozzaad.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btCsapatokKHozzaad.setText("Hozzáad");
        btCsapatokKHozzaad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCsapatokKGombokActionPerformed(evt);
            }
        });

        btCsapatokKModosit.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btCsapatokKModosit.setText("Módosít");
        btCsapatokKModosit.setEnabled(false);
        btCsapatokKModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCsapatokKGombokActionPerformed(evt);
            }
        });

        btCsapatokKTorol.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btCsapatokKTorol.setText("Töröl");
        btCsapatokKTorol.setEnabled(false);
        btCsapatokKTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCsapatokKGombokActionPerformed(evt);
            }
        });

        btCsapatokKAlap.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btCsapatokKAlap.setText("Alaphelyzet");
        btCsapatokKAlap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCsapatokKGombokActionPerformed(evt);
            }
        });

        jLabel85.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel85.setHorizontalAlignment(0);
        jLabel85.setText("Csapatok kezelése");

        javax.swing.GroupLayout pnDolgozokCsapatokKezelLayout = new javax.swing.GroupLayout(pnDolgozokCsapatokKezel);
        pnDolgozokCsapatokKezel.setLayout(pnDolgozokCsapatokKezelLayout);
        pnDolgozokCsapatokKezelLayout.setHorizontalGroup(
            pnDolgozokCsapatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDolgozokCsapatokKezelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 1332, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(pnDolgozokCsapatokKezelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btCsapatokKHozzaad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCsapatokKModosit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCsapatokKTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCsapatokKAlap, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnDolgozokCsapatokKezelLayout.createSequentialGroup()
                .addContainerGap(504, Short.MAX_VALUE)
                .addGroup(pnDolgozokCsapatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDolgozokCsapatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel85)
                    .addGroup(pnDolgozokCsapatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbCsapatokKCsVez, javax.swing.GroupLayout.Alignment.TRAILING, 0, 262, Short.MAX_VALUE)
                        .addComponent(tfCsapatokKNev, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(476, Short.MAX_VALUE))
        );

        pnDolgozokCsapatokKezelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCsapatokKHozzaad, btCsapatokKModosit, btCsapatokKTorol});

        pnDolgozokCsapatokKezelLayout.setVerticalGroup(
            pnDolgozokCsapatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDolgozokCsapatokKezelLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(jLabel85)
                .addGap(18, 18, 18)
                .addGroup(pnDolgozokCsapatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(tfCsapatokKNev, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnDolgozokCsapatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel75)
                    .addComponent(cbCsapatokKCsVez, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(pnDolgozokCsapatokKezelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCsapatokKHozzaad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCsapatokKModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCsapatokKTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCsapatokKAlap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnJelszovaltoztatas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnJelszovaltoztatas.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel3.setText("Jelszóváltoztatás");

        lbJelszoHibaUzenet.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbJelszoHibaUzenet.setForeground(new java.awt.Color(255, 0, 51));

        pfJelszoValtUj.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        pfJelszoValtMegerosit.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel5.setText("Új jelszó:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel4.setText("Jelenlegi jelszó:");

        btJelszoValtMent.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btJelszoValtMent.setText("Mentés");
        btJelszoValtMent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJelszoValtMentActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel7.setText("Új jelszó megerősítése:");

        pfJelszoValtJelenlegi.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        javax.swing.GroupLayout pnJelszovaltoztatasLayout = new javax.swing.GroupLayout(pnJelszovaltoztatas);
        pnJelszovaltoztatas.setLayout(pnJelszovaltoztatasLayout);
        pnJelszovaltoztatasLayout.setHorizontalGroup(
            pnJelszovaltoztatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnJelszovaltoztatasLayout.createSequentialGroup()
                .addContainerGap(384, Short.MAX_VALUE)
                .addGroup(pnJelszovaltoztatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnJelszovaltoztatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pfJelszoValtMegerosit)
                    .addComponent(pfJelszoValtUj)
                    .addComponent(pfJelszoValtJelenlegi)
                    .addComponent(btJelszoValtMent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
                .addComponent(lbJelszoHibaUzenet, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnJelszovaltoztatasLayout.setVerticalGroup(
            pnJelszovaltoztatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnJelszovaltoztatasLayout.createSequentialGroup()
                .addContainerGap(266, Short.MAX_VALUE)
                .addGroup(pnJelszovaltoztatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbJelszoHibaUzenet, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnJelszovaltoztatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(pfJelszoValtJelenlegi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnJelszovaltoztatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(pfJelszoValtUj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnJelszovaltoztatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(pfJelszoValtMegerosit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btJelszoValtMent, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
        );

        lpTartalom.setLayer(pnFooldal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpTartalom.setLayer(pnFooldalKereses, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpTartalom.setLayer(pnProjektekKezel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpTartalom.setLayer(pnProjektekMegrendelo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpTartalom.setLayer(pnProjektCsapatok, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpTartalom.setLayer(pnFeladatok, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpTartalom.setLayer(pnFeladatokKezel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpTartalom.setLayer(pnJelentesek, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpTartalom.setLayer(pnJelentesekKezel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpTartalom.setLayer(pnDolgozokKezel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpTartalom.setLayer(pnDolgozokCsapatok, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpTartalom.setLayer(pnDolgozokCsapatokKezel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpTartalom.setLayer(pnJelszovaltoztatas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lpTartalomLayout = new javax.swing.GroupLayout(lpTartalom);
        lpTartalom.setLayout(lpTartalomLayout);
        lpTartalomLayout.setHorizontalGroup(
            lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnFooldal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnJelszovaltoztatas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnProjektekKezel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnJelentesek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnFooldalKereses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnProjektCsapatok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnFeladatok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnFeladatokKezel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnDolgozokKezel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnDolgozokCsapatokKezel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnJelentesekKezel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnProjektekMegrendelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnDolgozokCsapatok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lpTartalomLayout.setVerticalGroup(
            lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnFooldal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnJelszovaltoztatas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnProjektekKezel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnJelentesek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnFooldalKereses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnProjektCsapatok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnFeladatok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnFeladatokKezel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnDolgozokKezel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnDolgozokCsapatokKezel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnJelentesekKezel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnProjektekMegrendelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnDolgozokCsapatok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnFooldalKereses.setVisible(false);
        pnProjektekKezel.setVisible(false);
        pnProjektekMegrendelo.setVisible(false);
        pnProjektCsapatok.setVisible(false);
        pnFeladatok.setVisible(false);
        pnFeladatokKezel.setVisible(false);
        pnJelentesek.setVisible(false);
        pnJelentesekKezel.setVisible(false);
        pnDolgozokKezel.setVisible(false);
        pnDolgozokCsapatok.setVisible(false);
        pnDolgozokCsapatokKezel.setVisible(false);
        pnJelszovaltoztatas.setVisible(false);

        pnFooldalAlmenu.setBackground(new java.awt.Color(204, 204, 204));

        bgFomenuAlmenu.add(tbAttekinto);
        tbAttekinto.setSelected(true);
        tbAttekinto.setBackground(new java.awt.Color(235, 235, 235));
        tbAttekinto.setBorder(null);
        tbAttekinto.setFocusPainted(false);
        tbAttekinto.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbAttekinto.setText("Áttekintő");
        tbAttekinto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFooldalAlmenuActionPerformed(evt);
            }
        });

        bgFomenuAlmenu.add(tbKereses);
        tbKereses.setBackground(new java.awt.Color(235, 235, 235));
        tbKereses.setBorder(null);
        tbKereses.setFocusPainted(false);
        tbKereses.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbKereses.setText("Részletes keresés");
        tbKereses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFooldalAlmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFooldalAlmenuLayout = new javax.swing.GroupLayout(pnFooldalAlmenu);
        pnFooldalAlmenu.setLayout(pnFooldalAlmenuLayout);
        pnFooldalAlmenuLayout.setHorizontalGroup(
            pnFooldalAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFooldalAlmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbAttekinto, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbKereses)
                .addContainerGap(1172, Short.MAX_VALUE))
        );
        pnFooldalAlmenuLayout.setVerticalGroup(
            pnFooldalAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFooldalAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tbAttekinto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tbKereses, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnProjektekAlmenu.setBackground(new java.awt.Color(204, 204, 204));

        bgProjektek.add(tbProjektKezel);
        tbProjektKezel.setBackground(new java.awt.Color(235, 235, 235));
        tbProjektKezel.setBorder(null);
        tbProjektKezel.setFocusPainted(false);
        tbProjektKezel.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbProjektKezel.setText("Projekt kezelése");
        tbProjektKezel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbProjektekAlmenuActionPerformed(evt);
            }
        });

        bgProjektek.add(tbProjektCsapatok);
        tbProjektCsapatok.setActionCommand("Projekt kapcsolat");
        tbProjektCsapatok.setBackground(new java.awt.Color(235, 235, 235));
        tbProjektCsapatok.setBorder(null);
        tbProjektCsapatok.setFocusPainted(false);
        tbProjektCsapatok.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbProjektCsapatok.setText("Projekten dolgozó csapatok");
        tbProjektCsapatok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbProjektekAlmenuActionPerformed(evt);
            }
        });

        bgProjektek.add(tbProjektMegrendelo);
        tbProjektMegrendelo.setSelected(true);
        tbProjektMegrendelo.setBackground(new java.awt.Color(235, 235, 235));
        tbProjektMegrendelo.setBorder(null);
        tbProjektMegrendelo.setFocusPainted(false);
        tbProjektMegrendelo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbProjektMegrendelo.setText("Megrendelők kezelése");
        tbProjektMegrendelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbProjektekAlmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnProjektekAlmenuLayout = new javax.swing.GroupLayout(pnProjektekAlmenu);
        pnProjektekAlmenu.setLayout(pnProjektekAlmenuLayout);
        pnProjektekAlmenuLayout.setHorizontalGroup(
            pnProjektekAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProjektekAlmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbProjektKezel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbProjektMegrendelo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbProjektCsapatok)
                .addContainerGap(611, Short.MAX_VALUE))
        );
        pnProjektekAlmenuLayout.setVerticalGroup(
            pnProjektekAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProjektekAlmenuLayout.createSequentialGroup()
                .addGroup(pnProjektekAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbProjektKezel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbProjektCsapatok, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbProjektMegrendelo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        pnFeladatokAlmenu.setBackground(new java.awt.Color(204, 204, 204));

        bgFeladatok.add(tbFeladatok);
        tbFeladatok.setSelected(true);
        tbFeladatok.setBackground(new java.awt.Color(235, 235, 235));
        tbFeladatok.setBorder(null);
        tbFeladatok.setFocusPainted(false);
        tbFeladatok.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbFeladatok.setText("Feladatok áttekintő");
        tbFeladatok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFeladatokAlmenuActionPerformed(evt);
            }
        });

        bgFeladatok.add(tbFeladatokKezel);
        tbFeladatokKezel.setActionCommand("Projekt kapcsolat");
        tbFeladatokKezel.setBackground(new java.awt.Color(235, 235, 235));
        tbFeladatokKezel.setBorder(null);
        tbFeladatokKezel.setFocusPainted(false);
        tbFeladatokKezel.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbFeladatokKezel.setText("Feladatok kezelése");
        tbFeladatokKezel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFeladatokAlmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFeladatokAlmenuLayout = new javax.swing.GroupLayout(pnFeladatokAlmenu);
        pnFeladatokAlmenu.setLayout(pnFeladatokAlmenuLayout);
        pnFeladatokAlmenuLayout.setHorizontalGroup(
            pnFeladatokAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFeladatokAlmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbFeladatok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbFeladatokKezel)
                .addContainerGap(1172, Short.MAX_VALUE))
        );
        pnFeladatokAlmenuLayout.setVerticalGroup(
            pnFeladatokAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFeladatokAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tbFeladatok, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tbFeladatokKezel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnJelentesekAlmenu.setBackground(new java.awt.Color(204, 204, 204));

        bgJelentesek.add(tbJelentesek);
        tbJelentesek.setSelected(true);
        tbJelentesek.setBackground(new java.awt.Color(235, 235, 235));
        tbJelentesek.setBorder(null);
        tbJelentesek.setFocusPainted(false);
        tbJelentesek.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbJelentesek.setText("Jelentések áttekintő");
        tbJelentesek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbJelentesekAlmenuActionPerformed(evt);
            }
        });

        bgJelentesek.add(tbJelentesekKezel);
        tbJelentesekKezel.setActionCommand("Projekt kapcsolat");
        tbJelentesekKezel.setBackground(new java.awt.Color(235, 235, 235));
        tbJelentesekKezel.setBorder(null);
        tbJelentesekKezel.setFocusPainted(false);
        tbJelentesekKezel.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbJelentesekKezel.setText("Jelentések kezelése");
        tbJelentesekKezel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbJelentesekAlmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnJelentesekAlmenuLayout = new javax.swing.GroupLayout(pnJelentesekAlmenu);
        pnJelentesekAlmenu.setLayout(pnJelentesekAlmenuLayout);
        pnJelentesekAlmenuLayout.setHorizontalGroup(
            pnJelentesekAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnJelentesekAlmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbJelentesek)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbJelentesekKezel)
                .addContainerGap(881, Short.MAX_VALUE))
        );
        pnJelentesekAlmenuLayout.setVerticalGroup(
            pnJelentesekAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnJelentesekAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tbJelentesek, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tbJelentesekKezel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnDolgozokAlmenu.setBackground(new java.awt.Color(204, 204, 204));

        bgDolgozok.add(tbDolgozokKezel);
        tbDolgozokKezel.setBackground(new java.awt.Color(235, 235, 235));
        tbDolgozokKezel.setBorder(null);
        tbDolgozokKezel.setFocusPainted(false);
        tbDolgozokKezel.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbDolgozokKezel.setText("Dolgozók kezelése");
        tbDolgozokKezel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbDolgozokAlmenuActionPerformed(evt);
            }
        });

        bgDolgozok.add(tbDolgozokCsapatok);
        tbDolgozokCsapatok.setActionCommand("Projekt kapcsolat");
        tbDolgozokCsapatok.setBackground(new java.awt.Color(235, 235, 235));
        tbDolgozokCsapatok.setBorder(null);
        tbDolgozokCsapatok.setFocusPainted(false);
        tbDolgozokCsapatok.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbDolgozokCsapatok.setText("Csapatok összeállítása");
        tbDolgozokCsapatok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbDolgozokAlmenuActionPerformed(evt);
            }
        });

        bgDolgozok.add(tbDolgozokCsapatokKezell);
        tbDolgozokCsapatokKezell.setActionCommand("Projekt kapcsolat");
        tbDolgozokCsapatokKezell.setBackground(new java.awt.Color(235, 235, 235));
        tbDolgozokCsapatokKezell.setBorder(null);
        tbDolgozokCsapatokKezell.setFocusPainted(false);
        tbDolgozokCsapatokKezell.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbDolgozokCsapatokKezell.setText("Csapatok kezelése");
        tbDolgozokCsapatokKezell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbDolgozokAlmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDolgozokAlmenuLayout = new javax.swing.GroupLayout(pnDolgozokAlmenu);
        pnDolgozokAlmenu.setLayout(pnDolgozokAlmenuLayout);
        pnDolgozokAlmenuLayout.setHorizontalGroup(
            pnDolgozokAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDolgozokAlmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbDolgozokKezel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbDolgozokCsapatok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbDolgozokCsapatokKezell)
                .addContainerGap(900, Short.MAX_VALUE))
        );
        pnDolgozokAlmenuLayout.setVerticalGroup(
            pnDolgozokAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDolgozokAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tbDolgozokKezel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tbDolgozokCsapatok, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tbDolgozokCsapatokKezell, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnVisszaAlmenu.setBackground(new java.awt.Color(204, 204, 204));

        btVissza.setBackground(new java.awt.Color(235, 235, 235));
        btVissza.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btVissza.setText("Vissza");
        btVissza.setFocusPainted(false);
        btVissza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisszaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnVisszaAlmenuLayout = new javax.swing.GroupLayout(pnVisszaAlmenu);
        pnVisszaAlmenu.setLayout(pnVisszaAlmenuLayout);
        pnVisszaAlmenuLayout.setHorizontalGroup(
            pnVisszaAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVisszaAlmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btVissza, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(986, Short.MAX_VALUE))
        );
        pnVisszaAlmenuLayout.setVerticalGroup(
            pnVisszaAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btVissza, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lpAlmenu.setLayer(pnFooldalAlmenu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpAlmenu.setLayer(pnProjektekAlmenu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpAlmenu.setLayer(pnFeladatokAlmenu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpAlmenu.setLayer(pnJelentesekAlmenu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpAlmenu.setLayer(pnDolgozokAlmenu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpAlmenu.setLayer(pnVisszaAlmenu, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lpAlmenuLayout = new javax.swing.GroupLayout(lpAlmenu);
        lpAlmenu.setLayout(lpAlmenuLayout);
        lpAlmenuLayout.setHorizontalGroup(
            lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lpAlmenuLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnProjektekAlmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
            .addGroup(lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnFooldalAlmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnVisszaAlmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnFeladatokAlmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnJelentesekAlmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnDolgozokAlmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lpAlmenuLayout.setVerticalGroup(
            lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnProjektekAlmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpAlmenuLayout.createSequentialGroup()
                    .addComponent(pnFooldalAlmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpAlmenuLayout.createSequentialGroup()
                    .addComponent(pnVisszaAlmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpAlmenuLayout.createSequentialGroup()
                    .addComponent(pnFeladatokAlmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpAlmenuLayout.createSequentialGroup()
                    .addComponent(pnJelentesekAlmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpAlmenuLayout.createSequentialGroup()
                    .addComponent(pnDolgozokAlmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnProjektekAlmenu.setVisible(false);
        pnFeladatokAlmenu.setVisible(false);
        pnJelentesekAlmenu.setVisible(false);
        pnDolgozokAlmenu.setVisible(false);
        pnVisszaAlmenu.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnFomenu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lpTartalom)
                    .addComponent(lpAlmenu)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pnFomenu, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lpAlmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lpTartalom))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btJelszoValtMentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJelszoValtMentActionPerformed
        vezerlo.jelszovaltoztatas(this, pfJelszoValtJelenlegi.getPassword(), pfJelszoValtUj.getPassword(), pfJelszoValtMegerosit.getPassword());
    }//GEN-LAST:event_btJelszoValtMentActionPerformed

    @Override
    public void jelszovaltPanelAlaphelyzet() {
        pfJelszoValtJelenlegi.setText(null);
        pfJelszoValtUj.setText(null);
        pfJelszoValtMegerosit.setText(null);
    }

    private void tbtFomenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtFomenuActionPerformed
        kivalasztottMenuGomb = (JToggleButton) evt.getSource();

        if (!jelenlegiOldal.equals(pnFooldal) && tbtFooldal.equals(kivalasztottMenuGomb)) {
            tbFooldalAktivP.setSelected(true);
            tablaFrissit(tblFooldalProjektek, vezerlo.getFooldalAttekintoTablaAktivP());
            panelValt(pnFooldal, pnFooldalAlmenu);
            tbAttekinto.setSelected(true);
        } else if (!jelenlegiOldal.equals(pnProjektekKezel) && tbtProjektek.equals(kivalasztottMenuGomb)) {
            projektPanelAlaphelyzet();
            panelValt(pnProjektekKezel, pnProjektekAlmenu);
            tbProjektKezel.setSelected(true);
        } else if (!jelenlegiOldal.equals(pnFeladatok) && tbtFeladatok.equals(kivalasztottMenuGomb)) {
            tbFeladatokAktivP.setSelected(true);
            tablaFrissit(tblFeladatok, vezerlo.getFeladatokTablaAktivF());
            panelValt(pnFeladatok, pnFeladatokAlmenu);
            tbFeladatok.setSelected(true);
        } else if (!jelenlegiOldal.equals(pnJelentesek) && tbtJelentesek.equals(kivalasztottMenuGomb)) {
            tablaFrissit(tblJelentesek, vezerlo.getJelentesekTabla());
            panelValt(pnJelentesek, pnJelentesekAlmenu);
            tbJelentesek.setSelected(true);
        } else if (!jelenlegiOldal.equals(pnDolgozokKezel) && tbtDolgozok.equals(kivalasztottMenuGomb)) {
            dolgozoPanelAlaphelyzet();
            panelValt(pnDolgozokKezel, pnDolgozokAlmenu);
            tbDolgozokKezel.setSelected(true);
        }
    }//GEN-LAST:event_tbtFomenuActionPerformed

    private void tbFooldalAlmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFooldalAlmenuActionPerformed
        kivalasztottMenuGomb = (JToggleButton) evt.getSource();

        if (!jelenlegiOldal.equals(pnFooldal) && tbAttekinto.equals(kivalasztottMenuGomb)) {
            tbFooldalAktivP.setSelected(true);
            tablaFrissit(tblFooldalProjektek, vezerlo.getFooldalAttekintoTablaAktivP());
            panelValt(pnFooldal, pnFooldalAlmenu);
        } else if (!jelenlegiOldal.equals(pnFooldalKereses) && tbKereses.equals(kivalasztottMenuGomb)) {
            tablaFrissit(tblFooldalKereses, vezerlo.getFooldalAttekintoTablaOsszesP());
            comboBoxFrissit(cbKeresesMegrend, vezerlo.getMegrendelokCBModell());
            comboBoxFrissit(cbKeresesFTerulet, vezerlo.getFTeruletCBModell());
            comboBoxFrissit(cbKeresesHolTart, vezerlo.getHolTartCBModell());
            comboBoxFrissit(cbKeresesPrioritas, vezerlo.getPrioritasCBModell());
            comboBoxFrissit(cbKeresesPVezeto, vezerlo.getProjektvezetoCBModell());
            comboBoxFrissit(cbKeresesStatusz, vezerlo.getStatuszCBModell());
            panelValt(pnFooldalKereses, pnFooldalAlmenu);
        }
    }//GEN-LAST:event_tbFooldalAlmenuActionPerformed

    private void btJelentesekGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJelentesekGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();

        if (tblJelentesek.getSelectedRow() > -1) {
            Object kivalasztottObj = tblJelentesek.getValueAt(tblJelentesek.getSelectedRow(), JelentesTablaModell.OBJECT_OSZLOP);
            if (btJelentesekTeljesMeret.equals(kivalasztottGomb)) {
                vezerlo.jelentesTeljesNezet(kivalasztottObj);
            } else if (btJelentesekMentPDF.equals(kivalasztottGomb)) {
                vezerlo.jelentesMentesPDF(kivalasztottObj);
                tblJelentesek.setSelectionMode(0);
            }
        } else {
            infoAblak("Válassz ki egy jelentést!", "Info");
        }
    }//GEN-LAST:event_btJelentesekGombokActionPerformed

    private void tbFeladatokAlmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFeladatokAlmenuActionPerformed
        kivalasztottMenuGomb = (JToggleButton) evt.getSource();

        if (!jelenlegiOldal.equals(pnFeladatok) && tbFeladatok.equals(kivalasztottMenuGomb)) {
            tbFeladatokAktivP.setSelected(true);
            tablaFrissit(tblFeladatok, vezerlo.getFeladatokTablaAktivF());
            panelValt(pnFeladatok, pnFeladatokAlmenu);
        } else if (!jelenlegiOldal.equals(pnFeladatokKezel) && tbFeladatokKezel.equals(kivalasztottMenuGomb)) {
            feladatPanelAlaphelyzet();
            panelValt(pnFeladatokKezel, pnFeladatokAlmenu);
        }
    }//GEN-LAST:event_tbFeladatokAlmenuActionPerformed

    private void tbJelentesekAlmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbJelentesekAlmenuActionPerformed
        kivalasztottMenuGomb = (JToggleButton) evt.getSource();

        if (!jelenlegiOldal.equals(pnJelentesek) && tbJelentesek.equals(kivalasztottMenuGomb)) {
            tablaFrissit(tblJelentesek, vezerlo.getJelentesekTabla());
            panelValt(pnJelentesek, pnJelentesekAlmenu);
        } else if (!jelenlegiOldal.equals(pnJelentesekKezel) && tbJelentesekKezel.equals(kivalasztottMenuGomb)) {
            jelentesPanelAlaphelyzet();
            panelValt(pnJelentesekKezel, pnJelentesekAlmenu);
        }
    }//GEN-LAST:event_tbJelentesekAlmenuActionPerformed

    private void tbDolgozokAlmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbDolgozokAlmenuActionPerformed
        kivalasztottMenuGomb = (JToggleButton) evt.getSource();

        if (!jelenlegiOldal.equals(pnDolgozokKezel) && tbDolgozokKezel.equals(kivalasztottMenuGomb)) {
            dolgozoPanelAlaphelyzet();
            panelValt(pnDolgozokKezel, pnDolgozokAlmenu);
        } else if (!jelenlegiOldal.equals(pnDolgozokCsapatok) && tbDolgozokCsapatok.equals(kivalasztottMenuGomb)) {
            comboBoxFrissit(cbCsapatOsszeallitNev, vezerlo.getCsapatCBModell());
            listaFrissit(liCsapatOsszeallitCstagok, vezerlo.getKivalasztottCsapatTagjaiLModell(cbCsapatOsszeallitNev.getSelectedItem()));
            listaFrissit(liCsapatOsszeallitDolgozok, vezerlo.getDolgozokLModell(cbCsapatOsszeallitNev.getSelectedItem()));
            panelValt(pnDolgozokCsapatok, pnDolgozokAlmenu);
        } else if (!jelenlegiOldal.equals(pnDolgozokCsapatokKezel) && tbDolgozokCsapatokKezell.equals(kivalasztottMenuGomb)) {
            csapatKPanelAlaphelyzet();
            panelValt(pnDolgozokCsapatokKezel, pnDolgozokAlmenu);
        }
    }//GEN-LAST:event_tbDolgozokAlmenuActionPerformed

    private void tbProjektekAlmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbProjektekAlmenuActionPerformed
        kivalasztottMenuGomb = (JToggleButton) evt.getSource();

        if (!jelenlegiOldal.equals(pnProjektekKezel) && tbProjektKezel.equals(kivalasztottMenuGomb)) {
            tablaFrissit(tblProjektek, vezerlo.getFooldalAttekintoTablaOsszesP());
            projektPanelAlaphelyzet();
            panelValt(pnProjektekKezel, pnProjektekAlmenu);
        } else if (!jelenlegiOldal.equals(pnProjektekMegrendelo) && tbProjektMegrendelo.equals(kivalasztottMenuGomb)) {
            tablaFrissit(tblProjektMegrend, vezerlo.getProjektMegrendelokTabla());
            megrendPanelAlaphelyzet();
            panelValt(pnProjektekMegrendelo, pnProjektekAlmenu);
        } else if (!jelenlegiOldal.equals(pnProjektCsapatok) && tbProjektCsapatok.equals(kivalasztottMenuGomb)) {
            comboBoxFrissit(cbProjektCsapatokProjektNev, vezerlo.getProjektCBModell());
            listaFrissit(liProjektenDolgozoCsapatok, vezerlo.getKivalasztottProjektenDolgozoCsapatokLModell(((Projekt) cbProjektCsapatokProjektNev.getSelectedItem()).getAzon()));
            listaFrissit(liProjektCsapatCsapatok, vezerlo.getCsapatokLModell((Projekt) cbProjektCsapatokProjektNev.getSelectedItem()));
            panelValt(pnProjektCsapatok, pnProjektekAlmenu);
        }
    }//GEN-LAST:event_tbProjektekAlmenuActionPerformed

    private void btVisszaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisszaActionPerformed
        panelValt(elozoOldal, elozoAlmenu);
    }//GEN-LAST:event_btVisszaActionPerformed

    private void btFomenuAlsoGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFomenuAlsoGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();

        if (!jelenlegiOldal.equals(pnJelszovaltoztatas) && btJelszovalt.equals(kivalasztottGomb)) {
            panelValt(pnJelszovaltoztatas, pnVisszaAlmenu);
        } else if (btKijelentkezes.equals(kivalasztottGomb)) {
            vezerlo.kijelentkezes();
        }
    }//GEN-LAST:event_btFomenuAlsoGombokActionPerformed

    private void btKeresesGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKeresesGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();

        if (btKeresesKeres.equals(kivalasztottGomb)) {
            tablaFrissit(tblFooldalKereses, vezerlo.getReszletesKeresesProjektekTabla(
                    cbKeresesMegrend.getSelectedItem(), cbKeresesFTerulet.getSelectedIndex() + 1,
                    dcKeresesDatumtol.getDate(), dcKeresesDatumig.getDate(), cbKeresesHolTart.getSelectedIndex() + 1, cbKeresesPrioritas.getSelectedIndex() + 1,
                    cbKeresesPVezeto.getSelectedItem(), cbKeresesStatusz.getSelectedIndex() + 1
            ));
        } else if (btKeresesMentPDF.equals(kivalasztottGomb)) {
            vezerlo.mentesPDF(tblFooldalKereses.getModel());
        }
    }//GEN-LAST:event_btKeresesGombokActionPerformed

    private void btFooldalGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFooldalGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();

        if (btFooldalKeres.equals(kivalasztottGomb)) {
            tablaFrissit(tblFooldalProjektek, vezerlo.getKeresProjektTabla(tfFooldalPNev.getText()));
        } else if (btFooldalInfo.equals(kivalasztottGomb)) {
            int kivalasztottSor = tblFooldalProjektek.getSelectedRow();

            if (kivalasztottSor >= 0) {
                vezerlo.keszitTobbinfoAblak(kivalasztottSor);
            } else {
                infoAblak("Válassz ki egy projektet!", "Info");
            }
            tblFooldalProjektek.setSelectionMode(0);
        } else if (btFooldalMentPDF.equals(kivalasztottGomb)) {
            tblFooldalProjektek.setSelectionMode(0);
            vezerlo.mentesPDF(tblFooldalProjektek.getModel());
        } else if (btFooldalFrissit.equals(kivalasztottGomb)) {
            tblFooldalProjektek.setSelectionMode(0);
            tfFooldalPNev.setText(null);
            if (tbFooldalAktivP.isSelected()) {
                tablaFrissit(tblFooldalProjektek, vezerlo.getFooldalAttekintoTablaAktivP());
            } else {
                tablaFrissit(tblFooldalProjektek, vezerlo.getFooldalAttekintoTablaOsszesP());
            }
        }
    }//GEN-LAST:event_btFooldalGombokActionPerformed

    private void tblFooldalProjektekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFooldalProjektekMouseClicked
        int kivalasztottSor = tblFooldalProjektek.getSelectedRow();
        if (kivalasztottSor >= 0) {
            Projekt kivalasztottProjekt = (Projekt) tblFooldalProjektek.getValueAt(kivalasztottSor, ProjektTablaModell.OBJECT_OSZLOP);
            lbFooldalPNev.setText(kivalasztottProjekt.getNev() + ":");
            taFooldalPLeiras.setText(kivalasztottProjekt.getLeiras());
        }
    }//GEN-LAST:event_tblFooldalProjektekMouseClicked

    private void tblFooldalProjektekFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblFooldalProjektekFocusLost
        lbFooldalPNev.setText(null);
        taFooldalPLeiras.setText(null);
    }//GEN-LAST:event_tblFooldalProjektekFocusLost

    private void tfFooldalPNevFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfFooldalPNevFocusGained
        tblFooldalProjektek.setSelectionMode(0);
    }//GEN-LAST:event_tfFooldalPNevFocusGained

    private void tblFeladatokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFeladatokMouseClicked
        int kivalasztottSor = tblFeladatok.getSelectedRow();
        Feladat kivalasztottProjekt = (Feladat) tblFeladatok.getValueAt(kivalasztottSor, FeladatTablaModell.OBJECT_OSZLOP);
        if (kivalasztottSor >= 0) {
            lbFeladatokNev.setText(kivalasztottProjekt.getFeladatTargya() + ":");
            taFeladatokLeiras.setText(kivalasztottProjekt.getLeiras());
        }
    }//GEN-LAST:event_tblFeladatokMouseClicked

    private void tblFeladatokFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblFeladatokFocusLost
        tblFeladatok.setSelectionMode(0);
        lbFeladatokNev.setText(null);
        taFeladatokLeiras.setText(null);
    }//GEN-LAST:event_tblFeladatokFocusLost

    private void btFeladatokGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFeladatokGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();

        if (btFeladatokKeres.equals(kivalasztottGomb)) {
            tablaFrissit(tblFeladatok, vezerlo.getKeresFeladatTabla(tfFeladatokNev.getText()));
        } else if (btFeladatokMentPDF.equals(kivalasztottGomb)) {
            vezerlo.mentesPDF(tblFeladatok.getModel());
        } else if (btFeladatokFrissit.equals(kivalasztottGomb)) {
            tfFeladatokNev.setText(null);
            if (tbFeladatokAktivP.isSelected()) {
                tablaFrissit(tblFeladatok, vezerlo.getFeladatokTablaAktivF());
            } else {
                tablaFrissit(tblFeladatok, vezerlo.getFeladatokTablaOsszesF());
            }
        }
    }//GEN-LAST:event_btFeladatokGombokActionPerformed

    private void tblJelentesekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJelentesekMouseClicked
        int kivalasztottSor = tblJelentesek.getSelectedRow();
        if (kivalasztottSor >= 0) {
            taJelentesekLeiras.setText(vezerlo.getKivalasztottJelentes(kivalasztottSor).getSzoveg());
        }
    }//GEN-LAST:event_tblJelentesekMouseClicked

    private void btKeresesDatumTorolGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKeresesDatumTorolGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();

        if (btKeresesDatumtolTorol.equals(kivalasztottGomb)) {
            dcKeresesDatumtol.setDate(null);
        } else if (btKeresesDatumigTorol.equals(kivalasztottGomb)) {
            dcKeresesDatumig.setDate(null);
        }
    }//GEN-LAST:event_btKeresesDatumTorolGombokActionPerformed

    private void btProjektekMegrendDatumTorolGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProjektekMegrendDatumTorolGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();

        if (btProjektekMegrendDatumTorol.equals(kivalasztottGomb)) {
            dcProjektekMegrendDatum.setDate(null);
        } else if (btProjektekHataridoDatumTorol.equals(kivalasztottGomb)) {
            dcProjektekHataridoDatum.setDate(null);
        }
    }//GEN-LAST:event_btProjektekMegrendDatumTorolGombokActionPerformed

    private void btDolgozoKezdesDatumTorolbtKeresesDatumTorolGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDolgozoKezdesDatumTorolbtKeresesDatumTorolGombokActionPerformed
        dcDolgozoKezdesDatum.setDate(null);
    }//GEN-LAST:event_btDolgozoKezdesDatumTorolbtKeresesDatumTorolGombokActionPerformed

    private void btFeladatokHataridoDatumTorolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFeladatokHataridoDatumTorolActionPerformed
        dcFeladatokHataridoDatum.setDate(null);
    }//GEN-LAST:event_btFeladatokHataridoDatumTorolActionPerformed

    private void cbProjektCsapatokProjektNevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProjektCsapatokProjektNevActionPerformed
        listaFrissit(liProjektenDolgozoCsapatok, vezerlo.getKivalasztottProjektenDolgozoCsapatokLModell(((Projekt) cbProjektCsapatokProjektNev.getSelectedItem()).getAzon()));
        listaFrissit(liProjektCsapatCsapatok, vezerlo.getCsapatokLModell((Projekt) cbProjektCsapatokProjektNev.getSelectedItem()));
    }//GEN-LAST:event_cbProjektCsapatokProjektNevActionPerformed

    private void cbCsapatOsszeallitNevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCsapatOsszeallitNevActionPerformed
        listaFrissit(liCsapatOsszeallitCstagok, vezerlo.getKivalasztottCsapatTagjaiLModell((Csapat) cbCsapatOsszeallitNev.getSelectedItem()));
        listaFrissit(liCsapatOsszeallitDolgozok, vezerlo.getDolgozokLModell((Csapat) cbCsapatOsszeallitNev.getSelectedItem()));
    }//GEN-LAST:event_cbCsapatOsszeallitNevActionPerformed

    private void btProjektCsapatGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProjektCsapatGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();
        if (btProjektCsapatAddCsapat.equals(kivalasztottGomb)) {
            if (liProjektCsapatCsapatok.getSelectedIndex() > -1) {
                athelyezListaElem(liProjektCsapatCsapatok, liProjektenDolgozoCsapatok);
            } else {
                infoAblak("Válassz ki egy csapatot!", "Info");
            }
        } else if (btProjektCsapatKiveszCsapat.equals(kivalasztottGomb)) {
            if (liProjektenDolgozoCsapatok.getSelectedIndex() > -1) {
                athelyezListaElem(liProjektenDolgozoCsapatok, liProjektCsapatCsapatok);
            } else {
                infoAblak("Válassz ki egy projekten dolgozó csapatot!", "Info");
            }
        } else if (btProjektCsapatAddOsszes.equals(kivalasztottGomb)) {
            athelyezOsszesListaElem(liProjektCsapatCsapatok, liProjektenDolgozoCsapatok);
        } else if (btProjektCsapatKiveszOsszes.equals(kivalasztottGomb)) {
            athelyezOsszesListaElem(liProjektenDolgozoCsapatok, liProjektCsapatCsapatok);
        }
    }//GEN-LAST:event_btProjektCsapatGombokActionPerformed

    private void btProjektekKezelGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProjektekKezelGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();
        if (tblProjektek.getSelectedRow() > -1) {
            kivalasztottProjekt = (Projekt) tblProjektek.getValueAt(tblProjektek.getSelectedRow(), ProjektTablaModell.OBJECT_OSZLOP);
        }

        if (btProjektekHozzaad.equals(kivalasztottGomb)) {
            vezerlo.projektHozzaadd(tfProjektekNev.getText(), cbProjektekMegrend.getSelectedItem(), cbProjektekFTerulet.getSelectedIndex() + 1,
                    dcProjektekMegrendDatum.getDate(), dcProjektekHataridoDatum.getDate(), cbProjektekHolTart.getSelectedIndex() + 1,
                    cbProjektekPrioritas.getSelectedIndex() + 1, 
                    cbProjektekStatusz.getSelectedIndex() + 1, taProjektekLeiras.getText()
            );
        } else if (btProjektekModosit.equals(kivalasztottGomb)) {
            if (btProjektekModosit.getText().equals("Módosít")) {
                // projekt adatainak betöltése a mezőkbe
                tfProjektekNev.setText(kivalasztottProjekt.getNev());
                cbProjektekMegrend.setSelectedIndex(vezerlo.getKivalasztottMegrendeloIndex(kivalasztottProjekt.getMegrendelo()));
                cbProjektekFTerulet.setSelectedIndex(kivalasztottProjekt.getFejlesztesiTeruletID() - 1);
                dcProjektekMegrendDatum.setDate(Date.valueOf(kivalasztottProjekt.getMegrendelesDatum()));
                dcProjektekHataridoDatum.setDate(Date.valueOf(kivalasztottProjekt.getHataridoDatum()));
                cbProjektekHolTart.setSelectedIndex(kivalasztottProjekt.getHolTartID() - 1);
                cbProjektekPrioritas.setSelectedIndex(kivalasztottProjekt.getPrioritasID() - 1);
                cbProjektekStatusz.setSelectedIndex(kivalasztottProjekt.getStatuszID() - 1);
                taProjektekLeiras.setText(kivalasztottProjekt.getLeiras());
                btProjektekTorol.setEnabled(false);
                btProjektekModosit.setText("Mentés");
            } else {
                // projekt módosítások mentése
                vezerlo.projektModositasMentese(kivalasztottProjekt, tfProjektekNev.getText(), cbProjektekMegrend.getSelectedItem(),
                        cbProjektekFTerulet.getSelectedIndex() + 1, dcProjektekMegrendDatum.getDate(), dcProjektekHataridoDatum.getDate(),
                        cbProjektekHolTart.getSelectedIndex() + 1, cbProjektekPrioritas.getSelectedIndex() + 1, 
                        cbProjektekStatusz.getSelectedIndex() + 1, taProjektekLeiras.getText()
                );
                btProjektekModosit.setText("Módosít");
            }
        } else if (btProjektekTorol.equals(kivalasztottGomb)) {
            vezerlo.projektTorlese(kivalasztottProjekt);
        } else if (btProjektekAlap.equals(kivalasztottGomb)) {
            projektPanelAlaphelyzet();
        }
    }//GEN-LAST:event_btProjektekKezelGombokActionPerformed

    public void projektPanelAlaphelyzet() {
        tablaFrissit(tblProjektek, vezerlo.getFooldalAttekintoTablaOsszesP());
        dcProjektekMegrendDatum.setDate(null);
        dcProjektekHataridoDatum.setDate(null);
        tfProjektekNev.setText(null);
        taProjektekLeiras.setText(null);
        btProjektekHozzaad.setEnabled(true);
        btProjektekModosit.setEnabled(false);
        btProjektekTorol.setEnabled(false);
        comboBoxFrissit(cbProjektekMegrend, vezerlo.getMegrendelokCBModell());
        comboBoxFrissit(cbProjektekFTerulet, vezerlo.getFTeruletCBModell());
        comboBoxFrissit(cbProjektekHolTart, vezerlo.getHolTartCBModell());
        comboBoxFrissit(cbProjektekPrioritas, vezerlo.getPrioritasCBModell());
        comboBoxFrissit(cbProjektekStatusz, vezerlo.getStatuszCBModell());
    }

    private void tblProjektekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProjektekMouseClicked
        btProjektekHozzaad.setEnabled(false);
        btProjektekModosit.setEnabled(true);
        btProjektekTorol.setEnabled(true);
        btProjektekModosit.setText("Módosít");
    }//GEN-LAST:event_tblProjektekMouseClicked

    private void tblProjektMegrendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProjektMegrendMouseClicked
        btMegrendHozzaad.setEnabled(false);
        btMegrendModosit.setEnabled(true);
        btMegrendTorol.setEnabled(true);
        btMegrendModosit.setText("Módosít");
    }//GEN-LAST:event_tblProjektMegrendMouseClicked

    private void btMegrendGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMegrendGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();
        if (tblProjektMegrend.getSelectedRow() > -1) {
            kivalasztottMegrendelo = (Megrendelo) tblProjektMegrend.getValueAt(tblProjektMegrend.getSelectedRow(), MegrendeloTablaModell.OBJECT_OSZLOP);
        }

        if (btMegrendHozzaad.equals(kivalasztottGomb)) {
            vezerlo.megrendeloHozzaadd(tfMegrendNev.getText(), tfMegrendTelszam.getText(), tfMegrendEmail.getText(),
                    tfMegrendWeb.getText(), tfMegrendIranyitoszam.getText(), tfMegrendHely.getText(), tfMegrendUtcaHazszam.getText()
            );
        } else if (btMegrendModosit.equals(kivalasztottGomb)) {
            if (btMegrendModosit.getText().equals("Módosít")) {
                tfMegrendNev.setText(kivalasztottMegrendelo.getNev());
                tfMegrendTelszam.setText(kivalasztottMegrendelo.getTelSzam());
                tfMegrendEmail.setText(kivalasztottMegrendelo.getEmail());
                tfMegrendWeb.setText(kivalasztottMegrendelo.getWeboldal());
                tfMegrendIranyitoszam.setText(kivalasztottMegrendelo.getIranyitoszam());
                tfMegrendHely.setText(kivalasztottMegrendelo.getHelyseg());
                tfMegrendUtcaHazszam.setText(kivalasztottMegrendelo.getUtcaHazszam());
                btMegrendTorol.setEnabled(false);
                btMegrendModosit.setText("Mentés");
            } else {
                vezerlo.megrendeloModositasMentes(kivalasztottMegrendelo, tfMegrendNev.getText(), tfMegrendTelszam.getText(), tfMegrendEmail.getText(),
                        tfMegrendWeb.getText(), tfMegrendIranyitoszam.getText(), tfMegrendHely.getText(), tfMegrendUtcaHazszam.getText()
                );
                btMegrendModosit.setText("Módosít");
            }
        } else if (btMegrendTorol.equals(kivalasztottGomb)) {
            vezerlo.megrendeloTorlese(kivalasztottMegrendelo);
        } else if (btMegrendAlap.equals(kivalasztottGomb)) {
            megrendPanelAlaphelyzet();
        } else if (btMegrendMentPDF.equals(kivalasztottGomb)) {
            vezerlo.mentesPDF(tblProjektMegrend.getModel());
        }
    }//GEN-LAST:event_btMegrendGombokActionPerformed

    private void tblFeladatokKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFeladatokKMouseClicked
        btFeladatokKHozzaad.setEnabled(false);
        btFeladatokKModosit.setEnabled(true);
        btFeladatokKTorol.setEnabled(true);
        btFeladatokKModosit.setText("Módosít");
    }//GEN-LAST:event_tblFeladatokKMouseClicked

    private void btFeladatokKGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFeladatokKGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();
        if (tblFeladatokK.getSelectedRow() > -1) {
            kivalasztottFeladat = (Feladat) tblFeladatokK.getValueAt(tblFeladatokK.getSelectedRow(), FeladatTablaModell.OBJECT_OSZLOP);
        }

        if (btFeladatokKHozzaad.equals(kivalasztottGomb)) {
            vezerlo.feladatHozzaadd(tfFeladatokKTargy.getText(), dcFeladatokHataridoDatum.getDate(), cbFeladatokKFelelos.getSelectedItem(),
                    cbFeladatokKPNev.getSelectedItem(), cbFeladatokKStatusz.getSelectedIndex() + 1, taFeladatokKLeiras.getText()
            );
        } else if (btFeladatokKModosit.equals(kivalasztottGomb)) {
            if (btFeladatokKModosit.getText().equals("Módosít")) {
                tfFeladatokKTargy.setText(kivalasztottFeladat.getFeladatTargya());
                dcFeladatokHataridoDatum.setDate(Date.valueOf(kivalasztottFeladat.getHataridoDatum()));
                cbFeladatokKFelelos.setSelectedIndex(vezerlo.getKivalasztottDolgozoIndex(kivalasztottFeladat.getFelelos(), cbFeladatokKFelelos.getModel()));
                cbFeladatokKPNev.setSelectedIndex(vezerlo.getKivalasztottProjektIndex(kivalasztottFeladat.getProjekt(), cbFeladatokKPNev.getModel()));
                cbFeladatokKStatusz.setSelectedIndex(kivalasztottFeladat.getStatuszID() - 1);
                taFeladatokKLeiras.setText(kivalasztottFeladat.getLeiras());
                btFeladatokKTorol.setEnabled(false);
                btFeladatokKModosit.setText("Mentés");
            } else {
                vezerlo.feladatModositasMentes(kivalasztottFeladat, tfFeladatokKTargy.getText(), dcFeladatokHataridoDatum.getDate(), cbFeladatokKFelelos.getSelectedItem(),
                        cbFeladatokKPNev.getSelectedItem(), cbFeladatokKStatusz.getSelectedIndex() + 1, taFeladatokKLeiras.getText()
                );
                btFeladatokKModosit.setText("Módosít");
            }
        } else if (btFeladatokKTorol.equals(kivalasztottGomb)) {
            vezerlo.feladatTorlese(kivalasztottFeladat);
        } else if (btFeladatokKAlap.equals(kivalasztottGomb)) {
            feladatPanelAlaphelyzet();
        }
    }//GEN-LAST:event_btFeladatokKGombokActionPerformed

    private void btJelentesekKGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJelentesekKGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();
        if (tblJelentesekK.getSelectedRow() > -1) {
            kivalasztottJelentes = (Jelentes) tblJelentesekK.getValueAt(tblJelentesekK.getSelectedRow(), JelentesTablaModell.OBJECT_OSZLOP);
        }

        if (btJelentesekKHozzaad.equals(kivalasztottGomb)) {
            vezerlo.jelentesHozzaadd(cbJelentesekKPNev.getSelectedItem(), taJelentesekKLeiras.getText());
        } else if (btJelentesekKModosit.equals(kivalasztottGomb)) {
            if (btJelentesekKModosit.getText().equals("Módosít")) {
                cbJelentesekKPNev.setSelectedIndex(vezerlo.getKivalasztottProjektIndex(kivalasztottJelentes.getProjekt(), cbJelentesekKPNev.getModel()));
                taJelentesekKLeiras.setText(kivalasztottJelentes.getSzoveg());
                btJelentesekKTorol.setEnabled(false);
                btJelentesekKModosit.setText("Mentés");
            } else {
                vezerlo.jelentesModositasMentes(kivalasztottJelentes, cbJelentesekKPNev.getSelectedItem(), taJelentesekKLeiras.getText());
                btJelentesekKModosit.setText("Módosít");
            }
        } else if (btJelentesekKTorol.equals(kivalasztottGomb)) {
            vezerlo.jelentesTorlese(kivalasztottJelentes);
        } else if (btJelentesekKAlap.equals(kivalasztottGomb)) {
            jelentesPanelAlaphelyzet();
        }
    }//GEN-LAST:event_btJelentesekKGombokActionPerformed

    private void tblJelentesekKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJelentesekKMouseClicked
        btJelentesekKHozzaad.setEnabled(false);
        btJelentesekKModosit.setEnabled(true);
        btJelentesekKTorol.setEnabled(true);
        btJelentesekKModosit.setText("Módosít");
    }//GEN-LAST:event_tblJelentesekKMouseClicked

    private void btDolgozokGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDolgozokGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();
        if (tblDolgozok.getSelectedRow() > -1) {
            kivalasztottDolgozo = (Dolgozo) tblDolgozok.getValueAt(tblDolgozok.getSelectedRow(), DolgozoTablaModell.OBJECT_OSZLOP);
        }

        if (btDolgozokHozzaad.equals(kivalasztottGomb)) {
            vezerlo.dolgozoHozzaadd(tfDolgozokNev.getText(), cbDolgozokBeosztas.getSelectedIndex() + 1, cbDolgozokFTerulet.getSelectedIndex() + 1,
                    cbDolgozoSkill.getSelectedIndex() + 1, dcDolgozoKezdesDatum.getDate(), tfDolgozokTelSzam.getText()
            );
        } else if (btDolgozokModosit.equals(kivalasztottGomb)) {
            if (btDolgozokModosit.getText().equals("Módosít")) {
                tfDolgozokNev.setText(kivalasztottDolgozo.getNev());
                cbDolgozokBeosztas.setSelectedIndex(kivalasztottDolgozo.getBeosztasID() - 1);
                cbDolgozokFTerulet.setSelectedIndex(kivalasztottDolgozo.getfTeruletID() - 1);
                cbDolgozoSkill.setSelectedIndex(kivalasztottDolgozo.getSkillID() - 1);
                dcDolgozoKezdesDatum.setDate(Date.valueOf(kivalasztottDolgozo.getKezdesDatum()));
                tfDolgozokTelSzam.setText(kivalasztottDolgozo.getTelSzam());
                btDolgozokTorol.setEnabled(false);
                btDolgozokModosit.setText("Mentés");
            } else {
                vezerlo.dolgozoModositasMentes(kivalasztottDolgozo, tfDolgozokNev.getText(), cbDolgozokBeosztas.getSelectedIndex() + 1, cbDolgozokFTerulet.getSelectedIndex() + 1,
                        cbDolgozoSkill.getSelectedIndex() + 1, dcDolgozoKezdesDatum.getDate(), tfDolgozokTelSzam.getText()
                );
                btDolgozokModosit.setText("Módosít");
            }
        } else if (btDolgozokTorol.equals(kivalasztottGomb)) {
            vezerlo.dolgozoTorlese(kivalasztottDolgozo);
        } else if (btDolgozokAlap.equals(kivalasztottGomb)) {
            dolgozoPanelAlaphelyzet();
        }
    }//GEN-LAST:event_btDolgozokGombokActionPerformed

    private void tblDolgozokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDolgozokMouseClicked
        btDolgozokHozzaad.setEnabled(false);
        btDolgozokModosit.setEnabled(true);
        btDolgozokTorol.setEnabled(true);
        btDolgozokModosit.setText("Módosít");
    }//GEN-LAST:event_tblDolgozokMouseClicked

    private void btCsapatokKGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCsapatokKGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();
        if (tblCsapatokK.getSelectedRow() > -1) {
            kivalasztottCsapat = (Csapat) tblCsapatokK.getValueAt(tblCsapatokK.getSelectedRow(), CsapatTablaModell.OBJECT_OSZLOP);
        }

        if (btCsapatokKHozzaad.equals(kivalasztottGomb)) {
            vezerlo.csapatHozzaadd(tfCsapatokKNev.getText(), cbCsapatokKCsVez.getSelectedItem());
        } else if (btCsapatokKModosit.equals(kivalasztottGomb)) {
            if (btCsapatokKModosit.getText().equals("Módosít")) {
                tfCsapatokKNev.setText(kivalasztottCsapat.getNev());
                cbCsapatokKCsVez.setSelectedIndex(vezerlo.getKivalasztottDolgozoIndex(kivalasztottCsapat.getCsapatvezeto(), cbCsapatokKCsVez.getModel()));
                btCsapatokKTorol.setEnabled(false);
                btCsapatokKModosit.setText("Mentés");
            } else {
                vezerlo.csapatModositasMentes(kivalasztottCsapat, tfCsapatokKNev.getText(), cbCsapatokKCsVez.getSelectedItem());
                btCsapatokKModosit.setText("Módosít");
            }
        } else if (btCsapatokKTorol.equals(kivalasztottGomb)) {
            vezerlo.csapatTorlese(kivalasztottCsapat);
        } else if (btCsapatokKAlap.equals(kivalasztottGomb)) {
            csapatKPanelAlaphelyzet();
        }
    }//GEN-LAST:event_btCsapatokKGombokActionPerformed

    private void tblCsapatokKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCsapatokKMouseClicked
        btCsapatokKHozzaad.setEnabled(false);
        btCsapatokKModosit.setEnabled(true);
        btCsapatokKTorol.setEnabled(true);
        btCsapatokKModosit.setText("Módosít");
    }//GEN-LAST:event_tblCsapatokKMouseClicked

    private void btCsapatOsszeallitGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCsapatOsszeallitGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();
        if (btCsapatOsszeallitAddDolgozo.equals(kivalasztottGomb)) {
            if (liCsapatOsszeallitDolgozok.getSelectedIndex() > -1) {
                athelyezListaElem(liCsapatOsszeallitDolgozok, liCsapatOsszeallitCstagok);
            } else {
                infoAblak("Válassz ki egy dolgozót!", "Info");
            }
        } else if (btCsapatOsszeallitKiveszDolgozo.equals(kivalasztottGomb)) {
            if (liCsapatOsszeallitCstagok.getSelectedIndex() > -1) {
                athelyezListaElem(liCsapatOsszeallitCstagok, liCsapatOsszeallitDolgozok);
            } else {
                infoAblak("Válassz ki egy csapattagot!", "Info");
            }
        } else if (btCsapatOsszeallitOsszesAdd.equals(kivalasztottGomb)) {
            athelyezOsszesListaElem(liCsapatOsszeallitDolgozok, liCsapatOsszeallitCstagok);
        } else if (btCsapatOsszeallitOsszesKivesz.equals(kivalasztottGomb)) {
            athelyezOsszesListaElem(liCsapatOsszeallitCstagok, liCsapatOsszeallitDolgozok);
        }
    }//GEN-LAST:event_btCsapatOsszeallitGombokActionPerformed

    private void btProjektCsapatMentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProjektCsapatMentActionPerformed
        vezerlo.projektenDolgozoCsapatokMent(cbProjektCsapatokProjektNev.getSelectedItem(), liProjektenDolgozoCsapatok.getModel());
    }//GEN-LAST:event_btProjektCsapatMentActionPerformed

    private void btCsapatOsszeallitMentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCsapatOsszeallitMentActionPerformed
        vezerlo.csapattagokMent(cbCsapatOsszeallitNev.getSelectedItem(), liCsapatOsszeallitCstagok.getModel());
    }//GEN-LAST:event_btCsapatOsszeallitMentActionPerformed

    private void athelyezListaElem(JList<String> honnanLista, JList<String> hovaLista) {
        DefaultListModel dlmHonnan;
        DefaultListModel dlmHova;

        int kivalasztottCsapatIndex = honnanLista.getSelectedIndex();
        dlmHonnan = (DefaultListModel) honnanLista.getModel();
        dlmHova = (DefaultListModel) hovaLista.getModel();

        dlmHova.addElement(dlmHonnan.getElementAt(kivalasztottCsapatIndex));
        hovaLista.setModel(dlmHova);

        dlmHonnan.removeElementAt(kivalasztottCsapatIndex);
        honnanLista.setModel(dlmHonnan);
    }

    private void athelyezOsszesListaElem(JList<String> honnanLista, JList<String> hovaLista) {
        DefaultListModel dlmHonnan;
        DefaultListModel dlmHova;

        dlmHonnan = (DefaultListModel) honnanLista.getModel();
        dlmHova = (DefaultListModel) hovaLista.getModel();

        for (int i = 0; i < dlmHonnan.size(); i++) {
            dlmHova.addElement(dlmHonnan.getElementAt(i));
        }
        hovaLista.setModel(dlmHova);

        dlmHonnan.removeAllElements();
        honnanLista.setModel(dlmHonnan);
    }

    public void csapatKPanelAlaphelyzet() {
        tablaFrissit(tblCsapatokK, vezerlo.getCsapatokTabla());
        btCsapatokKHozzaad.setEnabled(true);
        btCsapatokKModosit.setEnabled(false);
        btCsapatokKTorol.setEnabled(false);
        tfCsapatokKNev.setText(null);
        comboBoxFrissit(cbCsapatokKCsVez, vezerlo.getCsapatvezetoCBModell());
    }

    public void dolgozoPanelAlaphelyzet() {
        btDolgozokHozzaad.setEnabled(true);
        btDolgozokModosit.setEnabled(false);
        btDolgozokTorol.setEnabled(false);
        tfDolgozokNev.setText(null);
        tfDolgozokTelSzam.setText(null);
        dcDolgozoKezdesDatum.setDate(null);
        tablaFrissit(tblDolgozok, vezerlo.getDolgozokTabla());
        comboBoxFrissit(cbDolgozokBeosztas, vezerlo.getBeosztasCBModell());
        comboBoxFrissit(cbDolgozokFTerulet, vezerlo.getFTeruletCBModell());
        comboBoxFrissit(cbDolgozoSkill, vezerlo.getSkillCBModell());
//        comboBoxFrissit(cbDolgozokCsapat, vezerlo.getCsapatCBModell());
    }

    public void jelentesPanelAlaphelyzet() {
        btJelentesekKHozzaad.setEnabled(true);
        btJelentesekKModosit.setEnabled(false);
        btJelentesekKTorol.setEnabled(false);
        taJelentesekKLeiras.setText(null);
        tablaFrissit(tblJelentesekK, vezerlo.getJelentesekTabla());
        comboBoxFrissit(cbJelentesekKPNev, vezerlo.getProjektCBModell());
    }

    public void feladatPanelAlaphelyzet() {
        tfFeladatokKTargy.setText(null);
        dcFeladatokHataridoDatum.setDate(null);
        btFeladatokKHozzaad.setEnabled(true);
        btFeladatokKModosit.setEnabled(false);
        btFeladatokKTorol.setEnabled(false);
        taFeladatokKLeiras.setText(null);
        tablaFrissit(tblFeladatokK, vezerlo.getFeladatokTablaOsszesF());
        comboBoxFrissit(cbFeladatokKFelelos, vezerlo.getCsapatvezetoCBModell());
        comboBoxFrissit(cbFeladatokKPNev, vezerlo.getProjektCBModell());
        comboBoxFrissit(cbFeladatokKStatusz, vezerlo.getStatuszCBModell());
    }

    public void megrendPanelAlaphelyzet() {
        tablaFrissit(tblProjektMegrend, vezerlo.getProjektMegrendelokTabla());
        btMegrendHozzaad.setEnabled(true);
        btMegrendModosit.setEnabled(false);
        btMegrendTorol.setEnabled(false);
        tfMegrendNev.setText(null);
        tfMegrendTelszam.setText(null);
        tfMegrendEmail.setText(null);
        tfMegrendWeb.setText(null);
        tfMegrendHely.setText(null);
        tfMegrendIranyitoszam.setText(null);
        tfMegrendUtcaHazszam.setText(null);
    }

    public JPanel getPnFooldal() {
        return pnFooldal;
    }

    public JPanel getPnProjektek() {
        return pnProjektekKezel;
    }

    public JPanel getPnJelentesek() {
        return pnJelentesek;
    }

    public JPanel getPnJelszovaltoztatas() {
        return pnJelszovaltoztatas;
    }

    public JLabel getLbJelszoHibaUzenet() {
        return lbJelszoHibaUzenet;
    }

    public JPasswordField getPfJelenJelszo() {
        return pfJelszoValtJelenlegi;
    }

    public JToggleButton getTbFooldalAktivP() {
        return tbFooldalAktivP;
    }

    public JToggleButton getTbFeladatokAktivP() {
        return tbFeladatokAktivP;
    }

    public JTable getTblFooldalProjektek() {
        return tblFooldalProjektek;
    }

    public JToggleButton getTbtFeladatok() {
        return tbtFeladatok;
    }

    public JComboBox<String> getCbProjektekMegrend() {
        return cbProjektekMegrend;
    }

    public JComboBox<String> getCbFeladatokKFelelos() {
        return cbFeladatokKFelelos;
    }

    public JComboBox<String> getCbFeladatokKPNev() {
        return cbFeladatokKPNev;
    }

    public JComboBox<String> getCbJelentesekKPNev() {
        return cbJelentesekKPNev;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgDolgozok;
    private javax.swing.ButtonGroup bgFeladatok;
    private javax.swing.ButtonGroup bgFomenu;
    private javax.swing.ButtonGroup bgFomenuAlmenu;
    private javax.swing.ButtonGroup bgJelentesek;
    private javax.swing.ButtonGroup bgProjektek;
    private javax.swing.JButton btCsapatOsszeallitAddDolgozo;
    private javax.swing.JButton btCsapatOsszeallitKiveszDolgozo;
    private javax.swing.JButton btCsapatOsszeallitMent;
    private javax.swing.JButton btCsapatOsszeallitOsszesAdd;
    private javax.swing.JButton btCsapatOsszeallitOsszesKivesz;
    private javax.swing.JButton btCsapatokKAlap;
    private javax.swing.JButton btCsapatokKHozzaad;
    private javax.swing.JButton btCsapatokKModosit;
    private javax.swing.JButton btCsapatokKTorol;
    private javax.swing.JButton btDolgozoKezdesDatumTorol;
    private javax.swing.JButton btDolgozokAlap;
    private javax.swing.JButton btDolgozokHozzaad;
    private javax.swing.JButton btDolgozokModosit;
    private javax.swing.JButton btDolgozokTorol;
    private javax.swing.JButton btFeladatokFrissit;
    private javax.swing.JButton btFeladatokHataridoDatumTorol;
    private javax.swing.JButton btFeladatokKAlap;
    private javax.swing.JButton btFeladatokKHozzaad;
    private javax.swing.JButton btFeladatokKModosit;
    private javax.swing.JButton btFeladatokKTorol;
    private javax.swing.JButton btFeladatokKeres;
    private javax.swing.JButton btFeladatokMentPDF;
    private javax.swing.JButton btFooldalFrissit;
    private javax.swing.JButton btFooldalInfo;
    private javax.swing.JButton btFooldalKeres;
    private javax.swing.JButton btFooldalMentPDF;
    private javax.swing.JButton btJelentesekKAlap;
    private javax.swing.JButton btJelentesekKHozzaad;
    private javax.swing.JButton btJelentesekKModosit;
    private javax.swing.JButton btJelentesekKTorol;
    private javax.swing.JButton btJelentesekMentPDF;
    private javax.swing.JButton btJelentesekTeljesMeret;
    private javax.swing.JButton btJelszoValtMent;
    private javax.swing.JButton btJelszovalt;
    private javax.swing.JButton btKeresesDatumigTorol;
    private javax.swing.JButton btKeresesDatumtolTorol;
    private javax.swing.JButton btKeresesKeres;
    private javax.swing.JButton btKeresesMentPDF;
    private javax.swing.JButton btKijelentkezes;
    private javax.swing.JButton btMegrendAlap;
    private javax.swing.JButton btMegrendHozzaad;
    private javax.swing.JButton btMegrendMentPDF;
    private javax.swing.JButton btMegrendModosit;
    private javax.swing.JButton btMegrendTorol;
    private javax.swing.JButton btProjektCsapatAddCsapat;
    private javax.swing.JButton btProjektCsapatAddOsszes;
    private javax.swing.JButton btProjektCsapatKiveszCsapat;
    private javax.swing.JButton btProjektCsapatKiveszOsszes;
    private javax.swing.JButton btProjektCsapatMent;
    private javax.swing.JButton btProjektekAlap;
    private javax.swing.JButton btProjektekHataridoDatumTorol;
    private javax.swing.JButton btProjektekHozzaad;
    private javax.swing.JButton btProjektekMegrendDatumTorol;
    private javax.swing.JButton btProjektekModosit;
    private javax.swing.JButton btProjektekTorol;
    private javax.swing.JButton btVissza;
    private javax.swing.JComboBox<String> cbCsapatOsszeallitNev;
    private javax.swing.JComboBox<String> cbCsapatokKCsVez;
    private javax.swing.JComboBox<String> cbDolgozoSkill;
    private javax.swing.JComboBox<String> cbDolgozokBeosztas;
    private javax.swing.JComboBox<String> cbDolgozokFTerulet;
    private javax.swing.JComboBox<String> cbFeladatokKFelelos;
    private javax.swing.JComboBox<String> cbFeladatokKPNev;
    private javax.swing.JComboBox<String> cbFeladatokKStatusz;
    private javax.swing.JComboBox<String> cbJelentesekKPNev;
    private javax.swing.JComboBox<String> cbKeresesFTerulet;
    private javax.swing.JComboBox<String> cbKeresesHolTart;
    private javax.swing.JComboBox<String> cbKeresesMegrend;
    private javax.swing.JComboBox<String> cbKeresesPVezeto;
    private javax.swing.JComboBox<String> cbKeresesPrioritas;
    private javax.swing.JComboBox<String> cbKeresesStatusz;
    private javax.swing.JComboBox<String> cbProjektCsapatokProjektNev;
    private javax.swing.JComboBox<String> cbProjektekFTerulet;
    private javax.swing.JComboBox<String> cbProjektekHolTart;
    private javax.swing.JComboBox<String> cbProjektekMegrend;
    private javax.swing.JComboBox<String> cbProjektekPrioritas;
    private javax.swing.JComboBox<String> cbProjektekStatusz;
    private com.toedter.calendar.JDateChooser dcDolgozoKezdesDatum;
    private com.toedter.calendar.JDateChooser dcFeladatokHataridoDatum;
    private com.toedter.calendar.JDateChooser dcKeresesDatumig;
    private com.toedter.calendar.JDateChooser dcKeresesDatumtol;
    private com.toedter.calendar.JDateChooser dcProjektekHataridoDatum;
    private com.toedter.calendar.JDateChooser dcProjektekMegrendDatum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lbBelepveNev;
    private javax.swing.JLabel lbFeladatokNev;
    private javax.swing.JLabel lbFooldalPNev;
    private javax.swing.JLabel lbJelszoHibaUzenet;
    private javax.swing.JList<String> liCsapatOsszeallitCstagok;
    private javax.swing.JList<String> liCsapatOsszeallitDolgozok;
    private javax.swing.JList<String> liProjektCsapatCsapatok;
    private javax.swing.JList<String> liProjektenDolgozoCsapatok;
    private javax.swing.JLayeredPane lpAlmenu;
    private javax.swing.JLayeredPane lpTartalom;
    private javax.swing.JPasswordField pfJelszoValtJelenlegi;
    private javax.swing.JPasswordField pfJelszoValtMegerosit;
    private javax.swing.JPasswordField pfJelszoValtUj;
    private javax.swing.JPanel pnDolgozokAlmenu;
    private javax.swing.JPanel pnDolgozokCsapatok;
    private javax.swing.JPanel pnDolgozokCsapatokKezel;
    private javax.swing.JPanel pnDolgozokKezel;
    private javax.swing.JPanel pnFeladatok;
    private javax.swing.JPanel pnFeladatokAlmenu;
    private javax.swing.JPanel pnFeladatokKezel;
    private javax.swing.JPanel pnFomenu;
    private javax.swing.JPanel pnFooldal;
    private javax.swing.JPanel pnFooldalAlmenu;
    private javax.swing.JPanel pnFooldalKereses;
    private javax.swing.JPanel pnJelentesek;
    private javax.swing.JPanel pnJelentesekAlmenu;
    private javax.swing.JPanel pnJelentesekKezel;
    private javax.swing.JPanel pnJelszovaltoztatas;
    private javax.swing.JPanel pnProjektCsapatok;
    private javax.swing.JPanel pnProjektekAlmenu;
    private javax.swing.JPanel pnProjektekKezel;
    private javax.swing.JPanel pnProjektekMegrendelo;
    private javax.swing.JPanel pnVisszaAlmenu;
    private javax.swing.JTextArea taFeladatokKLeiras;
    private javax.swing.JTextArea taFeladatokLeiras;
    private javax.swing.JTextArea taFooldalPLeiras;
    private javax.swing.JTextArea taJelentesekKLeiras;
    private javax.swing.JTextArea taJelentesekLeiras;
    private javax.swing.JTextArea taProjektekLeiras;
    private javax.swing.JToggleButton tbAttekinto;
    private javax.swing.JToggleButton tbDolgozokCsapatok;
    private javax.swing.JToggleButton tbDolgozokCsapatokKezell;
    private javax.swing.JToggleButton tbDolgozokKezel;
    private javax.swing.JToggleButton tbFeladatok;
    private javax.swing.JToggleButton tbFeladatokAktivP;
    private javax.swing.JToggleButton tbFeladatokKezel;
    private javax.swing.JToggleButton tbFooldalAktivP;
    private javax.swing.JToggleButton tbJelentesek;
    private javax.swing.JToggleButton tbJelentesekKezel;
    private javax.swing.JToggleButton tbKereses;
    private javax.swing.JToggleButton tbProjektCsapatok;
    private javax.swing.JToggleButton tbProjektKezel;
    private javax.swing.JToggleButton tbProjektMegrendelo;
    private javax.swing.JTable tblCsapatokK;
    private javax.swing.JTable tblDolgozok;
    private javax.swing.JTable tblFeladatok;
    private javax.swing.JTable tblFeladatokK;
    private javax.swing.JTable tblFooldalKereses;
    private javax.swing.JTable tblFooldalProjektek;
    private javax.swing.JTable tblJelentesek;
    private javax.swing.JTable tblJelentesekK;
    private javax.swing.JTable tblProjektMegrend;
    private javax.swing.JTable tblProjektek;
    private javax.swing.JToggleButton tbtDolgozok;
    private javax.swing.JToggleButton tbtFeladatok;
    private javax.swing.JToggleButton tbtFooldal;
    private javax.swing.JToggleButton tbtJelentesek;
    private javax.swing.JToggleButton tbtProjektek;
    private javax.swing.JTextField tfCsapatokKNev;
    private javax.swing.JTextField tfDolgozokNev;
    private javax.swing.JTextField tfDolgozokTelSzam;
    private javax.swing.JTextField tfFeladatokKTargy;
    private javax.swing.JTextField tfFeladatokNev;
    private javax.swing.JTextField tfFooldalPNev;
    private javax.swing.JTextField tfMegrendEmail;
    private javax.swing.JTextField tfMegrendHely;
    private javax.swing.JTextField tfMegrendIranyitoszam;
    private javax.swing.JTextField tfMegrendNev;
    private javax.swing.JTextField tfMegrendTelszam;
    private javax.swing.JTextField tfMegrendUtcaHazszam;
    private javax.swing.JTextField tfMegrendWeb;
    private javax.swing.JTextField tfProjektekNev;
    // End of variables declaration//GEN-END:variables
}
