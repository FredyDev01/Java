
package Forms;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Component;
import java.awt.event.ActionEvent;
// Importando Librerias
import Cajero.Cajero;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;


public final class CajeroForms extends javax.swing.JFrame {
    String user, aux;
    double cash, mount;
    enum Options {
        Login,
        Home,
        Deposit,
        Retreat,
        Record
    };
    Options optionCashier = Options.Login;
    Cajero cajero = new Cajero();
    JScrollPane containerTableRecord;
    DefaultTableModel modelRecord; 
    
    public CajeroForms() {
        initComponents();
        //Configuracion general del formulario
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Fasae - ATM");
        onInsertTableRecord();
        onSetEventsKeyNumbers();
        onChangeCashierScreen();
        //Ocultando los elementos
        label_user.setVisible(false);
        label_msg2.setVisible(false);
        input_monto.setVisible(false);
    }
    
        public void onInsertTableRecord() {
            containerTableRecord = new JScrollPane();
            containerTableRecord.setOpaque(false);
            containerTableRecord.setMinimumSize(new Dimension(200, 100));
            modelRecord = new DefaultTableModel(new String[] {"Tipo", "Monto", "Fecha"}, 0);
            JTable tableRecord = new JTable();
            tableRecord.setModel(modelRecord);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.insets = new Insets(0, 15, 0, 15);
            containerTableRecord.setViewportView(tableRecord);
            pnlPantalla.add(containerTableRecord, gbc);
            containerTableRecord.setVisible(false);
        }
    
    public void onChangeCashierScreen() {
        boolean showOptionsButtons = false,
                showTitleLabel = false,
                showMenssageLabel = false,
                showAmountLabel = false,
                showAmountInput = false,
                showPersonImage = false,
                showTableContainer = false,
                showNumberButtons = false,
                showCleanButton = false,
                showLoginButton = false,
                showActionsButton = false,
                showActionCancel = false;
        String titleLabelText = "", messageLabelText = "";
        switch(optionCashier) {
            case Login -> {
                showMenssageLabel = true;
                showPersonImage = true;
                showLoginButton = true;
                messageLabelText = "INGRESE SU CUENTA";
            }
            case Home -> {
                showOptionsButtons = true;
                showTitleLabel = true;
                showMenssageLabel = true;
                showPersonImage = true;
                titleLabelText = "Bienvenido(a) " + user + "!";
                messageLabelText = "Que operacion haras?";
            }
            case Deposit, Retreat -> {
                showMenssageLabel = true;
                showPersonImage = true;
                showAmountLabel = true;
                showAmountInput = true;
                showNumberButtons = true;
                showCleanButton = true;
                showActionsButton = true;
                showActionCancel = true;
                messageLabelText = optionCashier == Options.Deposit ? "DEPOSITAR" : "RETIRAR";
            }
            case Record -> {
                showMenssageLabel = true;
                showActionCancel = true;
                showTableContainer = true;
                messageLabelText = "MI HISTORIAL";
            }
        }
        label_user.setVisible(showTitleLabel);
        label_user.setText(titleLabelText);
        label_msg.setVisible(showMenssageLabel);
        label_msg.setText(messageLabelText);
        img_persona.setVisible(showPersonImage);
        label_msg2.setVisible(showAmountLabel);
        input_monto.setVisible(showAmountInput);
        containerTableRecord.setVisible(showTableContainer);
        onSetStatusButtons(ctnOptions, showOptionsButtons);
        onSetStatusButtons(ctnButtons, showNumberButtons);
        onSetStatusButtons(ctnActions, showActionsButton);
        btn_limpiar.setEnabled(showCleanButton);
        btn_ingresar.setEnabled(showLoginButton);
        btn_cancelar.setEnabled(showActionCancel);
    }

    public void onSetStatusButtons(JPanel container, boolean status) {
        for(Component element: container.getComponents()) {
            if(element instanceof JButton button) {
                button.setEnabled(status);
            }
        }
    }
    
