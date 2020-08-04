INSERT INTO book VALUES (11, "The Pragmatic Programmer");

INSERT INTO member VALUES (43, "Xin Xiong");

INSERT INTO checkout_item (member_id, book_id, movie_id) VALUES (43, 11, NULL);

SELECT member.name
  FROM member
  WHERE member.id IN (
  SELECT checkout_item.member_id
  FROM checkout_item, book
  WHERE checkout_item.book_id = book.id AND book.title = 'The Pragmatic Programmer'
);