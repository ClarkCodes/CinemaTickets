
package visual;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import control.AdmPelicula;
import control.AdmSettings;
import control.AdmTicket;
import control.Validacion;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import model.Commons;
import model.FilterValue;

/** Search-List Tickets Window
 * @author Clark - ClarkCodes 
 * @since 1.0
 * */
public class FrmBuscarTicket extends javax.swing.JDialog
{
    // Adms
    private final AdmTicket admTicket;
    private final AdmSettings admSettings;

    private FiltersGroups currentFiltersMacroGroupSelected; // Current Filters Selected, used to enable or disable filters following user's choosing
    private FiltersGroups currentFiltersMovieSubGroupSelected;
    
    java.util.ResourceBundle bundle = AdmSettings.getLanguageBundle();

    public FrmBuscarTicket ( java.awt.Frame parent, boolean modal )
    {
        super( parent, modal );
        initComponents();
        tableTicketsModelSetter();
        this.setLocationRelativeTo( null );
        this.currentFiltersMacroGroupSelected = FiltersGroups.Basics;
        this.currentFiltersMovieSubGroupSelected = FiltersGroups.MovieName;
        admTicket = AdmTicket.getAdm();
        admSettings = AdmSettings.getAdmSettings();
        btnBuscar.setIcon( admSettings.getSearchIconForSearchForm() );
        this.setIconImage( admSettings.getSearchIconForSearchForm().getImage() );
    }
    /** Enum constants to specify the filters group to enable
     * @since 1.6
     */
    private enum FiltersGroups
    {
        Basics,
        Client,
        Movie,
        MovieName,
        MovieOthers
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        bgPeliculaGroup = new javax.swing.ButtonGroup();
        bgMacroCriteriaGroup = new javax.swing.ButtonGroup();
        popUpTicketsTable = new javax.swing.JPopupMenu();
        popUpMnuEdit = new javax.swing.JMenuItem();
        popUpMnuDelete = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBusquedaTickets = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        panelCliente = new javax.swing.JPanel();
        lblGeneroCliente = new javax.swing.JLabel();
        cmbFiltroGeneroCliente = new javax.swing.JComboBox<>();
        lblEdad = new javax.swing.JLabel();
        cmbFiltroEdad = new javax.swing.JComboBox<>();
        lblAnios = new javax.swing.JLabel();
        spinnerEdad = new javax.swing.JSpinner();
        panelPelicula = new javax.swing.JPanel();
        lblNombrePelicula = new javax.swing.JLabel();
        cmbFiltroPelicula = new javax.swing.JComboBox<>();
        lblGeneroPelicula = new javax.swing.JLabel();
        cmbFiltroGeneroPelicula = new javax.swing.JComboBox<>();
        lblIdiomaPelicula = new javax.swing.JLabel();
        cmbFiltroIdiomaPelicula = new javax.swing.JComboBox<>();
        cmbFiltroSubtitulosPelicula = new javax.swing.JComboBox<>();
        lblSubtitulosPelicula = new javax.swing.JLabel();
        lblSearchFor = new javax.swing.JLabel();
        rbNombrePelicula = new javax.swing.JRadioButton();
        rbOtrosPelicula = new javax.swing.JRadioButton();
        btnBuscar = new javax.swing.JButton();
        panelBasicos = new javax.swing.JPanel();
        lblPrecioTicket = new javax.swing.JLabel();
        lblCedulaCliente = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtPrecioTicket = new javax.swing.JTextField();
        rbBasicos = new javax.swing.JRadioButton();
        rbCliente = new javax.swing.JRadioButton();
        rbPelicula = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        lblCantidadTickets = new javax.swing.JLabel();

