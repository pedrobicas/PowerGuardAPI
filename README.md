# PowerGuard API

## 📋 Sobre o Projeto
PowerGuard é uma API desenvolvida para monitoramento e gerenciamento de falhas de energia e impactos cibernéticos. O sistema permite registrar, acompanhar e analisar eventos relacionados a interrupções de energia e ameaças cibernéticas, fornecendo recomendações e insights para mitigação de riscos.

## 👥 Equipe
- Felipe Terra - RM99405
- Gabriel Freitas - RM550187
- Pedro Bicas - RM99534

## 🚀 Tecnologias Utilizadas
- Java 17
- Spring Boot 3.2.3
- Spring Security
- Spring Data JPA
- PostgreSQL
- JWT para autenticação
- Swagger/OpenAPI para documentação
- Maven para gerenciamento de dependências

## 📦 Funcionalidades Principais

### Autenticação e Segurança
- Registro de usuários
- Login com JWT
- Proteção de rotas
- Validação de tokens

### Gestão de Eventos
- Registro de falhas de energia
- Registro de alertas de segurança
- Simulação de ataques cibernéticos
- Listagem de eventos por tipo

### Gestão de Localizações
- Cadastro de localizações
- Registro de áreas afetadas
- Mapeamento de incidentes

### Gestão de Durações
- Registro de tempo de interrupção
- Estimativas de duração
- Histórico de eventos

### Gestão de Perdas
- Registro de perdas financeiras
- Impacto em residências e empresas
- Estimativas de prejuízo

### Recomendações
- Orientações para diferentes situações
- Números de emergência
- Medidas preventivas

## 🔧 Configuração do Ambiente

### Pré-requisitos
- Java 17 ou superior
- Maven
- PostgreSQL
- IDE (recomendado: IntelliJ IDEA ou Eclipse)

### Configuração do Banco de Dados
1. Instale o PostgreSQL
2. Crie um banco de dados chamado `powerguarddb`
3. Configure as credenciais no arquivo `application.properties`

### Instalação
1. Clone o repositório:
```bash
git clone https://github.com/pedrobicas/powerguard-api.git
```

2. Navegue até o diretório do projeto:
```bash
cd powerguard-api
```

3. Instale as dependências:
```bash
mvn install
```

4. Execute o projeto:
```bash
mvn spring-boot:run
```

## 📚 Documentação da API
A documentação completa da API está disponível através do Swagger UI:
- URL: `http://localhost:8080/swagger-ui.html`

### Principais Endpoints

#### Autenticação
- POST `/api/auth/register` - Registro de usuário
- POST `/api/auth/login` - Login de usuário

#### Eventos
- POST `/api/eventos/falha` - Registrar falha de energia
- POST `/api/eventos/alerta` - Registrar alerta de segurança
- POST `/api/eventos/simular-ataque` - Simular ataque cibernético
- GET `/api/eventos` - Listar eventos

#### Localizações
- POST `/api/locations` - Criar localização
- GET `/api/locations` - Listar localizações

#### Durações
- POST `/api/durations` - Criar duração
- GET `/api/durations` - Listar durações

#### Perdas
- POST `/api/losses` - Criar perda
- GET `/api/losses` - Listar perdas

#### Recomendações
- GET `/api/recommendations` - Obter recomendações
- GET `/api/recommendations/emergency` - Obter números de emergência

## 🔒 Segurança
- Autenticação via JWT
- Senhas criptografadas com BCrypt
- Proteção contra CSRF
- Validação de dados de entrada
- Headers de segurança configurados

## 📊 Estrutura do Projeto
```
src/main/java/com/example/powerguard/
├── config/          # Configurações do Spring
├── controller/      # Controladores REST
├── dto/            # Objetos de transferência de dados
├── model/          # Entidades JPA
├── repository/     # Repositórios JPA
├── service/        # Lógica de negócio
└── PowerGuardApplication.java
```

## 🤝 Contribuição
1. Faça um Fork do projeto
2. Crie uma Branch para sua Feature (`git checkout -b feature/AmazingFeature`)
3. Faça o Commit das suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Faça o Push para a Branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request