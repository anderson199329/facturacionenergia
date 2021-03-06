PGDMP     *    	    	        
    w            facturacion    11.2    11.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    26361    facturacion    DATABASE     �   CREATE DATABASE facturacion WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Colombia.1252' LC_CTYPE = 'Spanish_Colombia.1252';
    DROP DATABASE facturacion;
             postgres    false                        2615    26362    energia    SCHEMA        CREATE SCHEMA energia;
    DROP SCHEMA energia;
             postgres    false            �            1259    26365    cliente    TABLE     �   CREATE TABLE energia.cliente (
    id integer NOT NULL,
    cc_nit bigint NOT NULL,
    cliente character varying(50) NOT NULL,
    telefono bigint,
    celular bigint,
    estrato integer NOT NULL
);
    DROP TABLE energia.cliente;
       energia         postgres    false    8            �            1259    26363    cliente_id_seq    SEQUENCE     �   CREATE SEQUENCE energia.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE energia.cliente_id_seq;
       energia       postgres    false    8    198            �           0    0    cliente_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE energia.cliente_id_seq OWNED BY energia.cliente.id;
            energia       postgres    false    197            �            1259    34555    factura    TABLE       CREATE TABLE energia.factura (
    id integer NOT NULL,
    numero bigint NOT NULL,
    consumo bigint NOT NULL,
    mes character varying(20) NOT NULL,
    ano integer NOT NULL,
    total_pagar double precision NOT NULL,
    fk_cliente integer NOT NULL
);
    DROP TABLE energia.factura;
       energia         postgres    false    8            �            1259    34553    factura_id_seq    SEQUENCE     �   CREATE SEQUENCE energia.factura_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE energia.factura_id_seq;
       energia       postgres    false    200    8            �           0    0    factura_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE energia.factura_id_seq OWNED BY energia.factura.id;
            energia       postgres    false    199            �            1259    42749    pago    TABLE     �   CREATE TABLE energia.pago (
    id integer NOT NULL,
    fk_factura integer NOT NULL,
    fecha_pago timestamp(6) without time zone NOT NULL
);
    DROP TABLE energia.pago;
       energia         postgres    false    8            �            1259    42747    pago_id_seq    SEQUENCE     �   CREATE SEQUENCE energia.pago_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE energia.pago_id_seq;
       energia       postgres    false    202    8            �           0    0    pago_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE energia.pago_id_seq OWNED BY energia.pago.id;
            energia       postgres    false    201                       2604    26368 
   cliente id    DEFAULT     j   ALTER TABLE ONLY energia.cliente ALTER COLUMN id SET DEFAULT nextval('energia.cliente_id_seq'::regclass);
 :   ALTER TABLE energia.cliente ALTER COLUMN id DROP DEFAULT;
       energia       postgres    false    198    197    198                       2604    34558 
   factura id    DEFAULT     j   ALTER TABLE ONLY energia.factura ALTER COLUMN id SET DEFAULT nextval('energia.factura_id_seq'::regclass);
 :   ALTER TABLE energia.factura ALTER COLUMN id DROP DEFAULT;
       energia       postgres    false    200    199    200                       2604    42752    pago id    DEFAULT     d   ALTER TABLE ONLY energia.pago ALTER COLUMN id SET DEFAULT nextval('energia.pago_id_seq'::regclass);
 7   ALTER TABLE energia.pago ALTER COLUMN id DROP DEFAULT;
       energia       postgres    false    201    202    202            �          0    26365    cliente 
   TABLE DATA               S   COPY energia.cliente (id, cc_nit, cliente, telefono, celular, estrato) FROM stdin;
    energia       postgres    false    198          �          0    34555    factura 
   TABLE DATA               Z   COPY energia.factura (id, numero, consumo, mes, ano, total_pagar, fk_cliente) FROM stdin;
    energia       postgres    false    200   �       �          0    42749    pago 
   TABLE DATA               ;   COPY energia.pago (id, fk_factura, fecha_pago) FROM stdin;
    energia       postgres    false    202          �           0    0    cliente_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('energia.cliente_id_seq', 5, true);
            energia       postgres    false    197            �           0    0    factura_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('energia.factura_id_seq', 4, true);
            energia       postgres    false    199            �           0    0    pago_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('energia.pago_id_seq', 4, true);
            energia       postgres    false    201                       2606    26370    cliente cliente_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY energia.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);
 ?   ALTER TABLE ONLY energia.cliente DROP CONSTRAINT cliente_pkey;
       energia         postgres    false    198            
           2606    34560    factura factura_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY energia.factura
    ADD CONSTRAINT factura_pkey PRIMARY KEY (id);
 ?   ALTER TABLE ONLY energia.factura DROP CONSTRAINT factura_pkey;
       energia         postgres    false    200                       2606    42754    pago pago_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY energia.pago
    ADD CONSTRAINT pago_pkey PRIMARY KEY (id);
 9   ALTER TABLE ONLY energia.pago DROP CONSTRAINT pago_pkey;
       energia         postgres    false    202                       2606    42746    factura uq_numero 
   CONSTRAINT     O   ALTER TABLE ONLY energia.factura
    ADD CONSTRAINT uq_numero UNIQUE (numero);
 <   ALTER TABLE ONLY energia.factura DROP CONSTRAINT uq_numero;
       energia         postgres    false    200                       2606    34561    factura fk_ciente    FK CONSTRAINT     w   ALTER TABLE ONLY energia.factura
    ADD CONSTRAINT fk_ciente FOREIGN KEY (fk_cliente) REFERENCES energia.cliente(id);
 <   ALTER TABLE ONLY energia.factura DROP CONSTRAINT fk_ciente;
       energia       postgres    false    200    198    2056                       2606    42755    pago fk_factura    FK CONSTRAINT     u   ALTER TABLE ONLY energia.pago
    ADD CONSTRAINT fk_factura FOREIGN KEY (fk_factura) REFERENCES energia.factura(id);
 :   ALTER TABLE ONLY energia.pago DROP CONSTRAINT fk_factura;
       energia       postgres    false    200    2058    202            �   �   x��M
�0����=��O&�,��EJI������ap����ːѐ
&X6��O/_k�6��	�(	�q	��,�\���~l}�}������D�� �j�#Ӑ����2�r�P�\��6��0.4����,����a*"h      �   f   x�=��
� ������qtʖ.���z��HZ��c�t�<tD	�a3���0$[�&��kW�]m���:�i�r*�H=��!#v�*�[��/���;�Vi#      �   G   x�Uʱ�@�����,�Z��̲��,BǾ���=Y�mͬ����{�a�Ҕ��=�)����T���L     