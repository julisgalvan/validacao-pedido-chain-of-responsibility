public class ValidadorPreco extends ValidadorPedido {
    private static final double VALOR_MINIMO = 10.0;
    private static final double VALOR_MAXIMO = 500.0;

    @Override
    public boolean validar(Pedido pedido) {
        if (pedido.getValor() < VALOR_MINIMO) {
            System.out.println("❌ ERRO: Valor mínimo do pedido é R$ " + VALOR_MINIMO);
            return false;
        }
        if (pedido.getValor() > VALOR_MAXIMO) {
            System.out.println("❌ ERRO: Valor máximo do pedido é R$ " + VALOR_MAXIMO);
            return false;
        }
        System.out.println("✅ Valor dentro do limite permitido");

        if (proximo != null) {
            return proximo.validar(pedido);
        }
        return true;
    }
}