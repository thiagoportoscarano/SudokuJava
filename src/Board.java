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
            Random coluna = new Random();
            int pescolhida = coluna.nextInt(9);
            Random  lescolhida = new Random();
            int nlescolhida = lescolhida.nextInt(9);
            if(validarNumero(numero,pescolhida,nlescolhida)){
                    matrizeslinha.get(nlescolhida).set(pescolhida,numero);}
                }
        toStringPersonalizado();
            }


    Boolean validarNumero(Integer numero, Integer coluna, Integer linha) {
        if (matrizeslinha.get(linha).contains(numero)) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            if (matrizeslinha.get(i).get(coluna).equals(numero)) {
                return false;
            }
        }


        int inicioLinha = (linha / 3) * 3;
        int inicioColuna = (coluna / 3) * 3;

        for (int i = inicioLinha; i < inicioLinha + 3; i++) {
            for (int j = inicioColuna; j < inicioColuna + 3; j++) {
                if (matrizeslinha.get(i).get(j).equals(numero)) {
                    return false;
                }
            }
        }

        return true;
    }

    void jogada(Integer coluna,Integer linha, Integer numero){
        if (validarNumero(numero, coluna, linha) && matrizeslinha.get(linha).get(coluna) == 0){
        matrizeslinha.get(linha).set(coluna,numero);
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











