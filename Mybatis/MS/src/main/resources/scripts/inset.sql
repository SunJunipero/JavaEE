INSERT INTO public.users(user_first_name, user_last_name, user_name, password, email, is_active)
 VALUES ('Alex', 'Turner', 'Al', 'qwe12', 'al@mail.com', true );
 INSERT INTO public.users(user_first_name, user_last_name, user_name, password, email, is_active)
 VALUES ('Jordan', 'Peterson', 'JP', '4321', 'jb@mail.com', true );

 INSERT INTO public.user_roles (user_id, authority)
  VALUES ('1', 'ROLE_ADMIN');
  INSERT INTO public.user_roles (user_id, authority)
  VALUES ('1', 'ROLE_USER');
  INSERT INTO public.user_roles (user_id, authority)
  VALUES ('2', 'ROLE_USER');
