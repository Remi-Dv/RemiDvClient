package remidv.fr.remidvclient.UI;

public class GUIManager {
    private static boolean isModMenuOpened = false;

    public static void toggleModMenu()
    {
        isModMenuOpened = !isModMenuOpened;
        System.out.println(isModMenuOpened);
    }
}
