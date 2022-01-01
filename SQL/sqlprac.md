```sql
SELECT distinct publisher from book;
SELECT * FROM book where price >=10000 and price <=20000;
SELECT * FROM book where price between 10000 and 20000;

SELECT * FROM book where publisher = '굿스포츠' or publisher ='대한미디어';
SELECT * FROM book WHERE publisher in ('굿스포츠' , '대한미디어');

SELECT * FROM book WHERE publisher <> '굿스포츠' and publisher <>'대한미디어';
SELECT * FROM book WHERE publisher not in( '굿스포츠','대한미디어');

select bookname, publisher from book where bookname like '%축구%';
 /* 축구에 관한 도서(책 이름에 축구를 포함) 중 가격이 20000원 이상인 도서를 검색 */
SELECT * FROM book WHERE bookname like '%축구%' and price >=20000;
/* 출판사가 '굿스포츠' 혹은 '대한미디어'인 도서를 검색 */
SELECT * FROM book WHERE publisher ='굿스포츠' OR publisher ='대한미디어';
/* 도서를 가격순으로 검색하고, 가격이 같으면 이름으로 검색 */
SELECT * FROM book order by price, bookname;
/* 도서를 가격의 내림차순으로 검색하고, 가격이 같으면 이름을 올림차순으로 검색 */
SELECT * FROM book order by price desc, bookname asc;
/* 고객이 주문한 도서의 총 판매액을 조회 */
SELECT SUM(saleprice) AS '총 판매액' FROM orders;
/* 고객 아이디가 2인 고객이 주문한 도서의 총 판매금액을 조회 */
SELECT custid, SUM(saleprice) AS total FROM orders WHERE custid=2;
/* 고객이 주문한 도서의 총 판매액, 평균값, 최저값, 최고가를 조회 */
SELECT SUM(saleprice), AVG(saleprice), MIN(saleprice), MAX(saleprice) FROM orders;
/* 도서 판매 건수를 조회 */
SELECT COUNT(*) FROM orders;
/*고객별 도서 판매 건수를 조회 */
SELECT custid, count(custid), sum(saleprice) FROM orders GROUP BY custid;
/* 가격이 8000원 이상인 도서를 구매한 고객에 대하여 고객별 주문 도서의 총 수량을 조회 (단, 두 권 이상 구매한 고객) */
SELECT custid, COUNT(*) AS total FROM orders WHERE saleprice >= 8000 GROUP BY custid HAVING count(*) >=2;

/*테이블 조인(결합)*/
/* 고객별로 주문한 모든 도서의 총 판매액을 구하고, 고객 이름으로 정렬 */
SELECT customer.name, SUM(saleprice) FROM orders,customer where orders.custid = customer.custid GROUP BY orders.custid order by name;
/* 고객의 이름과 고객이 주문한 도서의 이름을 조회 */
SELECT c.name,b.bookname  FROM book b,customer c,orders o WHERE b.bookid=o.bookid and c.custid = o.custid;
/* 가격이 20000원인 도서를 주문한 고객의 이름과 도서의 이름을 조회 */
SELECT c.name, b.bookname,o.saleprice FROM book b,customer c,orders o WHERE b.bookid=o.bookid and c.custid = o.custid and o.saleprice = 20000;
/* 도서를 구매하지 않은 고객을 포함해서 고객 이름과 고객이 주문한 도서의 판매가격을 조회 */
SELECT customer.name, saleprice FROM customer LEFT OUTER JOIN orders on customer.custid = orders.custid;
/* 가장 비싼 도서의 이름을 조회 */
SELECT bookname FROM book WHERE price =(SELECT max(price) FROM book);
/* 도서를 구매한 적이 있는 고객의 이름을 검색 */
-- 1. 도서를 구매한 적이 있는 고객 (중복제거)
SELECT DISTINCT custid FROM orders;
-- 2. custid가 1번 결괏값에 있는 것만 출력
SELECT * FROM customer WHERE custid in (SELECT DISTINCT custid FROM orders);
-- 3. 이름만 출력
SELECT name FROM customer WHERE custid in (SELECT DISTINCT custid FROM orders);

/* 대한미디어에서 출판한 도서를 구매한 고객의 이름을 조회 */
-- 방법1. 서브쿼리사용
-- 1. 대한 미디어에서 출판한 도서
SELECT * FROM book WHERE publisher = '대한미디어';
-- 2.  이 도서를 구매한 고객
SELECT * FROM orders WHERE bookid in (SELECT bookid FROM book WHERE publisher = '대한미디어');
-- 3. 고객의 이름을 조회
SELECT name FROM customer WHERE custid in (SELECT custid FROM orders WHERE bookid in (SELECT bookid FROM book WHERE publisher = '대한미디어'));

-- 방법2. 조인을 걸고, 검색 조건을 추가
SELECT name FROM book b, orders o, customer c WHERE b.bookid = o.bookid and o.custid = c.custid and publisher='대한미디어' ;

-- 상관 부속 질의(correlated sub query)
/* 출판사별로 출판사의 평균 도서 가격 보다 비싼 도서를 조회 */
SELECT bookname FROM book b WHERE b.price > (SELECT AVG(price) FROM book where publisher = b.publisher);

/* 대한민국에서 거주하는 고객의 이름과 도서를 주문한 고객의 이름 조회 */
SELECT * FROM customer WHERE address like '대한민국%'
UNION
SELECT * FROM customer WHERE custid in (SELECT custid from orders);
-- 차집합
/* 대한민국에서 거주하는 고객의 이름에서 도서를 주문한 고객의 이름을 빼고 조회 */
SELECT * FROM customer WHERE address like '대한민국%' and custid not in (SELECT custid FROM customer WHERE custid in (SELECT custid FROM orders));

-- 교집합
SELECT * FROM customer WHERE address like '대한민국%'and custid in (SELECT custid FROM customer WHERE custid in (SELECT custid FROM orders));
 /* 주문이 있는 고객의 이름과 주소를 조회 */
 SELECT name, address FROM customer c WHERE EXISTS (SELECT custid FROM orders WHERE custid = c.custid);
 SELECT name, address FROM customer WHERE custid in (SELECT custid FROM orders);

-- 마당서점 도서의 총 개수
SELECT count(*) FROM book;
-- 마당서점에 도서를 출고하는 출판사의 총 개수
SELECT count( distinct publisher) FROM book;
-- 모든 고객의 이름, 주소
SELECT name, address FROM customer;
-- 2014년 7월 4일~7월 7일 사이에 주문 받은 도서의 주문번호
SELECT * FROM orders WHERE orderdate between 20140704 AND 20140707;
SELECT * FROM orders WHERE orderdate >=20140704 AND orderdate <= 20140707;
-- 2014년 7월 4일~7월 7일 사이에 주문 받은 도서를 제외한 도서의 주문번호
SELECT * FROM orders WHERE orderdate not in (SELECT orderdate FROM orders WHERE orderdate between 20140704 AND 20140707);
SELECT * FROM orders WHERE orderdate not between 20140704 AND 20140707;
SELECT * FROM orders WHERE orderdate < 20140704 or orderdate > 20140707;
-- 성이 '김'씨인 고객의 이름과 주소
SELECT name, address FROM customer WHERE name like '김%';
-- 성이 '김'씨이고 이름이 '아'로 끝나는 고객의 이름과 주소
SELECT name, address FROM customer WHERE name like '김%아';
-- 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
SELECT name FROM book,orders,customer WHERE book.bookid = orders.bookid and orders.custid = customer.custid and book.publisher in
(SELECT publisher FROM orders o, customer c,book b WHERE o.custid = c.custid and b.bookid = o.bookid and name='박지성') and name <> '박지성';
-- 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
SELECT * FROM customer cs WHERE
(SELECT  count(distinct publisher) FROM book b, orders o, customer c WHERE o.custid = c.custid and b.bookid = o.bookid and cs.name = c.name)>= 2;
-- 전체 고객의 30% 이상이 구매한 도서 == 도서별로 구매한 고객 수가 30%(1.5) 이상인 도서
-- select * from book where (해당 도서의 판매 개수) >= (전체 고객의 30%);
-- 방법1
SELECT bookname FROM book, orders WHERE book.bookid = orders.bookid
GROUP BY bookname HAVING count(book.bookid)>=(SELECT count(*) * 0.3 FROM customer);
-- 방법2 SELECT bookname FROM book WHERE a > b형태
SELECT bookname FROM book b1
WHERE (SELECT count(b2.bookid) FROM book b2,orders WHERE b2.bookid = b1.bookid and b2.bookid = orders.bookid)
>= (SELECT count(*) FROM customer) * 0.3;
-- 새로운 도서 ('스포츠 세계', '대한미디어', 10000원)이 마당서점에 입고되었다.
INSERT INTO book VALUES (11, '스포츠 세계', '대한미디어',10000);
select * from book;
-- '삼성당'에서 출판한 도서를 삭제해야 한다.
DELETE FROM book WHERE publisher = '삼성당';
-- '이상미디어'에서 출판한 도서를 삭제해야 한다. 삭제가 안 될 경우 원인을 생각해보자.
DELETE FROM book WHERE publisher='이상미디어';
-- Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`madang`.`orders`, CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`bookid`) REFERENCES `book` (`bookid`))
-- = 현재 삭제하려고 하는 테이블 또는 행이 다른 곳에서 참조하고 있기 때문에 발생하는 문제
-- 출판사 '대한미디어'가 '대한출판사'로 이름을 바꾸었다.
UPDATE book SET publisher = '대한출판사' WHERE publisher = '대한미디어';
```
