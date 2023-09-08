package GUI;

/**
 *
 * @author fredy
 */
public class PanelTransaction extends javax.swing.JPanel {

    /**
     * Creates new form PanelTransaction
     */
    public PanelTransaction() {
        initComponents();
    }

    public void setTitle(String title) {
        tltCajero.setText(title);
    }
    
    public void setDescription(String description) {
        lblDescription.setText(description);
    }
    
    public float getMonto() {
        if(txtMonto.getText().length() > 0) {
            return Float.parseFloat(txtMonto.getText());
        }
        return 0f;
    }
    
    public void setMonto(char valorNumerico) {
        String monto = this.txtMonto.getText();
        if(Character.isDigit(valorNumerico)) {
            txtMonto.setText(monto + valorNumerico);
        }else if(monto.length() > 0) {
            String digitoEliminado = monto.substring(0, monto.length() - 1);
            txtMonto.setText(digitoEliminado);
        }
    } 
    
    public void reiniciarMonto() {
        txtMonto.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tltCajero = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();

        setBackground(new java.awt.Color(103, 126, 92));

        tltCajero.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tltCajero.setForeground(new java.awt.Color(0, 0, 0));
        tltCajero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tltCajero.setText("Realizar retiro");

        lblDescription.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblDescription.setText("<html>El monto ingrezado sera retirado de su cuenta.<html>");

        txtMonto.setEditable(false);
        txtMonto.setBackground(new java.awt.Color(103, 126, 92));
        txtMonto.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        txtMonto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 12))); // NOI18N
        txtMonto.setFocusable(false);
        txtMonto.setOpaque(false);
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(txtMonto)
                    .addComponent(tltCajero, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tltCajero, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c) && !Character.isISOControl(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMontoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel tltCajero;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
