package visual;
// Imports
import control.AdmSettings;
import control.AdmTicket;
import control.Validacion;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import model.TipoAccion;
import model.TipoFiltroEdadGenero;
import model.TipoFiltroSoloBusqueda;
import model.CommonlyUsedObjects;

/** Search-List Tickets Window 
 * @author Clark - ClarkCodes */
public class FrmBuscarTicket extends javax.swing.JDialog 
{
    // AdmTicket
    AdmTicket admTicket = AdmTicket.getAdm();
    AdmSettings admSettings = AdmSettings.getAdmSettings();
    CommonlyUsedObjects common = CommonlyUsedObjects.getAdm();
    
    // Tipo de Busqueda: Si es solo para buscar o para Modificar, se utiliza este mismo formulario
    private TipoAccion tipoBusqueda;
    
    public FrmBuscarTicket(java.awt.Frame parent, boolean modal, TipoAccion tipoBusqueda) 
    {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.tipoBusqueda = tipoBusqueda;
        btnBuscar.setIcon(admSettings.getSearchIconForSearchForm());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        SubtitulosGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBusquedaTickets = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblCodigoTicket = new javax.swing.JLabel();
        txtPrecioTicket = new javax.swing.JTextField();
        lblIdCliente = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        checkEdadCliente = new javax.swing.JCheckBox();
        panelEdadCliente = new javax.swing.JPanel();
        lblEdad = new javax.swing.JLabel();
        cmbFiltroEdad = new javax.swing.JComboBox<>();
        ftxEdad = new javax.swing.JFormattedTextField();
        lblAnios = new javax.swing.JLabel();
        checkGeneroCliente = new javax.swing.JCheckBox();
        panelGeneroCliente = new javax.swing.JPanel();
        lblGenero = new javax.swing.JLabel();
        cmbFiltroGenero = new javax.swing.JComboBox<>();
        panelPelicula = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cmbFiltroPelicula = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbFiltroGeneroPelicula = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbFiltroIdiomaPelicula = new javax.swing.JComboBox<>();
        panelSubtitulos = new javax.swing.JPanel();
        rdoSubCon = new javax.swing.JRadioButton();
        rdoSubSin = new javax.swing.JRadioButton();
        rdoSubTodas = new javax.swing.JRadioButton();
        checkPelicula = new javax.swing.JCheckBox();
        btnBuscar = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblCantidadTickets = new javax.swing.JLabel();
        btnModificarEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Ticket");
        setIconImage((new javax.swing.ImageIcon(getClass().getResource("/Cinema_Tickets_Icon_FEVM_12@8x_MODIFICADO_SINGLE_500px.png"))).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        tblBusquedaTickets.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblBusquedaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "N°", "Código-Ticket", "Precio", "Cliente", "Cedula", "Edad", "Sexo", "Pelicula", "Genero", "Idioma", "Idioma-Subtitulos", "Duracion", "Estreno/Habitual", "Sala", "N° de Sala", "Tipo de Sala", "Asiento/s", "Funcion", "Horario Elegido"
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
        tblBusquedaTickets.setRowHeight(40);
        tblBusquedaTickets.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblBusquedaTickets.setShowGrid(false);
        tblBusquedaTickets.getTableHeader().setResizingAllowed(false);
        tblBusquedaTickets.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblBusquedaTickets);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Detalles del Ticket");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar por..."));

        lblCodigoTicket.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCodigoTicket.setText("Precio del Ticket:   $");

        txtPrecioTicket.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPrecioTicket.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtPrecioTicketKeyReleased(evt);
            }
        });

        lblIdCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblIdCliente.setText("Cedula del Cliente: ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Criterios adicionales de Busqueda: ");

        checkEdadCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        checkEdadCliente.setText("Edad del Cliente");
        checkEdadCliente.setEnabled(false);
        checkEdadCliente.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                checkEdadClienteItemStateChanged(evt);
            }
        });

        panelEdadCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Edad del Cliente"));
        panelEdadCliente.setEnabled(false);

        lblEdad.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblEdad.setText("Edad: ");
        lblEdad.setEnabled(false);

        cmbFiltroEdad.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbFiltroEdad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clientes con...", "Clientes mayores de...", "Clientes menores de..." }));
        cmbFiltroEdad.setEnabled(false);

        ftxEdad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ftxEdad.setEnabled(false);
        ftxEdad.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        ftxEdad.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ftxEdad.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                ftxEdadKeyReleased(evt);
            }
        });

        lblAnios.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblAnios.setText("años");
        lblAnios.setEnabled(false);

        javax.swing.GroupLayout panelEdadClienteLayout = new javax.swing.GroupLayout(panelEdadCliente);
        panelEdadCliente.setLayout(panelEdadClienteLayout);
        panelEdadClienteLayout.setHorizontalGroup(
            panelEdadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEdadClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEdad)
                .addGap(18, 18, 18)
                .addComponent(cmbFiltroEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ftxEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAnios)
                .addContainerGap())
        );
        panelEdadClienteLayout.setVerticalGroup(
            panelEdadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEdadClienteLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelEdadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFiltroEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEdad)
                    .addComponent(lblAnios))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        checkGeneroCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        checkGeneroCliente.setText("Género del Cliente");
        checkGeneroCliente.setEnabled(false);
        checkGeneroCliente.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                checkGeneroClienteStateChanged(evt);
            }
        });

        panelGeneroCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Género del Cliente"));
        panelGeneroCliente.setEnabled(false);

        lblGenero.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblGenero.setText("Genero: ");
        lblGenero.setEnabled(false);

        cmbFiltroGenero.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbFiltroGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cmbFiltroGenero.setEnabled(false);

        javax.swing.GroupLayout panelGeneroClienteLayout = new javax.swing.GroupLayout(panelGeneroCliente);
        panelGeneroCliente.setLayout(panelGeneroClienteLayout);
        panelGeneroClienteLayout.setHorizontalGroup(
            panelGeneroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneroClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGenero)
                .addGap(18, 18, 18)
                .addComponent(cmbFiltroGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGeneroClienteLayout.setVerticalGroup(
            panelGeneroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneroClienteLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelGeneroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenero)
                    .addComponent(cmbFiltroGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelPelicula.setBorder(javax.swing.BorderFactory.createTitledBorder("Pelicula"));
        panelPelicula.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Nombre: ");
        jLabel9.setEnabled(panelPelicula.isEnabled());

        cmbFiltroPelicula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbFiltroPelicula.setEnabled(panelPelicula.isEnabled());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Genero: ");
        jLabel10.setEnabled(panelPelicula.isEnabled());

        cmbFiltroGeneroPelicula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbFiltroGeneroPelicula.setEnabled(panelPelicula.isEnabled());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("Idioma: ");
        jLabel11.setEnabled(panelPelicula.isEnabled());

        cmbFiltroIdiomaPelicula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbFiltroIdiomaPelicula.setEnabled(panelPelicula.isEnabled());

        panelSubtitulos.setBorder(javax.swing.BorderFactory.createTitledBorder("Subtitulos"));
        panelSubtitulos.setEnabled(panelPelicula.isEnabled());

        SubtitulosGroup.add(rdoSubCon);
        rdoSubCon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdoSubCon.setText("Con Subtitulos");
        rdoSubCon.setEnabled(panelSubtitulos.isEnabled());

        SubtitulosGroup.add(rdoSubSin);
        rdoSubSin.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdoSubSin.setText("Sin Subtitulos");
        rdoSubSin.setEnabled(panelSubtitulos.isEnabled());

        SubtitulosGroup.add(rdoSubTodas);
        rdoSubTodas.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdoSubTodas.setSelected(true);
        rdoSubTodas.setText("Todas");
        rdoSubTodas.setEnabled(panelSubtitulos.isEnabled());

        javax.swing.GroupLayout panelSubtitulosLayout = new javax.swing.GroupLayout(panelSubtitulos);
        panelSubtitulos.setLayout(panelSubtitulosLayout);
        panelSubtitulosLayout.setHorizontalGroup(
            panelSubtitulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubtitulosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(rdoSubTodas)
                .addGap(18, 18, 18)
                .addComponent(rdoSubCon)
                .addGap(18, 18, 18)
                .addComponent(rdoSubSin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSubtitulosLayout.setVerticalGroup(
            panelSubtitulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubtitulosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelSubtitulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoSubTodas)
                    .addComponent(rdoSubCon)
                    .addComponent(rdoSubSin))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPeliculaLayout = new javax.swing.GroupLayout(panelPelicula);
        panelPelicula.setLayout(panelPeliculaLayout);
        panelPeliculaLayout.setHorizontalGroup(
            panelPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPeliculaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(cmbFiltroPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(cmbFiltroGeneroPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(cmbFiltroIdiomaPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelSubtitulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPeliculaLayout.setVerticalGroup(
            panelPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPeliculaLayout.createSequentialGroup()
                .addGroup(panelPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPeliculaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelSubtitulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPeliculaLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panelPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbFiltroPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(cmbFiltroIdiomaPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbFiltroGeneroPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        checkPelicula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        checkPelicula.setText("Pelicula");
        checkPelicula.setEnabled(false);

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBuscarActionPerformed(evt);
            }
        });

        txtCedula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtCedulaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkEdadCliente)
                                .addGap(18, 18, 18)
                                .addComponent(checkGeneroCliente)
                                .addGap(18, 18, 18)
                                .addComponent(checkPelicula))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCodigoTicket)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblIdCliente)
                                .addGap(18, 18, 18)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(91, 91, 91)
                        .addComponent(panelEdadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(panelGeneroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(checkEdadCliente)
                            .addComponent(checkGeneroCliente)
                            .addComponent(checkPelicula))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigoTicket)
                            .addComponent(lblIdCliente)
                            .addComponent(txtPrecioTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelEdadCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelGeneroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Cantidad de Tickets Listados: ");

        lblCantidadTickets.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCantidadTickets.setText("______");

        btnModificarEliminar.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        btnModificarEliminar.setText("Modificar");
        btnModificarEliminar.setEnabled(false);
        btnModificarEliminar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnModificarEliminarActionPerformed(evt);
            }
        });

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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnModificarEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificarEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblCantidadTickets))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        switch(tipoBusqueda) // La forma por defecto en la que estï¿½ diseï¿½ado el Formulario es para Solo Busquedas, 
        {                   // los controles de Modificaciï¿½n estan deshabilitados, por ello cuando entramos en modo Modificacion los habilitamos y deshabilitamos algunos de Solo Busqueda
            case SoloBusqueda ->
            {
                txtPrecioTicket.requestFocusInWindow();
                this.btnModificarEliminar.setIcon(admSettings.getEditIconForSearchForm());
                this.setIconImage(admSettings.getSearchIconForSearchForm().getImage());
            }   
             
            case Modificacion ->
            {   // Deshabilitamos los controles de Solo Busqueda
                lblCodigoTicket.setEnabled(false);
                lblIdCliente.setEnabled(false);
                txtPrecioTicket.setEnabled(false);
                txtCedula.setEnabled(false);
                // Habilitamos los controles de Modificacion
                checkEdadCliente.setEnabled(true);
                checkGeneroCliente.setEnabled(true);
                checkEdadCliente.setSelected(true);
                checkGeneroCliente.setSelected(true);
                btnModificarEliminar.setEnabled(true);
                panelEdadCliente.setEnabled(true);
                panelGeneroCliente.setEnabled(true);
                this.setTitle("Modificar Ticket");
                this.setIconImage(admSettings.getEditIconForSearchForm().getImage());
                this.btnModificarEliminar.setIcon(admSettings.getEditIconForSearchForm());   
            }
            
            case Eliminacion ->
            {   // Deshabilitamos los controles de Solo Busqueda
                lblCodigoTicket.setEnabled(false);
                lblIdCliente.setEnabled(false);
                txtPrecioTicket.setEnabled(false);
                txtCedula.setEnabled(false);
                // Habilitamos los filtros para Eliminacion
                checkEdadCliente.setEnabled(true);
                checkGeneroCliente.setEnabled(true);
                checkEdadCliente.setSelected(true);
                checkGeneroCliente.setSelected(true);
                btnModificarEliminar.setEnabled(true);
                btnModificarEliminar.setText("Eliminar");
                panelEdadCliente.setEnabled(true);
                panelGeneroCliente.setEnabled(true);
                this.setTitle("Eliminar Ticket");
                this.setIconImage(admSettings.getDeleteIconForSearchForm().getImage());
                this.btnModificarEliminar.setIcon(admSettings.getDeleteIconForSearchForm());   
            }
        }
        
        admTicket.getAdmPelicula().llenarComboPeliculas(cmbFiltroPelicula);
        admTicket.getAdmPelicula().llenarComboGenerosPeliculas(cmbFiltroGeneroPelicula);
        admTicket.getAdmPelicula().llenarComboIdiomasPeliculas(cmbFiltroIdiomaPelicula);
        admTicket.buscarTicket(tblBusquedaTickets);
        
        updateTicketsCount();
        
        if(admTicket.getTickets().isEmpty()) // Marcado para Remosion
        {
            JOptionPane.showMessageDialog(this, "Todavia no se han agregado Tickets que pueda buscar.", "Sin elementos", JOptionPane.INFORMATION_MESSAGE);
            btnBuscar.setEnabled(false);
            btnModificarEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) 
    {//GEN-FIRST:event_btnBuscarActionPerformed
        switch(tipoBusqueda)
        {
            case SoloBusqueda ->
            {
                String cedula = "";
                double precio = 0.0;
                boolean cedulaValida = false, precioValido = false;
                // Validaciones
                if(!txtPrecioTicket.getText().isBlank()) 
                    precio = Validacion.leerReal(txtPrecioTicket.getText(), "El Precio debe ser un numero Real decimal. Ingreselo nuevamente", "Precio no valido");
                if(Validacion.isDatoValido())
                    precioValido = true;
                if(!txtCedula.getText().isBlank())
                    cedula = Validacion.validarStrings(txtCedula.getText(), Validacion.TipoEntradaString.Cedula);
                if(Validacion.isDatoValido())
                    cedulaValida = true;
                // Posibles escenarios
                if(txtPrecioTicket.getText().isBlank() && txtCedula.getText().isBlank()) // Si los dos estan vacios
                {
                    admTicket.buscarTicket(tblBusquedaTickets);
                }
                else
                {
                    if(txtPrecioTicket.getText().isBlank() && !txtCedula.getText().isBlank() && cedulaValida) // Si el precio esta vacio y la cedula tiene algo
                    {
                        admTicket.buscarTicket(tblBusquedaTickets, cedula, precio, TipoFiltroSoloBusqueda.Cedula);
                    }
                    else if(!txtPrecioTicket.getText().isBlank() && txtCedula.getText().isBlank() && precioValido) // Si el precio tiene algo y la cedula esta vacia
                    {
                        admTicket.buscarTicket(tblBusquedaTickets, cedula, precio, TipoFiltroSoloBusqueda.Precio);
                    }
                    else if(!txtPrecioTicket.getText().isBlank() && !txtCedula.getText().isBlank() && cedulaValida && precioValido) // Si los dos tienen algo
                    {
                        admTicket.buscarTicket(tblBusquedaTickets, cedula, precio, TipoFiltroSoloBusqueda.Cedula_y_Precio);
                    }
                } 
            }
            
            default -> busquedaParaModificarEliminar(); // Para Modificacion y Eliminacion
        }
        
        updateTicketsCount();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void busquedaParaModificarEliminar()
    {
        int edad = 0;
        
        if(!ftxEdad.getText().isBlank())
            edad = Validacion.leerEntero(ftxEdad.getText(), "La edad debe ser un numero natural (entero positivo). Ingresela nuevamente", "Edad no valida");
                
        if(checkEdadCliente.isSelected() && checkGeneroCliente.isSelected())
        {
            if(Validacion.isDatoValido())
            {
                admTicket.buscarTicket(tblBusquedaTickets, edad, cmbFiltroEdad.getSelectedItem().toString(), cmbFiltroGenero.getSelectedItem().toString(), TipoFiltroEdadGenero.Edad_y_Genero);
            }
        }
        else if(!checkEdadCliente.isSelected() && checkGeneroCliente.isSelected())
        {
            admTicket.buscarTicket(tblBusquedaTickets, edad, cmbFiltroEdad.getSelectedItem().toString(), cmbFiltroGenero.getSelectedItem().toString(), TipoFiltroEdadGenero.Genero);
        }
        else if(checkEdadCliente.isSelected() && !checkGeneroCliente.isSelected())
        {
            if(Validacion.isDatoValido())
            {
                admTicket.buscarTicket(tblBusquedaTickets, edad, cmbFiltroEdad.getSelectedItem().toString(), cmbFiltroGenero.getSelectedItem().toString(), TipoFiltroEdadGenero.Edad);
            }
        }
        else if(!checkEdadCliente.isSelected() && !checkGeneroCliente.isSelected())
        {
            admTicket.buscarTicket(tblBusquedaTickets);
            updateTicketsCount();
        }
    }
    
    private void btnModificarEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEliminarActionPerformed
        switch(tipoBusqueda)
        {
            case Modificacion ->
            {
                if(tblBusquedaTickets.getSelectedRow() >= 0)
                {
                    FrmGenerarTicket dialogActualizarTicket = new FrmGenerarTicket((javax.swing.JFrame)this.getOwner(), true, TipoAccion.Modificacion, (String)tblBusquedaTickets.getValueAt(tblBusquedaTickets.getSelectedRow(), 1));
                    dialogActualizarTicket.setVisible(true);
                    
                    if(admTicket.isTicketGeneradoExitosamente()) // Evaluamos si el Ticket se genera correctamente para cerrar esta ventana
                    {   
                        admTicket.setTicketGeneradoExitosamente(false); // Volvemos a este atributo a su estado normal para la proxima generacion de Ticket, y mandamos a llenar el registro del Ticket modificado para que refleje su actualizaciï¿½n
                        admTicket.llenarRegistroTablaBusqueda(tblBusquedaTickets, admTicket.getTickets().get((String)tblBusquedaTickets.getValueAt(tblBusquedaTickets.getSelectedRow(), 1)), (int)tblBusquedaTickets.getValueAt(tblBusquedaTickets.getSelectedRow(), 0), tblBusquedaTickets.getSelectedRow());
                    }
                }
                else
                    JOptionPane.showMessageDialog(this, "Ningun registro seleccionado. Debe seleccionar un registro para modificarlo", "Sin seleccion", JOptionPane.WARNING_MESSAGE);
            }
            
            case Eliminacion ->
            {
                if(tblBusquedaTickets.getSelectedRow() >= 0)
                {            
                    if(JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar este Ticket, esta accion no se podra deshacer.", "Confirmar eliminacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) // Confirmo Eliminacion
                    {   
                        admTicket.eliminarTicket((String)tblBusquedaTickets.getValueAt(tblBusquedaTickets.getSelectedRow(), 1)); // Envio el codigo del Ticket para eliminarlo del HashMap
                        admTicket.buscarTicket(tblBusquedaTickets); // Muestro todos los elementos del HashMap haciendo una busqueda sin filtros para evidenciar que el elemento ya ha sido eliminado.
                        updateTicketsCount();
                    }
                }
                else
                    JOptionPane.showMessageDialog(this, "Ningun registro seleccionado. Debe seleccionar un registro para eliminarlo", "Sin seleccion", JOptionPane.WARNING_MESSAGE);
            }
            default -> { } // Yes, it has nothing
        }
                
    }//GEN-LAST:event_btnModificarEliminarActionPerformed

    private void checkGeneroClienteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkGeneroClienteStateChanged
        panelGeneroCliente.setEnabled(checkEdadCliente.isEnabled());
        lblGenero.setEnabled(checkEdadCliente.isEnabled());
        cmbFiltroGenero.setEnabled(checkEdadCliente.isEnabled());
    }//GEN-LAST:event_checkGeneroClienteStateChanged

    private void checkEdadClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkEdadClienteItemStateChanged
        panelEdadCliente.setEnabled(checkEdadCliente.isEnabled());
        lblEdad.setEnabled(checkEdadCliente.isEnabled());
        cmbFiltroEdad.setEnabled(checkEdadCliente.isEnabled());
        ftxEdad.setEnabled(checkEdadCliente.isEnabled());
        lblAnios.setEnabled(checkEdadCliente.isEnabled());
    }//GEN-LAST:event_checkEdadClienteItemStateChanged

    private void txtPrecioTicketKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtPrecioTicketKeyReleased
    {//GEN-HEADEREND:event_txtPrecioTicketKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            btnBuscar.doClick();
    }//GEN-LAST:event_txtPrecioTicketKeyReleased

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtCedulaKeyReleased
    {//GEN-HEADEREND:event_txtCedulaKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            btnBuscar.doClick();
    }//GEN-LAST:event_txtCedulaKeyReleased

    private void ftxEdadKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_ftxEdadKeyReleased
    {//GEN-HEADEREND:event_ftxEdadKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            btnBuscar.doClick();
    }//GEN-LAST:event_ftxEdadKeyReleased

    private void updateTicketsCount()
    {
        lblCantidadTickets.setText(tblBusquedaTickets.getRowCount() + "");
        centerTableContent(tblBusquedaTickets);
    }
    
    private void centerTableContent(JTable tablaBusqueda)
    {
        common.centerTableColumns(tablaBusqueda);
        DefaultTableColumnModel columnModelTB = (DefaultTableColumnModel) tablaBusqueda.getColumnModel();
        
        columnModelTB.getColumn(0).setPreferredWidth(20);
        columnModelTB.getColumn(1).setPreferredWidth(215);
        columnModelTB.getColumn(2).setPreferredWidth(40);
        columnModelTB.getColumn(3).setPreferredWidth(150);
        columnModelTB.getColumn(4).setPreferredWidth(85);
        columnModelTB.getColumn(5).setPreferredWidth(50);
        columnModelTB.getColumn(6).setPreferredWidth(75);
        columnModelTB.getColumn(7).setPreferredWidth(160);
        columnModelTB.getColumn(8).setPreferredWidth(75);
        columnModelTB.getColumn(9).setPreferredWidth(50);
        columnModelTB.getColumn(10).setPreferredWidth(60);
        columnModelTB.getColumn(11).setPreferredWidth(50);
        columnModelTB.getColumn(12).setPreferredWidth(60);
        columnModelTB.getColumn(13).setPreferredWidth(85);
        columnModelTB.getColumn(14).setPreferredWidth(50);
        columnModelTB.getColumn(15).setPreferredWidth(60);
        columnModelTB.getColumn(16).setPreferredWidth(50);
        columnModelTB.getColumn(17).setPreferredWidth(75);
        columnModelTB.getColumn(18).setPreferredWidth(75);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup SubtitulosGroup;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnModificarEliminar;
    private javax.swing.JCheckBox checkEdadCliente;
    private javax.swing.JCheckBox checkGeneroCliente;
    private javax.swing.JCheckBox checkPelicula;
    private javax.swing.JComboBox<String> cmbFiltroEdad;
    private javax.swing.JComboBox<String> cmbFiltroGenero;
    private javax.swing.JComboBox<String> cmbFiltroGeneroPelicula;
    private javax.swing.JComboBox<String> cmbFiltroIdiomaPelicula;
    private javax.swing.JComboBox<String> cmbFiltroPelicula;
    private javax.swing.JFormattedTextField ftxEdad;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnios;
    private javax.swing.JLabel lblCantidadTickets;
    private javax.swing.JLabel lblCodigoTicket;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JPanel panelEdadCliente;
    private javax.swing.JPanel panelGeneroCliente;
    private javax.swing.JPanel panelPelicula;
    private javax.swing.JPanel panelSubtitulos;
    private javax.swing.JRadioButton rdoSubCon;
    private javax.swing.JRadioButton rdoSubSin;
    private javax.swing.JRadioButton rdoSubTodas;
    private javax.swing.JTable tblBusquedaTickets;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtPrecioTicket;
    // End of variables declaration//GEN-END:variables
}
