public class ABB {
    private No raiz; //elemento de controle

    public boolean estaVazia(){
        return raiz == null;
    }
    //o parametro passado não é do tipo 'no' pois para o usuario não importa
    public void insere(int i){
        No novo = new No(i);
        if(estaVazia()){
            raiz = novo;
        }
        else{
            insereRec(novo, raiz);
        }
    }

    void insereRec(No novo, No atual){
        if(novo.getInfo() <= atual.getInfo()){ //se o elemento novo for menor ou igual ao atual...
            if(atual.getEsquerda() == null){ //se a esquerda do atual for nula/estiver disponivel, então insere o no novo lá
                atual.setEsquerda(novo);
            }
            else{//se não estiver vazia
                insereRec(novo, atual.getEsquerda());;
            }
        }
        else{//se o nó novo é maior que o atual...
            if(atual.getDireita() == null){ //se o 'gancho' da direita estiver disponivel, então insira-o lá
                atual.setDireita(novo);
            }
            else{
                insereRec(novo, atual.getDireita());
            }
        }
    }

    // nao é override porque é uma arvore
    public String toStringEmOrdem(){
        if (estaVazia())
            return "arvore vazia";
        else
            return toStringEmOrdemRec(raiz);
    }
    //a inserção dos elementos é feito pela lógica mas depois da varredura da arvore, os elementos são retornados todos ordenados.
    //faz a varredura da estrutura
    String toStringEmOrdemRec (No atual){
        if(atual == null)
            return "";
        return toStringEmOrdemRec(atual.getEsquerda()) + // busca tudo que tenho na esquerda
               atual.getInfo() + " " + //pega a info da raiz
               toStringEmOrdemRec(atual.getDireita()); //busca tudo que tenho na direita
    }
}
