public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE VALIDAÇÃO DE PEDIDOS ===\n");

        // Cria os validadores
        ValidadorEstoque validadorEstoque = new ValidadorEstoque();
        ValidadorPreco validadorPreco = new ValidadorPreco();
        ValidadorPagamento validadorPagamento = new ValidadorPagamento();

        // Monta a cadeia de responsabilidade
        validadorEstoque.setProximo(validadorPreco);
        validadorPreco.setProximo(validadorPagamento);

        System.out.println("--- Teste 1: Pedido válido ---");
        Pedido pedido1 = new Pedido("João Silva", 150.0, 10);
        pedido1.setPagamentoConfirmado(true);
        testarPedido(validadorEstoque, pedido1);

        System.out.println("\n--- Teste 2: Sem estoque ---");
        Pedido pedido2 = new Pedido("Maria Souza", 100.0, 0);
        pedido2.setPagamentoConfirmado(true);
        testarPedido(validadorEstoque, pedido2);

        System.out.println("\n--- Teste 3: Valor inválido (muito baixo) ---");
        Pedido pedido3 = new Pedido("José Santos", 5.0, 5);
        pedido3.setPagamentoConfirmado(true);
        testarPedido(validadorEstoque, pedido3);

        System.out.println("\n--- Teste 4: Pagamento não confirmado ---");
        Pedido pedido4 = new Pedido("Ana Costa", 200.0, 8);
        pedido4.setPagamentoConfirmado(false);
        testarPedido(validadorEstoque, pedido4);

        System.out.println("\n--- Teste 5: Valor inválido (muito alto) ---");
        Pedido pedido5 = new Pedido("Carlos Lima", 600.0, 15);
        pedido5.setPagamentoConfirmado(true);
        testarPedido(validadorEstoque, pedido5);
    }

    private static void testarPedido(ValidadorPedido validador, Pedido pedido) {
        System.out.println("Validando pedido de: " + pedido.getNomeCliente());
        System.out.println("Valor: R$ " + pedido.getValor());

        boolean resultado = validador.validar(pedido);

        if (resultado) {
            System.out.println("🎉 PEDIDO VÁLIDO! Pedido aprovado com sucesso.");
        } else {
            System.out.println("⚠️ PEDIDO INVÁLIDO! Verifique os erros acima.");
        }
    }
}