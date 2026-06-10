public abstract class ValidadorPedido {
    protected ValidadorPedido proximo;

    public ValidadorPedido setProximo(ValidadorPedido proximo) {
        this.proximo = proximo;
        return this;
    }

    public abstract boolean validar(Pedido pedido);
}