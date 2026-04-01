public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
   Board board = new Board();
    board.iniciar();
   while(!board.jogoAcabou()){
       System.out.print("digite o numero desejado para inserir: ");
       int numero = input.nextInt();
       System.out.println();
       System.out.print("digite a linha que deseja inserir: ");
       int linha = input.nextInt()-1;
       System.out.println();
       System.out.print("digite a posição que voce deseja: ");
       int posicao = input.nextInt()-1;
       System.out.println();
       board.jogada(posicao,linha,numero);
   }
    System.out.println("acabou! boa!");
}