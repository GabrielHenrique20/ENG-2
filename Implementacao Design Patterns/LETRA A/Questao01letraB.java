public class Questao01letraB { // Declaração da classe pública chamada Questao01letraB

    // Variável estática que armazena a única instância da classe (padrão Singleton)
    private static Questao01letraB instancia;

    // Construtor privado para evitar a criação de instâncias externas à classe
    // Isso garante que a classe só possa ser instanciada de dentro dela mesma
    private Questao01letraB() {
    }

    // Método estático que retorna a única instância da classe
    // Implementa o padrão Singleton, garantindo que apenas uma instância exista
    public static Questao01letraB getInstancia() {
        // Verifica se a instância já foi criada
        if (instancia == null) {
            // Se não, cria uma nova instância
            instancia = new Questao01letraB();
        }
        // Retorna a instância única
        return instancia;
    }

    // Método de instância que imprime os números de 0 a 100
    public void func() {
        // Loop for para iterar de 0 a 100
        for (int i = 0; i <= 100; i++) {
            // Imprime o valor atual de 'i' seguido por um espaço
            System.out.print(i + " ");
        }
    }

    // Método principal que é o ponto de entrada do programa
    public static void main(String[] args) {
        // Obtém a instância única da classe usando o método getInstancia()
        Questao01letraB questao01 = Questao01letraB.getInstancia();
        // Chama o método func() na instância única para imprimir os números
        questao01.func();
    }
}
