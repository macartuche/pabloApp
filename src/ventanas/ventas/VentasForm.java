/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas.ventas;

import controllers.AccountJpaController;
import controllers.BillingJpaController;
import controllers.ClientProviderJpaController;
import controllers.ConfigurationsJpaController;
import controllers.DetailBillingJpaController;
import controllers.ProductJpaController;
import controllers.exceptions.NonexistentEntityException;
import entities.Account;
import entities.Billing;
import entities.ClientProvider;
import entities.Configurations;
import entities.DetailBilling;
import entities.Person;
import entities.Product;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author macbookpro
 */
public class VentasForm extends javax.swing.JDialog implements ActionListener, KeyListener {
    
    static BillingJpaController controller = null;
    static DetailBillingJpaController controllerDetail = null;
    static ClientProviderJpaController controllerClient = null;
    static AccountJpaController controllerAccount = null;
    static ConfigurationsJpaController controllerConfig;
    static ProductJpaController controllerProduct;
//    private List<DetailBilling> details;
    private DetailBilling d;
    private ClientProvider cliente;
    private Configurations config;
    private List<ClientProvider> clients;
    private List<String> list = new ArrayList<>();
    private List<DetailBilling> details;
    private int numSecuencial;
    private String mensaje;

    /**
     * Creates new form VentasForm
     *
     * @param parent
     * @param modal
     */
    public VentasForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public VentasForm(java.awt.Frame parent, boolean modal, Billing b) {
        super(parent, modal);
        initComponents();
        this.billing = b;
        controller = new BillingJpaController();
        controllerDetail = new DetailBillingJpaController();
        controllerClient = new ClientProviderJpaController();
        controllerAccount = new AccountJpaController();
        controllerConfig = new ConfigurationsJpaController();
        controllerProduct = new ProductJpaController();
        fijarEntidad();
        verTabla();
    }
    
    private void verTabla() {
        
        System.out.println("AAA");
        dBTable1.createControlPanel();
        fijarDatos();
//        if (billing.getId() != null) {
//            details = billing.getDetailBillingList();
//            fijarDatos(billing.getDetailBillingList());
//        } else {
//            details = new ArrayList<>();
//            fijarDatos(new ArrayList<DetailBilling>());
//        }

    }
    
