#language: ru
@Smoke

Свойство: SM-0001

   Сценарий: Регистрация нового пользователя
#      Дано авторизоваться под Тестовым пользователем с логином "9128553333" и паролем "Qwerty123"
#      Если на "БоковаяПанель" нажать на "Вкладка Договоры"
#      Если на "ВклДоговоры" нажать на "Кнопка {Продолжить заполонение}"
#      То на ВклДоговоры в календаре Календарь-поле дата выдачи выбрать значение 19 "мая" 2003
#      И ожидать 5 секунд

   Перейти на тестовый стенд
   Нажать на форме кнопку {Регистрация}
   В поле Логин(Телефон/Эл.почта) ввести значение ""
   В поле Пароль ввести тестовый пароль: ""
   В поле Повторите пароль - повторить пароль из предыдущего шага
   Нажать на кнопку {Зарегистрироваться}
   Ввести в поле код из письма присланного на почту
   Нажать на кнопку {Подтвердить}
   На приветственном окне нажать на кнопку {Выход}



   Ввести логин
   Ввести пароль
   Нажать на кнопку {Войти}
   Нажать на кнопку {Хорошо}
   Проверить, что присутсвует и доступна для взаимодействия кнопка {Открыть на весь экран}
   Нажать на кнопку {Я согласен}
   Нажать на кнопку {Подключить лицевой счёт}
   Нажать на кнопку {Отмена}
   Нажать на кнопку {Подключить лицевой счёт}
   Проверить, что кнопка {Продолжить} недоступна для взаимодействия
   В Комбобоксе выбрать "Межрегионгаз Волгоград"
   Нажать на кнопку {Продолжить}
   Нажать на кнопку {Назад}
   Нажать на кнопку {Продолжить}
   Проверить, что кнопка {Продолжить} недоступна для взаимодействия
   В поле ввести значение "5300314311"
   Нажать на кнопку {Продолжить}
   Перейти на вкладку Настройки
   Проверить, что в таблице на вкладке Лицевые счета, отображается подключенные счет "Межрегионгаз Волгоград 5300314311"
   На вкладке Настройки -> Лицевые счета, нажать на кнопку {Подключить лицевой счёт}
   Проверить, что кнопка {Продолжить} недоступна для взаимодействия
   В Комбобоксе выбрать "Межрегионгаз Иваново"
   Нажать на кнопку {Продолжить}
   Проверить, что кнопка {Продолжить} недоступна для взаимодействия
   Нажать на кнопку {Назад}
   Нажать на кнопку {Продолжить}
   Нажать на {X}
   На вкладке Настройки -> Лицевые счета, нажать на кнопку {Подключить лицевой счёт}
   В Комбобоксе проверить, что отображается "Межрегионгаз Иваново"
   Нажать на кнопку {Продолжить}
   В поле лицевой счёт ввести значение "1103006-01"
   Нажать на кнопку {Продолжить}
   Перейти на вкладку Настройки
   Проверить, что в таблице на вкладке Лицевые счета, отображается подключенные счет "Межрегионгаз Иваново 1103006-01"
   На Боковой панели, нажать на кнпоку {Добавить лицевой счет}
   Проверить, что кнопка {Продолжить} недоступна для взаимодействия
   В Комбобоксе проверить, что отображается "Межрегионгаз Тверь"
   Нажать на {X}
   На Боковой панели, нажать на кнпоку {Добавить лицевой счет}
   В Комбобоксе проверить, что отображается "Межрегионгаз Иваново"
   Нажать на кнопку {Продолжить}
   Нажать на {X}
   На Боковой панели, нажать на кнпоку {Добавить лицевой счет}
   В Комбобоксе проверить, что отображается "Межрегионгаз Тверь"
   Нажать на кнопку {Продолжить}
   Нажать на кнопку {Назад}
   Нажать на кнопку {Продолжить}
   Проверить, что кнопка {Продолжить} недоступна для взаимодействия
   В поле лицевой счёт ввести значение "10025827"
   Нажать на кнопку {Продолжить}
   Перейти на вкладку Настройки
   Проверить, что в таблице на вкладке Лицевые счета, отображается подключенные счет "Межрегионгаз Тверь 10025827"
   В боковой панели раскрыть весь список подключенных счетов
   Убедиться, что все подключенные счета в тесте присутсвуют


   Доп.действия
   Добавить карту
   Перейти на вкладку настройки
   Перейти на вкладку Карты
   Нажать на символ "Добавить карту"
   В поле номер карты ввести "4268 1070 8338 9256"
   В комбобоксе месяц выбрать значение "12"
   В комбобоксе год выбрать значение "21"
   В поле имя на карте выбрать Smoke + текущая дата
   В поле CVV ввести значение "684"
   Активировать комбобокс "Публичной аферты"
   Нажать на кнопку {Зарегистрировать}





   Выйти из системы





