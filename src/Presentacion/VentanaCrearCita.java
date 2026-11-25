package Presentacion;

import Conceptos.Cita;
import Conceptos.Cliente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Ventana modal para solicitar y crear una nueva cita.
 * 
 * @author fuent
 */
public class VentanaCrearCita extends javax.swing.JDialog {

    //listas de datos
    private ArrayList<Cita> listaCitas;
    private ArrayList<Cliente> listaClientes;

    /**
     * Constructor que inicializa los componentes, el consecutivo y la lista de clientes.
     */
    public VentanaCrearCita(java.awt.Frame parent, boolean modal, ArrayList<Cita> listaCitas, ArrayList<Cliente> listaClientes) {
        super(parent, modal);
        initComponents();
        this.listaCitas = listaCitas;
        this.listaClientes = listaClientes;
        this.textFieldID.setEditable(false);
        this.textFieldID.setText(generarNuevoId());
        cargarClientes();
    }

    /**
     * Genera un nuevo ID consecutivo automatico para la cita.
     */
    private String generarNuevoId() {
        int maxId = 0;
        if (this.listaCitas != null) {
            for (Cita c : this.listaCitas) {
                try {
                    int idNum = Integer.parseInt(c.getIdentificacion().trim());
                    if (idNum > maxId) {
                        maxId = idNum;
                    }
                } catch (NumberFormatException e) {
                    //ignorar identificaciones no numericas
                }
            }
        }
        return String.valueOf(maxId == 0 ? 100 : maxId + 1);
    }

    /**
     * Carga los clientes disponibles en el combo box.
     */
    private void cargarClientes() {
        this.comboBoxCliente.removeAllItems();
        if (this.listaClientes != null) {
            for (Cliente c : this.listaClientes) {
                this.comboBoxCliente.addItem(c);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelID = new javax.swing.JLabel();
        textFieldID = new javax.swing.JTextField();
        labelCliente = new javax.swing.JLabel();
        comboBoxCliente = new javax.swing.JComboBox<>();
        buttonAgregarCliente = new javax.swing.JButton();
        labelObservaciones = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaObservaciones = new javax.swing.JTextArea();
        buttonSalvar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear Cita");

        labelID.setText("ID");

        labelCliente.setText("Cliente");

        buttonAgregarCliente.setText("+");
        buttonAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarClienteActionPerformed(evt);
            }
        });

        labelObservaciones.setText("Observaciones");

        textAreaObservaciones.setColumns(20);
        textAreaObservaciones.setLineWrap(true);
        textAreaObservaciones.setRows(5);
        textAreaObservaciones.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textAreaObservaciones);

        buttonSalvar.setText("Salvar");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelObservaciones)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                    .addComponent(labelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(buttonAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelID)
                    .addComponent(textFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCliente)
                    .addComponent(comboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAgregarCliente))
                .addGap(18, 18, 18)
                .addComponent(labelObservaciones)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSalvar)
                    .addComponent(buttonCancelar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {
        //guardar cantidad previa de clientes y abrir ventana de clientes
        int cantidadAntes = (this.listaClientes != null) ? this.listaClientes.size() : 0;
        VentanaClientes ventana = new VentanaClientes((java.awt.Frame) this.getOwner(), true, this.listaClientes);
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);

        //recargar combo y seleccionar el nuevo cliente si se agrego alguno
        cargarClientes();
        if (this.listaClientes != null && this.listaClientes.size() > cantidadAntes) {
            comboBoxCliente.setSelectedIndex(this.listaClientes.size() - 1);
        }
    }

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        //validar cliente seleccionado
        Cliente clienteSeleccionado = (Cliente) comboBoxCliente.getSelectedItem();
        if (clienteSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar o agregar un cliente para crear la cita");
            return;
        }

        //generar consecutivo y fecha actual dd-MM-yyyy
        String id = generarNuevoId();
        String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String observaciones = textAreaObservaciones.getText().trim();

        //crear nueva cita
        Cita nuevaCita = new Cita();
        nuevaCita.setIdentificacion(id);
        nuevaCita.setCliente(clienteSeleccionado);
        nuevaCita.setFecha(fechaActual);
        nuevaCita.setObservaciones(observaciones);
        nuevaCita.setVeterinario(null);

        //agregar a la lista y guardar en CITAS.DAT
        if (this.listaCitas == null) {
            this.listaCitas = new ArrayList<>();
        }
        this.listaCitas.add(nuevaCita);
        Util.GestorDAT.guardarCitas(this.listaCitas);

        //mostrar dialogo de confirmacion con el numero generado
        JOptionPane.showMessageDialog(
            this,
            "Su solicitud ha sido ingresada exitosamente,\nNumero " + id,
            "# Cita",
            JOptionPane.INFORMATION_MESSAGE
        );

        //mantener ventana abierta y preparar siguiente consecutivo
        textFieldID.setText(generarNuevoId());
        textAreaObservaciones.setText("");
    }

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        //cerrar dialogo sin realizar ninguna operacion
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAgregarCliente;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JComboBox<Cliente> comboBoxCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelObservaciones;
    private javax.swing.JTextArea textAreaObservaciones;
    private javax.swing.JTextField textFieldID;
    // End of variables declaration//GEN-END:variables
}
