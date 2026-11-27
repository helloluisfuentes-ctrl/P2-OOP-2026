package Presentacion;

import Conceptos.Cita;
import Conceptos.Cliente;
import Conceptos.Veterinario;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana modal para atender una cita existente, asignar veterinario,
 * editar observaciones y registrar diagnosticos y tratamientos.
 * 
 * @author fuent
 */
public class VentanaAtenderCita extends javax.swing.JDialog {

    //listas de datos
    private ArrayList<Cita> listaCitas;
    private ArrayList<Veterinario> listaVeterinarios;
    private ArrayList<String> diagnosticosTemp;
    private ArrayList<String> tratamientosTemp;
    private boolean cargando = false;

    /**
     * Constructor que inicializa los componentes y carga citas y veterinarios.
     */
    public VentanaAtenderCita(java.awt.Frame parent, boolean modal, ArrayList<Cita> listaCitas, ArrayList<Veterinario> listaVeterinarios) {
        super(parent, modal);
        initComponents();
        this.listaCitas = listaCitas;
        this.listaVeterinarios = listaVeterinarios;
        this.diagnosticosTemp = new ArrayList<>();
        this.tratamientosTemp = new ArrayList<>();
        this.textFieldClienteID.setEnabled(false);
        this.textFieldClienteNombre.setEnabled(false);

        this.cargando = true;
        cargarVeterinarios();
        cargarCitas();
        this.cargando = false;
        cargarDatosCitaSeleccionada();
    }

    /**
     * Carga los veterinarios en el combo dejando la primera opcion en blanco.
     */
    private void cargarVeterinarios() {
        this.comboBoxVeterinario.removeAllItems();
        this.comboBoxVeterinario.addItem("");
        if (this.listaVeterinarios != null) {
            for (Veterinario v : this.listaVeterinarios) {
                this.comboBoxVeterinario.addItem(v);
            }
        }
    }

    /**
     * Carga las citas disponibles en el combo #Cita.
     */
    private void cargarCitas() {
        this.comboBoxCita.removeAllItems();
        if (this.listaCitas != null) {
            for (Cita c : this.listaCitas) {
                this.comboBoxCita.addItem(c);
            }
        }
    }

    /**
     * Carga en pantalla los datos de la cita seleccionada actualmente.
     */
    private void cargarDatosCitaSeleccionada() {
        Cita cita = (Cita) this.comboBoxCita.getSelectedItem();
        if (cita == null) {
            this.textFieldClienteID.setText("");
            this.textFieldClienteNombre.setText("");
            this.comboBoxVeterinario.setSelectedIndex(0);
            this.textAreaObservaciones.setText("");
            this.diagnosticosTemp = new ArrayList<>();
            this.tratamientosTemp = new ArrayList<>();
            llenarTablaTexto(this.tableDiagnosticos, "Diagnostico", this.diagnosticosTemp);
            llenarTablaTexto(this.tableTratamientos, "Tratamiento", this.tratamientosTemp);
            return;
        }

        //mostrar datos del cliente deshabilitados
        Cliente cli = cita.getCliente();
        this.textFieldClienteID.setText((cli != null && cli.getIdentificacion() != null) ? cli.getIdentificacion() : "");
        this.textFieldClienteNombre.setText((cli != null && cli.getNombre() != null) ? cli.getNombre() : "");

        //seleccionar veterinario si ya tiene uno asignado, sino dejar en blanco
        this.comboBoxVeterinario.setSelectedIndex(0);
        if (cita.getVeterinario() != null && cita.getVeterinario().getIdentificacion() != null) {
            String vetId = cita.getVeterinario().getIdentificacion();
            for (int i = 1; i < this.comboBoxVeterinario.getItemCount(); i++) {
                Object item = this.comboBoxVeterinario.getItemAt(i);
                if (item instanceof Veterinario) {
                    Veterinario v = (Veterinario) item;
                    if (v.getIdentificacion() != null && v.getIdentificacion().equalsIgnoreCase(vetId)) {
                        this.comboBoxVeterinario.setSelectedIndex(i);
                        break;
                    }
                }
            }
        }

        //cargar observaciones y copiar listas temporales para permitir cancelar
        this.textAreaObservaciones.setText(cita.getObservaciones() != null ? cita.getObservaciones() : "");
        this.diagnosticosTemp = (cita.getListaDiagnosticos() != null)
                ? new ArrayList<>(cita.getListaDiagnosticos())
                : new ArrayList<>();
        this.tratamientosTemp = (cita.getListaTratamientos() != null)
                ? new ArrayList<>(cita.getListaTratamientos())
                : new ArrayList<>();

        llenarTablaTexto(this.tableDiagnosticos, "Diagnostico", this.diagnosticosTemp);
        llenarTablaTexto(this.tableTratamientos, "Tratamiento", this.tratamientosTemp);
    }

