package view;

import java.util.Scanner;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		RedesController redesController = new RedesController();
		String sistemaOperacional = System.getProperty("os.name");
		System.out.println(sistemaOperacional);
		int opc = 0;
		Scanner scanner = new Scanner(System.in);
		
		while (opc != 9) {
			System.out.println("Escolha uma opcao para iniciar: \n 1 - metodo ip \n 2 - metodo ping  \n 9 - encerrar");
			opc = scanner.nextInt();
			switch (opc) {
			case 1:
				redesController.ip(sistemaOperacional);
			break;
			
			case 2:
				redesController.ping(sistemaOperacional);
			break;
			case 9:
				System.out.println("Finalizado!");
			break;
			default:
				System.out.println("Opcao invalida");
			break;
			}
			
		}
		
		

	}

}
