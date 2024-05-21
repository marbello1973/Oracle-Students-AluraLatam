package com.literalura.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("count") Long contador,
        @JsonAlias("next") String pag_siguiente,
        @JsonAlias("previous") String pag_anterior,
        @JsonAlias("results") List<LibroResults> libro

){}


/*
"count": 2265,
  "next": "https://gutendex.com/books/?page=2&search=charles",
  "previous": null,
  "results": [
    {
      "id": 98,
      "title": "A Tale of Two Cities",
      "authors": [
        {
          "name": "Dickens, Charles",
          "birth_year": 1812,
          "death_year": 1870
        }
      ],
      "translators": [],
      "subjects": [
        "British -- France -- Paris -- Fiction",
        "Executions and executioners -- Fiction",
        "France -- History -- Revolution, 1789-1799 -- Fiction",
        "French -- England -- London -- Fiction",
        "Historical fiction",
        "London (England) -- History -- 18th century -- Fiction",
        "Lookalikes -- Fiction",
        "Paris (France) -- History -- 1789-1799 -- Fiction",
        "War stories"
      ],
      "bookshelves": [
        "Historical Fiction"
      ],
      "languages": [
        "en"
      ],
      "copyright": false,
      "media_type": "Text",
      "formats": {
        "text/html": "https://www.gutenberg.org/ebooks/98.html.images",
        "text/html; charset=utf-8": "https://www.gutenberg.org/files/98/98-h/98-h.htm",
        "application/epub+zip": "https://www.gutenberg.org/ebooks/98.epub3.images",
        "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/98.kf8.images",
        "text/plain; charset=utf-8": "https://www.gutenberg.org/files/98/98-0.txt",
        "application/rdf+xml": "https://www.gutenberg.org/ebooks/98.rdf",
        "image/jpeg": "https://www.gutenberg.org/cache/epub/98/pg98.cover.medium.jpg",
        "application/octet-stream": "https://www.gutenberg.org/cache/epub/98/pg98-h.zip",
        "text/plain; charset=us-ascii": "https://www.gutenberg.org/ebooks/98.txt.utf-8"
      },
      "download_count": 22044
    },
*/