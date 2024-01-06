import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Tela2 {

    @FXML
    private Button botaoPES;

    @FXML
    private Button botaoVOLTAR;

    @FXML
    private TextField nomeTextField;

    @FXML
    private Label resultado;

    private Scene cenaAnterior;

    ConexaoMySQL connMySQL = new ConexaoMySQL();

    @FXML
    void pesquisarContato(ActionEvent event) {
	    String sql = "SELECT * FROM DADOS WHERE NOME = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Contatos contatos = new Contatos();

        try {
            contatos.setNome(nomeTextField.getText());
            
            if(nomeTextField.getText().equals("")){
                exibirAlerta(Alert.AlertType.INFORMATION,"Campo Vazio","Para pesquisar, digite um nome.");
            }
            else{
                ps = connMySQL.getConexao().prepareStatement(sql);
                ps.setString(1, contatos.getNome());
    
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    String contatoNome = rs.getString("NOME");
                    int ddd = rs.getInt("DDD");
                    int numero = rs.getInt("NUMERO");
                    String email = rs.getString("EMAIL");

                    String infoUser = "Nome: "+ contatoNome + "\n" +
                                      "Número: ("+ String.valueOf(ddd) + ") " + String.valueOf(numero) + "\n" +
                                      "Email: " + email;
                    
                    resultado.setText(infoUser);
      
                }
                else{
                    exibirAlerta(Alert.AlertType.ERROR, "Inexistente", "Contato não existente na Agenda.");
                }
            }

        } catch (Exception e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro", "Não foi possível buscar os dados.");
        }
    }
    private void exibirAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
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
