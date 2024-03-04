import java.io.FileWriter;

/**
 * Класс сохраняет в файл выданные игрушки.
 * Если имя файла не указывается, по умолчанию создается файл "toys.txt."
 */
public class Writter {
    private String filepath;

    public Writter(String filepath) {
        this.filepath = filepath;
    }

    public Writter() {
        this ("toys.txt");
    }

    /**
     * Записывает передаваему строку в файл.
     * @param str
     */
    public void writeToFile(String str){
        try(FileWriter fileWriter = new FileWriter(filepath, true)){
         fileWriter.append(str);
         fileWriter.append("\n");
         fileWriter.flush();
        } catch (Exception e){
            System.out.println("Ошибка записи в файл");
        }
    }

}
