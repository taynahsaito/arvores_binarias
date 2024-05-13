public class No{
    private int info;
    private No esquerda;
    private No direita;
    private int quantidade;
    
    public No(int info) {
        this.info = info;
        this.quantidade = 1; 
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    @Override
    public String toString() {
        return "[info =  " + info + ", quantidade = " + quantidade + "]";
    }
    
    //quando o elemento aparece mais uma vez, incrementamos a quantidade 
    public void incrementaQuantidade(){
        quantidade++;
    }

    //quando removemos a repeticao de um elemento, decrementamos a quantidade existente dele.
    public void decrementaQuantidade(){
        quantidade--;
    }

    public int getQuantidade() {
        return quantidade;
    }

    
}