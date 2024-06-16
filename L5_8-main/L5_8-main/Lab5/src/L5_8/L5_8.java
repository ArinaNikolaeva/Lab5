package L5_8;

import L5_8.data.Popular;
import L5_8.data.Mus;
import L5_8.data.NotPopular;
import L5_8.GUI.MainWindow;

public class L5_8 {
    public static void main(String[] args) {
        new MainWindow();

        //Начальные города и деревни
        Mus.add(new Popular("Тринадцать карат", 2022, 3, "поп-рок"));
        Mus.add(new Popular("Три дня дождя", 2019, 8, "рок"));
        Mus.add(new Popular("ПМ", 2016, 5, "панк-рок"));
        Mus.add(new NotPopular("Проблемный ребёнок", 2020, 1, "инди-рок"));

    }
}