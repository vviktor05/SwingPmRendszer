package projektmenedzsmentrendszer.nezet;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.LayoutManager;
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

public class FejlesztoFoablak extends javax.swing.JFrame implements FoAblak{
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

    public FejlesztoFoablak(Vezerlo vezerlo) {
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
        bgFeladatok = new javax.swing.ButtonGroup();
        bgJelentesek = new javax.swing.ButtonGroup();
        jScrollBar1 = new javax.swing.JScrollBar();
        pnFomenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbBelepveNev = new javax.swing.JLabel();
        tbtFooldal = new javax.swing.JToggleButton();
        tbtJelentesek = new javax.swing.JToggleButton();
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
        dcKeresesDatumtol = new com.toedter.calendar.JDateChooser();
        dcKeresesDatumig = new com.toedter.calendar.JDateChooser();
        btKeresesDatumtolTorol = new javax.swing.JButton();
        btKeresesDatumigTorol = new javax.swing.JButton();
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
        pnJelentesek = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        btJelentesekTeljesMeret = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        taJelentesekLeiras = new javax.swing.JTextArea();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblJelentesek = new javax.swing.JTable();
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
        pnFeladatokAlmenu = new javax.swing.JPanel();
        tbFeladatok = new javax.swing.JToggleButton();
        pnJelentesekAlmenu = new javax.swing.JPanel();
        tbJelentesek = new javax.swing.JToggleButton();
        pnVisszaAlmenu = new javax.swing.JPanel();
        btVissza = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projektmenedzsment szoftver - Fejlesztő");
        setPreferredSize(new java.awt.Dimension(1200, 720));
        setSize(new java.awt.Dimension(1200, 720));

        pnFomenu.setBackground(new java.awt.Color(204, 204, 204));
        pnFomenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnFomenu.setPreferredSize(new java.awt.Dimension(298, 0));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Belépve:");

        lbBelepveNev.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        tbtFooldal.setBackground(new java.awt.Color(235, 235, 235));
        bgFomenu.add(tbtFooldal);
        tbtFooldal.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbtFooldal.setSelected(true);
        tbtFooldal.setText("Főoldal");
        tbtFooldal.setBorder(null);
        tbtFooldal.setFocusPainted(false);
        tbtFooldal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtFomenuActionPerformed(evt);
            }
        });

        tbtJelentesek.setBackground(new java.awt.Color(235, 235, 235));
        bgFomenu.add(tbtJelentesek);
        tbtJelentesek.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbtJelentesek.setText("Jelentések");
        tbtJelentesek.setBorder(null);
        tbtJelentesek.setFocusPainted(false);
        tbtJelentesek.addActionListener(new java.awt.event.ActionListener() {
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
            .addComponent(tbtJelentesek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFomenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFomenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lbBelepveNev, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(btJelszovalt, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
            .addComponent(btKijelentkezes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(tbtJelentesek, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 654, Short.MAX_VALUE)
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
        lbFooldalPNev.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
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

        javax.swing.GroupLayout pnFooldalLayout = new javax.swing.GroupLayout(pnFooldal);
        pnFooldal.setLayout(pnFooldalLayout);
        pnFooldalLayout.setHorizontalGroup(
            pnFooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFooldalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1332, Short.MAX_VALUE)
                    .addGroup(pnFooldalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFooldalPNev, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btFooldalKeres))
                    .addGroup(pnFooldalLayout.createSequentialGroup()
                        .addComponent(btFooldalInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnFooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnFooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btFooldalFrissit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btFooldalInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        cbKeresesFTerulet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKeresesFTeruletActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel11.setText("Megrendelő:");

        cbKeresesMegrend.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        cbKeresesHolTart.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbKeresesHolTart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKeresesHolTartActionPerformed(evt);
            }
        });

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

        dcKeresesDatumtol.setFocusable(false);

        dcKeresesDatumig.setFocusable(false);

        btKeresesDatumtolTorol.setPreferredSize(new java.awt.Dimension(53, 23));
        btKeresesDatumtolTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKeresesDatumTorolGombokActionPerformed(evt);
            }
        });

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
                .addGap(0, 349, Short.MAX_VALUE)
                .addGroup(pnFooldalKeresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(btKeresesKeres, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnFooldalKeresesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btKeresesDatumigTorol, btKeresesDatumtolTorol, cbKeresesFTerulet, cbKeresesHolTart, cbKeresesMegrend, cbKeresesPVezeto, cbKeresesPrioritas, cbKeresesStatusz, dcKeresesDatumig, dcKeresesDatumtol});

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
        lbFeladatokNev.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
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
                        .addGap(0, 999, Short.MAX_VALUE)
                        .addGroup(pnFeladatokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnFeladatokLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfFeladatokNev, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btFeladatokKeres))
                            .addGroup(pnFeladatokLayout.createSequentialGroup()
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
                    .addComponent(tbFeladatokAktivP))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnFeladatokLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btFeladatokFrissit, tbFeladatokAktivP});

        pnJelentesek.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnJelentesek.setOpaque(false);

        jLabel58.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
                            .addComponent(btJelentesekTeljesMeret, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 406, Short.MAX_VALUE)))
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
                .addComponent(btJelentesekTeljesMeret, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

        pnJelszovaltoztatas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnJelszovaltoztatas.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel3.setText("Jelszó változtatás");

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
        lpTartalom.setLayer(pnFeladatok, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpTartalom.setLayer(pnJelentesek, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpTartalom.setLayer(pnJelentesekKezel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpTartalom.setLayer(pnJelszovaltoztatas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lpTartalomLayout = new javax.swing.GroupLayout(lpTartalom);
        lpTartalom.setLayout(lpTartalomLayout);
        lpTartalomLayout.setHorizontalGroup(
            lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnFooldal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnJelszovaltoztatas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnJelentesek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnFooldalKereses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnFeladatok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnJelentesekKezel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lpTartalomLayout.setVerticalGroup(
            lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnFooldal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnJelszovaltoztatas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnJelentesek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnFooldalKereses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnFeladatok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpTartalomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnJelentesekKezel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnFooldalKereses.setVisible(false);
        pnFeladatok.setVisible(false);
        pnJelentesek.setVisible(false);
        pnJelentesekKezel.setVisible(false);
        pnJelszovaltoztatas.setVisible(false);

        pnFooldalAlmenu.setBackground(new java.awt.Color(204, 204, 204));

        tbAttekinto.setBackground(new java.awt.Color(235, 235, 235));
        bgFomenuAlmenu.add(tbAttekinto);
        tbAttekinto.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbAttekinto.setSelected(true);
        tbAttekinto.setText("Áttekintő");
        tbAttekinto.setBorder(null);
        tbAttekinto.setFocusPainted(false);
        tbAttekinto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFooldalAlmenuActionPerformed(evt);
            }
        });

        tbKereses.setBackground(new java.awt.Color(235, 235, 235));
        bgFomenuAlmenu.add(tbKereses);
        tbKereses.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbKereses.setText("Részletes keresés");
        tbKereses.setBorder(null);
        tbKereses.setFocusPainted(false);
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

        pnFeladatokAlmenu.setBackground(new java.awt.Color(204, 204, 204));

        tbFeladatok.setBackground(new java.awt.Color(235, 235, 235));
        bgFeladatok.add(tbFeladatok);
        tbFeladatok.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbFeladatok.setSelected(true);
        tbFeladatok.setText("Feladatok");
        tbFeladatok.setBorder(null);
        tbFeladatok.setFocusPainted(false);
        tbFeladatok.addActionListener(new java.awt.event.ActionListener() {
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
                .addContainerGap(1289, Short.MAX_VALUE))
        );
        pnFeladatokAlmenuLayout.setVerticalGroup(
            pnFeladatokAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbFeladatok, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnJelentesekAlmenu.setBackground(new java.awt.Color(204, 204, 204));

        tbJelentesek.setBackground(new java.awt.Color(235, 235, 235));
        bgJelentesek.add(tbJelentesek);
        tbJelentesek.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbJelentesek.setSelected(true);
        tbJelentesek.setText("Jelentések");
        tbJelentesek.setBorder(null);
        tbJelentesek.setFocusPainted(false);
        tbJelentesek.addActionListener(new java.awt.event.ActionListener() {
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
                .addContainerGap(1285, Short.MAX_VALUE))
        );
        pnJelentesekAlmenuLayout.setVerticalGroup(
            pnJelentesekAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbJelentesek, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        lpAlmenu.setLayer(pnFeladatokAlmenu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpAlmenu.setLayer(pnJelentesekAlmenu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpAlmenu.setLayer(pnVisszaAlmenu, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lpAlmenuLayout = new javax.swing.GroupLayout(lpAlmenu);
        lpAlmenu.setLayout(lpAlmenuLayout);
        lpAlmenuLayout.setHorizontalGroup(
            lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
            .addGroup(lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnFooldalAlmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnVisszaAlmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnFeladatokAlmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnJelentesekAlmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lpAlmenuLayout.setVerticalGroup(
            lpAlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
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
        );

        pnFeladatokAlmenu.setVisible(false);
        pnJelentesekAlmenu.setVisible(false);
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
        } else if (!jelenlegiOldal.equals(pnJelentesek) && tbtJelentesek.equals(kivalasztottMenuGomb)) {
            tablaFrissit(tblJelentesek, vezerlo.getJelentesekTabla());
            panelValt(pnJelentesek, pnJelentesekAlmenu);
            tbJelentesek.setSelected(true);
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

        if (btJelentesekTeljesMeret.equals(kivalasztottGomb)) {
            if (tblJelentesek.getSelectedRow() > -1) {
                vezerlo.jelentesTeljesNezet(tblJelentesek.getValueAt(tblJelentesek.getSelectedRow(), JelentesTablaModell.OBJECT_OSZLOP));
            } else {
                infoAblak("Válassz ki egy jelentést!", "Info");
            }
        }
    }//GEN-LAST:event_btJelentesekGombokActionPerformed

    private void tbFeladatokAlmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFeladatokAlmenuActionPerformed
        kivalasztottMenuGomb = (JToggleButton) evt.getSource();

        if (!jelenlegiOldal.equals(pnFeladatok) && tbFeladatok.equals(kivalasztottMenuGomb)) {
            tbFeladatokAktivP.setSelected(true);
            tablaFrissit(tblFeladatok, vezerlo.getFeladatokTablaAktivF());
            panelValt(pnFeladatok, pnFeladatokAlmenu);
        }
    }//GEN-LAST:event_tbFeladatokAlmenuActionPerformed

    private void tbJelentesekAlmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbJelentesekAlmenuActionPerformed
        kivalasztottMenuGomb = (JToggleButton) evt.getSource();

        if (!jelenlegiOldal.equals(pnJelentesek) && tbJelentesek.equals(kivalasztottMenuGomb)) {
            tablaFrissit(tblJelentesek, vezerlo.getJelentesekTabla());
            panelValt(pnJelentesek, pnJelentesekAlmenu);
        }
    }//GEN-LAST:event_tbJelentesekAlmenuActionPerformed

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

    private void cbKeresesFTeruletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKeresesFTeruletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKeresesFTeruletActionPerformed

    private void btKeresesGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKeresesGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();

        if (btKeresesKeres.equals(kivalasztottGomb)) {
            tablaFrissit(tblFooldalKereses, vezerlo.getReszletesKeresesProjektekTabla(
                    cbKeresesMegrend.getSelectedItem(), cbKeresesFTerulet.getSelectedIndex() + 1,
                    dcKeresesDatumtol.getDate(), dcKeresesDatumig.getDate(), cbKeresesHolTart.getSelectedIndex() + 1, cbKeresesPrioritas.getSelectedIndex() + 1,
                    cbKeresesPVezeto.getSelectedItem(), cbKeresesStatusz.getSelectedIndex() + 1
            ));
        }
    }//GEN-LAST:event_btKeresesGombokActionPerformed

    private void cbKeresesHolTartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKeresesHolTartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKeresesHolTartActionPerformed

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

    private void btJelentesekKGombokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJelentesekKGombokActionPerformed
        kivalasztottGomb = (JButton) evt.getSource();
        if (tblJelentesekK.getSelectedRow() > -1) {
            kivalasztottJelentes = (Jelentes) tblJelentesekK.getValueAt(tblJelentesekK.getSelectedRow(), JelentesTablaModell.OBJECT_OSZLOP);
        }

        if (btJelentesekKHozzaad.equals(kivalasztottGomb)) {
            vezerlo.csVezetoJelentesHozzaadd(cbJelentesekKPNev.getSelectedItem(), taJelentesekKLeiras.getText());
        } else if (btJelentesekKModosit.equals(kivalasztottGomb)) {
            if (btJelentesekKModosit.getText().equals("Módosít")) {
                cbJelentesekKPNev.setSelectedIndex(vezerlo.getKivalasztottProjektIndex(kivalasztottJelentes.getProjekt(), cbJelentesekKPNev.getModel()));
                taJelentesekKLeiras.setText(kivalasztottJelentes.getSzoveg());
                btJelentesekKTorol.setEnabled(false);
                btJelentesekKModosit.setText("Mentés");
            } else {
                vezerlo.csVezetoJelentesModositasMentes(kivalasztottJelentes, cbJelentesekKPNev.getSelectedItem(), taJelentesekKLeiras.getText());
                btJelentesekKModosit.setText("Módosít");
            }
        } else if (btJelentesekKTorol.equals(kivalasztottGomb)) {
            vezerlo.csVezetoJelentesTorlese(kivalasztottJelentes);
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

    public void jelentesPanelAlaphelyzet() {
        btJelentesekKHozzaad.setEnabled(true);
        btJelentesekKModosit.setEnabled(false);
        btJelentesekKTorol.setEnabled(false);
        taJelentesekKLeiras.setText(null);
        tablaFrissit(tblJelentesekK, vezerlo.getCsvezJelentesekKTabla());
        comboBoxFrissit(cbJelentesekKPNev, vezerlo.getProjektCBModell());
    }

    public JPanel getPnFooldal() {
        return pnFooldal;
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

    public JComboBox<String> getCbJelentesekKPNev() {
        return cbJelentesekKPNev;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgFeladatok;
    private javax.swing.ButtonGroup bgFomenu;
    private javax.swing.ButtonGroup bgFomenuAlmenu;
    private javax.swing.ButtonGroup bgJelentesek;
    private javax.swing.JButton btFeladatokFrissit;
    private javax.swing.JButton btFeladatokKeres;
    private javax.swing.JButton btFooldalFrissit;
    private javax.swing.JButton btFooldalInfo;
    private javax.swing.JButton btFooldalKeres;
    private javax.swing.JButton btJelentesekKAlap;
    private javax.swing.JButton btJelentesekKHozzaad;
    private javax.swing.JButton btJelentesekKModosit;
    private javax.swing.JButton btJelentesekKTorol;
    private javax.swing.JButton btJelentesekTeljesMeret;
    private javax.swing.JButton btJelszoValtMent;
    private javax.swing.JButton btJelszovalt;
    private javax.swing.JButton btKeresesDatumigTorol;
    private javax.swing.JButton btKeresesDatumtolTorol;
    private javax.swing.JButton btKeresesKeres;
    private javax.swing.JButton btKijelentkezes;
    private javax.swing.JButton btVissza;
    private javax.swing.JComboBox<String> cbJelentesekKPNev;
    private javax.swing.JComboBox<String> cbKeresesFTerulet;
    private javax.swing.JComboBox<String> cbKeresesHolTart;
    private javax.swing.JComboBox<String> cbKeresesMegrend;
    private javax.swing.JComboBox<String> cbKeresesPVezeto;
    private javax.swing.JComboBox<String> cbKeresesPrioritas;
    private javax.swing.JComboBox<String> cbKeresesStatusz;
    private com.toedter.calendar.JDateChooser dcKeresesDatumig;
    private com.toedter.calendar.JDateChooser dcKeresesDatumtol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lbBelepveNev;
    private javax.swing.JLabel lbFeladatokNev;
    private javax.swing.JLabel lbFooldalPNev;
    private javax.swing.JLabel lbJelszoHibaUzenet;
    private javax.swing.JLayeredPane lpAlmenu;
    private javax.swing.JLayeredPane lpTartalom;
    private javax.swing.JPasswordField pfJelszoValtJelenlegi;
    private javax.swing.JPasswordField pfJelszoValtMegerosit;
    private javax.swing.JPasswordField pfJelszoValtUj;
    private javax.swing.JPanel pnFeladatok;
    private javax.swing.JPanel pnFeladatokAlmenu;
    private javax.swing.JPanel pnFomenu;
    private javax.swing.JPanel pnFooldal;
    private javax.swing.JPanel pnFooldalAlmenu;
    private javax.swing.JPanel pnFooldalKereses;
    private javax.swing.JPanel pnJelentesek;
    private javax.swing.JPanel pnJelentesekAlmenu;
    private javax.swing.JPanel pnJelentesekKezel;
    private javax.swing.JPanel pnJelszovaltoztatas;
    private javax.swing.JPanel pnVisszaAlmenu;
    private javax.swing.JTextArea taFeladatokLeiras;
    private javax.swing.JTextArea taFooldalPLeiras;
    private javax.swing.JTextArea taJelentesekKLeiras;
    private javax.swing.JTextArea taJelentesekLeiras;
    private javax.swing.JToggleButton tbAttekinto;
    private javax.swing.JToggleButton tbFeladatok;
    private javax.swing.JToggleButton tbFeladatokAktivP;
    private javax.swing.JToggleButton tbFooldalAktivP;
    private javax.swing.JToggleButton tbJelentesek;
    private javax.swing.JToggleButton tbKereses;
    private javax.swing.JTable tblFeladatok;
    private javax.swing.JTable tblFooldalKereses;
    private javax.swing.JTable tblFooldalProjektek;
    private javax.swing.JTable tblJelentesek;
    private javax.swing.JTable tblJelentesekK;
    private javax.swing.JToggleButton tbtFooldal;
    private javax.swing.JToggleButton tbtJelentesek;
    private javax.swing.JTextField tfFeladatokNev;
    private javax.swing.JTextField tfFooldalPNev;
    // End of variables declaration//GEN-END:variables
}