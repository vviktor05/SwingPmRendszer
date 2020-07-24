package projektmenedzsmentrendszer.nezet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import projektmenedzsmentrendszer.modell.pojoosztalyok.Csapat;
import projektmenedzsmentrendszer.modell.pojoosztalyok.Projekt;
import projektmenedzsmentrendszer.vezerlo.Vezerlo;

public class FooldalTobbinfoAblak extends javax.swing.JFrame {
    private final Vezerlo vezerlo;

    public FooldalTobbinfoAblak(Vezerlo vezerlo) {
        this.vezerlo = vezerlo;
        initComponents();
        setVisible(true);
    }
    
    public void alapHelyzet() {
        if(liPDolgozoCsapatok.getModel().getSize() > 0){
            liPDolgozoCsapatok.setSelectedIndex(0);
            Object kivalasztottSor = liPDolgozoCsapatok.getSelectedValue();
            if(kivalasztottSor instanceof Csapat){
                Csapat kivalasztottCsapat = (Csapat) kivalasztottSor;
                lbCsapatvezeto.setText(kivalasztottCsapat.getCsapatvezeto().getNev());
                dolgozoListaKiir(kivalasztottCsapat);
            }
        }
    }

    public void csapatokListaKiir(int kivalasztottProjektAzon) {
        DefaultListModel dolgozoCsapatokModell = vezerlo.getKivalasztottProjektenDolgozoCsapatokLModell(kivalasztottProjektAzon);
        if (dolgozoCsapatokModell.getSize() <= 0) {
            dolgozoCsapatokModell.addElement("Nincs adat");
        }
        liPDolgozoCsapatok.setModel(dolgozoCsapatokModell);
    }

    public void dolgozoListaKiir(Object kivalasztottCsapatAzon) {
        DefaultListModel csapatbanDolgozokModell = vezerlo.getKivalasztottCsapatTagjaiLModell(kivalasztottCsapatAzon);
        if (csapatbanDolgozokModell.getSize() <= 0) {
            csapatbanDolgozokModell.addElement("Nincs adat");
        }
        liCsapatbanDolgozok.setModel(csapatbanDolgozokModell);
    }

    public void comboBoxFrissit(JComboBox cb, DefaultComboBoxModel modell) {
        if (modell.getSize() <= 0) {
            modell.addElement("Nincs adat");
        }
        cb.setModel(modell);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
        btVissza = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        liPDolgozoCsapatok = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        liCsapatbanDolgozok = new javax.swing.JList<>();
        jLabel27 = new javax.swing.JLabel();
        cbProjekt = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        lbCsapatvezeto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Projekt információ");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Projekt információ");

        btVissza.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btVissza.setText("Vissza");
        btVissza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisszaActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel26.setText("Projekten dolgozó csapatok:");

        jLabel40.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel40.setText("Csapatban dolgozók:");

        liPDolgozoCsapatok.setBackground(new java.awt.Color(240, 240, 240));
        liPDolgozoCsapatok.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        liPDolgozoCsapatok.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        liPDolgozoCsapatok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                liPDolgozoCsapatokMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(liPDolgozoCsapatok);

        liCsapatbanDolgozok.setBackground(new java.awt.Color(240, 240, 240));
        liCsapatbanDolgozok.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        liCsapatbanDolgozok.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        liCsapatbanDolgozok.setFocusable(false);
        jScrollPane2.setViewportView(liCsapatbanDolgozok);

        jLabel27.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel27.setText("Kiválasztott projekt:");

        cbProjekt.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProjektActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel41.setText("Csapatvezető:");

        lbCsapatvezeto.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbProjekt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCsapatvezeto)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btVissza, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(cbProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(lbCsapatvezeto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVissza, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVisszaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisszaActionPerformed
        vezerlo.infoKilep();
    }//GEN-LAST:event_btVisszaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        vezerlo.infoKilep();
    }//GEN-LAST:event_formWindowClosing

    private void liPDolgozoCsapatokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_liPDolgozoCsapatokMouseClicked
        Object kivalasztottSor = liPDolgozoCsapatok.getSelectedValue();
        if(kivalasztottSor instanceof Csapat){
            Csapat kivalasztottCsapat = (Csapat) kivalasztottSor;
            lbCsapatvezeto.setText(kivalasztottCsapat.getCsapatvezeto().getNev());
            dolgozoListaKiir(kivalasztottCsapat);
        }
    }//GEN-LAST:event_liPDolgozoCsapatokMouseClicked

    private void cbProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProjektActionPerformed
        liCsapatbanDolgozok.setModel(new DefaultComboBoxModel<>());
        csapatokListaKiir(((Projekt) cbProjekt.getSelectedItem()).getAzon());
        alapHelyzet();
    }//GEN-LAST:event_cbProjektActionPerformed

    public JList<String> getLiPDolgozoCsapatok() {
        return liPDolgozoCsapatok;
    }

    public JList<String> getLiCsapatbanDolgozok() {
        return liCsapatbanDolgozok;
    }

    public JComboBox<String> getCbProjekt() {
        return cbProjekt;
    }

    public JLabel getLbCsapatvezeto() {
        return lbCsapatvezeto;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVissza;
    private javax.swing.JComboBox<String> cbProjekt;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCsapatvezeto;
    private javax.swing.JList<String> liCsapatbanDolgozok;
    private javax.swing.JList<String> liPDolgozoCsapatok;
    // End of variables declaration//GEN-END:variables
}