
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
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import model.Commons;

/** Tickets Comfirmation Window
 *
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public class FrmConfirmarGeneracion extends javax.swing.JDialog
{   // AdmTicket Principal
    private final AdmTicket admTicket;

    public FrmConfirmarGeneracion ( java.awt.Frame parent, boolean modal )
    {
        super( parent, modal );
        initComponents();
        this.setLocationRelativeTo( null );
        getRootPane().setDefaultButton( btnConfirmar );
        admTicket = AdmTicket.getAdm();
        this.setIconImage( ( new javax.swing.ImageIcon( getClass().getResource( "/Cinema_Tickets_Icon_12@8x_MODIFICADO_SINGLE_500px.png" ) ) ).getImage() );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        popUpMnuConfirmation = new javax.swing.JPopupMenu();
        popUpMnuitCopy = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDetallesTicket = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        popUpMnuitCopy.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("internationalization/Internationalization_Bundle"); // NOI18N
        popUpMnuitCopy.setText(bundle.getString("lk_copy")); // NOI18N
        popUpMnuitCopy.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                popUpMnuitCopyActionPerformed(evt);
            }
        });
        popUpMnuConfirmation.add(popUpMnuitCopy);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(bundle.getString("lk_confirm_ticket_generation")); // NOI18N
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(bundle.getString("lk_ticket_generation_confirmation_question")); // NOI18N

        txaDetallesTicket.setEditable(false);
        txaDetallesTicket.setColumns(20);
        txaDetallesTicket.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txaDetallesTicket.setRows(5);
        txaDetallesTicket.setComponentPopupMenu(popUpMnuConfirmation);
        txaDetallesTicket.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                txaDetallesTicketMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(txaDetallesTicket);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(bundle.getString("lk_ticket_details")); // NOI18N

        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnConfirmar.setText(bundle.getString("lk_confirm_generate")); // NOI18N
        btnConfirmar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        admTicket.generarTicket();
        admTicket.setTicketGeneradoExitosamente( true );
        JOptionPane.showMessageDialog( this, AdmSettings.getLanguageBundle().getString( "lk_ticket_successfuly_generated" ), AdmSettings.getLanguageBundle().getString( "lk_ticket_generation_title" ), JOptionPane.INFORMATION_MESSAGE );
        this.dispose();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        admTicket.setTicket( null );
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txaDetallesTicket.setText("\n" + AdmSettings.getLanguageBundle().getString( "lk_generation_date_label" ) + admTicket.getTicket().getFechaGeneracion().format(Commons.getFormatoDateTime(Commons.TypeFormatoDateTime.FechaLarga ) ) + admTicket.getTicket() );
        popUpMnuitCopy.setIcon( AdmSettings.getAdmSettings().getCopyIcon() );
    }//GEN-LAST:event_formWindowOpened

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER )
            btnConfirmar.doClick();
        if ( evt.getKeyCode() == KeyEvent.VK_ESCAPE )
            btnCancelar.doClick();
    }//GEN-LAST:event_formKeyReleased

    private void txaDetallesTicketMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_txaDetallesTicketMousePressed
    {//GEN-HEADEREND:event_txaDetallesTicketMousePressed
        if ( evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2 )
            txaDetallesTicket.selectAll();
    }//GEN-LAST:event_txaDetallesTicketMousePressed

    private void popUpMnuitCopyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_popUpMnuitCopyActionPerformed
    {//GEN-HEADEREND:event_popUpMnuitCopyActionPerformed
        txaDetallesTicket.copy();
    }//GEN-LAST:event_popUpMnuitCopyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popUpMnuConfirmation;
    private javax.swing.JMenuItem popUpMnuitCopy;
    private javax.swing.JTextArea txaDetallesTicket;
    // End of variables declaration//GEN-END:variables
}
