package com.example.decimaabinario;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;

public class binarioController implements Initializable {

    @FXML
    private Label binario;

    @FXML
    private Button btnConvert;

    @FXML
    private Label cero;

    @FXML
    private Label cien;

    @FXML
    private HBox contenedorCinta;

    @FXML
    private Label cuatro;

    @FXML
    private Label dies;

    @FXML
    private Label dos;

    @FXML
    private Label doscientos;

    @FXML
    private ImageView flecha;

    @FXML
    private Label inicio;

    @FXML
    private Label mil;

    @FXML
    private Label ocho;

    @FXML
    private Label quinientos;

    @FXML
    private Label sesenta;

    @FXML
    private Label treinta;

    @FXML
    private TextField txtDecimal;

    @FXML
    private Label uno;

    Map<String, Double> positionsX = new HashMap<>();
    ArrayList<Integer> divisiones = new ArrayList<>();

//    TranslateTransition transition;

    @FXML
    void convertir(ActionEvent event) {
        int numeroDecimal = Integer.parseInt(txtDecimal.getText());

        divisiones.clear();
        divisiones.add(numeroDecimal);

        SequentialTransition seqTransition = new SequentialTransition();

        while (numeroDecimal > 1) {
            numeroDecimal /= 2;
            divisiones.add(numeroDecimal);
        }

//        Collections.reverse(divisiones);
        StringBuilder resultadoBinario = new StringBuilder();

        for (int i = 0; i < divisiones.size(); i++) {
            TranslateTransition transition = new TranslateTransition(Duration.seconds(1), flecha);
            TranslateTransition transition2 = new TranslateTransition(Duration.seconds(1), flecha);


            int ultimoResultado = divisiones.get(i);

            if (ultimoResultado >= 513 && ultimoResultado <= 1024) {
                transition2.setToX(positionsX.get("milX"));
            } else if (ultimoResultado >= 257 && ultimoResultado <= 512) {
                transition2.setToX(positionsX.get("quinientosX"));
            } else if (ultimoResultado >= 129 && ultimoResultado <= 256) {
                transition2.setToX(positionsX.get("docientosX"));
            } else if (ultimoResultado >= 65 && ultimoResultado <= 128) {
                transition2.setToX(positionsX.get("cienX"));
            } else if (ultimoResultado >= 33 && ultimoResultado <= 64) {
                transition2.setToX(positionsX.get("sesentaX"));
            } else if (ultimoResultado >= 17 && ultimoResultado <= 32) {
                transition2.setToX(positionsX.get("treintaX"));
            } else if (ultimoResultado >= 9 && ultimoResultado <= 16) {
                transition2.setToX(positionsX.get("diesX"));
            } else if (ultimoResultado >= 5 && ultimoResultado <= 8) {
                transition2.setToX(positionsX.get("ochoX"));
            } else if (ultimoResultado >= 3 && ultimoResultado <= 4) {
                transition2.setToX(positionsX.get("cuatroX"));
            } else if (ultimoResultado >= 1 && ultimoResultado <= 2) {
                transition2.setToX(positionsX.get("dosX"));
            }


            seqTransition.getChildren().add(transition2);
            System.out.println(ultimoResultado);

            if (ultimoResultado % 2 == 0) {
                transition.setToX(positionsX.get("ceroX"));
            } else {
                transition.setToX(positionsX.get("unoX"));
            }

            final int currentResidue = ultimoResultado;
            transition.setOnFinished(e -> {
                resultadoBinario.insert(0, currentResidue % 2);
                binario.setText(resultadoBinario.toString());
            });
            seqTransition.getChildren().add(transition);
        }
        TranslateTransition transition3 = new TranslateTransition(Duration.seconds(1), flecha);
        transition3.setToX(positionsX.get("inicioX"));
        seqTransition.getChildren().add(transition3);

        seqTransition.play();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        transition = new TranslateTransition(Duration.seconds(1), flecha);
        positionsX.put("ceroX", 325.0);
        positionsX.put("dosX", 270.0);
        positionsX.put("cuatroX", 215.0);
        positionsX.put("ochoX", 160.0);
        positionsX.put("diesX", 105.0);
        positionsX.put("treintaX", 50.0);
        positionsX.put("inicioX", -1.0);
        positionsX.put("sesentaX", -55.0);
        positionsX.put("cienX", -110.0);
        positionsX.put("docientosX", -165.0);
        positionsX.put("quinientosX", -220.0);
        positionsX.put("milX", -275.0);
        positionsX.put("unoX", -328.0);
    }
}


