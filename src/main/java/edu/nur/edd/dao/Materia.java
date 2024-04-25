package edu.nur.edd.dao;

//import ConexionPSQL.PersonaDao;
//import ConexionPSQL.MateriaP;
//import ConexionPSQL.Registro;

import edu.nur.edd.listas.ListaDoble;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

public class Materia extends JFrame {
    private static Logger logger = LogManager.getRootLogger();
    private PersonaDto persona;
    private JTextField idTextField = new JTextField();
    private JTextField nombreTextField = new JTextField();;
    private JTextField alturaTextField = new JTextField();;

    private JPanel panel_informacion = new JPanel();
    private JPanel panel_principal = new JPanel();
    private JTable tabla;
    private DefaultTableModel tableModel;
    public Materia(PersonaDto persona) {
        this.persona = persona;
        setTitle("Formulario Materia");
        setSize(294,382);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        pack();
        setLocationRelativeTo(null);

        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Option");
        JMenuItem menuItem = new JMenuItem("Cerrar Sesion");
        menuItem.addActionListener(e ->{
            new Ventana();
            this.dispose();
//            cerrarV();
        });
        menu.add(menuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Salir");
        menuItem.addActionListener(e -> {
            logger.info("El usuario sale del programa");
            System.exit(0);
        });
        menu.add(menuItem);
        bar.add(menu);
        this.setJMenuBar(bar);

        initInformation();
        this.setVisible(true);
//        addComponentListener( new MyComponentAdapter());
        repaint();
    }
    private void cerrarV() {
        // Show the Ventana window
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana();
            }
        });

        // Close the current Materia window
        dispose();
    }

    private class MyComponentAdapter extends ComponentAdapter {
        @Override
        public void componentShown(ComponentEvent e) {
            if (e.getComponent() == panel_principal) {
                setSize(500, 500);
            } else if (e.getComponent() == panel_informacion) {
                setSize(260, 220);
            }
        }
    }
    public void initInformation(){
        panel_informacion.setLayout(null);
        panel_informacion.setBackground(Color.gray);
//        idTextField = new JTextField(10);
//        nombreTextField = new JTextField(10);
//        alturaTextField = new JTextField(10);
        JLabel tituloLabel = new JLabel("Informacion Personal");
        JLabel idLabel = new JLabel("ID:");
        JLabel nombreLabel = new JLabel("Nombre:");
        JLabel alturaLabel = new JLabel("Altura:");

        JButton btnInicio1 = new JButton("Inicio");
        JButton btnPerfil1 = new JButton("Perfil");

//        PersonaDao dao = new PersonaDao();
//        PersonaDto persona = dao.getById(Integer.parseInt(idTextField.getText()));

        tituloLabel.setBounds(68,20,150,30);
        idLabel.setBounds(50,60,80,25);
        idTextField.setBounds(100,60,80,25);
        nombreLabel.setBounds(50,90,80,25);
        nombreTextField.setBounds(100,90,80,25);
        alturaLabel.setBounds(50,120,80,25);
        alturaTextField.setBounds(100,120,80,25);

        btnInicio1.setBounds(60,148,65,25);
        btnPerfil1.setBounds(130,148,65,25);

        idTextField.setOpaque(false);
        nombreTextField.setOpaque(false);
        alturaTextField.setOpaque(false);
//        nombreTextField.setForeground();
        btnPerfil1.setBorder(new LineBorder(new Color(213, 201, 4)));
        btnInicio1.setMargin(new Insets(0,0,0,0));
        btnPerfil1.setMargin(new Insets(0,0,0,0));


        idTextField.setText(String.valueOf(persona.getId()));
        nombreTextField.setText(persona.getNombre());
        alturaTextField.setText(String.valueOf(persona.getAltura()));

        idTextField.setEnabled(false);
        nombreTextField.setEnabled(false);
        alturaTextField.setEnabled(false);

        panel_informacion.add(tituloLabel);
        panel_informacion.add(idLabel);
        panel_informacion.add(idTextField);
        panel_informacion.add(nombreLabel);
        panel_informacion.add(nombreTextField);
        panel_informacion.add(alturaLabel);
        panel_informacion.add(alturaTextField);
        panel_informacion.add(btnInicio1);
        panel_informacion.add(btnPerfil1);

        this.add(panel_informacion);

        btnInicio1.addActionListener(e ->{
            JOptionPane.showMessageDialog(rootPane, "ventana de inicio");
            panel_informacion.setVisible(false);
            panel_principal.setVisible(true);
            initTable();
            this.repaint();
        });
        btnPerfil1.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "ventana perfil");

        });

