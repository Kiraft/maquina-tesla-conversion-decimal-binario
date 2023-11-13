package com.example.decimaabinario;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ResourceBundle;

public class EstadoInicialController implements Initializable {

    @FXML
    private Line conector;

    @FXML
    private Label labelEstado;


    int estado;
    public Line getConector() {
        return conector;
    }

    public void setEstado(int estado){
        this.estado = estado;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Thread hilo = new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Platform.runLater(() -> {
                labelEstado.setText("q"+estado);
            });
        });

        hilo.start();

    }
}
