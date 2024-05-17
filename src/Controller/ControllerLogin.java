package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerLogin {

	@FXML
	private TextField email;

	@FXML
	private PasswordField senha;
	public Stage currentStage;

	public void entrar() {
		System.out.println("Tentativa de Login...");
		// Lógica de entrada
		if (email.getText().equals("admin") && senha.getText().equals("admin")) {
			System.out.println("Realizando login com acesso ADMIN");

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Dashboard.fxml"));
				
				Parent root = loader.load();
				
				Scene scene = new Scene(root, 834,459);
				
				Stage currentStage = (Stage) email.getScene().getWindow();

				currentStage.setScene(scene);
				currentStage.setTitle("Dashboard");
				currentStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			mensagemDeErro();
		}
	}

	public void mensagemDeErro() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Sua senha está incorreta");
		alert.setContentText("Sua senha está incorreta!");
		alert.setHeaderText(null);
		alert.showAndWait();
	}

}
