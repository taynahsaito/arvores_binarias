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
    //tostring padrão retornaria o hashcode, por isso criamos o tostringemordem, para podermos visualizar a arvore
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
    
    public int numeroNos(){
    if (estaVazia()){
        return 0;
    }
    return numeroNosRec(raiz);
    }

    int numeroNosRec(No atual){
        if (atual == null)
            return 0;
        //varre a subarvore da esquerda, pega a raiz que tem como quantidae 1 e varre a subarvore da direita -> soma tudo depois e essa será a quantidade de nós
        return numeroNosRec(atual.getEsquerda()) + 1 + numeroNosRec(atual.getDireita());
    }

    //o maximo entre os niveis
    public int altura(){
        if (estaVazia())
            return 0;
        return alturaRec(raiz);
    }

    int alturaRec(No atual){
        if(atual.getEsquerda() == null & atual.getDireita() == null)
            return 0;
        int nivelEsq = 0;
        
        if(atual.getEsquerda() != null)
            nivelEsq = alturaRec(atual.getEsquerda());

        int nivelDir = atual.getDireita() != null ? alturaRec(atual.getDireita()) : 0;

        return nivelDir > nivelEsq ? nivelDir + 1 : nivelEsq + 1;
    }

    public boolean busca (int x){
        if (estaVazia())
            return false;
        return buscaRec(x, raiz); //buscar o x a partir da raiz
    }

    boolean buscaRec(int x, No atual){
        // //modo 1 - requer a verificação do nó antes da chamada(exemplo só para a esquerda):
        // if (x == atual.getInfo()) return true;//como aqui eu não fiz a verificação se o nó existe, então nas proximas vezes eu preciso realizar essa verificação
        // if (x <= atual.getInfo()) //garantir que esse nó não é vazio antes de mandar ele fazer a busca (antes de chegar)
        //     if (atual.getEsquerda() != null)
        //         return buscaRec(x, atual.getEsquerda());
        //     return false;

        //modo 2 - faz a verificação do nó na chegada da chamada, pois chama o metodo recursivo, e vai para a linha 107 de novo - lá ele faz a verificação se é nulo ou não:
        if (atual == null) return false; 
        if (atual.getInfo() == x) return true;     //quando temos a chamada a um metodo, temos uma empilhação de memoria.
        if (x <= atual.getInfo()) return buscaRec(x, atual.getEsquerda()); //mando para esquerda direto sem verificar se é nulo.
        return buscaRec(x, atual.getDireita());
    }

    //na remoção de um elemento, precisamos saber quem é o pai dele para poder atualizar a informação
    public boolean remocao (int x){
        if (estaVazia()) return false;
        return remocaoRec(x, raiz, null, false);
    }

    //a remoção é um processo muito complicado, então marcamos o pai como elemento inativo
    boolean remocaoRec(int x, No atual, No pai, boolean eFilhoEsquerdo){
        if (atual == null) return false;
        if (atual.getInfo() == x){ //se for igual ao elemento que estou procurando...
            if (atual.getEsquerda() == null & atual.getDireita() == null){ //se o nó a ser removido nao tem filhos...
                //precisamos verificar se é filho direito ou esquerdo do pai
                if (eFilhoEsquerdo)
                    pai.setEsquerda(null);
                else
                    pai.setDireita(null);

            }
            //verificando qual dos dois é verdade
            else if (atual.getEsquerda() == null){ //se for nulo, só tem filho na direita
                if (eFilhoEsquerdo)
                    pai.setEsquerda(atual.getDireita()); //faz a ligação do pai do atual com o filho do atual
                else
                    pai.setDireita(atual.getDireita());
                }
            else if (atual.getDireita() == null){ //se for nulo, só tem filho da esquerda
                if (eFilhoEsquerdo)
                    pai.setEsquerda(atual.getEsquerda());
                else
                    pai.setDireita(atual.getEsquerda());
            }
            else{//se tem os dois filhos...
                //o sucessor é o menor valor maior que o numero a ser removido - isso garante que o atributo esquerda seja nulo, ou seja, esteja disponivel.
                //a subarvore da direita do nó a ser removido vai ser subarvore (direita ou esquerda) do pai e a subarvore da esquerda do no a ser removido vai ser a subarvore
                //da esquerda do sucessor. - a subarvore direita ou esquerda depende do eFilhoEsquerdo
                No sucessor = atual.getDireita();
                //não precisa ser recursivo pois estou andando para um lado so 
                while (sucessor.getEsquerda() != null) { //enquanto o sucessor tiver filhos na esquerda...
                    sucessor = sucessor.getEsquerda(); //passa para o proximo da esquerda e achamos o sucessor
                }
                sucessor.setEsquerda(atual.getEsquerda());
                //a subarvore da esquerda vai ser adotada pela subarvore do sucessor, a subarvore da direita vai ser adotada pelo pai.
                if (pai == null) //se não tiver pai é porque é a raiz
                    raiz = atual.getDireita();
                else if (eFilhoEsquerdo)
                    pai.setEsquerda(sucessor); // faz a ligação do pai com o proximo do elemento removido
                else
                    pai.setDireita(sucessor);
            }
            return true; //porque conseguimos remover o elemento que estavamos procurando
        }
        else if (x < atual.getInfo()){//se o elemento que queremos remover for menor que o elemento atual que estamos...
            eFilhoEsquerdo = true;
            pai = atual;
            return remocaoRec(x, atual.getEsquerda(), pai, eFilhoEsquerdo);
        }
        else { //se x for maior
            eFilhoEsquerdo = false;
            pai = atual;
            return remocaoRec(x, atual.getDireita(), pai, eFilhoEsquerdo);
        }
    }
}
