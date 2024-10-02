import java.util.Scanner;

class Morse {
    
    private static void PreencherArvoreMorse(Arvore arvore) { // Método para preencher a árvore Morse com os códigos padrão
        arvore.inserir(".-", 'A');
        arvore.inserir("-...", 'B');
        arvore.inserir("-.-.", 'C');
        arvore.inserir("-..", 'D');
        arvore.inserir(".", 'E');
        arvore.inserir("..-.", 'F');
        arvore.inserir("--.", 'G');
        arvore.inserir("....", 'H');
        arvore.inserir("..", 'I');
        arvore.inserir(".---", 'J');
        arvore.inserir("-.-", 'K');
        arvore.inserir(".-..", 'L');
        arvore.inserir("--", 'M');
        arvore.inserir("-.", 'N');
        arvore.inserir("---", 'O');
        arvore.inserir(".--.", 'P');
        arvore.inserir("--.-", 'Q');
        arvore.inserir(".-.", 'R');
        arvore.inserir("...", 'S');
        arvore.inserir("-", 'T');
        arvore.inserir("..-", 'U');
        arvore.inserir("...-", 'V');
        arvore.inserir(".--", 'W');
        arvore.inserir("-..-", 'X');
        arvore.inserir("-.--", 'Y');
        arvore.inserir("--..", 'Z');
        arvore.inserir(".----", '1');
        arvore.inserir("..---", '2');
        arvore.inserir("...--", '3');
        arvore.inserir("....-", '4');
        arvore.inserir(".....", '5');
        arvore.inserir("-....", '6');
        arvore.inserir("--...", '7');
        arvore.inserir("---..", '8');
        arvore.inserir("----.", '9');
        arvore.inserir("-----", '0');
    }

    public static void main(String[] args) {
        Arvore arv = new Arvore(); // Cria uma nova árvore Morse
        PreencherArvoreMorse(arv); // Preenche a árvore com os códigos padrão

        Scanner scanner = new Scanner(System.in); // Utiliza Scanner para capturar entradas do usuário
        int opcao = 0;

        do { // Loop do menu
            // Exibe as opções do menu
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar código Morse");
            System.out.println("2 - Buscar código Morse");
            System.out.println("3 - Exibir todos os códigos Morse");
            System.out.println("4 - Exibir a árvore Morse");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt(); // Lê a opção escolhida
                scanner.nextLine(); // Consome a quebra de linha
            } else {
                System.out.println("Opção inválida!");
                scanner.nextLine(); // Limpa o buffer
                continue; // Retorna ao início do loop
            }

            switch (opcao) {
                case 1:
                    // Adiciona um novo código Morse à árvore
                    System.out.print("Digite o código Morse (pontos e traços): ");
                    String codigo = scanner.nextLine().trim(); // Lê o código Morse
                    System.out.print("Digite o caractere correspondente: ");
                    String caractereStr = scanner.nextLine().trim(); // Lê o caractere
                    if (caractereStr.length() != 1) {
                        // Verifica se o caractere é válido
                        System.out.println("Caractere inválido!");
                        break;
                    }
                    char caractere = caractereStr.charAt(0); // Obtém o caractere
                    arv.inserir(codigo, caractere); // Insere na árvore
                    System.out.println("Código adicionado com sucesso!");
                    break;
                case 2:
                    // Busca um código Morse na árvore
                    System.out.print("Digite o código Morse para buscar (separe múltiplos códigos com espaço): ");
                    String codigoBusca = scanner.nextLine().trim(); // Lê o código Morse para busca
                    String resultado = arv.buscar(codigoBusca); // Realiza a busca na árvore
                    if (resultado.isEmpty()) {
                        System.out.println("Código não encontrado ou inválido!");
                    } else {
                        System.out.println("Resultado: " + resultado);
                    }
                    break;
                case 3:
                    // Exibe todos os códigos Morse armazenados
                    System.out.println("Todos os códigos Morse:");
                    arv.percorrerMorse(); // Percorre a árvore e imprime os códigos
                    break;
                case 4:
                    // Exibe a estrutura da árvore Morse
                    System.out.println("Árvore Morse:");
                    arv.imprimirArvore(); // Imprime a árvore de forma visual
                    break;
                case 0:
                    // Encerra o programa
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    // Caso o usuário insira uma opção inválida
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0); // Continua até que o usuário escolha sair

        scanner.close(); // Fecha o Scanner no final
    }
}

class Arvore {
    Node raiz; // Nó raiz da árvore Morse

    public Arvore() {
        raiz = new Node(); // Inicializa a raiz com um novo nó vazio
    }

