# ExamApp

*Веб-приложение, которое будет генерировать вопросы к экзамену.

## **Описание веб-приложения**

Путь пользователя:

1. Пользователь обращается к некому эндпоинту по адресу (”/exam/get/{amount}”)
2. Пользователь получает ответ в виде списка случайных вопросов-ответов, количество которых равно amount из прошлого шага
3. Пользователь должен иметь возможность добавить, получить и удалить вопросы из хранилища вопросов (”/exam/java/(add/remove/find)”)
Внешний интерфейс приложения представлен в виде REST API.

# Бэкенд-часть проекта предполагает реализацию следующего функционала:

1. Реализована сущность Question с двумя полями: question и answer. Данная сущность используется в качестве хранителя данных по вопросу.
    - Архитектура
        
        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/80201e85-0c39-427b-955a-2a2dffa930b0/Untitled.png)
        
2. Интерфейс QuestionService, который содержит в себе все методы по работе с вопросами определенного предмета.
    - Архитектура
        
        ![diagram-17353247503607978677.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a4c0fece-02d6-41f3-bf07-24da115beee9/diagram-17353247503607978677.png)
        
3. Сервис JavaQuestionService, который реализовывает QuestionService и хранит в себе список вопросов по Java, а также осуществляет всю работу с этим списком.
    
    Реализация метода getRandomQuestion осуществляется с помощью класса Random и его метода nextInt, который в качестве параметра принимает максимальное число, а затем возвращает вам результат в виде случайного числа от 0 до максимального числа из параметров (не включительно).
    
    - Архитектура
        
        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b0d0166a-6f2d-41f2-9b00-ad0cb675ea11/Untitled.png)
        
4. Контроллер JavaQuestionController, который предоставляет возможность пользователю добавлять, просматривать и удалять вопросы по Java в соответствующем QuestionService.
    
    Контроллер имеет три метода: добавить, удалить и получить все вопросы.
    
    Эти методы висят на следующих эндпоинтах:
    
    Добавить: “/exam/java/add?question=QuestionText&answer=QuestionAnswer”
    
    Удалить: “/exam/java/remove?question=QuestionText&answer=QuestionAnswer”
    
    Получить все вопросы: “/exam/java”
    
    - Архитектура
        
        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/20e1b4ad-1631-4a4c-8b99-35bcf5c0d247/Untitled.png)
        
5. Интерфейс ExaminerService с одним методом getQuestions.
    
    Этот интерфейс содержит один метод, который вернет список вопросов.
    
    - Архитектура
        
        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/09fcb326-fcd6-4f22-887b-88266928110d/Untitled.png)
        
6. ExaminerServiceImpl, который является реализацией интерфейса ExaminerService. Данный сервис внутри себя хранит поля типа QuestionService.
    
    Его задача: создать коллекцию и заполнить её с помощью вызова getRandomQuestion у QuestionService случайными вопросами. 
    
    Пояснение:
    
    1.  Вопросы - уникальные, следовательно, для получения N вопросов может потребоваться более N вызовов метода getRandomQuestion сервиса вопросов.
    2. Если запрошено большее количество вопросов, чем хранится в сервисе, то выкидывается исключение со статусом BAD_REQUEST.
    - Архитектура
        
        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4cb9d332-c716-4734-9642-22eb2969ea17/Untitled.png)
        
7. Контроллер ExamController с одним методом getQuestions(int amount).
    
    Контроллер обращается к ExaminerService, получает от сервиса коллекцию вопросов и возвращает пользователю.
   
## Использован следующий стек технологий: ##

Веб-приложение выполнено в виде RESTful-сервиса\
Java11\
SpringBoot\
Swagger\
Lombok

*Выполнил задание - [Алексей Петкун](https://github.com/AlekseyPetkun "AlekseyPetkun")*

[![Typing SVG](https://readme-typing-svg.herokuapp.com?color=%2336BCF7&lines=thank+you+for+your+attention)](https://git.io/typing-svg)
