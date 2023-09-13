package GUI;

import DEV.ClassCajero;
import DEV.ClassHistorial;
import DEV.ClassCajero.EstadoActual;
import DEV.ClassHistorial.TipoTransaccion;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import devlibrerias.Libreria_imagenes;
import java.awt.image.BufferedImage;

/**
 *
 * @author fredy
 */
public final class ScreenMain extends javax.swing.JFrame {
    private final PanelInitCashier pnlInitCashier = new PanelInitCashier();
    private final PanelTransaction pnlTransaction = new PanelTransaction();
    private final ClassCajero info_cajero;
    
    /**
     * Creates new form Formulario
     */
    public ScreenMain() {
        initComponents();
        info_cajero = new ClassCajero("", 0f);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Fasae cashier");
        //Ingrezar a la pantalla principal
        GridBagConstraints contrains = new GridBagConstraints();
        contrains.gridx = 0;
        contrains.gridy = 0;
        panelMain.add(pnlInitCashier, contrains);
        panelMain.add(pnlTransaction, contrains);
        pnlLogin.setVisible(false);
        pnlInitCashier.setVisible(false);
        pnlTransaction.setVisible(false);
        //Asignar eventos al teclado numerico
        setEventKeyNumbers();
        //Generar cambios en la pantalla
        changeStateCashier();
        setImagesCajero();
    }
    
    public void setEventKeyNumbers() {
        for(Component cmp: ctnNumberButtons.getComponents()) {
            if(cmp instanceof JButton btn) {
                btn.addActionListener((ActionEvent e) -> {
                    pnlTransaction.setMonto(btn.getText().charAt(0));
                });
            }
        }
    }
    
    public void setImagesCajero() {
        String pathImage1 = "src/assets/iconoCancelar.png";
        String pathImage2 = "src/assets/iconoBorrar.png";
        String pathImage3 = "src/assets/iconoAceptar.png";
        Libreria_imagenes resize = new Libreria_imagenes();
        BufferedImage getImage1 = resize.getImageResize(pathImage1, 14, 14);
        BufferedImage getImage2 = resize.getImageResize(pathImage2, 14, 14);
        BufferedImage getImage3 = resize.getImageResize(pathImage3, 14, 14);
        btnCancel.setIcon(new ImageIcon(getImage1));
        btnDelete.setIcon(new ImageIcon(getImage2));
        btnOk.setIcon(new ImageIcon(getImage3));
    }
    
