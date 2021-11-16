package visual;
// Imports
import PROYECTO_CINES_CLARK_CODES.Principal;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Splash Window 
 * @author Clark - ClarkCodes
 * @since 1.0
 */
public class FrmSplash extends javax.swing.JFrame implements Runnable 
{
    Thread t; //Creo un nuevo hilo implementando la interface Runnable en esta clase para sobreescribir el método run

    public FrmSplash() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setIconImage((new javax.swing.ImageIcon(getClass().getResource("/Cinema_Tickets_Icon_FEVM_12@8x_MODIFICADO_SINGLE_500px.png"))).getImage());
        setUndecorated(true);
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Splash_Cinema_Ticket_FEVM_v2.png"))); // NOI18N
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setFocusable(false);
        jLabel1.setInheritsPopupMenu(false);
        jLabel1.setName("lblSplash"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    public void run()
    {
        try 
        {
            this.setLocationRelativeTo(null);
            this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.0f));           
            this.setVisible(true);
            Thread.sleep(2400);
            new FrmCinemaTicketsSystem().setVisible(true);
            this.dispose();
        } 
        catch (InterruptedException ex) 
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
