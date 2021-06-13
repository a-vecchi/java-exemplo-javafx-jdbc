package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmenteFormController implements Initializable {

	private Department entity;

	private DepartmentService service;

	public void setDepartment(Department entity) {
		this.entity = entity;
	}

	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}

	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Departamento está vazio.");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	}

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
	private void onBtSaveAction(ActionEvent event) {
		if (entity == null) {
			throw new IllegalStateException("Departamento está vazio.");
		}
		if (service == null) {
			throw new IllegalStateException("Serviço do Departamento está vazio.");
		}
		try {
			entity = getFormData();
			service.saveOrUpdate(entity);
			Utils.currentState(event).close();
		} catch (DbException e) {
			Alerts.showAlert("Erro Salvando Registro", null, e.getMessage(), AlertType.ERROR);
		}
	}

	private Department getFormData() {
		Department obj = new Department();
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());

		return obj;
	}

	@FXML
	private void onBtCancelAction(ActionEvent event) {
		Utils.currentState(event).close();
	}

	private void InitializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		InitializeNodes();
	}
}
