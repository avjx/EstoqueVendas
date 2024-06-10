## Visão Geral do Sistema
O sistema de Estoque e Vendas foi desenvolvido em Java utilizando a biblioteca Java Swing para a interface gráfica. 
A arquitetura do sistema segue o padrão MVC (Model-View-Controller) e utiliza a biblioteca Gson para a manipulação de arquivos JSON.
O programa permite gerenciar produtos, estoques, clientes e empresas, além de registrar vendas e calcular trocos.

### Funcionalidades do Sistema
1. **Cadastro de Empresas, Clientes e Produtos**
    - **Cadastro de Empresas:** Permite adicionar novas empresas ao sistema, armazenando informações como nome, CNPJ, endereço, telefone e email.
    - **Cadastro de Clientes:** Permite adicionar novos clientes ao sistema com informações pessoais detalhadas, como nome, CPF, data de nascimento, contato e endereço.
    - **Cadastro de Produtos:** Permite adicionar novos produtos ao sistema, armazenando a descrição do produto, o código, valor, data de cadastro, quantidade inicial. Também adiciona o produto ao estoque.

2. **Gerenciamento de Estoque**
   - **Listar Estoque:** Exibe a lista de todos os produtos disponíveis no estoque com suas quantidades e informações relevantes.

3. **Registro de Vendas**
   - **Adicionar Produtos à Venda:** Permite adicionar produtos à lista de itens de uma venda em andamento, especificando o código do produto e a quantidade desejada.
   - **Calcular Troco:** Calcula o troco a ser devolvido ao cliente com base no valor pago e no total da venda com desconto aplicado.
   - **Registrar Venda:** Confirma a venda, atualiza o estoque com a quantidade vendida e registra a transação.
   - **Cancelar Venda:** Cancela a venda em andamento, limpando a tela de vendas e não alterando o estoque.

4. **Validação de CPF/CNPJ**
   - **Verificação de CPF/CNPJ:** Valida se o CPF ou CNPJ fornecido durante o processo de venda está registrado no sistema. Caso não esteja, exibe uma mensagem de erro.

5. **Geração de JSON**
   - **Geração de JSON para Vendas:** Após a confirmação da venda, gera um arquivo JSON contendo os dados dos produtos vendidos, incluindo código do produto, descrição, quantidade, preço e total da venda. Também contém os dados do comprador, CPNJ ou CPF e outras informações importantes.
