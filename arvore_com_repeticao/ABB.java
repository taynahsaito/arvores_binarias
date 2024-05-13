public class ABB {
    private No raiz; //elemento de controle

    public boolean estaVazia(){
        return raiz == null;
    }
    //o parametro passado não é do tipo 'no' pois para o usuario não importa
    public void insere(int i){
        if(estaVazia()){
            raiz = new No(i);
        }
        else{
            insereRec(i, raiz);
        }
    }

    void insereRec(int i, No atual){
        if(i == atual.getInfo()) //se i for igual ao elemento que está no atual apenas incrementa
            atual.incrementaQuantidade();
        else if(i < atual.getInfo()){ //se o i for menor que o atual..
            if(atual.getEsquerda() == null){ //se a esquerda do atual for nula/estiver disponivel, então insere o no novo lá
                atual.setEsquerda(new No(i));
            }
            else{//se não estiver vazia
                insereRec(i, atual.getEsquerda());;
            }
        }
        else{//se i é maior que o atual...
            if(atual.getDireita() == null){ //se o 'gancho' da direita estiver disponivel, então liga-se a nova referencia daquele elemento 
                atual.setDireita(new No(i));
            }
            else{
                insereRec(i, atual.getDireita());
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
        
        String s = "";
        s += toStringEmOrdemRec(atual.getEsquerda()); // busca tudo que tenho na esquerda
        
        //processamento da raiz, levando em consideração a quantidade:
        for (int i = 1; i <= atual.getQuantidade(); i++)
               s = s + atual.getInfo() + " ";//pega a info da raiz

        s = s + toStringEmOrdemRec(atual.getDireita()); //busca tudo que tenho na direita
        return s;
    }
}
