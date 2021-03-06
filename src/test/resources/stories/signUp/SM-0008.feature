#language: ru

Свойство: SM-0008

   Сценарий: Возможность редактировать профиль, смена логина и пароля
      И открыть тестовый стенд
      Если на "ОкноАвторизации" нажать на "Ссылка_<Регистрация>"
      К тому же создать тестового пользователя и заполнить поля Регистрации валидными данными
      Если на "ОкноРегистрации" нажать на "Кнопка_Зарегистрироваться"
      И в поле Код подтверждения ввести код из письма
      Если на "МОкноКодПодтверждения" нажать на "Кнопка Подтвердить"
      Если на "ОкнаПослеРегистрации" нажать на "Кнопка_Хорошо"
      Если на "ОкнаПослеРегистрации" нажать на "Кнопка_я_согласен"
      Если на "ОкнаПослеРегистрации" нажать на "Кнопка_Подключить_лицевой_счет"
      Если на "ОкнаПослеРегистрации" нажать на "Комбобокс_Выберите_ресурсоснабжающую_организацию"
      И на "ОкнаПослеРегистрации" в поле "Поле_Выберите_ресурсоснабжающую_организацию" ввести текст "Межрегионгаз Воронеж"
      Если на "ОкнаПослеРегистрации" нажать на "Текст Какая региональная газовая компания Вас обслуживает?"
      Если на "ОкнаПослеРегистрации" нажать на "Кнопка_продолжить"
      То на "ОкнаПослеРегистрации" в поле "Поле_введите_номер_счета" ввести текст "3600008314"
      Если на "ОкнаПослеРегистрации" нажать на "Кнопка_продолжить"
      Если на "БоковаяПанель" нажать на "Вкладка Настройки"
      Если на "ВклНастройки" нажать на "вкладка Профиль"
      Если на "ВклНастройки" нажать на "Кнопка  {сменить Логин}"
      И проверить, что элемент с текстом "После смены логина вход в личный кабинет необходимо осуществлять по новому логину." отображается
      Затем сгенерировать тестовую почту
      То на странице смены логина заполнить поля сгенерированным новым почтовым ящиком и старым паролем
      И на "ВклНастройки" нажать на "Кнопка Изменить логин"
      И ожидать 3 секунд
      Тогда в поле Код ввести последнее значение из письма
      Если на "МОкноКодПодтверждения" нажать на "Кнопка Подтвердить"
      И проверить, что элемент с текстом "Ваш логин изменен!" отображается
      И на "ОбщиеЭлементы" нажать на "кнопка {Закрыть}"
      И выйти из системы
      Затем повторно авторизоваться под сгенерированным пользователем
      Если на "ОкноАвторизации" нажать на "Кнопка_входа_в_личный_кабинет"
      Тогда на "БоковаяПанель" проверить, что элемент "Вкладка Лицевой счёт" отображается
      Тогда на "БоковаяПанель" проверить, что элемент "Вкладка Карта отделений" отображается
      Тогда на "БоковаяПанель" проверить, что элемент "Вкладка Договоры" отображается
      Тогда на "БоковаяПанель" проверить, что элемент "Вкладка Настройки" отображается
      Тогда на "БоковаяПанель" проверить, что элемент "Вкладка Техническая поддержка" отображается
      Если на "БоковаяПанель" нажать на "Вкладка Настройки"
      Если на "ВклНастройки" нажать на "вкладка Профиль"
      Если на "ВклНастройки" нажать на "Кнопка  {сменить Пароль}"
      И на странице смены пароля заполнить поля новым паролем и ввести для подтверждения старый
      И на "ОбщиеЭлементы" нажать на "кнопка {Сохранить}"
      И ожидать 3 секунд
      Тогда в поле Код ввести последнее значение из письма
      Если на "МОкноКодПодтверждения" нажать на "Кнопка Подтвердить"
      И проверить, что элемент с текстом "Ваш пароль изменен!" отображается
      И на "ОбщиеЭлементы" нажать на "кнопка {Закрыть}"
      И выйти из системы
      Затем повторно авторизоваться под сгенерированным пользователем
      Если на "ОкноАвторизации" нажать на "Кнопка_входа_в_личный_кабинет"
      Тогда на "БоковаяПанель" проверить, что элемент "Вкладка Лицевой счёт" отображается
      Тогда на "БоковаяПанель" проверить, что элемент "Вкладка Карта отделений" отображается
      Тогда на "БоковаяПанель" проверить, что элемент "Вкладка Договоры" отображается
      Тогда на "БоковаяПанель" проверить, что элемент "Вкладка Настройки" отображается
      Тогда на "БоковаяПанель" проверить, что элемент "Вкладка Техническая поддержка" отображается
