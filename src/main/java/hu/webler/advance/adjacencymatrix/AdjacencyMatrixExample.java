package hu.webler.advance.adjacencymatrix;

// szomszédsági mátrix (jaaa, és még ezt lehet súlyozni is) -> olyankor nem 1 kerül a mátrixba, hanem a súly

/*
    Szomszédsági mátrix:
        1 -- 2
        |    |
        4 -- 3
*/
public class AdjacencyMatrixExample {

    public static void main(String[] args) {

        int[][] adjacencyMatrix = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0}
        };

        printAdjacencyMatrix(adjacencyMatrix);
    }

    static void printAdjacencyMatrix(int[][] matrix) {
        System.out.println("Szomszédsági mátrix:");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    /*
    Az adott példa egy egyszerű irányítatlan gráfot mutat be, amelynek csomópontjai 1-től 5-ig vannak számozva.
    Az élek a csomópontok közötti kapcsolatokat jelképezik.
    A szomszédsági mátrix a gráf éleit reprezentálja. A mátrix sorai és oszlopai a csomópontokat jelölik, és a mátrix
    elemei azt mutatják meg, hogy két csomópont között van-e él vagy sem.
    Az egyes sorok és oszlopok a csomópontokat reprezentálják. Például, a [2][1] és [1][2] elemek értéke 1, mert a második
    és az első csomópont között van él. Az 1-esek a gráf éleit jelölik, ahol az adott csomópontok össze vannak kötve.
    0 1 0 1 0
    1 0 1 0 0
    0 1 0 1 0
    1 0 1 0 1
    0 0 0 1 0
    Például:
    A második és harmadik csomópont között van él (1. sor, 2. oszlop és 3. oszlop).
    Az első és negyedik csomópont között van él (1. oszlop, 4. oszlop és 1. sor).
    Az ötödik csomópontnak nincs éllel való kapcsolata más csomópontokkal.
    Ez a szomszédsági mátrix reprezentálja a gráf topológiáját, és könnyen leolvasható, hogy mely csomópontok vannak
    összekötve egymással.
    */
}