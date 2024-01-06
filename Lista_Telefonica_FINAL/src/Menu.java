import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class Menu {

    @FXML
    private RadioButton Sair;

    @FXML
    private Button botaoADD;

    @FXML
    private Button botaoALT;

    @FXML
    private Button botaoDEL;

    @FXML
    private Button botaoLIS;

    @FXML
    private Button botaoPES;

    @FXML
    void adicionarContato(ActionEvent event) throws IOException {

        FXMLLoader Tela1Loader = new FXMLLoader(getClass().getResource("TelaADD.fxml"));
        Parent tela1 = Tela1Loader.load();
        Tela1 tela1controle = Tela1Loader.getController();

        tela1controle.setCenaAnterior(botaoADD.getScene());

        Stage telaInicio = (Stage) botaoADD.getScene().getWindow();
        Scene novaTela1 = new Scene(tela1);

        telaInicio.setResizable(false);
        telaInicio.setTitle("Adicionar Contato");
        telaInicio.setScene(novaTela1);
    }

    @FXML
    void alterarContato(ActionEvent event) throws IOException {

        FXMLLoader Tela3Loader = new FXMLLoader(getClass().getResource("TelaALT.fxml"));
        Parent tela3 = Tela3Loader.load();
        Tela3 tela3controle = Tela3Loader.getController();

        tela3controle.setCenaAnterior(botaoALT.getScene());

        Stage telaInicio = (Stage) botaoALT.getScene().getWindow();
        Scene novaTela3 = new Scene(tela3);

        telaInicio.setResizable(false);
        telaInicio.setTitle("Alterar Contato");
        telaInicio.setScene(novaTela3);
    }

    @FXML
    void deletarContato(ActionEvent event) throws Exception{
        FXMLLoader Tela4Loader = new FXMLLoader(getClass().getResource("TelaEXC.fxml"));
        Parent tela4 = Tela4Loader.load();
        Tela4 tela4controle = Tela4Loader.getController();

        tela4controle.setCenaAnterior(botaoDEL.getScene());

        Stage telaInicio = (Stage) botaoDEL.getScene().getWindow();
        Scene novaTela4 = new Scene(tela4);

        telaInicio.setResizable(false);
        telaInicio.setTitle("Deletar Contato");
        telaInicio.setScene(novaTela4);
    }

    @FXML
    void listarContatos(ActionEvent event) throws Exception{
        FXMLLoader Tela5Louder = new FXMLLoader(getClass().getResource("TelaLIS.fxml"));
        Parent tela5 = Tela5Louder.load();
        Tela5 tela5controle = Tela5Louder.getController();

        tela5controle.setCenaAnterior(botaoLIS.getScene());

        Stage telaInicio = (Stage) botaoLIS.getScene().getWindow();
        Scene novaTela5 = new Scene(tela5);

        telaInicio.setResizable(false);
        telaInicio.setTitle("Listar Contatos");
        telaInicio.setScene(novaTela5);
    }

    @FXML
    void pesquisarContato(ActionEvent event) throws Exception{

        FXMLLoader Tela2Loader = new FXMLLoader(getClass().getResource("TelaPES.fxml"));
        Parent tela2 = Tela2Loader.load();  
        Tela2 tela2controle = Tela2Loader.getController();

        tela2controle.setCenaAnterior(botaoPES.getScene());

        Stage telaInicio = (Stage) botaoPES.getScene().getWindow();
        Scene novaTela2 = new Scene(tela2);

        telaInicio.setResizable(false);
        telaInicio.setTitle("Pesquisar Contato");
        telaInicio.setScene(novaTela2);
    }

    @FXML
    void sairPrograma(ActionEvent event) {
        Platform.exit();
    }

}

