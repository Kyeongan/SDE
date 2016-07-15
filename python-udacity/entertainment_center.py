import fresh_tomatoes
import media

movies = [];
movies.append(media.Movie("Terminator 2",
    "1991",
    "http://t1.gstatic.com/images?q=tbn:ANd9GcS5J6Ay6y1UT7WAI4U7Zm2KDYITrvfOI3vmaCNdGhx_0jmWiI1d",
    "https://www.youtube.com/watch?v=eajuMYNYtuY"))

movies.append(media.Movie("The Matrix",
    "1999",
    "http://t0.gstatic.com/images?q=tbn:ANd9GcQq3pIz-aKgkmYX1dJ-EL-AlHSPcOO7wdqRIJ5gJy9qNinXpmle",
    "https://www.youtube.com/watch?v=oZ1-M8O70zk"))

movies.append(media.Movie("Inception",
    "2010",
    "http://t2.gstatic.com/images?q=tbn:ANd9GcRo9vfJCM6dzPkZHIHBVCtlJnAnew9Ai26kEdrli0-tfmatmciD",
    "https://www.youtube.com/watch?v=66TuSJo4dZM"))

movies.append(media.Movie("The Wolf of Wall Street",
    "2013",
    "http://t1.gstatic.com/images?q=tbn:ANd9GcTm52BWbxXmwOpfz5rmx0BNBj79kSQoGpYPq4TVt07Jel5En6aC",
    "https://www.youtube.com/watch?v=iszwuX1AK6A"))

movies.append(media.Movie("Shutter Island",
    "2010",
    "http://www.gstatic.com/tv/thumb/movieposters/3531967/p3531967_p_v8_ah.jpg",
    "https://www.youtube.com/watch?v=5iaYLCiq5RM"))

movies.append(media.Movie("Terminator 2",
    "1991",
    "http://t1.gstatic.com/images?q=tbn:ANd9GcS5J6Ay6y1UT7WAI4U7Zm2KDYITrvfOI3vmaCNdGhx_0jmWiI1d",
    "https://www.youtube.com/watch?v=eajuMYNYtuY"))

movies.append(media.Movie("The Martian",
    "2015",
    "http://t2.gstatic.com/images?q=tbn:ANd9GcTkKPZ7EIOafEsemyn6zTIDeGYthKC_Okgxi1eX6diuOT3xKWXQ",
    "https://www.youtube.com/watch?v=ej3ioOneTy8"))


movies_sorted = sorted(movies, key=lambda movies: movies.year, reverse=True)

fresh_tomatoes.open_movies_page(movies_sorted)
# print(media.Movie.VALID_RATINGS)
