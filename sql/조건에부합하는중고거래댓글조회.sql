SELECT a.TITLE, b.BOARD_ID, b.REPLY_ID, b.WRITER_ID, b.CONTENTS, 
left(b.CREATED_DATE, 10) as CREATED_DATE
from USED_GOODS_BOARD as a join USED_GOODS_REPLY as b
on a.BOARD_ID = b.BOARD_ID
where date(a.CREATED_DATE) between '2022-10-01' and '2022-10-31'
order by b.CREATED_DATE, a.TITLE