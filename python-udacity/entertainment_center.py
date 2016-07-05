import fresh_tomatoes
import media

movies = [];
movies.append(media.Movie("Terminator 2",
    "1991",
    "http://t1.gstatic.com/images?q=tbn:ANd9GcS5J6Ay6y1UT7WAI4U7Zm2KDYITrvfOI3vmaCNdGhx_0jmWiI1d",
    "https://www.youtube.com/watch?v=eajuMYNYtuY"))

movies.append(media.Movie("The Matrix",
    "1999",
    "http://ia.media-imdb.com/images/M/MV5BMTkxNDYxOTA4M15BMl5BanBnXkFtZTgwNTk0NzQxMTE@._V1_UX182_CR0,0,182,268_AL_.jpg",
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


fresh_tomatoes.open_movies_page(movies)
# print(media.Movie.VALID_RATINGS)
