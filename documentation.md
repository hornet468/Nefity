# Posts API

Base URL: /api/v1/posts

---

## GET /

Опис: Отримати всі пости (GetAllPosts).

Відповідь:
- 200 OK – Список постів
- 401 Unauthorized – Користувач не авторизований
- 500 Internal Server Error – Помилка сервера

---

## POST /add_post

Опис: Додати новий пост (AddPost).

    Запит:
    {
    "title": "You should think more over it",
    "text": "Nice try, however.............",
    "user": {
    "id": 102
    },
    "timestamp": "2025-03-20T19:42:43.530"
    }
Відповідь:
- 200 OK – Повертає створений пост
- 401 Unauthorized – Користувач не авторизований
- 400 Bad Request – Некоректні дані
- 500 Internal Server Error – Помилка сервера

---

## DELETE /delete_post/{id}

Опис: Видалити пост за ID.

Параметри:
    id – ID поста (тип: Long)

    Приклад URL:
    /api/v1/posts/delete_post/1
Відповідь:
- 200 OK – Пост видалено, тіло відповіді порожнє
- 401 Unauthorized – Користувач не авторизований
- 404 Not Found – Пост не знайдено
- 500 Internal Server Error – Помилка сервера

---

## PUT /update_post

Опис: Оновити існуючий пост (UpdatePost).

    Запит:
    {
    "title": "You should think more over it",
    "text": "Nice try, however.............",
    "user": {
    "id": 102
    },
    "timestamp": "2025-03-20T19:42:43.530"
    }
    Відповідь:
- 200 OK – Повертає оновлений пост
- 401 Unauthorized – Користувач не авторизований
- 400 Bad Request – Некоректні дані
- 500 Internal Server Error – Помилка сервера


# UsersInfo  API

Base URL: /api/v1/userinfo

---

## GET /

Опис: Отримати всіх користувачів (GetAllUserInfo).

Відповідь:
- 200 OK – Список користувачів
- 401 Unauthorized – Користувач не авторизований
- 500 Internal Server Error – Помилка сервера

---

## GET /get_by_id/{id}

Опис: Отримати інформацію про користувача за ID (GetUserById).

Параметри:
id – ID користувача (тип: Long)

    Приклад URL:
    /api/v1/userinfo/get_by_id/1
Відповідь:
- 200 OK – Повертає об'єкт користувача
- 401 Unauthorized – Користувач не авторизований
- 404 Not Found – Користувача не знайдено
- 500 Internal Server Error – Помилка сервера

---

## DELETE /delete_user/{id}

Опис: Видалити користувача за ID.

Параметри:
id – ID користувача (тип: Long)

    Приклад URL:
    /api/v1/userinfo/delete_user/1
Відповідь:
- 200 OK – Користувача видалено, тіло відповіді порожнє
- 401 Unauthorized – Користувач не авторизований
- 404 Not Found – Користувача не знайдено
- 500 Internal Server Error – Помилка сервера

---

## PUT /update_userinfo

Опис: Оновити інформацію про користувача (UpdateUserInfo).

    Запит:
     {
        "firstName": "John",
        "lastName": "Doe",
        "nickName": "9q",
        "email": "johndoe@example.com",
        "password": "$2a$10$P0.DHSXwifG2BFRli3qTDuMrR47/ZWSbXxpnS.fwOmrMQQ2YbARri",
        "country": "USA",
        "profilePhoto": "https://example.com/profile.jpg",
        "dateOfBirth": "2000-05-15",
        "categoryProfile": "Technology",
        "age": 24,
    }
Відповідь:
- 200 OK – Повертає оновленого користувача
- 401 Unauthorized – Користувач не авторизований
- 400 Bad Request – Некоректні дані
- 500 Internal Server Error – Помилка сервера


# Likes API

Base URL: /api/v1/likes

---

## GET /

Опис: Отримати всі пости (GetAllPosts).
    
    Запит: /api/v1/likes/{post_id}

Відповідь:
- 200 OK – Список постів
- 401 Unauthorized – Користувач не авторизований
- 500 Internal Server Error – Помилка сервера

---

## POST /add_like

Опис: Додати лайк (AddPost).

    Запит:
    {
        "user": {
        "id": 3
        }
    }

    Шлях:
    /api/v1/likes/{post_id}
Відповідь:
- 200 OK – Повертає like
- 401 Unauthorized – Користувач не авторизований
- 400 Bad Request – Некоректні дані
- 500 Internal Server Error – Помилка сервера

---
