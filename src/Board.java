import java.util.*;

public class Board {

    private List<List<Integer>> matrizeslinha = new ArrayList<>();

    void iniciar(){
        for (int i = 0; i < 9; i++) {
            List<Integer> linha = new ArrayList<>(Collections.nCopies(9,0));
            matrizeslinha.add(linha);
        }
        var c = 0;
        for (int i = 0; i < 37; i++) {
            Random nrand = new Random();
            int numero = nrand.nextInt(9) + 1;
            Random posicao = new Random();
            int pescolhida = posicao.nextInt(9);
            Random  lescolhida = new Random();
            int nlescolhida = lescolhida.nextInt(9);
            if(validarNumero(numero,pescolhida,nlescolhida)){
                    matrizeslinha.get(nlescolhida).set(pescolhida,numero);}
                }
        toStringPersonalizado();
            }


    Boolean validarNumero(Integer numero,Integer posicao,Integer linha){
        boolean valido = false;
        if(!matrizeslinha.get(linha).contains(numero)){
            int j;
            for (j = 0; j < 9; j++) {
                if(matrizeslinha.get(j).get(posicao).equals(numero)) {
                    break;
                }
            }
            if (j==9){
                valido = true;
            }
        }
        return valido;
    }

    void jogada(Integer posicao,Integer linha, Integer numero){
        if (validarNumero(numero, posicao, linha) && matrizeslinha.get(linha).get(posicao) == 0){
        matrizeslinha.get(linha).set(posicao,numero);
    }else {
        System.out.println("jogada invalida!!!");
    }
    toStringPersonalizado();
    }

    Boolean jogoAcabou(){
        boolean acabou;
        for (int i=0; i < matrizeslinha.size();i++){
            for (int j=0; j <matrizeslinha.get(i).size();j++){
                if (matrizeslinha.get(i).get(j).equals(0)) {
                    return false;
                }
            }
        }
        return true;
    }


    public void toStringPersonalizado() {
        for (int i = 0; i < matrizeslinha.size(); i++) {
            List<Integer> linhaAtual = matrizeslinha.get(i);

            for (int j = 0; j < linhaAtual.size(); j++) {
                System.out.print(linhaAtual.get(j) + " ");


                if ((j + 1) % 3 == 0 && (j + 1) < linhaAtual.size()) {
                    System.out.print("|");
                }
            }

            System.out.println("");
            System.out.println("-------------------");
        }
    }



}











