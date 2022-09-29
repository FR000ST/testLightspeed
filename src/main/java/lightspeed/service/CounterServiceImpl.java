package lightspeed.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Сервис работы со счётчиками
 */
@Service
public class CounterServiceImpl implements CounterService {
    /**
     * Хранилище счётчиков
     */
    private final ConcurrentHashMap<String, AtomicInteger> counters = new ConcurrentHashMap<>();

    /**
     * Метод создания счётчика с рандомным наименованием
     *
     * @return {@link String} наименование созданного счётчика
     */
    public String create() {
        var randomString = RandomStringUtils.random(10, true, true);
        counters.putIfAbsent(randomString, new AtomicInteger(0));
        return randomString;
    }

    /**
     * Метод инкрементации счётчика
     *
     * @param name {@link String} наименование счётчика
     * @return int. Значение после инкрементации
     */
    public int increment(final String name) {
        return counters.get(name).incrementAndGet();
    }

    /**
     * Получение текущего значения счётчика
     *
     * @param name {@link String} наименование счётчика
     * @return int. Значение счётчика
     */
    public int get(final String name) {
        return counters.get(name).get();
    }

    /**
     * Удаление счётчика по наименованию
     *
     * @param name {@link String} наименование счётчика
     * @return boolean. Если такой счётчик был в хранилище, то true, в противном случае false
     */
    public boolean delete(final String name) {
        return counters.remove(name) != null;
    }

    /**
     * Суммарное значение всех счётчиков
     *
     * @return int. Сумма
     */
    public int sum() {
        return counters.values().stream().mapToInt(AtomicInteger::get).sum();
    }

    /**
     * Получение списка наименований всех счётчиков
     *
     * @return {@link List} of {@link String}
     */
    public List<String> nameList() {
        return new ArrayList<>(counters.keySet());
    }
}
