# labwork-0_HLPM

## Задание 1. Разбиение текста на слова

> Приложение получает через параметры командной строки текст и выдаёт список слов, разделённых пробельными символами.

**Пример:**

```bash
$ java -jar task1.jar the quick brown fox jumps over the lazy dog
```

**Ожидаемый вывод:**

```
the
quick
brown
fox
jumps
over
the
lazy
dog
```

**Идея решения:** объединить аргументы, разбить строку по регулярному выражению `\s+`, отфильтровать пустые строки, вывести каждое слово на отдельной строке.

### Решение

<img width="616" height="273" alt="image" src="https://github.com/user-attachments/assets/298d3319-209b-4f3d-b13f-bec6e7c11cd4" />
<img width="357" height="155" alt="image" src="https://github.com/user-attachments/assets/89dfd0f2-a145-49f5-ad43-092388d7fe43" />

---

## Задание 2. Сортировка слов по алфавиту

> Слова из предыдущего задания должны быть отсортированы по алфавиту.

**Пример:**

```bash
$ java -jar task2.jar the quick brown fox jumps over the lazy dog
```

**Ожидаемый вывод:**

```
brown
dog
fox
jumps
lazy
over
quick
the
the
```

**Идея решения:** к результату задания 1 применить `.sorted()`.

### Решение

<img width="352" height="114" alt="image" src="https://github.com/user-attachments/assets/f489e82d-01a4-4766-b1dd-06d1f535b053" />

---

## Задание 3. Уникальные слова

> Слова из предыдущего задания должны быть уникальными.

**Пример:**

```bash
$ java -jar task3.jar the quick brown fox jumps over the lazy dog
```

**Ожидаемый вывод:**

```
brown
dog
fox
jumps
lazy
over
quick
the
```

**Идея решения:** к результату задания 2 применить `.distinct()` (до сортировки или после - результат одинаковый).

### Решение

<img width="593" height="109" alt="image" src="https://github.com/user-attachments/assets/c8f9ba9d-e815-4bbb-92b9-b6ff70a90b94" />
<img width="354" height="135" alt="image" src="https://github.com/user-attachments/assets/67b0f1b7-3896-43bb-bdb6-f77cd1149727" />

---

## Задание 4. Подсчёт повторений

> После каждого слова вывести количество его повторений.

**Пример:**

```bash
$ java -jar task4.jar the quick brown fox jumps over the lazy dog
```

**Ожидаемый вывод:**

```
brown 1
dog 1
fox 1
jumps 1
lazy 1
over 1
quick 1
the 2
```

**Идея решения:** `words.groupingBy { it }.eachCount()` даёт `Map<String, Int>` — слово → количество вхождений. Вывести ключи в алфавитном порядке.

### Решение

<img width="606" height="116" alt="image" src="https://github.com/user-attachments/assets/b1604dee-448f-4e1c-b541-c6ae6add7ac7" />
<img width="351" height="134" alt="image" src="https://github.com/user-attachments/assets/c49b6ec7-5a53-4a80-afcf-e13d8e49ef8d" />

---

## Задание 5. Сортировка по частоте и алфавиту

> Список отсортирован сначала по количеству повторений в обратном порядке, при равном количестве — по алфавиту.

**Пример:**

```bash
$ java -jar task5.jar the quick brown fox jumps over the lazy dog
```

**Ожидаемый вывод:**

```
the 2
brown 1
dog 1
fox 1
jumps 1
lazy 1
over 1
quick 1
```

**Идея решения:** составной компаратор

```kotlin
compareByDescending<Map.Entry<String, Int>> { it.value }.thenBy { it.key }
```

### Решение

<img width="613" height="118" alt="image" src="https://github.com/user-attachments/assets/9c4d123c-6561-45b4-8c70-a08fdab0cddb" />
<img width="347" height="200" alt="image" src="https://github.com/user-attachments/assets/64007d2f-378b-40c3-b2ca-ffdbfa50b087" />

---

## Задание 6. Чтение из stdin

> Если приложению не передано ни одного аргумента, читать текст из стандартного потока ввода (stdin).

**Примеры запуска — оба дают одинаковый результат:**

```bash
$ echo "the quick brown fox jumps over the lazy dog" | java -jar task6.jar

$ java -jar task6.jar the quick brown fox jumps over the lazy dog
```

**Ожидаемый вывод:**

```
the 2
brown 1
dog 1
fox 1
jumps 1
lazy 1
over 1
quick 1
```

**Идея решения:** если `args.isEmpty()`, читать `System.`in`.bufferedReader().readText()`, иначе - объединить аргументы через пробел. Дальнейшая обработка общая.

### Решение

<img width="610" height="71" alt="image" src="https://github.com/user-attachments/assets/606c8ea4-37a2-490a-9852-f13d7ae90881" />
<img width="354" height="195" alt="image" src="https://github.com/user-attachments/assets/62653f4f-9f1c-4b98-bfe5-8ba08ca75598" />
