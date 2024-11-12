import java.util.HashSet;
import java.util.Set;

// Classe Pedido original
class Pedido {
    private Set<String> dentroDaCaixa = new HashSet<String>();
    private Set<String> foraDaCaixa = new HashSet<String>();

    public void adicionarDentroDaCaixa(String item) {
        dentroDaCaixa.add(item);
    }

    public void adicionarForaDaCaixa(String item) {
        foraDaCaixa.add(item);
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Seu pedido:\n");
        buffer.append("Dentro da caixa:\n");
        for (String item : dentroDaCaixa)
            buffer.append("\t" + item + "\n");
        buffer.append("Fora da caixa:\n");
        for (String item : foraDaCaixa)
            buffer.append("\t" + item + "\n");
        buffer.append("\nTenha um bom dia!\n\n");
        return buffer.toString();
    }
}

// 1. Builder para criar o objeto Pedido
class PedidoBuilder {
    private Pedido pedido;

    public PedidoBuilder() {
        pedido = new Pedido();
    }

    public PedidoBuilder adicionarDentroDaCaixa(String item) {
        pedido.adicionarDentroDaCaixa(item);
        return this;
    }

    public PedidoBuilder adicionarForaDaCaixa(String item) {
        pedido.adicionarForaDaCaixa(item);
        return this;
    }

    public Pedido build() {
        return pedido;
    }
}

// 2. Adapter para permitir que Pedido funcione com a interface NovoPedido
interface NovoPedido {
    void adicionarItemNaCaixa(String item);

    void adicionarItemForaDaCaixa(String item);

    String obterPedido();
}

class PedidoAdapter implements NovoPedido {
    private Pedido pedido;

    public PedidoAdapter() {
        this.pedido = new Pedido();
    }

    @Override
    public void adicionarItemNaCaixa(String item) {
        pedido.adicionarDentroDaCaixa(item);
    }

    @Override
    public void adicionarItemForaDaCaixa(String item) {
        pedido.adicionarForaDaCaixa(item);
    }

    @Override
    public String obterPedido() {
        return pedido.toString();
    }
}

// 3. Command para encapsular as operações de adicionar itens ao Pedido
interface Command {
    void execute();
}

class AdicionarDentroDaCaixaCommand implements Command {
    private Pedido pedido;
    private String item;

    public AdicionarDentroDaCaixaCommand(Pedido pedido, String item) {
        this.pedido = pedido;
        this.item = item;
    }

    @Override
    public void execute() {
        pedido.adicionarDentroDaCaixa(item);
    }
}

class AdicionarForaDaCaixaCommand implements Command {
    private Pedido pedido;
    private String item;

    public AdicionarForaDaCaixaCommand(Pedido pedido, String item) {
        this.pedido = pedido;
        this.item = item;
    }

    @Override
    public void execute() {
        pedido.adicionarForaDaCaixa(item);
    }
}

class PedidoInvoker {
    public void executarComando(Command command) {
        command.execute();
    }
}

// Classe principal para testar o código unificado
public class DesignPatterContinuacao {
    public static void main(String[] args) {
        // Usando o Builder para criar um Pedido
        Pedido pedido1 = new PedidoBuilder()
                .adicionarDentroDaCaixa("Sapato")
                .adicionarForaDaCaixa("Camisa do Galo")
                .build();

        System.out.println("Pedido usando Builder:");
        System.out.println(pedido1);

        // Usando o Adapter para criar um Pedido com interface diferente
        NovoPedido novoPedido = new PedidoAdapter();
        novoPedido.adicionarItemNaCaixa("Xbox Series X");
        novoPedido.adicionarItemForaDaCaixa("Playstation 5");

        System.out.println("Pedido usando Adapter:");
        System.out.println(novoPedido.obterPedido());

        // Usando Command para adicionar itens ao Pedido
        Pedido pedido2 = new Pedido();
        PedidoInvoker invoker = new PedidoInvoker();

        Command addDentroCommand = new AdicionarDentroDaCaixaCommand(pedido2, "LEGO Avengers");
        Command addForaCommand = new AdicionarForaDaCaixaCommand(pedido2, "PLAYMOBIL garçom");

        invoker.executarComando(addDentroCommand);
        invoker.executarComando(addForaCommand);

        System.out.println("Pedido usando Command:");
        System.out.println(pedido2);
    }
}
