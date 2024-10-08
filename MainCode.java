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
		String linha1[] = {"V1","Santa Rita do Novo destino","22","V2","Porteirão","34","F1","Verdelândia","40"};
		String linha2[] = {"V3","","","V4","","","V5","","","F2","",""};
		String linha3[] = {"F3","",""};
		String linha4[] = {"V6","","","F4","",""};
		String linha5[] = {"V7","F5"};
		String linha6[] = {"V8","","","V9","","","F6","",""};
		
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
					
					String ticket[] = {};
					//INSERIR itinerario
					
					// SELEÇÃO DE LINHA
					do {
						System.out.print(""
								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
								+ "| Linha:");
						escolhaSub = scanner.nextInt();
						System.out.println(""
								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");
						if(escolhaSub < 0 || escolhaSub > 6)
						{
							System.out.println(""
									+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
									+ "│    │    │                    Opção invalida! Por favor insira uma correta !               │\r\n"
									+ "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
						}else {
							subLoop = false;
						}
						
					}while(subLoop == true);
					
					subLoop = true;
					
					//SELEÇÃO DE ORIGEM
					do {
						System.out.print(""
								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
								+ "| Origem:");
						escolhaSub = scanner.nextInt();
						System.out.println(""
								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");
						if(escolhaSub < 0 || escolhaSub > 9)
						{
							System.out.println(""
									+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
									+ "│    │    │                    Opção invalida! Por favor insira uma correta !               │\r\n"
									+ "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
						}else {
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
						if(escolhaSub < 0 || escolhaSub > 9)
						{
							System.out.println(""
									+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
									+ "│    │    │                    Opção invalida! Por favor insira uma correta !               │\r\n"
									+ "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
						}else {
							subLoop = false;
						}
						
					}while(subLoop == true);
					
					//CADASTRO DE USUARIO
					ticket [1] = String.valueOf(escolhaMenu);
					
					System.out.print(""
							+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
							+ "| Nome Completo:");
					dado = scanner.next();
					ticket [2] = String.valueOf(dado);
					
					System.out.println(""
							+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");
					
					
					System.out.print(""
							+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
							+ "| CPF:                                                                                   \r\n");
					dado = scanner.next();
					
					
					System.out.println(""
							+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");
					
					ticket [3] = String.valueOf(dado);
					
					
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
							+ "│   |    |                                                                                  │\r\n"
							+ "│   |    |                                                                                  │\r\n"
							+ "│   |    |                                                                                  │\r\n"
							+ "│   |    |                                                                                  │\r\n"
							+ "│   |    |                                 ● ⚑1             - - ● ⚑2                        │\r\n"
							+ "│   |    |               ● ⚑6              |               ○ ⚐5                             │\r\n"
							+ "│   |    |               \\                ○ ⚐2            /                                 │\r\n"
							+ "│ M |    |                  - ○ ⚐9         |            /           ╭───────────────────────┤\r\n"
							+ "│ A |    |                    |            |           ○ ⚐4         |                       │\r\n"
							+ "│ P |    |                      \\         ○ ⚐1       /              |        DESTINOS       │\r\n"
							+ "│ A |    |                        \\       |       /                 |                       │\r\n"
							+ "│   |    |                          ○ ⚐8  |     /                   ├───────────────────────┤\r\n"
							+ "│ D |    |                            \\   |   ○ ⚐3                  |     DESTINO FINAL     │\r\n"
							+ "│ E |    |                              \\ | /                       ├───────────────────────┤\r\n"
							+ "│   |    |                      -   - - - ⊙ - - \\                   |⚑ 1  Verdelândia       │\r\n"
							+ "│ V |    |                    /  \\ /      |      -                  |⚑ 2  Barro-Alto        │\r\n"
							+ "│ I |    |                  ○ ⚐7          /        \\                |⚑ 3  Vila-Proprício    │\r\n"
							+ "│ A |    |                 /             /          \\               |⚑ 4  Jaraguá           │\r\n"
							+ "│ G |    |               /              /            ●  ⚑3          |⚑ 5  Rianápolis        │\r\n"
							+ "│ E |    |            ● ⚑5             /                            |⚑ 6  Jucelândia        │\r\n"
							+ "│ M |    |                            ○ ⚐6                          ├───────────────────────┤\r\n"
							+ "│   |    |                          /                               | DESTINOS SECUNDARIOS  │\r\n"
							+ "│   |    |                         /                                ├───────────────────────┤\r\n"
							+ "│   |    |                        |                                 |⚐ 1  Santa-Rita        │\r\n"
							+ "│   |    |                        ● ⚑4                              |⚐ 2  Porteirão         │\r\n"
							+ "│   |    |                                                          |⚐ 3  Pedra-Preta       │\r\n"
							+ "│   |    |           ╭──────────────────────────────────╮           |⚐ 4  Morro-Branco      │\r\n"
							+ "│   |    |           |  ⊙  Goianésia                    |           |⚐ 5  Souzalândia       │\r\n"
							+ "│   |    |           |                                  |           |⚐ 6  Artulândia        │\r\n"
							+ "│   |    |           |  ○  Cidade-vizinha               |           |⚐ 7  Cirilândia        │\r\n"
							+ "│   |    |           |                                  |           |⚐ 8  Limoeiro          │\r\n"
							+ "│   |    |           |  ●  Cidade-final                 |           |⚐ 9  Cafelândia        │\r\n"
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













	
	