    // Método para inserir um caractere na árvore Morse
    public void inserir(String morse, char caractere) {
        Node atual = raiz; // Começa pela raiz
        for (int i = 0; i < morse.length(); i++) {
            char token = morse.charAt(i); // Lê cada símbolo do código Morse
            if (token == '.') {
                // Se for ponto, vai para a esquerda
                if (atual.esq == null) {
                    atual.esq = new Node(); // Cria um novo nó se necessário
                }
                atual = atual.esq; // Avança para o nó esquerdo
            } else if (token == '-') {
                // Se for traço, vai para a direita
                if (atual.dir == null) {
                    atual.dir = new Node(); // Cria um novo nó se necessário
                }
                atual = atual.dir; // Avança para o nó direito
            } else {
                // Se o símbolo não for ponto nem traço, é inválido
                System.out.println("Caractere inválido no código Morse: " + token);
                return; // Sai do método
            }
        }
        atual.caractere = caractere; // Atribui o caractere ao nó final
    }

    // Método para decodificar uma sequência Morse e retornar os caracteres
    public String buscar(String morse) {
        Node atual = raiz; // Começa pela raiz
        String saida = ""; // Armazena a saída
        int length = morse.length();
        for (int i = 0; i < length; i++) {
            char token = morse.charAt(i); // Lê cada símbolo
            if (token == '.') {
                // Se for ponto, vai para a esquerda
                if (atual.esq != null) {
                    atual = atual.esq; // Avança para o nó esquerdo
                } else {
                    return "";
                }

            } else if (token == '-') {
                // Se for traço, vai para a direita
                if (atual.dir != null) {
                    atual = atual.dir; // Avança para o nó direito
                } else {
                    return "";
                }

            } else if (token == ' ') { // Se for espaço, significa fim de um caractere
                saida += atual.caractere; // Adiciona o caractere à saída
                atual = raiz; // Reinicia na raiz para o próximo caractere

            } else {
                System.out.println("Caractere inválido no código Morse: " + token);
                return ""; // Retorna vazio
            }
        }
        saida += atual.caractere; // Adiciona o último caractere à saída
        return saida; // Retorna a string decodificada
    }

    // Método para imprimir a árvore
    public void imprimirArvore() {
        int altura = getAltura(raiz); // Calcula a altura da árvore
        int largura = potencia(2, altura + 1); // Calcula a largura necessária para a impressão
        Lista lista = new Lista(); // Cria uma lista para armazenar os nós com suas posições
        preencherPosicoes(raiz, 0, largura / 2, largura / 4, lista); // Preenche as posições dos nós na lista

        imprimirArvoreNaTela(lista, altura, largura); // Imprime a árvore na tela
    }

    // Método recursivo para preencher as posições dos nós na lista
    private void preencherPosicoes(Node node, int nivel, int posicaoX, int espaco, Lista lista) {
        if (node == null) {
            return; // Caso base da recursão
        }

        NodeComPosicao ncp = new NodeComPosicao(node, nivel, posicaoX); // Cria um novo nó com a posição
        lista.adicionar(ncp); // Adiciona o nó à lista

        // Chamada recursiva para os filhos esquerdo e direito
        preencherPosicoes(node.esq, nivel + 1, posicaoX - espaco, espaco / 2, lista); // Filho esquerdo
        preencherPosicoes(node.dir, nivel + 1, posicaoX + espaco, espaco / 2, lista); // Filho direito
    }

    // O print da arvore funciona pegando a altura e largura total da arvore, 
    // adicionado um espaço para cada nível e imprimindo os caracteres na posição correta.
    // e calculando a posição de cada nó com base na largura da árvore, assim,
    // preenchendo com mais espaços vazios os níveis que tem menos nós.

    // Método para imprimir a árvore na tela
    private void imprimirArvoreNaTela(Lista lista, int altura, int largura) {
        int nivelAtual = 0;

        while (nivelAtual <= altura) {
            char[] linha = new char[largura]; // Cria um array de caracteres para representar a linha
            for (int i = 0; i < largura; i++) {
                linha[i] = ' '; // Inicializa com espaços em branco
            }

            NodeLista atual = lista.getInicio(); // Obtém o início da lista
            while (atual != null) {
                NodeComPosicao ncp = atual.item; // Obtém o nó com posição
                if (ncp.nivel == nivelAtual) {
                    char caractere = ncp.node.caractere != '\0' ? ncp.node.caractere : '/'; // Usa '/' se não houver caractere
                    if (ncp.posicaoX >= 0 && ncp.posicaoX < largura) {
                        linha[ncp.posicaoX] = caractere; // Coloca o caractere na posição correta
                    }
                }
                atual = atual.proximo; // Avança para o próximo nó
            }

            System.out.println(new String(linha));
            nivelAtual++; // Avança para o próximo nível
        }
    }