    /**
     * Llena una tabla de una sola columna con la lista de textos indicada.
     */
    private void llenarTablaTexto(JTable tabla, String encabezado, ArrayList<String> datos) {
        Vector<String> titulos = new Vector<>();
        titulos.addElement(encabezado);

        Vector<Vector<String>> filas = new Vector<>();
        if (datos != null) {
            for (String item : datos) {
                Vector<String> fila = new Vector<>();
                fila.addElement(item);
                filas.addElement(fila);
            }
        }

        DefaultTableModel modeloTabla = new DefaultTableModel(filas, titulos) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        tabla.setModel(modeloTabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCita = new javax.swing.JLabel();
        comboBoxCita = new javax.swing.JComboBox<>();
        labelNombre = new javax.swing.JLabel();
        textFieldClienteID = new javax.swing.JTextField();
        textFieldClienteNombre = new javax.swing.JTextField();
        labelVeterinario = new javax.swing.JLabel();
        comboBoxVeterinario = new javax.swing.JComboBox<>();
        labelObservaciones = new javax.swing.JLabel();
        jScrollPaneObservaciones = new javax.swing.JScrollPane();
        textAreaObservaciones = new javax.swing.JTextArea();
        labelDiagnosticos = new javax.swing.JLabel();
        buttonAgregarDiagnostico = new javax.swing.JButton();
        jScrollPaneDiagnosticos = new javax.swing.JScrollPane();
        tableDiagnosticos = new javax.swing.JTable();
        labelTratamientos = new javax.swing.JLabel();
        buttonAgregarTratamiento = new javax.swing.JButton();
        jScrollPaneTratamientos = new javax.swing.JScrollPane();
        tableTratamientos = new javax.swing.JTable();
        buttonSalvar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atender Cita");

        labelCita.setText("#Cita");

        comboBoxCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCitaActionPerformed(evt);
            }
        });

        labelNombre.setText("Nombre");

        labelVeterinario.setText("Veterinario");

        labelObservaciones.setText("Observaciones");

        textAreaObservaciones.setColumns(20);
        textAreaObservaciones.setLineWrap(true);
        textAreaObservaciones.setRows(4);
        textAreaObservaciones.setWrapStyleWord(true);
        jScrollPaneObservaciones.setViewportView(textAreaObservaciones);

        labelDiagnosticos.setText("Diagnosticos");

        buttonAgregarDiagnostico.setText("+");
        buttonAgregarDiagnostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarDiagnosticoActionPerformed(evt);
            }
        });

        tableDiagnosticos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Diagnostico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneDiagnosticos.setViewportView(tableDiagnosticos);

        labelTratamientos.setText("Tratamientos");

        buttonAgregarTratamiento.setText("+");
        buttonAgregarTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarTratamientoActionPerformed(evt);
            }
        });

        tableTratamientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tratamiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneTratamientos.setViewportView(tableTratamientos);

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelVeterinario, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxCita, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textFieldClienteID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(textFieldClienteNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboBoxVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 80, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelObservaciones)
                            .addComponent(labelDiagnosticos)
                            .addComponent(labelTratamientos))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPaneObservaciones)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonAgregarDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jScrollPaneDiagnosticos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonAgregarTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jScrollPaneTratamientos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCita)
                    .addComponent(comboBoxCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(textFieldClienteID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldClienteNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVeterinario)
                    .addComponent(comboBoxVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(labelObservaciones)
                .addGap(6, 6, 6)
                .addComponent(jScrollPaneObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(labelDiagnosticos)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonAgregarDiagnostico)
                    .addComponent(jScrollPaneDiagnosticos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(labelTratamientos)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonAgregarTratamiento)
                    .addComponent(jScrollPaneTratamientos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSalvar)
                    .addComponent(buttonCancelar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxCitaActionPerformed(java.awt.event.ActionEvent evt) {
        //cargar datos cuando el usuario cambia la cita seleccionada
        if (!this.cargando) {
            cargarDatosCitaSeleccionada();
        }
    }

    private void buttonAgregarDiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {
        //solicitar diagnostico via popup
        String texto = JOptionPane.showInputDialog(this, "Ingrese el diagnóstico:");
        if (texto != null && !texto.trim().isEmpty()) {
            this.diagnosticosTemp.add(texto.trim());
            llenarTablaTexto(this.tableDiagnosticos, "Diagnostico", this.diagnosticosTemp);
        }
    }

    private void buttonAgregarTratamientoActionPerformed(java.awt.event.ActionEvent evt) {
        //solicitar tratamiento via popup
        String texto = JOptionPane.showInputDialog(this, "Ingrese el tratamiento:");
        if (texto != null && !texto.trim().isEmpty()) {
            this.tratamientosTemp.add(texto.trim());
            llenarTablaTexto(this.tableTratamientos, "Tratamiento", this.tratamientosTemp);
        }
    }

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        //validar cita seleccionada
        Cita cita = (Cita) this.comboBoxCita.getSelectedItem();
        if (cita == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una cita");
            return;
        }

        //validar veterinario seleccionado (obligatorio)
        Object vetSeleccionado = this.comboBoxVeterinario.getSelectedItem();
        if (!(vetSeleccionado instanceof Veterinario)) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un veterinario para atender la cita");
            return;
        }

        //guardar cambios en el objeto cita y en CITAS.DAT
        cita.setVeterinario((Veterinario) vetSeleccionado);
        cita.setObservaciones(this.textAreaObservaciones.getText().trim());
        cita.setListaDiagnosticos(new ArrayList<>(this.diagnosticosTemp));
        cita.setListaTratamientos(new ArrayList<>(this.tratamientosTemp));
        Util.GestorDAT.guardarCitas(this.listaCitas);

        JOptionPane.showMessageDialog(this, "Se guardó la atención de la cita correctamente");
    }

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        //cerrar dialogo sin realizar ninguna operacion
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAgregarDiagnostico;
    private javax.swing.JButton buttonAgregarTratamiento;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JComboBox<Cita> comboBoxCita;
    private javax.swing.JComboBox<Object> comboBoxVeterinario;
    private javax.swing.JScrollPane jScrollPaneDiagnosticos;
    private javax.swing.JScrollPane jScrollPaneObservaciones;
    private javax.swing.JScrollPane jScrollPaneTratamientos;
    private javax.swing.JLabel labelCita;
    private javax.swing.JLabel labelDiagnosticos;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelObservaciones;
    private javax.swing.JLabel labelTratamientos;
    private javax.swing.JLabel labelVeterinario;
    private javax.swing.JTable tableDiagnosticos;
    private javax.swing.JTable tableTratamientos;
    private javax.swing.JTextArea textAreaObservaciones;
    private javax.swing.JTextField textFieldClienteID;
    private javax.swing.JTextField textFieldClienteNombre;
    // End of variables declaration//GEN-END:variables
}
