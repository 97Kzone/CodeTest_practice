SELECT BOOK_ID, AUTHOR_NAME, TO_CHAR(PUBLISHED_DATE, 'yyyy-MM-dd')
  FROM BOOK B, AUTHOR A
 WHERE B.AUTHOR_ID = A.AUTHOR_ID
   AND B.CATEGORY = '경제'
ORDER BY B.PUBLISHED_DATE;