#language: ru

Свойство: SM-0007

   Сценарий: Возможность переименовать счёт и отключить

      И открыть тестовый стенд
      Затем авторизоваться под Тестовым пользователем с логином "forsm0007@sanizr.com" и паролем "Qwerty123"
      Если на "БоковаяПанель" нажать на "Вкладка Настройки"
      То на вклНастройки в таблице нажать на кнопку "Переименовать" у счёта "5300309475"
      Если проверить, что элемент с текстом "ЛС №5300309475" отображается

      И на "ВклНастройки" очистить поле "Поле для ввода Нового имени счёта", если оно заполненно
      То на "ВклНастройки" в поле "Поле для ввода Нового имени счёта" ввести текст "Проверка возможности дать имя карте"
      И на "ВклНастройки" нажать на "Кнопка {Сохранить}"
      Если проверить, что элемент с текстом "Проверка возможности дать имя карте (5300309475)" отображается

      К тому же на "БоковаяПанель" проверить, что в поле "Описание активного счёта", отображается значение "Проверка возможности дать имя карте"

      То на вклНастройки в таблице нажать на кнопку "Переименовать" у счёта "5300309475"
      Если проверить, что элемент с текстом "ЛС №5300309475" отображается
      И на "ВклНастройки" очистить поле "Поле для ввода Нового имени счёта", если оно заполненно
      И на "ВклНастройки" нажать на "Кнопка {Сохранить}"
      Если проверить, что элемент с текстом "5300309475" отображается

      К тому же на "БоковаяПанель" проверить, что в поле "Описание активного счёта", отображается значение "400131, Волгоградская обл, Волгоград г., р-н Центральный, ул. ЧУЙКОВА МАРШАЛА, д. 33, кв. 6"

