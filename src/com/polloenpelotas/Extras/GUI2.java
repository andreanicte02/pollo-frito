package com.polloenpelotas.Extras;

import org.fife.ui.rsyntaxtextarea.*;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class GUI2 extends JFrame {
    private JPanel panel1;
    private JTabbedPane multiTab;
    private JButton ejecutarCupButton;
    private JButton abrirButton;
    private JButton guardarButton;
    private JButton guardarComoButton;
    private JButton addPestaña;
    private JButton ASTCupButton;
    private JButton ejecutarJCCButton;
    private JButton erroresButton;
    private JButton astJCCButton;
    private JPanel panel2;
    private JButton closePestañaButton;
    private JButton TSCupButton;
    private JButton TSJCCButton;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JButton button18;
    private JButton button19;
    public  static  RSyntaxTextArea console;
    private FlowInterpreter execute;

    public GUI2(){

        super("Interprete - Andrea Nicte Vicente Campos - 201404104");
        if (panel1 == null) {
            buildLayout(); // built without IntelliJ's form compiler (Maven, CheerpJ)
        }
        this.setContentPane(panel1);
        this.setSize(1250,720);
        this.setResizable(false);
        this.addWindow();
        this.createConsole();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.execute = new FlowInterpreter();


        addPestaña.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addWindow();

            }
        });
        closePestañaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                int i = multiTab.getSelectedIndex();
                if(i<0){
                    return;
                }
                System.out.println(i);
                multiTab.remove(i);


            }
        });
        abrirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                openFile();
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(multiTab.getTitleAt(multiTab.getSelectedIndex()).equals("new:")){
                    saveAsFile();
                }
                saveFile();

            }
        });
        guardarComoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveAsFile();
            }
        });
        ejecutarCupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String path = currentTextAsFile();
                if (path != null) {
                    execute.executeCup(path);
                }

            }
        });

        ejecutarJCCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JPanel ho = (JPanel) multiTab.getSelectedComponent();
                JScrollPane sccodigo = (JScrollPane) ho.getComponent(0);
                JTextArea textArea = (JTextArea) sccodigo.getViewport().getComponent(0);


                execute.executeJCC(textArea.getText());
            }
        });


        ASTCupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String path = currentTextAsFile();
                if (path == null) {
                    return;
                }
                execute.astCup(path);
                console.setText(console.getText()+"\n"+"Grafica cup");
            }
        });

        astJCCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JPanel ho = (JPanel) multiTab.getSelectedComponent();
                JScrollPane sccodigo = (JScrollPane) ho.getComponent(0);
                JTextArea textArea = (JTextArea) sccodigo.getViewport().getComponent(0);

                execute.astJCC(textArea.getText());
                console.setText(console.getText()+"\n"+"Grafica jcc");
            }
        });

        TSCupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String path = currentTextAsFile();
                if (path == null) {
                    return;
                }
                execute.tsCup(path);
                console.setText(console.getText()+"\n"+"Tabla simbolos cup");
            }
        });
        TSJCCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JPanel ho = (JPanel) multiTab.getSelectedComponent();
                JScrollPane sccodigo = (JScrollPane) ho.getComponent(0);
                JTextArea textArea = (JTextArea) sccodigo.getViewport().getComponent(0);
                execute.tsJCC(textArea.getText());

                console.setText(console.getText()+"\n"+"Tabla simbolos jcc");
            }
        });
        erroresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                execute.reporteErrores();
            }
        });
    }

    /** Text of the editor in the selected tab, or null if there is no tab. */
    private String currentText() {
        if (multiTab.getSelectedIndex() < 0) {
            return null;
        }
        JPanel ho = (JPanel) multiTab.getSelectedComponent();
        JScrollPane sccodigo = (JScrollPane) ho.getComponent(0);
        JTextArea textArea = (JTextArea) sccodigo.getViewport().getComponent(0);
        return textArea.getText();
    }

    /**
     * The CUP parser reads from a file, so the current editor text is written to a
     * temporary one. This runs exactly what is on screen, even if it was never saved.
     */
    private String currentTextAsFile() {
        String text = currentText();
        if (text == null) {
            return null;
        }
        try {
            File tmp = File.createTempFile("pollo-frito", ".txt");
            tmp.deleteOnExit();
            try (Writer w = new OutputStreamWriter(new FileOutputStream(tmp), "UTF-8")) {
                w.write(text);
            }
            return tmp.getAbsolutePath();
        } catch (IOException e) {
            console.setText("No se pudo preparar el archivo: " + e.getMessage());
            return null;
        }
    }

    /** Opens a file in its own tab (used to preload the examples). */
    public void openPath(String path) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            console.setText(console.getText() + "\nNo se pudo abrir " + path);
            return;
        }
        String actual = currentText();
        boolean reuse = multiTab.getTabCount() == 1 && "new:".equals(multiTab.getTitleAt(0))
                && actual != null && actual.isEmpty();
        if (!reuse) {
            addWindow();
        }
        int index = multiTab.getTabCount() - 1;
        multiTab.setSelectedIndex(index);
        JPanel ho = (JPanel) multiTab.getComponentAt(index);
        JScrollPane sccodigo = (JScrollPane) ho.getComponent(0);
        JTextArea textArea = (JTextArea) sccodigo.getViewport().getComponent(0);
        textArea.setText(contenido.toString());
        textArea.setCaretPosition(0);
        multiTab.setTitleAt(index, new File(path).getName());
    }

    /** Same layout as GUI2.form, for builds that don't run IntelliJ's form compiler. */
    private void buildLayout() {
        panel1 = new JPanel(new GridBagLayout());
        multiTab = new JTabbedPane();
        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

        abrirButton = new JButton("Abrir");
        guardarButton = new JButton("Guardar");
        guardarComoButton = new JButton("Guardar Como");
        TSCupButton = new JButton("TS Cup");
        TSJCCButton = new JButton("TS JCC");
        ASTCupButton = new JButton("AST cup");
        astJCCButton = new JButton("Ast JCC");
        erroresButton = new JButton("Errores");
        addPestaña = new JButton("Add Pestaña");
        closePestañaButton = new JButton("Close Pestaña");
        ejecutarCupButton = new JButton("Ejecutar Cup");
        ejecutarJCCButton = new JButton("Ejecutar JCC");

        JButton[] fila0 = {abrirButton, guardarButton, guardarComoButton, TSCupButton,
                TSJCCButton, ASTCupButton, astJCCButton, erroresButton};
        JButton[] fila1 = {addPestaña, closePestañaButton, ejecutarCupButton, ejecutarJCCButton};

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        for (int i = 0; i < fila0.length; i++) {
            c.gridx = i;
            c.gridy = 0;
            panel1.add(fila0[i], c);
        }
        for (int i = 0; i < fila1.length; i++) {
            c.gridx = i;
            c.gridy = 1;
            panel1.add(fila1[i], c);
        }

        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        c.gridy = 2;
        c.gridx = 0;
        c.gridwidth = 4;
        panel1.add(multiTab, c);

        JPanel consola = new JPanel(new BorderLayout());
        consola.add(panel2, BorderLayout.CENTER);
        c.gridx = 4;
        panel1.add(consola, c);
    }

    public void addWindow(){
        JPanel window = new JPanel();
        window.setBackground(Color.BLACK);
        window.setLayout(null);

        JLabel info = new JLabel("Dir");
        RSyntaxTextArea textArea = new RSyntaxTextArea();
        RTextScrollPane scroll = new RTextScrollPane(textArea);
        textArea.setBorder(null);

        AbstractTokenMakerFactory algo = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
        algo.putMapping("colors", "com.polloenpelotas.Extras.ExampleTokenMaker");
        textArea.setSyntaxEditingStyle("colors");
        textArea.setCodeFoldingEnabled(true);
        textArea.setCurrentLineHighlightColor(Color.decode("#9f9f9f"));
        textArea.setFadeCurrentLineHighlight(false);

        SyntaxScheme px = textArea.getSyntaxScheme();
        px.getStyle(Token.RESERVED_WORD).foreground = Color.BLUE;
        px.getStyle(Token.LITERAL_STRING_DOUBLE_QUOTE).foreground = Color.decode("#ff8306");
        px.getStyle(Token.LITERAL_NUMBER_DECIMAL_INT).foreground = Color.decode("#692a79");
        px.getStyle(Token.COMMENT_EOL).foreground = Color.GRAY;
        px.getStyle(Token.COMMENT_MULTILINE).foreground = Color.GRAY;
        px.getStyle(Token.SEPARATOR).foreground = Color.BLACK;
        px.getStyle(Token.OPERATOR).foreground = Color.BLACK;

        textArea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                caretUpdate2(evt, textArea, info);
            }
        });

        info.setForeground(Color.WHITE);
        info.setSize(500, 30);
        info.setLocation(10, 5);
        textArea.setSize(60, 60);
        info.setText("----");
        scroll.setSize(690, 570);
        scroll.setLocation(5, 30);
        window.add(scroll);

        window.add(info);
        multiTab.addTab("new:", null, window, "");


    }

    public void createConsole(){

        panel2.setLayout(null);
        console = new RSyntaxTextArea();
        RTextScrollPane scroll = new RTextScrollPane(console);
        console.setSize(60, 60);
        scroll.setSize(510, 600);
        scroll.setLocation(10, 19);

        console.setBackground(Color.BLACK);
        console.setForeground(Color.white);
        console.setCurrentLineHighlightColor(Color.BLACK);
        console.setText("Console");
        console.setEditable(false);
        console.setBorder(null);
        panel2.add(scroll);

    }

    public void openFile(){

        JFileChooser filechooserabrir = new JFileChooser();
        filechooserabrir.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("(*.*)", "*");
        filechooserabrir.setFileFilter(filtro);
        int seleccion = filechooserabrir.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {

                BufferedReader bufferreader;
                File file = filechooserabrir.getSelectedFile();
                bufferreader = new BufferedReader(new FileReader(file.getAbsolutePath()));
                String linea, contenido = "";
                JPanel ho = (JPanel) multiTab.getSelectedComponent();
                JScrollPane sccodigo = (JScrollPane) ho.getComponent(0);
                JTextArea codigooriginal = (JTextArea) sccodigo.getViewport().getComponent(0);

                while ((linea = bufferreader.readLine()) != null) {
                    contenido += linea + "\n";
                }
                codigooriginal.setText(contenido);
                bufferreader.close();

                multiTab.setTitleAt(multiTab.getSelectedIndex(), file.getAbsolutePath());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveFile(){

        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            String path = multiTab.getTitleAt(multiTab.getSelectedIndex());
            fichero = new FileWriter(path);
            pw = new PrintWriter(fichero);
            JPanel ho = (JPanel) multiTab.getSelectedComponent();
            JScrollPane sccodigo = (JScrollPane) ho.getComponent(0);
            JTextArea codigooriginal = (JTextArea) sccodigo.getViewport().getComponent(0);

            pw.println(codigooriginal.getText());
            pw.close();
            fichero.close();

        } catch (IOException ef) {

            JOptionPane.showMessageDialog(null, "El archivo no se guardo", "", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    public void saveAsFile(){
        FileNameExtensionFilter filtrotxt;
        JFileChooser dialogoguardar = new JFileChooser();

        //Filtro
        filtrotxt = new FileNameExtensionFilter("", "*");
        dialogoguardar.setFileFilter(filtrotxt);

        dialogoguardar.showSaveDialog(this);
        File fichero = dialogoguardar.getSelectedFile();

        if (fichero != null) {
            try (FileWriter ficheroguardando = new FileWriter(fichero + "")) {
                JPanel ho = (JPanel) multiTab.getSelectedComponent();
                JScrollPane sccodigo = (JScrollPane) ho.getComponent(0);
                JTextArea codigooriginal = (JTextArea) sccodigo.getViewport().getComponent(0);
                ficheroguardando.write(codigooriginal.getText());
                JOptionPane.showMessageDialog(null, "El archivo se a guardado Exitosamente", "", JOptionPane.INFORMATION_MESSAGE);

                multiTab.setTitleAt(multiTab.getSelectedIndex(), fichero.getAbsolutePath());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado", "", JOptionPane.WARNING_MESSAGE);

            }
        }

    }

    public void caretUpdate2(javax.swing.event.CaretEvent evt, RSyntaxTextArea txtentrada, JLabel lcaret){
        try {
            int posicion = txtentrada.getCaretPosition();
            int fila = (posicion == 0) ? 1 : 0;
            for (int offset = posicion; offset > 0; ) {
                offset = Utilities.getRowStart(txtentrada, offset) - 1;
                fila++;
            }
            int offset = Utilities.getRowStart(txtentrada, posicion);
            int columna = posicion - offset;
            lcaret.setText("Linea: " + fila + "       Columna: " + columna);
        } catch (BadLocationException e) {
            e.printStackTrace();
        } finally {

        }

    }

    public void executeCup(){


    }


}
