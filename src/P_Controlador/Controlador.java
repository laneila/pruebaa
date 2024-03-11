package P_Controlador;

import P_Modelo.*;
import P_Igu.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener{
    
    MetodosEmpleados metem = new MetodosEmpleados();
    Inicio ini = new Inicio();
    Menu_Admin adm = new Menu_Admin();
    Menu_Cajero caj = new Menu_Cajero();
    Conexion_Sqlite conexsqlite = new Conexion_Sqlite();
    
    public Controlador(Inicio ini, Menu_Admin adm, Menu_Cajero caj, Conexion_Sqlite conexsqlite) {
        this.ini = ini;
        this.adm = adm;
        this.caj = caj;
        this.metem = metem;
        this.conexsqlite = conexsqlite;
        
        this.ini.btnLogin.addActionListener(this);
        
    }
    
    public void autenticarUsuarios(){
        String empleado = ini.InputUser.getText();
        String clave = new String(ini.InputPsswordUser.getPassword());
        

        if(empleado.equals("brayanxd") && clave.equals("123456")) {
            ini.setVisible(false);
            adm.setVisible(true);
            adm.setLocationRelativeTo(null);
        }
            
       else if(empleado.equals("andresxd") && clave.equals("123456")) {
            ini.setVisible(false);
            caj.setVisible(true);
            caj.setLocationRelativeTo(null);
                
        }
            
        else{
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Ha ocurrido un error", JOptionPane.WARNING_MESSAGE);
            ini.InputUser.requestFocus();
        }
        
    }
    
     
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == ini.btnLogin) {
            autenticarUsuarios();
        } 
    }
}
