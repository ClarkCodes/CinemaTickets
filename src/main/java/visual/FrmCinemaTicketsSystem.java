package visual;
/* LICENSE 
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import control.AdmSettings;
import control.AdmTicket;
import data.DatosTickets;
import java.util.HashMap;
import javax.swing.JOptionPane;
import model.Ticket;
import model.TipoAccion;

/** Cinema Tickets System Main {@code JFrame} Class
 * @author Clark - ClarkCodes 
 * @since 1.0
 */
public class FrmCinemaTicketsSystem extends javax.swing.JFrame 
{
    /** Creates new form FrmCinemaTicketsSystem */
    // AdmTicket - Inicializa en AdmTicket para que los datos quemados se inicialicen y poder usarlos.
    AdmTicket admTicket;
    AdmSettings admSettings;
    DatosTickets datos;
    
    public FrmCinemaTicketsSystem() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        this.admTicket = AdmTicket.getAdm();
        this.admSettings = AdmSettings.getAdmSettings();
        this.datos = DatosTickets.getDatosTickets();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuAbrir = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuGenerar = new javax.swing.JMenuItem();
        mnuBuscar = new javax.swing.JMenuItem();
        mnuModificar = new javax.swing.JMenuItem();
        mnuEliminar = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnuGuardarComo = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuPreferencias = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuAtribucion = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuAboutDeveloper = new javax.swing.JMenuItem();
        mnuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cinema Tickets");
        setBackground(new java.awt.Color(227, 25, 15));
        setIconImage((new javax.swing.ImageIcon(getClass().getResource("/Cinema_Tickets_Icon_FEVM_12@8x_MODIFICADO_SINGLE_500px.png"))).getImage());
        setMinimumSize(new java.awt.Dimension(650, 375));
        setName("FrmCinemaTicketSystem"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cinema_Tickets_IMG_Pantalla_Bienvenida.jpg"))); // NOI18N

        jMenu1.setText("Tickets");
        jMenu1.setToolTipText("");

        mnuAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuAbrir.setText("Abrir...");
        mnuAbrir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(mnuAbrir);
        jMenu1.add(jSeparator1);

        mnuGenerar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuGenerar.setText("Generar");
        mnuGenerar.setName("mni"); // NOI18N
        mnuGenerar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuGenerarActionPerformed(evt);
            }
        });
        jMenu1.add(mnuGenerar);

        mnuBuscar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuBuscar.setText("Buscar");
        mnuBuscar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuBuscarActionPerformed(evt);
            }
        });
        jMenu1.add(mnuBuscar);

        mnuModificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuModificar.setText("Modificar");
        mnuModificar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuModificarActionPerformed(evt);
            }
        });
        jMenu1.add(mnuModificar);

        mnuEliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuEliminar.setText("Eliminar");
        mnuEliminar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuEliminarActionPerformed(evt);
            }
        });
        jMenu1.add(mnuEliminar);
        jMenu1.add(jSeparator5);

        mnuGuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuGuardarComo.setText("Guardar como...");
        mnuGuardarComo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuGuardarComoActionPerformed(evt);
            }
        });
        jMenu1.add(mnuGuardarComo);
        jMenu1.add(jSeparator3);

        mnuPreferencias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuPreferencias.setText("Preferencias");
        mnuPreferencias.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuPreferenciasActionPerformed(evt);
            }
        });
        jMenu1.add(mnuPreferencias);
        jMenu1.add(jSeparator2);

        mnuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        mnuAtribucion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuAtribucion.setText("Atribucion - Recursos de Terceros");
        mnuAtribucion.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuAtribucionActionPerformed(evt);
            }
        });
        jMenu2.add(mnuAtribucion);
        jMenu2.add(jSeparator4);

        mnuAboutDeveloper.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuAboutDeveloper.setText("Acerca del Desarrollador...");
        mnuAboutDeveloper.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuAboutDeveloperActionPerformed(evt);
            }
        });
        jMenu2.add(mnuAboutDeveloper);

        mnuAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cinema_Tickets_Icon_FEVM_12@8x_MODIFICADO_SINGLE_18px.png"))); // NOI18N
        mnuAbout.setText("Acerca de Cinema Tickets...");
        mnuAbout.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuAboutActionPerformed(evt);
            }
        });
        jMenu2.add(mnuAbout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGenerarActionPerformed
        FrmGenerarTicket dialogGenerarTicket = new FrmGenerarTicket(this, true, TipoAccion.Creacion, null);
        dialogGenerarTicket.setVisible(true);
        editDeleteItemsVerifiyer();
    }//GEN-LAST:event_mnuGenerarActionPerformed

    private void mnuBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBuscarActionPerformed
        FrmBuscarTicket dialogBuscarTicket = new FrmBuscarTicket(this, true, TipoAccion.SoloBusqueda);
        dialogBuscarTicket.setVisible(true);
    }//GEN-LAST:event_mnuBuscarActionPerformed

    private void mnuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModificarActionPerformed
        FrmBuscarTicket dialogModificarTicket = new FrmBuscarTicket(this, true, TipoAccion.Modificacion);
        dialogModificarTicket.setVisible(true);
    }//GEN-LAST:event_mnuModificarActionPerformed

    private void mnuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEliminarActionPerformed
        FrmBuscarTicket dialogEliminarTicket = new FrmBuscarTicket(this, true, TipoAccion.Eliminacion);
        dialogEliminarTicket.setVisible(true);
        editDeleteItemsVerifiyer();
    }//GEN-LAST:event_mnuEliminarActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        if(!admTicket.guardianDelGuardado())
        {
            admTicket.saveSettings();
            System.exit(0);
        }
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAboutActionPerformed
        FrmAbout dialogAbout = new FrmAbout(this, true);
        dialogAbout.setVisible(true);
    }//GEN-LAST:event_mnuAboutActionPerformed

    private void mnuPreferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPreferenciasActionPerformed
        FrmDialogPreferencias dialogSettings = new FrmDialogPreferencias(this, true);
        dialogSettings.setVisible(true);
    }//GEN-LAST:event_mnuPreferenciasActionPerformed

    private void mnuAboutDeveloperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAboutDeveloperActionPerformed
        FrmAboutDeveloper aboutDeveloper = new FrmAboutDeveloper(this, true);
        aboutDeveloper.setVisible(true);
    }//GEN-LAST:event_mnuAboutDeveloperActionPerformed

    private void mnuAtribucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAtribucionActionPerformed
        FrmAtribucionTerceros dialogAttrib = new FrmAtribucionTerceros(this, true);
        dialogAttrib.setVisible(true);
    }//GEN-LAST:event_mnuAtribucionActionPerformed

    private void mnuGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGuardarComoActionPerformed
        if(admTicket.getTickets().size() > 0)
        {
            admTicket.guardar();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "No se han registrados Tickets todavia, genere tickets primero para poder guardarlos posteriormente por favor.", "Sin Tickets registrados", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_mnuGuardarComoActionPerformed

    private void mnuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAbrirActionPerformed
        HashMap<String, Ticket> tempTickets = null;
        if(!admTicket.guardianDelGuardado())
        {
            tempTickets = admTicket.datosTickets.abrirArchivoTicketsTexto();
            
            if(tempTickets != null & DatosTickets.getResult() == DatosTickets.OperationResult.Operacion_Exitosa)
            {
                if(admTicket.getTickets().size() > 0)
                    admTicket.getTickets().clear();
                admTicket.setTickets(tempTickets);
                admTicket.setSaved(true);
                FrmBuscarTicket abrirTickets = new FrmBuscarTicket(this, true, TipoAccion.SoloBusqueda);
                abrirTickets.setVisible(true);
                editDeleteItemsVerifiyer();
            }
        }
    }//GEN-LAST:event_mnuAbrirActionPerformed
    
    private void editDeleteItemsVerifiyer()
    {
        if(admTicket.getTickets().isEmpty())
        {
            mnuModificar.setEnabled(false);
            mnuEliminar.setEnabled(false);
            mnuBuscar.setEnabled(false);
            mnuGuardarComo.setEnabled(false);
        }
        else
        {
            mnuModificar.setEnabled(true);
            mnuEliminar.setEnabled(true);
            mnuBuscar.setEnabled(true);
            mnuGuardarComo.setEnabled(true);
        }
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        // Setting Icons
        this.mnuGenerar.setIcon(admSettings.getAddIcon());
        this.mnuAbrir.setIcon(admSettings.getSourceOpenIcon());
        this.mnuModificar.setIcon(admSettings.getEditIcon());
        this.mnuBuscar.setIcon(admSettings.getSearchIcon());
        this.mnuEliminar.setIcon(admSettings.getDeleteIcon());
        this.mnuGuardarComo.setIcon(admSettings.getSaveIcon());
        this.mnuPreferencias.setIcon(admSettings.getSettingsIcon());
        this.mnuSalir.setIcon(admSettings.getPowerExitIcon());
        this.mnuAtribucion.setIcon(admSettings.getGroupsAttributionIcon());
        this.mnuAboutDeveloper.setIcon(admSettings.getInfoIcon());
        // Setting LafTheme saved in User Settings
        admSettings.applyThemeManager(datos.getUserProperties().getProperty("currentGuiLafTheme")); // Making the Call to apply the theme
        admSettings.colorOnIconsManager(AdmSettings.ColorSetType.Startup); // Applying Colors on Icons
        // Validating if there Tickets created to enable/disable edit and delete Menu Items.
        editDeleteItemsVerifiyer();
    }//GEN-LAST:event_formWindowOpened
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JMenuItem mnuAbout;
    private javax.swing.JMenuItem mnuAboutDeveloper;
    private javax.swing.JMenuItem mnuAbrir;
    private javax.swing.JMenuItem mnuAtribucion;
    private javax.swing.JMenuItem mnuBuscar;
    private javax.swing.JMenuItem mnuEliminar;
    private javax.swing.JMenuItem mnuGenerar;
    private javax.swing.JMenuItem mnuGuardarComo;
    private javax.swing.JMenuItem mnuModificar;
    private javax.swing.JMenuItem mnuPreferencias;
    private javax.swing.JMenuItem mnuSalir;
    // End of variables declaration//GEN-END:variables
}
