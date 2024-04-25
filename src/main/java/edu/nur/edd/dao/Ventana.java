package edu.nur.edd.dao;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

/*/public class Ventana extends JFrame implements MouseListener {
    private PersonaDao estudiante = new PersonaDao();

    // Panel_login
    private JPanel panel_login = new JPanel();
    private JLabel lbTitulo = new JLabel("...LOGIN...", SwingConstants.CENTER);
    private JLabel lbId = new JLabel("REGISTRO ID");
    private JLabel lbNom = new JLabel("CONTRASEÑA");
    private JTextField txtId = new JTextField();
    private JTextField txtNom = new JTextField();
    TextPrompt placeholder = new TextPrompt("Numero Registro....", txtId);
    TextPrompt placeholder1 = new TextPrompt("Pin....", txtNom);
    private JPasswordField jpContraseña = new JPasswordField();
    TextPrompt placeholder2 = new TextPrompt("", jpContraseña);
    private JButton btnIngresar = new JButton("ingresar");
    private JLabel lbNoCuenta = new JLabel("No tienes cuenta?");
    private JLabel lbCuenta = new JLabel("Registrate");
    private JLabel lbLogo = new JLabel();

//    private JPanel fondo = new JPanel();

    //    //panel_registro1
    private JPanel panel_registro = new JPanel();
    private JButton lbLogo1 = new JButton();
    private JLabel lbTitulo1 = new JLabel("REGISTRO - USUARIO", SwingConstants.CENTER);
    private JLabel lbRegistroR = new JLabel("Registro");
    private JLabel lbContraseñaR = new JLabel("Contraseña");
    private JTextField txtRegistroR = new JTextField();
    private JTextField txtContraseñaR = new JTextField();
    //    private JPasswordField jpContraseñaR = new JPasswordField();
    TextPrompt placeholderR = new TextPrompt("numero o nombre", txtRegistroR);
    TextPrompt placeholderR1 = new TextPrompt("pin", txtContraseñaR);
    //    TextPrompt placeholderR2 = new TextPrompt("", jpContraseñaR);
    private JButton btnAtras = new JButton("atras");
    private JButton btnFinalizar = new JButton("finalizar");
    //panel_registro3
    private JPanel panel_registro2 = new JPanel();
    private JLabel lbTitulo2 = new JLabel("REGISTRO", SwingConstants.CENTER);
    private JLabel lbDatosPersonales = new JLabel("DATOS GENERALES", SwingConstants.CENTER);
    private JLabel lbNombre = new JLabel("Nombre");
    private JLabel lbAppaterno = new JLabel("Ap. Paterno");
    private JLabel lbApmaterno = new JLabel("Ap. Materno");
    private JLabel lbDtnacimiento = new JLabel("F. Nacimiento");
    private JLabel lbDireccion = new JLabel("Direccion");
    private JLabel lbTelefono = new JLabel("Telefono");
    private JLabel lbCorreo = new JLabel("C. Electronico");
    private JTextField txtNombre = new JTextField();
    private JTextField txtAppaterno = new JTextField();
    private JTextField txtApmaterno = new JTextField();
    private JTextField txtDtnacimiento = new JTextField();
    private JTextField txtDireccion = new JTextField();
    private JTextField txtTelefono = new JTextField();
    private JTextField txtCorreo = new JTextField();
    TextPrompt placeholderG = new TextPrompt("ingrese nombre..", txtNombre);
    TextPrompt placeholderG1 = new TextPrompt("ingrese apellido paterno..", txtAppaterno);
    TextPrompt placeholderG2 = new TextPrompt("ingrese apellido materno..", txtApmaterno);
    TextPrompt placeholderG3 = new TextPrompt("1999/mes/dia", txtDtnacimiento);
    TextPrompt placeholderG4 = new TextPrompt("direccion..", txtDireccion);
    TextPrompt placeholderG5 = new TextPrompt("numero telefonico", txtTelefono);
    TextPrompt placeholderG6 = new TextPrompt("correo electronico..", txtCorreo);
    private JButton btnAtrasG = new JButton("< atras");
    private JButton btnSiguienteG = new JButton("siguiente>Finl");

    public Ventana() {
        //setLayout(null);
        this.setSize(380, 550);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Image icon = new ImageIcon(getClass().getResource("/user.png")).getImage();
        //setIconImage(icon);

        //setIconImage(new ImageIcon(requireNonNull(getClass().getResource("/user.png"))).getImage());

        //setIconImage(getIconImage());
        //this.setResizable(false);// ventana estatica
        cerrar();
        this.setLocationRelativeTo(null);
        cargarPanelLogin();
//        cargarPanelRegistroG();
//        cargarPanelRegistroU();
        panel_login.addMouseListener(this);

        this.setVisible(true);
        //this.repaint();
    }

    private void cerrar() {
        try {
            this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    confirmarSalida();
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void confirmarSalida() {
        int valor = JOptionPane.showConfirmDialog(this, "¿Esta seguro de cerrar la aplicación?", "Advertencia", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (valor == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Gracias por su visita, Hasta pronto", "Gracias", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
//    @Override
//    public Image getIconImage (){
//        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/user.png"));
//        return retValue;
//    }

    private void cargarPanelLogin() {
        ImageIcon imlogo = new ImageIcon("user.png");
        panel_login.setLayout(null);
        panel_login.setSize(getSize());
        panel_login.setBackground(Color.gray);
//        fondo.setLayout(null);

        //Separadores
        JSeparator spRegistro = new JSeparator(SwingConstants.HORIZONTAL);
        JSeparator spContraseña = new JSeparator(SwingConstants.HORIZONTAL);
        spRegistro.setBounds(100, 210, 160, 12);
        spContraseña.setBounds(100, 256, 160, 12);
        spRegistro.setBackground(Color.darkGray);
        spContraseña.setBackground(Color.darkGray);
        panel_login.add(spRegistro);
        panel_login.add(spContraseña);
        //Posiciones e modificacions
        lbLogo.setBounds(114, 40, 150, 102);
        lbTitulo.setBounds(85, 117, 200, 80);
//lbTitulo.setBounds(0,117,200,80);
//lbTitulo.setHorizontalTextPosition(SwingConstants.CENTER);     poner en el centro el label no se
//btnFinalizar.setHorizontalTextPosition(SwingConstants.CENTER); si resulta tambien con los botton
        lbId.setBounds(90, 159, 80, 50);
        txtId.setBounds(100, 194, 160, 20);
        lbNom.setBounds(90, 204, 90, 50);
        txtNom.setBounds(100, 239, 160, 20);
        btnIngresar.setBounds(140, 300, 100, 27);
        lbNoCuenta.setBounds(100, 325, 105, 40);
        lbCuenta.setBounds(208, 325, 100, 40);

        lbTitulo.setFont(new Font("Britannic Bold", Font.BOLD, 25));
        lbId.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));//Font.BOLD text gruego
        txtId.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        lbNom.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));//Font.ITALIC text cursiva
        lbNoCuenta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        lbCuenta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

        //txtId.setBorder(null);
        txtId.setOpaque(false);
        txtId.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 0));
        placeholder.setForeground(Color.darkGray);
        //txtNom.setBorder(null);
        txtNom.setOpaque(false);
        txtNom.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 0));
        placeholder1.setForeground(Color.darkGray);
        //btnIngresar.setOpaque(false);
        btnIngresar.setForeground(Color.black);
        btnIngresar.setContentAreaFilled(false);
        //btnIngresar.setBorderPainted(true);
        btnIngresar.setBorder(new LineBorder(new Color(4, 117, 247, 255)));
        btnIngresar.setMargin(new Insets(0, 0, 0, 0));

        lbLogo.setIcon(new ImageIcon(imlogo.getImage().getScaledInstance(lbLogo.getWidth(), lbLogo.getHeight(), imlogo.getImageLoadStatus())));
        txtId.setToolTipText("ingrese su registro");
        txtNom.setToolTipText("ingrese el pin de su cuenta");
        lbNoCuenta.setToolTipText("click a 'Registrate'");
        UIManager.put("ToolTip.background", new Color(23, 20, 20, 103));
        UIManager.put("ToolTip.foreground", Color.BLACK);
        UIManager.put("ToolTip.font", new Font("Arial Rounded MT Bold", Font.PLAIN, 11));

//        fondo.setBounds(100,180,160,40);
//        fondo.setBackground(new Color(245, 139, 71));
//        fondo.setBackground(Color.orange);
//        this.add(fondo);
        panel_login.add(lbTitulo);
        panel_login.add(lbLogo);
        panel_login.add(lbId);
        panel_login.add(lbNom);
        panel_login.add(txtId);

        panel_login.add(txtNom);
        panel_login.add(btnIngresar);
        panel_login.add(lbNoCuenta);
        panel_login.add(lbCuenta);
        this.add(panel_login);
        //generarListener();
//        lbLogo.addActionListener(e -> {
//            JOptionPane.showMessageDialog(null,"Click");
//        });
        btnIngresar.addActionListener(e -> {
//            this.setVisible(false);
//            new Materia(estudiante);
            // Validar el ingreso
            if (estudiante.verificarIniciarSesion(Integer.parseInt(txtId.getText()), txtNom.getText()) == true) {
                JOptionPane.showMessageDialog(this, "!!CORRECTO!!", "acceso", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
//                estudiante.setRegistro_id(txtId.getText());
//                new Materia(estudiante);
            } else {
//                txtId.setText("");
//                txtNom.setText("");
                JOptionPane.showMessageDialog(null, "Datos erroneos/incorrecto", "error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void cargarPanelRegistroG() {
        ImageIcon imlogo = new ImageIcon("Fondo1.png");
        panel_registro2.setLayout(null);
        panel_registro2.setSize(getSize());
        panel_registro2.setBackground(Color.GRAY);
        //Separadores
        JSeparator spRegistro = new JSeparator(SwingConstants.HORIZONTAL);
        JSeparator spContraseña = new JSeparator(SwingConstants.HORIZONTAL);
        JSeparator spNombre = new JSeparator(SwingConstants.HORIZONTAL);
        JSeparator spAppaterno = new JSeparator(SwingConstants.HORIZONTAL);
        JSeparator spApmaterno = new JSeparator(SwingConstants.HORIZONTAL);
        JSeparator spDtnacimiento = new JSeparator(SwingConstants.HORIZONTAL);
        JSeparator spDireccion = new JSeparator(SwingConstants.HORIZONTAL);
        JSeparator spTelefono = new JSeparator(SwingConstants.HORIZONTAL);
        JSeparator spCorreo = new JSeparator(SwingConstants.HORIZONTAL);
        //ubicacion y tamaño
        spRegistro.setBounds(100, 128, 162, 12);
        spContraseña.setBounds(100, 164, 162, 12);
        spNombre.setBounds(100, 208, 162, 12);
        spAppaterno.setBounds(100, 252, 162, 12);
        spApmaterno.setBounds(100, 299, 162, 12);
        spDtnacimiento.setBounds(100, 347, 162, 12);
        spDireccion.setBounds(100, 393, 162, 12);
        spTelefono.setBounds(100, 437, 162, 12);
        spCorreo.setBounds(100, 480, 162, 12);
        //Color y agregar
        spRegistro.setBackground(Color.GREEN);
        spContraseña.setBackground(Color.BLUE);
        spNombre.setBackground(Color.RED);
        spAppaterno.setBackground(Color.darkGray);
        spApmaterno.setBackground(Color.darkGray);
        spDtnacimiento.setBackground(Color.darkGray);
        spDireccion.setBackground(Color.darkGray);
        spTelefono.setBackground(Color.darkGray);
        spCorreo.setBackground(Color.darkGray);
        panel_registro2.add(spRegistro);
        panel_registro2.add(spContraseña);
        panel_registro2.add(spNombre);
        panel_registro2.add(spAppaterno);
        panel_registro2.add(spApmaterno);
        panel_registro2.add(spDtnacimiento);
        panel_registro2.add(spDireccion);
        panel_registro2.add(spTelefono);
        panel_registro2.add(spCorreo);

        // posicion txt lb
        lbLogo.setBounds(50, 15, 110, 53);
        lbTitulo2.setBounds(95, 0, 300, 88);
        lbDatosPersonales.setBounds(55, 44, 250, 80);
        lbRegistroR.setBounds(86, 80, 80, 50);
        txtRegistroR.setBounds(100, 110, 165, 20);
        lbContraseñaR.setBounds(86, 115, 88, 50);
        txtContraseñaR.setBounds(100, 145, 165, 20);
        lbNombre.setBounds(86, 156, 80, 50);
        txtNombre.setBounds(100, 190, 165, 20);
        lbAppaterno.setBounds(86, 202, 88, 50);
        txtAppaterno.setBounds(100, 235, 165, 20);
        lbApmaterno.setBounds(86, 247, 80, 50);
        txtApmaterno.setBounds(100, 282, 165, 20);
        lbDtnacimiento.setBounds(86, 295, 88, 50);
        txtDtnacimiento.setBounds(100, 330, 165, 20);
        lbDireccion.setBounds(86, 341, 80, 50);
        txtDireccion.setBounds(100, 375, 165, 20);
        lbTelefono.setBounds(86, 386, 88, 50);
        txtTelefono.setBounds(100, 420, 165, 20);
        lbCorreo.setBounds(86, 430, 88, 50);
        txtCorreo.setBounds(100, 463, 165, 20);

        btnAtrasG.setBounds(5, 488, 70, 20);
        btnSiguienteG.setBounds(282, 488, 78, 20);

        lbTitulo2.setFont(new Font("Britannic Bold", Font.BOLD, 32));
        lbDatosPersonales.setFont(new Font("Britannic Bold", Font.BOLD, 25));
        lbRegistroR.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));//Font.BOLD text gruego
        lbContraseñaR.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        lbNombre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));//Font.BOLD text gruego
        lbAppaterno.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        lbApmaterno.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));//Font.ITALIC text cursiva
        lbDtnacimiento.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        lbDireccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        lbTelefono.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        lbCorreo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

        txtRegistroR.setOpaque(false);
        txtRegistroR.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 0));
        placeholderR.setForeground(Color.darkGray);
        txtContraseñaR.setOpaque(false);
        txtContraseñaR.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 0));
        placeholderR1.setForeground(Color.darkGray);

        txtNombre.setOpaque(false);
        txtNombre.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 0));
        placeholderG.setForeground(Color.darkGray);
        txtAppaterno.setOpaque(false);
        txtAppaterno.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 0));
        placeholderG1.setForeground(Color.darkGray);
        txtApmaterno.setOpaque(false);
        txtApmaterno.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 0));
        placeholderG2.setForeground(Color.darkGray);
        txtDtnacimiento.setOpaque(false);
        txtDtnacimiento.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 0));
        placeholderG3.setForeground(Color.darkGray);
        txtDireccion.setOpaque(false);
        txtDireccion.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 0));
        placeholderG4.setForeground(Color.darkGray);
        txtTelefono.setOpaque(false);
        txtTelefono.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 0));
        placeholderG5.setForeground(Color.darkGray);
        txtCorreo.setOpaque(false);
        txtCorreo.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 0));
        placeholderG6.setForeground(Color.darkGray);

        btnAtrasG.setContentAreaFilled(false);
        btnAtrasG.setBorder(new LineBorder(new Color(4, 117, 247, 255)));
        btnAtrasG.setMargin(new Insets(0, 0, 0, 0));
        btnSiguienteG.setForeground(new Color(0x25D920));
        btnSiguienteG.setContentAreaFilled(false);
        btnSiguienteG.setBorder(new LineBorder(new Color(4, 117, 247, 255)));
        btnSiguienteG.setMargin(new Insets(0, 0, 0, 0));

        lbLogo.setIcon(new ImageIcon(imlogo.getImage().getScaledInstance(lbLogo.getWidth(), lbLogo.getHeight(), imlogo.getImageLoadStatus())));

        txtRegistroR.setToolTipText("llenar casilla");
        txtContraseñaR.setToolTipText("llenar casilla");
        txtNombre.setToolTipText("llenar casilla");
        txtAppaterno.setToolTipText("llenar casilla");
        txtApmaterno.setToolTipText("llenar casilla");
        txtDtnacimiento.setToolTipText("como lo esta pidiendo 'año/mes/dia'");
        txtDireccion.setToolTipText("direccion, en que zona vive");
        txtTelefono.setToolTipText("llenar casilla");
        txtCorreo.setToolTipText("llenar casilla");
        btnSiguienteG.setToolTipText("asegure que todos los datos esten bien escritos y llenos");
        btnAtrasG.setToolTipText("volver al login");
        UIManager.put("ToolTip.background", new Color(23, 20, 20, 103));
        UIManager.put("ToolTip.foreground", Color.BLACK);
        UIManager.put("ToolTip.font", new Font("Arial Rounded MT Bold", Font.PLAIN, 11));

        panel_registro2.add(lbLogo);
        panel_registro2.add(lbTitulo2);
        panel_registro2.add(lbDatosPersonales);
        panel_registro2.add(lbRegistroR);
        panel_registro2.add(txtRegistroR);
        panel_registro2.add(lbContraseñaR);
        panel_registro2.add(txtContraseñaR);
        panel_registro2.add(lbNombre);
        panel_registro2.add(txtNombre);
        panel_registro2.add(lbAppaterno);
        panel_registro2.add(txtAppaterno);
        panel_registro2.add(lbApmaterno);
        panel_registro2.add(txtApmaterno);
        panel_registro2.add(lbDtnacimiento);
        panel_registro2.add(txtDtnacimiento);
        panel_registro2.add(lbDireccion);
        panel_registro2.add(txtDireccion);
        panel_registro2.add(lbTelefono);
        panel_registro2.add(txtTelefono);
        panel_registro2.add(lbCorreo);
        panel_registro2.add(txtCorreo);
        panel_registro2.add(btnAtrasG);
        panel_registro2.add(btnSiguienteG);
        this.repaint();
        this.add(panel_registro2);
        btnSiguienteG.addActionListener(e -> {
            if (!txtRegistroR.getText().replace(" ", "").equals("") && !txtContraseñaR.getText().replace(" ", "").equals("") && !txtNombre.getText().replace(" ", "").equals("")
                    && !txtAppaterno.getText().replace(" ", "").equals("") && !txtApmaterno.getText().replace(" ", "").equals("") && !txtDtnacimiento.getText().replace(" ", "").equals("")
                    && !txtDireccion.getText().replace(" ", "").equals("") && !txtTelefono.getText().replace(" ", "").equals("") && !txtCorreo.getText().replace(" ", "").equals("")) {
                JOptionPane.showMessageDialog(this, "Registro exitoso", "acceso", JOptionPane.INFORMATION_MESSAGE);
                panel_registro2.setVisible(false);
                panel_login.setVisible(true);
//                new PersonaDao(txtRegistroR.getText(), txtContraseñaR.getText(), txtNombre.getText(), txtAppaterno.getText(), txtApmaterno.getText(), txtDtnacimiento.getText(),
//                        txtDireccion.getText(), txtTelefono.getText(), txtCorreo.getText());
//                txtRegistroR.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "se debe llenar todos los datos importantes", "error", JOptionPane.ERROR_MESSAGE);
            }
//            panel_registro2.setVisible(false);
//            panel_registro.setVisible(true);
//            cargarPanelRegistroU();
//            if (true) {//validar que todos los datos se llenen
//
//            } else {
//                JOptionPane.showMessageDialog(null, "Para el registrar llene todos los datos", "!!error!!",JOptionPane.ERROR_MESSAGE);
//            }
        });
        btnAtrasG.addActionListener(e -> {
            panel_registro2.setVisible(false);
            panel_login.setVisible(true);
            cargarPanelLogin();
            txtId.setText("");
            txtNom.setText("");

        });
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getX() > lbCuenta.getX() && e.getX() < lbCuenta.getX() + lbCuenta.getWidth() && e.getY() > lbCuenta.getY() && e.getY() < lbCuenta.getY() + lbCuenta.getHeight()) {
            panel_login.setVisible(false);
            panel_registro2.setVisible(true);
            txtNombre.setText("");
            txtAppaterno.setText("");
            txtApmaterno.setText("");
            txtDtnacimiento.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            txtCorreo.setText("");
            cargarPanelRegistroG();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    private void generarListener() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getX() > lbCuenta.getX() && e.getX() < lbCuenta.getX() + lbCuenta.getWidth() && e.getY() > lbCuenta.getY() && e.getY() < lbCuenta.getY() + lbCuenta.getHeight()) {
                    panel_login.setVisible(false);
                    panel_registro2.setVisible(true);
//            txtRegistroR.setText("");
//            txtContraseñaR.setText("");
                    txtNombre.setText("");
                    txtAppaterno.setText("");
                    txtApmaterno.setText("");
                    txtDtnacimiento.setText("");
                    txtDireccion.setText("");
                    txtTelefono.setText("");
                    txtCorreo.setText("");
                    cargarPanelRegistroG();
                }
                repaint();
            }
        };
        this.addMouseListener(mouseAdapter);
    }

    public static void main(String[] args) {
        Ventana acceso = new Ventana();
    }
}*/

