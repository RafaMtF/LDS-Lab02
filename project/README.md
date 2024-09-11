# Histórias de Usuário

## Cliente

### 1. Cadastro de Cliente
- **Como cliente**, quero me cadastrar no sistema para que eu possa fazer pedidos de aluguel de automóveis.
  - **Critérios de Aceitação**:
    - O cliente deve fornecer seus dados pessoais (RG, CPF, Nome, Endereço, etc.).
    - O cliente deve criar um login e senha para acessar o sistema.

### 2. Consulta de Automóveis Disponíveis
- **Como cliente**, quero consultar os automóveis disponíveis para aluguel, para escolher o que melhor atende às minhas necessidades.
  - **Critérios de Aceitação**:
    - O sistema deve exibir uma lista de automóveis com detalhes como matrícula, marca, modelo, ano e placa.

### 3. Criação de Pedido de Aluguel
- **Como cliente**, quero criar um pedido de aluguel de automóvel, para solicitar o aluguel de um veículo específico.
  - **Critérios de Aceitação**:
    - O cliente deve poder selecionar um automóvel disponível.
    - O cliente deve preencher informações adicionais, como data de início e término do aluguel.
    - O pedido deve ser enviado para avaliação por um agente.

### 4. Edição de Pedido de Aluguel
- **Como cliente**, quero editar um pedido de aluguel, para modificar detalhes como a data de início ou o automóvel escolhido, caso ainda não tenha sido avaliado pelo agente.
  - **Critérios de Aceitação**:
    - O cliente deve poder modificar pedidos que ainda estão pendentes de avaliação.

### 5. Consulta de Status do Pedido
- **Como cliente**, quero consultar o status do meu pedido de aluguel, para acompanhar se foi aprovado ou rejeitado.
  - **Critérios de Aceitação**:
    - O sistema deve exibir o status do pedido (Aguardando avaliação, Aprovado, Rejeitado).

### 6. Cancelamento de Pedido de Aluguel
- **Como cliente**, quero cancelar um pedido de aluguel, caso eu mude de ideia ou não precise mais do automóvel.
  - **Critérios de Aceitação**:
    - O cliente deve poder cancelar pedidos que ainda não foram aprovados ou executados.

### 7. Consulta de Contrato de Aluguel
- **Como cliente**, quero visualizar os detalhes do contrato de aluguel, para verificar informações como datas e valor total.
  - **Critérios de Aceitação**:
    - O cliente deve poder consultar os contratos relacionados aos seus pedidos aprovados.

## Agente

### 1. Avaliação de Pedido de Aluguel
- **Como agente**, quero avaliar os pedidos de aluguel, para decidir se aprovo ou rejeito com base nas informações financeiras do cliente.
  - **Critérios de Aceitação**:
    - O agente deve ter acesso aos detalhes do pedido e às informações financeiras do cliente.
    - O agente deve poder aprovar ou rejeitar o pedido.

### 2. Modificação de Pedido de Aluguel
- **Como agente**, quero poder modificar os detalhes de um pedido de aluguel, caso necessário, antes de aprová-lo ou rejeitá-lo.
  - **Critérios de Aceitação**:
    - O agente pode ajustar informações como datas ou valores do pedido antes de decidir.

### 3. Registro de Contrato de Crédito
- **Como agente (banco)**, quero registrar um contrato de crédito para um pedido de aluguel, para permitir que o cliente financie o aluguel do automóvel.
  - **Critérios de Aceitação**:
    - O agente pode registrar as condições do crédito, como valor e número de parcelas.

### 4. Consulta de Contratos de Aluguel
- **Como agente**, quero consultar os contratos de aluguel associados aos pedidos aprovados, para acompanhar o status dos contratos.
  - **Critérios de Aceitação**:
    - O agente pode visualizar a lista de contratos e seus detalhes (datas, valores, status).

## Sistema Web

### 1. Autenticação de Usuário
- **Como usuário**, quero poder fazer login no sistema, para acessar minha conta de cliente ou agente.
  - **Critérios de Aceitação**:
    - O sistema deve permitir que o usuário entre com seu login e senha.
    - Deve haver verificação de credenciais para garantir segurança.

### 2. Logout de Usuário
- **Como usuário**, quero poder fazer logout do sistema, para garantir a segurança da minha conta.
  - **Critérios de Aceitação**:
    - O sistema deve fornecer a opção de logout em qualquer momento da navegação.