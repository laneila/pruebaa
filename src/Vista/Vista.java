package Vista;

import P_Controlador.Controlador;
import P_Igu.Inicio;
import P_Igu.Menu_Admin;
import P_Igu.Menu_Cajero;
import P_Modelo.Conexion_Sqlite;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Vista {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        
        UIManager.put( "TextComponent.arc", 999 );
        UIManager.put( "Component.arc", 999 );
        UIManager.put( "Button.arc", 999 );
        
        Inicio ini = new Inicio();
       
        ini.setLocationRelativeTo(null); // Centrar la interfaz en la pantalla
        ini.setVisible(true);
    

        ActionEvent e = new ActionEvent(ini, ActionEvent.ACTION_PERFORMED, "");
        
        Controlador c = new Controlador(ini, new Menu_Admin(), new Menu_Cajero(), new Conexion_Sqlite());
        c.actionPerformed(e);
    }
    
}
