package PROYECTO_CINES_CLARK_CODES;
/* LICENSE 
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import javax.swing.UIManager;
import visual.FrmSplash;

/** 
 * Proyecto de Curso
 * Programacion Orientada a Objetos - SOF-S-MA-2-2
 * Sistema de Administracion de Cines - Modulo de Tickets
 * @author Clark - Grupo #6
 */
public class Principal 
{
    public static void main(String[] args) 
    {
        // FlatLaf Customizations
        UIManager.put("Component.arc", 5);
        UIManager.put("TextComponent.arc", 5);
        UIManager.put("Button.arc", 10);
        
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater( () -> new Thread( new FrmSplash() ).start() );
    }
    
}
