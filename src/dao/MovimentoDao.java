package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Veiculo;

public class MovimentoDao {

	private Veiculo veiculo;
	private static final String LOCAL_ARQUIVO = "C:/Users/21193113/clientes.ds1";

	  public Veiculo getveiculo() {
	        return veiculo;
	    }

	 
	    public MovimentoDao(Veiculo movimento) {
	        this.veiculo = movimento;
	    }


	    public MovimentoDao() {

	 

	    }

	public void salvar() {

		Path path = Paths.get(LOCAL_ARQUIVO);

		try {
			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("ISO-8859-1"),
					StandardOpenOption.WRITE, StandardOpenOption.APPEND);

			writer.write(veiculo.toString());
			writer.newLine();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Veiculo> listarMovimentos() {
		// procedimento de abertura de arquivo para leitura ou escrita

		// PASSO 1: obter o caminho do arquivo.

		Path path = Paths.get(LOCAL_ARQUIVO);

		// PASSO 2: criar o buffer para o arquivo, indicando o arquivo (path) e o
		// conjunto de caracteres.

		try {
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));

			String linha = reader.readLine();
			ArrayList<Veiculo> veiculos = new ArrayList<>();

			while (linha != null) // vai emprimir todas as linhas.
			{
				String[] vetorMovimento = linha.split(";");

				Veiculo veiculo = new Veiculo();
				veiculo.setCodigo(vetorMovimento[0]);
				veiculo.setPlaca(vetorMovimento[1]);
				veiculo.setModelo(vetorMovimento[2]);
				veiculo.setDataEntrada(vetorMovimento[3]);
				veiculo.setHoraEntrada(vetorMovimento[4]);
				veiculo.setDataSaida(vetorMovimento[5]);
				veiculo.setHoraSaida(vetorMovimento[6]);
				veiculo.setTempo(vetorMovimento[7]);
				// veiculo.setValorPagar(vetorVeiculo[1]);

				veiculos.add(veiculo);

				linha = reader.readLine();
			}

			return veiculos;

		} catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo!");
			e.printStackTrace(); // pega a mensagem do erro p/ o programador || "e" é a variável do erro.
			return null;

		}

	}

	public Veiculo buscarMovimento(String placa) {

		  

	        // Passo 1 - obter o caminho do arquivo

	 

	        Path path = Paths.get(LOCAL_ARQUIVO);

	 

	        // Criar o Buffer para o arquivo
	        try {
	            BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));

	 

	            String linha = reader.readLine();
	            Veiculo movimento = new Veiculo();

	 

	            while (linha != null) {
	                String[] vetorCliente = linha.split(";");

	 

	                if (vetorCliente[1].equals(placa)) {
	                    movimento.setCodigo(vetorCliente[0]);
	                    movimento.setPlaca(vetorCliente[1]);
	                    movimento.setModelo(vetorCliente[2]);
	                    movimento.setDataEntrada(vetorCliente[3]);
	                    movimento.setHoraEntrada(vetorCliente[4]);
	                    movimento.setDataSaida(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	                    movimento.setHoraSaida(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
	    
	                    
	                    return movimento;

	                }

	 
	                linha = reader.readLine();

	            }
	            reader.close();
	            
	        } catch (Exception e) {
				System.out.println("Ocorreu um erro na tentativa de ler o arquivo!");
				e.printStackTrace(); // pega a mensagem do erro p/ o programador || "e" é a variável do erro.
				return null;

	    }
	        return veiculo;
	        
	}
}
