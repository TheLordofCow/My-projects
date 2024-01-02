from src.models import Movie, db


class MovieRepository:
    def get_all_movies(self):
        return Movie.query.all()

    def get_movie_by_id(self, movie_id):
        # TODO get a single movie from the DB using the ID
        return Movie.query.filter_by(movie_id=movie_id).first()

    def create_movie(self, title, director, rating):
        # TODO create a new movie in the DB
        new_movie = Movie(title=title, director=director, rating=rating)
        db.session.add(new_movie)
        db.session.commit()
        return new_movie

    def search_movies(self, title):
        # TODO get all movies matching case insensitive substring (SQL LIKE, use google for how to do with SQLAlchemy)
        return Movie.query.filter_by(title=Movie.title.like(title)).all()


# Singleton to be used in other modules
movie_repository_singleton = MovieRepository()
