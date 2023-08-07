package remidv.fr.remidvclient.UI.Chat;

public class ChatControl {
    private static String[] forbiddenWords = { "fuck", "porn", "merde" };
    public static boolean isMessageAllowed(String message) {
        String lowercaseMessage = message.toLowerCase();
        for (int i = 0; i < forbiddenWords.length; i++) {  // Utilisez '<' au lieu de '<='
            if (lowercaseMessage.contains(forbiddenWords[i])) {
                return false;
            }
        }
        return true;
    }
}
