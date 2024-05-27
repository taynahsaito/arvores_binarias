public class TesteRemocao {
    public static void main(String[] args) {
        ABB abb = new ABB();
        abb.insere(12);
        abb.insere(10);
        abb.insere(16);
        abb.insere(14);
        abb.insere(15);
        abb.insere(18);
        abb.insere(20);
        System.out.println(abb.toStringEmOrdem());

        abb.remocao(16);
        System.out.println(abb.toStringEmOrdem());

        abb.insere(9);
        abb.insere(11);
        System.out.println(abb.toStringEmOrdem());

        abb.remocao(10);
        System.out.println(abb.toStringEmOrdem());

        abb.remocao(12);
        System.out.println(abb.toStringEmOrdem());
        abb.insere(12);
        abb.insere(10);
        abb.insere(16);
        abb.insere(14);
        abb.insere(15);
        abb.insere(18);
        abb.insere(20);
        System.out.println(abb.toStringEmOrdem());
        abb.remocao(18);
        System.out.println(abb.toStringEmOrdem());
    }
}