    // Método para obter a altura da árvore
    private int getAltura(Node node) {
        if (node == null) {
            return -1; // Altura de uma árvore vazia é -1
        }
        int alturaEsq = getAltura(node.esq); // Altura da subárvore esquerda
        int alturaDir = getAltura(node.dir); // Altura da subárvore direita
        return maior(alturaEsq, alturaDir) + 1; // Retorna a maior altura + 1
    }

    // Método para calcular potência
    private int potencia(int base, int expoente) {
        int resultado = 1;
        for (int i = 0; i < expoente; i++) {
            resultado *= base; // Multiplica a base por si mesma
        }
        return resultado;
    }

    // Método para retornar o maior entre dois números
    private int maior (int base, int expoente) {
        return base > expoente ? base : expoente;
    }

    // Método para percorrer a árvore e imprimir as sequências Morse e seus caracteres
    public void percorrerMorse() {
        Fila fila = new Fila(); // Cria uma nova fila
        fila.adicionar(new Par(raiz, "")); // Enfileira a raiz com código vazio

        while (!fila.vazia()) {
            Par atual = (Par) fila.remover(); // Desenfileira o próximo elemento
            Node node = atual.node; // Obtém o nó atual
            String codigo = atual.codigo; // Obtém o código Morse até o nó atual

            if (node.caractere != '\0') {
                System.out.println(codigo + " -> " + node.caractere); // Imprime o código e o caractere
            }

            if (node.esq != null) {
                fila.adicionar(new Par(node.esq, codigo + ".")); // Enfileira o filho esquerdo
            }

            if (node.dir != null) {
                fila.adicionar(new Par(node.dir, codigo + "-")); // Enfileira o filho direito
            }
        }
    }
}

// Classe que guarda um nó da árvore com sua posição
class NodeComPosicao {
    Node node; // O nó da árvore
    int nivel; // O nível em que o nó está
    int posicaoX; // A posição horizontal para impressão

    public NodeComPosicao(Node node, int nivel, int posicaoX) {
        this.node = node;
        this.nivel = nivel;
        this.posicaoX = posicaoX;
    }
}

// Classe que representa um nó da árvore Morse
class Node {
    char caractere; // Caractere armazenado no nó
    Node esq, dir; // Filhos esquerdo e direito

    public Node() {
        this.caractere = '\0'; // Inicializa sem caractere
        this.esq = null;
        this.dir = null;
    }
}

// Nó de uma lista encadeada de nós da árvore com suas posições
class NodeLista {
    NodeComPosicao item; // O item (nó com posição)
    NodeLista proximo; // Referência para o próximo nó

    public NodeLista(NodeComPosicao item) {
        this.item = item;
        this.proximo = null;
    }
}

// Nó de uma fila
class NodeFila {
    Object item; // Item armazenado
    NodeFila proximo; // Próximo nó na fila

    public NodeFila(Object item) { 
        this.item = item;
        this.proximo = null;
    }
}

// Classe que representa um par de nó e código Morse
class Par {
    Node node; // O nó da árvore
    String codigo; // O código Morse até este nó

    public Par(Node node, String codigo) {
        this.node = node;
        this.codigo = codigo;
    }
}

// Lista encadeada de nós da árvore com suas posições
class Lista {
    private NodeLista inicio; // Início da lista
    private NodeLista fim; // Fim da lista
    private int tamanho; // Tamanho da lista

    public Lista() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    // Método para adicionar um item à lista
    public void adicionar(NodeComPosicao item) {
        NodeLista novoNode = new NodeLista(item); 
        if (inicio == null) {
            inicio = fim = novoNode;
        } else {
            fim.proximo = novoNode;
            fim = novoNode;
        }
        tamanho++;
    }

    // Retorna o início da lista
    public NodeLista getInicio() {
        return inicio;
    }

    // Retorna o tamanho da lista
    public int tamanho() {
        return tamanho;
    }
}

// Implementação de uma fila simples (FIFO)
class Fila {
    private NodeFila inicio, fim;

    public Fila() {
        inicio = fim = null;
    }

    public void adicionar(Object item) { // Método para adicionar um item na fila
        NodeFila novoNode = new NodeFila(item); 
        if (vazia()) {
            inicio = fim = novoNode;
        } else {
            fim.proximo = novoNode;
            fim = novoNode;
        }
    }

    public Object remover() { // Método para remover o primeiro item da fila
        if (vazia()) {
            return null;
        }
        Object item = inicio.item;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null; // Se a fila ficou vazia, ajusta o fim
        }
        return item; // Retorna o item removido
    }

    
    public boolean vazia() { // Método para verificar se a fila está vazia
        return inicio == null;
    }
}
