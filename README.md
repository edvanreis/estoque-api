<h1><b>estoque-api</b></h1>
<p>Projeto Desafio Ler, Armazenar, Calcular dados</b>

<h2>Funcionalidade:</h2>
<p>Cadastra os produtos na base de dados e calcula a quantidade de produtos por loja</p>
<h2>Detalhes da Implementação</h2>
<ul>
  <li>
      <p>Tecnologias utilizadas na implementação:</p>
  </li>
  <li>
      <p>JAVA: 8,</p>
  </li>
  <li>
      <p>Spring boot:2.4.5 ,</p>
  </li>
  <li>
      <p>SPRING-DATA-JPA:2.4.5 ,</p>
  </li>
  <li>
      <p>JUNIT: 5,</p>
  </li>
  <li>
      <p>pring-boot-starter-test:2.4.5 ,</p>
  </li>
  <li>
      <p>DataBase para teste: postgres</p>
  </li>
  <li>
      <p>Lombok.</p>
  </li>
   <li>
      <p>Swagger 3.0</p>
  </li>
</ul>


<h2>Pre-requisitos para o Funcionamento:</h2>
<ul>
  <li>JAVA 8,</li>
  <li>MAVEN,</li>
  <li>POSTMAN OU QUALQUER OUTRO DO RAMO,</li>
  <li>É necessario rodar os arquivos .json de massa</li>
  <li>Quando rodar o arquivo .json colocar o nome do arquivo que esta executando Ex:<br/>
    {"file":"data_1.json","data":[{"product":"RTIX","quantity":25,"price":"$0.67","type":"3XL","industry":"Industrial Specialties","origin":"LA"}}
  </li>
   <li>Quando for fazer o cálculo informar no endpoint:nome do produto ea quantidade de lojas</li>
</ul>
<h2>Instalação:</h2>
<ul>
  <li>1 - Instalar Eclipse compatível com java 8</li>
  <li>2 - fazer o download do repositório</li>
  <li>3 - importar como projeto MAVEN. APÓS, RODAR: MAVEN -&gt; UPDATE  / MAVEN -&gt; CLEAN / MAVEN -&gt; INSTALL</li>
  <li>4 - NÃO É NECESSÁRIO TER SERVIDOR (CONTEINER WEB - TOMCAT EMBUTIDO). ABRA A CLASSE: <em>EstoqueApiApplication.java.</em> e rode a partir dela.</li>
  <li>5 - Dentro do projeto tem uma pasta chamada: POSTMAN_ENDPOINTS. Nela consta a massa de dados para rodar no projeto.</li>
  <li>6 - Importe no postman o arquivos <em>data_1.json,data_2.json,data_3.json,data_4.json</em> um cada vez que se encontra dentro da pasta  POSTMAN_ENDPOINTS</li>
</ul>
<h2>Swagger Api Documentation:</h2>
<ul>
    <li>http://localhost:8080/swagger-ui/index.html</h1>
</ul>
<h2>Exemplo do desafio:</h2>
<ul>
    <li>https://estoque-loja.herokuapp.com/calculo-estoque</h1>
</ul>  
