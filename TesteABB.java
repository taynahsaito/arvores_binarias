import java.util.Random;

public class TesteABB {
    public static void main(String[] args) {
        Random r = new Random();
        ABB abb = new ABB();
        for (int i = 1; i <= 12; i++){
            int num = r.nextInt(100);
            System.out.print(num + " ");
            abb.insere(num);
        }
        System.out.println("\n" + abb.toStringEmOrdem());
    }
}
