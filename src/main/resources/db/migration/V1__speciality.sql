CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;

CREATE TABLE IF NOT EXISTS public.speciality (
                                                 id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
                                                 name character varying(50)
);

ALTER TABLE public.speciality OWNER TO postgres;

ALTER TABLE ONLY public.speciality
    ADD CONSTRAINT speciality_pkey PRIMARY KEY (id);

INSERT INTO public.speciality (id, name) VALUES ('a4dda15f-4e29-43bf-939b-e2cf51835aca', 'Аллерголог');
INSERT INTO public.speciality (id, name) VALUES ('22a5092f-1710-4db9-9432-fca040c8dfe2', 'Венеролог');
INSERT INTO public.speciality (id, name) VALUES ('9f060f3f-a494-4af4-91a7-6ac517d47d7b', 'Вирусолог');
INSERT INTO public.speciality (id, name) VALUES ('113792d8-dd8e-4dfd-a650-73bda80e91b9', 'Гастроэнтеролог');
INSERT INTO public.speciality (id, name) VALUES ('c762d7e0-3166-4f3f-8415-374953489f7a', 'Гематолог');
INSERT INTO public.speciality (id, name) VALUES ('3f7ecf7d-a813-4f6d-9090-346be0e78bcb', 'Гинеколог');
INSERT INTO public.speciality (id, name) VALUES ('5819d552-48ec-48be-95d2-5cbd006bcb56', 'Дерматолог');
INSERT INTO public.speciality (id, name) VALUES ('106fad16-0cc8-4afc-a187-cfda3e5ef4c9', 'Диабетолог');
INSERT INTO public.speciality (id, name) VALUES ('98ea6c24-31d3-4ef2-a140-2eb121cedb2f', 'Диетолог');
INSERT INTO public.speciality (id, name) VALUES ('30f7684d-4448-4568-950d-850324066e4f', 'Иммунолог');
INSERT INTO public.speciality (id, name) VALUES ('4455f9ad-b3ba-47bb-bf2d-16c9df3a98e6', 'Кардиолог');
INSERT INTO public.speciality (id, name) VALUES ('d4fb8674-cd21-42fb-945c-f2f8d8d9f54e', 'Кардиохирург');
INSERT INTO public.speciality (id, name) VALUES ('7c968fc0-6c34-4ca2-b8bf-43d990f7f6f3', 'Логопед');
INSERT INTO public.speciality (id, name) VALUES ('ea7d075d-dd77-400d-be9f-9cab0c3059fa', 'Маммолог');
INSERT INTO public.speciality (id, name) VALUES ('962a0c5a-5069-4a0d-93c5-65553a45fca5', 'Нарколог');
INSERT INTO public.speciality (id, name) VALUES ('eb399077-c483-4900-a996-66cdcd27d1ed', 'Нейрохирург');
INSERT INTO public.speciality (id, name) VALUES ('36676331-08c3-4f09-8b36-5850eefdd47b', 'Окулист');
INSERT INTO public.speciality (id, name) VALUES ('0e065110-7380-4cf7-8f9d-420c2ce773ae', 'Онколог');
INSERT INTO public.speciality (id, name) VALUES ('a15d1683-38ba-4b49-8679-453da42991cd', 'Ортопед');
INSERT INTO public.speciality (id, name) VALUES ('2933ee2f-8b10-4be3-bacc-4acea8c267b6', 'Отоларинголог');
INSERT INTO public.speciality (id, name) VALUES ('320ba4de-6a09-4b3b-876c-5bb6a3a40f9f', 'Паразитолог');
INSERT INTO public.speciality (id, name) VALUES ('86785568-3e1d-4ef7-b916-d3b35394c31f', 'Пластический хирург');
INSERT INTO public.speciality (id, name) VALUES ('ea548561-e407-4dfe-9c22-f1c374579882', 'Психиатр');
INSERT INTO public.speciality (id, name) VALUES ('7a66b902-b16a-4137-be3c-18bf312a4d0d', 'Психолог');
INSERT INTO public.speciality (id, name) VALUES ('3ec350ea-88e0-4b36-8f0b-bd125622094f', 'Психотерапевт');
INSERT INTO public.speciality (id, name) VALUES ('735dddf0-26aa-442b-b27a-adb8b1982357', 'Радиолог');
INSERT INTO public.speciality (id, name) VALUES ('2482bd7a-f72a-4af6-93eb-7278064a1626', 'Реабилитолог');
INSERT INTO public.speciality (id, name) VALUES ('ffe8add0-9fe3-4806-9b3a-e88716419be5', 'Ревматолог');
INSERT INTO public.speciality (id, name) VALUES ('f2b8500b-4aa4-4882-9dfc-34af2a6ec124', 'Рентгенолог');
INSERT INTO public.speciality (id, name) VALUES ('fae0b1fa-995a-4681-ae6f-1182358b845f', 'Стоматолог');
INSERT INTO public.speciality (id, name) VALUES ('f46ccfaf-7e1a-4db0-8896-94b43323cdcc', 'Терапевт');
INSERT INTO public.speciality (id, name) VALUES ('bbcdfea7-1205-4f87-af5e-038e891c5dd5', 'Токсиколог');
INSERT INTO public.speciality (id, name) VALUES ('0ee7b824-e94d-4415-a673-95e0ddcff8ca', 'Уролог');
INSERT INTO public.speciality (id, name) VALUES ('4e69438e-abd7-4bbb-a79c-f446e38b186c', 'Фармаколог');
INSERT INTO public.speciality (id, name) VALUES ('dbfbb21a-f9d9-4fea-9e6b-322a0a60f4e6', 'Физиотерапевт');
INSERT INTO public.speciality (id, name) VALUES ('14293985-e53f-4847-b117-dec179050b77', 'Химиотерапевт');
INSERT INTO public.speciality (id, name) VALUES ('277a1cab-ebd2-4a68-98ec-8b789609e8e3', 'Хирург');
INSERT INTO public.speciality (id, name) VALUES ('7e3d17da-6335-4d9d-9889-dfd8357df528', 'Эпидемиолог');
INSERT INTO public.speciality (id, name) VALUES ('eb2a5574-5680-4d68-abcc-c841510a7a12', 'Трансплантолог');