select * from kinder;

# 1. 기사 정보에서 postcode(등록유치원)와 user_address_detail(유치원명)을 가지고와서 해당 포스트코드에 해당하는 유치원이름리스트가져오기
select user_postcode, user_address_detail from user where user_key=2;
select kinder_key, kinder_name 
from kinder where kinder_postcode='04524' and kinder_name like '%햇살유치원%';

# 2. 해당 유치원에 등록된 아이들중 픽업여부가 'Y'인 유치원생들의 key받아오기
select child_key from kindermatch 
				where kinder_key in (select kinder_key 
									from kinder 
                                    where kinder_postcode='04524' and 
											kinder_name like '%햇살유치원%');

# 3. 해당 유치원생들의 정보 가져오기 (받을 인자는 로그인된 유저정보의 postcode와 address_detail)
select * from children 
where child_key in (select child_key 
					from kindermatch 
                    where kinder_key in (select kinder_key 
										from kinder 
                                        where kinder_postcode='04524' and 
												kinder_name like '%햇살유치원%')
					);

