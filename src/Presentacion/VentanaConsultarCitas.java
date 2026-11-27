package Presentacion;

import Conceptos.Cita;
import Conceptos.Cliente;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana modal para consultar y filtrar las citas registradas.
 * 
 * @author fuent
 */
public class VentanaConsultarCitas extends javax.swing.JDialog {

    //arraylist citas
    private ArrayList<Cita> listaCitas;

    /**
     * Constructor que inicializa los componentes y carga todas las citas en la tabla.
     */
    public VentanaConsultarCitas(java.awt.Frame parent, boolean modal, ArrayList<Cita> listaCitas) {
        super(parent, modal);
        initComponents();
        this.listaCitas = listaCitas;
        LlenarTabla(this.listaCitas);
    }

    /**
     * Llena la tabla visual con la lista de citas indicada.
     */
    private void LlenarTabla(ArrayList<Cita> citasAMostrar) {
        //encabezados de las columnas de la tabla
        Vector<String> titulos = new Vector<>();
        titulos.addElement("ID");
        titulos.addElement("Nombre");
        titulos.addElement("Fecha");

        //estructura para almacenar las filas de datos
        Vector<Vector<String>> filas = new Vector<>();

        //poblado de filas con la informacion de cada cita
        if (citasAMostrar != null) {
            for (Cita c : citasAMostrar) {
                Vector<String> fila = new Vector<>();
                fila.addElement(c.getIdentificacion());
                String nombreCliente = (c.getCliente() != null && c.getCliente().getNombre() != null)
                        ? c.getCliente().getNombre()
                        : "";
                fila.addElement(nombreCliente);
                fila.addElement(c.getFecha());
                filas.addElement(fila);
            }
        }

        //asignacion del modelo de datos no editable a la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel(filas, titulos) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        this.tableCitas.setModel(modeloTabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCliente = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelPropietario = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        textFieldNombre = new javax.swing.JTextField();
        textFieldTelefono = new javax.swing.JTextField();
        textFieldPropietario = new javax.swing.JTextField();
        textFieldEmail = new javax.swing.JTextField();
        buttonBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCitas = new javax.swing.JTable();
        buttonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Citas");

        labelCliente.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelCliente.setText("Cliente");

        labelNombre.setText("Nombre");

        labelTelefono.setText("Telefono");

        labelPropietario.setText("Propietario");

        labelEmail.setText("Email");

        buttonBuscar.setText("Buscar");
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });

        tableCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableCitas);

        buttonSalir.setText("Salir");
        buttonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCliente)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(labelTelefono)
                                .addGap(10, 10, 10)
                                .addComponent(textFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(textFieldPropietario))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(textFieldEmail)))
                        .addGap(25, 25, 25)
                        .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNombre)
                            .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTelefono)
                            .addComponent(textFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPropietario)
                            .addComponent(textFieldPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEmail)
                            .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(buttonSalir)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        //obtener textos de los filtros
        String nombre = textFieldNombre.getText().trim();
        String telefono = textFieldTelefono.getText().trim();
        String propietario = textFieldPropietario.getText().trim();
        String email = textFieldEmail.getText().trim();

        //si todos los filtros estan vacios, mostrar todas las citas
        if (nombre.isEmpty() && telefono.isEmpty() && propietario.isEmpty() && email.isEmpty()) {
            LlenarTabla(this.listaCitas);
            return;
        }

        //filtrar aplicando condicion AND y coincidencia exacta
        ArrayList<Cita> filtradas = new ArrayList<>();
        if (this.listaCitas != null) {
            for (Cita c : this.listaCitas) {
                Cliente cli = c.getCliente();
                if (cli == null) {
                    continue;
                }
                String cliNombre = (cli.getNombre() != null) ? cli.getNombre().trim() : "";
                String cliTelefono = (cli.getTelefono() != null) ? cli.getTelefono().trim() : "";
                String cliPropietario = (cli.getPropietario() != null) ? cli.getPropietario().trim() : "";
                String cliEmail = (cli.getEmail() != null) ? cli.getEmail().trim() : "";

                boolean coincide = true;
                if (!nombre.isEmpty() && !cliNombre.equalsIgnoreCase(nombre)) {
                    coincide = false;
                }
                if (!telefono.isEmpty() && !cliTelefono.equalsIgnoreCase(telefono)) {
                    coincide = false;
                }
                if (!propietario.isEmpty() && !cliPropietario.equalsIgnoreCase(propietario)) {
                    coincide = false;
                }
                if (!email.isEmpty() && !cliEmail.equalsIgnoreCase(email)) {
                    coincide = false;
                }

                if (coincide) {
                    filtradas.add(c);
                }
            }
        }

        //actualizar tabla con resultados filtrados
        LlenarTabla(filtradas);
    }

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        //cerrar ventana
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPropietario;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JTable tableCitas;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldPropietario;
    private javax.swing.JTextField textFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
