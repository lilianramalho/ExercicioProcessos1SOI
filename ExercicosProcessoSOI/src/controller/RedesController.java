package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class RedesController {
	
	public RedesController() {	
		super();
	}
	
	public void ip(String sistemaOperacional) {
		Process process;
		try {
			boolean windows = false;
			if (sistemaOperacional.contains("Linux")) {
				process = Runtime.getRuntime().exec("ifconfig");
			}else {
				process = Runtime.getRuntime().exec("ipconfig");
				windows = true;
			}
			InputStream fluxo = process.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			String adaptador = null;

			while (linha != null) {
				if(windows) {
					if(linha.contains("Adaptador"))
						adaptador = linha.replace("Adaptador","").replace(":", "");
					else if(adaptador !=null && linha.contains("IPv4"))
					System.out.println("Adaptador:" + adaptador + "\n\t" + linha);
				}else {
					if(linha.contains("inet"))
					System.out.println( linha);
				}
					
					linha = buffer.readLine();	
			}		
			fluxo.close();
			buffer.close();
			leitor.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ping(String sistemaOperacional) {
		Process process;
		try {
			boolean windows = false;
			if (sistemaOperacional.contains("Linux")) {
				process = Runtime.getRuntime().exec("ping -c 10 www.google.com.br");
			}else {
				process = Runtime.getRuntime().exec("PING -n 10 www.google.com.br");
				windows = true;
			}
			InputStream fluxo = process.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			String mensagens = "";
			while (linha != null) {
					mensagens+=linha;
					linha = buffer.readLine();
			}
			if (windows) {
				System.out.println("A média final de tempo é:"+mensagens.substring(mensagens.length()-9));
			}else {
				linha = buffer.readLine();
				System.out.println("A média final de tempo é:"+mensagens.substring(mensagens.length()-9));
			}
			fluxo.close();
			buffer.close();
			leitor.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
