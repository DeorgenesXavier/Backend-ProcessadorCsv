# RestCsvProcessor

	Este projeto é um processador de dados, que realiza uma única leitura no início da aplicação de um arquivo com o nomde de movielist.csv,
	que deverá estar dentro da mesma pasta da application do projeto, filtrando as informações e traduzindo para uma tabela em memória,
	retornando um cálcula via API REST no endpoins /premios, com os dois premiados em menor e maior intervalo de tempo.
	Ele está codificado na linguagem Java, utilizando o Spring Boot framework.

# Getting Started

	Para executar o projeto, você precisará dos seguintes programas e configurações:

	   - Apache Maven 3.6.3: Utilzado para fazer o build do projeto Java.
	   
	   - Java jdk 11.0.8: Necessário para executar o projeto e o Jar que é gerado.
          
	   - IntelliJ IDEA 2020.2.1: Necessário para o desenvolvimento do projeto e para executar os testes unitários. 

# Developing

	- git clone https://github.com/DeorgenesXavier/Backend-RestCsvProcessor.git
	- cd Backend-RestCsvProcessor/

# Build

	- Não é necessário fazer o build do projeto, ele pode ser executado diretamente pelo Jar dentro da pasta.

# Deploying 
 
 	O projeto pode ser executado das seguintes maneiras:
  
 		- Entrar na pasta do projeto e abrir um prompt de comando. Dentro dele basta digitar o comando: 
 		  "java -cp application.jar com.prova.agibank.ProvaAgibankDeorgenes.Application"
 
		- É possível executar o projeto a partir da IDE do IntelliJ, onde também podem ser rodados os testes unitários do código.
 
# Features

	Este projeto executa, em sua inicialização, a leitura de todos os dados presentes no arquivo movielist com a extensão ".csv", 
	após isso, ele deixa disponível no endpoint /premios, o nome, e os respectivos anos dos produtores que ganharam dois ou mais premios 
	consecutivos no maior e no menor tempo.
	
	Os dados de entrada estão no seguinte formato:
	
	year;title;studios;producers;winner
	
	Devido ao formato dos dados de entrada, foi implementado um filtro para extrair a informação linha a linha e coluna a coluna, para que a informação pudesse ser 
	analisada e posteriormente obter os requisitos da aplicação.
	
	No caso dos dados de studios, há a possibilidade de ter mais de um "studio" produzindo o mesmo filme, então foi usado o separador "," para filtrar os estudios.
	
	No caso dos "producers", também há a possibilidade de ter mais de um produtor, porém, o separador não é apenas por ",", mas também "and".


# Configuration

	- No momento este projeto não tem nenhum parâmetro configurável.
 
# Links

	- Obrigado por ter lido até aqui. Em caso de elogios, melhorias ou bugs, entrar em contato pelo e-mail: deorgenes.junior@gmail.com xD

