public class Pedido {
    private String nomeCliente;
    private double valor;
    private int quantidadeEstoque;
    private boolean pagamentoConfirmado;

    // Construtor
    public Pedido(String nomeCliente, double valor, int quantidadeEstoque) {
        this.nomeCliente = nomeCliente;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
        this.pagamentoConfirmado = false;
    }

    // Getters e Setters
    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

    public boolean isPagamentoConfirmado() { return pagamentoConfirmado; }
    public void setPagamentoConfirmado(boolean pagamentoConfirmado) { this.pagamentoConfirmado = pagamentoConfirmado; }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente='" + nomeCliente + '\'' +
                ", valor=" + valor +
                ", estoque=" + quantidadeEstoque +
                ", pagamento=" + pagamentoConfirmado +
                '}';
    }
}