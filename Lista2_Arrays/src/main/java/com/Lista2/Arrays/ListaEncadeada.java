package com.Lista2.Arrays;

public class ListaEncadeada {
    private int[] elemento;
    private int tamanho;
    private int capacidade;

    // Método para criar uma lista vazia com uma capacidade específica
    public ListaEncadeada(int capacidade) {
        this.elemento = new int[capacidade];
        this.tamanho = 0;
        this.capacidade = capacidade;
    }

    // Método para inserir um elemento no início da lista
    public void inserirInicio(int elemento) {
        if (tamanho < capacidade) {
            // Desloca os elemento para a direita para abrir espaço para o novo elemento no início
            for (int i = tamanho - 1; i >= 0; i--) {
                this.elemento[i + 1] = this.elemento[i];
            }
            this.elemento[0] = elemento;
            tamanho++;
        } else {
            System.out.println("A lista está cheia. Não é possível inserir mais elemento.");
        }
    }

    // Método para inserir um elemento no fim da lista
    public void inserirFim(int elemento) {
        if (tamanho < capacidade) {
            this.elemento[tamanho] = elemento;
            tamanho++;
        } else {
            System.out.println("A lista está cheia. Não é possível inserir mais elemento.");
        }
    }

    // Método para inserir um elemento em uma posição específica da lista
    public void inserirPosicao(int posicao, int elemento) {
        if (posicao >= 0 && posicao <= tamanho && tamanho < capacidade) {
            // Desloca os elemento para a direita para abrir espaço para o novo elemento na posição especificada
            for (int i = tamanho - 1; i >= posicao; i--) {
                this.elemento[i + 1] = this.elemento[i];
            }
            this.elemento[posicao] = elemento;
            tamanho++;
        } else {
            System.out.println("Posição inválida ou lista cheia.");
        }
    }

    // Método para remover um elemento no início da lista
    public void removerInicio() {
        if (tamanho > 0) {
            // Desloca os elemento para a esquerda para preencher o espaço deixado pelo elemento removido
            for (int i = 0; i < tamanho - 1; i++) {
                elemento[i] = elemento[i + 1];
            }
            tamanho--;
        } else {
            System.out.println("A lista está vazia. Não é possível remover elemento.");
        }
    }

    // Método para remover um elemento no fim da lista
    public void removerFim() {
        if (tamanho > 0) {
            tamanho--;
        } else {
            System.out.println("A lista está vazia. Não é possível remover elemento.");
        }
    }

    // Método para remover um elemento em uma posição específica da lista
    public void removerPosicao(int posicao) {
        if (posicao >= 0 && posicao < tamanho) {
            // Desloca os elemento para a esquerda para preencher o espaço deixado pelo elemento removido
            for (int i = posicao; i < tamanho - 1; i++) {
                elemento[i] = elemento[i + 1];
            }
            tamanho--;
        } else {
            System.out.println("Posição inválida.");
        }
    }

    // Método para remover um elemento específico da lista
    public void removerElemento(int elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (this.elemento[i] == elemento) {
                removerPosicao(i);
                return;
            }
        }
        System.out.println("Elemento não encontrado na lista.");
    }

    // Método para exibir o conteúdo da lista
    public void exibir() {
        System.out.print("[");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elemento[i]);
            if (i < tamanho - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Método para pesquisar por um elemento específico e informar sua posição
    public void pesquisar(int elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (this.elemento[i] == elemento) {
                System.out.println("O elemento " + elemento + " está na posição " + i + " da lista.");
                return;
            }
        }
        System.out.println("O elemento " + elemento + " não está na lista.");
    }

    // Método para retornar o número de elemento existentes na lista
    public int tamanho() {
        return tamanho;
    }

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada(5);
        lista.inserirInicio(10);
        lista.inserirFim(99);
        lista.inserirPosicao(1, 48);
        lista.exibir();

        lista.removerInicio();
        lista.removerFim();
        lista.removerPosicao(0);
        lista.exibir();

        lista.inserirInicio(5);
        lista.inserirFim(85);
        lista.inserirPosicao(2, 3);
        lista.exibir();

        lista.removerElemento(30);
        lista.exibir();

        lista.pesquisar(15);
        lista.pesquisar(30);

        System.out.println("Número de elemento na lista: " + lista.tamanho());
    }
}
