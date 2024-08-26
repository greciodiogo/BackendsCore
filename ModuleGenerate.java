import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ModuleGenerate {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Por favor, forneça o nome do módulo e o caminho base do pacote.");
            return;
        }

        String moduleName = args[0];
        String basePackagePath = args[1].replace(".", "/");
        String className = moduleName.substring(0, 1).toUpperCase() + moduleName.substring(1);
        String baseDir = "./src/main/java/" + basePackagePath;


        FolderAndFile[] folders = {
            new FolderAndFile("controllers", "Controller"),
            new FolderAndFile("services", "Service"),
            new FolderAndFile("repositories", "Repository"),
            new FolderAndFile("domain", ""),  // Domain class doesn't need suffix
            new FolderAndFile("DTO", "DTO")
        };

        for (FolderAndFile folder : folders) {
            String folderPath = baseDir + "/" + folder.fold;
            new File(folderPath).mkdirs();

            String fileName = folderPath + "/" + className + folder.file + ".java";

            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(getFileContent(folder.fold, className, moduleName, basePackagePath));
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo: " + fileName);
                e.printStackTrace();
            }
        }

        System.out.println("Módulo " + moduleName + " criado com sucesso!");
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static String getFileContent(String folder, String className, String moduleName, String basePackagePath) {
        String basePackage = basePackagePath.replace("/", ".");

        switch (folder) {
            case "domain":
                return "package " + basePackage + ".domain;\n\n" +
                       "import jakarta.persistence.*;\n" +
                       "import lombok.*;\n\n" +
                       "import java.util.Date;\n\n" +
                       "@Getter\n" +
                       "@Setter\n" +
                       "@NoArgsConstructor\n" +
                       "@AllArgsConstructor\n" +
                       "@EqualsAndHashCode(of = \"id\")\n" +
                       "@Entity(name=\"" + moduleName.toLowerCase() + "s\")\n" +
                       "@Table(name = \"" + moduleName.toLowerCase() + "s\")\n" +
                       "public class " + className + " {\n\n" +
                       "    @Id\n" +
                       "    @GeneratedValue(strategy = GenerationType.IDENTITY)\n" +
                       "    private Integer id;\n" +
                       "    private String descricao;\n" +
                       "    @Column(name = 'created_at')"+
                       "    private Date createdAt;\n" +
                       "    @Column(name = 'updated_at')"+
                       "    private Date updatedAt;\n" +
                       "}\n";

            case "repositories":
                return "package " + basePackage + ".repositories;\n\n" +
                       "import org.springframework.data.jpa.repository.JpaRepository;\n" +
                       "import java.util.List;\n" +
                       "import " + basePackage + ".domain." + className + ";\n\n" +
                       "public interface " + className + "Repository extends JpaRepository<" + className + ", Long> {\n" +
                       "    List<" + className + "> findAll();\n" +
                       "}\n";

            case "DTO":
                return "package " + basePackage + ".DTO;\n\n" +
                       "import " + basePackage + ".domain." + className + ";\n\n" +
                       "public record " + className + "DTO(\n\n" +
                       "    Integer id,\n" +
                       "    String descricao\n\n){" +
                       "    public " + className + "DTO(" + className + " " + moduleName.toLowerCase() + ") {\n" +
                       "        this(\n        " + moduleName.toLowerCase() + ".getId(),\n" +
                       "                       " + moduleName.toLowerCase() + ".getDescricao()\n);" +
                       "    }\n" +
                       "}\n";

            case "services":
                return "package " + basePackage + ".services;\n\n" +
                       "import org.springframework.stereotype.Service;\n" +
                       "import java.util.List;\n" +
                       "import " + basePackage + ".domain." + className + ";\n" +
                       "import " + basePackage + ".repositories." + className + "Repository;\n\n" +
                       "@Service\n" +
                       "public class " + className + "Service {\n\n" +
                       "    private final " + className + "Repository " + moduleName.toLowerCase() + "Repository;\n\n" +
                       "    public " + className + "Service(" + className + "Repository " + moduleName.toLowerCase() + "Repository) {\n" +
                       "        this." + moduleName.toLowerCase() + "Repository = " + moduleName.toLowerCase() + "Repository;\n" +
                       "    }\n\n" +
                       "    public List<" + className + "> findAll() {\n" +
                       "        return " + moduleName.toLowerCase() + "Repository.findAll();\n" +
                       "    }\n" +
                       "}\n";

            case "controllers":
                return "package " + basePackage + ".controllers;\n\n" +
                       "import org.springframework.beans.factory.annotation.Autowired;\n" +
                       "import org.springframework.http.ResponseEntity;\n" +
                       "import org.springframework.web.bind.annotation.*;\n" +
                       "import java.util.List;\n" +
                       "import " + basePackage + ".domain." + className + ";\n" +
                       "import " + basePackage + ".services." + className + "Service;\n\n" +
                       "@RestController\n" +
                       "@RequestMapping(\"/api/" + moduleName.toLowerCase() + "s\")\n" +
                       "public class " + className + "Controller {\n\n" +
                       "    private final " + className + "Service " + moduleName.toLowerCase() + "Service;\n\n" +
                       "    @Autowired\n" +
                       "    public " + className + "Controller(" + className + "Service " + moduleName.toLowerCase() + "Service) {\n" +
                       "        this." + moduleName.toLowerCase() + "Service = " + moduleName.toLowerCase() + "Service;\n" +
                       "    }\n\n" +
                       "    @GetMapping\n" +
                       "    public ResponseEntity<List<" + className + ">> findAll() {\n" +
                       "        List<" + className + "> lista = " + moduleName.toLowerCase() + "Service.findAll();\n" +
                       "        return ResponseEntity.ok(lista);\n" +
                       "    }\n" +
                       "}\n";

            default:
                return "";
        }
    }

    static class FolderAndFile {
        String fold;
        String file;

        FolderAndFile(String fold, String file) {
            this.fold = fold;
            this.file = file;
        }
    }
}
