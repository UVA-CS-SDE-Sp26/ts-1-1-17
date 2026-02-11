public class CipherService {

    public String decipher(String text, CipherKey key) {
        StringBuilder out = new StringBuilder();

        // iterate over text
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            Character mapped = key.get(ch);

            // if mapped replace, else keep as is
            if (mapped != null) {
                out.append(mapped);
            } else {
                out.append(ch);
            }
        }

        return out.toString();
    }
}
