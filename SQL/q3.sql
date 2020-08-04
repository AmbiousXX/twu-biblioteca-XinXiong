SELECT book.title
  FROM book
  WHERE book.id NOT IN (
  SELECT book.id
  FROM book, checkout_item
  WHERE book.id = checkout_item.book_id
)
 UNION
  SELECT movie.title
  FROM movie
  WHERE movie.id NOT IN (
  SELECT movie.id
  FROM movie, checkout_item
  WHERE movie.id = checkout_item.movie_id
);