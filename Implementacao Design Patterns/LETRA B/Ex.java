import java.util.ArrayList;
import java.util.List;

// Interface do Observador
// Define o contrato que todos os observadores devem implementar
interface Observer {
    // Método que será chamado pelo sujeito para notificar o observador
    void update(String message);
}

// Classe Concreta do Observador
// Implementa a interface Observer
class ConcreteObserver implements Observer {
    private String observerName;

    // Construtor que recebe o nome do observador
    public ConcreteObserver(String observerName) {
        this.observerName = observerName;
    }

    // Implementação do método update da interface Observer
    @Override
    public void update(String message) {
        // Exibe a mensagem recebida, junto com o nome do observador
        System.out.println(observerName + " recebeu a mensagem: " + message);
    }
}

// Interface do Sujeito (Subject)
// Define o contrato para as classes que desejam ser observadas
interface Subject {
    // Método para registrar um observador
    void registerObserver(Observer observer);

    // Método para remover um observador
    void removeObserver(Observer observer);

    // Método para notificar todos os observadores registrados
    void notifyObservers(String message);
}

// Classe Concreta do Sujeito (Subject)
// Implementa a interface Subject
class ConcreteSubject implements Subject {
    // Lista para armazenar os observadores registrados
    private List<Observer> observers = new ArrayList<>();

    // Adiciona um observador à lista
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    // Remove um observador da lista
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notifica todos os observadores registrados enviando-lhes uma mensagem
    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    // Método que simula uma ação que requer notificação dos observadores
    public void doSomething() {
        // Exibe uma mensagem para indicar que algo aconteceu no sujeito
        System.out.println("Algo aconteceu no Sujeito!");
        // Notifica todos os observadores com uma mensagem
        notifyObservers("Mensagem de notificação do Sujeito");
    }
}

// Classe principal para testar o padrão Observer
public class Ex {
    public static void main(String[] args) {
        // Criando uma instância de ConcreteSubject
        ConcreteSubject subject = new ConcreteSubject();

        // Criando instâncias de ConcreteObserver com nomes únicos
        Observer observer1 = new ConcreteObserver("Observador 1");
        Observer observer2 = new ConcreteObserver("Observador 2");

        // Registrando os observadores no sujeito
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        // Simulando uma mudança no sujeito e notificando os observadores
        subject.doSomething();

        // Removendo um observador da lista
        subject.removeObserver(observer2);

        // Simulando outra mudança no sujeito e notificando o observador restante
        subject.doSomething();
    }
}
