package repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Payment;

public class PagamentoRepository {
	private List<Payment> payments;
	private File database;

	public PagamentoRepository() {
		this.database = new File("database-payments.txt");
		this.payments = new ArrayList<>();
		// Carregar os dados;
		loadPayments();
	}
	
	// Carregar
	private void loadPayments() {
		try (Scanner input = new Scanner(database)) {
			while (input.hasNextLine()) {
				
			String[] data = input.nextLine().split(";");
			if (data.length >= 4) {
				// 0 -> id, 1 -> nome, 2 -> início, 3 -> Fim
				Payment pay = new Payment();
				pay.setId(Long.parseLong(data[0]));
				pay.setNome(data[1]);
				pay.setConta(Integer.parseInt(data[2]));
				pay.setCVV(data[3]);
				pay.setMMA(data[4]);
				payments.add(pay);
			}
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("========================================");
			System.out.println("Arquivo não encontrado, criando um novo!");
			System.out.println("========================================");
		}
	}

	// CRUD -> Create, Read, Update and Delete;

	// Buscar todos;
	public List<Payment> buscarTodosPayments() {
		return new ArrayList<>(payments);
	}

	// Deletar pagamento;
	public void deletePayment(int id) {
		// Pecorrer todo o Array, caso seja igual ele vai remover
		payments.removeIf(pay -> pay.getId() == id);
		savePayments();
	}

	// Criar pagamento;
	public void addPayment(Payment pay) {
		// Vai faltar um ID
		pay.setId(getNextId());
		payments.add(pay);

		// Sobrescrever o arquivo database
		savePayments();
	}

	// Sobrescrever o arquivo database;
	private void savePayments() {
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(database, false))) {
			for (Payment pay : payments) {
				String data = pay.getId() + ";" + pay.getNome() + ";" + pay.getConta() + ";" + pay.getCVV() + ";" + pay.getMMA();
				
				// Escreva uma linha e passa para a proxima;
				writer.println(data);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Aquivo database não encontrado!");
		}
	}
	
	public void updatePayment(Payment updatePayment) {
		for(int i = 0 ; i < payments.size(); i ++	) {
			if(payments.get(i).getId() == updatePayment.getId()) {
				payments.set(i, updatePayment);
				savePayments();
				break;
			}
		}
	}
	
	public Payment getPaymentById(long id) {
		for(Payment pay : payments) {
			if(pay.getId() == id) {
				return pay;
			}
		}
		return null;
	}
	
	// Lógica ID;
	public long getNextId() {
		long maxId = 0;
		for(Payment pay : payments) {
			// Verifica se o npumero é maior qie o nosso número maximo;
			if (pay.getId() > maxId) {
				maxId = pay.getId();
			}
		}
		return maxId + 1;
	}
	
}
