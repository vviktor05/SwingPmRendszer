package projektmenedzsmentrendszer.nezet;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import projektmenedzsmentrendszer.vezerlo.Vezerlo;

public class BelepesAblak extends javax.swing.JFrame {
    private final Vezerlo vezerlo;
    
    public BelepesAblak(Vezerlo vezerlo) {
        this.vezerlo = vezerlo;
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btBelepes = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pfJelszo = new javax.swing.JPasswordField();
        cbBeosztas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projektmenedzsment szoftver - Belépés");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Belépés");

        btBelepes.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btBelepes.setText("Belépés");
        btBelepes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBelepesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Dolgozó ID:");

        tfID.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Jelszó:");

        pfJelszo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        cbBeosztas.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        cbBeosztas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Projektvezető", "Csapatvezető", "Fejlesztő" }));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("Beosztás:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btBelepes, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBeosztas, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfJelszo, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btBelepes, cbBeosztas, pfJelszo, tfID});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pfJelszo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbBeosztas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btBelepes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btBelepesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBelepesActionPerformed
        vezerlo.bejelentkezes(tfID.getText(), pfJelszo.getPassword(), cbBeosztas.getSelectedIndex() + 1);       // az adatbázisban 1-től kezdődik az azonosító kiosztás
    }//GEN-LAST:event_btBelepesActionPerformed
    
    public void infoAblak(String uzenet, String fejlec) {
        JOptionPane.showMessageDialog(this, uzenet, fejlec, JOptionPane.INFORMATION_MESSAGE);
    }

    public void kerdesAblak(String uzenet, String fejlec) {
        JOptionPane.showMessageDialog(this, uzenet, fejlec, JOptionPane.YES_NO_OPTION);
    }
    
    public void hibaAblak(String uzenet, String fejlec) {
        JOptionPane.showMessageDialog(this, uzenet, fejlec, JOptionPane.ERROR_MESSAGE);
    }
    
    public JTextField getTfDolgozoID() {
        return tfID;
    }
    
    public JPasswordField getPfJelszo() {
        return pfJelszo;
    }
    
    public JComboBox<String> getCbSzint() {
        return cbBeosztas;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBelepes;
    private javax.swing.JComboBox<String> cbBeosztas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pfJelszo;
    private javax.swing.JTextField tfID;
    // End of variables declaration//GEN-END:variables
}