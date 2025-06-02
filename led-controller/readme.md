# 💡 Projeto de Controle de LED via Arduino + Spring Boot

Este projeto permite ligar e desligar um LED conectado ao Arduino usando uma interface web desenvolvida em Java (Spring Boot MVC), HTML e CSS. Toda a comunicação ocorre via porta serial (COM4). As ações são registradas em um banco de dados H2 (memória).

---

## 📋 Requisitos do Trabalho (Faculdade)

| Critério | Descrição |
|---------|-----------|--------|
| ✅ Web MVC | Projeto organizado em camadas: Controller, Service e Model
| ✅ POO | Uso de classes Java orientadas a objetos
| ✅ Responsividade e feedback visual | Página muda de cor ao ligar/desligar o LED
| ✅ Log em banco de dados | Cada ação é registrada no banco H2

---

## ⚙️ Tecnologias Utilizadas

- Arduino UNO
- Java 17+
- Spring Boot 3
- Maven
- HTML5 e CSS3
- H2 Database (modo memória)
- RXTX para comunicação serial

---

## 🚀 Como Executar o Projeto

### 1. ⚡ Carregue o Código no Arduino

Copie e carregue o seguinte código no seu Arduino (via Arduino IDE):


int ledPin = 13;
int dado;

void setup() {
  Serial.begin(9600);
  pinMode(ledPin, OUTPUT);
}

void loop() {
  if (Serial.available() > 0) {
    dado = Serial.read();
    if (dado == '1') {
      digitalWrite(ledPin, HIGH);
    } else if (dado == '2') {
      digitalWrite(ledPin, LOW);
    }
  }
}
⚠️ Verifique se o Arduino está conectado na porta COM4. Caso não esteja, atualize a porta no arquivo Java LedService.java.

2. 💻 Execute o Projeto Java
Descompacte o arquivo led-controller.zip

No terminal, vá até a pasta do projeto:

bash
Sempre exibir os detalhes

Copiar
cd led-controller
Execute o projeto:

bash
Sempre exibir os detalhes

Copiar
mvn spring-boot:run
3. 🌐 Acesse a Interface Web
Abra seu navegador em:

arduino
Sempre exibir os detalhes

Copiar
http://localhost:8080
Você verá:

Um botão de Ligar/Desligar LED

Mudança de cor do fundo (ex: verde para ligado, vermelho para desligado)

Log de cada ação no banco

4. 🗃️ Acessar o Console do Banco (H2)
Acesse:

bash
Sempre exibir os detalhes

Copiar
http://localhost:8080/h2-console
Use os seguintes dados:

Campo	Valor
JDBC URL	jdbc:h2:mem:testdb
User Name	sa
Password	(deixe em branco)

Após conectar, execute:

sql
Sempre exibir os detalhes

Copiar
SELECT * FROM LED_LOG;
🧱 Estrutura de Pastas
swift
Sempre exibir os detalhes

Copiar
led-controller/
├── src/
│   ├── main/
│   │   ├── java/com/exemplo/led/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   └── service/
│   │   └── resources/
│   │       ├── static/
│   │       │   └── style.css
│   │       ├── templates/
│   │       │   └── index.html
│   │       └── application.properties
├── pom.xml
└── README.md
❗ Observações
Feche o Monitor Serial do Arduino IDE antes de rodar o projeto, ou haverá conflito de porta.

Projeto usa a biblioteca RXTX para comunicação serial (incluída no zip).

Porta serial COM4 está fixa — altere em LedService.java se necessário.

📚 Créditos
Desenvolvido por [Gabriel Teixeira] para a disciplina de Projeto de Software.