    public void changeStateCashier() {
        boolean login = false,
                initCashier = false,
                transaction = false,
                activeNumbers = false,
                activeOptions = false,
                select1 = false,
                select2 = false,
                select3 = false,
                dep = info_cajero.getDepositando();
        String txtSelect1 = "",
               txtSelect2 = "",
               txtSelect3 = ""; 
        EstadoActual estado = info_cajero.obtenerEstadoActual();
        switch (estado) {
            case LOGIN -> {
                login = true;
                select1 = true;
                txtSelect1 = "Ingresar";
            }
            case CAJERO -> {
                initCashier = true;
                select1 = true;
                select2 = true;
                select3 = true;
                txtSelect1 = "Depositar";
                txtSelect2 = "Retirar";
                txtSelect3 = "Salir";
            }
            case TRANSACCION -> {
                transaction = true;
                activeNumbers = true;
                activeOptions = true;
                pnlTransaction.setTitle(dep ? "Realizar deposito" : "Realizar retiro");  
                pnlTransaction.setDescription(
                    "<html>El monto ingrezado sera" +
                    (dep ? " retirado de" : " agregado a") +
                    " su cuenta.<html>"
                );
            }
        }
        for(Component cmp: ctnNumberButtons.getComponents()) 
            cmp.setEnabled(activeNumbers);
        for(Component cmp: ctnOptionsButtons.getComponents()) 
            cmp.setEnabled(activeOptions);
        btnSelect1.setEnabled(select1);
        btnSelect2.setEnabled(select2);
        btnSelect3.setEnabled(select3);
        lblSelect1.setText(txtSelect1);
        lblSelect2.setText(txtSelect2);
        lblSelect3.setText(txtSelect3);
        pnlLogin.setVisible(login);
        pnlInitCashier.setVisible(initCashier);
        pnlTransaction.setVisible(transaction);
        pnlInitCashier.setUsuario(info_cajero.getUsuario());
        pnlInitCashier.setMonto(Float.toString(info_cajero.getMonto()));
        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTextField2 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        ctnNumberButtons = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        ctnOptionsButtons = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        panelMain = new javax.swing.JPanel();
        pnlLogin = new javax.swing.JPanel();
        tltCajero = new javax.swing.JLabel();
        inpUsuario = new javax.swing.JTextField();
        inpMontoInicial = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        lblSelect1 = new javax.swing.JLabel();
        lblSelect2 = new javax.swing.JLabel();
        lblSelect3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        btnSelect1 = new javax.swing.JButton();
        btnSelect2 = new javax.swing.JButton();
        btnSelect3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(8, 8, 26));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 45));

        ctnNumberButtons.setMaximumSize(new java.awt.Dimension(100, 100));
        ctnNumberButtons.setMinimumSize(new java.awt.Dimension(100, 100));
        ctnNumberButtons.setOpaque(false);
        ctnNumberButtons.setPreferredSize(new java.awt.Dimension(169, 169));
        ctnNumberButtons.setLayout(new java.awt.GridLayout(4, 3, 5, 5));

        jButton4.setBackground(new java.awt.Color(26, 26, 63));
        jButton4.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("1");
        jButton4.setPreferredSize(new java.awt.Dimension(24, 24));
        ctnNumberButtons.add(jButton4);

        jButton5.setBackground(new java.awt.Color(26, 26, 63));
        jButton5.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("2");
        ctnNumberButtons.add(jButton5);

        jButton6.setBackground(new java.awt.Color(26, 26, 63));
        jButton6.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("3");
        ctnNumberButtons.add(jButton6);

        jButton9.setBackground(new java.awt.Color(26, 26, 63));
        jButton9.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("4");
        ctnNumberButtons.add(jButton9);

        jButton7.setBackground(new java.awt.Color(26, 26, 63));
        jButton7.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("5");
        ctnNumberButtons.add(jButton7);

        jButton8.setBackground(new java.awt.Color(26, 26, 63));
        jButton8.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("6");
        ctnNumberButtons.add(jButton8);

        jButton12.setBackground(new java.awt.Color(26, 26, 63));
        jButton12.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("7");
        ctnNumberButtons.add(jButton12);

        jButton11.setBackground(new java.awt.Color(26, 26, 63));
        jButton11.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("8");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        ctnNumberButtons.add(jButton11);

        jButton10.setBackground(new java.awt.Color(26, 26, 63));
        jButton10.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("9");
        ctnNumberButtons.add(jButton10);

        jPanel3.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        ctnNumberButtons.add(jPanel3);

        jButton13.setBackground(new java.awt.Color(26, 26, 63));
        jButton13.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("0");
        ctnNumberButtons.add(jButton13);

        jPanel5.add(ctnNumberButtons);
        ctnNumberButtons.getAccessibleContext().setAccessibleName("");

        ctnOptionsButtons.setOpaque(false);

        btnCancel.setBackground(new java.awt.Color(196, 21, 28));
        btnCancel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnCancel.setIconTextGap(8);
        btnCancel.setPreferredSize(new java.awt.Dimension(84, 32));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(194, 182, 0));
        btnDelete.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Borrar");
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnDelete.setIconTextGap(8);
        btnDelete.setPreferredSize(new java.awt.Dimension(71, 32));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnOk.setBackground(new java.awt.Color(0, 142, 70));
        btnOk.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        btnOk.setForeground(new java.awt.Color(255, 255, 255));
        btnOk.setText("Aceptar");
        btnOk.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnOk.setIconTextGap(8);
        btnOk.setPreferredSize(new java.awt.Dimension(77, 32));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ctnOptionsButtonsLayout = new javax.swing.GroupLayout(ctnOptionsButtons);
        ctnOptionsButtons.setLayout(ctnOptionsButtonsLayout);
        ctnOptionsButtonsLayout.setHorizontalGroup(
            ctnOptionsButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctnOptionsButtonsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(ctnOptionsButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        ctnOptionsButtonsLayout.setVerticalGroup(
            ctnOptionsButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctnOptionsButtonsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.add(ctnOptionsButtons);

        jPanel4.setBackground(new java.awt.Color(8, 8, 26));

        panelMain.setBackground(new java.awt.Color(103, 126, 92));
        panelMain.setName(""); // NOI18N
        panelMain.setPreferredSize(new java.awt.Dimension(287, 160));
        java.awt.GridBagLayout panelMainLayout = new java.awt.GridBagLayout();
        panelMainLayout.columnWidths = new int[] {0};
        panelMainLayout.rowHeights = new int[] {0};
        panelMainLayout.columnWeights = new double[] {0.0};
        panelMainLayout.rowWeights = new double[] {0.0};
        panelMain.setLayout(panelMainLayout);

        pnlLogin.setOpaque(false);

        tltCajero.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tltCajero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tltCajero.setText("Gestiona tu usuario");

        inpUsuario.setBackground(new java.awt.Color(103, 126, 92));
        inpUsuario.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        inpUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 12))); // NOI18N

        inpMontoInicial.setBackground(new java.awt.Color(103, 126, 92));
        inpMontoInicial.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        inpMontoInicial.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monto inical", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 12))); // NOI18N
        inpMontoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inpMontoInicialKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inpMontoInicial)
                    .addComponent(tltCajero, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(inpUsuario))
                .addGap(40, 40, 40))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tltCajero, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(inpUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(inpMontoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelMain.add(pnlLogin, gridBagConstraints);
        pnlLogin.getAccessibleContext().setAccessibleName("");

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.GridBagLayout());

        lblSelect1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblSelect1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSelect1.setText("Ingresar");
        lblSelect1.setPreferredSize(new java.awt.Dimension(60, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel9.add(lblSelect1, gridBagConstraints);

        lblSelect2.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblSelect2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSelect2.setPreferredSize(new java.awt.Dimension(60, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel9.add(lblSelect2, gridBagConstraints);

        lblSelect3.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblSelect3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSelect3.setPreferredSize(new java.awt.Dimension(60, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel9.add(lblSelect3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        panelMain.add(jPanel9, gridBagConstraints);

        jPanel12.setBackground(new java.awt.Color(8, 8, 26));
        jPanel12.setMinimumSize(new java.awt.Dimension(129, 24));
        jPanel12.setPreferredSize(new java.awt.Dimension(45, 0));
        jPanel12.setLayout(new java.awt.GridBagLayout());

        btnSelect1.setBackground(new java.awt.Color(26, 26, 63));
        btnSelect1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        btnSelect1.setForeground(new java.awt.Color(255, 255, 255));
        btnSelect1.setText("<");
        btnSelect1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelect1ActionPerformed(evt);
            }
        });
        jPanel12.add(btnSelect1, new java.awt.GridBagConstraints());

        btnSelect2.setBackground(new java.awt.Color(26, 26, 63));
        btnSelect2.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        btnSelect2.setForeground(new java.awt.Color(255, 255, 255));
        btnSelect2.setText("<");
        btnSelect2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelect2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        jPanel12.add(btnSelect2, gridBagConstraints);

        btnSelect3.setBackground(new java.awt.Color(26, 26, 63));
        btnSelect3.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        btnSelect3.setForeground(new java.awt.Color(255, 255, 255));
        btnSelect3.setText("<");
        btnSelect3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelect3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        jPanel12.add(btnSelect3, gridBagConstraints);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if(info_cajero.obtenerEstadoActual() == EstadoActual.TRANSACCION) {
            boolean dep = info_cajero.getDepositando(); 
            float monto = info_cajero.getMonto();
            float tranMonto = pnlTransaction.getMonto();
            if(!dep && monto < tranMonto) {
                JOptionPane.showMessageDialog(this, "No tiene el monto suficiente para el retiro.", "Monto invalido", JOptionPane.ERROR_MESSAGE);
            }else if(tranMonto == 0f) {
                JOptionPane.showMessageDialog(this, "Tiene que insertar algun monto.", "Monto invalido", JOptionPane.ERROR_MESSAGE);
            }else {
                float montoFinal = dep ? (monto + tranMonto) : (monto - tranMonto);
                ClassHistorial transaccion = new ClassHistorial(tranMonto, dep ? TipoTransaccion.DEPOSITO : TipoTransaccion.RETIRO);
                info_cajero.setMonto(montoFinal);
                info_cajero.agregarHistorial(transaccion);
                info_cajero.cambiarEstadoCajero();
                pnlInitCashier.setHistorial(info_cajero.obtenerHistorial());
                pnlTransaction.reiniciarMonto();
                changeStateCashier();
                this.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void btnSelect3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelect3ActionPerformed
        if(info_cajero.obtenerEstadoActual() == EstadoActual.CAJERO) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Al salir sus datos se borraran del cajero.", "¿Seguro de salir?", JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }//GEN-LAST:event_btnSelect3ActionPerformed

    private void inpMontoInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inpMontoInicialKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c) && !Character.isISOControl(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_inpMontoInicialKeyTyped

    private void btnSelect2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelect2ActionPerformed
        if(info_cajero.obtenerEstadoActual() == EstadoActual.CAJERO) {
            info_cajero.cambiarEstadoTransaccion();
            info_cajero.setDepositando(false);
            changeStateCashier();
        }
    }//GEN-LAST:event_btnSelect2ActionPerformed

    private void btnSelect1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelect1ActionPerformed
        if(info_cajero.obtenerEstadoActual() == EstadoActual.LOGIN) {
            String usuario = inpUsuario.getText();
            String montoInicial = inpMontoInicial.getText();
            if(!usuario.isEmpty() && !montoInicial.isEmpty()) {
                info_cajero.cambiarEstadoCajero();
                info_cajero.setUsuario(usuario);
                info_cajero.setMonto(Float.parseFloat(montoInicial));
                changeStateCashier();
            }else {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos.", "Formulario invalido", JOptionPane.ERROR_MESSAGE);
            }            
        }else if(info_cajero.obtenerEstadoActual() == EstadoActual.CAJERO) {
            info_cajero.cambiarEstadoTransaccion();
            info_cajero.setDepositando(true);
            changeStateCashier();
        }
    }//GEN-LAST:event_btnSelect1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(info_cajero.obtenerEstadoActual() == EstadoActual.TRANSACCION) {
            pnlTransaction.setMonto('e');
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        if(info_cajero.obtenerEstadoActual() == EstadoActual.TRANSACCION) {
            info_cajero.cambiarEstadoCajero();
            pnlTransaction.reiniciarMonto();
            changeStateCashier();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScreenMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSelect1;
    private javax.swing.JButton btnSelect2;
    private javax.swing.JButton btnSelect3;
    private javax.swing.JPanel ctnNumberButtons;
    private javax.swing.JPanel ctnOptionsButtons;
    private javax.swing.JTextField inpMontoInicial;
    private javax.swing.JTextField inpUsuario;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblSelect1;
    private javax.swing.JLabel lblSelect2;
    private javax.swing.JLabel lblSelect3;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JLabel tltCajero;
    // End of variables declaration//GEN-END:variables
}
