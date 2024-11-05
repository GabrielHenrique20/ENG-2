public class Questao01letraA { // Declaração da classe pública chamada Questao01letraA

    // Método estático chamado func que não retorna nada (void)
    public static void func() {
        // Loop for que inicializa a variável 'i' com 0, verifica se 'i' é menor ou
        // igual a 100,
        // e incrementa 'i' em 1 após cada iteração
        for (int i = 0; i <= 100; i++) {
            // Imprime o valor atual de 'i' seguido de um espaço, na mesma linha
            System.out.print(i + " ");
        }
    }

    // Método principal da classe que é o ponto de entrada do programa
    public static void main(String[] args) {
        // Chama o método func para executar o loop e imprimir os números de 0 a 100
        func();
    }
}
