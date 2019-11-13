/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author Usuario DAM 2
 */
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.Persona;

public class PestaniaSiete extends JFrame implements ActionListener, ChangeListener {

    JButton botonNormal, bDialogoInfo, bDialogoWarn, bDialogoError, bDialogoOpciones, bDialogoOpcionesPerso,
            bDialogoEntrada, bDialogoEntradaPersona;
    JProgressBar barraProgreso;
    int opcion;
    Container container;

    public PestaniaSiete() {

        initGUI();
    }

    public void initGUI() {
        instancias();
        configurarBarra();
        configurarPanel();
        acciones();
        this.setTitle("Examen DI");
        this.setSize(new Dimension(1000, 1000));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void configurarBarra() {
        barraProgreso.setMinimum(0);
        barraProgreso.setMaximum(100);
        barraProgreso.setValue(0);
        //barraProgreso.getValue();
        barraProgreso.setStringPainted(true);
        barraProgreso.setBorderPainted(true);

    }

    private void acciones() {
        botonNormal.addActionListener(this);
        bDialogoInfo.addActionListener(this);
        bDialogoWarn.addActionListener(this);
        bDialogoError.addActionListener(this);
        bDialogoOpciones.addActionListener(this);
        bDialogoOpcionesPerso.addActionListener(this);
        bDialogoEntrada.addActionListener(this);
        bDialogoEntradaPersona.addActionListener(this);
        barraProgreso.addChangeListener(this);

    }

    private void configurarPanel() {
        container.add(botonNormal);
        container.add(barraProgreso);
        container.add(bDialogoInfo);
        container.add(bDialogoWarn);
        container.add(bDialogoError);
        container.add(bDialogoOpciones);
        container.add(bDialogoOpcionesPerso);
        container.add(bDialogoEntrada);
        container.add(bDialogoEntradaPersona);
    }

    private void instancias() {
        botonNormal = new JButton("Pulsar");
        barraProgreso = new JProgressBar();
        bDialogoError = new JButton("Error");
        bDialogoWarn = new JButton("Aviso");
        bDialogoInfo = new JButton("Info");
        bDialogoOpciones = new JButton("Pregunta");
        bDialogoOpcionesPerso = new JButton("Pregunta perso");
        bDialogoEntrada = new JButton("Entrada");
        bDialogoEntradaPersona = new JButton("Entrada persona");

        container = this.getContentPane();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonNormal) {
            barraProgreso.setValue(barraProgreso.getValue() + 25);
            if (barraProgreso.getValue() == 100) {
                getToolkit().beep();
            }
        } else if (e.getSource() == bDialogoInfo) {
            JOptionPane.showMessageDialog(PestaniaSiete.this, "ESte es un diálogo de información",
                    "Titulo del mensaje", JOptionPane.INFORMATION_MESSAGE, null);
        } else if (e.getSource() == bDialogoError) {

            JOptionPane.showMessageDialog(PestaniaSiete.this, "ESte es un diálogo de error",
                    "Titulo del mensaje", JOptionPane.ERROR_MESSAGE, null);

        } else if (e.getSource() == bDialogoWarn) {
            JOptionPane.showMessageDialog(PestaniaSiete.this, "ESte es un diálogo de warning",
                    "Titulo del mensaje", JOptionPane.WARNING_MESSAGE, null);
        } else if (e.getSource() == bDialogoOpciones) {
            opcion = JOptionPane.showConfirmDialog(PestaniaSiete.this,
                    "¿Segudo que quieres continuar?",
                    "Titulo del mensaje", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null);

            if (opcion == JOptionPane.YES_OPTION) {
                System.out.println("Pulsado si");
            } else if (opcion == JOptionPane.NO_OPTION) {
                System.out.println("Pulsado no");
            } else if (opcion == JOptionPane.CANCEL_OPTION) {
                System.out.println("Pulsado cancelar");
            }

        } else if (e.getSource() == bDialogoOpcionesPerso) {
            String[] opciones = {"Botón1", "Botón2", "Botón3"};
            Persona[] personas = {new Persona("Nombre1", "Apellido1", 123, 123, false),
                new Persona("Nombre2", "Apellido2", 123, 123, false),
                new Persona("Nombre3", "Apellido3", 123, 123, false)};
            int opcionPerso = JOptionPane.showOptionDialog(PestaniaSiete.this, "Selecciona una opción",
                    "Título del diálogo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    personas, personas[0]);
            switch (opcionPerso) {
                case 0:
                    System.out.println("Boton 1 pulsado");
                    break;
                case 1:
                    System.out.println("Boton 2 pulsado");
                    break;
                case 2:
                    System.out.println("Boton 3 pulsado");
                    break;
            }
        } else if (e.getSource() == bDialogoEntrada) {
            String datoIntro = JOptionPane.showInputDialog(PestaniaSiete.this, "Introduce datos",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(datoIntro);
        } else if (e.getSource() == bDialogoEntradaPersona) {
            //MUESTRA COMBOBOX DEL ARRAY
            /*Persona[] personas = {new Persona("Nombre1", "Apellido1", 123, 123, false),
                new Persona("Nombre2", "Apellido2", 123, 123, false),
                new Persona("Nombre3", "Apellido3", 123, 123, false)};
            Persona seleccionada = (Persona) JOptionPane.showInputDialog(PestaniaSiete.this,"Selecciona una persona",
                    "Titulo",JOptionPane.INFORMATION_MESSAGE,null,personas,personas[0]);
            System.out.println(seleccionada.getNombre());*/

            //MUESTRA UN AREA PARA ESCRIBIR
            /*String datoIntro = JOptionPane.showInputDialog(PestaniaSiete.this, "Introduce datos",
                    "Mensaje",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(datoIntro);*/
            
            
            //MUESTRA BOTONES DE ORDEN DERECHA A IZQUIERDA
            /*Persona[] personas = {new Persona("Nombre1", "Apellido1", 123, 123, false),
                new Persona("Nombre2", "Apellido2", 123, 123, false),
                new Persona("Nombre3", "Apellido3", 123, 123, false)};
            int opcionPerso = JOptionPane.showOptionDialog(PestaniaSiete.this, "Selecciona una opción",
                    "Título del diálogo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    personas, personas[0]);*/
            
            
            //IGUAL QUE EL ANTERIOR PERO CON YES NO Y CANCEL
            /*opcion = JOptionPane.showConfirmDialog(PestaniaSiete.this,
                    "¿Segudo que quieres continuar?",
                    "Titulo del mensaje", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null);*/
            
            
            //MUESTRA MENSAJE DE INFORMACION,ERROR o AVISO
            /*JOptionPane.showMessageDialog(PestaniaSiete.this, "ESte es un diálogo de warning",
                    "Titulo del mensaje", JOptionPane.WARNING_MESSAGE, null);*/
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (barraProgreso.getValue() == 100) {
            JOptionPane.showMessageDialog(PestaniaSiete.this, "Proceso completo",
                    "Titulo del mensaje", JOptionPane.INFORMATION_MESSAGE, null);

        }
    }
}
