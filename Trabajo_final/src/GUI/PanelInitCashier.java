/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DEV.ClassHistorial;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author fredy
 */
public class PanelInitCashier extends javax.swing.JPanel {

    /**
     * Creates new form PanelInitCashier
     */
    public PanelInitCashier() {
        initComponents();
        txtHistorial.setText("Sin operaciones hasta el momento.");
    }

    public void setUsuario(String usuario) {
        txtUsuario.setText("Usuario: " + usuario);
    }
    
    public void setMonto(String monto) {
        txtMonto.setText("Monto: S/." + monto);
    }
    
    public void setHistorial(ArrayList<ClassHistorial> transacciones) {
        StyledDocument doc = txtHistorial.getStyledDocument();
        txtHistorial.setText("");
        try {
            if(!transacciones.isEmpty()) {
                Style txtRed = doc.addStyle("Rojo", null);
                Style txtGreen = doc.addStyle("Verde", null);
                StyleConstants.setForeground(txtRed, Color.red);
                StyleConstants.setForeground(txtGreen, Color.green);
                for(ClassHistorial transaccion: transacciones) {
                    boolean dep = transaccion.getTipo() == ClassHistorial.TipoTransaccion.DEPOSITO;
                    String text = (dep ? "Deposito: " : "Retiro: ") + transaccion.getMonto() + "\n";
                    doc.insertString(doc.getLength(), text, dep ? txtGreen : txtRed);
                }
            }else {
                doc.insertString(doc.getLength(), "No hay operaciones recientes.", null);
            }
        }catch(BadLocationException e) {
            e.getLocalizedMessage();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tltCajero1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        txtMonto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtHistorial = new javax.swing.JTextPane();

        setBackground(new java.awt.Color(103, 126, 92));

        tltCajero1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tltCajero1.setForeground(new java.awt.Color(0, 0, 0));
        tltCajero1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tltCajero1.setText("Gestiona tu cuenta");

        txtUsuario.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        txtUsuario.setText("Usuario: Fredy");

        txtMonto.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        txtMonto.setText("Monto: S/. 1200");

        jScrollPane2.setBorder(null);

        txtHistorial.setEditable(false);
        txtHistorial.setBackground(new java.awt.Color(103, 126, 92));
        txtHistorial.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Historial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 12))); // NOI18N
        txtHistorial.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        txtHistorial.setFocusable(false);
        txtHistorial.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtHistorial.setMaximumSize(new java.awt.Dimension(11, 22));
        jScrollPane2.setViewportView(txtHistorial);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMonto)
                    .addComponent(txtUsuario)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tltCajero1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tltCajero1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtUsuario)
                .addGap(10, 10, 10)
                .addComponent(txtMonto)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel tltCajero1;
    private javax.swing.JTextPane txtHistorial;
    private javax.swing.JLabel txtMonto;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
