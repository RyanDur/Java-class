public class PracticeFindBugsOnce {

    public String getInitials(String fullName) {
        String result = "";
        String[] words = fullName.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String nextInitial = "" + words[i].charAt(0);
            result = result + nextInitial.toUpperCase();
        }
        return result;
    }
}
