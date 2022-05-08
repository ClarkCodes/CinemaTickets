
package visual;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import java.awt.Color;
import java.awt.event.KeyEvent;

/** About Window - Venta Acerca de...
 *
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public class FrmAbout extends javax.swing.JDialog
{
    public FrmAbout ( java.awt.Frame parent, boolean modal )
    {
        super( parent, modal );
        initComponents();
        this.setLocationRelativeTo( null );
        this.setBackground( new Color( 1.0f, 1.0f, 1.0f, 0.0f ) );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        lblAbout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("internationalization/Internationalization_Bundle"); // NOI18N
        setTitle(bundle.getString("lk_about")); // NOI18N
        setBackground(new java.awt.Color(24, 55, 77));
        setUndecorated(true);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                formKeyReleased(evt);
            }
        });

        lblAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CinemaTickets_About_v1_6-public-stable.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAbout)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAbout)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if ( evt.getKeyCode() == KeyEvent.VK_ESCAPE || evt.getKeyCode() == KeyEvent.VK_ENTER )
            dispose();
    }//GEN-LAST:event_formKeyReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        dispose();
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAbout;
    // End of variables declaration//GEN-END:variables
}
