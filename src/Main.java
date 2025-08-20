import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, Set<String>> synonymMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Домашняя работа №9");

        // Создайте HashSet<String>, добавьте 5 слов и выведите все элементы
        Set<String> set = new HashSet<>(List.of("январь", "февраль", "март", "апрель", "java"));
        for (String item : set) {
            System.out.println(item);
        }

        // Проверьте, содержится ли слово "java" в множестве
        System.out.printf("Слово \"java\" в множестве %s\n", (set.contains("java") ? "есть" : "нет"));

        //Удалите слово "python" из множества (если оно есть)
        if (set.contains("python")) {
            set.remove("python");
        }

        // Дан список строк с повторами. Добавьте их в HashSet и выведите количество уникальных слов
        List<String> list = new ArrayList<>(List.of("a b c d e f f f f".split(" ")));
        set.addAll(list);
        System.out.println(set);
        System.out.printf("Количество уникальных слов - %s\n", set.size());

        //Создайте HashMap<String, Integer> с названиями предметов и оценками. Выведите все пары ключ-значение
        Map<String, Integer> gradeMap = new HashMap<>();
        gradeMap.put("Math", 1);
        gradeMap.put("Francaise", 2);
        gradeMap.put("Biology", 3);
        gradeMap.put("English",4);
        gradeMap.put("Physics", 5);
        gradeMap.put("History", 6);
        System.out.println(gradeMap);
        for (Map.Entry<String, Integer> item : gradeMap.entrySet()) {
            System.out.println(item.getKey() + " = " + item.getValue());
        }

        //Выведите значение по ключу "Math".
        System.out.printf("Значение по ключу Math = %s\n", gradeMap.get("Math"));

        //Измените значение по ключу "English" на 5
        if (gradeMap.containsKey("English")) {
            gradeMap.put("English", 5);
            System.out.printf("Значение по ключу English изменено на %s\n", gradeMap.get("English"));
        }

        //Проверьте, есть ли в мапе ключ "History"
        if (gradeMap.containsKey("History")) {
            System.out.println("В мапе есть ключ \"History\"");
        } else {
            System.out.println("В мапе нет ключа \"History\"");
        }

        //Удалите ключ "Physics" из мапы
        gradeMap.remove("Physics");
        System.out.println(gradeMap);

        Map<String, Integer> map = new HashMap<>();
        map.put("Иванов", 5);
        map.put("Петров", 4);
        map.put("Сидоров", 5);
        System.out.printf("Лучше всех учится %s\n", bestStudent(map));

        // Словарь синонимов
        addSynonym("гора", "вершина");
        addSynonym("гора", "круча");
        addSynonym("гора", "скала");
        addSynonym("гора", "вершина");
        addSynonym("синоним", "аналог");
        addSynonym("синоним", "дубликат");
        addSynonym("синоним", "эквивалент");
        System.out.println(synonymMap);
    }

    /**
     * - Анаграммы
     * Напишите метод areAnagrams(String a, String b),
     * который возвращает true, если строки состоят из одинаковых символов (используйте Map<Character, Integer>).
     */
    public static boolean areAnagram(String a, String b) {
        return map(a).equals(map(b));
    }

    //получить map из слова
    public static Map<Character, Integer> map(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : string.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    /**
     * - Поиск дубликатов с помощью Set
     * Напишите метод hasDuplicates(List<Integer> list) — возвращает true, если в списке есть дубликаты
     */
    public static boolean hasDuplicates(List<Integer> list) {
        return (new HashSet<>(list).size() < list.size());
    }

    /**
     * - Рейтинг студентов
     * Дан Map<String, Integer> (имя студента → балл). Верните имя студента с максимальным баллом
     */
    public static List<String> bestStudent(Map<String, Integer> map) {
        List<String> students = new ArrayList<>();
        Integer maxValue = Collections.max(map.values());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) {
                students.add(entry.getKey());
            }
        }
        return students;
    }

    /**
     * - Словарь синонимов
     * Создайте Map<String, Set<String>> — ключ: слово, значение: набор синонимов.
     * Реализуйте метод addSynonym(String word, String synonym)
     */

    public static void addSynonym(String word, String synonym) {
        synonymMap.computeIfAbsent(word, k -> new HashSet<>()).add(synonym);
    }
}