        popUpTicketsTable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        popUpMnuEdit.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("internationalization/Internationalization_Bundle"); // NOI18N
        popUpMnuEdit.setText(bundle.getString("lk_edit")); // NOI18N
        popUpMnuEdit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                popUpMnuEditActionPerformed(evt);
            }
        });
        popUpTicketsTable.add(popUpMnuEdit);

        popUpMnuDelete.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        popUpMnuDelete.setText(bundle.getString("lk_delete")); // NOI18N
        popUpMnuDelete.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                popUpMnuDeleteActionPerformed(evt);
            }
        });
        popUpTicketsTable.add(popUpMnuDelete);

        popUpTicketsTable.getAccessibleContext().setAccessibleDescription("");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(bundle.getString("lk_search_ticket")); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                formKeyReleased(evt);
            }
        });

        tblBusquedaTickets.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblBusquedaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        tblBusquedaTickets.setComponentPopupMenu(popUpTicketsTable);
        tblBusquedaTickets.setRowHeight(40);
        tblBusquedaTickets.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblBusquedaTickets.setShowGrid(false);
        tblBusquedaTickets.getTableHeader().setResizingAllowed(false);
        tblBusquedaTickets.getTableHeader().setReorderingAllowed(false);
        tblBusquedaTickets.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                tblBusquedaTicketsMousePressed(evt);
            }
        });
        tblBusquedaTickets.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                tblBusquedaTicketsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblBusquedaTickets);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(bundle.getString("lk_search_ticket_details")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("lk_search_filter_by"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText(bundle.getString("lk_search_search_criterias")); // NOI18N

        panelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("lk_client"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lblGeneroCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblGeneroCliente.setText(bundle.getString("lk_gender_label")); // NOI18N

        cmbFiltroGeneroCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbFiltroGeneroCliente.setNextFocusableComponent(btnBuscar);

        lblEdad.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblEdad.setText(bundle.getString("lk_age_label")); // NOI18N

        cmbFiltroEdad.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbFiltroEdad.setNextFocusableComponent(spinnerEdad);
        cmbFiltroEdad.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                cmbFiltroEdadItemStateChanged(evt);
            }
        });

        lblAnios.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblAnios.setText(bundle.getString("lk_search_years")); // NOI18N
        lblAnios.setEnabled(false);

        spinnerEdad.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        spinnerEdad.setEnabled(false);
        spinnerEdad.setNextFocusableComponent(cmbFiltroGeneroCliente);
        spinnerEdad.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                spinnerEdadKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelClienteLayout = new javax.swing.GroupLayout(panelCliente);
        panelCliente.setLayout(panelClienteLayout);
        panelClienteLayout.setHorizontalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEdad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFiltroEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAnios)
                .addGap(18, 18, 18)
                .addComponent(lblGeneroCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFiltroGeneroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelClienteLayout.setVerticalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblGeneroCliente)
                        .addComponent(cmbFiltroGeneroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbFiltroEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEdad)
                        .addComponent(lblAnios)
                        .addComponent(spinnerEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelPelicula.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("lk_movie"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lblNombrePelicula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNombrePelicula.setText(bundle.getString("lk_name_label")); // NOI18N
        lblNombrePelicula.setEnabled(panelPelicula.isEnabled());

        cmbFiltroPelicula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbFiltroPelicula.setEnabled(panelPelicula.isEnabled());
        cmbFiltroPelicula.setNextFocusableComponent(btnBuscar);

        lblGeneroPelicula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblGeneroPelicula.setText(bundle.getString("lk_movie_genre")); // NOI18N
        lblGeneroPelicula.setEnabled(panelPelicula.isEnabled());

        cmbFiltroGeneroPelicula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbFiltroGeneroPelicula.setEnabled(panelPelicula.isEnabled());
        cmbFiltroGeneroPelicula.setNextFocusableComponent(cmbFiltroIdiomaPelicula);

        lblIdiomaPelicula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblIdiomaPelicula.setText(bundle.getString("lk_language_label")); // NOI18N
        lblIdiomaPelicula.setEnabled(panelPelicula.isEnabled());

        cmbFiltroIdiomaPelicula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbFiltroIdiomaPelicula.setEnabled(panelPelicula.isEnabled());
        cmbFiltroIdiomaPelicula.setNextFocusableComponent(cmbFiltroSubtitulosPelicula);

        cmbFiltroSubtitulosPelicula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbFiltroSubtitulosPelicula.setEnabled(panelPelicula.isEnabled());
        cmbFiltroSubtitulosPelicula.setNextFocusableComponent(btnBuscar);

        lblSubtitulosPelicula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblSubtitulosPelicula.setText(bundle.getString("lk_subtitles_label")); // NOI18N
        lblSubtitulosPelicula.setEnabled(panelPelicula.isEnabled());

        lblSearchFor.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblSearchFor.setText(bundle.getString("lk_search_search_by_label")); // NOI18N
        lblSearchFor.setEnabled(panelPelicula.isEnabled());

        bgPeliculaGroup.add(rbNombrePelicula);
        rbNombrePelicula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rbNombrePelicula.setSelected(true);
        rbNombrePelicula.setText(bundle.getString("lk_name")); // NOI18N
        rbNombrePelicula.setNextFocusableComponent(rbOtrosPelicula);
        rbNombrePelicula.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                rbNombrePeliculaItemStateChanged(evt);
            }
        });

        bgPeliculaGroup.add(rbOtrosPelicula);
        rbOtrosPelicula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rbOtrosPelicula.setText(bundle.getString("lk_search_others")); // NOI18N
        rbOtrosPelicula.setNextFocusableComponent(rbNombrePelicula);
        rbOtrosPelicula.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                rbOtrosPeliculaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelPeliculaLayout = new javax.swing.GroupLayout(panelPelicula);
        panelPelicula.setLayout(panelPeliculaLayout);
        panelPeliculaLayout.setHorizontalGroup(
            panelPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPeliculaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSearchFor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbNombrePelicula)
                    .addComponent(rbOtrosPelicula))
                .addGap(18, 18, 18)
                .addComponent(lblNombrePelicula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFiltroPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblGeneroPelicula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFiltroGeneroPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblIdiomaPelicula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFiltroIdiomaPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSubtitulosPelicula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFiltroSubtitulosPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelPeliculaLayout.setVerticalGroup(
            panelPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPeliculaLayout.createSequentialGroup()
                .addComponent(rbNombrePelicula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbOtrosPelicula)
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(panelPeliculaLayout.createSequentialGroup()
                .addGroup(panelPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPeliculaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblSearchFor))
                    .addGroup(panelPeliculaLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombrePelicula)
                            .addComponent(cmbFiltroPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGeneroPelicula)
                            .addComponent(lblIdiomaPelicula)
                            .addComponent(cmbFiltroIdiomaPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbFiltroGeneroPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtitulosPelicula)
                            .addComponent(cmbFiltroSubtitulosPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        btnBuscar.setText(bundle.getString("lk_search")); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBuscarActionPerformed(evt);
            }
        });

        panelBasicos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("lk_search_basics"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lblPrecioTicket.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblPrecioTicket.setText(bundle.getString("lk_search_ticket_price_label")); // NOI18N

        lblCedulaCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCedulaCliente.setText(bundle.getString("lk_client_id_label")); // NOI18N

        txtCedula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtCedula.setNextFocusableComponent(btnBuscar);
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtCedulaKeyReleased(evt);
            }
        });

        txtPrecioTicket.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPrecioTicket.setNextFocusableComponent(txtCedula);
        txtPrecioTicket.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtPrecioTicketKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelBasicosLayout = new javax.swing.GroupLayout(panelBasicos);
        panelBasicos.setLayout(panelBasicosLayout);
        panelBasicosLayout.setHorizontalGroup(
            panelBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBasicosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPrecioTicket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecioTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCedulaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelBasicosLayout.setVerticalGroup(
            panelBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBasicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecioTicket)
                    .addComponent(lblCedulaCliente)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        bgMacroCriteriaGroup.add(rbBasicos);
        rbBasicos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rbBasicos.setSelected(true);
        rbBasicos.setText(bundle.getString("lk_search_basics")); // NOI18N
        rbBasicos.setNextFocusableComponent(rbCliente);
        rbBasicos.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                rbBasicosItemStateChanged(evt);
            }
        });

        bgMacroCriteriaGroup.add(rbCliente);
        rbCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rbCliente.setText(bundle.getString("lk_client")); // NOI18N
        rbCliente.setNextFocusableComponent(rbPelicula);
        rbCliente.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                rbClienteItemStateChanged(evt);
            }
        });

        bgMacroCriteriaGroup.add(rbPelicula);
        rbPelicula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rbPelicula.setText(bundle.getString("lk_movie")); // NOI18N
        rbPelicula.setNextFocusableComponent(rbBasicos);
        rbPelicula.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                rbPeliculaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbBasicos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbPelicula))
                            .addComponent(panelBasicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rbBasicos)
                    .addComponent(rbCliente)
                    .addComponent(rbPelicula))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBasicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText(bundle.getString("lk_search_listed_tickets_quantity")); // NOI18N

        lblCantidadTickets.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCantidadTickets.setText(bundle.getString("______")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(lblCantidadTickets)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblCantidadTickets))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        popUpMnuEdit.setIcon( admSettings.getEditIcon() );
        popUpMnuDelete.setIcon( admSettings.getDeleteIcon() );
        admTicket.setSpinnerRange( spinnerEdad );
        enableDisableClientFilters( rbCliente.isSelected() );
        enableDisableMovieFilters( rbPelicula.isSelected() );
        admTicket.getAdmCliente().fillGenders( cmbFiltroGeneroCliente, Commons.WindowMode.Busqueda);
        admTicket.getAdmCliente().fillClientAgeCriterias( cmbFiltroEdad );
        admTicket.getAdmPelicula().llenarComboPeliculas( cmbFiltroPelicula, Commons.WindowMode.Busqueda );
        admTicket.getAdmPelicula().llenarComboGenerosPeliculas( cmbFiltroGeneroPelicula );
        admTicket.getAdmPelicula().llenarComboIdiomasPeliculas( cmbFiltroIdiomaPelicula );
        admTicket.getAdmPelicula().llenarComboSubtitulosPeliculas( cmbFiltroSubtitulosPelicula );
        admTicket.buscarTicket( tblBusquedaTickets );
        rbBasicos.doClick();

        updateTicketsCount();
    }//GEN-LAST:event_formWindowOpened
    
    /** Sets the proper table model to the tickets search table
     * @since 1.6
     */
    private void tableTicketsModelSetter()
    {
        tblBusquedaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "N°", AdmSettings.getLanguageBundle().getString("lk_cHeader_ticket_code"), AdmSettings.getLanguageBundle().getString("lk_cHeader_price"), AdmSettings.getLanguageBundle().getString("lk_client"), AdmSettings.getLanguageBundle().getString("lk_cHeader_id"), AdmSettings.getLanguageBundle().getString("lk_cHeader_age"), AdmSettings.getLanguageBundle().getString("lk_cHeader_gender"), AdmSettings.getLanguageBundle().getString("lk_cHeader_movie"), AdmSettings.getLanguageBundle().getString("lk_cHeader_movie_genre"), AdmSettings.getLanguageBundle().getString("lk_cHeader_movie_language"), AdmSettings.getLanguageBundle().getString("lk_cHeader_subs_language"), AdmSettings.getLanguageBundle().getString("lk_cHeader_movie_duration"), AdmSettings.getLanguageBundle().getString("lk_cHeader_premiere_habitual"), AdmSettings.getLanguageBundle().getString("lk_cHeader_theater"), AdmSettings.getLanguageBundle().getString("lk_cHeader_theater_number"), AdmSettings.getLanguageBundle().getString("lk_cHeader_theater_type"), AdmSettings.getLanguageBundle().getString("lk_cHeader_seats"), AdmSettings.getLanguageBundle().getString("lk_cHeader_show"), AdmSettings.getLanguageBundle().getString("lk_cHeader_selected_showtime")
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
    }
    
    private void btnBuscarActionPerformed ( java.awt.event.ActionEvent evt )
    {//GEN-FIRST:event_btnBuscarActionPerformed
        switch ( currentFiltersMacroGroupSelected )
        {
            case Basics -> busquedaFiltrosBasicos();
            case Client -> busquedaFiltrosCliente();
            case Movie -> busquedaFiltroPelicula();
            default -> {}
        }

        updateTicketsCount();
    }//GEN-LAST:event_btnBuscarActionPerformed

    /** Manages tickets searching using the basic filters criterias
     * 
     * @since 1.6
     * @see control.AdmTicket
     */
    private void busquedaFiltrosBasicos ()
    {
        String cedula = "";
        double precio = 0.0;
        boolean cedulaValida = false, precioValido = false;
        // Validaciones
        if ( !txtPrecioTicket.getText().isBlank() )
            precio = Validacion.leerReal( txtPrecioTicket.getText(), AdmSettings.getLanguageBundle().getString( "lk_decimal_error_msj" ), AdmSettings.getLanguageBundle().getString( "lk_price_error_title" ) );

        if ( Validacion.isDatoValido() )
            precioValido = true;

        if ( !txtCedula.getText().isBlank() )
            cedula = Validacion.validarStrings(txtCedula.getText(), Validacion.TipoEntradaString.Cedula_Busqueda );

        if ( Validacion.isDatoValido() )
            cedulaValida = true;
        // Posibles escenarios
        if ( txtPrecioTicket.getText().isBlank() && txtCedula.getText().isBlank() ) // Si los dos estan vacios
        {
            admTicket.buscarTicket( tblBusquedaTickets );
        }
        else
        {
            if ( txtPrecioTicket.getText().isBlank() && !txtCedula.getText().isBlank() && cedulaValida ) // Si el precio esta vacio y la cedula tiene algo
            {
                FilterValue.setCedulaSearching( cedula );
                admTicket.buscarTicket( tblBusquedaTickets, Commons.Filters.Cedula );
            }
            else if ( !txtPrecioTicket.getText().isBlank() && txtCedula.getText().isBlank() && precioValido ) // Si el precio tiene algo y la cedula esta vacia
            {
                FilterValue.setTicketPriceSearching( precio );
                admTicket.buscarTicket( tblBusquedaTickets, Commons.Filters.Precio );
            }
            else if ( !txtPrecioTicket.getText().isBlank() && !txtCedula.getText().isBlank() && cedulaValida && precioValido ) // Si los dos tienen algo
            {
                FilterValue.setCedulaSearching( cedula );
                FilterValue.setTicketPriceSearching( precio );
                admTicket.buscarTicket( tblBusquedaTickets, Commons.Filters.Cedula_y_Precio );
            }
        }
        
        if ( !txtPrecioTicket.getText().isBlank() && !precioValido )
        {
            txtPrecioTicket.setText( "" );
            txtPrecioTicket.requestFocus();
        }
        else if ( !txtCedula.getText().isBlank() && !cedulaValida )
        {
            txtCedula.setText( "" );
            txtCedula.requestFocus();
        }
    }

    /** Manages tickets searching using the client filters criterias
     * 
     * @since 1.6
     * @see control.AdmTicket
     */
    private void busquedaFiltrosCliente ()
    {
        if ( cmbFiltroEdad.getSelectedIndex() != 0 && cmbFiltroGeneroCliente.getSelectedIndex() != 0 )
        {
            FilterValue.setClientAgeCriteria( Commons.ClientCriterias.valueOfLocalizedString( cmbFiltroEdad.getSelectedItem().toString() ) );
            FilterValue.setClientAgeSearching( ( int ) spinnerEdad.getValue() );
            FilterValue.setClientGenderSearching( cmbFiltroGeneroCliente.getSelectedItem().toString() );
            admTicket.buscarTicket( tblBusquedaTickets, Commons.Filters.Edad_y_Genero );
        }
        else if ( cmbFiltroEdad.getSelectedIndex() != 0 && cmbFiltroGeneroCliente.getSelectedIndex() == 0 )
        {
            FilterValue.setClientAgeCriteria( Commons.ClientCriterias.valueOfLocalizedString( cmbFiltroEdad.getSelectedItem().toString() ) );
            FilterValue.setClientAgeSearching( ( int ) spinnerEdad.getValue() );
            admTicket.buscarTicket( tblBusquedaTickets, Commons.Filters.Edad );
        }
        else if ( cmbFiltroEdad.getSelectedIndex() == 0 && cmbFiltroGeneroCliente.getSelectedIndex() != 0 )
        {
            FilterValue.setClientGenderSearching( cmbFiltroGeneroCliente.getSelectedItem().toString() );
            admTicket.buscarTicket( tblBusquedaTickets, Commons.Filters.GeneroCliente );
        }
        else if ( cmbFiltroEdad.getSelectedIndex() == 0 && cmbFiltroGeneroCliente.getSelectedIndex() == 0 )
        {
            admTicket.buscarTicket( tblBusquedaTickets );
        }
    }

    /** Manages tickets searching using the movie filters criterias
     * 
     * @since 1.6
     * @see control.AdmTicket
     */
    private void busquedaFiltroPelicula ()
    {
        switch ( currentFiltersMovieSubGroupSelected )
        {
            case MovieName ->
            {
                if ( cmbFiltroPelicula.getSelectedIndex() != 0 ) // Validamos que no este seleccionado el primer indice que corresponde a "Todas", de ser asï¿½deberï¿½a listar simplemente todos los tickets sin buscar
                {
                    FilterValue.setMovieNameSearching( cmbFiltroPelicula.getSelectedItem().toString() );
                    admTicket.buscarTicket( tblBusquedaTickets, Commons.Filters.NombrePelicula );
                }
                else
                {
                    admTicket.buscarTicket( tblBusquedaTickets );
                }
            }

            case MovieOthers ->
            {
                if ( cmbFiltroGeneroPelicula.getSelectedIndex() != 0
                        && cmbFiltroIdiomaPelicula.getSelectedIndex() != 0
                        && cmbFiltroSubtitulosPelicula.getSelectedIndex() != 0 )
                {
                    FilterValue.setMovieGenreSearching( AdmPelicula.MovieGenres.valueOfLocalizedString( cmbFiltroGeneroPelicula.getSelectedItem().toString() ) );
                    FilterValue.setMovieLanguageSearching( cmbFiltroIdiomaPelicula.getSelectedItem().toString() );
                    FilterValue.setMovieSubSearching( cmbFiltroSubtitulosPelicula.getSelectedItem().toString() );
                    admTicket.buscarTicket( tblBusquedaTickets, Commons.Filters.Gen_Idiom_Sub_Pelicula );
                }
                else if ( cmbFiltroGeneroPelicula.getSelectedIndex() == 0
                        && cmbFiltroIdiomaPelicula.getSelectedIndex() != 0
                        && cmbFiltroSubtitulosPelicula.getSelectedIndex() != 0 )
                {
                    FilterValue.setMovieLanguageSearching( cmbFiltroIdiomaPelicula.getSelectedItem().toString() );
                    FilterValue.setMovieSubSearching( cmbFiltroSubtitulosPelicula.getSelectedItem().toString() );
                    admTicket.buscarTicket( tblBusquedaTickets, Commons.Filters.Idiom_y_Sub_Pelicula );
                }
                else if ( cmbFiltroGeneroPelicula.getSelectedIndex() != 0
                        && cmbFiltroIdiomaPelicula.getSelectedIndex() == 0
                        && cmbFiltroSubtitulosPelicula.getSelectedIndex() != 0 )
                {
                    FilterValue.setMovieGenreSearching( AdmPelicula.MovieGenres.valueOfLocalizedString( cmbFiltroGeneroPelicula.getSelectedItem().toString() ) );
                    FilterValue.setMovieSubSearching( cmbFiltroSubtitulosPelicula.getSelectedItem().toString() );
                    admTicket.buscarTicket( tblBusquedaTickets, Commons.Filters.Gen_y_Sub_Pelicula );
                }
                else if ( cmbFiltroGeneroPelicula.getSelectedIndex() != 0
                        && cmbFiltroIdiomaPelicula.getSelectedIndex() != 0
                        && cmbFiltroSubtitulosPelicula.getSelectedIndex() == 0 )
                {
                    FilterValue.setMovieGenreSearching( AdmPelicula.MovieGenres.valueOfLocalizedString( cmbFiltroGeneroPelicula.getSelectedItem().toString() ) );
                    FilterValue.setMovieLanguageSearching( cmbFiltroIdiomaPelicula.getSelectedItem().toString() );
                    admTicket.buscarTicket( tblBusquedaTickets, Commons.Filters.Gen_e_Idiom_Pelicula );
                }
                else if ( cmbFiltroGeneroPelicula.getSelectedIndex() != 0
                        && cmbFiltroIdiomaPelicula.getSelectedIndex() == 0
                        && cmbFiltroSubtitulosPelicula.getSelectedIndex() == 0 )
                {
                    FilterValue.setMovieGenreSearching( AdmPelicula.MovieGenres.valueOfLocalizedString( cmbFiltroGeneroPelicula.getSelectedItem().toString() ) );
                    admTicket.buscarTicket( tblBusquedaTickets, Commons.Filters.GeneroPelicula );
                }
                else if ( cmbFiltroGeneroPelicula.getSelectedIndex() == 0
                        && cmbFiltroIdiomaPelicula.getSelectedIndex() != 0
                        && cmbFiltroSubtitulosPelicula.getSelectedIndex() == 0 )
                {
                    FilterValue.setMovieLanguageSearching( cmbFiltroIdiomaPelicula.getSelectedItem().toString() );
                    admTicket.buscarTicket( tblBusquedaTickets, Commons.Filters.IdiomaPelicula );
                }
                else if ( cmbFiltroGeneroPelicula.getSelectedIndex() == 0
                        && cmbFiltroIdiomaPelicula.getSelectedIndex() == 0
                        && cmbFiltroSubtitulosPelicula.getSelectedIndex() != 0 )
                {
                    FilterValue.setMovieSubSearching( cmbFiltroSubtitulosPelicula.getSelectedItem().toString() );
                    admTicket.buscarTicket( tblBusquedaTickets, Commons.Filters.SubtitulosPelicula );
                }
                else
                {
                    admTicket.buscarTicket( tblBusquedaTickets );
                }
            }

            default -> {}
        }
    }

    /** Performs a Ticket editing if there is a ticket selected, opens the 
     *  ticket information in the {@code FrmGenerarTicket} window in edit mode
     *  to be able to edit it
     * 
     * @since 1.6
     * @see control.AdmTicket
     */
    private void editTicket ()
    {
        if ( tblBusquedaTickets.getSelectedRow() >= 0 )
        {
            FrmGenerarTicket dialogActualizarTicket = new FrmGenerarTicket( ( javax.swing.JFrame ) this.getOwner(), true, Commons.WindowMode.Edicion, ( String ) tblBusquedaTickets.getValueAt( tblBusquedaTickets.getSelectedRow(), 1 ) );
            dialogActualizarTicket.setVisible( true );

            if ( admTicket.isTicketGeneradoExitosamente() ) // Evaluamos si el Ticket se genera correctamente para cerrar esta ventana
            {
                admTicket.setTicketGeneradoExitosamente( false ); // Volvemos a este atributo a su estado normal para la proxima generacion de Ticket, y mandamos a llenar el registro del Ticket modificado para que refleje su actualizaciï¿½n
                admTicket.llenarRegistroTablaBusqueda( tblBusquedaTickets, admTicket.getTickets().get( ( String ) tblBusquedaTickets.getValueAt( tblBusquedaTickets.getSelectedRow(), 1 ) ), tblBusquedaTickets.getSelectedRow(), AdmTicket.TipoLlenarRegistro.EditRow );
            }
        }
        else
            JOptionPane.showMessageDialog( this, AdmSettings.getLanguageBundle().getString( "lk_no_reg_edit_msj" ), AdmSettings.getLanguageBundle().getString( "lk_no_selection_title" ), JOptionPane.WARNING_MESSAGE );
    }

    /** Performs a Ticket deletion if there is a ticket selected
     * 
     * @since 1.6
     * @see control.AdmTicket
     */
    private void deleteTicket ()
    {
        if ( tblBusquedaTickets.getSelectedRow() >= 0 )
        {
            if ( JOptionPane.showConfirmDialog( this, AdmSettings.getLanguageBundle().getString( "lk_delete_ticket_confirm_msj" ), AdmSettings.getLanguageBundle().getString( "lk_delete_confirm_title" ), JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE ) == JOptionPane.OK_OPTION ) // Confirmo Eliminacion
            {
                admTicket.eliminarTicket( ( String ) tblBusquedaTickets.getValueAt( tblBusquedaTickets.getSelectedRow(), 1 ) ); // Envio el codigo del Ticket para eliminarlo del HashMap
                btnBuscar.doClick(); // Se llama al boton Buscar, de esta manera si hay filtros activos se volvera a hacer la misma busqueda y si no los hay mostraria todos los tickets, de una forma y otra, ya no apareceria el que se acaba de eliminar, evidenciandose asi que, en efecto, el ticket fue eliminado.
                updateTicketsCount();
            }
        }
        else
            JOptionPane.showMessageDialog( this, AdmSettings.getLanguageBundle().getString( "lk_no_reg_delete_msj" ), AdmSettings.getLanguageBundle().getString( "lk_no_selection_title" ), JOptionPane.WARNING_MESSAGE );
    }

    private void cmbFiltroEdadItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_cmbFiltroEdadItemStateChanged
    {//GEN-HEADEREND:event_cmbFiltroEdadItemStateChanged
        if ( cmbFiltroEdad.getSelectedIndex() != 0 )
        {
            if ( !spinnerEdad.isEnabled() )
                spinnerEdad.setEnabled( true );

            if ( !lblAnios.isEnabled() )
                lblAnios.setEnabled( true );
        }
        else
        {
            spinnerEdad.setEnabled( false );
            lblAnios.setEnabled( false );
        }
    }//GEN-LAST:event_cmbFiltroEdadItemStateChanged

    private void rbBasicosItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_rbBasicosItemStateChanged
    {//GEN-HEADEREND:event_rbBasicosItemStateChanged
        if ( rbBasicos.isSelected() & !panelBasicos.isEnabled() )
        {
            enableDisableBasicFilters( rbBasicos.isSelected() );

            if ( panelCliente.isEnabled() )
                enableDisableClientFilters( rbCliente.isSelected() );

            if ( panelPelicula.isEnabled() )
                enableDisableMovieFilters( rbPelicula.isSelected() );

            if ( !currentFiltersMacroGroupSelected.equals( FiltersGroups.Basics ) )
                currentFiltersMacroGroupSelected = FiltersGroups.Basics;
        }
    }//GEN-LAST:event_rbBasicosItemStateChanged

    private void rbClienteItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_rbClienteItemStateChanged
    {//GEN-HEADEREND:event_rbClienteItemStateChanged
        if ( rbCliente.isSelected() & !panelCliente.isEnabled() )
        {
            enableDisableClientFilters( rbCliente.isSelected() );

            if ( panelBasicos.isEnabled() )
                enableDisableBasicFilters( rbBasicos.isSelected() );

            if ( panelPelicula.isEnabled() )
                enableDisableMovieFilters( rbPelicula.isSelected() );

            if ( !currentFiltersMacroGroupSelected.equals( FiltersGroups.Client ) )
                currentFiltersMacroGroupSelected = FiltersGroups.Client;
        }
    }//GEN-LAST:event_rbClienteItemStateChanged

    private void rbPeliculaItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_rbPeliculaItemStateChanged
    {//GEN-HEADEREND:event_rbPeliculaItemStateChanged
        if ( rbPelicula.isSelected() & !panelPelicula.isEnabled() )
        {
            enableDisableMovieFilters( rbPelicula.isSelected() );

            if ( panelCliente.isEnabled() )
                enableDisableClientFilters( rbCliente.isSelected() );

            if ( panelBasicos.isEnabled() )
                enableDisableBasicFilters( rbBasicos.isSelected() );

            if ( !currentFiltersMacroGroupSelected.equals( FiltersGroups.Movie ) )
                currentFiltersMacroGroupSelected = FiltersGroups.Movie;
        }
    }//GEN-LAST:event_rbPeliculaItemStateChanged

    private void rbNombrePeliculaItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_rbNombrePeliculaItemStateChanged
    {//GEN-HEADEREND:event_rbNombrePeliculaItemStateChanged
        if ( rbNombrePelicula.isSelected() & !cmbFiltroPelicula.isEnabled() )
        {
            enableDisableMovieCriterias( rbNombrePelicula.isSelected() );
            currentFiltersMovieSubGroupSelected = FiltersGroups.MovieName;
        }
    }//GEN-LAST:event_rbNombrePeliculaItemStateChanged

    private void rbOtrosPeliculaItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_rbOtrosPeliculaItemStateChanged
    {//GEN-HEADEREND:event_rbOtrosPeliculaItemStateChanged
        if ( rbOtrosPelicula.isSelected() & !cmbFiltroGeneroPelicula.isEnabled() )
        {
            enableDisableMovieCriterias( rbNombrePelicula.isSelected() );
            currentFiltersMovieSubGroupSelected = FiltersGroups.MovieOthers;
        }
    }//GEN-LAST:event_rbOtrosPeliculaItemStateChanged

    private void spinnerEdadKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_spinnerEdadKeyReleased
    {//GEN-HEADEREND:event_spinnerEdadKeyReleased
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER )
            btnBuscar.doClick();
    }//GEN-LAST:event_spinnerEdadKeyReleased

    private void popUpMnuEditActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_popUpMnuEditActionPerformed
    {//GEN-HEADEREND:event_popUpMnuEditActionPerformed
        editTicket();
    }//GEN-LAST:event_popUpMnuEditActionPerformed

    private void popUpMnuDeleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_popUpMnuDeleteActionPerformed
    {//GEN-HEADEREND:event_popUpMnuDeleteActionPerformed
        deleteTicket();
    }//GEN-LAST:event_popUpMnuDeleteActionPerformed

    private void tblBusquedaTicketsKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_tblBusquedaTicketsKeyReleased
    {//GEN-HEADEREND:event_tblBusquedaTicketsKeyReleased
        switch ( evt.getKeyCode() )
        {
            case KeyEvent.VK_SPACE -> editTicket();
            case KeyEvent.VK_DELETE -> deleteTicket();
            default -> {}
        }
    }//GEN-LAST:event_tblBusquedaTicketsKeyReleased

    private void tblBusquedaTicketsMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tblBusquedaTicketsMousePressed
    {//GEN-HEADEREND:event_tblBusquedaTicketsMousePressed
        if ( evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2 )
            editTicket();
    }//GEN-LAST:event_tblBusquedaTicketsMousePressed

    private void formKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_formKeyReleased
    {//GEN-HEADEREND:event_formKeyReleased
        if ( evt.getKeyCode() == KeyEvent.VK_ESCAPE )
            this.dispose();
    }//GEN-LAST:event_formKeyReleased

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtCedulaKeyReleased
    {//GEN-HEADEREND:event_txtCedulaKeyReleased
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER )
            btnBuscar.doClick();
    }//GEN-LAST:event_txtCedulaKeyReleased

    private void txtPrecioTicketKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtPrecioTicketKeyReleased
    {//GEN-HEADEREND:event_txtPrecioTicketKeyReleased
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER )
            btnBuscar.doClick();
    }//GEN-LAST:event_txtPrecioTicketKeyReleased

    /**
     * Updates the Tickets count indicator label counting how many rows are in
     * the table
     */
    private void updateTicketsCount ()
    {
        lblCantidadTickets.setText( tblBusquedaTickets.getRowCount() + "" );
    }
    
    /** Enables or disables the basic filters group
     * @param basicState A {@code boolean} parameter used to enable or disable
     *                   the basic filters components, if true, components 
     *                    will be enabled, they will be disabled otherwise
     * @since 1.6
     */
    private void enableDisableBasicFilters ( boolean basicState )
    {   // Macro Enablement Manager
        panelBasicos.setEnabled( basicState );
        lblPrecioTicket.setEnabled( basicState );
        txtPrecioTicket.setEnabled( basicState );
        lblCedulaCliente.setEnabled( basicState );
        txtCedula.setEnabled( basicState );
    }
    
    /** Enables or disables the client filters group
     * @param clientState A {@code boolean} parameter used to enable or disable
     *                    the client filters components, if true, components 
     *                    shall be enabled, disabled otherwise
     * @since 1.6
     */
    private void enableDisableClientFilters ( boolean clientState )
    {   // Macro Enablement Manager
        panelCliente.setEnabled( clientState );
        lblEdad.setEnabled( clientState );
        cmbFiltroEdad.setEnabled( clientState );
        lblGeneroCliente.setEnabled( clientState );
        cmbFiltroGeneroCliente.setEnabled( clientState );

        if ( !spinnerEdad.isEnabled() & clientState & cmbFiltroEdad.getSelectedIndex() != 0 )
        {
            spinnerEdad.setEnabled( clientState );
            lblAnios.setEnabled( clientState );
        }
        else if ( !clientState )
        {
            spinnerEdad.setEnabled( clientState );
            lblAnios.setEnabled( clientState );
        }
    }

    /** Enables or disables the movie filters group as it corresponds with the
     * given order
     * @param movieState A {@code boolean} order parameter used to enable or 
     *                   disable the movie filtering components
     * @since 1.6
     */
    private void enableDisableMovieFilters ( boolean movieState )
    {   // Macro Enablement Manager
        // Only if movie filters panel is in a different state than the indicated then movie filters control components are enabled or disabled, because it doesn't make sense to call to enable them if they are already enabled, and movie filters panel is taken as reference because all movie filters control components have the same state
        if ( panelPelicula.isEnabled() != movieState )
        {   
            panelPelicula.setEnabled( movieState );
            lblSearchFor.setEnabled( movieState );
            rbNombrePelicula.setEnabled( movieState );
            rbOtrosPelicula.setEnabled( movieState );
        }
        
        if ( movieState ) // Only if movieState is true, it means that the order is to enable movie filters
        {   // and it calls to the criterias group enabler to enable the filters group that correspond wheter movie name or others taking the rbNombrePelicula component as reference, because if it is selected it means that movie name filters have to be enabled and the other filters have to be disabled, but if it is not selected, then opposite behavior is produced             
            enableDisableMovieCriterias( rbNombrePelicula.isSelected() );
        }
        else // so if movieState is false then all movie filters are going to be disabled then this takes one component of each movie filters group as reference to disable only those which are currently enabled, those which are already disabled are not affected and just still that way
        {
            if ( cmbFiltroPelicula.isEnabled() != movieState )
            {
                lblNombrePelicula.setEnabled( movieState );
                cmbFiltroPelicula.setEnabled( movieState );
            }

            if ( cmbFiltroGeneroPelicula.isEnabled() != movieState )
            {
                lblGeneroPelicula.setEnabled( movieState );
                cmbFiltroGeneroPelicula.setEnabled( movieState );
                lblIdiomaPelicula.setEnabled( movieState );
                cmbFiltroIdiomaPelicula.setEnabled( movieState );
                lblSubtitulosPelicula.setEnabled( movieState );
                cmbFiltroSubtitulosPelicula.setEnabled( movieState );
            }
        }
    }

    /**
     * Enables or disables movie filters groups following an {@code boolean} 
     * order, the {@code rbNombrePelicula} selected state is taken as reference, 
     * so movie name filtering group components shall have this state if they 
     * do not already have it, and others filtering group shall have the 
     * opposite state if their state is equal to the referenced component state,
     * this logic allows the right behavior that is intended to achieve, for
     * example: 
     * <pre>
     *      - If the {@code rbNombrePelicula} selected state is true, it means 
     *        it is currently selected and so {@code rbOtrosPelicula} is not 
     *        selected, so it means that movie name fitering group components 
     *        shall be enabled if they are not already and movie others 
     *        filtering group components shall be disabled if they are currently
     *        enabled
     * </pre>
     * 
     * @param nombrePeliculaSelectedState The {@code rbNombrePelicula} component 
     *                                    selected state taken as reference 
     *                                    order to enable or disable the movie 
     *                                    filters groups
     *
     * @since 1.6
     */
    private void enableDisableMovieCriterias ( boolean nombrePeliculaSelectedState )
    {   // Movie Sub Criterias Enablement Manager
        if ( cmbFiltroPelicula.isEnabled() != nombrePeliculaSelectedState )
        {
            lblNombrePelicula.setEnabled( nombrePeliculaSelectedState );
            cmbFiltroPelicula.setEnabled( nombrePeliculaSelectedState );
        }

        if ( cmbFiltroGeneroPelicula.isEnabled() == nombrePeliculaSelectedState )
        {
            lblGeneroPelicula.setEnabled( !nombrePeliculaSelectedState );
            cmbFiltroGeneroPelicula.setEnabled( !nombrePeliculaSelectedState );
            lblIdiomaPelicula.setEnabled( !nombrePeliculaSelectedState );
            cmbFiltroIdiomaPelicula.setEnabled( !nombrePeliculaSelectedState );
            lblSubtitulosPelicula.setEnabled( !nombrePeliculaSelectedState );
            cmbFiltroSubtitulosPelicula.setEnabled( !nombrePeliculaSelectedState );
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgMacroCriteriaGroup;
    private javax.swing.ButtonGroup bgPeliculaGroup;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cmbFiltroEdad;
    private javax.swing.JComboBox<String> cmbFiltroGeneroCliente;
    private javax.swing.JComboBox<String> cmbFiltroGeneroPelicula;
    private javax.swing.JComboBox<String> cmbFiltroIdiomaPelicula;
    private javax.swing.JComboBox<String> cmbFiltroPelicula;
    private javax.swing.JComboBox<String> cmbFiltroSubtitulosPelicula;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnios;
    private javax.swing.JLabel lblCantidadTickets;
    private javax.swing.JLabel lblCedulaCliente;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblGeneroCliente;
    private javax.swing.JLabel lblGeneroPelicula;
    private javax.swing.JLabel lblIdiomaPelicula;
    private javax.swing.JLabel lblNombrePelicula;
    private javax.swing.JLabel lblPrecioTicket;
    private javax.swing.JLabel lblSearchFor;
    private javax.swing.JLabel lblSubtitulosPelicula;
    private javax.swing.JPanel panelBasicos;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JPanel panelPelicula;
    private javax.swing.JMenuItem popUpMnuDelete;
    private javax.swing.JMenuItem popUpMnuEdit;
    private javax.swing.JPopupMenu popUpTicketsTable;
    private javax.swing.JRadioButton rbBasicos;
    private javax.swing.JRadioButton rbCliente;
    private javax.swing.JRadioButton rbNombrePelicula;
    private javax.swing.JRadioButton rbOtrosPelicula;
    private javax.swing.JRadioButton rbPelicula;
    private javax.swing.JSpinner spinnerEdad;
    private javax.swing.JTable tblBusquedaTickets;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtPrecioTicket;
    // End of variables declaration//GEN-END:variables
}
