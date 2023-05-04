
package visual;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import control.AdmSettings;
import data.DatosTickets;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Locale;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import control.Commons;

/** Settings Window
 *
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

    // Adms
    private final DatosTickets datosTickets;
    private final AdmSettings admSettings;

    public FrmDialogPreferencias ( java.awt.Frame parent, boolean modal )
    {
        super( parent, modal );
        initComponents();
        this.setLocationRelativeTo( null );
        datosTickets = DatosTickets.getDatosTickets();
        admSettings = AdmSettings.getAdmSettings();
        this.setIconImage( admSettings.getSettingsIconForSettingsForm().getImage() );

        // Close the dialog when Esc is pressed
        String cancelName = java.util.ResourceBundle.getBundle( "internationalization/Internationalization_Bundle" ).getString( "lk_cancel" );
        InputMap inputMap = getRootPane().getInputMap( JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT );
        inputMap.put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), cancelName );
        ActionMap actionMap = getRootPane().getActionMap();

        actionMap.put( cancelName, new AbstractAction()
        {
            public void actionPerformed ( ActionEvent e )
            {
                doClose( RET_CANCEL );
            }
        } );
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus ()
    {
        return returnStatus;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btgIngresoCliente = new javax.swing.ButtonGroup();
        btgTemaLaf = new javax.swing.ButtonGroup();
        btgAppData = new javax.swing.ButtonGroup();
        btgFileType = new javax.swing.ButtonGroup();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabPanelGenerals = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        rdbClientInputManual = new javax.swing.JRadioButton();
        rdbClientInputStored = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        rdbAppDataManual = new javax.swing.JRadioButton();
        rdbAppDataStored = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbAppLanguage = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        rdbFileTypeText = new javax.swing.JRadioButton();
        rdbFileTypeBinary = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtStartingFolder = new javax.swing.JTextField();
        btnSelectFolder = new javax.swing.JButton();
        btnValueByDefault = new javax.swing.JButton();
        tabPanelLaf = new javax.swing.JPanel();
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
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("internationalization/Internationalization_Bundle"); // NOI18N
        setTitle(bundle.getString("lk_settings")); // NOI18N
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
        okButton.setText(bundle.getString("lk_ok")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cancelButton.setText(bundle.getString("lk_cancel")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelButtonActionPerformed(evt);
            }
        });

        jTabbedPane1.setFocusable(false);

        tabPanelGenerals.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabPanelGenerals.addComponentListener(new java.awt.event.ComponentAdapter()
        {
            public void componentShown(java.awt.event.ComponentEvent evt)
            {
                tabPanelGeneralsComponentShown(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("lk_settings_client_input_mode_label"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        btgIngresoCliente.add(rdbClientInputManual);
        rdbClientInputManual.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdbClientInputManual.setText(bundle.getString("lk_settings_manual_input")); // NOI18N

        btgIngresoCliente.add(rdbClientInputStored);
        rdbClientInputStored.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdbClientInputStored.setText(bundle.getString("lk_settings_stored_data")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(rdbClientInputManual)
                .addGap(18, 18, 18)
                .addComponent(rdbClientInputStored)
                .addContainerGap(209, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbClientInputManual)
                    .addComponent(rdbClientInputStored))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("lk_settings_app_data"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        btgAppData.add(rdbAppDataManual);
        rdbAppDataManual.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdbAppDataManual.setText(bundle.getString("lk_settings_manual_input")); // NOI18N
        rdbAppDataManual.setEnabled(false);

        btgAppData.add(rdbAppDataStored);
        rdbAppDataStored.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdbAppDataStored.setText(bundle.getString("lk_settings_stored_data")); // NOI18N
        rdbAppDataStored.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(rdbAppDataManual)
                .addGap(18, 18, 18)
                .addComponent(rdbAppDataStored)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbAppDataManual)
                    .addComponent(rdbAppDataStored))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("lk_settings_app_language"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText(bundle.getString("lk_settings_use_app_in_label")); // NOI18N

        cmbAppLanguage.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmbAppLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbAppLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("lk_settings_file_type_title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        btgFileType.add(rdbFileTypeText);
        rdbFileTypeText.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdbFileTypeText.setText(bundle.getString("lk_settings_file_type_text")); // NOI18N

        btgFileType.add(rdbFileTypeBinary);
        rdbFileTypeBinary.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdbFileTypeBinary.setText(bundle.getString("lk_settings_file_type_binary")); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(rdbFileTypeText)
                .addGap(18, 18, 18)
                .addComponent(rdbFileTypeBinary)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbFileTypeText)
                    .addComponent(rdbFileTypeBinary))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("lk_settings_starting_folder_title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText(bundle.getString("lk_settings_starting_folder_msj")); // NOI18N

        txtStartingFolder.setEditable(false);
        txtStartingFolder.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        btnSelectFolder.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnSelectFolder.setText(bundle.getString("lk_settings_select")); // NOI18N
        btnSelectFolder.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSelectFolderActionPerformed(evt);
            }
        });

        btnValueByDefault.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnValueByDefault.setText(bundle.getString("lk_settings_value_by_default")); // NOI18N
        btnValueByDefault.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnValueByDefaultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtStartingFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelectFolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnValueByDefault, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnSelectFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnValueByDefault, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStartingFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabPanelGeneralsLayout = new javax.swing.GroupLayout(tabPanelGenerals);
        tabPanelGenerals.setLayout(tabPanelGeneralsLayout);
        tabPanelGeneralsLayout.setHorizontalGroup(
            tabPanelGeneralsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabPanelGeneralsLayout.setVerticalGroup(
            tabPanelGeneralsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPanelGeneralsLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab(bundle.getString("lk_settings_generals"), tabPanelGenerals); // NOI18N

        tabPanelLaf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabPanelLaf.addComponentListener(new java.awt.event.ComponentAdapter()
        {
            public void componentShown(java.awt.event.ComponentEvent evt)
            {
                tabPanelLafComponentShown(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(bundle.getString("lk_settings_laf_themes")); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("lk_settings_flatlaf_core_themes"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(718, 150));

        btgTemaLaf.add(rbtFlatLaf);
        rbtFlatLaf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rbtFlatLaf.setText(bundle.getString("lk_flat_laf_label")); // NOI18N
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

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("lk_settings_intellij_themes"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(718, 150));

        btgTemaLaf.add(rbtIntelliJ);
        rbtIntelliJ.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rbtIntelliJ.setText(bundle.getString("lk_intellij_laf")); // NOI18N
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

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("lk_settings_preview"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

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
        buttonApply.setText(bundle.getString("lk_settings_apply_theme")); // NOI18N
        buttonApply.setEnabled(false);
        buttonApply.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonApplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabPanelLafLayout = new javax.swing.GroupLayout(tabPanelLaf);
        tabPanelLaf.setLayout(tabPanelLafLayout);
        tabPanelLafLayout.setHorizontalGroup(
            tabPanelLafLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPanelLafLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(tabPanelLafLayout.createSequentialGroup()
                .addGroup(tabPanelLafLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(buttonApply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabPanelLafLayout.setVerticalGroup(
            tabPanelLafLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPanelLafLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabPanelLafLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tabPanelLafLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(buttonApply, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab(bundle.getString("lk_settings_visual_appereance"), tabPanelLaf); // NOI18N

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        getRootPane().setDefaultButton(okButton);
        jTabbedPane1.getAccessibleContext().setAccessibleName(bundle.getString("lk_settings_laf")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Loads and sets user settings on this settings window to represent the
     * saved settings and make them available to posible change 
     */
    private void settingsSetterOnOpen ()
    {
        if ( admSettings.getClientDataMode() == AdmSettings.DataMode.Stored )
        {
            rdbClientInputStored.setSelected( true );
        }
        else
        {
            rdbClientInputManual.setSelected( true );
        }

        if ( admSettings.getAppDataMode() == AdmSettings.DataMode.Stored )
        {
            rdbAppDataStored.setSelected( true );
        }
        else
        {
            rdbAppDataManual.setSelected( true );
        }
        
        if ( admSettings.getFileTypeToSave() == Commons.FileType.Text )
        {
            rdbFileTypeText.setSelected( true );
        }
        else
        {
            rdbFileTypeBinary.setSelected( true );
        }

        if ( admSettings.getCurrentSelectedGuiLafTheme().compareToIgnoreCase( "Flat Dark" ) == 0 || admSettings.getCurrentSelectedGuiLafTheme().compareToIgnoreCase( "Flat Light" ) == 0 )
        {
            rbtFlatLaf.setSelected( true );
            cmbFlatLaf.setSelectedItem( admSettings.getCurrentSelectedGuiLafTheme() );
        }
        else
        {
            rbtIntelliJ.setSelected( true );
            cmbIntelliJ.setSelectedItem( admSettings.getCurrentSelectedGuiLafTheme() );
        }
        
        txtStartingFolder.setText( admSettings.getStartingFolder() );

        cmbAppLanguage.setSelectedItem( AdmSettings.getAppLanguage().toString() );

        previewSetter();
        enabledComponentsManager(); // Set the enabled and disabled controls-components following saved User Settings
        tabGeneralsInitialFocus();
    }

    /** Sets and Saves the changed user settings only if a change had place, 
     * this occurs on close when clicking on Ok button /
     *
     * @see control.AdmSettings
     */
    private void settingsSetterOnClose ()
    {
        applyTheme(); // Aplicando el Tema si es que no se ha aplicado y esta pendiente de ello.
        
        // Verification and set on Settings in AdmSettings
        // Client Mode
        if( rdbClientInputManual.isSelected() )
        {
            if( admSettings.getClientDataMode() != AdmSettings.DataMode.valueOfLocalizedString( rdbClientInputManual.getText() ) )
            {   
                admSettings.setClientDataMode( AdmSettings.DataMode.Manual.toString() );
            }
        }
        else
        {
            if ( admSettings.getClientDataMode() != AdmSettings.DataMode.valueOfLocalizedString( rdbClientInputStored.getText() ) )
            {
                admSettings.setClientDataMode( AdmSettings.DataMode.Stored.toString() );
            }
        }
        
        // App Data Mode
        if( rdbAppDataManual.isSelected() )
        {
            if( admSettings.getAppDataMode() != AdmSettings.DataMode.valueOfLocalizedString( rdbAppDataManual.getText() ) )
            {   
                admSettings.setAppDataMode( AdmSettings.DataMode.Manual.toString() );
            }
        }
        else
        {
            if ( admSettings.getAppDataMode() != AdmSettings.DataMode.valueOfLocalizedString( rdbAppDataStored.getText() ) )
            {
                admSettings.setAppDataMode( AdmSettings.DataMode.Stored.toString() );
            }
        }
        
        // File Type to Save
        if( rdbFileTypeBinary.isSelected() )
        {
            if( admSettings.getFileTypeToSave() != Commons.FileType.valueOfLocalizedString( rdbFileTypeBinary.getText() ) )
            {   
                admSettings.setFileTypeToSave( Commons.FileType.Binary.toString() );
            }
        }
        else
        {
            if ( admSettings.getFileTypeToSave() != Commons.FileType.valueOfLocalizedString( rdbFileTypeText.getText() ) )
            {
                admSettings.setFileTypeToSave( Commons.FileType.Text.toString() );
            }
        }
        
        // Language
        if ( !AdmSettings.getAppLanguage().toString().equalsIgnoreCase( cmbAppLanguage.getSelectedItem().toString() ) )
            AdmSettings.setAppLanguage( cmbAppLanguage.getSelectedItem().toString() );

        // Verification and Saving on the user Properties object
        datosTickets.settingsChangeVerifier();

        if ( !datosTickets.getUserProperties().getProperty( "currentGuiLafTheme" ).equalsIgnoreCase( admSettings.getCurrentSelectedGuiLafTheme() ) ) //NOI18N
            datosTickets.getUserProperties().setProperty( "currentGuiLafTheme", admSettings.getCurrentSelectedGuiLafTheme() ); //NOI18N
        
        if ( !datosTickets.getUserProperties().getProperty( "clientDataMode" ).equalsIgnoreCase( admSettings.getClientDataMode().toString() ) )
            datosTickets.getUserProperties().setProperty( "clientDataMode", admSettings.getClientDataMode().toString() );

        if ( !datosTickets.getUserProperties().getProperty( "appDataMode" ).equalsIgnoreCase( admSettings.getAppDataMode().toString() ) )
            datosTickets.getUserProperties().setProperty( "appDataMode", admSettings.getAppDataMode().toString() );
        
        if ( !datosTickets.getUserProperties().getProperty( "fileTypeToSave" ).equalsIgnoreCase( admSettings.getFileTypeToSave().toString().toLowerCase() ) )
            datosTickets.getUserProperties().setProperty( "fileTypeToSave", admSettings.getFileTypeToSave().toString().toLowerCase() );
        
        if ( !datosTickets.getUserProperties().getProperty( "startingFolder" ).equalsIgnoreCase( admSettings.getStartingFolder() ) )
        {
            datosTickets.getUserProperties().setProperty( "startingFolder", admSettings.getStartingFolder() );
            datosTickets.dialogDirectorySetter();
        }
        
        if ( !datosTickets.getUserProperties().getProperty( "appLocale" ).equalsIgnoreCase( AdmSettings.getAppLanguage().getLocale().toLanguageTag().replace( "-", "_") ) ) //NOI18N
        {
            datosTickets.getUserProperties().setProperty( "appLocale", AdmSettings.getAppLanguage().getLocale().toLanguageTag().replace( "-", "_") ); //NOI18N
            admSettings.applyLanguageInApp();
        }

    }

    /** Sets the preview Look and Feel image on its component to check how the 
     * selected theme looks on
     * @see control.AdmSettings
     */
    private void previewSetter ()
    {
        labelLafPreview.setIcon( new ImageIcon( this.getClass().getResource( "/themes_previews/preview_" + admSettings.getCurrentSelectedGuiLafTheme() + ".png" ) ) ); //NOI18N
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        settingsSetterOnClose();
        doClose( RET_OK );
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if ( !datosTickets.getUserProperties().getProperty( "currentGuiLafTheme" ).equalsIgnoreCase( admSettings.getCurrentAppliedGuiLafTheme() ) ) //NOI18N
            admSettings.gettingBackToSavedTheme( datosTickets.getUserProperties().getProperty( "currentGuiLafTheme" ) ); //NOI18N
        
        if ( !datosTickets.getUserProperties().getProperty( "clientDataMode" ).equalsIgnoreCase( admSettings.getClientDataMode().toString() ) )
            admSettings.setClientDataMode( datosTickets.getUserProperties().getProperty( "clientDataMode" ) );

        if ( !datosTickets.getUserProperties().getProperty( "appDataMode" ).equalsIgnoreCase( admSettings.getAppDataMode().toString() ) )
            admSettings.setAppDataMode( datosTickets.getUserProperties().getProperty( "appDataMode" ) );

        if ( !datosTickets.getUserProperties().getProperty( "appLocale" ).equalsIgnoreCase( AdmSettings.getAppLanguage().getLocale().toLanguageTag().replace( "-", "_") ) ) //NOI18N
            AdmSettings.setAppLanguage( datosTickets.getUserProperties().getProperty( "appLocale" ) );
        
        if ( !datosTickets.getUserProperties().getProperty( "fileTypeToSave" ).equalsIgnoreCase( admSettings.getFileTypeToSave().toString().toLowerCase() ) )
            admSettings.setFileTypeToSave( datosTickets.getUserProperties().getProperty( "fileTypeToSave" ) );
        
        if ( !datosTickets.getUserProperties().getProperty( "startingFolder" ).equalsIgnoreCase( admSettings.getStartingFolder() ) )
            admSettings.setStartingFolder( datosTickets.getUserProperties().getProperty( "startingFolder" ) );
        
        doClose( RET_CANCEL );
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes this dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose( RET_CANCEL );
    }//GEN-LAST:event_closeDialog

    private void rbtFlatLafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtFlatLafActionPerformed
        enabledComponentsManager();
        themeChooser();
    }//GEN-LAST:event_rbtFlatLafActionPerformed

    private void rbtIntelliJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtIntelliJActionPerformed
        enabledComponentsManager();
        themeChooser();
    }//GEN-LAST:event_rbtIntelliJActionPerformed
    /** Manages themes related components that must be enabled and disabled
     *  following {@code rbtFlatLaf} component selected state, this indicates 
     * what group of themes are chosen by user
     */
    private void enabledComponentsManager ()
    {
        if ( rbtFlatLaf.isSelected() )
        {
            rbtFlatLaf.requestFocus();
            cmbFlatLaf.setEnabled( true );
            cmbIntelliJ.setEnabled( false );
        }
        else
        {
            rbtIntelliJ.requestFocus();
            cmbIntelliJ.setEnabled( true );
            cmbFlatLaf.setEnabled( false );
        }
    }

    /** Selects a theme from the respective {@code JComboBox} themes list,
     * either FlatLaf or IntelliJ, let a user see a preview of that theme and 
     * make it ready to appy for the user to decide 
     * @see control.AdmSettings
     */
    private void themeChooser ()
    {
        admSettings.setCurrentSelectedGuiLafTheme( switch ( ( rbtFlatLaf.isSelected() ? "true" : "false" ) ) //NOI18N
        {
            case "true" -> cmbFlatLaf.getSelectedItem().toString(); //NOI18N
            default -> cmbIntelliJ.getSelectedItem().toString();
        } );
        applyPendingVerifier();
        previewSetter();
    }

    /** Verifies if there is a theme ready to apply but it has not been applied
     * yet 
     */
    private void applyPendingVerifier ()
    {
        if ( !admSettings.getCurrentAppliedGuiLafTheme().equalsIgnoreCase( admSettings.getCurrentSelectedGuiLafTheme() ) )
        {
            admSettings.setApplyingThemePending( true );
            buttonApply.setEnabled( true );
        }
        else
        {
            admSettings.setApplyingThemePending( false );
            buttonApply.setEnabled( false );
        }
    }

    /** Applies a selected theme if it is not the current applied theme
     *
     * @see control.AdmSettings
     */
    private void applyTheme ()
    {
        if ( admSettings.isApplyingThemePending() )
        {
            FlatAnimatedLafChange.showSnapshot(); // Preparing to Make a Soft Transition
            admSettings.applyThemeManager( admSettings.getCurrentSelectedGuiLafTheme() ); // Making the Call to apply the theme
            admSettings.colorOnIconsManager( AdmSettings.ColorSetType.Runtime );
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
            admSettings.setCurrentAppliedGuiLafTheme( admSettings.getCurrentSelectedGuiLafTheme() );
            applyPendingVerifier();
        }
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        admSettings.fillLanguagesCombo( cmbAppLanguage );
        admSettings.fillFlatLafCombo( cmbFlatLaf );
        admSettings.fillIntelliJCombo( cmbIntelliJ );
        settingsSetterOnOpen();
    }//GEN-LAST:event_formWindowOpened

    private void cmbFlatLafItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_cmbFlatLafItemStateChanged
    {//GEN-HEADEREND:event_cmbFlatLafItemStateChanged
        if ( this.isVisible() & rbtFlatLaf.isSelected() & cmbFlatLaf.getSelectedItem() != null & admSettings.getCurrentSelectedGuiLafTheme() != null & !admSettings.getCurrentSelectedGuiLafTheme().equalsIgnoreCase( cmbFlatLaf.getSelectedItem().toString() ) )
            themeChooser();
    }//GEN-LAST:event_cmbFlatLafItemStateChanged

    private void cmbIntelliJItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_cmbIntelliJItemStateChanged
    {//GEN-HEADEREND:event_cmbIntelliJItemStateChanged
        if ( this.isVisible() & rbtIntelliJ.isSelected() & cmbIntelliJ.getSelectedItem() != null & admSettings.getCurrentSelectedGuiLafTheme() != null & !admSettings.getCurrentSelectedGuiLafTheme().equalsIgnoreCase( cmbIntelliJ.getSelectedItem().toString() ) )
            themeChooser();
    }//GEN-LAST:event_cmbIntelliJItemStateChanged

    private void buttonApplyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonApplyActionPerformed
    {//GEN-HEADEREND:event_buttonApplyActionPerformed
        applyTheme();
    }//GEN-LAST:event_buttonApplyActionPerformed

    private void btnSelectFolderActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSelectFolderActionPerformed
    {//GEN-HEADEREND:event_btnSelectFolderActionPerformed
        JFileChooser startingFolderChooser;
        
        if ( admSettings.getStartingFolder().equalsIgnoreCase( "default" ) )
        {
            startingFolderChooser = new JFileChooser();
        }
        else
        {
            startingFolderChooser = new JFileChooser( admSettings.getStartingFolder() );
        }
        
        startingFolderChooser.setPreferredSize( new Dimension( 900, 600 ) );
        startingFolderChooser.setLocale( new Locale ( AdmSettings.getAppLanguage().getLanguage() ) );
        startingFolderChooser.setApproveButtonText( AdmSettings.getLanguageBundle().getString( "lk_settings_just_select" ) );
        startingFolderChooser.setDialogTitle( AdmSettings.getLanguageBundle().getString( "lk_settings_select" ) );
        startingFolderChooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
        startingFolderChooser.setDialogType( JFileChooser.CUSTOM_DIALOG );
        DatosTickets.getOpenSaveFrame().setIconImage( admSettings.getSearchIconForSearchForm().getImage() );
        
        if ( startingFolderChooser.showDialog( DatosTickets.getOpenSaveFrame(), AdmSettings.getLanguageBundle().getString( "lk_settings_just_select" ) ) == JFileChooser.APPROVE_OPTION )
        {
            admSettings.setStartingFolder( startingFolderChooser.getSelectedFile().getAbsolutePath() );
            txtStartingFolder.setText( admSettings.getStartingFolder() );
        }
    }//GEN-LAST:event_btnSelectFolderActionPerformed

    private void btnValueByDefaultActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnValueByDefaultActionPerformed
    {//GEN-HEADEREND:event_btnValueByDefaultActionPerformed
        if ( !admSettings.getStartingFolder().equalsIgnoreCase( "default" ) )
            admSettings.setStartingFolder( "default" );
        
        txtStartingFolder.setText( admSettings.getStartingFolder() );
    }//GEN-LAST:event_btnValueByDefaultActionPerformed

    private void tabPanelGeneralsComponentShown(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_tabPanelGeneralsComponentShown
    {//GEN-HEADEREND:event_tabPanelGeneralsComponentShown
        tabGeneralsInitialFocus();
    }//GEN-LAST:event_tabPanelGeneralsComponentShown

    private void tabPanelLafComponentShown(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_tabPanelLafComponentShown
    {//GEN-HEADEREND:event_tabPanelLafComponentShown
        tabLafInitialFocus();
    }//GEN-LAST:event_tabPanelLafComponentShown

    private void tabGeneralsInitialFocus()
    {
        if ( rdbClientInputManual.isSelected() )
        {
            rdbClientInputManual.requestFocus();
        }
        else
        {
            rdbClientInputStored.requestFocus();
        }
    }
    
    private void tabLafInitialFocus()
    {
        if ( rbtFlatLaf.isSelected() )
        {
            rbtFlatLaf.requestFocus();
        }
        else
        {
            rbtIntelliJ.requestFocus();
        }
    }
    
    private void doClose ( int retStatus )
    {
        returnStatus = retStatus;
        setVisible( false );
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgAppData;
    private javax.swing.ButtonGroup btgFileType;
    private javax.swing.ButtonGroup btgIngresoCliente;
    private javax.swing.ButtonGroup btgTemaLaf;
    private javax.swing.JButton btnSelectFolder;
    private javax.swing.JButton btnValueByDefault;
    private javax.swing.JButton buttonApply;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> cmbAppLanguage;
    private javax.swing.JComboBox<String> cmbFlatLaf;
    private javax.swing.JComboBox<String> cmbIntelliJ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelLafPreview;
    private javax.swing.JButton okButton;
    private javax.swing.JRadioButton rbtFlatLaf;
    private javax.swing.JRadioButton rbtIntelliJ;
    private javax.swing.JRadioButton rdbAppDataManual;
    private javax.swing.JRadioButton rdbAppDataStored;
    private javax.swing.JRadioButton rdbClientInputManual;
    private javax.swing.JRadioButton rdbClientInputStored;
    private javax.swing.JRadioButton rdbFileTypeBinary;
    private javax.swing.JRadioButton rdbFileTypeText;
    private javax.swing.JPanel tabPanelGenerals;
    private javax.swing.JPanel tabPanelLaf;
    private javax.swing.JTextField txtStartingFolder;
    // End of variables declaration//GEN-END:variables

}
