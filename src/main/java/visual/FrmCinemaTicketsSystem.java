
package visual;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import control.AdmSettings;
import control.AdmTicket;
import control.Commons;
import data.DatosTickets;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JOptionPane;
import model.Ticket;

/** Cinema Tickets System Main {@code JFrame} Class
 *
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public class FrmCinemaTicketsSystem extends javax.swing.JFrame
{
    /** Creates new form FrmCinemaTicketsSystem */
    // AdmTicket - Inicializa en AdmTicket para que los datos quemados se inicialicen y poder usarlos.
    private final AdmTicket admTicket;
    private final AdmSettings admSettings;
    private final DatosTickets datos;

    public FrmCinemaTicketsSystem ()
    {
        this.admTicket = AdmTicket.getAdm();
        this.datos = admTicket.getDatosTickets();
        this.admSettings = AdmSettings.getAdmSettings();
        initComponents();
        this.setLocationRelativeTo( null );
        this.setIconImage( ( new javax.swing.ImageIcon( getClass().getResource( "/" + AdmSettings.getCINEMA_TICKETS_APP_ICON() ) ) ).getImage() );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        labelWelcomePicture = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuAbrir = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuGenerar = new javax.swing.JMenuItem();
        mnuBuscar = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnuGuardarComo = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuPreferencias = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuSalir = new javax.swing.JMenuItem();
        mnuAdmin = new javax.swing.JMenu();
        mnuMovies = new javax.swing.JMenuItem();
        mnuShows = new javax.swing.JMenuItem();
        mnuTheaters = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mnuAtribucion = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuAboutProject = new javax.swing.JMenuItem();
        mnuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("internationalization/Internationalization_Bundle"); // NOI18N
        setTitle(bundle.getString("lk_cinema_tickets")); // NOI18N
        setBackground(new java.awt.Color(227, 25, 15));
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

        labelWelcomePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cinema_Tickets_IMG_Pantalla_Bienvenida_es.jpg"))); // NOI18N

        jMenu1.setText(bundle.getString("lk_tickets")); // NOI18N
        jMenu1.setToolTipText("");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mnuAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuAbrir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuAbrir.setText(bundle.getString("lk_open")); // NOI18N
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
        mnuGenerar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuGenerar.setText(bundle.getString("lk_generate")); // NOI18N
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
        mnuBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuBuscar.setText(bundle.getString("lk_search")); // NOI18N
        mnuBuscar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuBuscarActionPerformed(evt);
            }
        });
        jMenu1.add(mnuBuscar);
        jMenu1.add(jSeparator5);

        mnuGuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuGuardarComo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuGuardarComo.setText(bundle.getString("lk_save_as")); // NOI18N
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
        mnuPreferencias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuPreferencias.setText(bundle.getString("lk_settings")); // NOI18N
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
        mnuSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuSalir.setText(bundle.getString("lk_exit")); // NOI18N
        mnuSalir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSalir);

        jMenuBar1.add(jMenu1);

        mnuAdmin.setText(bundle.getString("lk_administration")); // NOI18N
        mnuAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mnuMovies.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuMovies.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuMovies.setText(bundle.getString("lk_movies")); // NOI18N
        mnuMovies.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuMoviesActionPerformed(evt);
            }
        });
        mnuAdmin.add(mnuMovies);

        mnuShows.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuShows.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuShows.setText(bundle.getString("lk_shows")); // NOI18N
        mnuShows.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuShowsActionPerformed(evt);
            }
        });
        mnuAdmin.add(mnuShows);

        mnuTheaters.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuTheaters.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuTheaters.setText(bundle.getString("lk_theaters")); // NOI18N
        mnuTheaters.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuTheatersActionPerformed(evt);
            }
        });
        mnuAdmin.add(mnuTheaters);

        jMenuBar1.add(mnuAdmin);

        mnuHelp.setText(bundle.getString("lk_help")); // NOI18N
        mnuHelp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mnuAtribucion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuAtribucion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuAtribucion.setText(bundle.getString("lk_attribution_title")); // NOI18N
        mnuAtribucion.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuAtribucionActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuAtribucion);
        mnuHelp.add(jSeparator4);

        mnuAboutProject.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuAboutProject.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuAboutProject.setText(bundle.getString("lk_about_project")); // NOI18N
        mnuAboutProject.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuAboutProjectActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuAboutProject);

        mnuAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuAbout.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CinemaTickets_Icon_Vectorizado_Image_18px_300ppi.png"))); // NOI18N
        mnuAbout.setText(bundle.getString("lk_about_cinema_tickets")); // NOI18N
        mnuAbout.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mnuAboutActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuAbout);

        jMenuBar1.add(mnuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelWelcomePicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelWelcomePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGenerarActionPerformed
        FrmGenerarTicket dialogGenerarTicket = new FrmGenerarTicket( this, true, Commons.WindowMode.Creacion, null );
        dialogGenerarTicket.setVisible( true );
        editDeleteItemsVerifiyer();
    }//GEN-LAST:event_mnuGenerarActionPerformed

    private void mnuBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBuscarActionPerformed
        FrmBuscarTicket dialogBuscarModificarEliminarTicket = new FrmBuscarTicket( this, true );
        dialogBuscarModificarEliminarTicket.setVisible( true );
    }//GEN-LAST:event_mnuBuscarActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        if ( !admTicket.guardianDelGuardado() )
        {
            admTicket.saveSettings();
            System.exit( 0 );
        }
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAboutActionPerformed
        FrmAbout dialogAbout = new FrmAbout( this, true );
        dialogAbout.setVisible( true );
    }//GEN-LAST:event_mnuAboutActionPerformed

    private void mnuPreferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPreferenciasActionPerformed
        FrmDialogPreferencias dialogSettings = new FrmDialogPreferencias( this, true );
        dialogSettings.setVisible( true );
    }//GEN-LAST:event_mnuPreferenciasActionPerformed

    private void mnuAboutProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAboutProjectActionPerformed
        FrmAboutProject aboutDeveloper = new FrmAboutProject( this, true );
        aboutDeveloper.setVisible( true );
    }//GEN-LAST:event_mnuAboutProjectActionPerformed

    private void mnuAtribucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAtribucionActionPerformed
        FrmAtribucionTerceros dialogAttrib = new FrmAtribucionTerceros( this, true );
        dialogAttrib.setVisible( true );
    }//GEN-LAST:event_mnuAtribucionActionPerformed

    private void mnuGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGuardarComoActionPerformed
        if ( !admTicket.getTickets().isEmpty() )
        {
            admTicket.guardar();
        }
        else
        {
            JOptionPane.showMessageDialog( this, AdmSettings.getLanguageBundle().getString( "lk_no_tickets_msj" ), AdmSettings.getLanguageBundle().getString( "lk_no_tickets_title" ), JOptionPane.INFORMATION_MESSAGE );
        }
    }//GEN-LAST:event_mnuGuardarComoActionPerformed

    private void mnuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAbrirActionPerformed
        HashMap<String, Ticket> openedTickets;
        
        if ( !admTicket.guardianDelGuardado() )
        {
            openedTickets = datos.openTicketsFile();

            if ( openedTickets != null & DatosTickets.getResult() == DatosTickets.OperationResult.Operacion_Exitosa )
            {
                if ( !admTicket.getTickets().isEmpty() )
                    admTicket.getTickets().clear();
                admTicket.setTickets( openedTickets );
                admTicket.setSaved( true );
                FrmBuscarTicket abrirTickets = new FrmBuscarTicket( this, true );
                abrirTickets.setVisible( true );
                editDeleteItemsVerifiyer();
            }
        }
    }//GEN-LAST:event_mnuAbrirActionPerformed

    /** Verifies if currently there are tickets available to search or to save,
     * this is if there are opened or generated tickets, if so, it enables the 
     * respective menus, it disables them otherwise
     * 
     * @since 1.4
     */
    private void editDeleteItemsVerifiyer ()
    {
        if ( admTicket.getTickets().isEmpty() )
        {
            mnuBuscar.setEnabled( false );
            mnuGuardarComo.setEnabled( false );
        }
        else
        {
            mnuBuscar.setEnabled( true );
            mnuGuardarComo.setEnabled( true );
        }
    }

    /** Sets the application current locale, this affects between some things the application language
     * 
     * @since 1.6
     * @see control.AdmSettings
     */
    public void setLocaleInApp()
    {
        Locale.setDefault( AdmSettings.getAppLanguage().getLocale() );
        
        if ( this.isVisible() )
            setWelcomeImage ();
    }
    
    /** Updates the this window components language to make them match with the 
     * current language set by a user
     * 
     * @since 1.6
     */
    public void updateComponentsLanguage()
    {
        mnuAbrir.setText( AdmSettings.getLanguageBundle().getString( "lk_open" ) );
        mnuGenerar.setText( AdmSettings.getLanguageBundle().getString( "lk_generate" ) );
        mnuBuscar.setText( AdmSettings.getLanguageBundle().getString( "lk_search" ) );
        mnuGuardarComo.setText( AdmSettings.getLanguageBundle().getString( "lk_save_as" ) );
        mnuPreferencias.setText( AdmSettings.getLanguageBundle().getString( "lk_settings" ) );
        mnuSalir.setText( AdmSettings.getLanguageBundle().getString( "lk_exit" ) );
        mnuAdmin.setText( AdmSettings.getLanguageBundle().getString( "lk_administration" ) );
        mnuHelp.setText( AdmSettings.getLanguageBundle().getString( "lk_help" ) );
        mnuAtribucion.setText( AdmSettings.getLanguageBundle().getString( "lk_attribution_title" ) );
        mnuAboutProject.setText( AdmSettings.getLanguageBundle().getString( "lk_about_project" ) );
        mnuAbout.setText( AdmSettings.getLanguageBundle().getString( "lk_about_cinema_tickets" ) );
        mnuMovies.setText( AdmSettings.getLanguageBundle().getString( "lk_movies" ) );
        mnuShows.setText( AdmSettings.getLanguageBundle().getString( "lk_shows" ) );
        mnuTheaters.setText( AdmSettings.getLanguageBundle().getString( "lk_theaters" ) );
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        // Setting Icons
        this.mnuGenerar.setIcon( admSettings.getAddIcon() );
        this.mnuAbrir.setIcon( admSettings.getSourceOpenIcon() );
        this.mnuBuscar.setIcon( admSettings.getSearchIcon() );
        this.mnuGuardarComo.setIcon( admSettings.getSaveIcon() );
        this.mnuPreferencias.setIcon( admSettings.getSettingsIcon() );
        this.mnuSalir.setIcon( admSettings.getPowerExitIcon() );
        this.mnuMovies.setIcon( admSettings.getMoviesIcon() );
        this.mnuShows.setIcon( admSettings.getShowsIcon() );
        this.mnuTheaters.setIcon( admSettings.getTheatersIcon() );
        this.mnuAtribucion.setIcon( admSettings.getGroupsAttributionIcon() );
        this.mnuAboutProject.setIcon( admSettings.getInfoIcon() );
        
        // Validating if there are Tickets created to enable/disable edit and delete Menu Items.
        editDeleteItemsVerifiyer();
    }//GEN-LAST:event_formWindowOpened

    private void setWelcomeImage ()
    {
        labelWelcomePicture.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/Cinema_Tickets_IMG_Pantalla_Bienvenida_" + AdmSettings.getAppLanguage().getLanguage() + ".jpg" ) ) );
    }
    
    private void mnuMoviesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mnuMoviesActionPerformed
    {//GEN-HEADEREND:event_mnuMoviesActionPerformed
        JOptionPane.showMessageDialog( this, AdmSettings.getLanguageBundle().getString( "lk_feature_na" ), AdmSettings.getLanguageBundle().getString( "lk_coming_soon" ), JOptionPane.INFORMATION_MESSAGE );
    }//GEN-LAST:event_mnuMoviesActionPerformed

    private void mnuShowsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mnuShowsActionPerformed
    {//GEN-HEADEREND:event_mnuShowsActionPerformed
        JOptionPane.showMessageDialog( this, AdmSettings.getLanguageBundle().getString( "lk_feature_na" ), AdmSettings.getLanguageBundle().getString( "lk_coming_soon" ), JOptionPane.INFORMATION_MESSAGE );
    }//GEN-LAST:event_mnuShowsActionPerformed

    private void mnuTheatersActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mnuTheatersActionPerformed
    {//GEN-HEADEREND:event_mnuTheatersActionPerformed
        JOptionPane.showMessageDialog( this, AdmSettings.getLanguageBundle().getString( "lk_feature_na" ), AdmSettings.getLanguageBundle().getString( "lk_coming_soon" ), JOptionPane.INFORMATION_MESSAGE );
    }//GEN-LAST:event_mnuTheatersActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JLabel labelWelcomePicture;
    private javax.swing.JMenuItem mnuAbout;
    private javax.swing.JMenuItem mnuAboutProject;
    private javax.swing.JMenuItem mnuAbrir;
    private javax.swing.JMenu mnuAdmin;
    private javax.swing.JMenuItem mnuAtribucion;
    private javax.swing.JMenuItem mnuBuscar;
    private javax.swing.JMenuItem mnuGenerar;
    private javax.swing.JMenuItem mnuGuardarComo;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenuItem mnuMovies;
    private javax.swing.JMenuItem mnuPreferencias;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenuItem mnuShows;
    private javax.swing.JMenuItem mnuTheaters;
    // End of variables declaration//GEN-END:variables
}
