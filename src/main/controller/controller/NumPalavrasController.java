package controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class NumPalavrasController {

        @FXML
        private Label lbNumPalavras;



    public void getNum(int numPalavras)
    {

        String texto1= this.lbNumPalavras.getText();

        this.lbNumPalavras.setText(texto1+numPalavras+" palavras.");
    }



}
