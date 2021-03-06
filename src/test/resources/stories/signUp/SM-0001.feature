#language: ru
@Smoke
Свойство: Регистрация
  Функционал:
      Проверяем:
        1. Возможность зарегистрировать нового пользователя
        2. Наличие полей - ссылок - кнопок на начальном экране.
        3. После [Кода подтверждения] проверяем наличие кнопок и недоступность кнопки {Продолжить} до ввода значения
        4. Подключаем один счёт при регистрации
        5. Подключаем второй счёт через боковую панель
        6. Подключаем третий счёт через вкладку Настройки
        7. Проверяем удаление одного из счетов (и проверяем возможность отказаться от удаления)
        8. Проверка повторной авторизации

  Сценарий: SM-0001 Регистрация нового пользователя

    #Шаг 1.Открыть тестовый стенд
    Дано открыть тестовый стенд
    ## Проверить, что отображается начальное окно авторизации Личного кабинета
    Тогда на "ОкноАвторизации" проверить, что элемент "Окно_авторизации" отображается

    #Шаг 2. Нажать на кнопку {Регистрация}
    Если на "ОкноАвторизации" нажать на "Ссылка_<Регистрация>"
    ##Проверить, что отображается окно регистарции нового пользователя
    Тогда на "ОкноРегистрации" проверить, что элемент "Окно_Регистрации" отображается

    #Шаг 3. Проверить, что присутсвуют поля:
    # - ссылка на возврат на страницу авторизации
    Тогда на "ОкноРегистрации" проверить, что элемент "Ссылка_Войти_в_личный_кабинет" отображается
    # - поля для ввода Телефона или почты
    Тогда на "ОкноРегистрации" проверить, что элемент "Поле_Логин_Телефон/Эл.почта" отображается
    # - поле для ввода пароля
    Тогда на "ОкноРегистрации" проверить, что элемент "Поле_Пароль" отображается
    # - поле для повторного ввода пароля
    Тогда на "ОкноРегистрации" проверить, что элемент "Поле_Повторите_пароль" отображается
    # - кнопка {зарегистрировать}
    Тогда на "ОкноРегистрации" проверить, что элемент "Кнопка_Зарегистрироваться" отображается
    # - ссылка <Задать вопрос в техническую поддержку>
    Тогда на "ОкноРегистрации" проверить, что элемент "Ссылка_Задать_вопрос_в_техническую_поддержку" отображается

    #Шаг 5. Сгенерировать случайный почтовый ящик и пароль, заполнить все поля на форме регистрации
    К тому же создать тестового пользователя и заполнить поля Регистрации валидными данными

    #Шаг 6. Нажать на кнопку {Зарегистрироваться}
    Если на "ОкноРегистрации" нажать на "Кнопка_Зарегистрироваться"
    #Проверить, что окно с полем для Кода Подтверждения отображается
    Тогда на "МОкноКодПодтверждения" проверить, что элемент "МОкно с полем для кода подтверждения" отображается

    #Шаг 7. В поле код подтверждения ввести код из письма
    И в поле Код подтверждения ввести код из письма

    #Шаг 8. Нажать на кнопку {Подтвердить}
    Если на "МОкноКодПодтверждения" нажать на "Кнопка Подтвердить"

    #Шаг 9. Нажать на кнопку {Выход}
    Если на "ОкнаПослеРегистрации" нажать на "Кнопка_Выход"

    #Шаг 10. Повторно авторизоваться под сгенерированным пользователем
    То повторно авторизоваться под сгенерированным пользователем
    Если на "ОкноАвторизации" нажать на "Кнопка_входа_в_личный_кабинет"
    # проверить, что отображается окно с "Привет ... " и кнопками {Выход}{Хорошо}
    Тогда на "ОкнаПослеРегистрации" проверить, что элемент "Окно_с_надписью_ПРИВЕТ" отображается
    Тогда на "ОкнаПослеРегистрации" проверить, что элемент "Кнопка_Выход" отображается

    #Шаг 9. Нажать на кнопку {Хорошо}
    Если на "ОкнаПослеРегистрации" нажать на "Кнопка_Хорошо"
    # проверить, что отображается окно с Условиями для пользователя кнопками {расширить на весь экран} и {Я согласен}
    Тогда на "ОкнаПослеРегистрации" проверить, что элемент "Окно_ознакомления_с_условиями" отображается
    Тогда на "ОкнаПослеРегистрации" проверить, что элемент "Кнопка_открыть_на_весь_экран" отображается

    #Шаг 10. Нажать на кнопку {Я согласен}
    Если на "ОкнаПослеРегистрации" нажать на "Кнопка_я_согласен"
    # проверить, что отображается окно Выбора как подключить счета с кнопками {Подключить лицевой счет} и {Заявка на подключение}
    Тогда на "ОкнаПослеРегистрации" проверить, что элемент "Окно_подключить_счет" отображается
    Тогда на "ОкнаПослеРегистрации" проверить, что элемент "Кнопка_Подключить_лицевой_счет" отображается
    Тогда на "ОкнаПослеРегистрации" проверить, что элемент "Кнопка_заявка_на_подключение" отображается

    #Шаг 11. Нажать на кнопку {Подключить лицевой счет}
    Если на "ОкнаПослеРегистрации" нажать на "Кнопка_Подключить_лицевой_счет"
    # проверить, что на поле отображается кнопка {Продолжить} и она заблокированна
    Тогда на "ОкнаПослеРегистрации" проверить, что элемент "Кнопка_продолжить_заблокированная" отображается

    #Шаг 12. В комбобоксе [Выберите ресурсоснабжающую организацию] ввести значение "Межрегионгаз Воронеж"
    Если на "ОкнаПослеРегистрации" нажать на "Комбобокс_Выберите_ресурсоснабжающую_организацию"
    И на "ОкнаПослеРегистрации" в поле "Поле_Выберите_ресурсоснабжающую_организацию" ввести текст "Межрегионгаз Воронеж"
    Если на "ОкнаПослеРегистрации" нажать на "Текст Какая региональная газовая компания Вас обслуживает?"

    #Шаг 13. Нажать на кнопку {Продолжить}
    Если на "ОкнаПослеРегистрации" нажать на "Кнопка_продолжить"
    # проверить, что на поле отображается кнопка {Продолжить} и она заблокированна
    Тогда на "ОкнаПослеРегистрации" проверить, что элемент "Кнопка_продолжить_заблокированная" отображается

    #Шаг 14. В поле [Введите номер счета] ввести значение "3600008314"
    То на "ОкнаПослеРегистрации" в поле "Поле_введите_номер_счета" ввести текст "3600008314"

    #Шаг 15. Нажать на кнопку {Продолжить}
    Если на "ОкнаПослеРегистрации" нажать на "Кнопка_продолжить"
    # проверить, что отображается главная страница Личного кабинета
    Тогда на "БоковаяПанель" проверить, что элемент "Вкладка Лицевой счёт" отображается
    Тогда на "БоковаяПанель" проверить, что элемент "Вкладка Карта отделений" отображается
    Тогда на "БоковаяПанель" проверить, что элемент "Вкладка Договоры" отображается
    Тогда на "БоковаяПанель" проверить, что элемент "Вкладка Настройки" отображается
    Тогда на "БоковаяПанель" проверить, что элемент "Вкладка Техническая поддержка" отображается

    #Шаг 16. На боковой панели нажать на кнопку {Добавить лицевой счёт}
    Если на "БоковаяПанель" нажать на "Кнопка {Добавить лицевой счет}"

    #Шаг 17 В комбобоксе [Выберите ресурсоснабжающую организацию] ввести значение "Межрегионгаз Волгоград"
    Если на "ОкнаПослеРегистрации" нажать на "Комбобокс_Выберите_ресурсоснабжающую_организацию"
    И на "ОкнаПослеРегистрации" в поле "Поле_Выберите_ресурсоснабжающую_организацию" ввести текст "Межрегионгаз Волгоград"
    Если на "ОкнаПослеРегистрации" нажать на "Текст Какая региональная газовая компания Вас обслуживает?"

    #Шаг 18. Нажать на кнопку {Продолжить}
    Если на "ОкнаПослеРегистрации" нажать на "Кнопка_продолжить"

    #Шаг 19. В поле [Введите номер счета] ввести значение "5300309475" и нажать на кнопку {Продолжить}
    То на "ОкнаПослеРегистрации" в поле "Поле_введите_номер_счета" ввести текст "5300309475"
    Если на "ОкнаПослеРегистрации" нажать на "Кнопка_продолжить"

    #Шаг 20. Перейти на вкладку Настройки в боковой панели
    Если на "БоковаяПанель" нажать на "Вкладка Настройки"

    #Шаг 21. На вложенной вкладке (лицевые счета) нажать на кнопку {Подключить лицевой счёт}
    Если на "ВклНастройки" нажать на "Кнопка Подключить Лицевой Счет"

    #Шаг 22 В комбобоксе [Выберите ресурсоснабжающую организацию] ввести значение "Межрегионгаз Волгоград"
    Если на "ОкнаПослеРегистрации" нажать на "Комбобокс_Выберите_ресурсоснабжающую_организацию"
    И на "ОкнаПослеРегистрации" в поле "Поле_Выберите_ресурсоснабжающую_организацию" ввести текст "Межрегионгаз Волгоград"
    Если на "ОкнаПослеРегистрации" нажать на "Текст Какая региональная газовая компания Вас обслуживает?"

    #Шаг 23. Нажать на кнопку {Продолжить}
    Если на "ОкнаПослеРегистрации" нажать на "Кнопка_продолжить"

    #Шаг 24. В поле [Введите номер счета] ввести значение "5300320764"и нажать на кнопку {Продолжить}
    То на "ОкнаПослеРегистрации" в поле "Поле_введите_номер_счета" ввести текст "5300320764"
    Если на "ОкнаПослеРегистрации" нажать на "Кнопка_продолжить"

    #Шаг 25. Перейти на вкладку Настройки в боковой панели
    Если на "БоковаяПанель" нажать на "Вкладка Настройки"

    #Шаг 26. Проверить, что все подключенные счета отображаются на вкладке Настройки
    Тогда на вклНастройки в таблице проверить, что содержится счёт: "3600008314"
    Тогда на вклНастройки в таблице проверить, что содержится счёт: "5300309475"
    Тогда на вклНастройки в таблице проверить, что содержится счёт: "5300320764"

    #Шаг 27. На вложенной вкладке (лицевые счета) удалить подключенный счёт "5300309475"
    Если на вклНастройки отключить Счет: "5300309475"

    #Шаг 28. Проверить, что отключенный счёт не отображается в таблице
    Тогда на вклНастройки проверить, что лицевой счет: "5300309475" - НЕ отображается

