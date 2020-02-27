package com.morajavier.practicaunoismd.calculosoperaciones;

import java.util.Stack;

public class CalculoOperaciones {

    private Stack<String> pila;
    private Stack<String> pilaAux;
    private String data;
    private String aux;
    private String aux0;
    private char caracter;
    public  CalculoOperaciones(String data){

        this.data = data;
        pila = new Stack<String>();
        pilaAux = new Stack<String>();
    }
    public int infijoAPostfijo(){
        int tamanioData = this.data.length();
        int resOperacion = 0;
        char c;
        String strAux = "";
        String cAux;
        for(int i = 0; i<tamanioData; ++i){
            c = this.data.charAt(i);
            if(esParentesisDer(c)){
                pilaAux.push(c+"");
            }else if(esParentesisIzq(c)){
                while(!this.data.isEmpty()){
                    if(!(cAux = pilaAux.pop()).equals("(")) pila.push(cAux);
                }
            }else{
                if(!esOperador(c)){
                    //Checamos si el siguiente de charAt es igual un numero lo concatenamos
                    if(i+1 < tamanioData ){
                        if(!esOperador(this.data.charAt(i+1))){
                            pila.push((c+this.data.charAt(i+1))+"");
                            ++i;
                        }else{
                            pila.push(c+"");
                        }
                        //esOperador(this.data.charAt(i+1));
                    }else{
                        pila.push(c+"");
                    }

                }else{
                    if(pila.size() > 1){
                        if(c == '*'){
                            while(!pila.isEmpty()){
                                resOperacion = 1;
                                resOperacion = Integer.parseInt(pila.peek()) * resOperacion;
                                pila.pop();
                            }
                        }else if(c == '/'){
                            while(!pila.isEmpty()){
                                resOperacion = 1;
                                resOperacion = Integer.parseInt(pila.peek())/resOperacion;
                                pila.pop();
                            }
                        }else if(c == '+'){
                            while(!pila.isEmpty()){
                                resOperacion += Integer.parseInt(pila.peek());
                                pila.pop();
                            }
                        }else if(c == '-'){
                            while(!pila.isEmpty()){
                                resOperacion -= Integer.parseInt(pila.peek());
                                pila.pop();
                            }
                        }
                        pila.push(resOperacion+"");
                        resOperacion = 0;
                    }else{
                        pilaAux.push(c+"");
                    }
                }
            }

        }
        resOperacion = 0;
        while(!pilaAux.isEmpty()){
            if(!esParentesisIzq(pilaAux.peek().charAt(0))){
                if(pilaAux.peek().charAt(0) == '*'){
                    resOperacion = 1;
                    while(!pila.isEmpty()){
                        resOperacion *= Integer.parseInt(pila.peek());
                        pila.pop();
                    }
                }else if(pilaAux.peek().charAt(0) == '/'){
                    resOperacion = 1;
                    while(!pila.isEmpty()){
                        resOperacion = Integer.parseInt(pila.peek())/resOperacion;
                        pila.pop();
                    }
                }else if(pilaAux.peek().charAt(0) == '+'){
                    while(!pila.isEmpty()){
                        resOperacion += Integer.parseInt(pila.peek());
                        pila.pop();
                    }
                }else if(pilaAux.peek().charAt(0) == '-'){
                    while(!pila.isEmpty()){
                        resOperacion = Integer.parseInt(pila.peek()) - resOperacion;
                        pila.pop();
                    }
                }
                pila.push(resOperacion+"");
                resOperacion = 0;
            }
            pilaAux.pop();
        }
        strAux = pila.pop();
        return Integer.parseInt(strAux);
    }
    private boolean esParentesisDer(char c){
        return c==')';
    }
    private boolean esParentesisIzq(char c){
        return c=='(';
    }
    private boolean esOperador(char c){
        return c=='*' || c=='/' || c=='+' || c=='-';
    }
    private void importancia(char c){
        switch (c){
            case '*':
                System.out.println("Hola");
                break;
            default:
                System.out.println("Default");
                break;
        }
    }
}
