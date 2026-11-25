package Presentacion;

import Conceptos.Cita;
import Conceptos.Cliente;
import Conceptos.Servicio;
import Conceptos.Veterinario;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Ventana principal (Escritorio) de la aplicación.
 * Actúa como lanzador visual para Citas (Consultar, Solicitar, Atender),
 * Clientes, Servicios y Médicos Veterinarios.
 * 
 * @author fuent
 */
public class Escritorio extends javax.swing.JFrame {

    //listas de datos
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Servicio> listaServicios;
    private ArrayList<Veterinario> listaVeterinarios;
    private ArrayList<Cita> listaCitas;

    /**
     * Constructor por defecto.
     */
    public Escritorio() {
        initComponents();
        this.listaClientes = new ArrayList<>();
        this.listaServicios = new ArrayList<>();
        this.listaVeterinarios = new ArrayList<>();
        this.listaCitas = new ArrayList<>();
        this.setLocationRelativeTo(null);
        this.setSize(1024, 768);
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        cargarIconos();
    }

    /**
     * Constructor temporal de 3 listas para compatibilidad mientras se integra Main.
     */
    public Escritorio(ArrayList<Cliente> clientes, ArrayList<Servicio> servicios, ArrayList<Veterinario> veterinarios) {
        this(clientes, servicios, veterinarios, new ArrayList<>());
    }

    /**
     * Constructor que recibe las 4 listas de datos cargadas desde los archivos .DAT.
     */
    public Escritorio(ArrayList<Cliente> clientes, ArrayList<Servicio> servicios, ArrayList<Veterinario> veterinarios, ArrayList<Cita> citas) {
        this();
        this.listaClientes = clientes;
        this.listaServicios = servicios;
        this.listaVeterinarios = veterinarios;
        this.listaCitas = citas;
    }

