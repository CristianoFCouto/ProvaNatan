package eagleBus;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class MainCode {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		/*
		 Funcionalidades:
		 -Comprar Passagem
		 -Verificar Passagemd
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

		//VARIAVEIS
		String arquivoUsuarios = "Users.txt";
		File arquivo = new File(arquivoUsuarios);

		boolean loopPrincipal = true;
		int escolhaMenu = 0;
		boolean subLoop = true;
		int escolhaSub = 0;
		
		String dado = "";
		
		Scanner scanner = new Scanner(System.in);
		
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        formatoData.setLenient(false);
		
		//PSEUDO OBJETO
		String[] ticket  = new String[]{"IDUser","CPF","Nome"};
		String[] infoViagem  = new String[]{"IDViagem","Origem", "Destino","Distancia","Data"};

			
		//DISTANCIAS
		String[][] destinos = new String[16][4];

        destinos[1] = new String[]{"1", "Santa-Rita", "52", "60"};
        destinos[2] = new String[]{"2", "Porteirão", "38", "45"};
        destinos[3] = new String[]{"3", "Verdelândia", "45", "50"};
        destinos[4] = new String[]{"4", "Pedra-Preta", "47", "55"};
        destinos[5] = new String[]{"5", "Morro-Branco", "48", "55"};
        destinos[6] = new String[]{"6", "Souzalândia", "44", "50"};
        destinos[7] = new String[]{"7", "Barro-Alto", "41", "50"};
        destinos[8] = new String[]{"8", "Vila-Proprício", "56", "70"};
        destinos[9] = new String[]{"9", "Artulândia", "26", "30"};
        destinos[10] = new String[]{"10", "Jaraguá", "45", "50"};
        destinos[11] = new String[]{"11", "Cirilândia", "62", "75"};
        destinos[12] = new String[]{"12", "Rianápolis", "67", "80"};
        destinos[13] = new String[]{"13", "Limoeiro", "70", "85"};
        destinos[14] = new String[]{"14", "Cafelândia", "77", "90"};
        destinos[15] = new String[]{"15", "Jucelândia", "82", "95"};
			
			
		//CABEÇALHO
		System.out.println(""
				+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
				+ "│    │    │                                   BEM VINDO!                                    │\r\n"
				+ "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
		
		Thread.sleep(2000);
		
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
					+ "│   │    │  VERSÃO PREVIA - MUDANÇAS EM PLANEJAMENTO                                        │\r\n"
					+ "│   │    ├───┬──────────────────────────────────────────────────────────────────────────────┤\r\n"
					+ "│ M │    │ 1 │ COMPRAR PASSAGEM                                                             │\r\n"
					+ "│ E │    │ 2 │ VERIFICAR PASSAGEM                                                           │\r\n"
					+ "│ N │    │ 3 │ MODIFICAR PASSAGEM*                                                          │\r\n"
					+ "│ U │    │ 4 │ CANCELAR PASSAGEM*                                                           │\r\n"
					+ "│   │    ├───┼──────────────────────────────────────────────────────────────────────────────┤\r\n"
					+ "│ I │    │ 5 │ VER ITINERÁRIOS*                                                             │\r\n"
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
					
					loopPrincipal = false;
					break;
					
				case 1:
					//COMPRA DE PASSAGEM
					
					
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
						
					}while(subLoop);
					
					subLoop = true;
					
					
					//SELEÇÃO DE DESTINO
					do {
						System.out.print(""
								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
								+ "| Destino:");
						escolhaSub = scanner.nextInt();
						
						System.out.println(""
								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");
						if(escolhaSub <= 0 || escolhaSub > 15 || String.valueOf(escolhaSub) == infoViagem[1])
						{
							System.out.println(""
									+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
									+ "│    │    │                    Opção invalida! Por favor insira uma correta !               │\r\n"
									+ "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
						}else {
							infoViagem[2] = String.valueOf(escolhaSub);
							subLoop = false;
						}

					}while(subLoop);
					
					subLoop = true;
					

					//SELEÇÃO DE DATA
					do {
			
						System.out.print(""
								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
								+ "| Data (Ex.: 01/02/2025):");
						
						dado = scanner.next();

			            System.out.println(""
			                    + "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");

				        try {
				 
				            Date dataEntrada = formatoData.parse(dado);
				            Date dataAtual = new Date();

				            if (dataEntrada.after(dataAtual)) {
				            	infoViagem[3] = String.valueOf(formatoData.format(dataEntrada));
				            	subLoop = false; 
				            } else {
				                System.out.println(""
				                        + "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
				                        + "│    │    │          Data inválida! Por favor insira uma data maior que a atual.            │\r\n"
				                        + "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
				            }
				        } catch (ParseException e) {
				            System.out.println(""
				                    + "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
				                    + "│    │    │         Formato de data inválido! Por favor, insira no formato dd/MM/yyyy.      │\r\n"
				                    + "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
				        }

				  
					}while(subLoop);
					
					subLoop = true;
					
					//CHEGAGEM E CADASTRAMENTO DE USUARIO
					try {
			            if (arquivo.createNewFile()) {
			                System.out.println("Arquivo criado: " + arquivo.getName());
			            } else {
			                System.out.println("Arquivo já existe.");
			            }
			        } catch (IOException e) {
			            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
			        }

			        do {
			            ticket[0] = String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits()));

			            System.out.print("├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
			                    + "| CPF (Somente números):                                                                                   \r\n");

			            System.out.println("├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");

			            while (true) {
			                try {
			                    String cpfInput = scanner.next(); 
			                    
			                    if (cpfInput.length() != 11 || !cpfInput.matches("\\d+")) { 
			                        System.out.println("╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
			                                + "│    │    │                    Opção inválida! Por favor insira uma correta!               │\r\n"
			                                + "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
			                    } else {
			                        ticket[1] = cpfInput;
			                        break;
			                    }
			                } catch (InputMismatchException e) {
			                    System.out.println("Por favor, insira apenas números.");
			                    scanner.next();
			                }
			            }

			            System.out.print("├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
			                    + "| Nome Completo: ");
			            ticket[2] = scanner.next();

			            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo, true))) {
			                escritor.write(ticket[0] + "," + ticket[1] + "," + ticket[2] + "," + infoViagem[1] + "," + infoViagem[2]+ "," +infoViagem[3]);
			                escritor.newLine();
			                
			            } catch (IOException e) {
			                System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
			            }
			            
			            System.out.println("╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
			                    + "│    │    │           Reserva criada com sucesso! Bem-vindo, " + ticket[2] + "!         \r\n"
			                    + "╰───┴────┴──────────────────────────────────────────────────────────────────────────────────╯\r\n");
			            
			            System.out.print(""
								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
								+ "| Clique qualquer tecla para sair.\r\n");
						
						dado = scanner.next();
						System.out.println(""
								+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");

			            

			            subLoop = false;

			        } while (subLoop);

					break;
					
				case 2:			
//					 Scanner scanner = new Scanner(System.in);
			        String filePath = "Users.txt"; // Caminho do arquivo
			        String linha;

			        // Solicitar ao usuário o CPF do cliente a ser buscado
			        System.out.print("Digite o CPF do cliente (somente números): ");
			        String cpfBuscado = scanner.next();

			        // Verificação se o CPF é válido
			        if (cpfBuscado.length() != 11 || !cpfBuscado.matches("\\d+")) {
			            System.out.println("CPF inválido. O CPF deve ter 11 dígitos numéricos.");
			            return; // Encerrar a execução
			        }

			        try (BufferedReader leitor = new BufferedReader(new FileReader(filePath))) {
			            boolean encontrado = false; // Flag para verificar se o registro foi encontrado
			            
			            // Ler cada linha do arquivo
			            while ((linha = leitor.readLine()) != null) {
			                String[] leituraTicket = linha.split(","); // Supondo que os dados estejam separados por vírgula

			                // Verifica se o CPF corresponde
			                if (leituraTicket.length >= 6 && leituraTicket[1].equals(cpfBuscado)) {
			                    encontrado = true;

			                    // Extraindo informações para o comprovante
			                    String pontoPartida = leituraTicket[3]; // PONTO DE PARTIDA
			                    String pontoChegada = leituraTicket[4]; // PONTO DE CHEGADA
			                    String cliente = leituraTicket[2]; // Nome Completo
			                    String id = leituraTicket[0]; // ID
			                    String data = leituraTicket[5]; // Substitua por uma data real se disponível
			                    String empresa = "EAGLE-BUS TRANSPORTES LTDA"; // Substitua pelo nome real da empresa

			                    // Exibição do comprovante
			                    System.out.println("╭────────────────────────────────────────────────────────────────────╮");
			                    System.out.println("│                                COMPROVANTE                          │");
			                    System.out.println("├────────────────────────────────────────────────────────────────────┤");
			                    System.out.printf("│ PONTO DE PARTIDA   : %-47s │\n", pontoPartida);
			                    System.out.printf("│ PONTO DE CHEGADA   : %-47s │\n", pontoChegada);
			                    System.out.println("├────────────────────────────────────────────────────────────────────┤");
			                    System.out.printf("│ CLIENTE            : %-47s │\n", cliente);
			                    System.out.printf("│ CPF                : %-47s │\n", cpfBuscado);
			                    System.out.printf("│ ID                 : %-47s │\n", id);
			                    System.out.printf("│ DATA               : %-47s │\n", data);
			                    System.out.println("├────────────────────────────────────────────────────────────────────┤");
			                    System.out.printf("│ %-62s │\n", empresa);
			                    System.out.println("╰────────────────────────────────────────────────────────────────────╯");
			                    break; // Para sair do loop após encontrar e mostrar o comprovante
			                }
			            }

			            if (!encontrado) {
			                System.out.println("Registro com CPF " + cpfBuscado + " não encontrado.");
			            }

			        } catch (IOException e) {
			            
			        }
			        
			        System.out.print(""
							+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
							+ "| Clique qualquer tecla para sair.\r\n");
					
					dado = scanner.next();
					System.out.println(""
							+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");
					
					break;
					
					
				case 3:
					break;
					
					
				case 4:
					break;
					
					
				case 5:
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

			        System.out.println(""
			        		+ "╭───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╮\r\n"
			        		+ "|                                           I   T   I   N   E   R   Á   R   I   O                                       |\r\n"
			        		+ "╰───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╯\r\n"
			        		+ ");\r\n"
			        		+ "");
			        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nn\n\n");
			        
			    	System.out.print(""
							+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
							+ "| Clique qualquer tecla para sair.\r\n");
					
					dado = scanner.next();
					System.out.println(""
							+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");
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
					System.out.println(""
							+"╭──────────────────────────────────────────────────────────────────────────────────────────────────────╮\r\n"
			               + "│                           8 | SOBRE A EMPRESA:                                                       │\r\n"
			               + "│   ───────────────────────────────────────────────────────────────────────────────────────────────────│\r\n"
			                +"│                           NOME: EAGLE-BUS TRANSPORTES LTDA                                           │\r\n"
			                +"│                           CNPJ: 22.123.372/0001-05                                                   │\r\n"
			                +"│   ───────────────────────────────────────────────────────────────────────────────────────────────────│\r\n"
			                +"│                           DIRETORIA:                                                                 │\r\n"
			                +"│                           CRISTIANO COUTO C.O                                                        │\r\n"
			                +"│                           LUCAS CORREIA                                                              │\r\n"
			                +"│                           CAIO CAMPOS                                                                │\r\n"
			                +"│                           GUILHERME                                                                  │\r\n"
			                +"╰──────────────────────────────────────────────────────────────────────────────────────────────────────╯\r\n");

					System.out.print(""
							+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤\r\n"
							+ "| Clique qualquer tecla para sair.\r\n");
					
					dado = scanner.next();
					System.out.println(""
							+ "├──┼────┼───────────────────────────────────────────────────────────────────────────────────┤");
			        
					
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
		}while(loopPrincipal == true);
		
		scanner.close();
		//RODAPÉ OU FINALIZAÇÃO
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println(""
				+ "╭───┬────┬──────────────────────────────────────────────────────────────────────────────────╮\r\n"
				+ "│    │    │                         Obrigado por utilizar o EAGLE-BUS 𓅃!                   /\r\n"
				+ "╰───┴────┴────────────────────────────────────────────────────────────────────────────────╯\r\n");
		
		Thread.sleep(2000);
	}

}













	
	
