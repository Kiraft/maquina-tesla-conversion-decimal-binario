package com.example.decimaabinario;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class binarioController implements Initializable {

    @FXML
    private TextArea txtArea;

    @FXML
    private Label binario;

    @FXML
    private Button btnConvert;

    @FXML
    private Label cero;

    @FXML
    private Label cien;

    @FXML
    private HBox containerEstados;

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
    static int iAux = 1;


    @FXML
    void convertir(ActionEvent event) {
        txtArea.setText("");
        containerEstados.getChildren().clear();
        int numeroDecimal = Integer.parseInt(txtDecimal.getText());

        divisiones.clear();
        divisiones.add(numeroDecimal);

        SequentialTransition seqTransition = new SequentialTransition();

        while (numeroDecimal > 1) {
            numeroDecimal /= 2;
            divisiones.add(numeroDecimal);
        }

        StringBuilder resultadoBinario = new StringBuilder();

        if (divisiones.get(0) % 2 == 0){
            try {
                FXMLLoader EstadoLoader = new FXMLLoader(App.class.getResource("estado_inicial.fxml"));
                Parent EstadoRoot = EstadoLoader.load();

                containerEstados.getChildren().add(EstadoRoot);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


        for (int i = 0; i < divisiones.size(); i++) {
            final int jAux = i;
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

            transition2.setOnFinished(e -> {
                if (ultimoResultado >= 513 && ultimoResultado <= 1024) {
                    mil.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    transition2.setToX(positionsX.get("milX"));
                } else if (ultimoResultado >= 257 && ultimoResultado <= 512) {
                    quinientos.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    transition2.setToX(positionsX.get("quinientosX"));
                } else if (ultimoResultado >= 129 && ultimoResultado <= 256) {
                    doscientos.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    transition2.setToX(positionsX.get("docientosX"));
                } else if (ultimoResultado >= 65 && ultimoResultado <= 128) {
                    cien.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    transition2.setToX(positionsX.get("cienX"));
                } else if (ultimoResultado >= 33 && ultimoResultado <= 64) {
                    sesenta.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    transition2.setToX(positionsX.get("sesentaX"));
                } else if (ultimoResultado >= 17 && ultimoResultado <= 32) {
                    treinta.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    transition2.setToX(positionsX.get("treintaX"));
                } else if (ultimoResultado >= 9 && ultimoResultado <= 16) {
                    dies.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    transition2.setToX(positionsX.get("diesX"));
                } else if (ultimoResultado >= 5 && ultimoResultado <= 8) {
                    ocho.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    transition2.setToX(positionsX.get("ochoX"));
                } else if (ultimoResultado >= 3 && ultimoResultado <= 4) {
                    cuatro.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    transition2.setToX(positionsX.get("cuatroX"));
                } else if (ultimoResultado >= 1 && ultimoResultado <= 2) {
                    dos.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    transition2.setToX(positionsX.get("dosX"));
                }
            });

            seqTransition.getChildren().add(transition2);

            if (ultimoResultado % 2 == 0) {
                transition.setToX(positionsX.get("ceroX"));
            } else {
                transition.setToX(positionsX.get("unoX"));
            }

            final int currentResidue = ultimoResultado;
            transition.setOnFinished(e -> {
                resultadoBinario.insert(0, currentResidue % 2);
                binario.setText(resultadoBinario.toString());
                if (jAux != (divisiones.size()-1)){
                    if (currentResidue % 2 == 0) {
                    } else {

                        try {
                            FXMLLoader EstadoLoader = new FXMLLoader(App.class.getResource("estado.fxml"));
                            Parent EstadoRoot = EstadoLoader.load();

                            EstadoController estadoController = EstadoLoader.getController();
                            estadoController.setEstado(iAux);
                            containerEstados.getChildren().add(EstadoRoot);
                            iAux++;
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }else {
                    if (currentResidue % 2 == 0) {
                    } else {

                        try {
                            FXMLLoader EstadoLoader = new FXMLLoader(App.class.getResource("estado_final.fxml"));
                            Parent EstadoRoot = EstadoLoader.load();

                            EstadoFinalController estadoController = EstadoLoader.getController();
                            estadoController.setEstado(iAux);
                            containerEstados.getChildren().add(EstadoRoot);
                            iAux++;
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }

            });
            seqTransition.getChildren().add(transition);
        }
        TranslateTransition transition3 = new TranslateTransition(Duration.seconds(1), flecha);
        transition3.setToX(positionsX.get("inicioX"));
        transition3.setOnFinished(e -> {
             mil.setStyle("-fx-border-color: #000000");
             quinientos.setStyle("-fx-border-color: #000000");
             doscientos.setStyle("-fx-border-color: #000000");
             cien.setStyle("-fx-border-color: #000000");
             sesenta.setStyle("-fx-border-color: #000000");
             treinta.setStyle("-fx-border-color: #000000");
             dies.setStyle("-fx-border-color: #000000");
             ocho.setStyle("-fx-border-color: #000000");
             cuatro.setStyle("-fx-border-color: #000000");
             dos.setStyle("-fx-border-color: #000000");
            txtArea.setText("Se cumple el Teorema 1 en al contener cintas en los que da vuelta\n" +
                    "Teorema 2: Se cumple al ser determinista, hay un numero determinado de digitos binarios\n" +
                    "Teorema 3: Se cumple al llevar pila para las divisiones y una para el conteo de recorridos\n" +
                    "Teorema 4: Lle va un contador para las divisiones, uno para los digitos binarios y uno para el contador de vueltas\n" +
                    "Teorema 5: Se cumple al llevar mas de dos contadores");
        });

        seqTransition.getChildren().add(transition3);

        seqTransition.play();
        iAux = 1;


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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

//        try {
//            FXMLLoader EstadoLoader = new FXMLLoader(App.class.getResource("estadoInicial.fxml"));
//            Parent EstadoRoot = EstadoLoader.load();
//
//            containerEstados.getChildren().add(EstadoRoot);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

    }
}


