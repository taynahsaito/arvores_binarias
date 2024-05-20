import java.util.Random;

public class TesteABB {
    public static void main(String[] args) {
        Random r = new Random();
        ABB abb = new ABB();
        int total = r.nextInt(1500) + 50;
        System.out.println("total = " + total);
        //int total = 10;
        for (int i = 1; i <= total; i++) {
            int num = r.nextInt(total) + 1;
            //System.out.print(num + " ");
            abb.insere(num);
        }
        System.out.println("\n\n" + abb.toStringEmOrdem());
        System.out.println("\nnumero de nos: " + abb.numeroNos());
        System.out.println("altura: " + abb.altura());
        //busca
        int x = r.nextInt(total) + 1;
        if (abb.busca(x)){
            System.out.println(x + " esta na arvore");
        }
        else{
            System.out.println(x + " nao encontrado");
        }
        if(abb.remocao(x))
            System.out.println(x + " removido");
        else
            System.out.println(x + " nao encontrado");

    }
}
