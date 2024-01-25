package hu.webler.quicksortrecap;

public class QuickSortExample {

    /*
    A quicksort algoritmust érdemes használni olyan helyeken, ahol a gyors és hatékony rendezésre van szükség, különösen
    akkor, ha a rendezendő adatok nagy méretűek. A quicksort egy gyors és hatékony osztályozási algoritmus, és jól működik
    a legtöbb esetben.
    Itt néhány példa, amikor érdemes lehet a quicksort használatát fontolóra venni:
    Általános rendezési feladatok: Quicksort az egyik leggyorsabb általános rendezési algoritmus. Amikor a gyors futási
    idő kritikus, és a rendezendő adatméret nagy, a quicksort hatékony választás lehet.
    Adatbázisrendezés: Amikor egy adatbázisban található adatokat rendezni kell, a quicksort alkalmazása hatékony lehet,
    különösen nagy adatbázisok esetén.
    Operációs rendszerek: Az operációs rendszerek gyakran alkalmazzák a quicksortot a fájlrendezésre vagy a keresési
    algoritmusokhoz.
    Programozási nyelvek belső rendező algoritmusai: Néhány programozási nyelv belső rendező algoritmusaként használja a
    quicksortot a beépített rendezési funkciók megvalósításához.
    Fontos megjegyezni, hogy bár a quicksort rendkívül hatékony, néhány esetben, például már rendezett vagy majdnem rendezett
    adatok esetén, más rendezési algoritmusok, például a merge sort vagy a heap sort lehetnek hatékonyabbak. A választás függ
    az alkalmazás követelményeitől, az adatok jellegétől és a rendelkezésre álló erőforrásoktól.
    */

    public static void main(String[] args) {

        int[] array = {12, 4, 5, 6, 7, 3, 1, 15, 2, 10};

        // Call the quickSort method to sort the array
        quickSort(array, 0, array.length - 1);
        // quickSort(array, 0, array.length - 5);

        // Print the sorted array
        System.out.println("Sorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

     /*
    A partíciós index azt az indexet jelenti, ahol a tömb egy része megfelelően rendezett lesz a rendezési algoritmus
    futtatásának eredményeként. Konkrétan a quicksort algoritmus esetében a partíciós index kiválasztása és a tömb elemeinek
    átrendezése az a lépés, amelynek eredményeként a kiválasztott pivot elem helyes pozíciójába kerül, és a bal oldali részt
    alkotó elemek kisebbek lesznek, míg a jobb oldali részt alkotó elemek nagyobbak lesznek, de a rendezetlenségek megmaradnak
    mindkét részben.
    A partition függvény ezt a műveletet végzi el. Amikor a partíciós függvény végrehajtódik, a pivot elemet a tömb megfelelő
    helyére helyezi, és visszaadja azt az indexet, ahol a pivot elem mostantól a rendezett tömbben található. Ezt az indexet
    hívjuk partíciós indexnek.
    A quicksort algoritmus minden rekurzív hívásnál megválasztja a pivotot és hajtja végre a partíciót a pivot körül.
    Ezáltal a tömb minden egyes része rendezetté válik, amit a rekuzív hívások végeznek.
    */

    private static void quickSort(int[] array, int low, int high) {
        // Ellenőrizze, hogy több mint egy elem van-e a tömbben
        if (low < high) {
            // Keressen egy partíciós indexet, amelynek eredményeképpen a pivotnál kisebb elemek a bal oldalon,
            // a pivotnál nagyobb elemek pedig a jobb oldalon lesznek
            int pivotIndex = partition(array, low, high);
            // Rekurzívan rendezze a résztömböket a partíciós index előtti és utáni részen
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Segédfüggvény a partíciós index meghatározásához
    private static int partition(int[] array, int low, int high) {
        // Válassza ki a jobb oldali elemet a pivotként
        /*
        A quicksort esetében a "pivot" egy konkrét elem a rendezendő tömbből, amelyet a rendezési folyamat közben
        kiválasztanak. A cél az, hogy a pivot kiválasztásával és az elemek átrendezésével a pivot a helyes pozíciójába
        kerüljön a rendezett sorrendben. A pivot kiválasztása és az elemek átrendezése segít a további rekurzív rendezési
        lépésekben.
        */
        int pivot = array[high];
        // Inicializálja a kisebb elem indexét
        int i = low - 1;

        // Menjen végig az összes tömbelemen
        for (int j = low; j < high; j++) {
            // Ha a jelenlegi elem kisebb, mint a pivot
            if (array[j] < pivot) {
                i++;
                // Cserélje ki az array[i] és array[j] értékeket
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Cserélje ki a pivot elemet az (i + 1) indexű elemmel
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // Adja vissza a partíciós elem indexét
        return i + 1;
    }

    // quickSort(array, 0, array.length - 5)

    /*
    Magyarázat:
    Első Hívás: quickSort(array, 0, array.length - 5)
    low kezdetben 0.
    high kiszámolva mint array.length - 5, ami 10 - 5 = 5.
    Particionálás:
    A partition metódust meghívjuk a pivot kiválasztásához és az elemek átrendezéséhez.
    Pivot kiválasztása: A pivot az high indexű elem, vagyis array[5] = 3.
    Particionálási folyamat:
    Induljunk i = low - 1-nél, ami kezdetben -1.
    Iteráljunk j = low-tól high - 1-ig (ebben az esetben 0-tól 4-ig).
    Iteráció 1 (j=0): array[0] (12) > pivot (3), tehát nincs csere.
    Iteráció 2 (j=1): array[1] (4) < pivot (3), tehát cseréljük array[1] és array[0]. Tömb: {4, 12, 5, 6, 7, 3, 1, 15, 2, 10}
    Iteráció 3 (j=2): array[2] (5) < pivot (3), tehát cseréljük array[2] és array[1]. Tömb: {4, 5, 12, 6, 7, 3, 1, 15, 2, 10}
    Iteráció 4 (j=3): array[3] (6) > pivot (3), tehát nincs csere.
    Iteráció 5 (j=4): array[4] (7) > pivot (3), tehát nincs csere.
    A ciklus után cseréljük a pivotot (array[5] és array[i + 1]), ahol i + 1 a pivot helyes pozíciója.
    Cseréljük array[5] és array[2]. Tömb: {4, 5, 3, 6, 7, 12, 1, 15, 2, 10}.
    A pivot (3) most már a rendezett tömbben van, a bal oldalon kisebb elemekkel, a jobb oldalon pedig nagyobb elemekkel.
    Rekurzív Hívások:
    Most rekurzívan hívjuk quickSort-ot a két résztömbön:
    quickSort(array, low, pi - 1): quickSort(array, 0, 2)
    Ez a bal résztömbre vonatkozik {4, 5, 3}.
    A pivot 3, és a tömb {3, 4, 5} lesz a rendezés után.
    quickSort(array, pi + 1, high): quickSort(array, 4, 5)
    Ez a jobb résztömbre vonatkozik {7, 12, 1, 15, 2, 10}.
    A pivot 10, és a tömb {1, 2, 7, 10, 12, 15} lesz a rendezés után.
    Végeredmény:
    A rendezett résztömbök összefűzése a végső rendezett tömb létrehozásához: {3, 4, 5, 6, 7, 12, 1, 15, 2, 10}.
    */
}