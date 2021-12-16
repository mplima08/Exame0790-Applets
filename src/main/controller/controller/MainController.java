package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button btnContar;

    @FXML
    private TextField tfFrase;

    @FXML
    void contaPalavras(ActionEvent event) {
        String frase= this.tfFrase.getText();
        int numPalavras=1;
        int tamanho = frase.length();
        if(frase.equals(""))
        {
            alert(Alert.AlertType.ERROR,"Preencha o campo","Introduza uma frase");
        }else {
            for (int i = 0; i < tamanho; i++) {

                if (frase.charAt(i) == ' ') {
                    numPalavras++;
                }

            }
            if(frase.charAt(tamanho-1)!='.')
            {
                alert(Alert.AlertType.ERROR,"Falta ponto final","Introduza um ponto final");
            }else {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/NumPalavrasView.fxml"));
                    Parent root = loader.load();

                    NumPalavrasController controller = loader.getController();
                    controller.getNum(numPalavras);

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.setScene(scene);
                    stage.showAndWait();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void alert(Alert.AlertType type, String tit, String texto)
    {
        Alert alerta=new Alert(type);
        alerta.setTitle(tit);
        alerta.setHeaderText(null);
        alerta.setContentText(texto);
        alerta.showAndWait();
    }
}