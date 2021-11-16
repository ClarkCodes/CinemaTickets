package visual;
// Imports
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import control.AdmSettings;
import data.DatosTickets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/** Settings Window 
 * @author Clark - ClarkCodes 
 * @see control.AdmSettings
 * @since 1.4
 */
public class FrmDialogPreferencias extends javax.swing.JDialog 
{
    // A return status code - returned if Cancel button has been pressed
    public static final int RET_CANCEL = 0;
    // A return status code - returned if OK button has been pressed     
    public static final int RET_OK = 1;
    // The returnStatus variable which is return with the status code
    private int returnStatus = RET_CANCEL;
    
    // Fields, Attributes - Properties
    DatosTickets datosTickets = DatosTickets.getDatosTickets();
    private String dataInputMode, currentSelectedGuiLafTheme, currentAppliedGuiLafTheme;
    private boolean applyingThemePending;
    
    private enum DataInputMode
    {
        stored,
        manual
    }
    
    // AdmSettings
    AdmSettings admSettings = AdmSettings.getAdmSettings();
    
    public FrmDialogPreferencias(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        // Preferencias
        this.dataInputMode = datosTickets.getUserProperties().getProperty("dataInputMode");
        this.currentSelectedGuiLafTheme = datosTickets.getUserProperties().getProperty("currentGuiLafTheme");
        this.currentAppliedGuiLafTheme = currentSelectedGuiLafTheme;
        this.applyingThemePending = false;
        this.setIconImage(admSettings.getSettingsIconForSettingsForm().getImage());
        
        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        
        actionMap.put(cancelName, new AbstractAction() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                doClose(RET_CANCEL);
            }
        });
    }
    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() 
    {
        return returnStatus;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btgIngresoCliente = new javax.swing.ButtonGroup();
        btgTemaLaf = new javax.swing.ButtonGroup();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rdbManual = new javax.swing.JRadioButton();
        rdbStored = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        rbtFlatLaf = new javax.swing.JRadioButton();
        cmbFlatLaf = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        rbtIntelliJ = new javax.swing.JRadioButton();
        cmbIntelliJ = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        labelLafPreview = new javax.swing.JLabel();
        buttonApply = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Preferencias");
        setIconImage(null);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                closeDialog(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        okButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        okButton.setText("Aceptar");
        okButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modo de ingreso de Cliente:");

        btgIngresoCliente.add(rdbManual);
        rdbManual.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdbManual.setText("Ingreso Manual");
        rdbManual.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rdbManualActionPerformed(evt);
            }
        });

        btgIngresoCliente.add(rdbStored);
        rdbStored.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdbStored.setSelected(true);
        rdbStored.setText("Datos Almacenados");
        rdbStored.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rdbStoredActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addComponent(rdbManual)
                .addGap(18, 18, 18)
                .addComponent(rdbStored)
                .addGap(182, 182, 182))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbManual)
                    .addComponent(rdbStored))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(387, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Generales", jPanel2);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Temas de la Interfaz Grafica");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FlatLaf - Temas Nucleo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(718, 150));

        btgTemaLaf.add(rbtFlatLaf);
        rbtFlatLaf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rbtFlatLaf.setText("Flat Look And Feel:");
        rbtFlatLaf.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbtFlatLafActionPerformed(evt);
            }
        });

        cmbFlatLaf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbFlatLaf.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                cmbFlatLafItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtFlatLaf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(cmbFlatLaf, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtFlatLaf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbFlatLaf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FlatLaf - Temas de la Plataforma IntelliJ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(718, 150));

        btgTemaLaf.add(rbtIntelliJ);
        rbtIntelliJ.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rbtIntelliJ.setText("IntelliJ Look And Feel:");
        rbtIntelliJ.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbtIntelliJActionPerformed(evt);
            }
        });

        cmbIntelliJ.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbIntelliJ.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                cmbIntelliJItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtIntelliJ)
                .addGap(18, 18, 18)
                .addComponent(cmbIntelliJ, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtIntelliJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbIntelliJ, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Previsualización", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLafPreview, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLafPreview, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addContainerGap())
        );

        buttonApply.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        buttonApply.setText("Aplicar Tema");
        buttonApply.setEnabled(false);
        buttonApply.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonApplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(buttonApply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(buttonApply, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Aspecto Visual", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        getRootPane().setDefaultButton(okButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Loads and sets user settings on this settings window to represent the saved settings and make them available to posible change */
    private void settingsSetterOnOpen()
    {
        if(dataInputMode.equalsIgnoreCase(DataInputMode.stored.toString()))
        {
            rdbStored.setSelected(true);
        }
        else
        {
            rdbManual.setSelected(true);
        }
        
        if(currentSelectedGuiLafTheme.compareToIgnoreCase("Flat Dark") == 0 || currentSelectedGuiLafTheme.compareToIgnoreCase("Flat Light") == 0)
        {
            rbtFlatLaf.setSelected(true);
            cmbFlatLaf.setSelectedItem(currentSelectedGuiLafTheme);
        }
        else
        {
            rbtIntelliJ.setSelected(true);
            cmbIntelliJ.setSelectedItem(currentSelectedGuiLafTheme);
        }
        
        previewSetter();
        enabledComponentsManager(); // Set the enabled and disabled controls-components following saved User Settings
    }
    
    /** Saves the changed user settings only if a change had place, this occurs on close /
     * Establece la Preferencias elegidas por el Usuario en el Objeto Properties y también las hace efectivas en la Aplicación al momento
     * @see control.AdmSettings
     */
    private void settingsSetterOnClose()
    {
        applyTheme(); // Aplicando el Tema si es que no se ha aplicado y esta pendiente de ello.
        settingsChangeVerifier();
        
        if(!datosTickets.getUserProperties().getProperty("dataInputMode").equalsIgnoreCase(dataInputMode))
            datosTickets.getUserProperties().setProperty("dataInputMode", dataInputMode);
        
        if(!datosTickets.getUserProperties().getProperty("currentGuiLafTheme").equalsIgnoreCase(currentSelectedGuiLafTheme))
            datosTickets.getUserProperties().setProperty("currentGuiLafTheme", currentSelectedGuiLafTheme);
    }
    /** Verifies if a user setting has ben changed compared with the saved user setting store in the respective {@code Properties} object
     * @see data.DatosTickets
     */
    private void settingsChangeVerifier()
    {   // Setting the Property to store the Properties object later on App Close
        if( (!datosTickets.getUserProperties().getProperty("dataInputMode").equalsIgnoreCase(dataInputMode) |
             !datosTickets.getUserProperties().getProperty("currentGuiLafTheme").equalsIgnoreCase(currentSelectedGuiLafTheme)) && 
             !datosTickets.isUserSettingsChanged() )
        {
            datosTickets.setUserSettingsChanged(true);
        }
    }
    
    /** Sets the preview Look and Feel image to check how the selected theme looks */
    private void previewSetter()
    {
        labelLafPreview.setIcon( new ImageIcon( this.getClass().getResource("/themes_previews/preview_" + currentSelectedGuiLafTheme + ".png") ) );
    }
    
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        settingsSetterOnClose();
        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if( !datosTickets.getUserProperties().getProperty("currentGuiLafTheme").equalsIgnoreCase(currentAppliedGuiLafTheme) )
            gettingBackToSavedTheme();
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes this dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void rbtFlatLafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtFlatLafActionPerformed
        enabledComponentsManager();
        themeChooser();
    }//GEN-LAST:event_rbtFlatLafActionPerformed

    private void rbtIntelliJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtIntelliJActionPerformed
        enabledComponentsManager();
        themeChooser();
    }//GEN-LAST:event_rbtIntelliJActionPerformed
    /** Manages the components that must be enabled and disabled */
    private void enabledComponentsManager()
    {
        if(rbtFlatLaf.isSelected())
        {
            rbtFlatLaf.requestFocus();
            cmbFlatLaf.setEnabled(true);
            cmbIntelliJ.setEnabled(false);
        }
        else
        {
            rbtIntelliJ.requestFocus();
            cmbIntelliJ.setEnabled(true);
            cmbFlatLaf.setEnabled(false);
        }
    }
    /** Selects a theme from the respective {@code JComboBox} themes list, either FlatLaf or IntelliJ, let a user see
     * a preview of that theme and make it ready to appy for the user to decide */
    private void themeChooser()
    {
        currentSelectedGuiLafTheme = switch((rbtFlatLaf.isSelected() ? "true" : "false"))
        {
            case "true" -> cmbFlatLaf.getSelectedItem().toString();
            default -> cmbIntelliJ.getSelectedItem().toString();
        };
        applyPendingVerifier();
        previewSetter();
    }
    
    /** Verifies if is there a theme ready to apply but it has not been applied yet */
    private void applyPendingVerifier()
    {
        if(!currentAppliedGuiLafTheme.equalsIgnoreCase(currentSelectedGuiLafTheme))
        {
            this.applyingThemePending = true;
            buttonApply.setEnabled(true);
        }
        else
        {
            this.applyingThemePending = false;
            buttonApply.setEnabled(false);
        }
    }
    
    /** Applies a selected theme if it is not the same as current
     * @see control.AdmSettings
     */
    private void applyTheme()
    {
        if(isApplyingThemePending())
        {
            FlatAnimatedLafChange.showSnapshot(); // Preparing to Make a Soft Transition
            admSettings.applyThemeManager(currentSelectedGuiLafTheme); // Making the Call to apply the theme
            admSettings.colorOnIconsManager(AdmSettings.ColorSetType.Runtime);
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
            currentAppliedGuiLafTheme = currentSelectedGuiLafTheme;
            applyPendingVerifier();
        }
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        admSettings.fillFlatLafCombo(cmbFlatLaf);
        admSettings.fillIntelliJCombo(cmbIntelliJ);
        settingsSetterOnOpen();
    }//GEN-LAST:event_formWindowOpened

    private void rdbManualActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rdbManualActionPerformed
    {//GEN-HEADEREND:event_rdbManualActionPerformed
        dataInputMode = DataInputMode.manual.toString();
    }//GEN-LAST:event_rdbManualActionPerformed

    private void rdbStoredActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rdbStoredActionPerformed
    {//GEN-HEADEREND:event_rdbStoredActionPerformed
        dataInputMode = DataInputMode.stored.toString();
    }//GEN-LAST:event_rdbStoredActionPerformed

    private void cmbFlatLafItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_cmbFlatLafItemStateChanged
    {//GEN-HEADEREND:event_cmbFlatLafItemStateChanged
        if(this.isVisible() & rbtFlatLaf.isSelected() & cmbFlatLaf.getSelectedItem() != null & currentSelectedGuiLafTheme != null & !currentSelectedGuiLafTheme.equalsIgnoreCase(cmbFlatLaf.getSelectedItem().toString()))
            themeChooser();
    }//GEN-LAST:event_cmbFlatLafItemStateChanged

    private void cmbIntelliJItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_cmbIntelliJItemStateChanged
    {//GEN-HEADEREND:event_cmbIntelliJItemStateChanged
        if(this.isVisible() & rbtIntelliJ.isSelected() & cmbIntelliJ.getSelectedItem() != null & currentSelectedGuiLafTheme != null & !currentSelectedGuiLafTheme.equalsIgnoreCase(cmbIntelliJ.getSelectedItem().toString()))
            themeChooser();
    }//GEN-LAST:event_cmbIntelliJItemStateChanged

    private void buttonApplyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonApplyActionPerformed
    {//GEN-HEADEREND:event_buttonApplyActionPerformed
        applyTheme();
    }//GEN-LAST:event_buttonApplyActionPerformed

    public boolean isApplyingThemePending()
    {
        return applyingThemePending;
    }
    /** Returns the system to the theme saved in user settings if the user applies the theme but decides to click on cancel button
     * @see control.AdmSettings
     */
    public void gettingBackToSavedTheme() // Method when the user cancel, so he doesn't actually to apply the theme, the operation is reverted and the saved theme in user properties y applied back.
    {
        admSettings.applyThemeManager(datosTickets.getUserProperties().getProperty("currentGuiLafTheme")); // Making the Call to apply the theme
        admSettings.colorOnIconsManager(AdmSettings.ColorSetType.Runtime);
    }
    
    private void doClose(int retStatus) 
    {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgIngresoCliente;
    private javax.swing.ButtonGroup btgTemaLaf;
    private javax.swing.JButton buttonApply;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> cmbFlatLaf;
    private javax.swing.JComboBox<String> cmbIntelliJ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelLafPreview;
    private javax.swing.JButton okButton;
    private javax.swing.JRadioButton rbtFlatLaf;
    private javax.swing.JRadioButton rbtIntelliJ;
    private javax.swing.JRadioButton rdbManual;
    private javax.swing.JRadioButton rdbStored;
    // End of variables declaration//GEN-END:variables
    
}