    /**
     * Carga las imágenes de la carpeta Imagenes/ y las asigna a los botones.
     */
    private void cargarIconos() {
        //cargar imagenes para los botones
        try {
            File imgConsultar = new File("Imagenes/consultar.png");
            if (imgConsultar.exists()) {
                buttonConsultar.setIcon(new ImageIcon(imgConsultar.getAbsolutePath()));
            }
            File imgSolicitar = new File("Imagenes/solicitar.png");
            if (imgSolicitar.exists()) {
                buttonSolicitar.setIcon(new ImageIcon(imgSolicitar.getAbsolutePath()));
            }
            File imgAtender = new File("Imagenes/atender.png");
            if (imgAtender.exists()) {
                buttonAtender.setIcon(new ImageIcon(imgAtender.getAbsolutePath()));
            }
            File imgClientes = new File("Imagenes/clientes.png");
            if (imgClientes.exists()) {
                buttonClientes.setIcon(new ImageIcon(imgClientes.getAbsolutePath()));
            }
            File imgServicios = new File("Imagenes/servicios.png");
            if (imgServicios.exists()) {
                buttonServicios.setIcon(new ImageIcon(imgServicios.getAbsolutePath()));
            }
            File imgVeterinarios = new File("Imagenes/veterinarios.png");
            if (imgVeterinarios.exists()) {
                buttonVeterinarios.setIcon(new ImageIcon(imgVeterinarios.getAbsolutePath()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonConsultar = new javax.swing.JButton();
        buttonSolicitar = new javax.swing.JButton();
        buttonAtender = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        buttonClientes = new javax.swing.JButton();
        buttonServicios = new javax.swing.JButton();
        buttonVeterinarios = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuUtil = new javax.swing.JMenu();
        menuItemExportar = new javax.swing.JMenuItem();
        menuItemImportar = new javax.swing.JMenuItem();
        menuItemLimpiar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Veterinaria Plus");

        buttonConsultar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonConsultar.setText("Consultar");
        buttonConsultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonConsultar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConsultarActionPerformed(evt);
            }
        });

        buttonSolicitar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonSolicitar.setText("Solicitar");
        buttonSolicitar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonSolicitar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSolicitarActionPerformed(evt);
            }
        });

        buttonAtender.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonAtender.setText("Atender");
        buttonAtender.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonAtender.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtenderActionPerformed(evt);
            }
        });

        buttonClientes.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonClientes.setText("Clientes");
        buttonClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClientesActionPerformed(evt);
            }
        });

        buttonServicios.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonServicios.setText("Servicios");
        buttonServicios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonServicios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonServiciosActionPerformed(evt);
            }
        });

        buttonVeterinarios.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonVeterinarios.setText("Médicos Veterinarios");
        buttonVeterinarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonVeterinarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonVeterinarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVeterinariosActionPerformed(evt);
            }
        });

        menuUtil.setText("Util");

        menuItemExportar.setText("Exportar");
        menuItemExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExportarActionPerformed(evt);
            }
        });
        menuUtil.add(menuItemExportar);

        menuItemImportar.setText("Importar");
        menuItemImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemImportarActionPerformed(evt);
            }
        });
        menuUtil.add(menuItemImportar);

        menuItemLimpiar.setText("Limpiar");
        menuItemLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLimpiarActionPerformed(evt);
            }
        });
        menuUtil.add(menuItemLimpiar);

        menuBar.add(menuUtil);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(buttonSolicitar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(buttonAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(buttonServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(buttonVeterinarios, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSolicitar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVeterinarios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConsultarActionPerformed(java.awt.event.ActionEvent evt) {
        //abrir ventana de consultar citas
        VentanaConsultarCitas ventana = new VentanaConsultarCitas(this, true, this.listaCitas);
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }

    private void buttonSolicitarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO Paso 3: abrir ventana de crear cita
        JOptionPane.showMessageDialog(this, "Ventana Solicitar Cita pendiente (Paso 3)");
    }

    private void buttonAtenderActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO Paso 4: abrir ventana de atender cita
        JOptionPane.showMessageDialog(this, "Ventana Atender Cita pendiente (Paso 4)");
    }

    private void buttonVeterinariosActionPerformed(java.awt.event.ActionEvent evt) {
        //abrir ventana de veterinarios
        VentanaVeterinarios ventana = new VentanaVeterinarios(this, true, this.listaVeterinarios, this.listaServicios);
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }

    private void buttonServiciosActionPerformed(java.awt.event.ActionEvent evt) {
        //abrir ventana de servicios
        VentanaServicios ventana = new VentanaServicios(this, true, this.listaServicios);
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }

    private void buttonClientesActionPerformed(java.awt.event.ActionEvent evt) {
        //abrir ventana de clientes
        VentanaClientes ventana = new VentanaClientes(this, true, this.listaClientes);
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }

    private void menuItemExportarActionPerformed(java.awt.event.ActionEvent evt) {
        //confirmar exportacion
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Confirme si desea exportar los datos a los archivos XML.\nEsto sobrescribirá los archivos XML actuales.",
            "Confirmar exportación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        //exportar todos los conceptos a xml
        Util.GestorImportExport.exportarTodo(this.listaClientes, this.listaServicios, this.listaVeterinarios, this.listaCitas);
        JOptionPane.showMessageDialog(this, "Se exportaron los datos correctamente");
    }

    private void menuItemImportarActionPerformed(java.awt.event.ActionEvent evt) {
        //confirmar importacion
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Confirme si desea importar los datos desde los archivos XML.\nEsto reemplazará todos los datos actuales.",
            "Confirmar importación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        //importar todos los conceptos desde xml
        Util.GestorImportExport.importarTodo(this.listaClientes, this.listaServicios, this.listaVeterinarios, this.listaCitas);
        JOptionPane.showMessageDialog(this, "Se importaron los datos correctamente");
    }

    private void menuItemLimpiarActionPerformed(java.awt.event.ActionEvent evt) {
        //confirmar limpieza
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Confirme si desea limpiar todos los datos y archivos .DAT.\nEsta acción no se puede deshacer.",
            "Confirmar limpieza",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        //limpiar listas en memoria y archivos .dat
        Util.GestorImportExport.limpiarTodo(this.listaClientes, this.listaServicios, this.listaVeterinarios, this.listaCitas);
        JOptionPane.showMessageDialog(this, "Se limpiaron todos los datos correctamente");
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Escritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Escritorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAtender;
    private javax.swing.JButton buttonClientes;
    private javax.swing.JButton buttonConsultar;
    private javax.swing.JButton buttonServicios;
    private javax.swing.JButton buttonSolicitar;
    private javax.swing.JButton buttonVeterinarios;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemExportar;
    private javax.swing.JMenuItem menuItemImportar;
    private javax.swing.JMenuItem menuItemLimpiar;
    private javax.swing.JMenu menuUtil;
    // End of variables declaration//GEN-END:variables
}
