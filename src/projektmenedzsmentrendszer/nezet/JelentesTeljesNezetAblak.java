package projektmenedzsmentrendszer.nezet;

import java.util.Date;
import java.text.ParseException;
import projektmenedzsmentrendszer.modell.pojoosztalyok.Jelentes;
import projektmenedzsmentrendszer.modell.tablamodellek.DatumFormazo;

public class JelentesTeljesNezetAblak extends javax.swing.JFrame {
    Date datum;

    public JelentesTeljesNezetAblak(Jelentes jelentes) {
        initComponents();
        lbPNev.setText(jelentes.getProjekt().getNev());
        try {
            datum = DatumFormazo.ROVID_DATUM_IDO_ADATBAZIS.parse(jelentes.getFelvitelDatuma());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lbFelvitelDatum.setText(DatumFormazo.HOSSZU_DATUM_IDO.format(datum));
        lbFelvitte.setText(jelentes.getFelvitte().getNev());
        taTeljesNezetLeiras.setText(jelentes.getSzoveg());
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel59 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        taTeljesNezetLeiras = new javax.swing.JTextArea();
        lbPNev = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        lbFelvitelDatum = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        lbFelvitte = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Teljes nézet");

        jLabel59.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel59.setText("Projekt neve:");

        taTeljesNezetLeiras.setEditable(false);
        taTeljesNezetLeiras.setBackground(new java.awt.Color(240, 240, 240));
        taTeljesNezetLeiras.setColumns(20);
        taTeljesNezetLeiras.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        taTeljesNezetLeiras.setLineWrap(true);
        taTeljesNezetLeiras.setRows(5);
        taTeljesNezetLeiras.setWrapStyleWord(true);
        taTeljesNezetLeiras.setBorder(null);
        jScrollPane18.setViewportView(taTeljesNezetLeiras);

        lbPNev.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        jLabel61.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel61.setText("Felvitel dátuma:");

        lbFelvitelDatum.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        jLabel63.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel63.setText("Felvitte:");

        lbFelvitte.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPNev, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFelvitelDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFelvitte, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(lbPNev)
                    .addComponent(jLabel61)
                    .addComponent(lbFelvitelDatum)
                    .addComponent(jLabel63)
                    .addComponent(lbFelvitte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JLabel lbFelvitelDatum;
    private javax.swing.JLabel lbFelvitte;
    private javax.swing.JLabel lbPNev;
    private javax.swing.JTextArea taTeljesNezetLeiras;
    // End of variables declaration//GEN-END:variables
}