    private void fijarDatos() {
        try {
//            resultados.setText("Resultados: " + l.size());
            String methodNames[] = {"getProducto", "getCantidad", "getPrecioUnitario", "getDescuento", "getPrecioTotal"};
//            dBTable1.refreshDataObject(billing.getDetailBillingList(), methodNames);
            dBTable1.refreshDataObject(details, methodNames);
            dBTable1.getColumn(0).setPreferredWidth(100);
            dBTable1.getColumn(1).setPreferredWidth(300);
            dBTable1.getColumn(2).setPreferredWidth(200);
            dBTable1.getColumn(3).setPreferredWidth(100);
            dBTable1.getColumn(4).setPreferredWidth(100);
            calcularTotales();
        } catch (Exception ex) {
            Logger.getLogger(VentasForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fijarEntidad() {
        details = billing.getDetailBillingList();
        if (billing.getId() != null) {
            cliente = billing.getClientProviderid();
            System.out.println("CLIENTE >>> " + cliente.getPersonId().getNames()
                    + " " + cliente.getPersonId().getPassport());
            txtRucCi.setText(cliente.getPersonId().getPassport());
            txtNombres.setText(cliente.getPersonId().getNames() + cliente.getPersonId().getLastname());
            txtDireccion.setText(cliente.getPersonId().getPassport());
            txtTelefono.setText(cliente.getPersonId().getPhone());
            lblSubtotal.setText(billing.getSubtotal().toString());
            lblBaseIva0.setText(billing.getBaseiva0().toString());
//            lblValorIva0.setText(billing.getIva0().toString());
            lblBaseIva12.setText(billing.getBaseiva12().toString());
            lblValorIva12.setText(billing.getIva0().toString());
            lblDescuento.setText(billing.getDiscount().toString());
            lblTotal.setText(billing.getTotal().toString());
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

        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtRucCi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        butonAgregarFila = new javax.swing.JButton();
        txtNombres = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        dBTable1 = new quick.dbtable.DBTable();
        dBTable1.setEditable(false);
        jLabel13 = new javax.swing.JLabel();
        lblBaseIva0 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblValorIva12 = new javax.swing.JLabel();
        lblBaseIva12 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        combito = new javax.swing.JComboBox();
        combito.setEditable(true);
        JTextComponent editor = (JTextComponent) combito.getEditor().getEditorComponent();
        editor.addKeyListener(this);
        combito.addActionListener(this);
        jLabel10 = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();
        btnAgregarCliente = new javax.swing.JButton();

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("0,00");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Factura de venta");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Datos generales");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("RUC/CI: ");

        txtRucCi.setEditable(false);
        txtRucCi.setPreferredSize(new java.awt.Dimension(10, 26));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Nombres:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Dirección:");

        txtDireccion.setEditable(false);
        txtDireccion.setPreferredSize(new java.awt.Dimension(10, 26));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Telf.:");

        txtTelefono.setEditable(false);
        txtTelefono.setPreferredSize(new java.awt.Dimension(10, 26));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Detalle");

        butonAgregarFila.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        butonAgregarFila.setText("Agregar filas");
        butonAgregarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAgregarFilaActionPerformed(evt);
            }
        });

        txtNombres.setEditable(false);
        txtNombres.setPreferredSize(new java.awt.Dimension(10, 26));
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Subtotal:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Total:");

        btnGuardar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Base iva 12%:");

        lblBaseIva0.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblBaseIva0.setText("0,00");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Base iva 0%:");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("IVA 12%:");

        lblSubtotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSubtotal.setText("0,00");

        lblValorIva12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblValorIva12.setText("0,00");

        lblBaseIva12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblBaseIva12.setText("0,00");

        lblTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotal.setText("0,00");

        combito.setPreferredSize(new java.awt.Dimension(37, 26));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Total descuento:");

        lblDescuento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDescuento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDescuento.setText("0,00");

        btnAgregarCliente.setText("Ingresar cliente");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(dBTable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(80, 80, 80))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butonAgregarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(combito, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(42, 42, 42)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRucCi, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 148, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblBaseIva0, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                    .addComponent(lblSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblValorIva12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblBaseIva12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(btnGuardar)
                .addGap(33, 33, 33)
                .addComponent(btnCancelar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(txtRucCi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(dBTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(butonAgregarFila))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblSubtotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBaseIva0)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBaseIva12)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lblValorIva12))))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescuento)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblTotal))))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try {
            
            if (!noValido()) {
                
                if (billing.getId() == null) {
                    
                    System.out.println("INTRO >>> ");
//            controller.create(billing);
//            controller.createBilling(billing);
                    for (DetailBilling db : details) {
                        db.setBillingId(billing);
                    }
                    generarSecuencial();
                    billing.setDetailBillingList(details);
                    controller.createBilling(billing);
                    actualizarSecuencial();
                    actualizarStock();

                    //crear una nueva cta por cobrar
                    Account account = new Account();
                    account.setBillingId(billing);
                    account.setState("Abierta");
                    account.setBalance(billing.getTotal());
                    account.setTotal(billing.getTotal());
                    account.setDateCreation(new Date());
                    
                    controllerAccount.create(account);
                    System.out.println("Paso");
                    this.dispose();
                    
                } else {
                    
                }
                
            } else {
                JOptionPane.showMessageDialog(this, mensaje,
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(VentasForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed
    
    private void generarSecuencial() {
        String secuencial;
        Map<String, Object> variables = new HashMap<>();
        if (controller.getBillingCount() > 0) {
            System.out.println("secuencial act");
            variables.put("code", "SECUENCIAL_ACT");
            config = controllerConfig.namedQuery("Configurations.findByCode", variables).get(0);
            secuencial = config.getValue();
            numSecuencial = Integer.parseInt(secuencial);
            numSecuencial++;
            secuencial = formatoSecuencial(numSecuencial);
            System.out.println("secuencial >>> " + secuencial);
        } else {
            System.out.println("secuencial ini");
            variables.put("code", "SECUENCIAL_INI");
            config = controllerConfig.namedQuery("Configurations.findByCode", variables).get(0);
            secuencial = config.getValue();
            numSecuencial = Integer.parseInt(secuencial);
            numSecuencial++;
            secuencial = formatoSecuencial(numSecuencial);
            System.out.println("secuencial >>> " + secuencial);
        }
        
        billing.setShop_id("001");
        billing.setEmissionpoint_id("001");
        billing.setSequential(secuencial);
        billing.setNumber(billing.getShop_id() + "-" + billing.getEmissionpoint_id() + "-" + billing.getSequential());
        
    }
    
    private String formatoSecuencial(int numero) {
        Formatter fmt = new Formatter();
        fmt.format("%09d", numero);
        System.out.println("El numero formateado " + fmt);
        return fmt.toString();
    }
    
    private void actualizarSecuencial() {
        try {
            Map<String, Object> variables = new HashMap<>();
            variables.put("code", "SECUENCIAL_ACT");
            config = controllerConfig.namedQuery("Configurations.findByCode", variables).get(0);
            config.setValue(String.valueOf(numSecuencial));
            controllerConfig.edit(config);
        } catch (Exception ex) {
            Logger.getLogger(VentasForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void actualizarStock() {
        try {
            BigDecimal nuevoStock;
            Product p;
            for (DetailBilling detail : billing.getDetailBillingList()) {
                p = controllerProduct.findProduct(detail.getProductId().getId());
                nuevoStock = p.getStock().subtract(detail.getQuantity());
                p.setStock(nuevoStock);
                controllerProduct.edit(p);
            }
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(VentasForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VentasForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void butonAgregarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAgregarFilaActionPerformed
        // TODO add your handling code here:
        d = new DetailBilling();
        abrirVentana();
    }//GEN-LAST:event_butonAgregarFilaActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        // TODO add your handling code here:
        
        ClientProvider cp = new ClientProvider();
        cp.setClient(Boolean.TRUE);
        cp.setActiveclient(Boolean.TRUE);
        cp.setProvider(Boolean.FALSE);
        cp.setActiveprovider(Boolean.FALSE);
        cp.setPersonId(new Person());
        cp.getPersonId().setSex("M");
        ClienteForm dialog = new ClienteForm(new javax.swing.JFrame(), true, cp);
        dialog.setVisible(Boolean.TRUE);
        
    }//GEN-LAST:event_btnAgregarClienteActionPerformed
    
    private void abrirVentana() {

//        ItemForm dialog = new ItemForm(new javax.swing.JFrame(), true, d, billing.getDetailBillingList());
        ItemForm dialog = new ItemForm(new javax.swing.JFrame(), true, d, details);
        dialog.setVisible(Boolean.TRUE);

//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                final ItemForm dialog = new ItemForm(new javax.swing.JFrame(), true, d, details);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        dialog.dispose();
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
        System.out.println("SSSSSSSSSSSSS");
        fijarDatos();
        
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentasForm dialog = new VentasForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private Billing billing;
    
    public Billing getBilling() {
        return billing;
    }
    
    public void setBilling(Billing billing) {
        this.billing = billing;
    }
    
    @SuppressWarnings("UnusedAssignment")
    private void calcularTotales() {
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal descuento = BigDecimal.ZERO;
        BigDecimal subTotal = BigDecimal.ZERO;
        BigDecimal baseIva12 = BigDecimal.ZERO;
        BigDecimal iva12 = BigDecimal.ZERO;
        BigDecimal baseIva0 = BigDecimal.ZERO;
        BigDecimal iva0 = BigDecimal.ZERO;

//        for (DetailBilling detail : billing.getDetailBillingList()) {
        for (DetailBilling detail : details) {
            subTotal = subTotal.add(detail.getTotal());
            descuento = descuento.add(detail.getValueDiscount());
            System.out.println("PORCENTAJE IVA >> " + detail.getPercentageIva());
            if (detail.getPercentageIva().compareTo(BigDecimal.ZERO) == 0) {
                System.out.println("iva 0");
                baseIva0 = baseIva0.add(detail.getTotal());
            } else {
                System.out.println("iva 12");
                baseIva12 = baseIva12.add(detail.getTotal());
                iva12 = iva12.add(detail.getValueIva());
            }
        }
        total = subTotal.add(iva12);
        
        billing.setType("FACTURA");
        billing.setState("GENERADA");
        billing.setSubtotal(subTotal);
        billing.setBaseiva0(baseIva0);
        billing.setIva0(iva0);
        billing.setBaseiva12(baseIva12);
        billing.setIva12(iva12);
        billing.setPercentageDiscount(BigDecimal.ZERO);
        billing.setDiscount(descuento);
        billing.setTotal(total);
        billing.setNumber(null);
        billing.setSequential(null);
        billing.setEmissionpoint_id(null);
        billing.setShop_id(null);
        
        lblSubtotal.setText(subTotal.toString());
        lblBaseIva0.setText(baseIva0.toString());
//        lblValorIva0.setText(iva0.toString());
        lblBaseIva12.setText(baseIva12.toString());
        lblValorIva12.setText(iva12.toString());
        lblDescuento.setText(descuento.toString());
        lblTotal.setText(total.toString());
        
    }
    
    private boolean noValido() {
        Boolean error = Boolean.FALSE;
//        StringBuilder mensaje = new StringBuilder();

        if (billing.getClientProviderid() == null) {
            error = Boolean.TRUE;
            mensaje = "- Seleccione un cliente. \n";
            return error;
        }
        
        if (billing.getDetailBillingList().isEmpty()) {
            error = Boolean.TRUE;
            mensaje = "- Agregue al menos un detalle a la factura. \n";
            return error;
        }
        
        return error;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton butonAgregarFila;
    private javax.swing.JComboBox combito;
    private static quick.dbtable.DBTable dBTable1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBaseIva0;
    private javax.swing.JLabel lblBaseIva12;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblValorIva12;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtRucCi;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("AQUI YEA >>>");
        System.out.println(">>> " + combito.getSelectedIndex());
        int clienteSel = combito.getSelectedIndex();
        if (clienteSel != -1) {
            cliente = clients.get(clienteSel);
            billing.setClientProviderid(cliente);
            System.out.println("CLIENTE >>> " + cliente.getPersonId().getNames()
                    + " " + cliente.getPersonId().getPassport());
            txtRucCi.setText(cliente.getPersonId().getPassport());
            txtNombres.setText(cliente.getPersonId().getNames() + cliente.getPersonId().getLastname());
            txtDireccion.setText(cliente.getPersonId().getPassport());
            txtTelefono.setText(cliente.getPersonId().getPhone());
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("released");
        String text = ((JTextField) e.getSource()).getText();
        System.out.println("texto >>> " + text);
        try {
            if (text.equals("")) {
                System.out.println("no data");
                combito.setModel(getSuggestedModel(new Vector(), ""));
            } else {
                System.out.println("data");
                buscarClientes(text);
                setSuggestionModel(combito, getModelComboBox(list), text);
                combito.showPopup();
            }
        } catch (Exception ex) {
        }
    }
    
    private void buscarClientes(String criterio) {
        System.out.println("INTRO BUSCAR >>>");
        if (!criterio.trim().isEmpty()) {
            System.out.println("+++");
            Map<String, Object> variables = new HashMap<>();
            variables.put("criteria", criterio.toLowerCase() + "%");
            System.out.println("---");
            clients = controllerClient.namedQuery("ClientProvider.findByNamesOrPassport", variables);
            System.out.println("***");
            System.out.println("CLIENTES >>> " + clients.size());
            list = listaClientes(clients);
        }
    }
    
    public final List<String> listaClientes(List<ClientProvider> lis) {
        List<String> result = new ArrayList<>();
        String var;
        if (lis != null) {
            for (ClientProvider cp : lis) {
                var = cp.getPersonId().getNames() + " " + cp.getPersonId().getLastname() + " " + cp.getPersonId().getPassport();
                result.add(var);
            }
        }
        return result;
    }
    
    private static void setSuggestionModel(JComboBox comboBox, ComboBoxModel mdl, String str) {
        comboBox.setModel(mdl);
        comboBox.setSelectedIndex(-1);
        ((JTextField) comboBox.getEditor().getEditorComponent()).setText(str);
    }
    
    private static ComboBoxModel getSuggestedModel(Vector list, String text) {
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        for (Object obj : list) {
            String s = (String) obj;
            if (s.toUpperCase().contains(text.toUpperCase())) {
                m.addElement(s);
            }
        }
        return m;
    }
    
    private static ComboBoxModel getModelComboBox(List<String> list) {
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        for (String val : list) {
            m.addElement(val);
        }
        return m;
    }
    
}
