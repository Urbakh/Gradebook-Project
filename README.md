# Gradebook
Журнал оценок, который взаимодействует с БД Postgres на языке Java с использованием фреймворка Spring Boot.

API:

Для студента:

`GET/student` - возвращает список студентов:                                
```json
[
    {
        "id": 21,
        "name": "Ваня",
        "lastName": "Сидоров"
    },
    {
        "id": 22,
        "name": "Александр",
        "lastName": "Волков"
    },
    {
        "id": 23,
        "name": "Иван",
        "lastName": "Иванов"
    }
]
```
`GET/student/{id}` - получить студента по id:
```json
{
    "id": 21,
    "name": "Ваня",
    "lastName": "Сидоров"
}
```

`POST/student` - создать в базе студента:
```json
Принимает JSON:

{
    "name": "Иван",
    "lastName": "Иванов"
}

Возвращает JSON:

{
    "id": 24,
    "name": "Иван",
    "lastName": "Иванов"
}
```

`PUT/student/{id}` - изменение данных студента по id:
```json
Принимает JSON:

{
    "name": "Дмитрий",
    "lastName": "Иванов"
}

Возвращает JSON:

{
    "id": 24,
    "name": "Дмитрий",
    "lastName": "Иванов"
}
```

`DELETE/student/{id}` - удалить данные о студенте по id.


Для журнала:

`GET/journal` - возвращает список журналов:
```json
[
    {
        "id": 25,
        "schoolItems": "Философия",
        "grade": 4,
        "date": "25.11.2021",
        "studentId": 21
    },
    {
        "id": 26,
        "schoolItems": "История",
        "grade": 4,
        "date": "25.11.2021",
        "studentId": 21
    },
    {
        "id": 27,
        "schoolItems": "Музыка",
        "grade": 4,
        "date": "25.11.2021",
        "studentId": 21
    }
] 
```

`GET/journal/{id}` - получить журнал по id:
```json
{
    "id": 27,
    "schoolItems": "Музыка",
    "grade": 4,
    "date": "25.11.2021",
    "studentId": 21
}
```

`GET/journal/student/{studentId}` - получить все записи в журнале по id студента:
```json
[
    {
        "id": 25,
        "schoolItems": "Философия",
        "grade": 4,
        "date": "25.11.2021",
        "studentId": 21
    },
    {
        "id": 26,
        "schoolItems": "История",
        "grade": 4,
        "date": "25.11.2021",
        "studentId": 21
    },
    {
        "id": 27,
        "schoolItems": "Музыка",
        "grade": 4,
        "date": "25.11.2021",
        "studentId": 21
    }
]
```

`POST/journal` - создать в базе журнал:
```json
Принимает JSON:

{
    "schoolItems": "Музыка",
    "grade": 4,
    "date": "25.11.2021",
    "studentId": 21
}

Возвращает JSON:

{
    "id": 31,
    "schoolItems": "Музыка",
    "grade": 4,
    "date": "25.11.2021",
    "studentId": 21
}
```

`PUT/journal/{id}` - изменение данных журнала по id:
```json
Принимает JSON:

{
    "schoolItems": "Литература",
    "grade": 5,
    "date": "25.11.2021",
    "studentId": 21
}

Возвращает JSON:

{
    "id": 31,
    "schoolItems": "Литература",
    "grade": 5,
    "date": "25.11.2021",
    "studentId": 21
}
```

`DELETE/journal/{id}` - удалить данные журнала по id.


P.S. 
DELETE метод у студента реализован таким образом, что при обнаружении в журнале записей об удаляемом студенте, сначала удалятся данные из журнала, хранящиеся о студенте, после чего будет удален сам студент. 
