
    alter table address 
        drop 
        foreign key FK_7rod8a71yep5vxasb0ms3osbg;

    alter table eligibility_detail 
        drop 
        foreign key FK_mmkxmdmf6j6q909qyhwlkh9c5;

    alter table eligibility_detail 
        drop 
        foreign key FK_17844b31cqpyah1sy35c2dr0i;

    alter table eligibility_detail 
        drop 
        foreign key FK_2qhgrlgnbo7xavgt4vmj6ryga;

    alter table loan 
        drop 
        foreign key FK_7fqsqytb3q3k9c59covd8k6be;

    alter table loan 
        drop 
        foreign key FK_snp5j1a5kw8r7f2kv1pxu9hp0;

    alter table loan_detail 
        drop 
        foreign key FK_jkcdr297pjgiwphshvvcc9o9m;

    alter table loan_detail 
        drop 
        foreign key FK_nldfgvebqgxl0dsllgbv9nh4m;

    alter table loan_detail 
        drop 
        foreign key FK_cm0togw4b1iuq87l5w51rj04n;

    alter table loan_detail 
        drop 
        foreign key FK_nldfgvebqgxl0dsllgbv9nh4m;

    alter table payment 
        drop 
        foreign key FK_nseeiepn7ybuegosvbmhxa4iu;

    alter table payment 
        drop 
        foreign key FK_ctvskou1xh26obtbvta4d2o4l;

    alter table user_role 
        drop 
        foreign key FK_it77eq964jhfqtu54081ebtio;

    alter table user_role 
        drop 
        foreign key FK_apcc8lxk2xnug8377fatvbn04;

    alter table vehicle_model 
        drop 
        foreign key FK_oi0jtje8fhtho7e141w69q58x;

    alter table vehicle_model 
        drop 
        foreign key FK_blcifx8427v63xg2jtrc9dy4d;

    drop table if exists address;

    drop table if exists app_user;

    drop table if exists company_detail;

    drop table if exists eligibility_detail;

    drop table if exists loan;

    drop table if exists loan_detail;

    drop table if exists payment;

    drop table if exists role;

    drop table if exists user_role;

    drop table if exists vehicle;

    drop table if exists vehicle_model;

    create table address (
        address_id integer not null auto_increment,
        city varchar(255),
        landmark varchar(255),
        pincode integer,
        state varchar(255),
        street varchar(255),
        user_id bigint,
        primary key (address_id)
    ) ENGINE=InnoDB;

    create table app_user (
        id bigint not null auto_increment,
        account_expired bit not null,
        account_locked bit not null,
        address varchar(150),
        city varchar(50),
        country varchar(100),
        postal_code varchar(15),
        province varchar(100),
        credentials_expired bit not null,
        email varchar(255) not null,
        account_enabled bit,
        first_name varchar(50) not null,
        last_name varchar(50) not null,
        password varchar(255) not null,
        password_hint varchar(255),
        phone_number varchar(255),
        username varchar(50) not null,
        version integer,
        website varchar(255),
        primary key (id)
    ) ENGINE=InnoDB;

    create table company_detail (
        company_id integer not null auto_increment,
        company_name varchar(255),
        primary key (company_id)
    ) ENGINE=InnoDB;

    create table eligibility_detail (
        eligibility_detail_id integer not null auto_increment,
        current_city varchar(255),
        down_payment integer,
        salary integer,
        company_id integer,
        user_id bigint,
        vehicle_model_id integer,
        primary key (eligibility_detail_id)
    ) ENGINE=InnoDB;

    create table loan (
        loan_id integer not null auto_increment,
        date varchar(255),
        documentation_charges float,
        emi_in_rupees float,
        loan_amount integer,
        loan_period_in_months integer,
        processing_fees float,
        eligibility_detail_id integer,
        user_id bigint,
        primary key (loan_id)
    ) ENGINE=InnoDB;

    create table loan_detail (
        loan_detail_id integer not null auto_increment,
        balance_loan_amount integer,
        balance_emi_months integer,
        loan_id integer,
        payment_id integer,
        user_id bigint,
        primary key (loan_detail_id)
    ) ENGINE=InnoDB;

    create table payment (
        payment_id integer not null auto_increment,
        date varchar(255),
        payment_amount integer,
        loan_id integer,
        user_id bigint,
        primary key (payment_id)
    ) ENGINE=InnoDB;

    create table role (
        id bigint not null auto_increment,
        description varchar(64),
        name varchar(20),
        primary key (id)
    ) ENGINE=InnoDB;

    create table user_role (
        user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) ENGINE=InnoDB;

    create table vehicle (
        vehicle_id integer not null auto_increment,
        vehicle_name varchar(255),
        primary key (vehicle_id)
    ) ENGINE=InnoDB;

    create table vehicle_model (
        vehicle_model_id integer not null auto_increment,
        price_in_rupees integer,
        vehicle_model_name varchar(255),
        vehicle_id integer,
        primary key (vehicle_model_id)
    ) ENGINE=InnoDB;

    alter table app_user 
        add constraint UK_1j9d9a06i600gd43uu3km82jw  unique (email);

    alter table app_user 
        add constraint UK_3k4cplvh82srueuttfkwnylq0  unique (username);

    alter table address 
        add constraint FK_7rod8a71yep5vxasb0ms3osbg 
        foreign key (user_id) 
        references app_user (id);

    alter table eligibility_detail 
        add constraint FK_mmkxmdmf6j6q909qyhwlkh9c5 
        foreign key (company_id) 
        references company_detail (company_id);

    alter table eligibility_detail 
        add constraint FK_17844b31cqpyah1sy35c2dr0i 
        foreign key (user_id) 
        references app_user (id);

    alter table eligibility_detail 
        add constraint FK_2qhgrlgnbo7xavgt4vmj6ryga 
        foreign key (vehicle_model_id) 
        references vehicle_model (vehicle_model_id);

    alter table loan 
        add constraint FK_7fqsqytb3q3k9c59covd8k6be 
        foreign key (eligibility_detail_id) 
        references eligibility_detail (eligibility_detail_id);

    alter table loan 
        add constraint FK_snp5j1a5kw8r7f2kv1pxu9hp0 
        foreign key (user_id) 
        references app_user (id);

    alter table loan_detail 
        add constraint FK_jkcdr297pjgiwphshvvcc9o9m 
        foreign key (loan_id) 
        references loan (loan_id);

    alter table loan_detail 
        add constraint FK_nldfgvebqgxl0dsllgbv9nh4m 
        foreign key (payment_id) 
        references payment (payment_id);

    alter table loan_detail 
        add constraint FK_cm0togw4b1iuq87l5w51rj04n 
        foreign key (user_id) 
        references app_user (id);

    alter table loan_detail 
        add constraint FK_nldfgvebqgxl0dsllgbv9nh4m 
        foreign key (payment_id) 
        references loan (loan_id);

    alter table payment 
        add constraint FK_nseeiepn7ybuegosvbmhxa4iu 
        foreign key (loan_id) 
        references loan (loan_id);

    alter table payment 
        add constraint FK_ctvskou1xh26obtbvta4d2o4l 
        foreign key (user_id) 
        references app_user (id);

    alter table user_role 
        add constraint FK_it77eq964jhfqtu54081ebtio 
        foreign key (role_id) 
        references role (id);

    alter table user_role 
        add constraint FK_apcc8lxk2xnug8377fatvbn04 
        foreign key (user_id) 
        references app_user (id);

    alter table vehicle_model 
        add constraint FK_oi0jtje8fhtho7e141w69q58x 
        foreign key (vehicle_id) 
        references vehicle (vehicle_id);

    alter table vehicle_model 
        add constraint FK_blcifx8427v63xg2jtrc9dy4d 
        foreign key (vehicle_model_id) 
        references vehicle (vehicle_id);
