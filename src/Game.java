import java.util.Scanner;

public class Game {
    private static OX ox;
    private static Scanner kb = new Scanner(System.in);
    private static int Col;
    private static int Row;

    public static void main(String[]args){
        ox = new OX();
        while (true){
            printTable();
            input();
            /*checkWin*/
            if(ox.checkWin(Col,Row)) {
                printTable();
                printWin();
                printScore("X Win: " + ox.getScoreX(), "O Win: ", ox.getScoreO(), "Draw : ", ox.getScoreDraw());

                ox.reset();
                continue;
            }
            /*checkDraw*/
            if(ox.isDraw()){
                printTable();
                printScore("Draw", "X Win: ", ox.getScoreX(), "O Win: ", ox.getScoreO());
                printDraw("Draw : ", ox.getScoreDraw());
                ox.reset();
                continue;
            }
            ox.switchPlayer();

        }

    }

    private static void printDraw(String s, int scoreDraw) {
        System.out.println(s + scoreDraw);
    }

    private static void printWin() {
        System.out.println(ox.getCurrentPlayer()+ " " + "Win");
    }

    private static void printScore(String s, String s2, int scoreO, String s3, int scoreDraw) {
        System.out.println(s);
        System.out.println(s2 + scoreO);
        System.out.println(s3 + scoreDraw);
    }

    private static void input() {
        boolean canPut = true;
        do{


            System.out.print(ox.getCurrentPlayer() + " (Col) :");
            Col = kb.nextInt();
            System.out.print(ox.getCurrentPlayer() + " (Row) :");
            Row = kb.nextInt();
            canPut = ox.put(Col,Row);
            if(!canPut){
                System.out.println("Please input number between 0-2");
            }
        }while(!canPut);
    }


    private static void printTable() {
        System.out.print(ox.getTableString());
    }
}