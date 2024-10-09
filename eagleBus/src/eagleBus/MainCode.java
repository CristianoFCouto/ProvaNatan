package eagleBus;

import java.io.File;
import java.util.Scanner;

public class MainCode {
	
	public static void main(String[] args) throws InterruptedException {
		/*
		 Funcionalidades:
		 -Comprar Passagem
		 -Verificar Passagem
		 -Modificar Passagem
		 -Cancelar Passagem
		 
		 -Ver Itinerarios
		 -Ver Mapa
		 -Ver Taxas
		 
		 -Mais Opções
		 	-Informações do software
		 	-Configurações
		 		-Preco do Combustivel R$
		 		-Taxa de Serviço R$
		 
		 Utilizavel:
		 
		 -Ver Mapa
		 
		*/
		// DB - "v" = Cidade Vizinha (V1 , V2 , V3 ...) ; "F" = Destino final (F1, F2, F3 ...)
		
		
		String vetorGenerico[] = {};
		
		
		String infoUsuario[] = {"IDUser","CPF","Nome","ViagensRealizadas"};
			int IdUser = 0 ;
			String CPF = "00000000000";
			String Nome = "ABCDEFGHIJ";
			String ViagensRealizadas[] = {};
			
		String infoViagem[] = {"IDViagem","Origem", "Destino","Distancia","Data"};
			int IdViagem = 0 ;
			String Origem = "00000000000";
			String Destino = "ABCDEFGHIJ";
			Double Distancia = 0.0;
			String Data = "00/00/0000";
		
		String infoTicket[] = {"IDTicket","IDUser","IDViagem",};
			int IdTicket = 0;
		
		
		//Ajustes
		double precoCombustivel = 0.0;
		double taxaDeServico = 0.0;
		
	
		Scanner scanner = new Scanner(System.in);
		
		//CABEÇALHO
		System.out.println(""
				+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
				+ "│    │    │                                   BEM VINDO!                                    │\r\n"
				+ "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
		
		Thread.sleep(2000);
		
		boolean loop = true;
		int escolhaMenu = 0;
		
		//MENU PRINCIPAL
		do
		{	
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			
			System.out.println(""
					+ "╭───┬────┬────────────────────────────────────────────────────────────────────────────────────╮\r\n"
					+ "│    │    │                                EAGLE-BUS 𓅃                                       /\r\n"
					+ "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
			
			System.out.println(""
					+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
					+ "│   │    │                                                                                  │\r\n"
					+ "│   │    ├───┬──────────────────────────────────────────────────────────────────────────────┤\r\n"
					+ "│ M │    │ 1 │ COMPRAR PASSAGEM                                                             │\r\n"
					+ "│ E │    │ 2 │ VERIFICAR PASSAGEM                                                           │\r\n"
					+ "│ N │    │ 3 │ MODIFICAR PASSAGEM                                                           │\r\n"
					+ "│ U │    │ 4 │ CANCELAR PASSAGEM                                                            │\r\n"
					+ "│   │    ├───┼──────────────────────────────────────────────────────────────────────────────┤\r\n"
					+ "│ I │    │ 5 │ VER ITINERÁRIOS                                                              │\r\n"
					+ "│ N │    │ 6 │ VER MAPA                                                                     │\r\n"
					+ "│ I │    │ 7 │ VER TAXAS                                                                    │\r\n"
					+ "│ C │    ├───┼──────────────────────────────────────────────────────────────────────────────┤\r\n"
					+ "│ I │    │ 8 │ MAIS OPÇÕES                                                                  │\r\n"
					+ "│ A │    ├───┼──────────────────────────────────────────────────────────────────────────────┤\r\n"
					+ "│ L │    │ 0 │ SAIR                                                                         │\r\n"
					+ "│   │    ├───┴──────────────────────────────────────────────────────────────────────────────┤\r\n"
					+ "│   │    │                                                                                  │\r\n"
					+ "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
			
			System.out.print(""
					+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
					+ "| OPÇÃO:");
			escolhaMenu = scanner.nextInt();
			System.out.println(""
					+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");
			
			switch(escolhaMenu) {
			
				case 0:			
					
					loop = false;
					break;
					
				case 1:
					//COMPRA DE PASSAGEM
					boolean subLoop = true;
					int escolhaSub = 0;
					String dado = "";
					
					// SELEÇÃO DE ORIGEM
					do {
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						
						System.out.println(""
								+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
								+ "│   │    │                                                                                  │\r\n"
								+ "│   │    │                                                                                  │\r\n"
								+ "│   │    │                                                                                  │\r\n"
								+ "│   │    │                                                                                  │\r\n"
								+ "│   │    │                                  ● ⚑3             - - ● ⚑7                        │\r\n"
								+ "│   │    │               ● ⚑15              │               ○ ⚐6                            │\r\n"
								+ "│   │    │               \\                ○ ⚐2            /                                 │\r\n"
								+ "│ M │    │                  - ○ ⚐14         │            /                                  │\r\n"
								+ "│ A │    │                    │            │           ○ ⚐5                                 │\r\n"
								+ "│ P │    │                      \\         ○ ⚐1       /                                      │\r\n"
								+ "│ A │    │                        \\       │       /                                         │\r\n"
								+ "│   │    │                          ○ ⚐13  │     /                                          │\r\n"
								+ "│ D │    │                            \\   │   ○ ⚐4                                          │\r\n"
								+ "│ E │    │                              \\ │ /                                               │\r\n"
								+ "│   │    │                      -   - - - ⊙ - - \\                   ╭───────────────────────┤\r\n"
								+ "│ V │    │                    /  \\ /      │      -                  │        DESTINOS       │\r\n"
								+ "│ I │    │                  ○ ⚐11         /        \\                ├───────────────────────┤\r\n"
								+ "│ A │    │                 /             /          \\               │⚐ 1 Santa-Rita         │\r\n"
								+ "│ G │    │               /              /            ●  ⚑8          │⚐ 2 Porteirão          │\r\n"
								+ "│ E │    │            ● ⚑12             /                           │ ⚑ 3 Verdelândia       │\r\n"
								+ "│ M │    │                            ○ ⚐9                          │⚐ 4 Pedra-Preta        │\r\n"
								+ "│   │    │                          /                               │⚐ 5 Morro-Branco       │\r\n"
								+ "│   │    │                         /                                │⚐ 6 Souzalândia        │\r\n"
								+ "│   │    │                        │                                 │ ⚑ 7 Barro-Alto        │\r\n"
								+ "│   │    │                        ● ⚑10                             │ ⚑ 8 Vila-Proprício    │\r\n"
								+ "│   │    │                                                          │⚐ 9 Artulândia         │\r\n"
								+ "│   │    │           ╭──────────────────────────────────╮           │ ⚑ 10 Jaraguá          │\r\n"
								+ "│   │    │           │  ⊙  Goianésia (0)                │           │⚐ 11 Cirilândia        │\r\n"
								+ "│   │    │           │                                  │           │ ⚑ 12 Rianápolis       │\r\n"
								+ "│   │    │           │  ○  Cidade-vizinha               │           │⚐ 13 Limoeiro          │\r\n"
								+ "│   │    │           │                                  │           │⚐ 14 Cafelândia        │\r\n"
								+ "│   │    │           │  ●  Cidade-final                 │           │ ⚑ 15 Jucelândia       │\r\n"
								+ "╰───┴────┴──────────────────────────────────────────────────────────┴───────────────────────╯\r\n");
						
						System.out.print(""
								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
								+ "| Origem:");
						escolhaSub = scanner.nextInt();
						System.out.println(""
								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");
						
						if(escolhaSub < 0 || escolhaSub > 15)
						{
							System.out.println(""
									+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
									+ "│    │    │                    Opção invalida! Por favor insira uma correta !               │\r\n"
									+ "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
						}else {
							infoViagem[1] = String.valueOf(escolhaSub);
							subLoop = false;
						}
						
					}while(subLoop == true);
					
					subLoop = true;
					
					
					//SELEÇÃO DE DESTINO
					do {
						System.out.print(""
								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
								+ "| Destino:");
						escolhaSub = scanner.nextInt();
						
						System.out.println(""
								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");
						if(escolhaSub <= 0 || escolhaSub > 15 || String.valueOf(escolhaSub) == vetorGenerico[1])
						{
							System.out.println(""
									+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
									+ "│    │    │                    Opção invalida! Por favor insira uma correta !               │\r\n"
									+ "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
						}else {
							infoViagem[2] = String.valueOf(escolhaSub);
							subLoop = false;
						}
						
					}while(subLoop == true);
					
					subLoop = true;
					

					//SELEÇÃO DE DATA
//					do {
//						System.out.print(""
//								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
//								+ "| Data (Dia / Mes / Ano):");
//						escolhaSub = scanner.nextInt();
//						
//						System.out.println(""
//								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");
//						if(escolhaSub <= 0 || escolhaSub > 15 || String.valueOf(escolhaSub) == vetorGenerico[1])
//						{
//							System.out.println(""
//									+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
//									+ "│    │    │                    Opção invalida! Por favor insira uma correta !               │\r\n"
//									+ "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
//						}else {
//							infoViagem[2] = String.valueOf(escolhaSub);
//							subLoop = false;
//						}
//						
//					}while(subLoop == true);
					
					
					//CHEGAGEM E CADASTRAMENTO DE USUARIO
					do {
						System.out.print(""
								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
								+ "| CPF (Somente numeros):                                                                                   \r\n");
						
						System.out.println(""
								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");
						escolhaSub = scanner.nextInt();
						
						infoUsuario[1] = String.valueOf(escolhaSub);
						
						if(infoUsuario[1].length() > 11 || infoUsuario[1].length() < 0)
						{
							System.out.println(""
									+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
									+ "│    │    │                    Opção invalida! Por favor insira uma correta !               │\r\n"
									+ "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
						}else {
							if(escolhaSub == 1 /*Checar se existe cpf cadastrado*/)
							{
								System.out.println(""
										+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
										+ "│    │    │           Bem vindo de volta!"+infoUsuario[2]+"               │\r\n"
										+ "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");

							}else {
								//infoUsuario[1] = ultimo id - 1;
								
								System.out.print(""
										+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
										+ "| Nome Completo:");

								infoUsuario[3] = scanner.next();
								System.out.println(""
										+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");
							}
							subLoop = false;
						}
					}while(subLoop == true);
					
					subLoop = true;
					
					//CHEGAGEM E CRIAÇÃO DO TICKET
					
					do {
						
						
					}while(subLoop == true);
//					
//					
//					String infoTicket[] = {"IDTicket","IDUser","IDViagem"};
//					
//					
					
					break;
					
				case 2:			
					
					break;
					
					
				case 3:
					break;
					
					
				case 4:
					break;
					
					
				case 5:
					break;
					
				case 6:
					//MAPA DE VIAGEM
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					
					System.out.println(""
							+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
							+ "│   │    │                                                                                  │\r\n"
							+ "│   │    │                                                                                  │\r\n"
							+ "│   │    │                                                                                  │\r\n"
							+ "│   │    │                                                                                  │\r\n"
							+ "│   │    │                                  ● ⚑3             - - ● ⚑7                        │\r\n"
							+ "│   │    │               ● ⚑15              │               ○ ⚐6                            │\r\n"
							+ "│   │    │               \\                ○ ⚐2            /                                 │\r\n"
							+ "│ M │    │                  - ○ ⚐14         │            /                                  │\r\n"
							+ "│ A │    │                    │            │           ○ ⚐5                                 │\r\n"
							+ "│ P │    │                      \\         ○ ⚐1       /                                      │\r\n"
							+ "│ A │    │                        \\       │       /                                         │\r\n"
							+ "│   │    │                          ○ ⚐13  │     /                                          │\r\n"
							+ "│ D │    │                            \\   │   ○ ⚐4                                          │\r\n"
							+ "│ E │    │                              \\ │ /                                               │\r\n"
							+ "│   │    │                      -   - - - ⊙ - - \\                   ╭───────────────────────┤\r\n"
							+ "│ V │    │                    /  \\ /      │      -                  │        DESTINOS       │\r\n"
							+ "│ I │    │                  ○ ⚐11         /        \\                ├───────────────────────┤\r\n"
							+ "│ A │    │                 /             /          \\               │⚐ 1 Santa-Rita         │\r\n"
							+ "│ G │    │               /              /            ●  ⚑8          │⚐ 2 Porteirão          │\r\n"
							+ "│ E │    │            ● ⚑12             /                           │ ⚑ 3 Verdelândia       │\r\n"
							+ "│ M │    │                            ○ ⚐9                          │⚐ 4 Pedra-Preta        │\r\n"
							+ "│   │    │                          /                               │⚐ 5 Morro-Branco       │\r\n"
							+ "│   │    │                         /                                │⚐ 6 Souzalândia        │\r\n"
							+ "│   │    │                        │                                 │ ⚑ 7 Barro-Alto        │\r\n"
							+ "│   │    │                        ● ⚑10                             │ ⚑ 8 Vila-Proprício    │\r\n"
							+ "│   │    │                                                          │⚐ 9 Artulândia         │\r\n"
							+ "│   │    │           ╭──────────────────────────────────╮           │ ⚑ 10 Jaraguá          │\r\n"
							+ "│   │    │           │  ⊙  Goianésia (0)                │           │⚐ 11 Cirilândia        │\r\n"
							+ "│   │    │           │                                  │           │ ⚑ 12 Rianápolis       │\r\n"
							+ "│   │    │           │  ○  Cidade-vizinha               │           │⚐ 13 Limoeiro          │\r\n"
							+ "│   │    │           │                                  │           │⚐ 14 Cafelândia        │\r\n"
							+ "│   │    │           │  ●  Cidade-final                 │           │ ⚑ 15 Jucelândia       │\r\n"
							+ "╰───┴────┴──────────────────────────────────────────────────────────┴───────────────────────╯\r\n");
					
					System.out.print(""
							+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
							+ "| Clique qualquer tecla para sair.\r\n");
					
					dado = scanner.next();
					System.out.println(""
							+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");
					break;
					
				case 7:
					break;
					
				case 8:
					break;
					
				default:
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					
					Thread.sleep(2000);
					
					System.out.println(""
							+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
							+ "│    │    │                    Opção invalida! Por favor insira uma correta !               │\r\n"
							+ "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
					break;
			}
		}while(loop == true);
		
		//RODAPÉ OU FINALIZAÇÃO
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println(""
				+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
				+ "│    │    │                         Obrigado por utilizar o EAGLE-BUS 𓅃!                   /\r\n"
				+ "╰───┴────┴────────────────────────────────────────────────────────────────────────────────╯\r\n");
		
		Thread.sleep(2000);
	}

}













	
	
