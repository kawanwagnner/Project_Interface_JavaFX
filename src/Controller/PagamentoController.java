package Controller;

import java.util.Spliterator.OfInt;

import Model.Payment;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import repository.PagamentoRepository;

public class PagamentoController {
	// Cntrl + Espaço importar!
	@FXML
	private TextField nomeTitular;

	@FXML
	private TextField conta;

	@FXML
	private TextField cvv;

	@FXML
	private TextField mma;

	// Variables to List;
	@FXML
	private TableView<Payment> tablePayments;

	@FXML
	private TableColumn<Payment, String> trNome;
	
	@FXML
	private TableColumn<Payment, Integer> trConta;

	@FXML
	private TableColumn<Payment, String> trCVV;

	@FXML
	private TableColumn<Payment, String> trMMa;
	
	
	private PagamentoRepository repoPayment;

	@FXML
	public void initialize() {
		repoPayment = new PagamentoRepository();
	}

	public void adicionar() {
		System.out.println("Adicionado com sucesso!!");
		Payment pay = new Payment();
		pay.setNome(nomeTitular.getText());
		pay.setConta(Integer.parseInt(conta.getText()));
		pay.setCVV(cvv.getText());
		pay.setMMA(mma.getText());
		repoPayment.addPayment(pay);
	}

	public void clearFields() {
		nomeTitular.clear();
		conta.clear();
		cvv.clear();
		mma.clear();
	}

	public void limpar() {
		System.out.println("");
		System.out.println("Campos Limpos com sucesso!");
		clearFields();
	}

}
