import javax.ejb.Stateless;
import java.io.File;

@Stateless
public class GetFilesEjb implements GetFilesEjbLocal {
    @Override
    public String getFileStructure() {
        return getStructure(new File("."), "");
    }

    private String getStructure(File file, String prefix) {
        String result = prefix + file.getName() + '\n';

        if (file.isDirectory()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(prefix).append(file.getName()).append('\n');

            File[] files = file.listFiles();
            for (File someFile : files)
                stringBuilder.append(getStructure(someFile, prefix + "| "));

            result = stringBuilder.toString();
        }

        return result;
    }
}