public class Ventana extends JFrame {
    private JTextField idTextField;
    private JTextField nombreTextField;
    private JLabel noRegistLabel = new JLabel("No tienes cuenta? ");
    private JLabel registroLabel = new JLabel("<html><u>Registratee</u></html>" + "!");

    private JTextField idTextFieldRegistro = new JTextField();
    private JTextField nombreTextFieldRegistro = new JTextField();
    private JTextField alturaTextFieldRegistro = new JTextField();

    private JPanel panel_principal = new JPanel();
    private JPanel panel_registro = new JPanel();

    public Ventana() {
        setTitle("Ventana de ingreso");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponent();
        repaint();
        setVisible(true);
    }

    public void initComponent() {
        panel_principal.setLayout(null);
        panel_principal.setBackground(Color.gray);

        panel_principal.setLayout(null);

        idTextField = new JTextField();
        nombreTextField = new JTextField();
        JLabel titulolabel = new JLabel("INICIAR SESION");
        JLabel idLabel = new JLabel("ID:");
        JLabel nombreLabel = new JLabel("Nombre:");

        JButton ingresarButton = new JButton("Ingresar");

        titulolabel.setBounds(47, 10, 100, 25);
        idLabel.setBounds(20, 50, 80, 25);
        idTextField.setBounds(71, 50, 90, 25);
        nombreLabel.setBounds(20, 80, 80, 25);
        nombreTextField.setBounds(71, 80, 90, 25);
        ingresarButton.setBounds(50, 109, 80, 25);
        noRegistLabel.setBounds(5, 138, 110, 20);
        registroLabel.setBounds(112, 138, 100, 20);

        ingresarButton.setMargin(new Insets(0, 0, 0, 0));
        ingresarButton.setOpaque(false);

        panel_principal.add(titulolabel);
        panel_principal.add(idLabel);
        panel_principal.add(idTextField);
        panel_principal.add(nombreLabel);
        panel_principal.add(nombreTextField);
        panel_principal.add(ingresarButton);
        panel_principal.add(noRegistLabel);
        panel_principal.add(registroLabel);
        this.add(panel_principal);

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = idTextField.getText();
                String nombre = nombreTextField.getText();

                if (idText.isEmpty() || nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Debes ingresar el ID y el Nombre.", "Error en el inicio de sesión", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int id;
                try {
                    id = Integer.parseInt(idText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "El ID debe ser un número válido.", "Error en el inicio de sesión", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (verificarInicioSesion()) {
                    JOptionPane.showMessageDialog(rootPane, "Ingreso Exitoso!!", "Válido", JOptionPane.INFORMATION_MESSAGE);
                    mostrarFormularioMateria();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Datos incorrectos", "Error en el inicio de sesión", JOptionPane.WARNING_MESSAGE);
                }
                /*if (verificarInicioSesion()){
                    JOptionPane.showMessageDialog(rootPane,"Ingreso Exitos!!","valido", JOptionPane.INFORMATION_MESSAGE);
                    mostrarFormularioMateria();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "datos incorrectos","Error en el inicio de sesión",JOptionPane.WARNING_MESSAGE);
                }*/

//                int id = Integer.parseInt(idTextField.getText());
//                String nombre = nombreTextField.getText();
//
//                PersonaDao dao = new PersonaDao();
//
//                if (dao.verificarIniciarSesion2(id, nombre)) {
//                    JOptionPane.showMessageDialog(Ventana.this, "Inicio de sesión exitoso!");
//
//                } else {
//                    JOptionPane.showMessageDialog(Ventana.this, "Error en el inicio de sesión");
//                }
            }
        });
        panel_principal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (e.getX() > registroLabel.getX() && e.getX() < registroLabel.getX() + registroLabel.getWidth()
                        && e.getY() > registroLabel.getY() && e.getY() < registroLabel.getY() + registroLabel.getHeight()) {
                    JOptionPane.showMessageDialog(rootPane, "click al label");
                    panel_principal.setVisible(false);
                    panel_registro.setVisible(true);
                    idTextFieldRegistro.setText("");
                    nombreTextFieldRegistro.setText("");
                    alturaTextFieldRegistro.setText("");
                    initRegistr();
                    repaint();
                }
            }
        });
        repaint();
    }

    private void initRegistr() {
        panel_registro.setLayout(null);
        panel_registro.setBackground(Color.gray);

        JLabel idLabel = new JLabel("ID:");
        JLabel nombreLabel = new JLabel("Nombre:");
        JLabel alturaLabel = new JLabel("Altura:");


        JButton atrasButton = new JButton("Atrás");
        JButton guardarButton = new JButton("Guardar");

        idLabel.setBounds(20, 30, 80, 25);
        idTextFieldRegistro.setBounds(71, 30, 90, 25);
        nombreLabel.setBounds(20, 60, 80, 25);
        nombreTextFieldRegistro.setBounds(71, 60, 90, 25);
        alturaLabel.setBounds(20, 90, 80, 25);
        alturaTextFieldRegistro.setBounds(71, 90, 90, 25);
        atrasButton.setBounds(15, 120, 80, 25);
        guardarButton.setBounds(100, 120, 80, 25);

        panel_registro.add(idLabel);
        panel_registro.add(idTextFieldRegistro);
        panel_registro.add(nombreLabel);
        panel_registro.add(nombreTextFieldRegistro);
        panel_registro.add(alturaLabel);
        panel_registro.add(alturaTextFieldRegistro);
        panel_registro.add(atrasButton);
        panel_registro.add(guardarButton);

        this.add(panel_registro);

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_principal.setVisible(true);
                panel_registro.setVisible(false);
                repaint();
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = idTextFieldRegistro.getText();
                String nombre = nombreTextFieldRegistro.getText();
                String alturaText = alturaTextFieldRegistro.getText();

                if (idText.isEmpty() || nombre.isEmpty() || alturaText.isEmpty()) {
                    JOptionPane.showMessageDialog(panel_registro, "Necesita ingresar todos los datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int id = Integer.parseInt(idText);
                int altura;
                try {
                    altura = Integer.parseInt(alturaText);


                    PersonaDao dao = new PersonaDao();
                    if (!dao.isIdAlreadyExists(id)) {
                        //JOptionPane.showMessageDialog(panel_registro, "El ID ingresado ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("El ID ingresado ya está registrado.");
                        idTextFieldRegistro.setText("");

                    } else {
                        PersonaDto persona = new PersonaDto(id, nombre, altura);
                        dao.insert(persona);
                        //JOptionPane.showMessageDialog(panel_registro, "Estudiante registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("Estudiante registrado exitosamente.");
                    }
                } catch (NumberFormatException ex) {
                    altura = 0;
                    JOptionPane.showMessageDialog(panel_registro, "Error en el formato de los campos ID o Altura.", "Error", JOptionPane.ERROR_MESSAGE);
                }
//                    atrasButton.doClick(); // Go back to the previous panel after saving the data


            }
        });

        repaint();
    }

    public boolean verificarInicioSesion() {
        int id = Integer.parseInt(idTextField.getText());
        String nombre = nombreTextField.getText();

        PersonaDao dao = new PersonaDao();
        return dao.verificarIniciarSesion2(id, nombre);
    }

    public void mostrarFormularioMateria() {
        int id = Integer.parseInt(idTextField.getText());
        String nombre = nombreTextField.getText();

        PersonaDao dao = new PersonaDao();
        PersonaDto persona = dao.getById(id);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTextField alturaTextField = new JTextField(10);
                Materia materia = new Materia(persona);
                materia.setVisible(true);
                dispose();
            }
        });
    }

    private PersonaDto getPersonaFromFields(JTextField alturaTextField) {
        int id = Integer.parseInt(idTextField.getText());
        String nombre = nombreTextField.getText();
        int altura;
        try {
            altura = Integer.parseInt(alturaTextField.getText());
        } catch (NumberFormatException e) {
            altura = 0;
        }

        return new PersonaDto(id, nombre, altura);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana();
            }
        });
    }
}
