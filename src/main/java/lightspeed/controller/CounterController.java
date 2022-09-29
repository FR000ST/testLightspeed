package lightspeed.controller;

import lightspeed.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер для взаимодействия со счётчиками
 */
@RestController
@RequestMapping(value = "/counter")
public class CounterController {
    @Autowired
    private CounterService counterService;

    /**
     * Рест метод создания счётчика с рандомным наименованием
     *
     * @return {@link String} наименование созданного счётчика
     */
    @PutMapping("create")
    public String create() {
        return counterService.create();
    }

    /**
     * Рест метод инкрементации счётчика
     *
     * @param name {@link String} наименование счётчика
     * @return int. Значение после инкрементации
     */
    @PostMapping("increment/{name}")
    public int increment(@PathVariable final String name) {
        return counterService.increment(name);
    }

    /**
     * Рест метод получения текущего значения счётчика
     *
     * @param name {@link String} наименование счётчика
     * @return int. Значение счётчика
     */
    @GetMapping("get/{name}")
    public int get(@PathVariable final String name) {
        return counterService.get(name);
    }

    /**
     * Рест метод удаления счётчика по наименованию
     *
     * @param name {@link String} наименование счётчика
     * @return boolean. Если такой счётчик был в хранилище, то true, в противном случае false
     */
    @DeleteMapping("delete/{name}")
    public boolean delete(@PathVariable final String name) {
        return counterService.delete(name);
    }

    /**
     * Рест метод подсчёта суммарного значения всех счётчиков
     *
     * @return int. Сумма
     */
    @GetMapping("sum")
    public int sum() {
        return counterService.sum();
    }

    /**
     * Рест метод получения списка наименований всех счётчиков
     *
     * @return {@link List} of {@link String}
     */
    @GetMapping("names")
    public List<String> nameList() {
        return counterService.nameList();
    }
}
