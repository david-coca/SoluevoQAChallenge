# Desafio Soluevo QA Challenge

## Developed
![GitHub contributors](https://img.shields.io/github/contributors/tomgunners/MobileAutomation?color=green&label=Wellington%20de%20Oliveira%20Francisco)

## About
<h3>O objetivo do desafio é criar uma suite de testes automatizados para garantir o funcionamento básico da Ferramenta de Apontamento de Bugs</h3>

* Cenário 1 (Justificando uma criticidade)<br>
* - Ao apontar bug de criticidade Top Priority os usuários devem informar o motivo da classificação no campo [Descreva o motivo pelo qual Bug é considerado Top Priority];
* Cenário 2 (Cadastro de Bug com sucesso)<br>
* - Ao preencher o formulário com todos os campos obrigatórios e clicar no botão [Submit] o bug deve ser registrado e o sistema deve apresentar a mensagem [Você brilhou! Obrigado pela participação do nosso processo de seleção de QA.]

## Languages and Frameworks

Este projeto usa as seguintes linguagens e frameworks:

* [Java 11](https://openjdk.java.net/projects/jdk/11/) linguagem de programação.
* [Cucumber](https://cucumber.io/docs/gherkin/reference/) descreve o valor do negócio em uma linguagem natural.
* [Junit](https://junit.org/junit4/) é uma estrutura de teste de unidade para a linguagem de programação Java.
* [Selenium WebDriver](https://www.selenium.dev/) estrutura de automação do navegador da Web usando a linguagem Java.
* [AssertJ](https://joel-costigliola.github.io/assertj/) as the fluent assertion library
* [Allure Report](https://docs.qameta.io/allure/) relatório de teste personalizado
* [JavaFaker](https://javadoc.io/doc/com.github.javafaker/javafaker/latest/com/github/javafaker/Faker.html) gerador de dados aleatórios dinamicos
* [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) gerenciador do binário do Selenium WebDriver

## Arquitetura do Projeto

O Projeto foi desenvolvido seguindo boas praticas de arquitetura, você encontrar os guintes itens nesta arquitetura:

* [BaseWeb](#BaseWeb)
* [SeleniumRobot](#SeleniumRobot)
* [Utils](#Utils)
* [FormMap](#FormMap)
* [FormPage](#FormPage)
* [CadastroDeBugSteps](#CadastroDeBugSteps)
* [Hooks](#Hooks)
* [RunnerTest](#RunnerTest)
* [Form.Feature](#FormFeature)

```bash
                                                            
├───report           - Local do report html                                 
├───src                                               
│   ├───main                                          
│   │   ├───java                                      
│   │        ├───commons         - Package com classes utilitárias para todo o projeto
│   │        ├───map             - Package com id / xpath dos campos da aplicação       
│   │        ├───page            - Package com as telas da aplicação herdando os campos do map             
│   │        ├───steps           - Package responsável pela lógica automatizada
│   └───test                                          
│       ├───java                                      
│       │   └───runner           - Package responsável pela classe de execução dos testes
│       └───resources                                 
│           └───features          - Package com os cenários de Teste no formato Gherkin
```

### BaseWeb
A classe BaseWeb é responsável pela execução inicial do WebDriver como variável de referência estática para todo o projeto, além disso é responsãvel pela inicialização do Browser selecionado.

### SeleniumRobot
A classe SeleniumRobot é responsavel pelas ações do Selenium sendo extentida pela Classe `CadastrDeBugSteps`.

### Utils
A classe Utils é respnsavel pelas ações "mecanicas" como upload de arquivo e screenshot da tela.

### FormMap
A classe FormMap é responsável por guardar os campos da tela.

### FormPage
A classe FormPage é responsável por receber o retorno dos campos e ser usada na classe `CadastroDeBugSteps` junta das ações em tela.

### CadastroDeBugSteps
A classe CadastroDeBugSteps é onde fica a definição de etapas armazenando o mapeamento entre cada etapa do cenário definido no package resources/features no arquivo form.feature com um código de função a ser executada.

### Hooks
A classe Hooks é responsavel pelo redirecionamento para o site a partir do navegador escolhido como o encerramento e fechamento do browse, além de tirar uma evidencia caso ocorra uma falha no comportamento.

### RunnerTest
A classe RunnerTest é responsavel por executar a Suite de Testes descrita na `FormFeature` e a lógica da Classe `CadastroDeBugSteps`

### FormFeature
O arquivo .Feature é responsavel pela regra de negócio no modelo BDD com Gherkin no Cucumber;

## Run
<h3>Para executar o projeto, será necessário instalar os seguintes programas:</h3>

- [JDK 11: Necessário para executar o projeto Java](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3.8.7 Necessário para realizar o build do projeto Java - apache-maven-3.8.7-src.zip](https://maven.apache.org/download.cgi)

*Não Esqueça de configurar as variáveis de ambiente para execução.
- [Tutorial para configuração das variáveis](https://medium.com/beelabacademy/configurando-vari%C3%A1veis-de-ambiente-java-home-e-maven-home-no-windows-e-unix-d9461f783c26#:~:text=Bom%2C%20mas%20o%20que%20s%C3%A3o,arquivos%20necess%C3%A1rios%2C%20inclusive%20os%20bin%C3%A1rios.)
- [IntelliJ: Para desenvolvimento do projeto](https://www.jetbrains.com/pt-br/idea/)

*Instale também os plugins Gherkin e Cucumber for Java.

## Execução via IDE

O arquivo que deve ser executado encontra-se:

```bash
# src/test/java/runTest/RunnerTest.java
```
[IntelliJ] Para executar o projeto basta clicar com o botão direito do mouse -> Run 'RunTest'

## Execução Via Terminal

É possível executar o projeto via linha de comando. Após configurar as variáveis de ambiente abra o terminal.

```bash
# Você deverá clonar o projeto para alguma pasta ou repositório local da sua maquina e depois executar o comando
# clonando projeto do git
$ git clone https://github.com/SoluevoQAChallenge/tomgunners.git

# Após clonar o projeto você precisará abrir o cmd e navegar ate a pasta do projeto
# acesse a pasta do projeto
$ cd SoluevoQAChallenge

# Dentro do projeto basta executar o comando abaixo
# execute o comando do maven para execução dos testes.
$ mvn clean install test
```

## OBS:
Devido ao site ter CAPTCHA será necessario realizar a verificação manual das figuras apresentadas


## License
[MIT](https://choosealicense.com/licenses/mit/)


