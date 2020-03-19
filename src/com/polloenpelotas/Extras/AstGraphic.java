package com.polloenpelotas.Extras;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AstGraphic {

    int contador=0;



    public void armar_Cuerpo_dot(Node raiz) {
        contador = 0;
        StringBuffer buffer = new StringBuffer();
        buffer.append("\ndigraph G {\r\nnode [shape=doublecircle, style=filled, color=khaki1, fontcolor=black];\n");
        this.listarNodos(raiz, buffer);
        this.enlazarNodos(raiz, buffer);
        buffer.append("}");

        FileWriter archivo;
        try {
            String nameruta = "Reporte201404104_AST";
            archivo = new FileWriter(nameruta + ".dot");

            PrintWriter escritura = new PrintWriter(archivo);
            escritura.println(buffer.toString());
            archivo.close();
            String cmd = "dot -Tpng " + nameruta + ".dot -o " + nameruta + ".png";
            Runtime.getRuntime().exec(cmd);

            String cmd2 = "gnome-open " + nameruta + ".png";
            Runtime.getRuntime().exec(cmd2);

        } catch (IOException ex) {
            Logger.getLogger(AstGraphic.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    private void listarNodos(Node praiz, StringBuffer buffer) {

        if (praiz != null) {
            buffer.append("node").append(contador).append("[label=\"").append(praiz.name).append("\"];\n");
            praiz.id = contador;
            contador++;
            for (Node temp : praiz.hijos) {
                if (temp != null) {
                    listarNodos(temp, buffer);
                }
            }
        }
    }


    private void enlazarNodos(Node praiz, StringBuffer buffer) {

        if (praiz != null) {
            for (Node temp : praiz.hijos) {

                if (temp != null) {
                    buffer.append("\"node").append(praiz.id).append("\"->");
                    buffer.append("\"node").append(temp.id).append("\";\n");
                    enlazarNodos(temp, buffer);
                }
            }
        }
    }


}
