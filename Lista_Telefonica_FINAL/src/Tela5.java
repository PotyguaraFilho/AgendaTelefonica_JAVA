import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Tela5 {

    @FXML
    private ScrollPane ScrollPane;

    @FXML
    private Button botaoLIS;

    @FXML
    private Button botaoVOLTAR;

    @FXML
    private TextArea resultadoText;

    private Scene cenaAnterior;

    ConexaoMySQL connMySQL = new ConexaoMySQL();

    @FXML
    void ListarContatos(ActionEvent event) {
	String sql = "SELECT * FROM DADOS";
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder infoUsers = new StringBuilder();

        try {
            ps = connMySQL.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String contatoNome = rs.getString("NOME");
                int ddd = rs.getInt("DDD");
                int numero = rs.getInt("NUMERO");
                String email = rs.getString("EMAIL");

                String infoUser = "Nome: "+ contatoNome + "\n" +
                                  "Número: ("+ String.valueOf(ddd) + ") " + String.valueOf(numero) + "\n" +
                                  "Email: " + email +
                                  "\n_________________________\n\n";
                    
                infoUsers.append(infoUser);
            }
            resultadoText.setText(infoUsers.toString());
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Contatos listados com sucesso.");

            ps.close();
            rs.close();

        } catch (Exception e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro", "Não foi possivel listar os contatos.");
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
