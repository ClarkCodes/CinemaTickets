
package visual;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import control.AdmSettings;
import control.AdmTicket;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Commons;
import model.Ticket;

/** Generate Ticket Window
 *
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public class FrmGenerarTicket extends javax.swing.JDialog
{   // Adms
    AdmTicket admTicket = AdmTicket.getAdm();
    AdmSettings admSettings = AdmSettings.getAdmSettings();
    private final Commons.WindowMode proceder; // Tipo de Accion
    private final String keyToModify; // Key exclusiva para modificar el Ticket cuando lo llamo de esa manera
    
    public FrmGenerarTicket ( java.awt.Frame parent, boolean modal, Commons.WindowMode proceder, String keyToModify )
    {
        super( parent, modal );
        initComponents();
        tablesInitSetter();
        getRootPane().setDefaultButton( btnGenerarTicket );
        this.setLocationRelativeTo( null );
        this.proceder = proceder;
        this.keyToModify = keyToModify;
        this.setIconImage( ( new javax.swing.ImageIcon( getClass().getResource( "/Cinema_Tickets_Icon_12@8x_MODIFICADO_SINGLE_500px.png" ) ) ).getImage() );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        btnGenerarRegistrarCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClienteObtenido = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbPeliculas = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPeliculaElegida = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbSalas = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSalaElegida = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnElegirAsiento = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cmbHorariosDisponibles = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblFuncionElegida = new javax.swing.JTable();
        btnGenerarTicket = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("internationalization/Internationalization_Bundle"); // NOI18N
        setTitle(bundle.getString("lk_generate_ticket")); // NOI18N
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("lk_client"))); // NOI18N

        btnGenerarRegistrarCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGenerarRegistrarCliente.setText(bundle.getString("lk_generate_client")); // NOI18N
        btnGenerarRegistrarCliente.setToolTipText("");
        btnGenerarRegistrarCliente.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGenerarRegistrarClienteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText(bundle.getString("lk_client_generation_instruction")); // NOI18N

        tblClienteObtenido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblClienteObtenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Cedula", "Nombre", "Edad", "Genero"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false
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
        tblClienteObtenido.setRowHeight(36);
        tblClienteObtenido.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblClienteObtenido.setShowGrid(false);
        tblClienteObtenido.getTableHeader().setResizingAllowed(false);
        tblClienteObtenido.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblClienteObtenido);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(bundle.getString("lk_obtained_client_details")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                    .addComponent(btnGenerarRegistrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGenerarRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("lk_movie"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText(bundle.getString("lk_select_movie")); // NOI18N

        cmbPeliculas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbPeliculas.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                cmbPeliculasItemStateChanged(evt);
            }
        });

        tblPeliculaElegida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblPeliculaElegida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Codigo", "Genero", "Idioma", " Subtítulos", "Duracion"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false
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
        tblPeliculaElegida.setMinimumSize(new java.awt.Dimension(0, 0));
        tblPeliculaElegida.setPreferredSize(null);
        tblPeliculaElegida.setRowHeight(36);
        tblPeliculaElegida.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPeliculaElegida.setShowGrid(false);
        tblPeliculaElegida.getTableHeader().setResizingAllowed(false);
        tblPeliculaElegida.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblPeliculaElegida);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(bundle.getString("lk_selected_movie_details")); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(bundle.getString("lk_movie")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbPeliculas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("lk_theater"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText(bundle.getString("lk_select_theater")); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(bundle.getString("lk_selected_theater_details")); // NOI18N

        cmbSalas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbSalas.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                cmbSalasItemStateChanged(evt);
            }
        });

        tblSalaElegida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblSalaElegida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Codigo", "Numero de Sala", "Tipo de Sala", "Asiento"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false
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
        tblSalaElegida.setMinimumSize(new java.awt.Dimension(300, 0));
        tblSalaElegida.setRowHeight(36);
        tblSalaElegida.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSalaElegida.getTableHeader().setResizingAllowed(false);
        tblSalaElegida.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblSalaElegida);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(bundle.getString("lk_theater")); // NOI18N

        btnElegirAsiento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnElegirAsiento.setText(bundle.getString("lk_select_seat")); // NOI18N
        btnElegirAsiento.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnElegirAsientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnElegirAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnElegirAsiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbSalas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("lk_cHeader_show"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText(bundle.getString("lk_select_showtime_instruction")); // NOI18N

        cmbHorariosDisponibles.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbHorariosDisponibles.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                cmbHorariosDisponiblesItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText(bundle.getString("lk_show_details")); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText(bundle.getString("lk_available_showtimes")); // NOI18N

        tblFuncionElegida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblFuncionElegida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Codigo", "Nombre", "Estreno - Habitual"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false
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
        tblFuncionElegida.setMinimumSize(new java.awt.Dimension(0, 0));
        tblFuncionElegida.setPreferredSize(null);
        tblFuncionElegida.setRowHeight(36);
        tblFuncionElegida.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblFuncionElegida.getTableHeader().setResizingAllowed(false);
        tblFuncionElegida.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblFuncionElegida);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addComponent(cmbHorariosDisponibles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(cmbHorariosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGenerarTicket.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnGenerarTicket.setText(bundle.getString("lk_generate")); // NOI18N
        btnGenerarTicket.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGenerarTicketActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCancelar.setText(bundle.getString("lk_cancel")); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnGenerarTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Sets the proper table model to the each table in this window
     * @since 1.6
     */
    private void tablesInitSetter()
    {   // TABLA CLIENTE OBTENIDO / TABLE CLIENT OBTAINED
        tblClienteObtenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                AdmSettings.getLanguageBundle().getString("lk_cHeader_id"), AdmSettings.getLanguageBundle().getString("lk_name"), AdmSettings.getLanguageBundle().getString("lk_cHeader_age"), AdmSettings.getLanguageBundle().getString("lk_cHeader_gender")
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false
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
        
        // TABLA PELICULA ELEGIDA - TABLE SELECTED MOVIE
        tblPeliculaElegida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                AdmSettings.getLanguageBundle().getString("lk_code"), AdmSettings.getLanguageBundle().getString("lk_movie_genre"), AdmSettings.getLanguageBundle().getString("lk_cHeader_movie_language"), AdmSettings.getLanguageBundle().getString("lk_cHeader_movie_subs"), AdmSettings.getLanguageBundle().getString("lk_cHeader_movie_duration")
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false
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
        
        // TABLA SALA ELEGIDA / TABLE SELECTED THEATER
        tblSalaElegida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                AdmSettings.getLanguageBundle().getString("lk_code"), AdmSettings.getLanguageBundle().getString("lk_theater_number"), AdmSettings.getLanguageBundle().getString("lk_cHeader_theater_type"), AdmSettings.getLanguageBundle().getString("lk_cHeader_seats")
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false
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
        
        // TABLA FUNCION ELEGIDA / TABLE SELECTED SHOW
        tblFuncionElegida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                AdmSettings.getLanguageBundle().getString("lk_code"), AdmSettings.getLanguageBundle().getString("lk_name"), AdmSettings.getLanguageBundle().getString("lk_cHeader_premiere_habitual")
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false
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
    
    private void btnGenerarRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarRegistrarClienteActionPerformed
        switch ( admSettings.getClientDataMode() )
        {
            case Stored -> admTicket.prepararCliente( AdmSettings.DataMode.Stored );
            case Manual ->
            {
                FrmDialogClientRegistration clientRegister = new FrmDialogClientRegistration( (JFrame) this.getOwner(), true );
                clientRegister.setVisible( true );
            }
        }
        
        if ( admTicket.getTempReadyClient() != null )
            admTicket.llenarTablaCliente( tblClienteObtenido, admTicket.getTempReadyClient() );
    }//GEN-LAST:event_btnGenerarRegistrarClienteActionPerformed

    private void btnGenerarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarTicketActionPerformed

        if ( admTicket.getTempReadyClient() != null )
        {
            switch ( proceder )
            {
                case Creacion ->
                {
                    admTicket.prepararTicket( proceder );

                    FrmConfirmarGeneracion dialogConfirmarTicket = new FrmConfirmarGeneracion( ( javax.swing.JFrame ) this.getOwner(), true );
                    dialogConfirmarTicket.setVisible( true );

                    if ( admTicket.isTicketGeneradoExitosamente() ) // Evaluamos si el Ticket se generï¿½ correctamente para cerrar esta ventana
                    {
                        admTicket.setTicketGeneradoExitosamente( false ); // Volvemos a este atributo a su estado normal para la proxima generacion de Ticket
                        admTicket.setTempReadyClient( null );
                        this.dispose();
                    }

                }
                case Edicion ->
                {
                    admTicket.prepararTicket( proceder );

                    admTicket.actualizarTicket( keyToModify ); // Se llama a actualizar el Ticket para reemplazar el que habia por el nuevo y modificarlo.
                    JOptionPane.showMessageDialog( this, AdmSettings.getLanguageBundle().getString( "lk_ticket_data_succesfully_updated" ), AdmSettings.getLanguageBundle().getString( "lk_ticket_updated" ), JOptionPane.INFORMATION_MESSAGE );
                    admTicket.setTempReadyClient( null );
                    this.dispose();
                }
                default -> {}
            }
            admTicket.setSaved( false ); // Se setea el saved en false porque se esta alterando el HashMap con datos que no estan guardados todavia
        }
        else
        {
            JOptionPane.showMessageDialog( this, AdmSettings.getLanguageBundle().getString( "lk_generate_client_before" ), AdmSettings.getLanguageBundle().getString( "lk_client_not_generated" ), JOptionPane.WARNING_MESSAGE );
        }
    }//GEN-LAST:event_btnGenerarTicketActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Pelicula y Horarios Disponibles
        admTicket.getAdmPelicula().llenarComboPeliculas( cmbPeliculas, Commons.WindowMode.Creacion );
        // Sala
        admTicket.getAdmSala().llenarComboSalas( cmbSalas );
        
        btnGenerarRegistrarCliente.setIcon( admSettings.getAddClientForClientManualInputDialog() );
        
        if ( admSettings.getClientDataMode() == AdmSettings.DataMode.Manual )
        {
            btnGenerarRegistrarCliente.setText( AdmSettings.getLanguageBundle().getString( "lk_client_register_client" ) );
            admTicket.setTempReadyClient( null );
        }

        switch ( proceder )
        {
            case Creacion ->
            {   // Adecuaciones de la Ventana
                this.setIconImage( admSettings.getAddIconForGenerateForm().getImage() );
                btnGenerarTicket.setIcon( admSettings.getAddIconForGenerateForm() );

                // Creo el Objeto Ticket Temporal que va a ser un helper para luego guardarlo en el HashMap tickets como elemento.
                admTicket.setTicket( new Ticket() );
                // Pelicula
                admTicket.prepararPelicula( cmbPeliculas.getItemAt( 0 ), tblPeliculaElegida, cmbHorariosDisponibles ); // incluye Horarios Disponibles
                // Sala
                admTicket.prepararSala( cmbSalas.getItemAt( 0 ), tblSalaElegida );
                // Funcion
                admTicket.prepararFuncion( cmbHorariosDisponibles.getItemAt( 0 ), cmbPeliculas.getItemAt( 0 ), tblFuncionElegida );
            }

            case Edicion ->
            {   // Adecuaciones de la Ventana
                this.setTitle( AdmSettings.getLanguageBundle().getString( "lk_edit_ticket" ) );
                this.setIconImage( admSettings.getEditIconForSearchForm().getImage() );
                btnGenerarTicket.setText( AdmSettings.getLanguageBundle().getString( "lk_update" ) );
                btnGenerarTicket.setIcon( admSettings.getEditIconForSearchForm() );

                admTicket.setTicket( admTicket.getTickets().get( keyToModify ) );
                // Pelicula
                cmbPeliculas.setSelectedItem( admTicket.getTicket().getPelicula().getNombre() );
                admTicket.prepararPelicula( ( String ) cmbPeliculas.getSelectedItem(), tblPeliculaElegida, cmbHorariosDisponibles );
                // Sala
                cmbSalas.setSelectedItem( admTicket.getTicket().getSala().getNombre() );
                admTicket.prepararSala( ( String ) cmbSalas.getSelectedItem(), tblSalaElegida );
                // Funcion
                cmbHorariosDisponibles.setSelectedItem( admTicket.getTicket().getFuncion().getHorarioElegido().format(Commons.getFormatoDateTime(Commons.TypeFormatoDateTime.HorasMinutos ) ) );
                admTicket.prepararFuncion( cmbHorariosDisponibles.getSelectedItem().toString(), cmbPeliculas.getSelectedItem().toString(), tblFuncionElegida );
                // Cliente
                admTicket.setTempReadyClient( admTicket.getTicket().getCliente() );
                admTicket.llenarTablaCliente( tblClienteObtenido, admTicket.getTempReadyClient() );
            }
            default -> {}
        }

    }//GEN-LAST:event_formWindowOpened

    private void cmbPeliculasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPeliculasItemStateChanged
        // Pelicula
        admTicket.prepararPelicula( cmbPeliculas.getSelectedItem().toString(), tblPeliculaElegida, cmbHorariosDisponibles );
        // Funcion
        admTicket.prepararFuncion( cmbHorariosDisponibles.getSelectedItem().toString(), cmbPeliculas.getSelectedItem().toString(), tblFuncionElegida );
    }//GEN-LAST:event_cmbPeliculasItemStateChanged

    private void cmbSalasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSalasItemStateChanged
        admTicket.prepararSala( cmbSalas.getSelectedItem().toString(), tblSalaElegida );
    }//GEN-LAST:event_cmbSalasItemStateChanged

    private void btnElegirAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirAsientoActionPerformed
