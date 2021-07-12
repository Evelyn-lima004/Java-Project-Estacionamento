package model;

public class Veiculo {
		
		private String codigo;
		private String placa;
		private String modelo;
		private String dataEntrada;
		private String horaEntrada;
		private String dataSaida;
		private String horaSaida;
		private String tempo;
		private double valorPagar;
		
		
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public String getPlaca() {
			return placa;
		}
		public void setPlaca(String placa) {
			this.placa = placa;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public String getDataEntrada() {
			return dataEntrada;
		}
		public void setDataEntrada(String dataEntrada) {
			this.dataEntrada = dataEntrada;
		}
		public String getHoraEntrada() {
			return horaEntrada;
		}
		public void setHoraEntrada(String horaEntrada) {
			this.horaEntrada = horaEntrada;
		}
		public String getDataSaida() {
			return dataSaida;
		}
		public void setDataSaida(String dataSaida) {
			this.dataSaida = dataSaida;
		}
		public String getHoraSaida() {
			return horaSaida;
		}
		public void setHoraSaida(String horaSaida) {
			this.horaSaida = horaSaida;
		}
		public String getTempo() {
			return tempo;
		}
		public void setTempo(String tempo) {
			this.tempo = tempo;
		}
		public double getValorPagar() {
			return valorPagar;
		}
		public void setValorPagar(double valorPagar) {
			this.valorPagar = valorPagar;
		}
		
		@Override
		public String toString() {
			return codigo + ";" + placa + ";" + modelo + ";" + dataEntrada + ";" 
		+ horaEntrada + ";" + dataSaida + ";" + horaSaida + ";" 
					+ tempo + ";" + valorPagar + ";";
		}
		
}

	
