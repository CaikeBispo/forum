# Objective
* Project created with objective to develop and train knowledges in Kotlin and Spring Framework. <br>
* Development of an internet forum APIs.

# Topics

* **DELETE BY ID** <br>


* **CHANGE BY ID** <br>
asd

* **REGISTER NEW** <br>
http://localhost:8080/topics

    **HTTP POST Body**
    ```JSON
    {
        "title": "Qualquer dúvida sobre Kotlin",
        "message": "Como permitir variáveis nulas?",
        "idCourse": 1,
        "idAuthor": 1
    }
    ```

* **LIST ALL**<br>
http://localhost:8080/topics

* **SELECT BY ID** <br>
http://localhost:8080/topics/1 <br><br>

    **HTTP RESPONSE**
    ```KOTLIN
    // 20230314224601
    // http://localhost:8080/topics/3
    ```

  ```JSON
  [
    {
        "id": 1,
        "title": "Qualquer dúvida sobre Kotlin",
        "message": "Como permitir variáveis nulas?",
        "status": "NAO_RESPONDIDO",
        "dateCriation": "2023-03-15T23:28:16.8909937"
    },
    {
        "id": 2,
        "title": "Qualquer dúvida sobre Java",
        "message": "Como permitir variáveis nulas?",
        "status": "NAO_RESPONDIDO",
        "dateCriation": "2023-03-15T23:28:37.8183158"
    },
    {
        "id": 3,
        "title": "Qualquer dúvida sobre C",
        "message": "Como permitir variáveis nulas?",
        "status": "NAO_RESPONDIDO",
        "dateCriation": "2023-03-15T23:28:40.667184"
    }
  ]
```

