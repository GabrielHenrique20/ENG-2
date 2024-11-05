import java.util.ArrayList;
import java.util.List;

// Interface para a Estratégia de Controle de Temperatura
interface EstrategiaControleTemperatura {
    // Método que define o comportamento baseado na temperatura
    void aplicarComportamento(double temperatura);
}

// Classe concreta para controlar o ar-condicionado baseado na temperatura
class ArCondicionadoLigado implements EstrategiaControleTemperatura {
    @Override
    public void aplicarComportamento(double temperatura) {
        if (temperatura > 29) {
            System.out.println("- Ar condicionado ligado.");
        } else if (temperatura < 15) {
            System.out.println("- Ar condicionado desligado.");
        }
    }
}

// Classe concreta para controlar o aquecedor baseado na temperatura
class AquecedorLigado implements EstrategiaControleTemperatura {
    @Override
    public void aplicarComportamento(double temperatura) {
        if (temperatura < 15) {
            System.out.println("- Aquecedor ligado.");
        } else if (temperatura > 23) {
            System.out.println("- Aquecedor desligado.");
        }
    }
}

// Interface do Observer, que será implementada pelos dispositivos que monitoram
// a temperatura
interface Observer {
    // Método chamado para atualizar o observador com a nova temperatura
    void atualizar(double temperatura);
}

// Classe responsável por monitorar e notificar os observadores sobre mudanças
// de temperatura
class SensorDeTemperatura {
    private List<Observer> observers = new ArrayList<>();
    private double temperatura;

    // Método para registrar um novo observador
    public void registrarObserver(Observer observer) {
        observers.add(observer);
    }

    // Método para remover um observador
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    // Método para notificar todos os observadores sobre a mudança de temperatura
    public void notificarObservers() {
        for (Observer observer : observers) {
            observer.atualizar(temperatura);
        }
    }

    // Método para atualizar a temperatura e notificar os observadores
    public void setTemperatura(double temperatura) {
        System.out.println("\nTemperatura atualizada para: " + temperatura + "\n");
        this.temperatura = temperatura;
        notificarObservers();
    }
}

// Classe ArCondicionado que implementa Observer e usa uma estratégia para
// controle de temperatura
class ArCondicionado implements Observer {
    private EstrategiaControleTemperatura estrategia;

    // Construtor recebe uma estratégia específica de controle de temperatura
    public ArCondicionado(EstrategiaControleTemperatura estrategia) {
        this.estrategia = estrategia;
    }

    // Método chamado quando a temperatura é atualizada
    @Override
    public void atualizar(double temperatura) {
        estrategia.aplicarComportamento(temperatura);
    }
}

// Classe Aquecedor que implementa Observer e usa uma estratégia para controle
// de temperatura
class Aquecedor implements Observer {
    private EstrategiaControleTemperatura estrategia;

    // Construtor recebe uma estratégia específica de controle de temperatura
    public Aquecedor(EstrategiaControleTemperatura estrategia) {
        this.estrategia = estrategia;
    }

    // Método chamado quando a temperatura é atualizada
    @Override
    public void atualizar(double temperatura) {
        estrategia.aplicarComportamento(temperatura);
    }
}

// Classe principal para testar o comportamento do sistema
public class RespostaCompleta {
    public static void main(String[] args) {
        // Criação do sensor de temperatura
        SensorDeTemperatura sensor = new SensorDeTemperatura();

        // Definição das estratégias de controle
        EstrategiaControleTemperatura estrategiaAr = new ArCondicionadoLigado();
        EstrategiaControleTemperatura estrategiaAquecedor = new AquecedorLigado();

        // Criação dos dispositivos com suas estratégias
        ArCondicionado arCondicionado = new ArCondicionado(estrategiaAr);
        Aquecedor aquecedor = new Aquecedor(estrategiaAquecedor);

        // Registro dos dispositivos no sensor de temperatura
        sensor.registrarObserver(arCondicionado);
        sensor.registrarObserver(aquecedor);

        // Simulação de mudanças de temperatura
        sensor.setTemperatura(30); // Deve ligar o ar-condicionado
        sensor.setTemperatura(10); // Deve ligar o aquecedor
        sensor.setTemperatura(24); // Deve desligar o aquecedor
        sensor.setTemperatura(16); // Nenhuma ação
    }
}
