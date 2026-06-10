public class ValidadorEstoque extends ValidadorPedido {
    @Override
    public boolean validar(Pedido pedido) {
        if (pedido.getQuantidadeEstoque() <= 0) {
            System.out.println("❌ ERRO: Produto sem estoque disponível!");
            return false;
        }
        System.out.println("✅ Estoque OK");

        if (proximo != null) {
            return proximo.validar(pedido);
        }
        return true;
    }
}