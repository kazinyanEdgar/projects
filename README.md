# Projects

## Предварительные условия
Я использовал MySQL. Чтобы поменять на PostgreSQL, нужно подключить соответствующую dependency в 
**pom.xml** и изменить properties в **application.properties**. Таблицы и их связи автоматически
создадутся при запуске приложения. Выполнять следующую команду по обновлению
нужно из папки, где находится файл **params.txt** (данный файл со строкой **project1**
я уже создал в проекте).

*>curl -T params.txt localhost:8080/api/projects/1*

В противном случае нужно будет также прописать путь
к этому файлу.

## Запуск
* В командной строке перейти в папку проекта
(где присутствует файл **pom.xml**) и выполнить команду

*>mvn spring-boot:run*

Затем, не закрывая эту командную строку, открыть другую командную строку и проверить
работоспособность приложения с помощью утилиты curl