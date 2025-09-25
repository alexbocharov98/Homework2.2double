package org.skypro.skyshop.article;
import org.skypro.skyshop.search.Searchable;

    public final class Article implements Searchable {
        private final String articleTitle;
        private final String articleText;

        public Article(String articleTitle, String articleText) {
            this.articleTitle = articleTitle;
            this.articleText = articleText;
        }

        public String getTitle() {
            return articleTitle;
        }

        public String getText() {
            return articleText;
        }

        @Override
        public String getSearchTerm() {
            return this.toString(); // название + текст статьи
        }

        @Override
        public String getContentType() {
            return "ARTICLE";
        }

        @Override
        public String getName() {
            return articleTitle;
        }

        @Override
        public String toString() {
            return articleTitle + "\n" + articleText;
        }
    }