    public void onSetEventsKeyNumbers() {
        for(Component element: ctnButtons.getComponents()) {
            if(element instanceof JButton button) {
                String txtButton = button.getText();
                if(txtButton.matches("[0-9]+")) {
                    button.addActionListener((ActionEvent e) -> {
                        aux = input_monto.getText();
                        input_monto.setText(aux + button.getText());
                    });
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        ctnOptions = new javax.swing.JPanel();
        pnlPantalla = new javax.swing.JPanel();
        img_persona = new javax.swing.JLabel();
        label_msg = new javax.swing.JLabel();
        label_user = new javax.swing.JLabel();
        input_monto = new javax.swing.JTextField();
        label_msg2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        btn_deposito = new javax.swing.JButton();
        btn_cash = new javax.swing.JButton();
        btn_historial = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        btn_deposito1 = new javax.swing.JButton();
        btn_retiro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        pnlPrincipal = new javax.swing.JPanel();
        ctnButtons = new javax.swing.JPanel();
        btn_1 = new javax.swing.JButton();
        btn_2 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        btn_7 = new javax.swing.JButton();
        btn_8 = new javax.swing.JButton();
        btn_9 = new javax.swing.JButton();
        btn_0 = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_ingresar = new javax.swing.JButton();
        ctnActions = new javax.swing.JPanel();
        btn_cancelar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        btn_confirmar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setEnabled(false);

        ctnOptions.setBackground(new java.awt.Color(0, 51, 102));
        ctnOptions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPantalla.setBackground(new java.awt.Color(102, 204, 255));
        pnlPantalla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlPantalla.setLayout(new java.awt.GridBagLayout());

        img_persona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/persona.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BELOW_BASELINE_LEADING;
        pnlPantalla.add(img_persona, gridBagConstraints);

        label_msg.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_msg.setText("INGRESE SU CUENTA");
        label_msg.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        label_msg.setMaximumSize(new java.awt.Dimension(220, 17));
        label_msg.setMinimumSize(new java.awt.Dimension(220, 17));
        label_msg.setPreferredSize(new java.awt.Dimension(220, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        pnlPantalla.add(label_msg, gridBagConstraints);

        label_user.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_user.setMaximumSize(new java.awt.Dimension(220, 17));
        label_user.setMinimumSize(new java.awt.Dimension(220, 17));
        label_user.setName(""); // NOI18N
        label_user.setPreferredSize(new java.awt.Dimension(220, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        pnlPantalla.add(label_user, gridBagConstraints);

        input_monto.setEditable(false);
        input_monto.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BELOW_BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 15);
        pnlPantalla.add(input_monto, gridBagConstraints);

        label_msg2.setText("Monto: S/");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.insets = new java.awt.Insets(10, 65, 0, 0);
        pnlPantalla.add(label_msg2, gridBagConstraints);

        ctnOptions.add(pnlPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 230, 180));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        ctnOptions.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 30));

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        ctnOptions.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 50, 30));

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        ctnOptions.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 30));

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));

        jPanel13.setBackground(new java.awt.Color(0, 204, 0));
        jPanel13.setPreferredSize(new java.awt.Dimension(133, 4));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        ctnOptions.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 200, 20));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(153, 153, 153));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel17.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 40));

        ctnOptions.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 340, 60));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        ctnOptions.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 210, 10));

        btn_deposito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/depositar.png"))); // NOI18N
        btn_deposito.setToolTipText("Depositar");
        btn_deposito.setEnabled(false);
        btn_deposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_depositoActionPerformed(evt);
            }
        });
        ctnOptions.add(btn_deposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 50, 30));

        btn_cash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cash.png"))); // NOI18N
        btn_cash.setToolTipText("Mostrar saldo");
        btn_cash.setEnabled(false);
        btn_cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cashActionPerformed(evt);
            }
        });
        ctnOptions.add(btn_cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 50, 30));

        btn_historial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Historial.png"))); // NOI18N
        btn_historial.setToolTipText("Historial");
        btn_historial.setEnabled(false);
        btn_historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_historialActionPerformed(evt);
            }
        });
        ctnOptions.add(btn_historial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 50, 30));

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        btn_exit.setText(" ");
        btn_exit.setToolTipText("Salir");
        btn_exit.setEnabled(false);
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        ctnOptions.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 50, 30));

        btn_deposito1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/depositar.png"))); // NOI18N
        btn_deposito1.setToolTipText("Depositar");
        btn_deposito1.setEnabled(false);
        btn_deposito1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deposito1ActionPerformed(evt);
            }
        });
        ctnOptions.add(btn_deposito1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 50, 30));

        btn_retiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retirar.png"))); // NOI18N
        btn_retiro.setToolTipText("Retirar");
        btn_retiro.setEnabled(false);
        btn_retiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retiroActionPerformed(evt);
            }
        });
        ctnOptions.add(btn_retiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 50, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CAJERO");

        jPanel18.setBackground(new java.awt.Color(0, 0, 0));

        jPanel19.setBackground(new java.awt.Color(0, 204, 0));
        jPanel19.setPreferredSize(new java.awt.Dimension(133, 6));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 110, 20));

        jPanel22.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel20.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 20));

        jPanel23.setBackground(new java.awt.Color(0, 0, 0));

        jPanel24.setBackground(new java.awt.Color(0, 204, 0));
        jPanel24.setPreferredSize(new java.awt.Dimension(133, 6));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlPrincipal.setBackground(new java.awt.Color(0, 51, 102));
        pnlPrincipal.setLayout(new java.awt.GridBagLayout());

        ctnButtons.setOpaque(false);
        ctnButtons.setLayout(new java.awt.GridBagLayout());

        btn_1.setText("1");
        btn_1.setEnabled(false);
        btn_1.setMaximumSize(new java.awt.Dimension(45, 45));
        btn_1.setMinimumSize(new java.awt.Dimension(45, 45));
        btn_1.setPreferredSize(new java.awt.Dimension(46, 46));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        ctnButtons.add(btn_1, gridBagConstraints);

        btn_2.setText("2");
        btn_2.setEnabled(false);
        btn_2.setMaximumSize(new java.awt.Dimension(45, 45));
        btn_2.setMinimumSize(new java.awt.Dimension(45, 45));
        btn_2.setPreferredSize(new java.awt.Dimension(46, 46));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        ctnButtons.add(btn_2, gridBagConstraints);

        btn_3.setText("3");
        btn_3.setEnabled(false);
        btn_3.setMaximumSize(new java.awt.Dimension(45, 45));
        btn_3.setMinimumSize(new java.awt.Dimension(45, 45));
        btn_3.setPreferredSize(new java.awt.Dimension(46, 46));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        ctnButtons.add(btn_3, gridBagConstraints);

        btn_4.setText("4");
        btn_4.setEnabled(false);
        btn_4.setMaximumSize(new java.awt.Dimension(45, 45));
        btn_4.setMinimumSize(new java.awt.Dimension(45, 45));
        btn_4.setPreferredSize(new java.awt.Dimension(46, 46));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        ctnButtons.add(btn_4, gridBagConstraints);

        btn_5.setText("5");
        btn_5.setEnabled(false);
        btn_5.setMaximumSize(new java.awt.Dimension(45, 45));
        btn_5.setMinimumSize(new java.awt.Dimension(45, 45));
        btn_5.setPreferredSize(new java.awt.Dimension(46, 46));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        ctnButtons.add(btn_5, gridBagConstraints);

        btn_6.setText("6");
        btn_6.setEnabled(false);
        btn_6.setMaximumSize(new java.awt.Dimension(45, 45));
        btn_6.setMinimumSize(new java.awt.Dimension(45, 45));
        btn_6.setPreferredSize(new java.awt.Dimension(46, 46));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        ctnButtons.add(btn_6, gridBagConstraints);

        btn_7.setText("7");
        btn_7.setEnabled(false);
        btn_7.setMaximumSize(new java.awt.Dimension(45, 45));
        btn_7.setMinimumSize(new java.awt.Dimension(45, 45));
        btn_7.setPreferredSize(new java.awt.Dimension(46, 46));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        ctnButtons.add(btn_7, gridBagConstraints);

        btn_8.setText("8");
        btn_8.setEnabled(false);
        btn_8.setMaximumSize(new java.awt.Dimension(45, 45));
        btn_8.setMinimumSize(new java.awt.Dimension(45, 45));
        btn_8.setPreferredSize(new java.awt.Dimension(46, 46));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        ctnButtons.add(btn_8, gridBagConstraints);

        btn_9.setText("9");
        btn_9.setEnabled(false);
        btn_9.setMaximumSize(new java.awt.Dimension(45, 45));
        btn_9.setMinimumSize(new java.awt.Dimension(45, 45));
        btn_9.setPreferredSize(new java.awt.Dimension(46, 46));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        ctnButtons.add(btn_9, gridBagConstraints);

        btn_0.setText("0");
        btn_0.setEnabled(false);
        btn_0.setMaximumSize(new java.awt.Dimension(45, 45));
        btn_0.setMinimumSize(new java.awt.Dimension(45, 45));
        btn_0.setPreferredSize(new java.awt.Dimension(46, 46));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        ctnButtons.add(btn_0, gridBagConstraints);

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar.png"))); // NOI18N
        btn_limpiar.setEnabled(false);
        btn_limpiar.setMaximumSize(new java.awt.Dimension(45, 45));
        btn_limpiar.setMinimumSize(new java.awt.Dimension(45, 45));
        btn_limpiar.setPreferredSize(new java.awt.Dimension(46, 46));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        ctnButtons.add(btn_limpiar, gridBagConstraints);

        btn_ingresar.setIcon(new javax.swing.ImageIcon("/home/fredy/NetBeansProjects/Entregable/src/img/login.png")); // NOI18N
        btn_ingresar.setPreferredSize(new java.awt.Dimension(46, 46));
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        ctnButtons.add(btn_ingresar, gridBagConstraints);

        pnlPrincipal.add(ctnButtons, new java.awt.GridBagConstraints());

        ctnActions.setOpaque(false);
        ctnActions.setLayout(new java.awt.GridLayout(3, 1, 0, 10));

        btn_cancelar.setBackground(new java.awt.Color(218, 51, 39));
        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setEnabled(false);
        btn_cancelar.setPreferredSize(new java.awt.Dimension(103, 35));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        ctnActions.add(btn_cancelar);

        btn_borrar.setBackground(new java.awt.Color(202, 187, 42));
        btn_borrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_borrar.setText("Borrar");
        btn_borrar.setEnabled(false);
        btn_borrar.setPreferredSize(new java.awt.Dimension(103, 35));
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });
        ctnActions.add(btn_borrar);

        btn_confirmar.setBackground(new java.awt.Color(14, 122, 58));
        btn_confirmar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_confirmar.setText("Confirmar");
        btn_confirmar.setEnabled(false);
        btn_confirmar.setMinimumSize(new java.awt.Dimension(103, 30));
        btn_confirmar.setPreferredSize(new java.awt.Dimension(103, 35));
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarActionPerformed(evt);
            }
        });
        ctnActions.add(btn_confirmar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        pnlPrincipal.add(ctnActions, gridBagConstraints);

        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        pnlPrincipal.add(jPanel7, gridBagConstraints);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/credit_card.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ctnOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(ctnOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_depositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_depositoActionPerformed
        optionCashier = Options.Deposit;
        onChangeCashierScreen();
    }//GEN-LAST:event_btn_depositoActionPerformed

    private void btn_cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cashActionPerformed
        JOptionPane.showMessageDialog(null, "Cash: S/ " + cajero.getCash(cash));
    }//GEN-LAST:event_btn_cashActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        input_monto.setText("");
        optionCashier = Options.Home;
        onChangeCashierScreen();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        input_monto.setText("");
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        String txtMonto = input_monto.getText();
        System.out.println("Texto: " + txtMonto);
        if(!txtMonto.isEmpty()) {
            System.out.println("Entrando a la condicional");
            txtMonto = txtMonto.substring(0, txtMonto.length() - 1);
            System.out.println("Resultado: " + txtMonto);
            input_monto.setText(txtMonto);
        }
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmarActionPerformed
        mount = Double.parseDouble(input_monto.getText());
        String typeTransaction = "Retiro";
        switch(optionCashier){
            case Deposit -> {
                if(mount > 0){
                    cash = cajero.Depositar(cash, mount);
                    JOptionPane.showMessageDialog(null, "DEPÓSITO EXITOSO!");
                } else{
                    JOptionPane.showMessageDialog(null, "INTRODUCE VALORES POSITIVOS!");
                }
                typeTransaction = "Deposito";
            }
            case Retreat -> {
                if(cash >= mount){
                    cash = cajero.Retirar(cash, mount);
                    JOptionPane.showMessageDialog(null, "RETIRO EXITOSO!");
                } else{
                    JOptionPane.showMessageDialog(null, "NO PUEDES RETIRAR MÁS DE TU SALDO ACTUAL");
                }
            }
        }
        //Agregar a historial
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");;
        String fecha = dateFormat.format(LocalDateTime.now());
        modelRecord.addRow(new Object[] {typeTransaction, mount, fecha});
        //Actualizar cajero
        input_monto.setText("");
        optionCashier = Options.Home;
        onChangeCashierScreen();
    }//GEN-LAST:event_btn_confirmarActionPerformed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        try{   
            user = JOptionPane.showInputDialog("User: ");
            cash = Double.parseDouble(JOptionPane.showInputDialog("Cash: "));
            if(user.isEmpty()) {
                throw new Exception("El campo usuario esta vacio.");
            }
            optionCashier = Options.Home;
            onChangeCashierScreen();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese datos validos!\n Vuelva a intentarlo");
        }
    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void btn_deposito1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deposito1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deposito1ActionPerformed

    private void btn_retiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retiroActionPerformed
        optionCashier = Options.Retreat;
        onChangeCashierScreen();
    }//GEN-LAST:event_btn_retiroActionPerformed

    private void btn_historialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_historialActionPerformed
        optionCashier = Options.Record;
        onChangeCashierScreen();
    }//GEN-LAST:event_btn_historialActionPerformed

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
            java.util.logging.Logger.getLogger(CajeroForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CajeroForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CajeroForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CajeroForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CajeroForms().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_0;
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_8;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_cash;
    private javax.swing.JButton btn_confirmar;
    private javax.swing.JButton btn_deposito;
    private javax.swing.JButton btn_deposito1;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_historial;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_retiro;
    private javax.swing.JPanel ctnActions;
    private javax.swing.JPanel ctnButtons;
    private javax.swing.JPanel ctnOptions;
    private javax.swing.JLabel img_persona;
    private javax.swing.JTextField input_monto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel label_msg;
    private javax.swing.JLabel label_msg2;
    private javax.swing.JLabel label_user;
    private javax.swing.JPanel pnlPantalla;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
