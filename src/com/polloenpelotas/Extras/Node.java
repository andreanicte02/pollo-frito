package com.polloenpelotas.Extras;

import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Node> hijos;
    String name;
    public int id;

    public Node(){
        this.name ="";
        this.id=0;
        this.hijos = new ArrayList<>();
    }

    public Node(String name) {
        this.name = name;
        this.id =0;
        this.hijos = new ArrayList<>();

    }


    public void add(Node hijo) {

        this.hijos.add(hijo);

    }

    public void add(List<Node> hijos){
        this.hijos = hijos;
    }


}
