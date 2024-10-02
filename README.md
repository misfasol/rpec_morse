# <center>Projeto Árvore Morse</center>

## Descrição do Projeto
Este projeto consiste em uma aplicação Java que implementa uma árvore binária para codificar e decodificar mensagens em código Morse. A árvore é preenchida com os códigos Morse padrão (letras de A a Z, números de 0 a 9), e permite que o usuário adicione novos códigos, busque códigos já existentes, e visualize a árvore construída.

### Funcionalidades

1. **Inserir Código Morse**: Permite ao usuário adicionar um novo código Morse para um caractere específico.
2. **Buscar Código Morse**: O usuário pode inserir um código Morse e receber o caractere correspondente, decodificando a mensagem.
3. **Exibir Todos os Códigos**: Lista todos os códigos Morse armazenados na árvore junto com seus respectivos caracteres.
4. **Exibir Estrutura da Árvore**: Imprime a estrutura da árvore Morse, exibindo os nós e a posição de cada caractere.
5. **Menu Interativo**: A interface é baseada em um menu simples que permite a interação do usuário com o sistema.

### Estrutura de Classes

- **`Morse`**: Classe principal que contém o menu de interação e utiliza a classe `Arvore` para gerenciar a árvore de códigos Morse.
- **`Arvore`**: Responsável por armazenar os códigos Morse em uma estrutura de árvore binária.
  - **`inserir`**: Insere um código Morse e seu respectivo caractere na árvore.
  - **`buscar`**: Decodifica uma sequência Morse em caracteres.
  - **`imprimirArvore`**: Imprime visualmente a árvore Morse.
  - **`percorrerMorse`**: Exibe todos os códigos Morse armazenados com seus caracteres.
- **`Node`**: Representa cada nó da árvore Morse, contendo um caractere e referências para os nós esquerdo e direito.
- **`NodeComPosicao`**: Classe auxiliar para armazenar a posição dos nós na árvore durante a impressão.
- **`Lista` e `NodeLista`**: Implementam uma lista encadeada para auxiliar na impressão da árvore com as posições dos nós.
- **`Fila` e `NodeFila`**: Implementam uma fila para percorrer a árvore de forma ordenada durante o processo de impressão e busca.
- **`Par`**: Classe que associa um nó da árvore com o código Morse correspondente.

### Interação no Menu

- **Opção 1 - Adicionar Código Morse**: O sistema solicitará o código Morse (composto por pontos e traços) e o caractere associado. Após a inserção, o novo código será adicionado à árvore.
  
- **Opção 2 - Buscar Código Morse**: Digite o código Morse que deseja decodificar, e o sistema retornará o caractere correspondente.

- **Opção 3 - Exibir Todos os Códigos Morse**: Lista todos os códigos Morse já armazenados, incluindo os padrões e os adicionados pelo usuário.

- **Opção 4 - Exibir a Árvore Morse**: Mostra a estrutura da árvore Morse de forma visual, indicando a posição dos nós.

- **Opção 0 - Sair**: Encerra a aplicação.

### Exemplo de Uso

```text
Menu:
1 - Adicionar código Morse
2 - Buscar código Morse
3 - Exibir todos os códigos Morse
4 - Exibir a árvore Morse
0 - Sair
Escolha uma opção: 2
Digite o código Morse para buscar: -- .-.
Resultado: MR
```

Neste exemplo, o usuário escolhe a opção 2 para buscar o código Morse correspondente a `--` e `.-.`.

### Considerações Finais

Este projeto é uma implementação simples de uma árvore binária para lidar com código Morse. O sistema pode ser estendido para incluir suporte a outros símbolos ou melhorar a visualização da árvore.
