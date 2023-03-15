# Objective
Project created with objective to develop and train the knowledge in Kotlin and Spring Framework. <br>

Development of an internet forum API's.

# Topics
**List all topics**<br>
http://localhost:8080/topics

**Select topic by id** <br>
http://localhost:8080/topics/1

**Return example**
```KOTLIN
// 20230314224601
// http://localhost:8080/topics/3
```

```JSON
{
  "id": 3,
  "titulo": "Qualquer dúvida sobre Kotlin",
  "mensagem": "Como permitir variáveis nulas?",
  "datacriacao": "2023-03-14T23:27:36.7415029",
  "curso": {
    "id": 1,
    "nome": "Kotlin",
    "categoria": "Programação"
  },
  "autor": {
    "id": 1,
    "nome": "Caike Bispo",
    "email": "caike@bispo.com"
  },
  "status": "NAO_RESPONDIDO",
  "respostas": [

  ]
}

```

# Register
**Add new topic** <br>
http://localhost:8080/topics


**Post Body**
```JSON
{
    "title": "Qualquer dúvida sobre Kotlin",
    "message": "Como permitir variáveis nulas?",
    "idCourse": 1,
    "idAuthor": 1
}
```