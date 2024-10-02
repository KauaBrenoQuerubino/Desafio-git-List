import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Items> carrinho;

    public CarrinhoDeCompras() {
        this.carrinho = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        Items items = new Items(nome, preco, quantidade);
        carrinho.add(items);

    }

    public void removerItem(String nome) {
        List<Items> itemsPraRemover = new ArrayList<>();

        if (!carrinho.isEmpty()){
            for (Items i : carrinho){
                if (i.getNome().equalsIgnoreCase(nome)){
                    itemsPraRemover.add(i);

                }
            }
        }else {
            System.out.println("A lista esta vazia");
        }


        carrinho.removeAll(itemsPraRemover);
    }
    public double calcularValorTotal(){
        double ValorTotal = 0d;
        if(!carrinho.isEmpty()){
            for (Items i : carrinho){
                double Valoritem = i.getPreco() * i.getQuantidade();
                ValorTotal += Valoritem;
            }
        }else {
            System.out.println("A lista esta vazia");
            return 0d;
        }

        return ValorTotal;

    }

    public void exibirItens(){
        System.out.println(carrinho.toString());
    }

    public static void main(String[] args) {
        CarrinhoDeCompras cdc = new CarrinhoDeCompras();

        cdc.adicionarItem("Teste" , 2.90, 1);
        cdc.adicionarItem("Test2" , 3.90, 1);
        cdc.calcularValorTotal();
        cdc.exibirItens();
        cdc.removerItem("Teste");
    }


}
