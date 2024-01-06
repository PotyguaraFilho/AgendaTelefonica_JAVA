import java.sql.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Tela1 {

    @FXML
    private Button botaoAdd;

    @FXML
    private Button botaoVOLTAR;

    @FXML
    private TextField dddTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField numeroTextField;

    private Scene cenaAnterior;

    ConexaoMySQL connMySQL = new ConexaoMySQL();

    @FXML
    void adicionarContato(ActionEvent event) {
        String sql = "INSERT INTO DADOS (NOME, DDD, NUMERO, EMAIL) VALUES (?, ?, ?, ?)";
    
        PreparedStatement ps = null;
        Contatos contatos = new Contatos();

        try {
            contatos.setNome(nomeTextField.getText());
            contatos.setDdd(validarNumero(dddTextField.getText()));
            contatos.setNumero(validarNumero(numeroTextField.getText()));
            contatos.setEmail(emailTextField.getText());

            if(nomeTextField.getText().equals("") || 
               dddTextField.getText() == "" || 
               numeroTextField.getText() == "" || 
               emailTextField.getText().equals(""))
               {
                exibirAlerta(Alert.AlertType.INFORMATION, "Campo Vazio", "Nenhum dos campos podem ficar vazios.");
            }
            else{
                ps = connMySQL.getConexao().prepareStatement(sql);
                ps.setString(1, contatos.getNome());
                ps.setInt(2, contatos.getDdd());
                ps.setInt(3, contatos.getNumero());
                ps.setString(4, contatos.getEmail());
                
                nomeTextField.clear();
                dddTextField.clear();
                numeroTextField.clear();
                emailTextField.clear();

                exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Contato adicionado com sucesso!");

                ps.executeUpdate();
                ps.close();
            }
        } catch (Exception e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao enviar dados ao Banco.");
        }
    }
    private void exibirAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
    private int validarNumero(String texto) {
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            exibirAlerta(Alert.AlertType.WARNING, "Informação Errada", "Os Campos: DDD e Número, só recebem números inteiros, será inserido um Zero(0) no local!");
            return 0;
        }
    }

    @FXML
    void voltarTelaInicial(ActionEvent event) {
        if (cenaAnterior != null) {
            Stage stage = (Stage) botaoVOLTAR.getScene().getWindow();
            stage.setScene(cenaAnterior);
        }
    }
    public void setCenaAnterior(Scene cenaAnterior) {
        this.cenaAnterior = cenaAnterior;
    }

}