//        FrmElegirAsientoFEVM dialogElegirAsiento = new FrmElegirAsientoFEVM((javax.swing.JFrame)this.getOwner(), true);
//        dialogElegirAsiento.setVisible(true);
        JOptionPane.showMessageDialog( this, AdmSettings.getLanguageBundle().getString( "lk_feature_na" ), AdmSettings.getLanguageBundle().getString( "lk_coming_soon" ), JOptionPane.INFORMATION_MESSAGE );
    }//GEN-LAST:event_btnElegirAsientoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if ( admTicket.getTempReadyClient() != null )
            admTicket.setTempReadyClient( null );
        
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbHorariosDisponiblesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbHorariosDisponiblesItemStateChanged
        if ( ( String ) cmbHorariosDisponibles.getSelectedItem() != null )
            admTicket.prepararFuncion( ( String ) cmbHorariosDisponibles.getSelectedItem(), ( String ) cmbPeliculas.getSelectedItem(), tblFuncionElegida );
    }//GEN-LAST:event_cmbHorariosDisponiblesItemStateChanged

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER )
            btnGenerarTicket.doClick();

        if ( evt.getKeyCode() == KeyEvent.VK_ESCAPE )
            dispose();
    }//GEN-LAST:event_formKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnElegirAsiento;
    private javax.swing.JButton btnGenerarRegistrarCliente;
    private javax.swing.JButton btnGenerarTicket;
    private javax.swing.JComboBox<String> cmbHorariosDisponibles;
    private javax.swing.JComboBox<String> cmbPeliculas;
    private javax.swing.JComboBox<String> cmbSalas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblClienteObtenido;
    private javax.swing.JTable tblFuncionElegida;
    private javax.swing.JTable tblPeliculaElegida;
    private javax.swing.JTable tblSalaElegida;
    // End of variables declaration//GEN-END:variables
}
