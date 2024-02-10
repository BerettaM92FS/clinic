CREATE TABLE public.patients (
                                 id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
                                 fio character varying(150),
                                 date_birth date,
                                 phone character varying(20),
                                 passport character varying(20),
                                 address character varying
);


ALTER TABLE public.patients OWNER TO postgres;

INSERT INTO public.patients (id, fio, date_birth, phone, passport, address) VALUES ('b4337fe5-afc8-4263-a33a-15b291cedfa3', 'Пастухов Александр Сергеевич', '1969-07-22', '7(8793)114-11-16', '4623 150784', 'Россия, г. Новороссийск, Восточная ул., д. 6 кв.59');
INSERT INTO public.patients (id, fio, date_birth, phone, passport, address) VALUES ('fede1fcf-a58e-453b-8540-1dcdfd05a355', 'Федорова Анастасия Андреевна', '1996-05-15', '7(8793)000-04-82', '4891 846667', 'Россия, г. Чебоксары, Озерный пер., д. 15 кв.42');
INSERT INTO public.patients (id, fio, date_birth, phone, passport, address) VALUES ('289b27ed-109a-4785-b149-fb3d816baa82', 'Михайлов Николай Никитич', '2002-05-12', '7(8793)519-69-12', '4017 415142', 'Россия, г. Новошахтинск, Центральная ул., д. 13 кв.50');
INSERT INTO public.patients (id, fio, date_birth, phone, passport, address) VALUES ('fc7d65de-470b-4a5a-b37c-a091c9039a0f', 'Соловьев Фёдор Саввич', '1942-04-20', '7(8793)200-95-11', '4954 186147', 'Россия, г. Кызыл, Южная ул., д. 16 кв.148');
INSERT INTO public.patients (id, fio, date_birth, phone, passport, address) VALUES ('672239a9-71ca-40ce-a238-0ab8c56c6c6b', 'Михайлова Агния Кирилловна', '1987-04-03', '7(8793)996-50-81', '4855 358594', 'Россия, г. Южно-Сахалинск, Ленина ул., д. 3 кв.140');
INSERT INTO public.patients (id, fio, date_birth, phone, passport, address) VALUES ('18671741-d741-4659-b492-5f9f5e3ede25', 'Климов Илья Тимофеевич', '1994-01-19', '7(8793)402-25-01', '4736 680035', 'Россия, г. Барнаул, Садовая ул., д. 16 кв.29');
INSERT INTO public.patients (id, fio, date_birth, phone, passport, address) VALUES ('1d1fee33-cf70-48a7-afef-ef15c43a0a9a', 'Блинова Ксения Дмитриевна', '1944-04-27', '7(8793)532-75-99', '4817 321809', 'Россия, г. Дзержинск, Вокзальная ул., д. 25 кв.25');
INSERT INTO public.patients (id, fio, date_birth, phone, passport, address) VALUES ('44bce3a9-b435-4d01-a611-af7e1b77a0d8', 'Гуляева Анастасия Данисовна', '1967-02-25', '7(8793)948-44-00', '4886 425832', 'Россия, г. Серпухов, Рабочая ул., д. 15 кв.177');
INSERT INTO public.patients (id, fio, date_birth, phone, passport, address) VALUES ('3f95bce4-25af-4cdd-8b5a-eb7637c6881a', 'Григорьева Анна Тимуровна', '1939-12-11', '7(8793)157-64-64', '4864 636424', 'Россия, г. Петрозаводск, Солнечный пер., д. 5 кв.24');
INSERT INTO public.patients (id, fio, date_birth, phone, passport, address) VALUES ('c2d6de65-006d-40e9-98fe-f89fd786e8a0', 'Масленникова Василиса Никитична', '2010-04-26', '7(8793)400-19-38', '4711 927576', 'Россия, г. Саратов, Вишневая ул., д. 9 кв.178');

ALTER TABLE ONLY public.patients
    ADD CONSTRAINT patients_pkey PRIMARY KEY (id);