//        panel_informacion.addComponentListener(new MyComponentAdapter());
    }
    public void initTable(){
        panel_principal.setLayout(null);
//        this.panel_principal.setSize(500,500);
        panel_principal.setBackground(Color.gray);
        JLabel lbTitulo = new JLabel("Tabla General");

        JButton btnInicio2 = new JButton("Inicio");
        JButton btnPerfil2 = new JButton("Perfil");
        JButton btnDosPersonasMasAl = new JButton("+");
        JButton btnDosPersonasMasBaj = new JButton("-");


        lbTitulo.setBounds(98,4,80,25);

        btnDosPersonasMasAl.setBounds(243, 6, 15, 15);
        btnDosPersonasMasBaj.setBounds(260, 6, 15, 15);
        btnInicio2.setBounds(65,293,60,25);
        btnPerfil2.setBounds(153,293,60,25);

        btnDosPersonasMasAl.setContentAreaFilled(false);
        btnDosPersonasMasBaj.setContentAreaFilled(false);
        btnDosPersonasMasAl.setBorder(new LineBorder(new Color(0, 252, 4, 255)));
        btnDosPersonasMasBaj.setBorder(new LineBorder(new Color(0, 252, 4, 255)));
        btnInicio2.setOpaque(false);
        btnInicio2.setBorder(new LineBorder(new Color(213, 201, 4)));
        btnPerfil2.setOpaque(true);

        btnInicio2.setMargin(new Insets(0,0,0,0));
        btnPerfil2.setMargin(new Insets(0,0,0,0));
        btnDosPersonasMasAl.setMargin(new Insets(0,0,0,0));
        btnDosPersonasMasBaj.setMargin(new Insets(0,0,0,0));

        panel_principal.add(lbTitulo);
        panel_principal.add(btnInicio2);
        panel_principal.add(btnPerfil2);
        panel_principal.add(btnDosPersonasMasAl);
        panel_principal.add(btnDosPersonasMasBaj);
        this.add(panel_principal);

        btnInicio2.addActionListener(e ->{
            JOptionPane.showMessageDialog(rootPane, "ventana de inicio");
        });
        btnPerfil2.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "ventana perfil");
            panel_principal.setVisible(false);
            panel_informacion.setVisible(true);
            initInformation();
        });


        JButton btnVerTabla = new JButton("Ver Tabla");
        btnVerTabla.setBounds(105, 263, 70, 25);
        btnVerTabla.setMargin(new Insets(0,0,0,0));
        panel_principal.add(btnVerTabla);

        btnVerTabla.addActionListener(e -> {
            ListaDoble<PersonaDto> listaPersonas = new PersonaDao().getAllInAscendingOrder();
            if (listaPersonas != null) {
                Object[][] data = new Object[listaPersonas.tamano()][3];
                String[] columnNames = {"ID", "Nombre", "Altura"};
                Iterator<PersonaDto> iterator = listaPersonas.iterator();
                int i = 0;
                while (iterator.hasNext()) {
                    PersonaDto persona = iterator.next();
                    data[i][0] = persona.getId();
                    data[i][1] = persona.getNombre();
                    data[i][2] = persona.getAltura();
                    i++;
                }
                tabla = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(tabla);
                scrollPane.setBounds(30, 110, 220, 150);

                JLabel idLabel = new JLabel("ID:");
                JLabel nombreLabel = new JLabel("Nombre:");
                JLabel alturaLabel = new JLabel("Altura:");
                JTextField idTextField2 = new JTextField();
                JTextField nombreTextField2 = new JTextField();
                JTextField alturaTextField2 = new JTextField();
                JButton btnEliminar = new JButton("eliminar");
                JButton btnModifcar = new JButton("guardar M.");

                JButton btnNuevo = new JButton("Guardar");



                idTextField2.setOpaque(false);
                nombreTextField2.setOpaque(false);
                alturaTextField2.setOpaque(false);

                idLabel.setBounds(10,25,80,25);
                idTextField2.setBounds(60,24,80,25);
                nombreLabel.setBounds(10,52,80,25);
                nombreTextField2.setBounds(60,51,80,25);
                alturaLabel.setBounds(10,78,80,25);
                alturaTextField2.setBounds(60,78,80,25);
                btnNuevo.setBounds(160, 30, 70, 25);
                btnEliminar.setBounds(160, 50, 70, 25);
                btnModifcar.setBounds(160, 75, 70, 25);

                idTextField2.setOpaque(false);
                nombreTextField2.setOpaque(false);
                alturaTextField2.setOpaque(false);
                btnNuevo.setContentAreaFilled(false);
                btnNuevo.setMargin(new Insets(0,0,0,0));
                btnEliminar.setContentAreaFilled(false);
                btnEliminar.setForeground(new Color(211, 30, 30, 255));
                btnEliminar.setBorder(new LineBorder(new Color(211, 30, 30, 255)));
                btnEliminar.setMargin(new Insets(0,0,0,0));
                btnModifcar.setContentAreaFilled(false);
                btnModifcar.setForeground(new Color(71, 175, 3, 255));
                btnModifcar.setBorder(new LineBorder(new Color(71, 175, 3, 255)));
                btnModifcar.setMargin(new Insets(0,0,0,0));

                panel_principal.add(idLabel);
                panel_principal.add(idTextField2);
                panel_principal.add(nombreLabel);
                panel_principal.add(nombreTextField2);
                panel_principal.add(alturaLabel);
                panel_principal.add(alturaTextField2);
                panel_principal.add(btnNuevo);
                panel_principal.add(btnEliminar);
                panel_principal.add(btnModifcar);
                panel_principal.add(scrollPane);
                panel_principal.revalidate();
                panel_principal.repaint();

                DefaultTableModel model = new DefaultTableModel(data, columnNames);
                tabla.setModel(model);
                tabla.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int row = tabla.getSelectedRow();
                        if (row >= 0) {
                            idTextField2.setText(String.valueOf(tabla.getValueAt(row, 0)));
                            nombreTextField2.setText(String.valueOf(tabla.getValueAt(row, 1)));
                            alturaTextField2.setText(String.valueOf(tabla.getValueAt(row, 2)));
                        }
                    }
                });
                btnNuevo.addActionListener(ee -> {
                    String idText = idTextField2.getText();
                    String nombre = nombreTextField2.getText();
                    String alturaText = alturaTextField2.getText();

                    if (idText.isEmpty() || nombre.isEmpty() || alturaText.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos para guardar el registro.");
                        return;
                    }

                    try {
                        int id = Integer.parseInt(idText);
                        int altura = Integer.parseInt(alturaText);

                        PersonaDao personaDao = new PersonaDao();
                        if (personaDao.isIdAlreadyExists(id)) {
                            JOptionPane.showMessageDialog(this, "+++El ID ingresado ya existe.");
                            System.out.println("#######################");
                            return;
                        }
                        PersonaDto nuevo = new PersonaDto(id, nombre, altura);
                        personaDao.insert(nuevo);

                        //JOptionPane.showMessageDialog(rootPane, "Registro guardado exitosamente.");
                        idTextField2.setText("");
                        nombreTextField2.setText("");
                        alturaTextField2.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Error en el formato de los campos ID o Altura.");
                        logger.info("++acaba de suceder un error no puedes registrar dos datos con el mismo" +
                                "(ID): " + idTextField2.getText() + " | " + idTextField2.getText());
                    }
                });

                btnEliminar.addActionListener(ee -> {
                    int row = tabla.getSelectedRow();
                    if (row >= 0) {
                        int id = Integer.parseInt(idTextField2.getText());
                        new PersonaDao().delete(id);

                        // Success: Remove the row from the table
                        model.removeRow(row);
                        JOptionPane.showMessageDialog(rootPane, "Registro eliminado exitosamente.");
                        idTextField2.setText("");
                        nombreTextField2.setText("");
                        alturaTextField2.setText("");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Seleccione un registro para eliminar.");
                    }
                });

                btnModifcar.addActionListener(ee -> {
                    int id = Integer.parseInt(idTextField2.getText());
                    String nombre = nombreTextField2.getText();
                    int altura = Integer.parseInt(alturaTextField2.getText());

                    PersonaDto updatedPersona = new PersonaDto(id, nombre, altura);

                    if (new PersonaDao().update(updatedPersona)) {
                        // Success: Update the table with the modified data
//                        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                        int row = tabla.getSelectedRow();
                        if (row >= 0) {
                            model.setValueAt(updatedPersona.getId(), row, 0);
                            model.setValueAt(updatedPersona.getNombre(), row, 1);
                            model.setValueAt(updatedPersona.getAltura(), row, 2);
                        }
                        JOptionPane.showMessageDialog(rootPane, "Registro actualizado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Error al actualizar el registro.");
                    }
                });

                btnDosPersonasMasAl.addActionListener(ee -> {
                    ListaDoble<PersonaDto> personas = new PersonaDao().personasMasAltas();
                    displayPersonsList("Las dos Personas mas altas", personas);
                });

                btnDosPersonasMasBaj.addActionListener(ee -> {
                    ListaDoble<PersonaDto> personas = new PersonaDao().personasMasBajas();
                    displayPersonsList("Las dos Personas mas bajas", personas);
                });
            } else {
                JOptionPane.showMessageDialog(rootPane, "No hay registros en la tabla persona.");
            }

        });


//        panel_principal.addComponentListener(new MyComponentAdapter());
    }
    private void refreshTable() {
        // Get the latest data from the database using PersonaDao.getAllInAscendingOrder()
        ListaDoble<PersonaDto> personas = new PersonaDao().getAllInAscendingOrder();

        // Update the table model with the new data
        tableModel.setRowCount(0); // Clear the existing data
        for (PersonaDto persona : personas) {
            Object[] rowData = {persona.getId(), persona.getNombre(), persona.getAltura()};
            tableModel.addRow(rowData);
        }
    }
    private void displayPersonsList(String title, ListaDoble<PersonaDto> personas) {
        if (personas == null || personas.tamano() == 0) {
            JOptionPane.showMessageDialog(this, "No hay registros para mostrar.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("------ ").append(title).append(" ------\n");
        for (PersonaDto persona : personas) {
            sb.append("ID: ").append(persona.getId()).append(", Nombre: ").append(persona.getNombre()).append(", Altura: ").append(persona.getAltura()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }
}
