# WARNING: NOT TESTED
from flask_sqlalchemy import SQLAlchemy

db = SQLAlchemy()


class Movie(db.Model):
    movie_id = db.Column(db.Integer, AUTO_INCREMENT=True, primary_key=True)
    title = db.Column(db.String(255), nullable=False)
    director = db.Column(db.String(255), nullable=False)
    rating = db.Column(db.Integer, nullable=False)
