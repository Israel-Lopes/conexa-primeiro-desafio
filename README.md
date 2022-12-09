# Primeiro projeto

### Requesitos

 - java version: 17
 - lombok
 - SDK: graalvm-ce-17

### Configuração do projeto

OBS: Caso o projeto seja aberto no Intellij, basta clickar na renderização logo ao lado.


```mvn compile install```

<br />

Depois basta acessar ***https://localhost:8080***

### O que foi feito

[regras do desafio](https://www.psicologiaviva.com.br/desafios/backend.html)


De acordo com a especificação do desafio, deve retornar da api,
todos os filmes em que o persogame Luke SkyWalker participou de filmes.

Esses filmes podem ser acessos no seguinte caminho ***https://localhost:8080\sky***

Todas regras de negocio que foram colocadas ficaram restritas na camada de serviço. Podem ser encontradas
em ***MovieLukeSkyWalker.java***.

Exemplo do retorno:

***/sky***
```
[
  {
    "title": "A New Hope",
    "director": "George Lucas",
    "episode_id": 4,
    "release_date": "1977-05-25"
  },
  {
    "title": "The Empire Strikes Back",
    "director": "Irvin Kershner",
    "episode_id": 5,
    "release_date": "1980-05-17"
  },
  {
    "title": "Return of the Jedi",
    "director": "Richard Marquand",
    "episode_id": 6,
    "release_date": "1983-05-25"
  },
  {
    "title": "Revenge of the Sith",
    "director": "George Lucas",
    "episode_id": 3,
    "release_date": "2005-05-19"
  }
]
```


 
