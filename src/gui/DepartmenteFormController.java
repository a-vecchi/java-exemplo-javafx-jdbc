package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmenteFormController implements Initializable{

	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private Label labelErroName;
	
	@FXML
	private Button btSave;

	@FXML
	private Button btCancel;
	
	@FXML
	private void onBtSaveAction() {
		System.out.println("onBtSaveAction");
	}

	@FXML
	private void onBtCancelAction() {
		System.out.println("onBtCancelAction");
	}

	private void InitializeNodes( ) {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		InitializeNodes();
	}
}
