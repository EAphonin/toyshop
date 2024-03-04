import java.util.*;

/**
 * Класс добавляет игрушки для розыгрыша и выбирает случайную в очередь.
 * Записывает выданные в файл.
 */
public class ToysQueue {
    private Queue<Toy> toyQueue = new ArrayDeque<>();
    private List<Toy> toyList = new ArrayList<>();
    private Writter writter;

    public ToysQueue(Writter writter) {
        this.writter = writter;
    }

    /**
     * Добавление игрушки к розыгрышу
     * @param id идентификатор
     * @param name наименование
     * @param frequency вероятность выпада(вес)
     * @param count количество игрушек
     */
    public void put(int id, String name, int frequency, int count){
        toyList.add(new Toy(id, name, frequency, count));
    }

    /**
     * Выбор одной случайной игрушки. Добавление ее в очередь для выдачи.
     */
    public void get(){
        int index = new Random().nextInt(getMaxVolue());
        for (Toy toy: toyList){
            if(toy.getCount() > 0){
                if (index < toy.getFrequency()){
                    toyQueue.add(toy);
                    toy.decrementCount();
                    break;
                }
                index -= toy.getFrequency();
            }
        }
    }

    /**
     * Выдача одной игрушки и запись об этом в файл.
     * @return
     */
    public Toy receiveToy(){
        Toy toy = toyQueue.poll();
        writter.writeToFile(toy.toString());
        return toy;
    }

    /**
     * Проверка, если ли в очереди игрушки для выдачи
     * @return
     */
    public boolean hasReceiving(){
        return !toyQueue.isEmpty();
    }

    /**
     * Получение максимального числа вероятности.
     * @return
     */
    private int getMaxVolue() {
        int result = 0;
        for (Toy toy: toyList){
            if(toy.getCount()>0)
                result += toy.getFrequency();
        }
        return result;
    }


}
