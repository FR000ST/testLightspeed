package lightspeed.service;

import java.util.List;

/**
 * Сервис работы со счётчиками
 */
public interface CounterService {
    /**
     * Метод создания счётчика с рандомным наименованием
     *
     * @return {@link String} наименование созданного счётчика
     */
    String create();

    /**
     * Метод инкрементации счётчика
     *
     * @param name {@link String} наименование счётчика
     * @return int. Значение после инкрементации
     */
    int increment(final String name);

    /**
     * Получение текущего значения счётчика
     *
     * @param name {@link String} наименование счётчика
     * @return int. Значение счётчика
     */
    int get(final String name);

    /**
     * Удаление счётчика по наименованию
     *
     * @param name {@link String} наименование счётчика
     * @return boolean. Если такой счётчик был в хранилище, то true, в противном случае false
     */
    boolean delete(final String name);

    /**
     * Суммарное значение всех счётчиков
     *
     * @return int. Сумма
     */
    int sum();

    /**
     * Получение списка наименований всех счётчиков
     *
     * @return {@link List} of {@link String}
     */
    List<String> nameList();
}
