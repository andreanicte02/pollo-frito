package com.polloenpelotas.Extras;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
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

                if(multiTab.getTitleAt(multiTab.getSelectedIndex()).equals("new:")){
                    saveAsFile();

                }

                String path = multiTab.getTitleAt(multiTab.getSelectedIndex());
                execute.executeCup(path);

            }
        });

        ejecutarJCCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(multiTab.getTitleAt(multiTab.getSelectedIndex()).equals("new:")){
                    saveAsFile();
                }

                String path = multiTab.getTitleAt(multiTab.getSelectedIndex());
                execute.executeJCC(path);
            }
        });


        ASTCupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String path = multiTab.getTitleAt(multiTab.getSelectedIndex());
                execute.astCup(path);
                console.setText(console.getText()+"\n"+"Grafica cup");
            }
        });

        astJCCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String path = multiTab.getTitleAt(multiTab.getSelectedIndex());
                execute.astJCC(path);
                console.setText(console.getText()+"\n"+"Grafica jcc");
            }
        });

        TSCupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String path = multiTab.getTitleAt(multiTab.getSelectedIndex());
                execute.tsCup(path);
                console.setText(console.getText()+"\n"+"Tabla simbolos cup");
            }
        });
        TSJCCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String path = multiTab.getTitleAt(multiTab.getSelectedIndex());
                execute.tsJCC(path);
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

    public void addWindow(){
        JPanel window = new JPanel();
        window.setBackground(Color.BLACK);
        window.setLayout(null);

        JLabel info = new JLabel("Dir");
        RSyntaxTextArea textArea = new RSyntaxTextArea();
        RTextScrollPane scroll = new RTextScrollPane(textArea);
        textArea.setBorder(null);

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
            fichero = new FileWriter(multiTab.getTitleAt(multiTab.getSelectedIndex()));
            pw = new PrintWriter(fichero);
            JPanel ho = (JPanel) multiTab.getSelectedComponent();
            JScrollPane sccodigo = (JScrollPane) ho.getComponent(0);
            JTextArea codigooriginal = (JTextArea) sccodigo.getViewport().getComponent(0);

            pw.println(codigooriginal.getText());
            JOptionPane.showMessageDialog(null, "El archivo se a guardado Exitosamente", "", JOptionPane.INFORMATION_MESSAGE);

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
