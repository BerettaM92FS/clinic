CREATE TABLE public.medical_card (
                                     id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
                                     number integer,
                                     patient_id uuid NOT NULL,
                                     doctor_id uuid NOT NULL,
                                     date_add timestamp(6) without time zone,
                                     diagnosis character varying
);


ALTER TABLE public.medical_card OWNER TO postgres;

INSERT INTO public.medical_card (id, number, patient_id, doctor_id, date_add, diagnosis) VALUES ('4d3ae930-15b9-43d4-b3fc-a627f560d4ab', 112, 'b4337fe5-afc8-4263-a33a-15b291cedfa3', 'fa55693e-7d1d-4ad2-9959-fe73a0731858', '2022-10-03 00:00:00', 'Гастрит');
INSERT INTO public.medical_card (id, number, patient_id, doctor_id, date_add, diagnosis) VALUES ('ad6a58ad-a603-484f-989d-a0282ca800f9', 346, 'fede1fcf-a58e-453b-8540-1dcdfd05a355', '2143e406-47f3-4001-b348-1838dee2b56f', '2015-10-16 00:00:00', 'Пролапс митрального клапана');
INSERT INTO public.medical_card (id, number, patient_id, doctor_id, date_add, diagnosis) VALUES ('281faef6-c5cc-43e8-b29f-14471312e002', 250, '289b27ed-109a-4785-b149-fb3d816baa82', 'd5647de9-395d-49c6-9439-cf293160ebc0', '2014-04-13 00:00:00', 'Бронхиальная астма');
INSERT INTO public.medical_card (id, number, patient_id, doctor_id, date_add, diagnosis) VALUES ('88a8450e-0413-4522-857d-8ae01afab37f', 841, 'fc7d65de-470b-4a5a-b37c-a091c9039a0f', 'c7979ccb-737f-481e-a046-96038aceacb2', '2022-02-08 00:00:00', 'Острый фарингит');
INSERT INTO public.medical_card (id, number, patient_id, doctor_id, date_add, diagnosis) VALUES ('9310c9a8-8a8e-46e9-8f91-09cea6efa650', 513, '672239a9-71ca-40ce-a238-0ab8c56c6c6b', '3900bdcc-e4d7-4290-be92-d72640776387', '2018-05-06 00:00:00', 'ОРВИ');
INSERT INTO public.medical_card (id, number, patient_id, doctor_id, date_add, diagnosis) VALUES ('e9ffc6db-2cb2-4905-b310-c39d14baf496', 411, '18671741-d741-4659-b492-5f9f5e3ede25', '5384024c-55e6-47a8-b770-96fdee1b1e75', '2016-02-16 00:00:00', 'Ревматоидный артрит');
INSERT INTO public.medical_card (id, number, patient_id, doctor_id, date_add, diagnosis) VALUES ('1014d5c9-6150-4cbf-83d3-6a57ca282fa5', 336, '1d1fee33-cf70-48a7-afef-ef15c43a0a9a', '4b123985-1996-4f5f-bafa-30aa7c9ad61a', '2017-01-25 00:00:00', 'Тилоз');
INSERT INTO public.medical_card (id, number, patient_id, doctor_id, date_add, diagnosis) VALUES ('300ecad7-9867-47e5-bec6-c11c2198fddc', 917, '44bce3a9-b435-4d01-a611-af7e1b77a0d8', '09ee19e5-94e4-4ac1-b050-14c3e1d1767e', '2019-01-08 00:00:00', 'Анемия');
INSERT INTO public.medical_card (id, number, patient_id, doctor_id, date_add, diagnosis) VALUES ('e8162af6-c7e7-4b5c-ab63-1bf2c591712e', 623, '3f95bce4-25af-4cdd-8b5a-eb7637c6881a', '59943d75-eb02-42a1-98ea-d8d8f284ebed', '2017-01-18 00:00:00', 'Аллергический дерматит');
INSERT INTO public.medical_card (id, number, patient_id, doctor_id, date_add, diagnosis) VALUES ('f9fd3b02-47aa-48fc-9ed8-4d39bd23ae04', 777, 'c2d6de65-006d-40e9-98fe-f89fd786e8a0', 'a9cd0101-3151-4330-982e-f3f58d40455c', '2022-09-13 00:00:00', 'Алалия');

ALTER TABLE ONLY public.medical_card
    ADD CONSTRAINT medical_card_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.medical_card
    ADD CONSTRAINT fk_medical_card_to_patients FOREIGN KEY (patient_id) REFERENCES public.patients(id);

ALTER TABLE ONLY public.medical_card
    ADD CONSTRAINT fk_medical_card_to_doctors FOREIGN KEY (doctor_id) REFERENCES public.doctors(id);