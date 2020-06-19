Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: scenario description
Given авторизоваться под Тестовым пользователем с логином 9128553333 и паролем Qwerty123
Then на "БоковаяПанель" нажать на "Вкладка Договоры"
Then на "ВклДоговоры" нажать на "Кнопка {Продолжить заполонение}"
Then на "ВклДоговоры" в календаре "Календарь-поле дата выдачи" выбрать дату в формате "19 мая 2003"
Then ожидать "100000"
