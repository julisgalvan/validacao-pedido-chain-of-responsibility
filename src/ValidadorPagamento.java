public class ValidadorPagamento extends ValidadorPedido {
    @Override
    public boolean validar(Pedido pedido) {
        if (!pedido.isPagamentoConfirmado()) {
            System.out.println("❌ ERRO: Pagamento não confirmado!");
            return false;
        }
        System.out.println("✅ Pagamento confirmado");

        if (proximo != null) {
            return proximo.validar(pedido);
        }
        return true;
    }
}